package com.api.view.orgRedeem;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/12/4.
 *
 * 点击 【缴纳平台利息】弹窗
 */
public class PlatformInterestInfo {

    @ApiModelProperty("平台利率")
    private String platformRate;

    @ApiModelProperty("利息")
    private String interest;

    public String getPlatformRate() {
        return platformRate;
    }

    public void setPlatformRate(String platformRate) {
        this.platformRate = platformRate;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
