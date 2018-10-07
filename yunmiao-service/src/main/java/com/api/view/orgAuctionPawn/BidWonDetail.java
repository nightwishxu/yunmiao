package com.api.view.orgAuctionPawn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/9/25.
 *
 * 竞拍中标后详情页面返回model
 */
@ApiModel
public class BidWonDetail {

    @ApiModelProperty("典当id")
    private String pawnId;

    @ApiModelProperty("当品id")
    private String goodsId;

    @ApiModelProperty("当品名称")
    private String goodsName;

    @ApiModelProperty("当号")
    private String pawnTicketCode;

    @ApiModelProperty("鉴定价")
    private String authPrice;

    @ApiModelProperty("当品图片")
    private String images;

    @ApiModelProperty("当户名")
    private String pawnerName;

    @ApiModelProperty("当户电话")
    private String pawnerTelNum;

    @ApiModelProperty("收款人")
    private String payeeName;

    @ApiModelProperty("当户收款银行名称")
    private String pawnerBankName;

    @ApiModelProperty("当户收款银行账户")
    private String pawnerBankCardCode;

    @ApiModelProperty("当户地址")
    private String pawnerAddress;

    @ApiModelProperty("当户期望金额")
    private String collecterMoney;

    @ApiModelProperty("当户期望利率")
    private String collecterRate;

    @ApiModelProperty("贷款开始时间")
    private String loanBeginTime;

    @ApiModelProperty("贷款结束时间")
    private String loanEndTime;

    @ApiModelProperty("贷款额度")
    private String loanAmount;

    @ApiModelProperty("综合利率")
    private String rate;

    @ApiModelProperty("综合费")
    private String cost;

    @ApiModelProperty("赎当利率")
    private String moneyRate;

    @ApiModelProperty("赎当利息")
    private String moneyCost;

    @ApiModelProperty("是否已支付典当款 0-否  1-已经支付")
    private String isPay;

    @ApiModelProperty("本次拍当是否已失效（中标后1小时内未支付贷款）0-已失效 1-有效")
    private String isInvalid;

    public String getPawnId() {
        return pawnId;
    }

    public void setPawnId(String pawnId) {
        this.pawnId = pawnId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPawnTicketCode() {
        return pawnTicketCode;
    }

    public void setPawnTicketCode(String pawnTicketCode) {
        this.pawnTicketCode = pawnTicketCode;
    }

    public String getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(String authPrice) {
        this.authPrice = authPrice;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
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

    public String getPawnerBankName() {
        return pawnerBankName;
    }

    public void setPawnerBankName(String pawnerBankName) {
        this.pawnerBankName = pawnerBankName;
    }

    public String getPawnerBankCardCode() {
        return pawnerBankCardCode;
    }

    public void setPawnerBankCardCode(String pawnerBankCardCode) {
        this.pawnerBankCardCode = pawnerBankCardCode;
    }

    public String getPawnerAddress() {
        return pawnerAddress;
    }

    public void setPawnerAddress(String pawnerAddress) {
        this.pawnerAddress = pawnerAddress;
    }

    public String getCollecterMoney() {
        return collecterMoney;
    }

    public void setCollecterMoney(String collecterMoney) {
        this.collecterMoney = collecterMoney;
    }

    public String getCollecterRate() {
        return collecterRate;
    }

    public void setCollecterRate(String collecterRate) {
        this.collecterRate = collecterRate;
    }

    public String getLoanBeginTime() {
        return loanBeginTime;
    }

    public void setLoanBeginTime(String loanBeginTime) {
        this.loanBeginTime = loanBeginTime;
    }

    public String getLoanEndTime() {
        return loanEndTime;
    }

    public void setLoanEndTime(String loanEndTime) {
        this.loanEndTime = loanEndTime;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
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

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public String getIsInvalid() {
        return isInvalid;
    }

    public void setIsInvalid(String isInvalid) {
        this.isInvalid = isInvalid;
    }
}
