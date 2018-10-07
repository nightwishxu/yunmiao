package com.item.dao.model;



/**
 *
 */
public class PayLog {

	/**
	 *UUID
	 */
	private Long id;

	/**
	 *用户id
	 */
	private Integer userId;

	/**
	 *订单id
	 */
	private Integer orderId;

	/**
	 *应付额
	 */
	private java.math.BigDecimal money;

	/**
	 *实付款
	 */
	private java.math.BigDecimal realPay;

	/**
	 *买家
	 */
	private String buyer;

	/**
	 *卖家
	 */
	private String seller;

	/**
	 *流水号
	 */
	private String tradeNo;

	/**
	 *0:待付款 9:付款成功 10:订单更新成功
	 */
	private Integer state;

	/**
	 *0:余额1:支付宝2：微信
	 */
	private Integer platform;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

	/**
	 *修改时间
	 */
	private java.util.Date modifyTime;

	/**
	 *微信支付key
	 */
	private String wxKey;

	/**
	 *支付宝商户号
	 */
	private String alipayPartner;

	/**
	 *支付额外参数（支付/充值等等）
	 */
	private String param;

	public void setId(Long id) {
		this.id=id;
	}

	public Long getId() {
		return id;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId=orderId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setMoney(java.math.BigDecimal money) {
		this.money=money;
	}

	public java.math.BigDecimal getMoney() {
		return money;
	}

	public void setRealPay(java.math.BigDecimal realPay) {
		this.realPay=realPay;
	}

	public java.math.BigDecimal getRealPay() {
		return realPay;
	}

	public void setBuyer(String buyer) {
		this.buyer=buyer == null ? buyer : buyer.trim();
	}

	public String getBuyer() {
		return buyer;
	}

	public void setSeller(String seller) {
		this.seller=seller == null ? seller : seller.trim();
	}

	public String getSeller() {
		return seller;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo=tradeNo == null ? tradeNo : tradeNo.trim();
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setState(Integer state) {
		this.state=state;
	}

	public Integer getState() {
		return state;
	}

	public void setPlatform(Integer platform) {
		this.platform=platform;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setModifyTime(java.util.Date modifyTime) {
		this.modifyTime=modifyTime;
	}

	public java.util.Date getModifyTime() {
		return modifyTime;
	}

	public void setWxKey(String wxKey) {
		this.wxKey=wxKey == null ? wxKey : wxKey.trim();
	}

	public String getWxKey() {
		return wxKey;
	}

	public void setAlipayPartner(String alipayPartner) {
		this.alipayPartner=alipayPartner == null ? alipayPartner : alipayPartner.trim();
	}

	public String getAlipayPartner() {
		return alipayPartner;
	}

	public void setParam(String param) {
		this.param=param == null ? param : param.trim();
	}

	public String getParam() {
		return param;
	}

}
