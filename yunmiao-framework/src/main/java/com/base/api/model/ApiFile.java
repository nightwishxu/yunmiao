package com.base.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="apiFile")
public class ApiFile {

	@ApiModelProperty(name="id",value="图片id")
	private String id;
	@ApiModelProperty(name="path",value="图片路径")
	private String path;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
