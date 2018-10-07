package com.api.view.orgHome.myPawners;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/9/25.
 *
 * 已经处于典当状态的当品
 * 我的当户 该当户下某当品 详情页 返回model
 */

@ApiModel
public class PawnedDetail extends PawnedMini{

    @ApiModelProperty("当户id")
    private String collecterId;

    @ApiModelProperty("当户名")
    private String pawnerName;

    @ApiModelProperty("当户电话")
    private String pawnerTelNum;

    @ApiModelProperty("当户地址")
    private String pawnerAddress;

    @ApiModelProperty("已发放当金")
    private String userMoney;

    @ApiModelProperty("综合利率")
    private String rate;

    @ApiModelProperty("综合利息(页面) 首期综合费")
    private String firstCost;

    @ApiModelProperty("赎当利率")
    private String moneyRate;

    @ApiModelProperty("利息（赎当利息）")
    private String moneyCost;

    @ApiModelProperty("贷款开始日期")
    private String loanBeginTime;

    @ApiModelProperty("当前应还款日期")
    private String loanCurrentRepayTime;

    @ApiModelProperty("到期应还款金额")
    private String payBack;

    @ApiModelProperty("已缴综合费(页面) 本期综合费")
    private String cost;

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

    public String getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(String userMoney) {
        this.userMoney = userMoney;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getFirstCost() {
        return firstCost;
    }

    public void setFirstCost(String firstCost) {
        this.firstCost = firstCost;
    }

    public String getMoneyRate() {
        return moneyRate;
    }

    public void setMoneyRate(String moneyRate) {
        this.moneyRate = moneyRate;
    }

    public String getMoneyCost() {
        return moneyCost;
    }

    public void setMoneyCost(String moneyCost) {
        this.moneyCost = moneyCost;
    }

    public String getLoanBeginTime() {
        return loanBeginTime;
    }

    public void setLoanBeginTime(String loanBeginTime) {
        this.loanBeginTime = loanBeginTime;
    }

    public String getLoanCurrentRepayTime() {
        return loanCurrentRepayTime;
    }

    public void setLoanCurrentRepayTime(String loanCurrentRepayTime) {
        this.loanCurrentRepayTime = loanCurrentRepayTime;
    }

    public String getPayBack() {
        return payBack;
    }

    public void setPayBack(String payBack) {
        this.payBack = payBack;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
