package com.paidang.daoEx.model;

import com.paidang.dao.model.Goods;

import java.math.BigDecimal;

/**
@author sun
*/
public class GoodsEx extends Goods {
    //分类名称
    private String cateName;
    //订单状态
    private String estate;
    //上架状态
    private String shelfDown;
    //出售价格
    private java.math.BigDecimal soldPrice;

    //订单号
    private String orderCode;
    //快递公司名称--顺风
    private String shipFirm;
    //快递单号
    private String shipCode;
    //我的出价
    private String myPrice;
    //机构名称
    private String orgName;
    //机构简介
    private String orgIntroduction;

    private String orgLogo;

    public BigDecimal getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(BigDecimal soldPrice) {
        this.soldPrice = soldPrice;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public String getShelfDown() {
        return shelfDown;
    }

    public void setShelfDown(String shelfDown) {
        this.shelfDown = shelfDown;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getShipFirm() {
        return shipFirm;
    }

    public void setShipFirm(String shipFirm) {
        this.shipFirm = shipFirm;
    }

    public String getShipCode() {
        return shipCode;
    }

    public void setShipCode(String shipCode) {
        this.shipCode = shipCode;
    }

    public String getMyPrice() {
        return myPrice;
    }

    public void setMyPrice(String myPrice) {
        this.myPrice = myPrice;
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
}