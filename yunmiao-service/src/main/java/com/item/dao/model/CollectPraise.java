package com.item.dao.model;



/**
 *
 */
public class CollectPraise {

	/**
	 *
	 */
	private Integer id;

	/**
	 *
	 */
	private Integer userId;

	/**
	 *
	 */
	private Integer articleId;

	/**
	 *动态作者id
	 */
	private Integer authorId;

	/**
	 *头像
	 */
	private String headImg;

	/**
	 *昵称
	 */
	private String nickName;

	/**
	 *动态图片
	 */
	private String img;

	/**
	 *
	 */
	private Integer status;

	/**
	 *0点赞1收藏
	 */
	private Integer type;

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

	public void setArticleId(Integer articleId) {
		this.articleId=articleId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId=authorId;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setHeadImg(String headImg) {
		this.headImg=headImg == null ? headImg : headImg.trim();
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setNickName(String nickName) {
		this.nickName=nickName == null ? nickName : nickName.trim();
	}

	public String getNickName() {
		return nickName;
	}

	public void setImg(String img) {
		this.img=img == null ? img : img.trim();
	}

	public String getImg() {
		return img;
	}

	public void setStatus(Integer status) {
		this.status=status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
