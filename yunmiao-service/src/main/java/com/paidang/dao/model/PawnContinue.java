package com.paidang.dao.model;



/**
 *
 */
public class PawnContinue {

	/**
	 *
	 */
	private Integer id;

	/**
	 *典当id
	 */
	private Integer pawnId;

	/**
	 *当号
	 */
	private String pawnTicketCode;

	/**
	 *上期截至日期
	 */
	private java.util.Date pawnLastEndTime;

	/**
	 *续当至日期
	 */
	private java.util.Date pawnEndTime;

	/**
	 *续当月份(半月)
	 */
	private Integer pawnMonth;

	/**
	 *本期综合费
	 */
	private java.math.BigDecimal pawnMoney;

	/**
	 *上期利息
	 */
	private java.math.BigDecimal pawnInterest;

	/**
	 *滞纳金，默认0
	 */
	private java.math.BigDecimal pawnOverdue;

	/**
	 *平台服务费
	 */
	private java.math.BigDecimal platformMoney;

	/**
	 *-1机构拒绝1申请3用户打款并上传凭证4机构确认5机构未收到
	 */
	private Integer state;

	/**
	 *0未缴纳1已缴纳平台服务费
	 */
	private Integer platformState;

	/**
	 *打款凭证
	 */
	private String payTicket;

	/**
	 *当票
	 */
	private String pawnTicket;

	/**
	 *上传凭证时间
	 */
	private java.util.Date payTime;

	/**
	 *用户姓名
	 */
	private String userName;

	/**
	 *用户银行
	 */
	private String userBank;

	/**
	 *用户银行卡号
	 */
	private String userBankCard;

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

	public void setPawnTicketCode(String pawnTicketCode) {
		this.pawnTicketCode=pawnTicketCode == null ? pawnTicketCode : pawnTicketCode.trim();
	}

	public String getPawnTicketCode() {
		return pawnTicketCode;
	}

	public void setPawnLastEndTime(java.util.Date pawnLastEndTime) {
		this.pawnLastEndTime=pawnLastEndTime;
	}

	public java.util.Date getPawnLastEndTime() {
		return pawnLastEndTime;
	}

	public void setPawnEndTime(java.util.Date pawnEndTime) {
		this.pawnEndTime=pawnEndTime;
	}

	public java.util.Date getPawnEndTime() {
		return pawnEndTime;
	}

	public void setPawnMonth(Integer pawnMonth) {
		this.pawnMonth=pawnMonth;
	}

	public Integer getPawnMonth() {
		return pawnMonth;
	}

	public void setPawnMoney(java.math.BigDecimal pawnMoney) {
		this.pawnMoney=pawnMoney;
	}

	public java.math.BigDecimal getPawnMoney() {
		return pawnMoney;
	}

	public void setPawnInterest(java.math.BigDecimal pawnInterest) {
		this.pawnInterest=pawnInterest;
	}

	public java.math.BigDecimal getPawnInterest() {
		return pawnInterest;
	}

	public void setPawnOverdue(java.math.BigDecimal pawnOverdue) {
		this.pawnOverdue=pawnOverdue;
	}

	public java.math.BigDecimal getPawnOverdue() {
		return pawnOverdue;
	}

	public void setPlatformMoney(java.math.BigDecimal platformMoney) {
		this.platformMoney=platformMoney;
	}

	public java.math.BigDecimal getPlatformMoney() {
		return platformMoney;
	}

	public void setState(Integer state) {
		this.state=state;
	}

	public Integer getState() {
		return state;
	}

	public void setPlatformState(Integer platformState) {
		this.platformState=platformState;
	}

	public Integer getPlatformState() {
		return platformState;
	}

	public void setPayTicket(String payTicket) {
		this.payTicket=payTicket == null ? payTicket : payTicket.trim();
	}

	public String getPayTicket() {
		return payTicket;
	}

	public void setPawnTicket(String pawnTicket) {
		this.pawnTicket=pawnTicket == null ? pawnTicket : pawnTicket.trim();
	}

	public String getPawnTicket() {
		return pawnTicket;
	}

	public void setPayTime(java.util.Date payTime) {
		this.payTime=payTime;
	}

	public java.util.Date getPayTime() {
		return payTime;
	}

	public void setUserName(String userName) {
		this.userName=userName == null ? userName : userName.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserBank(String userBank) {
		this.userBank=userBank == null ? userBank : userBank.trim();
	}

	public String getUserBank() {
		return userBank;
	}

	public void setUserBankCard(String userBankCard) {
		this.userBankCard=userBankCard == null ? userBankCard : userBankCard.trim();
	}

	public String getUserBankCard() {
		return userBankCard;
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
