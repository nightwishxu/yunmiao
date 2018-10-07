package com.paidang.dao.model;



/**
 *
 */
public class GoodsAuction {

	/**
	 *
	 */
	private Integer id;

	/**
	 *p_goods表主键id
	 */
	private Integer goodsId;

	/**
	 *用户
	 */
	private Integer userId;

	/**
	 *出价
	 */
	private java.math.BigDecimal price;

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

	public void setGoodsId(Integer goodsId) {
		this.goodsId=goodsId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setPrice(java.math.BigDecimal price) {
		this.price=price;
	}

	public java.math.BigDecimal getPrice() {
		return price;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
