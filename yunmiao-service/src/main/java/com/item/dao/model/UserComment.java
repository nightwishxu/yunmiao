package com.item.dao.model;



/**
 *
 */
public class UserComment {

	/**
	 *
	 */
	private Integer id;

	/**
	 *订单id
	 */
	private Integer orderId;

	/**
	 *用户id
	 */
	private Integer userId;

	/**
	 *用户名
	 */
	private String userName;

	/**
	 *商品id
	 */
	private Integer goodsId;

	/**
	 *商品名称
	 */
	private String goodsName;

	/**
	 *机构id
	 */
	private Integer orgId;

	/**
	 *评价信息
	 */
	private String info;

	/**
	 *评论图片，,隔开
	 */
	private String img;

	/**
	 *评分 1-5
	 */
	private Integer score;

	/**
	 *物流评分
	 */
	private Integer expressScore;

	/**
	 *服务评分
	 */
	private Integer serviceScore;

	/**
	 *后台回复人ID
	 */
	private Integer replayUserId;

	/**
	 *回复信息
	 */
	private String replayInfo;

	/**
	 *回复时间
	 */
	private java.util.Date replayTime;

	/**
	 *评价状态 0.删除，1.已评价， 2.客服已回复 
	 */
	private Integer status;

	/**
	 *是否匿名（0不匿名 1  匿名）
	 */
	private Integer showName;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

	/**
	 *修改时间
	 */
	private java.util.Date modifyTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setOrderId(Integer orderId) {
		this.orderId=orderId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserName(String userName) {
		this.userName=userName == null ? userName : userName.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId=goodsId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName=goodsName == null ? goodsName : goodsName.trim();
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setOrgId(Integer orgId) {
		this.orgId=orgId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setInfo(String info) {
		this.info=info == null ? info : info.trim();
	}

	public String getInfo() {
		return info;
	}

	public void setImg(String img) {
		this.img=img == null ? img : img.trim();
	}

	public String getImg() {
		return img;
	}

	public void setScore(Integer score) {
		this.score=score;
	}

	public Integer getScore() {
		return score;
	}

	public void setExpressScore(Integer expressScore) {
		this.expressScore=expressScore;
	}

	public Integer getExpressScore() {
		return expressScore;
	}

	public void setServiceScore(Integer serviceScore) {
		this.serviceScore=serviceScore;
	}

	public Integer getServiceScore() {
		return serviceScore;
	}

	public void setReplayUserId(Integer replayUserId) {
		this.replayUserId=replayUserId;
	}

	public Integer getReplayUserId() {
		return replayUserId;
	}

	public void setReplayInfo(String replayInfo) {
		this.replayInfo=replayInfo == null ? replayInfo : replayInfo.trim();
	}

	public String getReplayInfo() {
		return replayInfo;
	}

	public void setReplayTime(java.util.Date replayTime) {
		this.replayTime=replayTime;
	}

	public java.util.Date getReplayTime() {
		return replayTime;
	}

	public void setStatus(Integer status) {
		this.status=status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setShowName(Integer showName) {
		this.showName=showName;
	}

	public Integer getShowName() {
		return showName;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setModifyTime(java.util.Date modifyTime) {
		this.modifyTime=modifyTime;
	}

	public java.util.Date getModifyTime() {
		return modifyTime;
	}

}
