package com.paidang.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.base.ConstantsCode;
import com.base.api.ApiException;
import com.base.api.MobileInfo;
import com.base.dao.model.Ret;
import com.base.dialect.PaginationSupport;
import com.base.http.HttpUtil;
import com.base.util.JSONUtils;
import com.item.dao.model.Admin;
import com.item.dao.model.AdminExample;
import com.item.dao.model.User;
import com.item.service.AdminService;
import com.item.service.MobileVerifyService;
import com.item.service.UserNotifyService;
import com.item.service.UserService;
import com.paidang.dao.model.*;
import com.paidang.daoEx.model.UserGoodsEx;
import com.paidang.service.*;
import com.util.MExpressAddress;
import com.util.MPawnMsg;
import com.util.PaidangMessage;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.base.web.annotation.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import com.base.action.CoreController;

/**
@author sun
*/
@RequestMapping("userGoods")
@Controller
@LoginFilter
public class UserGoodsController extends CoreController{

    @Autowired
	private UserGoodsService userGoodsService;
	@Autowired
	private PawnLogService pawnLogService;
	@Autowired
	private UserNotifyService userNotifyService;
	@Autowired
	private UserService userService;
	@Autowired
	private MobileVerifyService mobileVerifyService;
	@Autowired
	private ExpressService expressService;
	@Autowired
	private UserPawnService userPawnService;
	@Autowired
	private ExperterInfoService experterInfoService;
	@Autowired
	private AdminService adminService;


	@RequestMapping("/list")
	@ResponseBody

    public String list(Integer page, Integer rows, String name,String type){
    	PaginationSupport.byPage(page, rows);
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("name",name);
    	map.put("type",type);
		List<UserGoodsEx> list = userGoodsService.selectList(map);
		List<UserGoodsEx> ret = new ArrayList<UserGoodsEx>();
		for(UserGoodsEx ex : list){
			UserGoodsEx c = new UserGoodsEx();
			if("authAdmin".equals(getSessionParameter("roleCode"))){
				//是审核管理员
				ex.setPower(1);
			}else{
				ex.setPower(0);
			}
			ret.add(ex);
		}
		return page(ret);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserGoods userGoods){
    	if (userGoods.getId() == null){
    		userGoodsService.insert(userGoods);
    	}else{
    		userGoodsService.updateByPrimaryKeySelective(userGoods);

    		//然后查询是否是专家评定
			UserGoods record = userGoodsService.selectByPrimaryKey(userGoods.getId());
			if(null != record.getExperterInfoId()){
				//邀请了专家鉴定
				//更新experterInfo表

				ExperterInfo experterInfo = experterInfoService.selectByPrimaryKey(record.getExperterInfoId());
				experterInfo.setGoodsId(userGoods.getId());
				experterInfoService.updateByPrimaryKeySelective(experterInfo);
			}
    	}
       	return ok();
    }

