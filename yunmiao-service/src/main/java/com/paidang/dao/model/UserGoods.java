package com.paidang.dao.model;



/**
 *
 */
public class UserGoods {

	/**
	 *
	 */
	private Integer id;

	/**
	 *用户id
	 */
	private Integer userId;

	/**
	 *所有人id
	 */
	private Integer belongId;

	/**
	 *所属类型0平台1用户2机构
	 */
	private Integer belongType;

	/**
	 *名称
	 */
	private String name;

	/**
	 *宝贝图片
	 */
	private String images;

	/**
	 *宝贝附件照
	 */
	private String goodsImgs;

	/**
	 *宝贝视频
	 */
	private String video;

	/**
	 *购买时间
	 */
	private java.util.Date buyTime;

	/**
	 *购买价格
	 */
	private java.math.BigDecimal buyPrice;

	/**
	 *宝贝备注
	 */
	private String info;

	/**
	 *宝贝属性(json[{name:'',content:'',contentType:1}])
contentType:1普通2时间3图片4视频
	 */
	private String content;

	/**
	 *所在城市
	 */
	private String city;

	/**
	 *藏友姓名
	 */
	private String userName;

	/**
	 *手机号码
	 */
	private String userPhone;

	/**
	 *鉴定要求
	 */
	private String authenticateRequire;

	/**
	 *鉴定类别id
	 */
	private Integer cateId;

	/**
	 *
	 */
	private String cateCode;

	/**
	 *鉴定结果(-1:无0:未鉴定 1:鉴定中 2:无法鉴定 3:赝品 4:真品)
	 */
	private Integer authResult;

	/**
	 *估价
	 */
	private java.math.BigDecimal authPriceTest;

	/**
	 *鉴定价
	 */
	private java.math.BigDecimal authPrice;

	/**
	 *取回时，平台拍摄的图片
	 */
	private String backImages;

	/**
	 *取回时，平台拍摄的视频
	 */
	private String backVideo;

	/**
	 *平台收货时拆箱视频
	 */
	private String openGoodsVideo;

	/**
	 *平台收获视频
	 */
	private String platGoodsReceiveVideo;

	/**
	 *平台鉴定视频
	 */
	private String platGoodsAuthVideo;

	/**
	 *平台拒绝理由
	 */
	private String notVerifyReason;

	/**
	 *拍摄去邮寄的宝贝视频
	 */
	private String goVideo;

	/**
	 *是否去典当0否  1是
	 */
	private Integer gotoPawn;

	/**
	 *0无1申请卖给平台2已卖出
	 */
	private Integer goSell;

	/**
	 *0用户1平台
	 */
	private Integer location;

	/**
	 *1未邮寄2邮寄中3平台确认4已经到货
	 */
	private Integer postState;

	/**
	 *寄件人
	 */
	private String postUserName;

	/**
	 *寄件人电话
	 */
	private String postUserPhone;

	/**
	 *寄件快递
	 */
	private String postExpress;

	/**
	 *寄件单号
	 */
	private String postExpressCode;

	/**
	 *收件人
	 */
	private String backUserName;

	/**
	 *收件人电话
	 */
	private String backUserPhone;

	/**
	 *收件人地址
	 */
	private String backUserExpress;

	/**
	 *收件人快递
	 */
	private String backExpress;

	/**
	 *收件人快递单号
	 */
	private String backExpressCode;

	/**
	 *0默认1申请取回2取回中3确认收货
	 */
	private Integer backState;

	/**
	 *
	 */
	private java.util.Date createTime;

	/**
	 *
	 */
	private java.util.Date modifyTime;

	/**
	 *1上架0下架
	 */
	private Integer isOnline;

	/**
	 *综合利率(%)
	 */
	private java.math.BigDecimal rate;

	/**
	 *利息利率(%)
	 */
	private java.math.BigDecimal moneyRate;

	/**
	 *平台(平台发送机构)
	 */
	private String platUserName;

	/**
	 *平台发货人
	 */
	private String platUserPhone;

