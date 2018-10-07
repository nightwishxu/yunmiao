package com.api.view.orgAuctionPawn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/10/13.
 *
 * 竞拍详情里的出价记录
 */
@ApiModel
public class BidRecord {

    @ApiModelProperty("竞拍表主键id，代表某个机构的某一次竞拍行为，用户端若选择了中标机构，只要把该机构此次竞拍的auctionId返回给机构端即可")
    private String auctionId;

    @ApiModelProperty("竞拍机构名称，机构端APP需用*隐藏真正名称")
    private String orgName;

    @ApiModelProperty("竞拍机构id")
    private String orgId;

    @ApiModelProperty("该机构提供的贷款金额")
    private String money;

    @ApiModelProperty("利率，该机构最新出价的利率")
    private String moneyRate;

    @ApiModelProperty("综合费率，该机构最新出价的综合费率")
    private String rate;

    @ApiModelProperty("出价时间，yyyy-MM-dd HH:mm:ss")
    private String time;


    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getMoneyRate() {
        return moneyRate;
    }

    public void setMoneyRate(String moneyRate) {
        this.moneyRate = moneyRate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
