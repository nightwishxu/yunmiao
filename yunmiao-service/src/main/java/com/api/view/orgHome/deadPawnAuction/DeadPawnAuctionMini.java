package com.api.view.orgHome.deadPawnAuction;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/11/9.
 */
public class DeadPawnAuctionMini {

    @ApiModelProperty("商品表id")
    private String goodsTableId;
/*
    @ApiModelProperty("典当id")
    private String pawnId;*/
    @ApiModelProperty("绝当/商品id，用户藏品表id")
    private String userGoodsId;
    @ApiModelProperty("绝当/商品名称")
    private String goodsName;
    @ApiModelProperty("绝当/商品封面图片")
    private String picture;
    @ApiModelProperty("鉴定价")
    private String authPrice;
    @ApiModelProperty("起拍价")
    private String startingPrice;
    @ApiModelProperty("当前价")
    private String currentPrice;
    @ApiModelProperty("倒计时")
    private String countdown;
    @ApiModelProperty("竞拍状态文字 0-不显示状态 1-竞拍中 2-已完成 3-无人竞拍")
    private String auctionState;
    @ApiModelProperty("按钮 0-不显示按钮 1-通知平台邮寄 2-去邮寄 3-缴纳平台利息")
    private String buttons;

/*    public String getPawnId() {
        return pawnId;
    }

    public void setPawnId(String pawnId) {
        this.pawnId = pawnId;
    }*/

    public String getGoodsTableId() {
        return goodsTableId;
    }

    public void setGoodsTableId(String goodsTableId) {
        this.goodsTableId = goodsTableId;
    }

    public String getUserGoodsId() {
        return userGoodsId;
    }

    public void setUserGoodsId(String userGoodsId) {
        this.userGoodsId = userGoodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(String authPrice) {
        this.authPrice = authPrice;
    }

    public String getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(String startingPrice) {
        this.startingPrice = startingPrice;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getCountdown() {
        return countdown;
    }

    public void setCountdown(String countdown) {
        this.countdown = countdown;
    }

    public String getAuctionState() {
        return auctionState;
    }

    public void setAuctionState(String auctionState) {
        this.auctionState = auctionState;
    }

    public String getButtons() {
        return buttons;
    }

    public void setButtons(String buttons) {
        this.buttons = buttons;
    }


}
