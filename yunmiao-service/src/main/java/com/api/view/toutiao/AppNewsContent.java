package com.api.view.toutiao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class AppNewsContent {

	@ApiModelProperty(value="内容")
	private String content;
	@ApiModelProperty(value="图片数组")
	private List<String> imgs;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getImgs() {
		return imgs;
	}
	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}
	
}
