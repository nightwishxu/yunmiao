package com.item.dao.model;



/**
 *
 */
public class SysDict {

	/**
	 *编号
	 */
	private Integer id;

	/**
	 *数据值
	 */
	private String value;

	/**
	 *标签名
	 */
	private String labelName;

	/**
	 *类型
	 */
	private String type;

	/**
	 *描述
	 */
	private String description;

	/**
	 *排序（升序）
	 */
	private java.math.BigDecimal sort;

	/**
	 *父级编号
	 */
	private String parentId;

	/**
	 *创建者
	 */
	private String createBy;

	/**
	 *创建时间
	 */
	private java.util.Date createDate;

	/**
	 *更新者
	 */
	private String updateBy;

	/**
	 *更新时间
	 */
	private java.util.Date updateDate;

	/**
	 *备注信息
	 */
	private String remarks;

	/**
	 *删除标记
	 */
	private String delFlag;

	/**
	 *1-初始数据;0-用户添加
	 */
	private String status;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setValue(String value) {
		this.value=value == null ? value : value.trim();
	}

	public String getValue() {
		return value;
	}

	public void setLabelName(String labelName) {
		this.labelName=labelName == null ? labelName : labelName.trim();
	}

	public String getLabelName() {
		return labelName;
	}

	public void setType(String type) {
		this.type=type == null ? type : type.trim();
	}

	public String getType() {
		return type;
	}

	public void setDescription(String description) {
		this.description=description == null ? description : description.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setSort(java.math.BigDecimal sort) {
		this.sort=sort;
	}

	public java.math.BigDecimal getSort() {
		return sort;
	}

	public void setParentId(String parentId) {
		this.parentId=parentId == null ? parentId : parentId.trim();
	}

	public String getParentId() {
		return parentId;
	}

	public void setCreateBy(String createBy) {
		this.createBy=createBy == null ? createBy : createBy.trim();
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate=createDate;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy=updateBy == null ? updateBy : updateBy.trim();
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate=updateDate;
	}

	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	public void setRemarks(String remarks) {
		this.remarks=remarks == null ? remarks : remarks.trim();
	}

	public String getRemarks() {
		return remarks;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag=delFlag == null ? delFlag : delFlag.trim();
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setStatus(String status) {
		this.status=status == null ? status : status.trim();
	}

	public String getStatus() {
		return status;
	}

}
