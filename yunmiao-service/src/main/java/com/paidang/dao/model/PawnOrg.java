package com.paidang.dao.model;



/**
 *
 */
public class PawnOrg {

	/**
	 *机构编号
	 */
	private Integer id;

	/**
	 *角色
	 */
	private String roleCode;

	/**
	 *1典当机构2服务商
	 */
	private Integer type;

	/**
	 *账号
	 */
	private String account;

	/**
	 *密码
	 */
	private String password;

	/**
	 *机构名称
	 */
	private String name;

	/**
	 *机构法人
	 */
	private String legalPerson;

	/**
	 *注册资金
	 */
	private String registeredCapital;

	/**
	 *机构地址
	 */
	private String adress;

	/**
	 *工商许可证号
	 */
	private String businessLicenseCode;

	/**
	 *工商许可证图片
	 */
	private String businessLicense;

	/**
	 *到期提醒设置 1.每天2.每周3.到期前3天
	 */
	private Integer expirationRemindType;

	/**
	 *机构电话
	 */
	private String phone;

	/**
	 *余额
	 */
	private java.math.BigDecimal balance;

	/**
	 *
	 */
	private java.util.Date createTime;

	/**
	 *
	 */
	private java.util.Date modifyTime;

	/**
	 *1启动0禁用
	 */
	private Integer state;

	/**
	 *1正常0不允许放贷
	 */
	private Integer pawnState;

	/**
	 *机构逾期利率（千分之）
	 */
	private java.math.BigDecimal overdueRate;

	/**
	 *印章
	 */
	private String seal;

	/**
	 *公司简介
	 */
	private String introduction;

	/**
	 *公司环境图片，多张逗号隔开
	 */
	private String orgImages;

	/**
	 *机构LOGO图片
	 */
	private String orgLogo;

	/**
	 *逾期滞纳利率
	 */
	private java.math.BigDecimal redeemOverrate;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode=roleCode == null ? roleCode : roleCode.trim();
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
	}

	public void setAccount(String account) {
		this.account=account == null ? account : account.trim();
	}

	public String getAccount() {
		return account;
	}

	public void setPassword(String password) {
		this.password=password == null ? password : password.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name=name == null ? name : name.trim();
	}

	public String getName() {
		return name;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson=legalPerson == null ? legalPerson : legalPerson.trim();
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital=registeredCapital == null ? registeredCapital : registeredCapital.trim();
	}

	public String getRegisteredCapital() {
		return registeredCapital;
	}

	public void setAdress(String adress) {
		this.adress=adress == null ? adress : adress.trim();
	}

	public String getAdress() {
		return adress;
	}

	public void setBusinessLicenseCode(String businessLicenseCode) {
		this.businessLicenseCode=businessLicenseCode == null ? businessLicenseCode : businessLicenseCode.trim();
	}

	public String getBusinessLicenseCode() {
		return businessLicenseCode;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense=businessLicense == null ? businessLicense : businessLicense.trim();
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setExpirationRemindType(Integer expirationRemindType) {
		this.expirationRemindType=expirationRemindType;
	}

	public Integer getExpirationRemindType() {
		return expirationRemindType;
	}

	public void setPhone(String phone) {
		this.phone=phone == null ? phone : phone.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setBalance(java.math.BigDecimal balance) {
		this.balance=balance;
	}

	public java.math.BigDecimal getBalance() {
		return balance;
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

	public void setState(Integer state) {
		this.state=state;
	}

	public Integer getState() {
		return state;
	}

	public void setPawnState(Integer pawnState) {
		this.pawnState=pawnState;
	}

	public Integer getPawnState() {
		return pawnState;
	}

	public void setOverdueRate(java.math.BigDecimal overdueRate) {
		this.overdueRate=overdueRate;
	}

	public java.math.BigDecimal getOverdueRate() {
		return overdueRate;
	}

	public void setSeal(String seal) {
		this.seal=seal == null ? seal : seal.trim();
	}

	public String getSeal() {
		return seal;
	}

	public void setIntroduction(String introduction) {
		this.introduction=introduction == null ? introduction : introduction.trim();
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setOrgImages(String orgImages) {
		this.orgImages=orgImages == null ? orgImages : orgImages.trim();
	}

	public String getOrgImages() {
		return orgImages;
	}

	public void setOrgLogo(String orgLogo) {
		this.orgLogo=orgLogo == null ? orgLogo : orgLogo.trim();
	}

	public String getOrgLogo() {
		return orgLogo;
	}

	public void setRedeemOverrate(java.math.BigDecimal redeemOverrate) {
		this.redeemOverrate=redeemOverrate;
	}

	public java.math.BigDecimal getRedeemOverrate() {
		return redeemOverrate;
	}

}
