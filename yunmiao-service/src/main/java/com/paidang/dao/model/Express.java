package com.paidang.dao.model;



/**
 *
 */
public class Express {

	/**
	 *
	 */
	private Integer id;

	/**
	 *1用户2机构
	 */
	private Integer source;

	/**
	 *用户id/机构id
	 */
	private Integer sourceId;

	/**
	 *相关id(藏品或订单id）
	 */
	private Integer fid;

	/**
	 *1寄给平台2取回3商城4平台寄给当户5机构寄给当户6机构取回（绝当品）7用户退款回寄到平台(认证商场)
	 */
	private Integer type;

	/**
	 *快递公司
	 */
	private String expressName;

	/**
	 *快递单号
	 */
	private String expressCode;

	/**
	 *0：在途1：揽件2：疑难3：签收4：退签或异常签收5：派件6：退回
	 */
	private Integer expressState;

	/**
	 *物流数据
	 */
	private String expressData;

	/**
	 *寄件人
	 */
	private String postName;

	/**
	 *寄件人电话
	 */
	private String postPhone;

	/**
	 *收件人
	 */
	private String receiveName;

	/**
	 *收件人电话
	 */
	private String receivePhone;

	/**
	 *收件人地址
	 */
	private String receviceAddress;

	/**
	 *
	 */
	private java.util.Date modifyTime;

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

	public void setSource(Integer source) {
		this.source=source;
	}

	public Integer getSource() {
		return source;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId=sourceId;
	}

	public Integer getSourceId() {
		return sourceId;
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

	public void setExpressName(String expressName) {
		this.expressName=expressName == null ? expressName : expressName.trim();
	}

	public String getExpressName() {
		return expressName;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode=expressCode == null ? expressCode : expressCode.trim();
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressState(Integer expressState) {
		this.expressState=expressState;
	}

	public Integer getExpressState() {
		return expressState;
	}

	public void setExpressData(String expressData) {
		this.expressData=expressData == null ? expressData : expressData.trim();
	}

	public String getExpressData() {
		return expressData;
	}

	public void setPostName(String postName) {
		this.postName=postName == null ? postName : postName.trim();
	}

	public String getPostName() {
		return postName;
	}

	public void setPostPhone(String postPhone) {
		this.postPhone=postPhone == null ? postPhone : postPhone.trim();
	}

	public String getPostPhone() {
		return postPhone;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName=receiveName == null ? receiveName : receiveName.trim();
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceivePhone(String receivePhone) {
		this.receivePhone=receivePhone == null ? receivePhone : receivePhone.trim();
	}

	public String getReceivePhone() {
		return receivePhone;
	}

	public void setReceviceAddress(String receviceAddress) {
		this.receviceAddress=receviceAddress == null ? receviceAddress : receviceAddress.trim();
	}

	public String getReceviceAddress() {
		return receviceAddress;
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
