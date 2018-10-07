package com.item.dao.model;



/**
 *
 */
public class WxUserInfo {

	/**
	 *
	 */
	private Integer userId;

	/**
	 *关注数量
	 */
	private Integer followCount;

	/**
	 *粉丝数量（被关注）
	 */
	private Integer fansCount;

	/**
	 *动态数量
	 */
	private Integer articleCount;

	/**
	 *
	 */
	private java.util.Date createTime;

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setFollowCount(Integer followCount) {
		this.followCount=followCount;
	}

	public Integer getFollowCount() {
		return followCount;
	}

	public void setFansCount(Integer fansCount) {
		this.fansCount=fansCount;
	}

	public Integer getFansCount() {
		return fansCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount=articleCount;
	}

	public Integer getArticleCount() {
		return articleCount;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
