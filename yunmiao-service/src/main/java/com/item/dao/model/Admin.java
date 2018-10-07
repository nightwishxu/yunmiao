package com.item.dao.model;



public class Admin {

	private Integer id;

	private String roleCode;

	private String account;

	private String password;

	private Integer state;

	private java.util.Date modifyTime;

	private java.util.Date createTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode=roleCode == null ? roleCode : roleCode.trim();
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setAccount(String account) {
		this.account=account == null ? account : account.trim();
	}

	public String getAccount() {
		return account;
	}

	public void setPassword(String password) {
		this.password=password == null ? password : password.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setState(Integer state) {
		this.state=state;
	}

	public Integer getState() {
		return state;
	}

	public void setModifyTime(java.util.Date modifyTime) {
		this.modifyTime=modifyTime;
	}

	public java.util.Date getModifyTime() {
		return modifyTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
