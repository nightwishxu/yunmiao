package com.item.dao.model;



/**
 *
 */
public class UserFollow {

	/**
	 *
	 */
	private Integer id;

	/**
	 *用户id
	 */
	private Integer userId;

	/**
	 *目标对象
	 */
	private Integer operateObject;

	/**
	 *当目标对象为被关注者，标示为1；
当目标对象为关注者，标示为2；
当双方互相关注，标示为3；
	 */
	private Integer status;

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

	public void setOperateObject(Integer operateObject) {
		this.operateObject=operateObject;
	}

	public Integer getOperateObject() {
		return operateObject;
	}

	public void setStatus(Integer status) {
		this.status=status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
