package com.api.view.orgDeadPawnage;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/11/8.
 */
public class OrgAuctionDetail {

    @ApiModelProperty("典当表id")
    private String pawnId;

    @ApiModelProperty("绝当品id")
    private String goodsId;

    @ApiModelProperty("绝当品名称")
    private String goodsName;

    @ApiModelProperty("当品图片")
    private String images;

    @ApiModelProperty("起拍价")
    private String startingPrice;

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

    public String getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(String startingPrice) {
        this.startingPrice = startingPrice;
    }
}
