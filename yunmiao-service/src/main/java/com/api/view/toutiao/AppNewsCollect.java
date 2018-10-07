package com.api.view.toutiao;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import com.api.view.home.UserInfo;

public class AppNewsCollect {
	
	private Integer id;
	@ApiModelProperty(value="用户id")
	private String userId;
	@ApiModelProperty(value="新闻id")
	private Integer newsId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	
	
}
