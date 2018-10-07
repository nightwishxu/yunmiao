package com.paidang.dao.model;



/**
 *
 */
public class ExperterInfo {

	/**
	 *
	 */
	private Integer id;

	/**
	 *标题
	 */
	private String title;

	/**
	 *专家id
	 */
	private Integer experterId;

	/**
	 *商品id
	 */
	private Integer goodsId;

	/**
	 *专家是否已经评定 0未评定 1已评定
	 */
	private Integer state;

	/**
	 *专家意见
	 */
	private String info;

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

	public void setTitle(String title) {
		this.title=title == null ? title : title.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setExperterId(Integer experterId) {
		this.experterId=experterId;
	}

	public Integer getExperterId() {
		return experterId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId=goodsId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setState(Integer state) {
		this.state=state;
	}

	public Integer getState() {
		return state;
	}

	public void setInfo(String info) {
		this.info=info == null ? info : info.trim();
	}

	public String getInfo() {
		return info;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
