package com.item.daoEx.model;

import com.item.dao.model.ShopCart;

import java.math.BigDecimal;

/**
@author sun
*/
public class ShopCartEx extends ShopCart {
	//商品名称
    private String goodsName;
    //商品价格
    private BigDecimal goodsPrice;
    //商品图片
    private String goodsImg;
    //商品简介
    private String goodsInfo;
    //机构名称
    private String orgName;
    //机构logo
    private String orgLogo;
    //商品库存数量
    private Integer goodsTotal;

    //1上架0下架
    private  Integer isOnline;
    //商品规格
    private String spec;
    //商品来源  2典当3平台4供应商
    private Integer source;
    //是否使用优惠券0不能使用1能使用
    private Integer couponFlag;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo;
    }

    public Integer getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(Integer goodsTotal) {
        this.goodsTotal = goodsTotal;
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getCouponFlag() {
        if (source==3){
            return 1;
        }else {
            return 0;
        }

//        return couponFlag;
    }

    public void setCouponFlag(Integer couponFlag) {
        this.couponFlag = couponFlag;
    }
}