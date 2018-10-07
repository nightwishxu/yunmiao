package com.paidang.dao.model;



/**
 *
 */
public class PlatformGoodsBuy {

	/**
	 *
	 */
	private Integer id;

	/**
	 *1用户2机构
	 */
	private Integer source;

	/**
	 *用户藏品
	 */
	private Integer goodsId;

	/**
	 *平台收购价
	 */
	private java.math.BigDecimal price;

	/**
	 *所属银行
	 */
	private String bankCardName;

	/**
	 *银行卡
	 */
	private String bankCardNo;

	/**
	 *用户真实姓名
	 */
	private String userName;

	/**
	 *用户手机号
	 */
	private String userPhone;

	/**
	 *1卖给平台2平台确认
	 */
	private Integer state;

	/**
	 *付款凭证
	 */
	private String ticket;

	/**
	 *
	 */
	private java.util.Date createTime;

	/**
	 *
	 */
	private java.util.Date modifyTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setSource(Integer source) {
		this.source=source;
	}

	public Integer getSource() {
		return source;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId=goodsId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setPrice(java.math.BigDecimal price) {
		this.price=price;
	}

	public java.math.BigDecimal getPrice() {
		return price;
	}

	public void setBankCardName(String bankCardName) {
		this.bankCardName=bankCardName == null ? bankCardName : bankCardName.trim();
	}

	public String getBankCardName() {
		return bankCardName;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo=bankCardNo == null ? bankCardNo : bankCardNo.trim();
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setUserName(String userName) {
		this.userName=userName == null ? userName : userName.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone=userPhone == null ? userPhone : userPhone.trim();
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setState(Integer state) {
		this.state=state;
	}

	public Integer getState() {
		return state;
	}

	public void setTicket(String ticket) {
		this.ticket=ticket == null ? ticket : ticket.trim();
	}

	public String getTicket() {
		return ticket;
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

}
