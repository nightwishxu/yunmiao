package com.item.dao.model;



public class Focus {

	private Integer id;

	private String areaCode;

	private String img;

	private Integer location;

	private String restraint;

	private Integer redirectType;

	private String redirectContent;

	private String content;

	private Integer sortOrder;

	private java.util.Date createTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode=areaCode == null ? areaCode : areaCode.trim();
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setImg(String img) {
		this.img=img == null ? img : img.trim();
	}

	public String getImg() {
		return img;
	}

	public void setLocation(Integer location) {
		this.location=location;
	}

	public Integer getLocation() {
		return location;
	}

	public void setRestraint(String restraint) {
		this.restraint=restraint == null ? restraint : restraint.trim();
	}

	public String getRestraint() {
		return restraint;
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

	public void setContent(String content) {
		this.content=content == null ? content : content.trim();
	}

	public String getContent() {
		return content;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder=sortOrder;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
