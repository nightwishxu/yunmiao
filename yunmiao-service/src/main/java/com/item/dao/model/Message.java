package com.item.dao.model;



public class Message {

	private Integer id;

	private Integer type;

	private String target;

	private String content;

	private Integer redirectType;

	private String redirectContent;

	private Integer state;

	private Integer num;

	private java.util.Date createTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
	}

	public void setTarget(String target) {
		this.target=target == null ? target : target.trim();
	}

	public String getTarget() {
		return target;
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

	public void setState(Integer state) {
		this.state=state;
	}

	public Integer getState() {
		return state;
	}

	public void setNum(Integer num) {
		this.num=num;
	}

	public Integer getNum() {
		return num;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
