package com.item.dao.model;



public class Right {

	private Integer id;

	private Integer parentId;

	private String name;

	private String code;

	private String icon;

	private String url;

	private String info;

	private Integer level;

	private Integer sortOrder;

	private java.util.Date createTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setParentId(Integer parentId) {
		this.parentId=parentId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setName(String name) {
		this.name=name == null ? name : name.trim();
	}

	public String getName() {
		return name;
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

	public void setUrl(String url) {
		this.url=url == null ? url : url.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setInfo(String info) {
		this.info=info == null ? info : info.trim();
	}

	public String getInfo() {
		return info;
	}

	public void setLevel(Integer level) {
		this.level=level;
	}

	public Integer getLevel() {
		return level;
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
