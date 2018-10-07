package com.base.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@ApiModel(value="mobileInfo")
public class MobileInfo {
	@ApiModelProperty(name="userId",value="用户id")
	private Integer userid;
	
	@ApiModelProperty(name="deviceid",value="设备Id",hidden=true)
	@ApiParam(hidden = true)
	private String deviceid;
	
	@ApiModelProperty(name="deviceType",value="设备类型",hidden=true)
	@ApiParam(hidden = true)
	private Integer deviceType;
	
	@ApiModelProperty(name="token",value="token验证")
	private String token;

	public MobileInfo() {
	}

	public MobileInfo(Integer userid, String deviceid, Integer deviceType) {
		this.userid = userid;
		this.deviceid = deviceid;
		this.deviceType = deviceType;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}