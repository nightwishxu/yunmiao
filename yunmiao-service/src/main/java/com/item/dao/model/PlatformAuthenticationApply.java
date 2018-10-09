package com.item.dao.model;



/**
 *
 */
public class PlatformAuthenticationApply {

	/**
	 *
	 */
	private Integer id;

	/**
	 *
	 */
	private Integer userId;

	/**
	 *
	 */
	private String nickName;

	/**
	 *
	 */
	private String account;

	/**
	 *
	 */
	private java.util.Date applyTime;

	/**
	 *
	 */
	private String address;

	/**
	 *非遗类目
	 */
	private String heritageType;

	/**
	 *真实姓名
	 */
	private String realName;

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
	 *0申请中1申请通过2申请拒绝
	 */
	private Integer status;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

	/**
	 *
	 */
	private String createName;

	/**
	 *
	 */
	private java.util.Date updateName;

	/**
	 *
	 */
	private String updateTime;

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

	public void setNickName(String nickName) {
		this.nickName=nickName == null ? nickName : nickName.trim();
	}

	public String getNickName() {
		return nickName;
	}

	public void setAccount(String account) {
		this.account=account == null ? account : account.trim();
	}

	public String getAccount() {
		return account;
	}

	public void setApplyTime(java.util.Date applyTime) {
		this.applyTime=applyTime;
	}

	public java.util.Date getApplyTime() {
		return applyTime;
	}

	public void setAddress(String address) {
		this.address=address == null ? address : address.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setHeritageType(String heritageType) {
		this.heritageType=heritageType == null ? heritageType : heritageType.trim();
	}

	public String getHeritageType() {
		return heritageType;
	}

	public void setRealName(String realName) {
		this.realName=realName == null ? realName : realName.trim();
	}

	public String getRealName() {
		return realName;
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

	public void setStatus(Integer status) {
		this.status=status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateName(String createName) {
		this.createName=createName == null ? createName : createName.trim();
	}

	public String getCreateName() {
		return createName;
	}

	public void setUpdateName(java.util.Date updateName) {
		this.updateName=updateName;
	}

	public java.util.Date getUpdateName() {
		return updateName;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime=updateTime == null ? updateTime : updateTime.trim();
	}

	public String getUpdateTime() {
		return updateTime;
	}

}
