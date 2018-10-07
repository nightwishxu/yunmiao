package com.paidang.dao.model;



/**
 *
 */
public class OrgBalanceLog {

	/**
	 *主键
	 */
	private Integer id;

	/**
	 *机构id
	 */
	private Integer orgId;

	/**
	 *金额
	 */
	private java.math.BigDecimal money;

	/**
	 *1支出2收入
	 */
	private Integer type;

	/**
	 *1用户典当  2用户续当 3用户赎当 4卖给平台 5典当平台服务费 6续当平台服务费
	 */
	private String item;

	/**
	 *描述
	 */
	private String info;

	/**
	 *当号
	 */
	private String pawnCode;

	/**
	 *相关id（典当表id或续当表id item=2,6时）
	 */
	private Integer fid;

	/**
	 *支付流水表id
	 */
	private Long payLogId;

	/**
	 *0余额1支付宝2微信10线下银行卡
	 */
	private Integer tradeType;

	/**
	 *支付宝微信流水号
	 */
	private String tradeNo;

	/**
	 *银行
	 */
	private String tradeCardBank;

	/**
	 *交易所用银行卡卡号
	 */
	private String tradeCardCode;

	/**
	 *线下打款凭证
	 */
	private String tradeTicket;

	/**
	 *
	 */
	private Integer userId;

	/**
	 *用户姓名
	 */
	private String userName;

	/**
	 *用户手机号
	 */
	private String userPhone;

	/**
	 *
	 */
	private java.util.Date createTime;

	/**
	 *开始日期
	 */
	private java.util.Date beginTime;

	/**
	 *结束日期
	 */
	private java.util.Date endTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setOrgId(Integer orgId) {
		this.orgId=orgId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setMoney(java.math.BigDecimal money) {
		this.money=money;
	}

	public java.math.BigDecimal getMoney() {
		return money;
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

	public void setPawnCode(String pawnCode) {
		this.pawnCode=pawnCode == null ? pawnCode : pawnCode.trim();
	}

	public String getPawnCode() {
		return pawnCode;
	}

	public void setFid(Integer fid) {
		this.fid=fid;
	}

	public Integer getFid() {
		return fid;
	}

	public void setPayLogId(Long payLogId) {
		this.payLogId=payLogId;
	}

	public Long getPayLogId() {
		return payLogId;
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

	public void setTradeTicket(String tradeTicket) {
		this.tradeTicket=tradeTicket == null ? tradeTicket : tradeTicket.trim();
	}

	public String getTradeTicket() {
		return tradeTicket;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
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

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setBeginTime(java.util.Date beginTime) {
		this.beginTime=beginTime;
	}

	public java.util.Date getBeginTime() {
		return beginTime;
	}

	public void setEndTime(java.util.Date endTime) {
		this.endTime=endTime;
	}

	public java.util.Date getEndTime() {
		return endTime;
	}

}
