package com.item.dao.model;



public class UserOauth {

	private Integer id;

	private Integer userId;

	private Integer type;

	private String openId;

	private String accessToken;

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

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
	}

	public void setOpenId(String openId) {
		this.openId=openId == null ? openId : openId.trim();
	}

	public String getOpenId() {
		return openId;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken=accessToken == null ? accessToken : accessToken.trim();
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
