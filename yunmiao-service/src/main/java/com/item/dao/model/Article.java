package com.item.dao.model;



/**
 *
 */
public class Article {

	/**
	 *
	 */
	private Integer id;

	/**
	 *
	 */
	private Integer userId;

	/**
	 *类型默认1
	 */
	private Integer type;

	/**
	 *0删除1草稿2发布
	 */
	private Integer status;

	/**
	 *文章内容
	 */
	private String content;

	/**
	 *图片
	 */
	private String imgs;

	/**
	 *视频
	 */
	private String video;

	/**
	 *评论数
	 */
	private Integer commentCount;

	/**
	 *收藏数
	 */
	private Integer collectCount;

	/**
	 *点赞数
	 */
	private Integer praiseCount;

	/**
	 *标签
	 */
	private String labels;

	/**
	 *
	 */
	private String createName;

	/**
	 *
	 */
	private java.util.Date createTime;

	/**
	 *
	 */
	private String updateName;

	/**
	 *
	 */
	private java.util.Date updateTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
	}

	public void setStatus(Integer status) {
		this.status=status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setContent(String content) {
		this.content=content == null ? content : content.trim();
	}

	public String getContent() {
		return content;
	}

	public void setImgs(String imgs) {
		this.imgs=imgs == null ? imgs : imgs.trim();
	}

	public String getImgs() {
		return imgs;
	}

	public void setVideo(String video) {
		this.video=video == null ? video : video.trim();
	}

	public String getVideo() {
		return video;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount=commentCount;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCollectCount(Integer collectCount) {
		this.collectCount=collectCount;
	}

	public Integer getCollectCount() {
		return collectCount;
	}

	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount=praiseCount;
	}

	public Integer getPraiseCount() {
		return praiseCount;
	}

	public void setLabels(String labels) {
		this.labels=labels == null ? labels : labels.trim();
	}

	public String getLabels() {
		return labels;
	}

	public void setCreateName(String createName) {
		this.createName=createName == null ? createName : createName.trim();
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setUpdateName(String updateName) {
		this.updateName=updateName == null ? updateName : updateName.trim();
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime=updateTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

}