	/**
	 * 回寄给用户并且插入express表
	 * @param userGoods
	 * @return
	 */
	@RequestMapping("/saveByBackToUser")
	@ResponseBody
	public String saveByBackToUser(UserGoods userGoods){
		if (userGoods.getId() == null){
			userGoodsService.insert(userGoods);
		}else{
			userGoodsService.updateByPrimaryKeySelective(userGoods);
		}
		UserGoods record = userGoodsService.selectByPrimaryKey(userGoods.getId());
		Express c = new Express();
		c.setSource(1);
		c.setSourceId(record.getUserId());
		c.setFid(userGoods.getId());
		c.setType(2);
		c.setExpressName(userGoods.getBackExpress());
		c.setExpressCode(userGoods.getBackExpressCode());
		c.setExpressState(0);
		c.setPostName(MPawnMsg.name);
		c.setPostPhone(MPawnMsg.phone);
		c.setReceiveName(userGoods.getBackUserName());
		c.setReceivePhone(userGoods.getBackUserPhone());
		c.setReceviceAddress(userGoods.getBackUserExpress());
		expressService.insert(c);
		return ok();
	}
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserGoods userGoods = userGoodsService.selectByPrimaryKey(id);
       	return ok(userGoods);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userGoodsService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }

    //开始拆箱--并且鉴定
	@RequestMapping("/beginToOper")
	@ResponseBody
	public String beginToOper(UserGoods userGoods){
    	if(4 != userGoods.getAuthResult()){
    		Map<String, Object> map = new HashMap<>();
    		map.put("id",userGoods.getId());
    		map.put("authResult", userGoods.getAuthResult());
    		map.put("authPrice","");
    		map.put("notVerifyReason",userGoods.getNotVerifyReason());
			int result = userGoodsService.updateResAuthPrice(map);
			//鉴定是赝品，或者是无法鉴定
			UserGoods userGoods2 = userGoodsService.selectByPrimaryKey(userGoods.getId());
			User user = userService.selectByPrimaryKey(userGoods2.getUserId());
			if(1 == userGoods2.getIsVerify()){
				if(2 == userGoods.getAuthResult()){
					//无法鉴定
					if (user.getId() != null) {
						//推送
						userNotifyService.insertByTemplate(user.getId(), "7", PaidangMessage.AUTH_MAIL_OPER_CANNOT_AUTH,userGoods2.getName(),userGoods.getNotVerifyReason());
					}
				}else if(3 == userGoods.getAuthResult()){
					//赝品
					if (user.getId() != null) {
						//推送
						userNotifyService.insertByTemplate(user.getId(), "7", PaidangMessage.AUTH_MAIL_OPER_YP, userGoods2.getName());
					}
				}
			}

		}else{
			userGoods.setId(userGoods.getId());
			userGoods.setAuthResult(userGoods.getAuthResult());
			userGoods.setAuthPrice(userGoods.getAuthPrice());
			userGoodsService.updateByPrimaryKeySelective(userGoods);

			UserGoods userGoods2 = userGoodsService.selectByPrimaryKey(userGoods.getId());
			User user = userService.selectByPrimaryKey(userGoods2.getUserId());
			if(1 == userGoods2.getIsVerify()){
				//经过鉴定者鉴定
				if(user != null) {
					//鉴定是真品
					//插入典当记录表
					pawnLogService.updatePawnlog(
							userGoods2.getId(),
							userGoods2.getBelongId(),
							null,
							userGoods2.getName(),
							userGoods.getAuthPrice(),
							userGoods2.getCateCode(),
							userGoods2.getCateId(),
							"",
							userGoods.getAuthPrice(),
							null,
							0,
							user.getName(),
							"",
							"");
					if (user.getId() != null) {
						//推送
						userNotifyService.insertByTemplate(user.getId(), "7", PaidangMessage.AUTH_MAIL_OPER, userGoods2.getName());
						userGoodsService.updateByPrimaryKeySelective(userGoods);


					}
				}
			}else{
				//通讯到authAdmin
				StringBuffer url = new StringBuffer();
				//查找admin权限--推送给admin
				AdminExample example = new AdminExample();
				example.createCriteria().andRoleCodeEqualTo("authAdmin");
				List<Admin> list = adminService.selectByExample(example);
				for(Admin admin : list){
					//url.append(ConstantsCode.SERVER_PUSH_URL+"?account="+admin.getId()+"&sys=authAdmin&msg={msg:'宝贝"+userGoods2.getName()+"请复审'}");
					try{
						Map<String, Object> pars = new HashMap<>();
						pars.put("account",admin.getId());
						pars.put("sys","admin");
						pars.put("msg","{msg:'宝贝"+userGoods2.getName()+"请复审'}");
						String result = HttpUtil.get(ConstantsCode.SERVER_PUSH_URL,pars);
					}catch (Exception e){
						e.printStackTrace();
						return ok();
					}

				}
			}

		}
    	return ok();
	}


	//鉴定者鉴定
	@RequestMapping("/authAdminVerify")
	@ResponseBody
	public String authAdminVerify(UserGoods userGoods) throws Exception {
		UserGoods userGoods2 = userGoodsService.selectByPrimaryKey(userGoods.getId());
		User user = userService.selectByPrimaryKey(userGoods2.getUserId());
		if(1 == userGoods.getIsVerify()){
			//经过鉴定者鉴定
			if(user != null) {
				//鉴定是真品
				//插入典当记录表
				if(4 == userGoods2.getAuthResult()){
					userNotifyService.insertByTemplate(user.getId(), "7", PaidangMessage.AUTH_MAIL_OPER, userGoods2.getName());
				}else if(2 == userGoods2.getAuthResult()){
					//无法鉴定
					if (user.getId() != null) {
						//推送
						userNotifyService.insertByTemplate(user.getId(), "7", PaidangMessage.AUTH_MAIL_OPER_CANNOT_AUTH,userGoods2.getName(),userGoods2.getNotVerifyReason());
					}
				}else if(3 == userGoods2.getAuthResult()){
					//赝品
					if (user.getId() != null) {
						//推送
						userNotifyService.insertByTemplate(user.getId(), "7", PaidangMessage.AUTH_MAIL_OPER_YP, userGoods2.getName());
					}
				}
				pawnLogService.updatePawnlog(
						userGoods2.getId(),
						userGoods2.getBelongId(),
						null,
						userGoods2.getName(),
						userGoods.getAuthPrice(),
						userGoods2.getCateCode(),
						userGoods2.getCateId(),
						"",
						userGoods2.getAuthPrice(),
						null,
						0,
						user.getName(),
						"",
						"");
				userGoodsService.updateByPrimaryKeySelective(userGoods);


				//通讯
				StringBuffer url = new StringBuffer();
				//查找admin权限--推送给admin
				AdminExample example = new AdminExample();
				example.createCriteria().andRoleCodeEqualTo("admin");
				List<Admin> list = adminService.selectByExample(example);
				for(Admin admin : list){
					url.append(ConstantsCode.SERVER_PUSH_URL+"?account="+admin.getId()+"&sys=admin&msg={msg:'宝贝"+userGoods2.getName()+"已经通过复审'}");
					try{
						String result = HttpUtil.get(url.toString());
					}catch (Exception e){
						return e.toString();
					}

				}

			}
		}
		return ok();
	}

	//查看在线鉴定详情
	@RequestMapping("/checkDetail")
	@ResponseBody
	public String checkDetail(Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",id);
		List<UserGoodsEx> list = userGoodsService.checkDetail(map);
		List<UserGoodsEx> ret = new ArrayList<>();
		for(UserGoodsEx ex : list){
			UserGoodsEx c = new UserGoodsEx();
			if(null != ex.getExpressType()){
				c.setId(ex.getId());
				c.setAccount(ex.getAccount());
				c.setNickName(ex.getNickName());
				c.setOldAccount(ex.getOldAccount());
				c.setUserId(ex.getUserId());
				c.setBelongId(ex.getBelongId());
				c.setName(ex.getName());
				c.setGoodsImgs(ex.getGoodsImgs());
				c.setVideo(ex.getVideo());
				c.setGoVideo(ex.getGoVideo());
				c.setOpenGoodsVideo(ex.getOpenGoodsVideo());
				c.setInfo(ex.getInfo());
				c.setUserName(ex.getUserName());
				c.setAuthResult(ex.getAuthResult());
				c.setBackExpressCode(ex.getBackExpressCode());
				c.setPostExpressCode(ex.getPostExpressCode());
				c.setSfProtectPrice(ex.getSfProtectPrice());
				c.setNotVerifyReason(ex.getNotVerifyReason());
				c.setPlatUserName(ex.getPlatUserName());
				c.setExperterName(ex.getExperterName());
				if(ex.getExpressType() == 1){
					//用户寄给平台
					c.setExpressData(ex.getExpressData());
				}else if(ex.getExpressType() == 2){
					//平台寄给用户
					c.setExpressData2(ex.getExpressData());
				}
				ret.add(c);
			}

		}
		return ok(ret.get(0));
	}

	@RequestMapping("/detail")
	@ResponseBody
	//卖给平台展示商品详情
	public String detail(Integer id){
		UserGoods userGoods = userGoodsService.selectByPrimaryKey(id);
		return ok(userGoods);
	}


	@RequestMapping("/goodsByOrgList")
	@ResponseBody
	//机构取回宝贝
	public String goodsByOrgList(Integer page, Integer rows, String name,Integer belongType, String code){
		PaginationSupport.byPage(page, rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name",name);
		map.put("belongType",belongType);
		map.put("code",code);
		List<UserGoodsEx> list = userGoodsService.selectGoodsByOrgList(map);
		return page(list);
	}


	@RequestMapping("/paltBackToOrg")
	@ResponseBody
	//机构取回--平台邮寄
	public String paltBackToOrg(UserGoods userGoods){

		userGoods.setPlatUserName(MPawnMsg.comName);
		userGoods.setPlatUserPhone(MPawnMsg.phone);
		userGoods.setPlatUserAddress(MPawnMsg.comAddress);
		userGoods.setPlatOrgState(2);
		userGoodsService.updateByPrimaryKeySelective(userGoods);

		//插入物流表
		Express express = new Express();
		express.setSource(2);
		express.setSourceId(userGoods.getBelongId());
		express.setFid(userGoods.getId());
		express.setType(6);
		express.setExpressName(MExpressAddress.xfAddress);
		express.setExpressCode(userGoods.getPlatOrgExpressCode());
		express.setExpressState(0);
		express.setPostName(MPawnMsg.comName);
		express.setPostPhone(MPawnMsg.phone);
		express.setReceiveName(userGoods.getPlatUserName());
		express.setReceivePhone(userGoods.getPlatUserPhone());
		express.setReceviceAddress(userGoods.getPlatUserAddress());
		expressService.insert(express);
		return ok();
	}

}