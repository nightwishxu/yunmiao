package com.paidang.dao.model;



/**
 *
 */
public class UserBankCard {

	/**
	 *
	 */
	private Integer id;

	/**
	 *用户id
	 */
	private Integer userId;

	/**
	 *银行图标
	 */
	private String bankLogo;

	/**
	 *银行卡号
	 */
	private String bankCardNo;

	/**
	 *所属银行
	 */
	private String bankCardName;

	/**
	 *姓名
	 */
	private String bankCardUserName;

	/**
	 *预留手机号
	 */
	private String bankCardPhone;

	/**
	 *身份证号
	 */
	private String bankCardIdCard;

	/**
	 *1储蓄卡2信用卡
	 */
	private Integer bankCardType;

	/**
	 *1默认0否
	 */
	private Integer isDefault;

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

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setBankLogo(String bankLogo) {
		this.bankLogo=bankLogo == null ? bankLogo : bankLogo.trim();
	}

	public String getBankLogo() {
		return bankLogo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo=bankCardNo == null ? bankCardNo : bankCardNo.trim();
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardName(String bankCardName) {
		this.bankCardName=bankCardName == null ? bankCardName : bankCardName.trim();
	}

	public String getBankCardName() {
		return bankCardName;
	}

	public void setBankCardUserName(String bankCardUserName) {
		this.bankCardUserName=bankCardUserName == null ? bankCardUserName : bankCardUserName.trim();
	}

	public String getBankCardUserName() {
		return bankCardUserName;
	}

	public void setBankCardPhone(String bankCardPhone) {
		this.bankCardPhone=bankCardPhone == null ? bankCardPhone : bankCardPhone.trim();
	}

	public String getBankCardPhone() {
		return bankCardPhone;
	}

	public void setBankCardIdCard(String bankCardIdCard) {
		this.bankCardIdCard=bankCardIdCard == null ? bankCardIdCard : bankCardIdCard.trim();
	}

	public String getBankCardIdCard() {
		return bankCardIdCard;
	}

	public void setBankCardType(Integer bankCardType) {
		this.bankCardType=bankCardType;
	}

	public Integer getBankCardType() {
		return bankCardType;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault=isDefault;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
