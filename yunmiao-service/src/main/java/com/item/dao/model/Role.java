package com.item.dao.model;



public class Role {

	private Integer id;

	private Integer groupId;

	private Integer parentId;

	private String name;

	private String code;

	private String info;

	private Integer state;

	private String rights;

	private Integer level;

	private java.util.Date modifyTime;

	private java.util.Date createTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setGroupId(Integer groupId) {
		this.groupId=groupId;
	}

	public Integer getGroupId() {
		return groupId;
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

	public void setInfo(String info) {
		this.info=info == null ? info : info.trim();
	}

	public String getInfo() {
		return info;
	}

	public void setState(Integer state) {
		this.state=state;
	}

	public Integer getState() {
		return state;
	}

	public void setRights(String rights) {
		this.rights=rights == null ? rights : rights.trim();
	}

	public String getRights() {
		return rights;
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
