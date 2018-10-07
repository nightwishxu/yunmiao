package com.api.view.myPawn;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 我的典当--已典当列表显示详情 
 * @author vonkira
 *
 */
@ApiModel
public class AppMyPawnedDetail {

	@ApiModelProperty(value="当品id")
	private Integer id;
	@ApiModelProperty(value="当品图片")
	private String title;
	@ApiModelProperty(value="当品图片")
	private String image;
	@ApiModelProperty(value="鉴定价格")
	private String authPrice;
	@ApiModelProperty(value="当号")
	private String pawnCodeString;
	@ApiModelProperty(value="当铺机构id")
	private Integer orgId;
	@ApiModelProperty(value="所有当票id")
	private List<String> images;
	
	@ApiModelProperty(value="到期时间")
	private String expireTime;
	@ApiModelProperty(value="已贷款金额")
	private String loansMoney;
	
	
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
	public String getPawnCodeString() {
		return pawnCodeString;
	}
	public void setPawnCodeString(String pawnCodeString) {
		this.pawnCodeString = pawnCodeString;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	
	
	
}
