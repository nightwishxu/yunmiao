package com.api.view.orgRedeem;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/9/26.
 */
@ApiModel
public class RedeemDetail extends RedeemMini{

    @ApiModelProperty("当户id")
    private String collecterId;

    @ApiModelProperty("当户名")
    private String pawnerName;

    @ApiModelProperty("当户电话")
    private String pawnerTelNum;

    @ApiModelProperty("当户地址 如果地址为空字符串，则不显示出来")
    private String pawnerAddress;

/*    @ApiModelProperty("综合利率，费率")
    private String rate;*/

    @ApiModelProperty("赎当利率(利息利率)")
    private String moneyRate;

    @ApiModelProperty("逾期滞纳利率")
    private String redeemOverRate;

    @ApiModelProperty("贷款开始日期")
    private String loanBeginTime;

    @ApiModelProperty("当前应还款日期")
    private String loanCurrentEndTime;

    @ApiModelProperty("本金")
    private String loanMoney;

/*    @ApiModelProperty("综合利息")
    private String cost;*/

    @ApiModelProperty("赎当利息")
    private String moneyCost;

    @ApiModelProperty("逾期滞纳金")
    private String redeemOverdue;

    @ApiModelProperty("到期应还款额度")
    private String payBack;

    @ApiModelProperty("收款账户持卡人姓名")
    private String bankCardUserName;

    @ApiModelProperty("收款银行名称")
    private String bankCardName;

    @ApiModelProperty("收款银行卡号")
    private String bankCardCode;

    @ApiModelProperty("本次支付凭证")
    private String currentPayTicket;

    @ApiModelProperty("机构是否确认本次赎当  1-已确认收款 0-否 该字段用于控制赎当详情页面下面的确认按钮，其值为0，显示确认按钮，为1隐藏确认按钮")
    private String isConfirmed;

    @ApiModelProperty("是否已经缴纳 0-否 1-已缴")
    private String isPay;


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

    public String getRedeemOverRate() {
        return redeemOverRate;
    }

    public void setRedeemOverRate(String redeemOverRate) {
        this.redeemOverRate = redeemOverRate;
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

    public String getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(String isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }
}
