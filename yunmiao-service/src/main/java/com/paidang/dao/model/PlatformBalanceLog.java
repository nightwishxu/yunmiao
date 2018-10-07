package com.paidang.dao.model;



/**
 *
 */
public class PlatformBalanceLog {

	/**
	 *
	 */
	private Integer id;

	/**
	 *金额
	 */
	private java.math.BigDecimal amount;

	/**
	 *项目
	 */
	private String item;

	/**
	 *描述
	 */
	private String info;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

	/**
	 *1-典当 2-续当
	 */
	private Integer type;

	/**
	 *典当/续当 id
	 */
	private Integer fid;

	/**
	 *支付流水表id
	 */
	private Long payLogId;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setAmount(java.math.BigDecimal amount) {
		this.amount=amount;
	}

	public java.math.BigDecimal getAmount() {
		return amount;
	}

	public void setItem(String item) {
		this.item=item == null ? item : item.trim();
	}

	public String getItem() {
		return item;
	}

	public void setInfo(String info) {
		this.info=info == null ? info : info.trim();
	}

	public String getInfo() {
		return info;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
	}

	public void setFid(Integer fid) {
		this.fid=fid;
	}

	public Integer getFid() {
		return fid;
	}

	public void setPayLogId(Long payLogId) {
		this.payLogId=payLogId;
	}

	public Long getPayLogId() {
		return payLogId;
	}

}
