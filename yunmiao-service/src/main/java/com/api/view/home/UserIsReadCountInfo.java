package com.api.view.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@ApiModel(value="userInfo")
public class UserIsReadCountInfo {
	
	@ApiModelProperty(value="未读消息数量")
	@ApiParam(hidden=true)
	private Integer count;
	@ApiModelProperty(value="用户id")
	@ApiParam(hidden=true)
	private Integer id;
	@ApiModelProperty(value="账号")
	@ApiParam(hidden=true)
	private String account;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
}