	/**
	 *平台地址
	 */
	private String platUserAddress;

	/**
	 *机构收件人名称
	 */
	private String orgUserName;

	/**
	 *机构收件人地址
	 */
	private String orgUserAddress;

	/**
	 *机构收件人联系电话
	 */
	private String orgUserPhone;

	/**
	 *机构取回的状态(0默认1申请取回2取回中3确认收货)
	 */
	private Integer platOrgState;

	/**
	 *机构取回，平台所拍摄的装箱视频
	 */
	private String platOrgVideo;

	/**
	 *机构取回时 0未确认 1确认宝贝完好
	 */
	private Integer platOrgVerify;

	/**
	 *机构取回时的快递单号
	 */
	private String platOrgExpressCode;

	/**
	 *宝贝绝当时间
	 */
	private java.util.Date platOrgTime;

	/**
	 *鉴宝审核是否复审0:否 1有
	 */
	private Integer isVerify;

	/**
	 *专家意见表id
	 */
	private Integer experterInfoId;

	/**
	 *顺风保价
	 */
	private java.math.BigDecimal sfProtectPrice;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setBelongId(Integer belongId) {
		this.belongId=belongId;
	}

	public Integer getBelongId() {
		return belongId;
	}

	public void setBelongType(Integer belongType) {
		this.belongType=belongType;
	}

	public Integer getBelongType() {
		return belongType;
	}

	public void setName(String name) {
		this.name=name == null ? name : name.trim();
	}

	public String getName() {
		return name;
	}

	public void setImages(String images) {
		this.images=images == null ? images : images.trim();
	}

	public String getImages() {
		return images;
	}

	public void setGoodsImgs(String goodsImgs) {
		this.goodsImgs=goodsImgs == null ? goodsImgs : goodsImgs.trim();
	}

	public String getGoodsImgs() {
		return goodsImgs;
	}

	public void setVideo(String video) {
		this.video=video == null ? video : video.trim();
	}

	public String getVideo() {
		return video;
	}

	public void setBuyTime(java.util.Date buyTime) {
		this.buyTime=buyTime;
	}

	public java.util.Date getBuyTime() {
		return buyTime;
	}

	public void setBuyPrice(java.math.BigDecimal buyPrice) {
		this.buyPrice=buyPrice;
	}

	public java.math.BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setInfo(String info) {
		this.info=info == null ? info : info.trim();
	}

	public String getInfo() {
		return info;
	}

	public void setContent(String content) {
		this.content=content == null ? content : content.trim();
	}

	public String getContent() {
		return content;
	}

	public void setCity(String city) {
		this.city=city == null ? city : city.trim();
	}

	public String getCity() {
		return city;
	}

