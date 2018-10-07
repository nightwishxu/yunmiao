package com.base.security.shiro.realm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.security.shiro.Principal;
import com.base.security.shiro.token.UsernamePasswordToken;
import com.base.util.ClassUtils;
import com.base.web.annotation.LoginMethod;
import com.item.dao.model.Admin;
import com.item.dao.model.Right;
import com.item.dao.model.Role;
import com.item.dao.model.UserGroup;
import com.item.service.AdminService;
import com.item.service.RightService;
import com.item.util.RoleUtil;

@Component
public class AdminRealm extends AuthorizingRealm{
	
	private Logger logger = LoggerFactory.getLogger(AdminRealm.class);
	
//	@Autowired
//	private RightService rightService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		Principal principal = (Principal) getAvailablePrincipal(principals);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (principal.getMenus() != null){
			for (Right right : principal.getMenus()){
				if (StringUtils.isNotBlank(right.getCode()))
					info.addStringPermission(right.getCode());
			}
		}
		List<Role> list = principal.getRoles();
		for (Role role : list){
			info.addRole(role.getCode());
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		// 获取基于用户名和密码的令牌
		// 实际上这个authcToken是从SystemUserController里面currentUser.login(token)传过来的
		// 两个token的引用都是一样的
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String password = new String(token.getPassword());
		UserGroup group = RoleUtil.getGroupByCode(token.getGroup());
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("account", token.getUsername());
		params.put("password", password);
		Object object = null;
		try {
			object = ClassUtils.invokeMethod(group.getClassName(), "login", params);
		} catch (Exception e) {
			logger.error(token.getClassName()+"中没有定义login(account,password)方法");
			return null;
		}
		if (object != null){
			
			Principal principal = new Principal();
			String roleCode = null;
			try {
				roleCode = BeanUtils.getProperty(object,"roleCode");
				principal.setId(BeanUtils.getProperty(object, "id"));
				principal.setRoleCode(roleCode);
				principal.setAccount(token.getUsername());
				principal.setGroupCode(token.getGroup());
				principal.setOrgName(group.getName());
//				principal.setAreaCode(admin.getAreaCode());
//				principal.setName(admin.getName());
//				principal.setAdminType(admin.getType());
//				if(admin.getType() > 2){
//					Org org = orgService.selectByPrimaryKey(admin.getOrgId());
//					principal.setOrgId(admin.getOrgId());
//					principal.setOrgName(org.getName());
//				}else{
//				}
				
				principal.setLoginMethod(LoginMethod.ADMIN);
				List<Right> rights = null;
				if (StringUtils.isBlank(roleCode)){
					//rights = rightService.selectByUser(principal.getId());
				}else {
					Role role = RoleUtil.getRoleByCode(roleCode);
					if (role == null){
						return null;
					}
					principal.addRole(role);
					rights = RoleUtil.getRightsByCode(group.getCode(),roleCode);
					if (!RoleUtil.isGroupRole(roleCode, token.getGroup())){
						return null;
					}
				}
				List<Right> realRight = new ArrayList<Right>();
				List<Right> menu = new ArrayList<Right>();
				for (Right right : rights){
					if (right.getLevel() == 3){
						menu.add(right);
					}else {
						realRight.add(right);
					}
				}
				//添加菜单权限
				principal.setRights(realRight);
				//添加按钮权限
				principal.setMenus(menu);
			} catch (Exception e) {
				logger.error("对象没有定义id或者roleCode字段");
				principal = null;
			} 
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(principal,password,this.getName());
			return authcInfo;
		}else {
			logger.error("后台用户登录败以后走的这里...");
			return null;
		}
	}
	
	/**
	 * 将一些数据放到ShiroSession中,以便于其它地方使用
	 * 在Controller中,使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			logger.debug("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

}
