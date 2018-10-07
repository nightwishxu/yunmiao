package com.api.wxaction;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.api.MEnumError;
import com.api.util.ApiUserUtils;
import com.api.util.IpUtil;
import com.api.view.account.SmsCode;
import com.base.Const;
import com.base.api.ApiBaseController;
import com.base.api.ApiException;
import com.base.api.MobileInfo;
import com.base.api.annotation.ApiMethod;
import com.base.api.sms.SmsError;
import com.base.cache.bean.MobileCodeRedisCache;
import com.base.dao.model.Ret;
import com.base.service.BFileService;
import com.base.util.StringUtil;
import com.item.dao.model.User;
import com.item.dao.model.UserExample;
import com.item.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.api.util.UserRongCloudUtil;

@RestController
@RequestMapping(value = "/api/account", produces = { "application/json;charset=UTF-8" })
@Api(tags = "账号登陆/注册")
public class ApiLoginController extends ApiBaseController {

	@Autowired
	private BaseService baseService;
	@Autowired
	private BFileService fileService;
	@Autowired
	private UserService userService;
	@Autowired
	private MobileVerifyService verifyService;
	@Autowired
	private UserOauthService oauthService;
	@Autowired
	private SmsSendLogService smsSendLogService;

	@Autowired
	private RestTemplate restTemplate;


	private enum MobileMsgEnum {
		REGIST(1), FORGET(2), LOGIN(3);
		private int code;

		private MobileMsgEnum(int code) {
			this.code = code;
		}

		public int getCode() {
			return this.code;
		}
		
		public String getPhone(String phone){
			return phone+Const.SEP+this.name();
		}
	}

	/**
	 * 获取验证码
	 * 
	 * @param phone
	 *            手机号
	 * @param type
	 *            1:注册,绑定手机 2:忘记密码
	 */
	@ApiOperation(value = "获取验证码", notes = "不需要登录")
	@RequestMapping(value = "/getMobileMsg", method = RequestMethod.POST)
	@ApiMethod
	public SmsCode getMobileMsg(
			@ApiParam(value = "手机号", required = true) String phone,
			@ApiParam(value = "1:注册,绑定手机 2:忘记密码 3:验证码登陆", required = true) Integer type,
			@ApiParam(value = "设备唯一识别码", required = true) String deviceid)
			throws Exception {
		if (StringUtils.isBlank(deviceid)) {
			throw new ApiException("deviceid");
		}
		if (StringUtils.isBlank(phone)) {
			throw new ApiException("phone");
		}
		if (type == null) {
			throw new ApiException("type");
		}

		// 查询
		UserExample example = new UserExample();
		example.createCriteria().andAccountEqualTo(phone);

		String key = phone;
		
		if (type == MobileMsgEnum.REGIST.getCode()) {// 注册
			int count = userService.countByExample(example);
			if (count > 0) {
				throw new ApiException(MEnumError.PHONE_EXISTS_ERROR);
			}
			key = MobileMsgEnum.REGIST.getPhone(phone);
		} else if (type == MobileMsgEnum.FORGET.getCode()) {
			int count = userService.countByExample(example);
			if (count == 0) {
				throw new ApiException(MEnumError.PHONE_NOTEXISTS_ERROR);
			}
			key = MobileMsgEnum.FORGET.getPhone(phone);
		}else if (type == MobileMsgEnum.LOGIN.getCode()) {
			key = MobileMsgEnum.LOGIN.getPhone(phone);
		}else {
			throw new ApiException(-1,"参数错误");
		}

		// 发送短信
		String mobileCode = StringUtil.getRandomNum(6);
		String content = new String("您的验证码是：" + mobileCode + "。请不要把验证码泄露给其他人。请于5分钟内完成验证！");

		String result = smsSendLogService.sendIdentifySms(phone, deviceid,
				null, content,type);
		if ("2".equals(result)) {
			// 发送成功
			MobileCodeRedisCache.setExpire(key, mobileCode);
		} else {
			// 发送失败,可以细化错误原因
			String error = SmsError.getSmsError(result);
			if (StringUtils.isNotBlank(error)) {
				logger.debug(error);
				throw new ApiException(MEnumError.SMS_ERROR.getErrorCode(),
						error);
			}
			throw new ApiException(MEnumError.SMS_ERROR);
		}

		SmsCode ret = new SmsCode();
		ret.setCode(mobileCode + "");
		return ret;
	}

