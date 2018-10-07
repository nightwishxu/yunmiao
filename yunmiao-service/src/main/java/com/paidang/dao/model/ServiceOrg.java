package com.paidang.dao.model;



/**
 *
 */
public class ServiceOrg {

	/**
	 *
	 */
	private Integer id;

	/**
	 *角色编号
	 */
	private String roleCode;

	/**
	 *名称
	 */
	private String name;

	/**
	 *账号
	 */
	private String account;

	/**
	 *密码
	 */
	private String password;

	/**
	 *余额
	 */
	private java.math.BigDecimal balance;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

	/**
	 *更新时间
	 */
	private java.util.Date modifyTime;

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

	public void setName(String name) {
		this.name=name == null ? name : name.trim();
	}

	public String getName() {
		return name;
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

	public void setBalance(java.math.BigDecimal balance) {
		this.balance=balance;
	}

	public java.math.BigDecimal getBalance() {
		return balance;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setModifyTime(java.util.Date modifyTime) {
		this.modifyTime=modifyTime;
	}

	public java.util.Date getModifyTime() {
		return modifyTime;
	}

}
