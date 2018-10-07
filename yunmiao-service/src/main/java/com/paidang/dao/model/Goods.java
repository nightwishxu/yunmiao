package com.paidang.dao.model;



/**
 *
 */
public class Goods {

	/**
	 *
	 */
	private Integer id;

	/**
	 *1平台2机构3服务商
	 */
	private Integer source;

	/**
	 *1新品2绝当品
	 */
	private Integer type;

	/**
	 *分类code
	 */
	private Integer cateCode;

	/**
	 *机构id,默认0
	 */
	private Integer orgId;

	/**
	 *绝当品id（p_user_goods用户藏品表的主键id）
	 */
	private Integer goodsId;

	/**
	 *商品名称
	 */
	private String name;

	/**
	 *成本（当type=2绝当品，该字段表示该绝当品的起拍价）
	 */
	private java.math.BigDecimal cost;

	/**
	 *售价
	 */
	private java.math.BigDecimal price;

	/**
	 *库存
	 */
	private Integer total;

	/**
	 *已售
	 */
	private Integer soldOut;

	/**
	 *1上架0下架
	 */
	private Integer isOnline;

	/**
	 *1审核中2通过3不通过
	 */
	private Integer isVerfiy;

	/**
	 *图片
	 */
	private String imgs;

	/**
	 *商品封面
	 */
	private String img;

	/**
	 *封面宽度
	 */
	private String width;

	/**
	 *封面高度
	 */
	private String height;

	/**
	 *商品描述
	 */
	private String info;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

	/**
	 *更新时间
	 */
	private java.util.Date modifyTime;

	/**
	 *(针对竞拍)- 0已失效 1有效
	 */
	private Integer state;

	/**
	 *最新出价id
	 */
	private Integer maxAutionId;

	/**
	 *竞拍(最新出价)
	 */
	private java.math.BigDecimal maxAuction;

	/**
	 *中标人
	 */
	private Integer userId;

	/**
	 *平台服务费率
	 */
	private java.math.BigDecimal platformRate;

	/**
	 *平台服务费
	 */
	private java.math.BigDecimal platformMoney;

	/**
	 *0未缴纳1已缴纳平台服务费
	 */
	private Integer platformState;

	/**
	 *排序(倒序)
	 */
	private Integer sortOrder;

	/**
	 *是否设置为推荐 0不设置 1设置
	 */
	private Integer isSuggest;

	/**
	 *规格
	 */
	private String spec;

	/**
	 *审核不通过原因
	 */
	private String refuseInfo;

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

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getType() {
		return type;
	}

	public void setCateCode(Integer cateCode) {
		this.cateCode=cateCode;
	}

	public Integer getCateCode() {
		return cateCode;
	}

	public void setOrgId(Integer orgId) {
		this.orgId=orgId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId=goodsId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setName(String name) {
		this.name=name == null ? name : name.trim();
	}

	public String getName() {
		return name;
	}

	public void setCost(java.math.BigDecimal cost) {
		this.cost=cost;
	}

	public java.math.BigDecimal getCost() {
		return cost;
	}

	public void setPrice(java.math.BigDecimal price) {
		this.price=price;
	}

	public java.math.BigDecimal getPrice() {
		return price;
	}

	public void setTotal(Integer total) {
		this.total=total;
	}

	public Integer getTotal() {
		return total;
	}

	public void setSoldOut(Integer soldOut) {
		this.soldOut=soldOut;
	}

	public Integer getSoldOut() {
		return soldOut;
	}

	public void setIsOnline(Integer isOnline) {
		this.isOnline=isOnline;
	}

	public Integer getIsOnline() {
		return isOnline;
	}

	public void setIsVerfiy(Integer isVerfiy) {
		this.isVerfiy=isVerfiy;
	}

	public Integer getIsVerfiy() {
		return isVerfiy;
	}

	public void setImgs(String imgs) {
		this.imgs=imgs == null ? imgs : imgs.trim();
	}

	public String getImgs() {
		return imgs;
	}

	public void setImg(String img) {
		this.img=img == null ? img : img.trim();
	}

	public String getImg() {
		return img;
	}

	public void setWidth(String width) {
		this.width=width == null ? width : width.trim();
	}

	public String getWidth() {
		return width;
	}

	public void setHeight(String height) {
		this.height=height == null ? height : height.trim();
	}

	public String getHeight() {
		return height;
	}

	public void setInfo(String info) {
		this.info=info == null ? info : info.trim();
	}

	public String getInfo() {
		return info;
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

	public void setState(Integer state) {
		this.state=state;
	}

	public Integer getState() {
		return state;
	}

	public void setMaxAutionId(Integer maxAutionId) {
		this.maxAutionId=maxAutionId;
	}

	public Integer getMaxAutionId() {
		return maxAutionId;
	}

	public void setMaxAuction(java.math.BigDecimal maxAuction) {
		this.maxAuction=maxAuction;
	}

	public java.math.BigDecimal getMaxAuction() {
		return maxAuction;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setPlatformRate(java.math.BigDecimal platformRate) {
		this.platformRate=platformRate;
	}

	public java.math.BigDecimal getPlatformRate() {
		return platformRate;
	}

	public void setPlatformMoney(java.math.BigDecimal platformMoney) {
		this.platformMoney=platformMoney;
	}

	public java.math.BigDecimal getPlatformMoney() {
		return platformMoney;
	}

	public void setPlatformState(Integer platformState) {
		this.platformState=platformState;
	}

	public Integer getPlatformState() {
		return platformState;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder=sortOrder;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setIsSuggest(Integer isSuggest) {
		this.isSuggest=isSuggest;
	}

	public Integer getIsSuggest() {
		return isSuggest;
	}

	public void setSpec(String spec) {
		this.spec=spec == null ? spec : spec.trim();
	}

	public String getSpec() {
		return spec;
	}

	public void setRefuseInfo(String refuseInfo) {
		this.refuseInfo=refuseInfo == null ? refuseInfo : refuseInfo.trim();
	}

	public String getRefuseInfo() {
		return refuseInfo;
	}

}
