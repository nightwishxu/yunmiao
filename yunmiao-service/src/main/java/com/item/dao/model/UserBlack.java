package com.item.dao.model;



/**
 *
 */
public class UserBlack {

	/**
	 *
	 */
	private Integer id;

	/**
	 *用户id
	 */
	private Integer userId;

	/**
	 *黑名单id
	 */
	private Integer backUserId;

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

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setBackUserId(Integer backUserId) {
		this.backUserId=backUserId;
	}

	public Integer getBackUserId() {
		return backUserId;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
