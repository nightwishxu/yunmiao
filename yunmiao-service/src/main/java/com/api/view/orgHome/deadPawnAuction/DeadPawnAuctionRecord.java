package com.api.view.orgHome.deadPawnAuction;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/11/30.
 */
public class DeadPawnAuctionRecord {

    @ApiModelProperty("竞拍人名称")
    private String bidderName;

    @ApiModelProperty("出价")
    private String bidPrice;

    @ApiModelProperty("出价时间")
    private String bidTime;

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getBidTime() {
        return bidTime;
    }

    public void setBidTime(String bidTime) {
        this.bidTime = bidTime;
    }
}
