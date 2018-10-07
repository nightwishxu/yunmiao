package com.api.view.store;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 拍档商城商品详情
 * @author vonkira
 *
 */
@ApiModel
public class AppStoreGoodsDetail {

	@ApiModelProperty(value="商品id")
	private Integer id;
	@ApiModelProperty(value="商品封面")
	private String img;
	@ApiModelProperty(value="商品图片")
	private String images;
	@ApiModelProperty(value="商品图片宽度")
	private String width;
	@ApiModelProperty(value="商品图片长度")
	private String height;
	@ApiModelProperty(value="商品名称")
	private String title;
	@ApiModelProperty(value="商品名称--绝当品")
	private String property;
	@ApiModelProperty(value="鉴定价格")
	private String authPrice;
	@ApiModelProperty(value="当前售价")
	private String price;
	@ApiModelProperty(value="市场预估文本")
	private String description;
	@ApiModelProperty(value="商品描述")
	private String goodsDescription;
	
	@ApiModelProperty(value="收货地址code")
	private Integer addressCode;
	@ApiModelProperty(value="购买声明")
	private String declare;
	@ApiModelProperty(value=" 优惠券减免金额")
	private String couponPrice;
	@ApiModelProperty(value="支付方式(1:支付宝  2;微信)")
	private Integer payType;
	@ApiModelProperty(value="竞拍次数")
	private Integer count;
	@ApiModelProperty(value="是否是竞拍商品  0不是  1是")
	private Integer type;
	@ApiModelProperty(value="机构id")
	private Integer orgId;
	@ApiModelProperty(value="机构名称")
	private String orgName;
	@ApiModelProperty(value="机构简介")
	private String orgIntroduction;
	@ApiModelProperty(value="机构logo")
	private String orgLogo;
	@ApiModelProperty(value="商品来源2机构3服务商4供应商")
	private Integer source;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getAuthPrice() {
		return authPrice;
	}

	public void setAuthPrice(String authPrice) {
		this.authPrice = authPrice;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGoodsDescription() {
		return goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	public Integer getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(Integer addressCode) {
		this.addressCode = addressCode;
	}

	public String getDeclare() {
		return declare;
	}

	public void setDeclare(String declare) {
		this.declare = declare;
	}

	public String getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(String couponPrice) {
		this.couponPrice = couponPrice;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgIntroduction() {
		return orgIntroduction;
	}

	public void setOrgIntroduction(String orgIntroduction) {
		this.orgIntroduction = orgIntroduction;
	}

	public String getOrgLogo() {
		return orgLogo;
	}

	public void setOrgLogo(String orgLogo) {
		this.orgLogo = orgLogo;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}
}
