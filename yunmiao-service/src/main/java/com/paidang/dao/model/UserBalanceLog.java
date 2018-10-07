package com.paidang.dao.model;



/**
 *
 */
public class UserBalanceLog {

	/**
	 *UUID
	 */
	private Integer id;

	/**
	 *藏品或者是典当续当id
	 */
	private Integer cid;

	/**
	 *用户id
	 */
	private Integer userId;

	/**
	 *数量
	 */
	private java.math.BigDecimal amount;

	/**
	 *1增2减
	 */
	private Integer type;

	/**
	 *项目1典当  2续当  3赎当 4卖给平台
	 */
	private String item;

	/**
	 *备注
	 */
	private String info;

	/**
	 *0余额1支付宝2微信10线下银行卡
	 */
	private Integer tradeType;

	/**
	 *支付宝微信流水号(线下打款当号)
	 */
	private String tradeNo;

	/**
	 *线下打款凭证
	 */
	private String tradeTicket;

	/**
	 *银行
	 */
	private String tradeCardBank;

	/**
	 *交易所用银行卡卡号
	 */
	private String tradeCardCode;

	/**
	 *机构id
	 */
	private Integer orgId;

	/**
	 *机构
	 */
	private String orgName;

	/**
	 *机构电话
	 */
	private String orgPhone;

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

	public void setCid(Integer cid) {
		this.cid=cid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setAmount(java.math.BigDecimal amount) {
		this.amount=amount;
	}

	public java.math.BigDecimal getAmount() {
		return amount;
	}

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
	}

	public void setItem(String item) {
		this.item=item == null ? item : item.trim();
	}

	public String getItem() {
		return item;
	}

	public void setInfo(String info) {
		this.info=info == null ? info : info.trim();
	}

	public String getInfo() {
		return info;
	}

	public void setTradeType(Integer tradeType) {
		this.tradeType=tradeType;
	}

	public Integer getTradeType() {
		return tradeType;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo=tradeNo == null ? tradeNo : tradeNo.trim();
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeTicket(String tradeTicket) {
		this.tradeTicket=tradeTicket == null ? tradeTicket : tradeTicket.trim();
	}

	public String getTradeTicket() {
		return tradeTicket;
	}

	public void setTradeCardBank(String tradeCardBank) {
		this.tradeCardBank=tradeCardBank == null ? tradeCardBank : tradeCardBank.trim();
	}

	public String getTradeCardBank() {
		return tradeCardBank;
	}

	public void setTradeCardCode(String tradeCardCode) {
		this.tradeCardCode=tradeCardCode == null ? tradeCardCode : tradeCardCode.trim();
	}

	public String getTradeCardCode() {
		return tradeCardCode;
	}

	public void setOrgId(Integer orgId) {
		this.orgId=orgId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgName(String orgName) {
		this.orgName=orgName == null ? orgName : orgName.trim();
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgPhone(String orgPhone) {
		this.orgPhone=orgPhone == null ? orgPhone : orgPhone.trim();
	}

	public String getOrgPhone() {
		return orgPhone;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
