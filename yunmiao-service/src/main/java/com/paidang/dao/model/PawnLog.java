package com.paidang.dao.model;



/**
 *
 */
public class PawnLog {

	/**
	 *
	 */
	private Integer id;

	/**
	 *藏品id
	 */
	private Integer goodsId;

	/**
	 *用户
	 */
	private Integer userId;

	/**
	 *机构id
	 */
	private Integer orgId;

	/**
	 *藏品名称
	 */
	private String goodsName;

	/**
	 *鉴定价格
	 */
	private java.math.BigDecimal authPrice;

	/**
	 *藏品类别
	 */
	private String goodsCate;

	/**
	 *藏品类别id
	 */
	private Integer goodsCateId;

	/**
	 *机构名称
	 */
	private String orgName;

	/**
	 *金额
	 */
	private java.math.BigDecimal money;

	/**
	 *时间
	 */
	private Integer pawnMonth;

	/**
	 *0鉴定真品1典当2续当3赎当4绝当5交易6卖给平台
	 */
	private Integer type;

	/**
	 *用户姓名
	 */
	private String userName;

	/**
	 *银行
	 */
	private String tradeCardBank;

	/**
	 *交易所用银行卡卡号
	 */
	private String tradeCardCode;

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

	public void setOrgId(Integer orgId) {
		this.orgId=orgId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName=goodsName == null ? goodsName : goodsName.trim();
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setAuthPrice(java.math.BigDecimal authPrice) {
		this.authPrice=authPrice;
	}

	public java.math.BigDecimal getAuthPrice() {
		return authPrice;
	}

	public void setGoodsCate(String goodsCate) {
		this.goodsCate=goodsCate == null ? goodsCate : goodsCate.trim();
	}

	public String getGoodsCate() {
		return goodsCate;
	}

	public void setGoodsCateId(Integer goodsCateId) {
		this.goodsCateId=goodsCateId;
	}

	public Integer getGoodsCateId() {
		return goodsCateId;
	}

	public void setOrgName(String orgName) {
		this.orgName=orgName == null ? orgName : orgName.trim();
	}

	public String getOrgName() {
		return orgName;
	}

	public void setMoney(java.math.BigDecimal money) {
		this.money=money;
	}

	public java.math.BigDecimal getMoney() {
		return money;
	}

	public void setPawnMonth(Integer pawnMonth) {
		this.pawnMonth=pawnMonth;
	}

	public Integer getPawnMonth() {
		return pawnMonth;
	}

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
	}

	public void setUserName(String userName) {
		this.userName=userName == null ? userName : userName.trim();
	}

	public String getUserName() {
		return userName;
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
