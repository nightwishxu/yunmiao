package com.paidang.dao.model;



/**
 *
 */
public class PawnAuction {

	/**
	 *
	 */
	private Integer id;

	/**
	 *典当id
	 */
	private Integer pawnId;

	/**
	 *机构id
	 */
	private Integer orgId;

	/**
	 *当号
	 */
	private String pawnCode;

	/**
	 *出价
	 */
	private java.math.BigDecimal money;

	/**
	 *费率
	 */
	private java.math.BigDecimal rate;

	/**
	 *利率
	 */
	private java.math.BigDecimal moneyRate;

	/**
	 *出价人
	 */
	private Integer orgUserId;

	/**
	 *出价次数
	 */
	private Integer num;

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

	public void setPawnId(Integer pawnId) {
		this.pawnId=pawnId;
	}

	public Integer getPawnId() {
		return pawnId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId=orgId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setPawnCode(String pawnCode) {
		this.pawnCode=pawnCode == null ? pawnCode : pawnCode.trim();
	}

	public String getPawnCode() {
		return pawnCode;
	}

	public void setMoney(java.math.BigDecimal money) {
		this.money=money;
	}

	public java.math.BigDecimal getMoney() {
		return money;
	}

	public void setRate(java.math.BigDecimal rate) {
		this.rate=rate;
	}

	public java.math.BigDecimal getRate() {
		return rate;
	}

	public void setMoneyRate(java.math.BigDecimal moneyRate) {
		this.moneyRate=moneyRate;
	}

	public java.math.BigDecimal getMoneyRate() {
		return moneyRate;
	}

	public void setOrgUserId(Integer orgUserId) {
		this.orgUserId=orgUserId;
	}

	public Integer getOrgUserId() {
		return orgUserId;
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

	public void setModifyTime(java.util.Date modifyTime) {
		this.modifyTime=modifyTime;
	}

	public java.util.Date getModifyTime() {
		return modifyTime;
	}

}
