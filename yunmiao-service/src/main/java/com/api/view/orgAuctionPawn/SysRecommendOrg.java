package com.api.view.orgAuctionPawn;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/11/8.
 */
public class SysRecommendOrg {

    @ApiModelProperty("竞拍表主键id，代表某个机构的某一次竞拍行为，用户端若选择中标机构，只要选择对应的auctionId返回给机构端即可")
    private String auctionId;
    @ApiModelProperty("贷款金额")
    private String money;
    @ApiModelProperty("系统推荐中标机构id")
    private String orgId;
    @ApiModelProperty("系统推荐中标机构名称")
    private String auctionOrgname;
    @ApiModelProperty("中标综合费率")
    private String rate;
    @ApiModelProperty("中标利率")
    private String moneyRate;
    @ApiModelProperty("主键")
    private String id;


    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAuctionOrgname() {
        return auctionOrgname;
    }

    public void setAuctionOrgname(String auctionOrgname) {
        this.auctionOrgname = auctionOrgname;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
