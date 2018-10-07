package com.item.dao.model;



/**
 *
 */
public class Label {

	/**
	 *
	 */
	private Integer id;

	/**
	 *
	 */
	private String name;

	/**
	 *0删除1正常
	 */
	private Integer status;

	/**
	 *0公用1个人标签
	 */
	private Integer type;

	/**
	 *
	 */
	private Integer userId;

	/**
	 *排序
	 */
	private Integer sort;

	/**
	 *
	 */
	private java.util.Date createTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name=name == null ? name : name.trim();
	}

	public String getName() {
		return name;
	}

	public void setStatus(Integer status) {
		this.status=status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setSort(Integer sort) {
		this.sort=sort;
	}

	public Integer getSort() {
		return sort;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