	/**
	 * 验证验证码
	 * 
	 * @param phone
	 *            手机号
	 * @param code
	 *            验证码
	 */
	@ApiOperation(value = "验证验证码", notes = "不需要登录")
	@RequestMapping(value = "/checkCode", method = RequestMethod.POST)
	@ApiMethod
	public Ret checkCode(
			@ApiParam(value = "手机号", required = true) String phone,
			@ApiParam(value = "验证码", required = true) String code,
			@ApiParam(value = "1:注册,绑定手机 2:忘记密码 3:验证码登陆", required = true) Integer type)
			throws Exception {
		if (StringUtils.isBlank(phone)) {
			throw new ApiException("phone");
		}
		if (StringUtils.isBlank(code)) {
			throw new ApiException("code");
		}
		if (type == null) {
			throw new ApiException("type");
		}
		String key = phone;
		
		if (type == MobileMsgEnum.REGIST.getCode()) {// 注册
			key = MobileMsgEnum.REGIST.getPhone(phone);
		} else if (type == MobileMsgEnum.FORGET.getCode()) {
			key = MobileMsgEnum.FORGET.getPhone(phone);
		}else if (type == MobileMsgEnum.LOGIN.getCode()) {
			key = MobileMsgEnum.LOGIN.getPhone(phone);
		}else {
			throw new ApiException(-1,"参数错误");
		}
		System.out.println(MobileCodeRedisCache.get(key));
		// 验证码验证
		String value = MobileCodeRedisCache.get(key);
		
		if (!code.equals(value)) {
			throw new ApiException(MEnumError.MOBILE_CODE_ERROR);
		}
		Ret ret = new Ret();
		ret.setCode(0);

		return ret;
	}

	/** 验证昵称
	 *
	 * @param nickName
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "验证昵称", notes = "不需要登录")
	@RequestMapping(value = "/checkNick", method = RequestMethod.POST)
	@ApiMethod
	public Ret checkNick(
			@ApiParam(value = "昵称", required = true) String nickName)
			throws Exception {
		if (StringUtils.isBlank(nickName)) {
			throw new ApiException("nickName");
		}
		UserExample example = new UserExample();
		example.createCriteria().andNickNameEqualTo(nickName);
		int i = userService.countByExample(example);
		if (i > 0) {
			throw new ApiException(MEnumError.NICK_EXISTS_ERROR);
		}
		Ret ret = new Ret();
		ret.setCode(0);

		return ret;
	}

	/**
	 * 注册
	 * 
	 * @param phone
	 *            手机号
	 * @param code
	 *            验证码
	 * @param password
	 *            密码(需要加密)
	 * @param deviceType
	 *            //设备类型 1:android 2:ios
	 * @param cid
	 *            //推送cid
	 */
	@ApiOperation(value = "注册", notes = "不需要登录")
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	@ApiMethod
	public MobileInfo regist(
			@ApiParam(value = "手机号", required = true) String phone,
			@ApiParam(value = "验证码", required = true) String code,
			@ApiParam(value = "密码(需要MD5加密)", required = true) String password,
			@ApiParam(value = "设备类型 1:android 2:ios", required = true) Integer deviceType,
			@ApiParam(value = "设备唯一识别码", required = false) String deviceid,
			@ApiParam(value = "推送cid", required = false) String cid)
			throws Exception {

		// 参数校验
		if (StringUtils.isBlank(phone)) {
			throw new ApiException("phone");
		}
		if (StringUtils.isBlank(code)) {
			throw new ApiException("code");
		}
		if (StringUtils.isBlank(password)) {
			throw new ApiException("password");
		}
		if (StringUtils.isBlank(deviceid)) {
			throw new ApiException("deviceid");
		}
		if (deviceType == null) {
			throw new ApiException("deviceType");
		}

		// 验证码验证
		String value = MobileCodeRedisCache.get(MobileMsgEnum.REGIST.getPhone(phone));
		
		if (!code.equals(value)) {
			throw new ApiException(MEnumError.MOBILE_CODE_ERROR);
		} else {
			MobileCodeRedisCache.delete(MobileMsgEnum.REGIST.getPhone(phone));
		}

		UserExample example = new UserExample();
		example.createCriteria().andAccountEqualTo(phone);
		int i = userService.countByExample(example);
		if (i > 0) {
			throw new ApiException(MEnumError.PHONE_EXISTS_ERROR);
		}



		User record = regist(phone, password, deviceType, deviceid, cid);

		MobileInfo mobileInfo = new MobileInfo();
		mobileInfo.setUserid(record.getId());
		mobileInfo.setDeviceid(deviceid);
		String verify = verifyService.updateMobileVerify(mobileInfo,
				deviceType, cid);
		mobileInfo.setDeviceType(deviceType);
		mobileInfo.setToken(verify);

		//融云用户注册
//		TokenResult imToken = UserRongCloudUtil.getToken(record.getId().toString(),"","");
//		record.setImToken(imToken.getToken());
//		userService.updateByPrimaryKeySelective(record);

		return mobileInfo;
	}

