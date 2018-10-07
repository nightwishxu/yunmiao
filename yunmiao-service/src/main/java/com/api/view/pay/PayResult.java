package com.api.view.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PayResult {

	@ApiModelProperty(value="支付订单id")
	private String id;
	@ApiModelProperty(value="支付宝支付金额")
	private String money;
	@ApiModelProperty(value="平台1:支付宝2：微信3:银联")
	private Integer platform;
	@ApiModelProperty(value="支付宝支付回调地址")
	private String backUrl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public Integer getPlatform() {
		return platform;
	}
	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
}
