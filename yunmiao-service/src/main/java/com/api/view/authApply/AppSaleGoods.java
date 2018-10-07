package com.api.view.authApply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 卖出藏品
 * @author vonkira
 *
 */
@ApiModel
public class AppSaleGoods {

	private Integer id;
	@ApiModelProperty(value="地址code")
	private Integer addressCode;
	@ApiModelProperty(value="图片")
	private String image;
	@ApiModelProperty(value="鉴定价格")
	private String authPrice;
	@ApiModelProperty(value="平台收购价")
	private String purchasePirce;
	@ApiModelProperty(value="用户id")
	private Integer userId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(Integer addressCode) {
		this.addressCode = addressCode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAuthPrice() {
		return authPrice;
	}
	public void setAuthPrice(String authPrice) {
		this.authPrice = authPrice;
	}
	public String getPurchasePirce() {
		return purchasePirce;
	}
	public void setPurchasePirce(String purchasePirce) {
		this.purchasePirce = purchasePirce;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