	private User regist(String phone, String password, Integer deviceType,
			String deviceid, String cid) throws Exception {
		// 添加数据
		Date date = new Date();
		User record = new User();
		record.setAccount(phone);
		record.setPhone(phone);
		record.setCreateTime(date);
		record.setStatus(1);
		record.setPassword(password);
		record.setNickName("匿名用户");
//		record.setBalance(BigDecimal.ZERO);
		record.setSex(1);
//		record.setCredit(0);
//		record.setIsBind(0);
//		record.setLoginTime(date);
		record.setCreateTime(date);

		// 保存
		int cnt = userService.insertSelective(record);
		if (cnt == 0) {
			throw new ApiException(MEnumError.CREATE_ACCOUNT_ERROR);
		}

		return record;
	}

	/**
	 * @api 密码登录
	 * @param phone
	 *            手机号
	 * @param password
	 *            密码(需要加密)
	 * @param deviceType
	 *            设备类型 1:android 2:ios
	 * @param cid
	 *            //推送cid
	 */
	@ApiOperation(value = "密码登录")
	@RequestMapping(value = "/loginByPwd", method = RequestMethod.POST)
	@ApiMethod
	public MobileInfo loginByPwd(
			@ApiParam(value = "手机号", required = true) String phone,
			@ApiParam(value = "密码(需要MD5加密)", required = true) String password,
			@ApiParam(value = "设备类型 1:android 2:ios", required = true) Integer deviceType,
			@ApiParam(value = "设备唯一识别码", required = false) String deviceid,
			@ApiParam(value = "推送cid", required = false) String cid)
			throws Exception {
		// 参数校验
		if (StringUtils.isBlank(phone)) {
			throw new ApiException("phone");
		}
		if (StringUtils.isBlank(password)) {
			throw new ApiException("password");
		}
		if (deviceType == null) {
			throw new ApiException("deviceType");
		}
		if (StringUtils.isBlank(deviceid)) {
			throw new ApiException("deviceid");
		}
		// 校验登录
		UserExample example = new UserExample();
		example.createCriteria().andAccountEqualTo(phone);
		List<User> list = userService.selectByExample(example);
		if (list.size() == 0) {
			throw new ApiException(MEnumError.LOGIN_FAILURE_ERROR);
		}
		User user = list.get(0);
		if (!password.equals(user.getPassword())) {
			throw new ApiException(MEnumError.LOGIN_FAILURE_ERROR);
		}
		// 禁用
		if (user.getStatus() == 0) {
			throw new ApiException(MEnumError.ACCOUNT_STOP_ERROR);
		}
		MobileInfo mobileInfo = new MobileInfo();
		mobileInfo.setUserid(user.getId());
		mobileInfo.setDeviceid(deviceid);
		mobileInfo.setDeviceType(deviceType);
		String verify = verifyService.updateMobileVerify(mobileInfo,
				deviceType, cid);
		mobileInfo.setToken(verify);
		return mobileInfo;
	}

