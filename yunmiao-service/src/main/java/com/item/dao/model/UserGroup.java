package com.item.dao.model;



public class UserGroup {

	private Integer id;

	private Integer parentId;

	private String code;

	private String name;

	private String info;

	private String url;

	private String className;

	private Integer level;

	private java.util.Date modifyTime;

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

	public void setCode(String code) {
		this.code=code == null ? code : code.trim();
	}

	public String getCode() {
		return code;
	}

	public void setName(String name) {
		this.name=name == null ? name : name.trim();
	}

	public String getName() {
		return name;
	}

	public void setInfo(String info) {
		this.info=info == null ? info : info.trim();
	}

	public String getInfo() {
		return info;
	}

	public void setUrl(String url) {
		this.url=url == null ? url : url.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setClassName(String className) {
		this.className=className == null ? className : className.trim();
	}

	public String getClassName() {
		return className;
	}

	public void setLevel(Integer level) {
		this.level=level;
	}

	public Integer getLevel() {
		return level;
	}

	public void setModifyTime(java.util.Date modifyTime) {
		this.modifyTime=modifyTime;
	}

	public java.util.Date getModifyTime() {
		return modifyTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
