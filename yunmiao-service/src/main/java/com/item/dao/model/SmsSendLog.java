package com.item.dao.model;



public class SmsSendLog {

	private Integer id;

	private String phone;

	private String deviceId;

	private String ip;

	private java.util.Date createTime;

	private Integer type;

	private String code;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setPhone(String phone) {
		this.phone=phone == null ? phone : phone.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId=deviceId == null ? deviceId : deviceId.trim();
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setIp(String ip) {
		this.ip=ip == null ? ip : ip.trim();
	}

	public String getIp() {
		return ip;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
	}

	public void setCode(String code) {
		this.code=code == null ? code : code.trim();
	}

	public String getCode() {
		return code;
	}

}
