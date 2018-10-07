package com.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.base.oauthLogin.api.OauthQQ;
import com.base.oauthLogin.api.OauthSina;
import com.base.oauthLogin.api.OauthWeixin;
import com.base.oauthLogin.model.QQUserInfo;
import com.base.oauthLogin.model.WEIXINUserInfo;
import com.base.oauthLogin.model.WeiboUser;
import com.base.service.BFileService;
import com.base.spring.SpringContextUtil;
import com.base.util.JSONUtils;
import com.item.dao.model.User;
import com.item.service.UserService;

/**
 * 第三方登陆实现
 * @author sun
 *
 */
public class OauthLoginRunnable implements Runnable{
	private static final Logger LOGGER = LoggerFactory.getLogger(OauthLoginRunnable.class);
	
	private BFileService fileService;

	private Integer userId;
	private UserService userService;
	private Integer type;
	private String openid;
	private String accessToken;
	private Integer deviceType;
	
	public OauthLoginRunnable(Integer userId, Integer type,Integer deviceType,String openid,
			String accessToken,UserService userService){
		this.userId = userId;
		this.userService = userService;
		this.type = type;
		this.openid = openid;
		this.accessToken = accessToken;
		this.deviceType = deviceType;
	}
	
	@Override
	public void run() {
		User user = new User();
		user.setId(userId);
		switch (type) {
			case 1:
				//qq
				qqLogin(user);
				break;
			case 2:
				//sina
				sinaLogin(user);
				break;
			case 3:
				//wx
				wxLogin(user);
				break;
			default:
				break;
		}
		//更新
		userService.updateByPrimaryKeySelective(user);
	}
	
	//qq第三方
	public void qqLogin(User user){
		String oauthQQ = OauthQQ.me().getUserInfo(accessToken, openid);
		LOGGER.debug("平台:{},qqJson:{}",deviceType,oauthQQ);
		QQUserInfo qq = JSONUtils.deserialize(oauthQQ, QQUserInfo.class);
		if (qq != null){
			LOGGER.debug("qq:{}",JSONUtils.serialize(qq));
			user.setNickName(getNickName(qq.getNickname(),user.getId()));
			user.setHeadImg(uploadHeadImg(qq.getFigureurl()));
		}
	}
	
	public void sinaLogin(User user){
		String oauthSina = OauthSina.me().getUserInfo(accessToken, openid);
		LOGGER.debug("平台:{},sinaJson:{}",deviceType,oauthSina);
		WeiboUser sina = JSONUtils.deserialize(oauthSina, WeiboUser.class);
		if (sina != null){
			LOGGER.debug("sina:{}",JSONUtils.serialize(sina));
			user.setNickName(getNickName(sina.getScreenName(),user.getId()));
			user.setHeadImg(uploadHeadImg(sina.getAvatarLarge()));
			user.setSex("男".equals(sina.getGender())?1:0);
		}
	}
	
	public void wxLogin(User user){
		String oauthWx = OauthWeixin.me().getUserInfo(accessToken, openid);
		LOGGER.debug("平台:{},wxJson:{}",deviceType,oauthWx);
		WEIXINUserInfo wx = JSONUtils.deserialize(oauthWx, WEIXINUserInfo.class);
		if (wx != null){
			LOGGER.debug("wx:{}",JSONUtils.serialize(wx));
			user.setNickName(getNickName(wx.getNickName(),user.getId()));
			user.setHeadImg(uploadHeadImg(wx.getHeadimgurl()));
		}
	}

	/**
	 * 第三方登录获取头像
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	private String uploadHeadImg(String url) {
		if (fileService == null){
			fileService = SpringContextUtil.getBean(BFileService.class);
		}
		return fileService.uploadHeadImg(url);
	}
	
	private String getNickName(String url,Integer id){
		return url+id;
	}
}
