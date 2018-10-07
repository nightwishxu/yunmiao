package com.paidang.dao.model;



/**
 *
 */
public class OrgAddress {

	/**
	 *
	 */
	private Integer id;

	/**
	 *用户id
	 */
	private Integer orgId;

	/**
	 *收件人名字
	 */
	private String userName;

	/**
	 *地区
	 */
	private String area;

	/**
	 *详细地址
	 */
	private String address;

	/**
	 *1默认0否
	 */
	private Integer isDefault;

	/**
	 *电话
	 */
	private String phone;

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

	public void setOrgId(Integer orgId) {
		this.orgId=orgId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setUserName(String userName) {
		this.userName=userName == null ? userName : userName.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setArea(String area) {
		this.area=area == null ? area : area.trim();
	}

	public String getArea() {
		return area;
	}

	public void setAddress(String address) {
		this.address=address == null ? address : address.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault=isDefault;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setPhone(String phone) {
		this.phone=phone == null ? phone : phone.trim();
	}

	public String getPhone() {
		return phone;
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
