package com.item.dao.model;



/**
 *
 */
public class UserWorks {

	/**
	 *
	 */
	private Integer id;

	/**
	 *申请id
	 */
	private Integer applyId;

	/**
	 *用户id
	 */
	private Integer userId;

	/**
	 *作品图
	 */
	private String img;

	/**
	 *名称
	 */
	private String name;

	/**
	 *价格
	 */
	private java.math.BigDecimal price;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

	/**
	 *
	 */
	private String createName;

	/**
	 *
	 */
	private java.util.Date updateName;

	/**
	 *
	 */
	private String updateTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setApplyId(Integer applyId) {
		this.applyId=applyId;
	}

	public Integer getApplyId() {
		return applyId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setImg(String img) {
		this.img=img == null ? img : img.trim();
	}

	public String getImg() {
		return img;
	}

	public void setName(String name) {
		this.name=name == null ? name : name.trim();
	}

	public String getName() {
		return name;
	}

	public void setPrice(java.math.BigDecimal price) {
		this.price=price;
	}

	public java.math.BigDecimal getPrice() {
		return price;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateName(String createName) {
		this.createName=createName == null ? createName : createName.trim();
	}

	public String getCreateName() {
		return createName;
	}

	public void setUpdateName(java.util.Date updateName) {
		this.updateName=updateName;
	}

	public java.util.Date getUpdateName() {
		return updateName;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime=updateTime == null ? updateTime : updateTime.trim();
	}

	public String getUpdateTime() {
		return updateTime;
	}

}
