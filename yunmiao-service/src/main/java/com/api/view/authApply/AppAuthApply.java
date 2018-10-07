package com.api.view.authApply;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 在线鉴宝申请
 * @author vonkira
 *
 */
@ApiModel
public class AppAuthApply {

	private Integer id;
	@ApiModelProperty(value="上传宝贝类型(1:图片  2:视频)")
	private Integer type;
	@ApiModelProperty(value="宝贝图片")
	private List<String> images;
	@ApiModelProperty(value="所在城市")
	private String city;
	@ApiModelProperty(value="藏友姓名")
	private String name;
	@ApiModelProperty(value="鉴定要求")
	private String authenticateRequire;
	@ApiModelProperty(value="用户id")
	private Integer userId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthenticateRequire() {
		return authenticateRequire;
	}
	public void setAuthenticateRequire(String authenticateRequire) {
		this.authenticateRequire = authenticateRequire;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