	/**
	 * 忘记密码
	 * 
	 * @param phone
	 *            手机号
	 * @param code
	 *            验证码
	 * @param password
	 *            密码(需要加密)
	 * @param deviceType
	 *            //设备类型 1:android 2:ios
	 * @param cid
	 *            //推送cid
	 */
	@ApiOperation(value = "忘记密码")
	@RequestMapping(value = "/forgetPwd", method = RequestMethod.POST)
	@ApiMethod
	public MobileInfo forgetPwd(
			@ApiParam(value = "手机号", required = true) String phone,
			@ApiParam(value = "验证码", required = true) String code,
			@ApiParam(value = "密码(需要加密)", required = true) String password,
			@ApiParam(value = "设备类型 1:android 2:ios", required = true) Integer deviceType,
			@ApiParam(value = "设备唯一识别码", required = false) String deviceid,
			@ApiParam(value = "推送cid", required = false) String cid)
			throws Exception {
		// 参数校验
		if (StringUtils.isBlank(phone)) {
			throw new ApiException("phone");
		}
		if (StringUtils.isBlank(code)) {
			throw new ApiException("code");
		}
		if (deviceType == null) {
			throw new ApiException("deviceType");
		}
		if (StringUtils.isBlank(deviceid)) {
			throw new ApiException("deviceid");
		}
		// 验证码验证
		String value = MobileCodeRedisCache.get(MobileMsgEnum.FORGET.getPhone(phone));
		if (!code.equals(value)) {
			throw new ApiException(MEnumError.MOBILE_CODE_ERROR);
		} else {
			MobileCodeRedisCache.delete(MobileMsgEnum.FORGET.getPhone(phone));
		}

		// 修改数据
		UserExample uexample = new UserExample();
		uexample.createCriteria().andAccountEqualTo(phone);
		List<User> list = userService.selectByExample(uexample);

		if (list.size() == 0) {
			throw new ApiException(MEnumError.PHONE_NOTEXISTS_ERROR);
		}

		User record = list.get(0);
		record.setPassword(password);
		int cnt = userService.updateByPrimaryKeySelective(record);
		if (cnt == 0) {
			throw new ApiException(MEnumError.UPDATE_ACCOUNT_ERROR);
		}
		

		MobileInfo mobileInfo = new MobileInfo();
		mobileInfo.setUserid(record.getId());
		mobileInfo.setDeviceType(deviceType);
		mobileInfo.setDeviceid(deviceid);
		//删除其他登陆设备
		verifyService.deleteOther(mobileInfo);
		String verify = verifyService.updateMobileVerify(mobileInfo,
				deviceType, cid);
		mobileInfo.setToken(verify);
		return mobileInfo;
	}

	/**
	 * 修改密码
	 * 
	 * @param oldPwd
	 *            旧密码(需要加密)
	 * @param newPwd
	 *            新密码(需要加密)
	 */

	/**
	 * 注销
	 */
	@ApiOperation(value = "注销*", notes = "")
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ApiMethod(isLogin = true)
	public Ret logout(MobileInfo mobileInfo) throws Exception {
		verifyService.logout(mobileInfo);
		return new Ret();
	}


	/**
	 * 微信登陆
	 * @param code
	 * @param nickName
	 * @param sex
	 * @param headImg
	 * @param request
	 * @return
	 */
    @ApiOperation(value = "微信登陆")
    @RequestMapping(value = "/loginByWeixin", method = RequestMethod.POST)
    @ApiMethod
	public Object loginByWeixin(@ApiParam(value = "code", required = true)String code,
								@ApiParam(value = "昵称", required = true)String nickName,
								@ApiParam(value = "性别", required = false)Integer sex,
								@ApiParam(value = "头像", required = true)String headImg,HttpServletRequest request) {


		if (code == null ) {
			throw new ApiException("缺少必要参数，请重试");
		}

		String requestUrl = ApiUserUtils.getWebAccess(code);//通过自定义工具类组合出小程序需要的登录凭证 code
		logger.info("》》》组合token为：" + requestUrl);
		String res = restTemplate.getForObject(requestUrl, String.class);
		JSONObject sessionData = JSON.parseObject(res);

		String sessionKey = sessionData.getString("openid");
		String openId = sessionData.getString("session_key");
		if (null == sessionData || StringUtils.isBlank(openId) || StringUtils.isBlank(sessionKey)) {
			throw new ApiException("登录失败");
		}
		sex=sex==null?2:sex;
		User user = userService.queryByOpenId(openId);
		Date date=new Date();
		if (user == null) {
			user = new User();
			user.setNickName(nickName);  // 其实没有用，因为用户没有真正注册
			user.setPassword(openId);                  // 其实没有用，因为用户没有真正注册
			user.setXcxId(openId);
			user.setHeadImg(headImg);
			user.setSex(sex);
			user.setUserLevel(0);
			user.setStatus(1);
			user.setLastLoginTime(date);
			user.setLastLoginIp(IpUtil.client(request));
			user.setCreateTime(date);
			userService.insert(user);
		} else {
			user.setLastLoginTime(date);
			user.setLastLoginIp(IpUtil.client(request));
		}

		MobileInfo mobileInfo = new MobileInfo();
		mobileInfo.setUserid(user.getId());
		mobileInfo.setDeviceid(openId);
		mobileInfo.setDeviceType(3);
		String verify = verifyService.updateMobileVerify(mobileInfo,
				3, null);
		mobileInfo.setToken(verify);

		return mobileInfo;
	}
}
