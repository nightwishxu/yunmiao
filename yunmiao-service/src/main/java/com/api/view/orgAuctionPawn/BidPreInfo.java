package com.api.view.orgAuctionPawn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/10/16.
 * 对某一当品竞拍次数 和 上一次出价利率
 */
@ApiModel
public class BidPreInfo {

    @ApiModelProperty(" 上一次竞拍出价价格")
    private String money;

    @ApiModelProperty(" 上一次竞拍出价费率")
    private String rate;

    @ApiModelProperty(" 上一次竞拍出价利率")
    private String moneyRate;

    @ApiModelProperty("我（登陆的机构）之前竞拍次数")
    private String times;

    @ApiModelProperty("宝祥综合费率")
    private String bxRate;

    @ApiModelProperty("宝祥利息利率")
    private String bxMoneyRate;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getMoneyRate() {
        return moneyRate;
    }

    public void setMoneyRate(String moneyRate) {
        this.moneyRate = moneyRate;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getBxRate() {
        return bxRate;
    }

    public void setBxRate(String bxRate) {
        this.bxRate = bxRate;
    }

    public String getBxMoneyRate() {
        return bxMoneyRate;
    }

    public void setBxMoneyRate(String bxMoneyRate) {
        this.bxMoneyRate = bxMoneyRate;
    }
}
