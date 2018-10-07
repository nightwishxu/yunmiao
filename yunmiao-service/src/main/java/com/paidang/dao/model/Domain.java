package com.paidang.dao.model;



/**
 *
 */
public class Domain {

	/**
	 *专家类别表
	 */
	private Integer id;

	/**
	 *领域名称
	 */
	private String domainName;

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

	public void setDomainName(String domainName) {
		this.domainName=domainName == null ? domainName : domainName.trim();
	}

	public String getDomainName() {
		return domainName;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
