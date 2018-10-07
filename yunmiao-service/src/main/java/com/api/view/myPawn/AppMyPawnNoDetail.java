package com.api.view.myPawn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 我的典当--未典当列表详情
 * @author vonkira
 *
 */
@ApiModel
public class AppMyPawnNoDetail {

	@ApiModelProperty(value="当品id")
	private Integer id;
	@ApiModelProperty(value="当品图片")
	private String title;
	@ApiModelProperty(value="当品图片")
	private String image;
	@ApiModelProperty(value="鉴定价格")
	private String authPrice;
	@ApiModelProperty(value="邮寄状态(0:未邮寄  1:已邮寄)")
	private Integer state;
	@ApiModelProperty(value="地址Code")
	private Integer addressCode;
	@ApiModelProperty(value="是否卖出给平台  -1没操作 0处理中 1已经卖给平台")
	private Integer goSellType;
//	@ApiModelProperty(value="是否是竞拍成功后机构未在一小时内打款 0不是 1是")
//	private Integer type;
	@ApiModelProperty(value="是否流拍 0未流拍")
	private Integer authCnt;
	@ApiModelProperty(value="拍卖id")
	private Integer pawnId;

	public Integer getPawnId() {
		return pawnId;
	}

	public void setPawnId(Integer pawnId) {
		this.pawnId = pawnId;
	}

	public Integer getAuthCnt() {
		return authCnt;
	}

	public void setAuthCnt(Integer authCnt) {
		this.authCnt = authCnt;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(Integer addressCode) {
		this.addressCode = addressCode;
	}

	public Integer getGoSellType() {
		return goSellType;
	}

	public void setGoSellType(Integer goSellType) {
		this.goSellType = goSellType;
	}
	//	public Integer getType() {
//		return type;
//	}
//
//	public void setType(Integer type) {
//		this.type = type;
//	}
}
