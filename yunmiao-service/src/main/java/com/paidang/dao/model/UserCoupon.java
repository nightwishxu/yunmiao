package com.paidang.dao.model;



/**
 *
 */
public class UserCoupon {

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
	private Integer couponId;

	/**
	 *满
	 */
	private java.math.BigDecimal full;

	/**
	 *减
	 */
	private java.math.BigDecimal value;

	/**
	 *领取时间
	 */
	private java.util.Date createTime;

	/**
	 *过期时间
	 */
	private java.util.Date endTime;

	/**
	 *1未使用0已使用
	 */
	private Integer state;

	/**
	 *使用时间
	 */
	private java.util.Date useTime;

	/**
	 *来源coupon表type
	 */
	private Integer source;

	/**
	 *coupon表fid
	 */
	private Integer fid;

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

	public void setCouponId(Integer couponId) {
		this.couponId=couponId;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setFull(java.math.BigDecimal full) {
		this.full=full;
	}

	public java.math.BigDecimal getFull() {
		return full;
	}

	public void setValue(java.math.BigDecimal value) {
		this.value=value;
	}

	public java.math.BigDecimal getValue() {
		return value;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setEndTime(java.util.Date endTime) {
		this.endTime=endTime;
	}

	public java.util.Date getEndTime() {
		return endTime;
	}

	public void setState(Integer state) {
		this.state=state;
	}

	public Integer getState() {
		return state;
	}

	public void setUseTime(java.util.Date useTime) {
		this.useTime=useTime;
	}

	public java.util.Date getUseTime() {
		return useTime;
	}

	public void setSource(Integer source) {
		this.source=source;
	}

	public Integer getSource() {
		return source;
	}

	public void setFid(Integer fid) {
		this.fid=fid;
	}

	public Integer getFid() {
		return fid;
	}

}
