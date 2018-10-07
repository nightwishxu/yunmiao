package com.paidang.dao.model;



/**
 *
 */
public class Experter {

	/**
	 *
	 */
	private Integer id;

	/**
	 *专家姓名
	 */
	private String expertName;

	/**
	 *专家的专业领域id
	 */
	private Integer domainId;

	/**
	 *联系电话
	 */
	private String phone;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setExpertName(String expertName) {
		this.expertName=expertName == null ? expertName : expertName.trim();
	}

	public String getExpertName() {
		return expertName;
	}

	public void setDomainId(Integer domainId) {
		this.domainId=domainId;
	}

	public Integer getDomainId() {
		return domainId;
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

}
