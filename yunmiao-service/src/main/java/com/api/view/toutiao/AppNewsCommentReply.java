package com.api.view.toutiao;

import com.api.view.home.UserInfo;
import com.base.util.DFA;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AppNewsCommentReply {

	private Integer id;
	@ApiModelProperty(value="内容")
	private String content;
	@ApiModelProperty(value="时间")
	private String time;
	@ApiModelProperty(value="用户信息")
	private UserInfo userInfo;
	@ApiModelProperty(value="赞数量")
	private Integer praiseCnt;
	@ApiModelProperty(value="1已赞")
	private Integer isPraise;
	@ApiModelProperty(value="回复用户")
	private UserInfo replyUser;
	@ApiModelProperty(value="回复内容")
	private String replyContent;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return DFA.replaceKeys(content);
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Integer getPraiseCnt() {
		return praiseCnt;
	}
	public void setPraiseCnt(Integer praiseCnt) {
		this.praiseCnt = praiseCnt;
	}
	public Integer getIsPraise() {
		return isPraise;
	}
	public void setIsPraise(Integer isPraise) {
		this.isPraise = isPraise;
	}
	public UserInfo getReplyUser() {
		return replyUser;
	}
	public void setReplyUser(UserInfo replyUser) {
		this.replyUser = replyUser;
	}
	public String getReplyContent() {
		return DFA.replaceKeys(replyContent);
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
}
