package com.item.dao.model;



/**
 *
 */
public class Ad {

	/**
	 *广告（轮播图）id
	 */
	private Integer id;

	/**
	 *展示位置（1首页轮播图；2认证商城轮播图；3绝当商城轮播图; 4拍档头条）
	 */
	private Integer location;

	/**
	 *图片
	 */
	private String img;

	/**
	 *文字简介
	 */
	private String discription;

	/**
	 *类型（0不跳转；1网址；2富文本；3认证商城商品详情页；4绝当商城商品详情页；5视频详情页）
	 */
	private Integer type;

	/**
	 *内容（null、跳转url、富文本内容、商品id、视频id等）
	 */
	private String content;

	/**
	 *排序(倒序)
	 */
	private Integer sortOrder;

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

	public void setLocation(Integer location) {
		this.location=location;
	}

	public Integer getLocation() {
		return location;
	}

	public void setImg(String img) {
		this.img=img == null ? img : img.trim();
	}

	public String getImg() {
		return img;
	}

	public void setDiscription(String discription) {
		this.discription=discription == null ? discription : discription.trim();
	}

	public String getDiscription() {
		return discription;
	}

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
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
