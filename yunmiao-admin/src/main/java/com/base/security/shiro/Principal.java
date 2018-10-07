package com.base.security.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.base.security.util.UserUtils;
import com.base.web.annotation.LoginMethod;
import com.item.dao.model.Right;
import com.item.dao.model.Role;


@SuppressWarnings("serial")
public class Principal implements Serializable{
	
	private String id; // 编号
	private String account;
	private String roleCode;
	private String groupCode;
	private String areaCode;
	private String orgId;
	private String orgName;
	private String name;
	private Integer adminType;
	
	//菜单
	private List<Right> rights;
	//按钮
	private List<Right> menus;
	private List<Role> roles = new ArrayList<Role>();
	private LoginMethod loginMethod;
	
	public Integer getAdminType() {
		return adminType;
	}
	public void setAdminType(Integer adminType) {
		this.adminType = adminType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public List<Right> getRights() {
		return rights;
	}
	public void setRights(List<Right> rights) {
		this.rights = rights;
	}
	public LoginMethod getLoginMethod() {
		return loginMethod;
	}
	public void setLoginMethod(LoginMethod loginMethod) {
		this.loginMethod = loginMethod;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public void addRole(Role role){
		roles.add(role);
	}
	public boolean hasRole(String roleCode){
		if (StringUtils.isBlank(roleCode)) return false;
		for (Role role : roles){
			if (roleCode.equals(role.getCode())){
				return true;
			}
		}
		return false;
	}
	/**
	 * 获取SESSIONID
	 */
	public String getSessionid() {
		try{
			return (String) UserUtils.getSession().getId();
		}catch (Exception e) {
			return "";
		}
	}
	@Override
	public String toString() {
		return id;
	}
	public List<Right> getMenus() {
		return menus;
	}
	public void setMenus(List<Right> menus) {
		this.menus = menus;
	}
}
