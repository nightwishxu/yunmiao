package com.api.view.orgHome.myPawners;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/10/19.
 * 我的当户下  当户和当品  当品列表每个元素 返回model
 */
@ApiModel
public class PawnedMini {
    @ApiModelProperty("典当id")
    private String id;

    @ApiModelProperty("当品名称")
    private String title;

    @ApiModelProperty("当品图片")
    private String image;

    @ApiModelProperty("当号")
    private String pawnTicketCode;

    @ApiModelProperty("鉴定价")
    private String authPrice;

    @ApiModelProperty("已贷额度")
    private String loanMoney;

    @ApiModelProperty("当品典当状态 0-正常，当品处于约定典当期限之内，页面显示【到期剩余：days】 1-已逾期，还未绝当 页面显示【已逾期：days】 2-已绝当 页面显示【已绝当】")
    private String pawnState;

    @ApiModelProperty("该当品典当交易到期天数或逾期天数")
    private String days;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPawnTicketCode() {
        return pawnTicketCode;
    }

    public void setPawnTicketCode(String pawnTicketCode) {
        this.pawnTicketCode = pawnTicketCode;
    }

    public String getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(String authPrice) {
        this.authPrice = authPrice;
    }

    public String getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(String loanMoney) {
        this.loanMoney = loanMoney;
    }

    public String getPawnState() {
        return pawnState;
    }

    public void setPawnState(String pawnState) {
        this.pawnState = pawnState;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
