package com.item.dao.model;



public class MobileVerify {

	private String deviceId;

	private Integer userId;

	private String verify;

	private String cid;

	private Integer deviceType;

	private java.util.Date updateTime;

	private java.util.Date expireTime;

	private java.util.Date createTime;

	public void setDeviceId(String deviceId) {
		this.deviceId=deviceId == null ? deviceId : deviceId.trim();
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setVerify(String verify) {
		this.verify=verify == null ? verify : verify.trim();
	}

	public String getVerify() {
		return verify;
	}

	public void setCid(String cid) {
		this.cid=cid == null ? cid : cid.trim();
	}

	public String getCid() {
		return cid;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType=deviceType;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime=updateTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setExpireTime(java.util.Date expireTime) {
		this.expireTime=expireTime;
	}

	public java.util.Date getExpireTime() {
		return expireTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
