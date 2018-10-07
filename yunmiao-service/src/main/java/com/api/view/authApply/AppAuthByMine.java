package com.api.view.authApply;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 我的鉴定
 * @author vonkira
 *
 */
@ApiModel
public class AppAuthByMine {

	private Integer id;
	@ApiModelProperty(value="宝贝名字")
	private String title;
	@ApiModelProperty(value="宝贝图片")
	private String image;
	@ApiModelProperty(value="鉴定结果(0未鉴定 1:鉴定中 2:无法鉴定 3:赝品 4:真品)")
	private Integer authResult;
	@ApiModelProperty(value="鉴定价格")
	private String authPrice;
	@ApiModelProperty(value="邮寄状态(1:未邮寄 2:已邮寄")
	private Integer postState;
	@ApiModelProperty(value="用户id")
	private Integer userId;
	@ApiModelProperty(value="用户按钮(0:没有按钮 1:取回  2:去典当 3:卖给平台  4:邮寄鉴定 )")
	private Integer state;
	
	private Date createTime;
	
	private Date modifyTime;

	
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

	public Integer getAuthResult() {
		return authResult;
	}

	public void setAuthResult(Integer authResult) {
		this.authResult = authResult;
	}

	public String getAuthPrice() {
		return authPrice;
	}

	public void setAuthPrice(String authPrice) {
		this.authPrice = authPrice;
	}

	public Integer getPostState() {
		return postState;
	}

	public void setPostState(Integer postState) {
		this.postState = postState;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	
}
