package com.item.dao.model;



/**
 *
 */
public class UserReport {

	/**
	 *
	 */
	private Integer id;

	/**
	 *
	 */
	private Integer userId;

	/**
	 *昵称
	 */
	private String nickName;

	/**
	 *
	 */
	private Integer articleId;

	/**
	 *
	 */
	private String info;

	/**
	 *
	 */
	private String imgs;

	/**
	 *0删除1未处理2已处理
	 */
	private Integer status;

	/**
	 *
	 */
	private java.util.Date createTime;

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

	public void setNickName(String nickName) {
		this.nickName=nickName == null ? nickName : nickName.trim();
	}

	public String getNickName() {
		return nickName;
	}

	public void setArticleId(Integer articleId) {
		this.articleId=articleId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setInfo(String info) {
		this.info=info == null ? info : info.trim();
	}

	public String getInfo() {
		return info;
	}

	public void setImgs(String imgs) {
		this.imgs=imgs == null ? imgs : imgs.trim();
	}

	public String getImgs() {
		return imgs;
	}

	public void setStatus(Integer status) {
		this.status=status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
