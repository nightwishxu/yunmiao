package com.item.dao.model;

public class SinglePage {
	private String code;
	private String content;
	private String remark;
	private Integer sortOrder;
	private Integer isShow;

	public void setCode(String code) {
		this.code=code == null ? code : code.trim();
	}

	public String getCode() {
		return code;
	}

	public void setContent(String content) {
		this.content=content == null ? content : content.trim();
	}

	public String getContent() {
		return content;
	}

	public void setRemark(String remark) {
		this.remark=remark == null ? remark : remark.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder=sortOrder;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setIsShow(Integer isShow) {
		this.isShow=isShow;
	}

	public Integer getIsShow() {
		return isShow;
	}

}
