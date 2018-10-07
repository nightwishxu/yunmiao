package com.item.dao.model;



/**
 *
 */
public class UserMessage {

	/**
	 *
	 */
	private Integer id;

	/**
	 *
	 */
	private Integer fromUserId;

	/**
	 *
	 */
	private Integer toUserId;

	/**
	 *0未读1已读
	 */
	private Integer status;

	/**
	 *内容
	 */
	private String content;

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

	public void setFromUserId(Integer fromUserId) {
		this.fromUserId=fromUserId;
	}

	public Integer getFromUserId() {
		return fromUserId;
	}

	public void setToUserId(Integer toUserId) {
		this.toUserId=toUserId;
	}

	public Integer getToUserId() {
		return toUserId;
	}

	public void setStatus(Integer status) {
		this.status=status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setContent(String content) {
		this.content=content == null ? content : content.trim();
	}

	public String getContent() {
		return content;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
