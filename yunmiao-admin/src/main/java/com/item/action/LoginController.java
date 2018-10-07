package com.item.action;

import com.base.action.CoreController;
import com.base.dao.model.Ret;
import com.base.des.Md5;
import com.base.exception.SystemException;
import com.base.pay.wx.util.MD5Util;
import com.base.security.shiro.Principal;
import com.base.security.shiro.token.UsernamePasswordToken;
import com.base.security.util.UserUtils;
import com.base.util.ClassUtils;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import com.base.web.annotation.LoginMethod;
import com.item.dao.model.Role;
import com.item.dao.model.UserGroup;
import com.item.util.RoleUtil;
import com.paidang.dao.model.PawnOrg;
import com.paidang.dao.model.PawnOrgExample;
import com.paidang.service.PawnOrgService;
import com.youtu.sign.MD5;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
@RequestMapping("manager")
public class LoginController extends CoreController{

	@Autowired
	private PawnOrgService pawnOrgService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String defalut(HttpSession session,HttpServletRequest request) throws Exception {
		String sys = getSessionParameter("sys");
		if(!sys.equals("")){
			return "redirect:manager/"+sys;
		}
		String temp = "admin";
		Cookie[] cookies = request.getCookies();
		Cookie c = null;
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			c = cookies[i];
			if (c.getName().equals("sys")) {
				temp = c.getValue();
				break;
			}
		}
		return "redirect:manager/"+temp;
	}

	@RequestMapping("{system}")
	public String index(@PathVariable("system")String system ,HttpSession session, String role, ModelMap model) throws Exception {
		if (!RoleUtil.isGroup(system)){
			return "common/404";
		}else {
			model.put("sys", system);
			model.put("sysName", RoleUtil.getGroupName(system));
		}
		Principal principal = UserUtils.getPrincipal();
		if (principal != null){
			if (!principal.getGroupCode().equals(system)){
				Subject subject = SecurityUtils.getSubject();
				if (subject.isAuthenticated()) {
					subject.logout();
				}
				return "sys/login2";
			}
			return "sys/main";
		}
		return "sys/login2";
	}


	@RequestMapping("register")
	@ResponseBody
	public String register(HttpSession session, String role, ModelMap model,PawnOrg pawnOrg){
		model.put("sysName", "");
		PawnOrgExample example=new PawnOrgExample();
		PawnOrgExample.Criteria criteria=example.createCriteria();
		criteria.andAccountEqualTo(pawnOrg.getAccount());
		List<PawnOrg> list=pawnOrgService.selectByExample(example);
		if (list!=null && list.size()>0){
			return JSONUtils.serialize(new Ret(1, "该账号已被注册请重新注册！"));
		}
		pawnOrg.setCreateTime(new Date());
		pawnOrg.setPassword(MD5Util.MD5Encode(pawnOrg.getPassword(),"UTF-8"));
		if (pawnOrg.getType()==1){
			pawnOrg.setRoleCode("org_admin");
		}else if (pawnOrg.getType()==3){
			pawnOrg.setRoleCode("supplier_admin");
		}
		pawnOrg.setState(2);
		pawnOrgService.insert(pawnOrg);
		return msg(0,"注册成功");
	}



	@RequestMapping("{system}/login")
	@ResponseBody
	public String login(@PathVariable("system")String system ,String account, String pwd, HttpSession session) throws Exception {

		UserGroup group = RoleUtil.getGroupByCode(system);

		if (group == null){
			return JSONUtils.serialize(new Ret(1, "登录错误L10000,联系管理员"));
		}

		if (Objects.equals(system,"org")){
			PawnOrgExample example=new PawnOrgExample();
			example.createCriteria().andAccountEqualTo(account);
			List<PawnOrg> orgs=pawnOrgService.selectByExample(example);
			if (orgs!=null && orgs.size()>0){
				if (!Objects.equals(orgs.get(0).getState(),1)){
					return JSONUtils.serialize(new Ret(1, "该账户审核未通过或被禁用"));
				}
			}

		}

		Principal principal = UserUtils.getPrincipal();

		if (principal != null){
			return msg(0,group.getUrl());
		}


		UsernamePasswordToken token = new UsernamePasswordToken(account, new Md5Hash(pwd).toHex(), system);
		try {
			UserUtils.getSubject().login(token);
		}catch (Exception e){
			return JSONUtils.serialize(new Ret(1, "用户名或密码不正确"));
		}

		token.clear();
		principal =  UserUtils.getPrincipal();
		if (principal == null){
			return JSONUtils.serialize(new Ret(1, "用户名或密码不正确"));
		}


		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", principal.getId());
		map.put("areaCode", principal.getAreaCode());
		map.put("name", principal.getName());
		map.put("orgId", principal.getOrgId());
		map.put("orgName", principal.getOrgName());
		map.put("adminType", principal.getAdminType()+"");
		map.put("account", account);
		map.put("sys", group.getCode());
		map.put("sysname", group.getName());
		map.put("groupId", group.getId()+"");
		map.put("groupCode", group.getCode());

		//是否角色用户
		List<Role> roles = principal.getRoles();
		if (roles.size() > 0){
			Role role = roles.get(0);
			map.put("roleId", role.getId());
			map.put("roleCode", role.getCode());
			map.put("rolename", role.getName());

		}

		/*if(principal.getAdminType() < 2){
			map.put("groupWelcome", "sys/welcomeAdmin");
		}else if(principal.getAdminType() == 2){
			map.put("groupWelcome", "sys/welcomeSchool");
		}else if(principal.getAdminType() == 3){
			map.put("groupWelcome", "sys/welcomeSchool");
		}else if(principal.getAdminType() == 4){
			map.put("groupWelcome", "sys/welcomeBuild");
		}*/
		map.put("groupWelcome",  StringUtils.isBlank(group.getUrl())?"sys/welcome":group.getUrl());
		map.put("menu", JSONUtils.serialize(RoleUtil.initMenus(principal.getRights())));
		UserUtils.getSession().setAttribute(LoginMethod.ADMIN.getName(), map);

		return msg(0,group.getUrl());
	}

	@RequestMapping("/changePwd")
	@ResponseBody
	@LoginFilter
	public String changePwd(String oldpwd, String newpwd) throws Exception {
		if(StringUtils.isBlank(oldpwd) || StringUtils.isBlank(newpwd))throw new SystemException(1,"请填写完整再提交");
		String account = getSessionParameter("account");
		String groupCode = getSessionParameter("groupCode");
		UserGroup group = RoleUtil.getGroupByCode(groupCode);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("account", account);
		params.put("password", Md5.mD5(oldpwd));

		Object object = null;

		try {
			object = ClassUtils.invokeMethod(group.getClassName(), "login", params);
		} catch (Exception e) {
			logger.error(group.getClassName()+"中没有定义login(account,password)方法");
			return msg(1, "错误C10001,联系管理员");
		}


		if (object != null){
			String id = null;
			try {
				id = BeanUtils.getProperty(object, "id");
			} catch (Exception e) {
				logger.error("对象没有定义id字段");
				return msg(1, "登录错误C10002,联系管理员");
			}

			params.clear();
			params.put("id", id);
			params.put("password", newpwd);

			try {
				ClassUtils.invokeMethod(group.getClassName(), "changePwd", params);
			} catch (Exception e) {
				logger.error(group.getClassName()+"中没有定义changePwd(id,password)方法");
				return msg(1, "错误C10003,联系管理员");
			}

			return ok();
		}
		return  msg(1,"密码错误");
	}


	// 注销
	@RequestMapping("/logout")
	@LoginFilter
	public String logout(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		String system = "";
		if (subject.isAuthenticated()) {
			Principal principal = UserUtils.getPrincipal();
			system = principal.getGroupCode();
			subject.logout();
		}
		return "redirect:/manager/"+system;
	}

	
}
