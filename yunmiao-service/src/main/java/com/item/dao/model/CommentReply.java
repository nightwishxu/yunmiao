package com.item.dao.model;



/**
 *
 */
public class CommentReply {

	/**
	 *
	 */
	private Integer id;

	/**
	 *评论id
	 */
	private Integer commentId;

	/**
	 *1为回复评论，2为回复别人的回复
	 */
	private Integer replyType;

	/**
	 *回复目标id，reply_type为1时，是comment_id，reply_type为2时为回复表的id
	 */
	private Integer replyId;

	/**
	 *回复内容
	 */
	private String content;

	/**
	 *回复目标id
	 */
	private Integer toUid;

	/**
	 *回复用户id
	 */
	private Integer fromUid;

	/**
	 *回复者的头像
	 */
	private String fromThumbImg;

	/**
	 *回复者的昵称
	 */
	private String fromNickname;

	/**
	 *评论时间
	 */
	private java.util.Date createTime;

	/**
	 *冗余回复对象的昵称
	 */
	private String toNickname;

	/**
	 *0为普通回复，1为后台管理员回复，2作者回复
	 */
	private Integer isAuthor;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setCommentId(Integer commentId) {
		this.commentId=commentId;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setReplyType(Integer replyType) {
		this.replyType=replyType;
	}

	public Integer getReplyType() {
		return replyType;
	}

	public void setReplyId(Integer replyId) {
		this.replyId=replyId;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setContent(String content) {
		this.content=content == null ? content : content.trim();
	}

	public String getContent() {
		return content;
	}

	public void setToUid(Integer toUid) {
		this.toUid=toUid;
	}

	public Integer getToUid() {
		return toUid;
	}

	public void setFromUid(Integer fromUid) {
		this.fromUid=fromUid;
	}

	public Integer getFromUid() {
		return fromUid;
	}

	public void setFromThumbImg(String fromThumbImg) {
		this.fromThumbImg=fromThumbImg == null ? fromThumbImg : fromThumbImg.trim();
	}

	public String getFromThumbImg() {
		return fromThumbImg;
	}

	public void setFromNickname(String fromNickname) {
		this.fromNickname=fromNickname == null ? fromNickname : fromNickname.trim();
	}

	public String getFromNickname() {
		return fromNickname;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setToNickname(String toNickname) {
		this.toNickname=toNickname == null ? toNickname : toNickname.trim();
	}

	public String getToNickname() {
		return toNickname;
	}

	public void setIsAuthor(Integer isAuthor) {
		this.isAuthor=isAuthor;
	}

	public Integer getIsAuthor() {
		return isAuthor;
	}

}
