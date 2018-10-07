package com.api.view.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserNotifyInfo")
public class UserNotifyInfo {

	
	@ApiModelProperty(value="标题")
	private String title;
	@ApiModelProperty(value="创建时间")
	private String createTime;
	@ApiModelProperty(value="是否已读")
	private int isRead;
	@ApiModelProperty(value="内容")
	private String content;
	@ApiModelProperty(value="id")
	private int id;
	@ApiModelProperty(value="0:不跳转 1:url 2:新闻")
	private int redirectType;
	@ApiModelProperty(value="新闻内容")
	private String redirectContent;
	@ApiModelProperty(value="类型 1:系统通知")
	private int type;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRedirectType() {
		return redirectType;
	}
	public void setRedirectType(int redirectType) {
		this.redirectType = redirectType;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getRedirectContent() {
		return redirectContent;
	}
	public void setRedirectContent(String redirectContent) {
		this.redirectContent = redirectContent;
	}
	
	
}
