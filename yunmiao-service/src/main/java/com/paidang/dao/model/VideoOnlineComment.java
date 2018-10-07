package com.paidang.dao.model;



/**
 *
 */
public class VideoOnlineComment {

	/**
	 *
	 */
	private Integer id;

	/**
	 *视频
	 */
	private Integer videoId;

	/**
	 *用户
	 */
	private Integer userId;

	/**
	 *内容
	 */
	private String content;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

	/**
	 *1删除0未删除
	 */
	private Integer isDel;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setVideoId(Integer videoId) {
		this.videoId=videoId;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setContent(String content) {
		this.content=content == null ? content : content.trim();
	}

	public String getContent() {
		return content;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setIsDel(Integer isDel) {
		this.isDel=isDel;
	}

	public Integer getIsDel() {
		return isDel;
	}

}
