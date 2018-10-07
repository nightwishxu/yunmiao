package com.paidang.dao.model;



public class Order {

	/**
	 *
	 */
	private Integer id;

	/**
	 *订单号
	 */
	private String code;

	/**
	 *用户
	 */
	private Integer userId;

	/**
	 *p_goods表主键id
	 */
	private Integer goodsId;

	/**
	 *商品名称
	 */
	private String goodsName;

	/**
	 *商品封面
	 */
	private String goodsImg;

	/**
	 *1平台2机构3服务商
	 */
	private Integer goodsSource;

	/**
	 *0平台
	 */
	private Integer orgId;

	/**
	 *商品价格
	 */
	private java.math.BigDecimal goodsPrice;

	/**
	 *商品成本
	 */
	private java.math.BigDecimal goodsCost;

	/**
	 *订单金额
	 */
	private java.math.BigDecimal price;

	/**
	 *物品打包视频
	 */
	private String video;

	/**
	 *订单状态-1已取消1待付款2已付款3已发货4确认收货5已评价
	 */
	private Integer state;

	/**
	 *退款状态 0未退款 1申请退款 2同意退款 3提交单号 4已退款 5拒绝退款
	 */
	private Integer refState;

	/**
	 *支付流水tradeNo
	 */
	private String payLogId;

	/**
	 *1已结算0未结算
	 */
	private Integer isBalance;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

	/**
	 *更新时间
	 */
	private java.util.Date modifyTime;

	/**
	 *结算日期
	 */
	private java.util.Date balanceTime;

	/**
	 *支付日期
	 */
	private java.util.Date payTime;

	/**
	 *收件人姓名
	 */
	private String shipUser;

	/**
	 *快递公司
	 */
	private String shipFirm;

	/**
	 *快递编号
	 */
	private String shipCode;

	/**
	 *收件人地址
	 */
	private String shipAddress;

	/**
	 *收件人电话
	 */
	private String shipPhone;

	/**
	 *用户优惠券id
	 */
	private Integer couponId;

	/**
	 *优惠券金额
	 */
	private java.math.BigDecimal couponValue;

	/**
	 *满xx减xx
	 */
	private String couponInfo;

	/**
	 *0未删除1已删除
	 */
	private Integer isDel;

	/**
	 *退款原因
	 */
	private String refundReason;

	/**
	 *退款审核不通过理由
	 */
	private String refundNotVerifyReason;

	/**
	 *退款回寄单号
	 */
	private String backCode;

	/**
	 *退款回寄地址
	 */
	private String backAddress;

	/**
	 *
	 */
	private String backUser;

	/**
	 *退款回寄联系电话
	 */
	private String backPhone;

	/**
	 *退款物流状态 0初始化 1后台已签收
	 */
	private Integer backState;

	/**
	 *支付方式 1微信 2支付宝 3线下
	 */
	private Integer payType;

	/**
	 *评论状态0未评价，1已评价
	 */
	private Integer commentState;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setCode(String code) {
		this.code=code == null ? code : code.trim();
	}

	public String getCode() {
		return code;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
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

	public void setGoodsImg(String goodsImg) {
		this.goodsImg=goodsImg == null ? goodsImg : goodsImg.trim();
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsSource(Integer goodsSource) {
		this.goodsSource=goodsSource;
	}

	public Integer getGoodsSource() {
		return goodsSource;
	}

	public void setOrgId(Integer orgId) {
		this.orgId=orgId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setGoodsPrice(java.math.BigDecimal goodsPrice) {
		this.goodsPrice=goodsPrice;
	}

	public java.math.BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsCost(java.math.BigDecimal goodsCost) {
		this.goodsCost=goodsCost;
	}

	public java.math.BigDecimal getGoodsCost() {
		return goodsCost;
	}

	public void setPrice(java.math.BigDecimal price) {
		this.price=price;
	}

	public java.math.BigDecimal getPrice() {
		return price;
	}

	public void setVideo(String video) {
		this.video=video == null ? video : video.trim();
	}

	public String getVideo() {
		return video;
	}

	public void setState(Integer state) {
		this.state=state;
	}

	public Integer getState() {
		return state;
	}

	public void setRefState(Integer refState) {
		this.refState=refState;
	}

	public Integer getRefState() {
		return refState;
	}

	public void setPayLogId(String payLogId) {
		this.payLogId=payLogId == null ? payLogId : payLogId.trim();
	}

	public String getPayLogId() {
		return payLogId;
	}

	public void setIsBalance(Integer isBalance) {
		this.isBalance=isBalance;
	}

	public Integer getIsBalance() {
		return isBalance;
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

	public void setBalanceTime(java.util.Date balanceTime) {
		this.balanceTime=balanceTime;
	}

	public java.util.Date getBalanceTime() {
		return balanceTime;
	}

	public void setPayTime(java.util.Date payTime) {
		this.payTime=payTime;
	}

	public java.util.Date getPayTime() {
		return payTime;
	}

	public void setShipUser(String shipUser) {
		this.shipUser=shipUser == null ? shipUser : shipUser.trim();
	}

	public String getShipUser() {
		return shipUser;
	}

	public void setShipFirm(String shipFirm) {
		this.shipFirm=shipFirm == null ? shipFirm : shipFirm.trim();
	}

	public String getShipFirm() {
		return shipFirm;
	}

	public void setShipCode(String shipCode) {
		this.shipCode=shipCode == null ? shipCode : shipCode.trim();
	}

	public String getShipCode() {
		return shipCode;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress=shipAddress == null ? shipAddress : shipAddress.trim();
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipPhone(String shipPhone) {
		this.shipPhone=shipPhone == null ? shipPhone : shipPhone.trim();
	}

	public String getShipPhone() {
		return shipPhone;
	}

	public void setCouponId(Integer couponId) {
		this.couponId=couponId;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponValue(java.math.BigDecimal couponValue) {
		this.couponValue=couponValue;
	}

	public java.math.BigDecimal getCouponValue() {
		return couponValue;
	}

	public void setCouponInfo(String couponInfo) {
		this.couponInfo=couponInfo == null ? couponInfo : couponInfo.trim();
	}

	public String getCouponInfo() {
		return couponInfo;
	}

	public void setIsDel(Integer isDel) {
		this.isDel=isDel;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason=refundReason == null ? refundReason : refundReason.trim();
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundNotVerifyReason(String refundNotVerifyReason) {
		this.refundNotVerifyReason=refundNotVerifyReason == null ? refundNotVerifyReason : refundNotVerifyReason.trim();
	}

	public String getRefundNotVerifyReason() {
		return refundNotVerifyReason;
	}

	public void setBackCode(String backCode) {
		this.backCode=backCode == null ? backCode : backCode.trim();
	}

	public String getBackCode() {
		return backCode;
	}

	public void setBackAddress(String backAddress) {
		this.backAddress=backAddress == null ? backAddress : backAddress.trim();
	}

	public String getBackAddress() {
		return backAddress;
	}

	public void setBackUser(String backUser) {
		this.backUser=backUser == null ? backUser : backUser.trim();
	}

	public String getBackUser() {
		return backUser;
	}

	public void setBackPhone(String backPhone) {
		this.backPhone=backPhone == null ? backPhone : backPhone.trim();
	}

	public String getBackPhone() {
		return backPhone;
	}

	public void setBackState(Integer backState) {
		this.backState=backState;
	}

	public Integer getBackState() {
		return backState;
	}

	public void setPayType(Integer payType) {
		this.payType=payType;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setCommentState(Integer commentState) {
		this.commentState=commentState;
	}

	public Integer getCommentState() {
		return commentState;
	}

}
