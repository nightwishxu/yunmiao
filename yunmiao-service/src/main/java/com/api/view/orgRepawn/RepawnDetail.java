package com.api.view.orgRepawn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/9/25.
 *
 * 续当详情返回model
 */
@ApiModel
public class RepawnDetail extends RepawnMini {


    @ApiModelProperty("当户id")
    private String collecterId;

    @ApiModelProperty("当户名")
    private String pawnerName;

    @ApiModelProperty("当户电话")
    private String pawnerTelNum;

    @ApiModelProperty("当户地址 如果地址为空字符串，则不显示出来")
    private String pawnerAddress;

    @ApiModelProperty("综合利率")
    private String rate;

    @ApiModelProperty("首期综合费 典当处理页面的本期综合费字段")
    private String firstCost;

    @ApiModelProperty("赎当利率")
    private String moneyRate;

/*    @ApiModelProperty("赎当利息")
    private String moneyCost;*/

    @ApiModelProperty("贷款开始日期")
    private String loanBeginTime;

    @ApiModelProperty("当前应还款日期")
    private String loanCurrentRepayTime;

    @ApiModelProperty("到期应还款金额:本金+上期利息+ 滞纳金（若逾期，否则为0）")
    private String payBack;

    @ApiModelProperty("本期综合费 用于续当处理页面")
    private String cost;

    @ApiModelProperty("上期利息费")
    private String preInterest;

    @ApiModelProperty("逾期滞纳利率")
    private String demurrageRate;

    @ApiModelProperty("逾期费")
    private String demurrage;

    @ApiModelProperty("续当费用：用于续当处理页面，本期综合费（本期指准备续当的那个当期）+上期利息+逾期滞纳金（若逾期，否则为0）")
    private String repawnMoney;

    @ApiModelProperty("收款账户持卡人姓名")
    private String bankCardUserName;

    @ApiModelProperty("收款银行名称")
    private String bankCardName;

    @ApiModelProperty("收款银行卡号")
    private String bankCardCode;

    @ApiModelProperty("本次支付凭证")
    private String currentPayTicket;

    @ApiModelProperty("是否已经缴纳本期综合费 0-否 1-已缴")
    private String isPayFirst;

    @ApiModelProperty("是否已经缴纳续当费 0-否 1-已缴")
    private String isPayRepawnMoney;

    @ApiModelProperty("是否已经缴纳平台利息 0-否 1-已缴")
    private String isPayPlatMoney;


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

    public String getPreInterest() {
        return preInterest;
    }

    public void setPreInterest(String preInterest) {
        this.preInterest = preInterest;
    }

    public String getDemurrageRate() {
        return demurrageRate;
    }

    public void setDemurrageRate(String demurrageRate) {
        this.demurrageRate = demurrageRate;
    }

    public String getDemurrage() {
        return demurrage;
    }

    public void setDemurrage(String demurrage) {
        this.demurrage = demurrage;
    }

    public String getRepawnMoney() {
        return repawnMoney;
    }

    public void setRepawnMoney(String repawnMoney) {
        this.repawnMoney = repawnMoney;
    }

    public String getBankCardUserName() {
        return bankCardUserName;
    }

    public void setBankCardUserName(String bankCardUserName) {
        this.bankCardUserName = bankCardUserName;
    }

    public String getBankCardName() {
        return bankCardName;
    }

    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName;
    }

    public String getBankCardCode() {
        return bankCardCode;
    }

    public void setBankCardCode(String bankCardCode) {
        this.bankCardCode = bankCardCode;
    }

    public String getCurrentPayTicket() {
        return currentPayTicket;
    }

    public void setCurrentPayTicket(String currentPayTicket) {
        this.currentPayTicket = currentPayTicket;
    }

    public String getIsPayFirst() {
        return isPayFirst;
    }

    public void setIsPayFirst(String isPayFirst) {
        this.isPayFirst = isPayFirst;
    }

    public String getIsPayRepawnMoney() {
        return isPayRepawnMoney;
    }

    public void setIsPayRepawnMoney(String isPayRepawnMoney) {
        this.isPayRepawnMoney = isPayRepawnMoney;
    }

    public String getIsPayPlatMoney() {
        return isPayPlatMoney;
    }

    public void setIsPayPlatMoney(String isPayPlatMoney) {
        this.isPayPlatMoney = isPayPlatMoney;
    }
}
