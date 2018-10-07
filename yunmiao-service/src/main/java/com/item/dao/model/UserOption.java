package com.item.dao.model;



/**
 *
 */
public class UserOption {

	/**
	 *
	 */
	private Integer id;

	/**
	 *
	 */
	private Integer userId;

	/**
	 *
	 */
	private String info;

	/**
	 *图片
	 */
	private String img;

	/**
	 *0删除1未读2已读
	 */
	private Integer status;

	/**
	 *0未处理1已处理
	 */
	private Integer processState;

	/**
	 *
	 */
	private java.util.Date createTime;

	/**
	 *回复信息
	 */
	private String replyInfo;

	/**
	 *回复时间
	 */
	private java.util.Date replyTime;

	/**
	 *回复账号
	 */
	private Integer replyAccount;

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

	public void setInfo(String info) {
		this.info=info == null ? info : info.trim();
	}

	public String getInfo() {
		return info;
	}

	public void setImg(String img) {
		this.img=img == null ? img : img.trim();
	}

	public String getImg() {
		return img;
	}

	public void setStatus(Integer status) {
		this.status=status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setProcessState(Integer processState) {
		this.processState=processState;
	}

	public Integer getProcessState() {
		return processState;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setReplyInfo(String replyInfo) {
		this.replyInfo=replyInfo == null ? replyInfo : replyInfo.trim();
	}

	public String getReplyInfo() {
		return replyInfo;
	}

	public void setReplyTime(java.util.Date replyTime) {
		this.replyTime=replyTime;
	}

	public java.util.Date getReplyTime() {
		return replyTime;
	}

	public void setReplyAccount(Integer replyAccount) {
		this.replyAccount=replyAccount;
	}

	public Integer getReplyAccount() {
		return replyAccount;
	}

}
