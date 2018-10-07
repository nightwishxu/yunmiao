package com.item.dao.model;



/**
 *
 */
public class Comment {

	/**
	 *
	 */
	private Integer id;

	/**
	 *主题id
	 */
	private Integer articleId;

	/**
	 *主题作者id
	 */
	private Integer authorId;

	/**
	 *1为文章
	 */
	private Integer type;

	/**
	 *评论内容
	 */
	private String content;

	/**
	 *评论者id，一般为会员表的id
	 */
	private Integer userId;

	/**
	 *冗余用户昵称
	 */
	private String nickName;

	/**
	 *冗余用户头像
	 */
	private String headImg;

	/**
	 *是否置顶评论，1为置顶，0为不置顶
	 */
	private Integer isTop;

	/**
	 *是否为热评，1为热评
	 */
	private Integer isHot;

	/**
	 *评论被点赞的次数
	 */
	private Integer likeNum;

	/**
	 *评论被回复的次数
	 */
	private Integer replyNum;

	/**
	 *是否回复0没有，1已回复
	 */
	private Integer isReply;

	/**
	 *评论状态，-1为删除，0为待审核，1为已发布
	 */
	private Integer status;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

	/**
	 *0为普通回复，1为后台管理员回复,2作者回复
	 */
	private Integer isAuthor;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
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

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
	}

	public void setContent(String content) {
		this.content=content == null ? content : content.trim();
	}

	public String getContent() {
		return content;
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

	public void setHeadImg(String headImg) {
		this.headImg=headImg == null ? headImg : headImg.trim();
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setIsTop(Integer isTop) {
		this.isTop=isTop;
	}

	public Integer getIsTop() {
		return isTop;
	}

	public void setIsHot(Integer isHot) {
		this.isHot=isHot;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setLikeNum(Integer likeNum) {
		this.likeNum=likeNum;
	}

	public Integer getLikeNum() {
		return likeNum;
	}

	public void setReplyNum(Integer replyNum) {
		this.replyNum=replyNum;
	}

	public Integer getReplyNum() {
		return replyNum;
	}

	public void setIsReply(Integer isReply) {
		this.isReply=isReply;
	}

	public Integer getIsReply() {
		return isReply;
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

	public void setIsAuthor(Integer isAuthor) {
		this.isAuthor=isAuthor;
	}

	public Integer getIsAuthor() {
		return isAuthor;
	}

}
