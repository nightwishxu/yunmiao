package com.paidang.dao.model;



/**
 *
 */
public class PawnCate {

	/**
	 *主键
	 */
	private Integer id;

	/**
	 *编号
	 */
	private String code;

	/**
	 *图片
	 */
	private String icon;

	/**
	 *名称
	 */
	private String name;

	/**
	 *鉴定类别
	 */
	private String cateType;

	/**
	 *排序
	 */
	private Integer sortOrder;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

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

	public void setIcon(String icon) {
		this.icon=icon == null ? icon : icon.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setName(String name) {
		this.name=name == null ? name : name.trim();
	}

	public String getName() {
		return name;
	}

	public void setCateType(String cateType) {
		this.cateType=cateType == null ? cateType : cateType.trim();
	}

	public String getCateType() {
		return cateType;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder=sortOrder;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
