package com.item.dao.model;



/**
 *
 */
public class WxUserNotify {

	/**
	 *
	 */
	private Integer id;

	/**
	 *
	 */
	private Integer userId;

	/**
	 *标题
	 */
	private String title;

	/**
	 *内容
	 */
	private String content;

	/**
	 *0删除1未读2已读
	 */
	private Integer status;

	/**
	 *0系统通知1个人通知
	 */
	private Integer type;

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

	public void setTitle(String title) {
		this.title=title == null ? title : title.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content=content == null ? content : content.trim();
	}

	public String getContent() {
		return content;
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

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
