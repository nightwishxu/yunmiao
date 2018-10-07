package com.api.view.account;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="smsCode")
public class SmsCode {

	@ApiModelProperty(name="code",value="验证码")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
