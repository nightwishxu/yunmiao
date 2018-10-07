package com.paidang.dao.model;



/**
 *
 */
public class OrgNotify {

	/**
	 *id
	 */
	private Integer id;

	/**
	 *机构id
	 */
	private Integer orgId;

	/**
	 *群发id
	 */
	private Integer nid;

	/**
	 *类型 1:系统通知
	 */
	private Integer type;

	/**
	 *标题
	 */
	private String title;

	/**
	 *内容
	 */
	private String content;

	/**
	 *0:不跳转 1:续当通知 2滞纳通知 3竞拍成功通知 4用户赎当 5绝当通知 6平台兜底成功
	 */
	private Integer redirectType;

	/**
	 *
	 */
	private String redirectContent;

	/**
	 *是否已读 0:未读 1:已读
	 */
	private Integer isRead;

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

	public void setOrgId(Integer orgId) {
		this.orgId=orgId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setNid(Integer nid) {
		this.nid=nid;
	}

	public Integer getNid() {
		return nid;
	}

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
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

	public void setRedirectType(Integer redirectType) {
		this.redirectType=redirectType;
	}

	public Integer getRedirectType() {
		return redirectType;
	}

	public void setRedirectContent(String redirectContent) {
		this.redirectContent=redirectContent == null ? redirectContent : redirectContent.trim();
	}

	public String getRedirectContent() {
		return redirectContent;
	}

	public void setIsRead(Integer isRead) {
		this.isRead=isRead;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
