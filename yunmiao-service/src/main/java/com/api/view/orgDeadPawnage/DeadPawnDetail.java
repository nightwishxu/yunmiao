package com.api.view.orgDeadPawnage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/9/26.
 */
@ApiModel
public class DeadPawnDetail extends DeadPawnMini {

    @ApiModelProperty("当户id")
    private String collecterId;

    @ApiModelProperty("当户名")
    private String pawnerName;

    @ApiModelProperty("当户电话")
    private String pawnerTelNum;

    @ApiModelProperty("当户地址 如果地址为空字符串，则不显示出来")
    private String pawnerAddress;

    @ApiModelProperty("综合利率，费率")
    private String rate;

    @ApiModelProperty("利率")
    private String moneyRate;

    @ApiModelProperty("逾期滞纳利率")
    private String redeemOverRate ;

    @ApiModelProperty("贷款开始日期")
    private String loanBeginTime;

    @ApiModelProperty("当前应还款日期")
    private String loanCurrentEndTime;

    @ApiModelProperty("本金")
    private String loanMoney;

    /*@ApiModelProperty("综合费")
    private String cost;*/

    @ApiModelProperty("赎当利息")
    private String moneyCost;

    @ApiModelProperty("逾期滞纳金")
    private String redeemOverdue;

    @ApiModelProperty("到期应还款额度")
    private String payBack;

    @ApiModelProperty("是否显示【平台拍卖】按钮 0-不显示 1-显示")
    private String auctionButton;

    @ApiModelProperty("是否显示【卖给平台】按钮 0-不显示 1-显示")
    private String sellButton;

    @ApiModelProperty("是否显示【取回按钮】按钮 0-不显示 1-显示")
    private String fectchBackButton;


    public String getCollecterId() {
        return collecterId;
    }

    public void setCollecterId(String collecterId) {
        this.collecterId = collecterId;
    }

    public String getPawnerName() {
        return pawnerName;
    }

    public void setPawnerName(String pawnerName) {
        this.pawnerName = pawnerName;
    }

    public String getPawnerTelNum() {
        return pawnerTelNum;
    }

    public void setPawnerTelNum(String pawnerTelNum) {
        this.pawnerTelNum = pawnerTelNum;
    }

    public String getPawnerAddress() {
        return pawnerAddress;
    }

    public void setPawnerAddress(String pawnerAddress) {
        this.pawnerAddress = pawnerAddress;
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

    public String getRedeemOverRate() {
        return redeemOverRate;
    }

    public void setRedeemOverRate(String redeemOverRate) {
        this.redeemOverRate = redeemOverRate;
    }

    public String getLoanBeginTime() {
        return loanBeginTime;
    }

    public void setLoanBeginTime(String loanBeginTime) {
        this.loanBeginTime = loanBeginTime;
    }

    public String getLoanCurrentEndTime() {
        return loanCurrentEndTime;
    }

    public void setLoanCurrentEndTime(String loanCurrentEndTime) {
        this.loanCurrentEndTime = loanCurrentEndTime;
    }

    public String getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(String loanMoney) {
        this.loanMoney = loanMoney;
    }

    public String getMoneyCost() {
        return moneyCost;
    }

    public void setMoneyCost(String moneyCost) {
        this.moneyCost = moneyCost;
    }

    public String getRedeemOverdue() {
        return redeemOverdue;
    }

    public void setRedeemOverdue(String redeemOverdue) {
        this.redeemOverdue = redeemOverdue;
    }

    public String getPayBack() {
        return payBack;
    }

    public void setPayBack(String payBack) {
        this.payBack = payBack;
    }

    public String getAuctionButton() {
        return auctionButton;
    }

    public void setAuctionButton(String auctionButton) {
        this.auctionButton = auctionButton;
    }

    public String getSellButton() {
        return sellButton;
    }

    public void setSellButton(String sellButton) {
        this.sellButton = sellButton;
    }

    public String getFectchBackButton() {
        return fectchBackButton;
    }

    public void setFectchBackButton(String fectchBackButton) {
        this.fectchBackButton = fectchBackButton;
    }
}
