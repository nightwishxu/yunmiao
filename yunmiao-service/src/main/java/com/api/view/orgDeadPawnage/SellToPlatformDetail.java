package com.api.view.orgDeadPawnage;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by Lee on 2017/11/13.
 */
public class SellToPlatformDetail {

    @ApiModelProperty("典当表id")
    private String pawnId;

    @ApiModelProperty("绝当品id")
    private String goodsId;

    @ApiModelProperty("绝当品名称")
    private String goodsName;

    @ApiModelProperty("当品图片")
    private String images;

    @ApiModelProperty("鉴定价")
    private String authPrice;

    @ApiModelProperty("平台收购价")
    private String purchasingPrice;

    @ApiModelProperty("收款账号")
    private List<MyBankCard> payAccounts;

    public String getPawnId() {
        return pawnId;
    }

    public void setPawnId(String pawnId) {
        this.pawnId = pawnId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(String authPrice) {
        this.authPrice = authPrice;
    }

    public String getPurchasingPrice() {
        return purchasingPrice;
    }

    public void setPurchasingPrice(String purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public List<MyBankCard> getPayAccounts() {
        return payAccounts;
    }

    public void setPayAccounts(List<MyBankCard> payAccounts) {
        this.payAccounts = payAccounts;
    }
}
