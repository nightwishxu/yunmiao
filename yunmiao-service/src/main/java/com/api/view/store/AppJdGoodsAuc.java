package com.api.view.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 绝当商城竞拍列表
 */
@ApiModel
public class AppJdGoodsAuc {
    @ApiModelProperty(value="商品id")
    private Integer id;
    @ApiModelProperty(value="商品封面")
    private String goodsImg;
    @ApiModelProperty(value="商品封面")
    private String title;
    @ApiModelProperty(value="鉴定价")
    private String authPrice;
    @ApiModelProperty(value="起价")
    private String price;
    @ApiModelProperty(value="当前价")
    private String maxPirce;
    @ApiModelProperty(value="我的出价")
    private String myPrice;
    @ApiModelProperty(value="时间")
    private String time;
    @ApiModelProperty(value="状态 2已中标 3未中标")
    private Integer state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getMaxPirce() {
        return maxPirce;
    }

    public void setMaxPirce(String maxPirce) {
        this.maxPirce = maxPirce;
    }

    public String getMyPrice() {
        return myPrice;
    }

    public void setMyPrice(String myPrice) {
        this.myPrice = myPrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
