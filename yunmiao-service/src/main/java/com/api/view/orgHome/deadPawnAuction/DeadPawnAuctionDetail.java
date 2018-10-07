package com.api.view.orgHome.deadPawnAuction;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by Lee on 2017/11/9.
 */
public class DeadPawnAuctionDetail extends DeadPawnAuctionMini {

    @ApiModelProperty("绝当竞拍记录")
    private List<DeadPawnAuctionRecord> records;

    @ApiModelProperty("绝当品图片")
    private String images;

    @ApiModelProperty("物品描述")
    private String goodsDescription;

    public List<DeadPawnAuctionRecord> getRecords() {
        return records;
    }

    public void setRecords(List<DeadPawnAuctionRecord> records) {
        this.records = records;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }
}