	public void setUserName(String userName) {
		this.userName=userName == null ? userName : userName.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone=userPhone == null ? userPhone : userPhone.trim();
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setAuthenticateRequire(String authenticateRequire) {
		this.authenticateRequire=authenticateRequire == null ? authenticateRequire : authenticateRequire.trim();
	}

	public String getAuthenticateRequire() {
		return authenticateRequire;
	}

	public void setCateId(Integer cateId) {
		this.cateId=cateId;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateCode(String cateCode) {
		this.cateCode=cateCode == null ? cateCode : cateCode.trim();
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setAuthResult(Integer authResult) {
		this.authResult=authResult;
	}

	public Integer getAuthResult() {
		return authResult;
	}

	public void setAuthPriceTest(java.math.BigDecimal authPriceTest) {
		this.authPriceTest=authPriceTest;
	}

	public java.math.BigDecimal getAuthPriceTest() {
		return authPriceTest;
	}

	public void setAuthPrice(java.math.BigDecimal authPrice) {
		this.authPrice=authPrice;
	}

	public java.math.BigDecimal getAuthPrice() {
		return authPrice;
	}

	public void setBackImages(String backImages) {
		this.backImages=backImages == null ? backImages : backImages.trim();
	}

	public String getBackImages() {
		return backImages;
	}

	public void setBackVideo(String backVideo) {
		this.backVideo=backVideo == null ? backVideo : backVideo.trim();
	}

	public String getBackVideo() {
		return backVideo;
	}

	public void setOpenGoodsVideo(String openGoodsVideo) {
		this.openGoodsVideo=openGoodsVideo == null ? openGoodsVideo : openGoodsVideo.trim();
	}

	public String getOpenGoodsVideo() {
		return openGoodsVideo;
	}

	public void setPlatGoodsReceiveVideo(String platGoodsReceiveVideo) {
		this.platGoodsReceiveVideo=platGoodsReceiveVideo == null ? platGoodsReceiveVideo : platGoodsReceiveVideo.trim();
	}

	public String getPlatGoodsReceiveVideo() {
		return platGoodsReceiveVideo;
	}

	public void setPlatGoodsAuthVideo(String platGoodsAuthVideo) {
		this.platGoodsAuthVideo=platGoodsAuthVideo == null ? platGoodsAuthVideo : platGoodsAuthVideo.trim();
	}

	public String getPlatGoodsAuthVideo() {
		return platGoodsAuthVideo;
	}

	public void setNotVerifyReason(String notVerifyReason) {
		this.notVerifyReason=notVerifyReason == null ? notVerifyReason : notVerifyReason.trim();
	}

	public String getNotVerifyReason() {
		return notVerifyReason;
	}

	public void setGoVideo(String goVideo) {
		this.goVideo=goVideo == null ? goVideo : goVideo.trim();
	}

	public String getGoVideo() {
		return goVideo;
	}

	public void setGotoPawn(Integer gotoPawn) {
		this.gotoPawn=gotoPawn;
	}

	public Integer getGotoPawn() {
		return gotoPawn;
	}

	public void setGoSell(Integer goSell) {
		this.goSell=goSell;
	}

	public Integer getGoSell() {
		return goSell;
	}

	public void setLocation(Integer location) {
		this.location=location;
	}

	public Integer getLocation() {
		return location;
	}

	public void setPostState(Integer postState) {
		this.postState=postState;
	}

	public Integer getPostState() {
		return postState;
	}

	public void setPostUserName(String postUserName) {
		this.postUserName=postUserName == null ? postUserName : postUserName.trim();
	}

	public String getPostUserName() {
		return postUserName;
	}

	public void setPostUserPhone(String postUserPhone) {
		this.postUserPhone=postUserPhone == null ? postUserPhone : postUserPhone.trim();
	}

	public String getPostUserPhone() {
		return postUserPhone;
	}

	public void setPostExpress(String postExpress) {
		this.postExpress=postExpress == null ? postExpress : postExpress.trim();
	}

	public String getPostExpress() {
		return postExpress;
	}

	public void setPostExpressCode(String postExpressCode) {
		this.postExpressCode=postExpressCode == null ? postExpressCode : postExpressCode.trim();
	}

	public String getPostExpressCode() {
		return postExpressCode;
	}

	public void setBackUserName(String backUserName) {
		this.backUserName=backUserName == null ? backUserName : backUserName.trim();
	}

	public String getBackUserName() {
		return backUserName;
	}

	public void setBackUserPhone(String backUserPhone) {
		this.backUserPhone=backUserPhone == null ? backUserPhone : backUserPhone.trim();
	}

	public String getBackUserPhone() {
		return backUserPhone;
	}

	public void setBackUserExpress(String backUserExpress) {
		this.backUserExpress=backUserExpress == null ? backUserExpress : backUserExpress.trim();
	}

	public String getBackUserExpress() {
		return backUserExpress;
	}

	public void setBackExpress(String backExpress) {
		this.backExpress=backExpress == null ? backExpress : backExpress.trim();
	}

	public String getBackExpress() {
		return backExpress;
	}

	public void setBackExpressCode(String backExpressCode) {
		this.backExpressCode=backExpressCode == null ? backExpressCode : backExpressCode.trim();
	}

	public String getBackExpressCode() {
		return backExpressCode;
	}

	public void setBackState(Integer backState) {
		this.backState=backState;
	}

	public Integer getBackState() {
		return backState;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setModifyTime(java.util.Date modifyTime) {
		this.modifyTime=modifyTime;
	}

	public java.util.Date getModifyTime() {
		return modifyTime;
	}

	public void setIsOnline(Integer isOnline) {
		this.isOnline=isOnline;
	}

	public Integer getIsOnline() {
		return isOnline;
	}

	public void setRate(java.math.BigDecimal rate) {
		this.rate=rate;
	}

	public java.math.BigDecimal getRate() {
		return rate;
	}

	public void setMoneyRate(java.math.BigDecimal moneyRate) {
		this.moneyRate=moneyRate;
	}

	public java.math.BigDecimal getMoneyRate() {
		return moneyRate;
	}

	public void setPlatUserName(String platUserName) {
		this.platUserName=platUserName == null ? platUserName : platUserName.trim();
	}

	public String getPlatUserName() {
		return platUserName;
	}

	public void setPlatUserPhone(String platUserPhone) {
		this.platUserPhone=platUserPhone == null ? platUserPhone : platUserPhone.trim();
	}

	public String getPlatUserPhone() {
		return platUserPhone;
	}

	public void setPlatUserAddress(String platUserAddress) {
		this.platUserAddress=platUserAddress == null ? platUserAddress : platUserAddress.trim();
	}

	public String getPlatUserAddress() {
		return platUserAddress;
	}

	public void setOrgUserName(String orgUserName) {
		this.orgUserName=orgUserName == null ? orgUserName : orgUserName.trim();
	}

	public String getOrgUserName() {
		return orgUserName;
	}

	public void setOrgUserAddress(String orgUserAddress) {
		this.orgUserAddress=orgUserAddress == null ? orgUserAddress : orgUserAddress.trim();
	}

	public String getOrgUserAddress() {
		return orgUserAddress;
	}

	public void setOrgUserPhone(String orgUserPhone) {
		this.orgUserPhone=orgUserPhone == null ? orgUserPhone : orgUserPhone.trim();
	}

	public String getOrgUserPhone() {
		return orgUserPhone;
	}

	public void setPlatOrgState(Integer platOrgState) {
		this.platOrgState=platOrgState;
	}

	public Integer getPlatOrgState() {
		return platOrgState;
	}

	public void setPlatOrgVideo(String platOrgVideo) {
		this.platOrgVideo=platOrgVideo == null ? platOrgVideo : platOrgVideo.trim();
	}

	public String getPlatOrgVideo() {
		return platOrgVideo;
	}

	public void setPlatOrgVerify(Integer platOrgVerify) {
		this.platOrgVerify=platOrgVerify;
	}

	public Integer getPlatOrgVerify() {
		return platOrgVerify;
	}

	public void setPlatOrgExpressCode(String platOrgExpressCode) {
		this.platOrgExpressCode=platOrgExpressCode == null ? platOrgExpressCode : platOrgExpressCode.trim();
	}

	public String getPlatOrgExpressCode() {
		return platOrgExpressCode;
	}

	public void setPlatOrgTime(java.util.Date platOrgTime) {
		this.platOrgTime=platOrgTime;
	}

	public java.util.Date getPlatOrgTime() {
		return platOrgTime;
	}

	public void setIsVerify(Integer isVerify) {
		this.isVerify=isVerify;
	}

	public Integer getIsVerify() {
		return isVerify;
	}

	public void setExperterInfoId(Integer experterInfoId) {
		this.experterInfoId=experterInfoId;
	}

	public Integer getExperterInfoId() {
		return experterInfoId;
	}

	public void setSfProtectPrice(java.math.BigDecimal sfProtectPrice) {
		this.sfProtectPrice=sfProtectPrice;
	}

	public java.math.BigDecimal getSfProtectPrice() {
		return sfProtectPrice;
	}

}
