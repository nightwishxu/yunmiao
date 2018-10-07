package com.api.view.myPawn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 我的典当--竞拍中--列表显示详情
 * @author vonkira
 *
 */
@ApiModel
public class AppMyPawningDetail {

	@ApiModelProperty(value="当品id")
	private Integer id;
	@ApiModelProperty(value="当品名称")
	private String title;
	@ApiModelProperty(value="当品图片")
	private String image;
	@ApiModelProperty(value="鉴定价格")
	private String authPrice;
	@ApiModelProperty(value="出价次数")
	private Integer count;
	@ApiModelProperty(value="状态(0:进行中 1:已结束)")
	private Integer state;
	@ApiModelProperty(value="用户id")
	private Integer userId;
	
	
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
}
