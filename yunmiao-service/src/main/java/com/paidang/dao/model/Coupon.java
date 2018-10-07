package com.paidang.dao.model;



/**
 *
 */
public class Coupon {

	/**
	 *
	 */
	private Integer id;

	/**
	 *满
	 */
	private java.math.BigDecimal full;

	/**
	 *减
	 */
	private java.math.BigDecimal value;

	/**
	 *
	 */
	private java.util.Date createTime;

	/**
	 *
	 */
	private java.util.Date modifyTime;

	/**
	 *领取后有效天数
	 */
	private Integer days;

	/**
	 *视频id--若为0则所有
	 */
	private Integer fid;

	/**
	 *1新用户注册2看视频3进入首页
	 */
	private Integer type;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
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

	public void setModifyTime(java.util.Date modifyTime) {
		this.modifyTime=modifyTime;
	}

	public java.util.Date getModifyTime() {
		return modifyTime;
	}

	public void setDays(Integer days) {
		this.days=days;
	}

	public Integer getDays() {
		return days;
	}

	public void setFid(Integer fid) {
		this.fid=fid;
	}

	public Integer getFid() {
		return fid;
	}

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
	}

}
