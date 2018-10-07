package com.paidang.dao.model;



/**
 *
 */
public class OrgMessageType {

	/**
	 *
	 */
	private Integer id;

	/**
	 *消息类型名称
	 */
	private String typeName;

	/**
	 *类型图片
	 */
	private String typePic;

	/**
	 *
	 */
	private java.util.Date createTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setTypeName(String typeName) {
		this.typeName=typeName == null ? typeName : typeName.trim();
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypePic(String typePic) {
		this.typePic=typePic == null ? typePic : typePic.trim();
	}

	public String getTypePic() {
		return typePic;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

}
