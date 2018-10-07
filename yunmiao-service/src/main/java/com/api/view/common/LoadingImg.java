package com.api.view.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class LoadingImg {

	@ApiModelProperty(value="图片")
	private String img;
	@ApiModelProperty(value="跳转")
	private String url;
	@ApiModelProperty(value="持续时间，单位:s")
	private int seconds;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
}
