package com.api.view.orgHome.deadPawnAuction;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/11/30.
 *
 * 绝当拍卖-去邮寄-填写物流信息页面model
 */
public class ToSendPageDetail {

    @ApiModelProperty("当户（中标人）姓名")
    private String name;
    @ApiModelProperty("当户（中标人）电话")
    private String telphone;
    @ApiModelProperty("当户（中标人）地址")
    private String address;
    @ApiModelProperty("绝当/商品图片")
    private String picture;
    @ApiModelProperty("绝当/商品名称")
    private String goodsName;
    @ApiModelProperty("物流公司")
    private String expressCompany;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }
}
