package com.api.view.toutiao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class NewsCategory {

	private Integer id;
	@ApiModelProperty(value="板块名称")
	private String name;
	@ApiModelProperty(value="可以发布的类型0全部1图文2图片3视频")
	private Integer contentType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
	
}
