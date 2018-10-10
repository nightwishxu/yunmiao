package com.item.dao.model;



/**
 *
 */
public class User {

	/**
	 *
	 */
	private Integer id;

	/**
	 *微信id(openid or unionid)
	 */
	private String xcxId;

	/**
	 *用户id
	 */
	private Integer userId;

	/**
	 *用户账号
	 */
	private String account;

	/**
	 *密码
	 */
	private String password;

	/**
	 *状态0删除 1正常
	 */
	private Integer status;

	/**
	 *
	 */
	private String headImg;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

	/**
	 *用户昵称
	 */
	private String nickName;

	/**
	 *性别 0:女 1:男 2:未知
	 */
	private Integer sex;

	/**
	 *姓名
	 */
	private String name;

	/**
	 *手机号
	 */
	private String phone;

	/**
	 *证件类型
	 */
	private String cardType;

	/**
	 *身份证
	 */
	private String idCard;

	/**
	 *身份证正面
	 */
	private String idCardImg;

	/**
	 *身份证反面
	 */
	private String idCardReverse;

	/**
	 *身份证手持
	 */
	private String idCardHand;

	/**
	 *是否实名认证 0未认证1认证中2认证通过
	 */
	private Integer realNameAuthentication;

	/**
	 *是否平台认证 0未认证1认证中2认证通过
	 */
	private Integer platformAuthentication;

	/**
	 *地址
	 */
	private String address;

	/**
	 *真实姓名
	 */
	private String trueName;

	/**
	 *
	 */
	private String createName;

	/**
	 *
	 */
	private String updateName;

	/**
	 *
	 */
	private java.util.Date updateTime;

	/**
	 *用户等级
	 */
	private Integer userLevel;

	/**
	 *用户最后登陆时间
	 */
	private java.util.Date lastLoginTime;

	/**
	 *登陆ip
	 */
	private String lastLoginIp;

	/**
	 *个人签名
	 */
	private String signature;

	/**
	 *身份证人脸是否绑定(0:未绑定 1绑定)
	 */
	private Integer isBind;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setXcxId(String xcxId) {
		this.xcxId=xcxId == null ? xcxId : xcxId.trim();
	}

	public String getXcxId() {
		return xcxId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
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

	public void setStatus(Integer status) {
		this.status=status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setHeadImg(String headImg) {
		this.headImg=headImg == null ? headImg : headImg.trim();
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setNickName(String nickName) {
		this.nickName=nickName == null ? nickName : nickName.trim();
	}

	public String getNickName() {
		return nickName;
	}

	public void setSex(Integer sex) {
		this.sex=sex;
	}

	public Integer getSex() {
		return sex;
	}

	public void setName(String name) {
		this.name=name == null ? name : name.trim();
	}

	public String getName() {
		return name;
	}

	public void setPhone(String phone) {
		this.phone=phone == null ? phone : phone.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setCardType(String cardType) {
		this.cardType=cardType == null ? cardType : cardType.trim();
	}

	public String getCardType() {
		return cardType;
	}

	public void setIdCard(String idCard) {
		this.idCard=idCard == null ? idCard : idCard.trim();
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCardImg(String idCardImg) {
		this.idCardImg=idCardImg == null ? idCardImg : idCardImg.trim();
	}

	public String getIdCardImg() {
		return idCardImg;
	}

	public void setIdCardReverse(String idCardReverse) {
		this.idCardReverse=idCardReverse == null ? idCardReverse : idCardReverse.trim();
	}

	public String getIdCardReverse() {
		return idCardReverse;
	}

	public void setIdCardHand(String idCardHand) {
		this.idCardHand=idCardHand == null ? idCardHand : idCardHand.trim();
	}

	public String getIdCardHand() {
		return idCardHand;
	}

	public void setRealNameAuthentication(Integer realNameAuthentication) {
		this.realNameAuthentication=realNameAuthentication;
	}

	public Integer getRealNameAuthentication() {
		return realNameAuthentication;
	}

	public void setPlatformAuthentication(Integer platformAuthentication) {
		this.platformAuthentication=platformAuthentication;
	}

	public Integer getPlatformAuthentication() {
		return platformAuthentication;
	}

	public void setAddress(String address) {
		this.address=address == null ? address : address.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setTrueName(String trueName) {
		this.trueName=trueName == null ? trueName : trueName.trim();
	}

	public String getTrueName() {
		return trueName;
	}

	public void setCreateName(String createName) {
		this.createName=createName == null ? createName : createName.trim();
	}

	public String getCreateName() {
		return createName;
	}

	public void setUpdateName(String updateName) {
		this.updateName=updateName == null ? updateName : updateName.trim();
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime=updateTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel=userLevel;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setLastLoginTime(java.util.Date lastLoginTime) {
		this.lastLoginTime=lastLoginTime;
	}

	public java.util.Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp=lastLoginIp == null ? lastLoginIp : lastLoginIp.trim();
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setSignature(String signature) {
		this.signature=signature == null ? signature : signature.trim();
	}

	public String getSignature() {
		return signature;
	}

	public void setIsBind(Integer isBind) {
		this.isBind=isBind;
	}

	public Integer getIsBind() {
		return isBind;
	}

}
