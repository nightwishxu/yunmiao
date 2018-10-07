package com.api.view.orgAuctionPawn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/9/25.
 *
 * 竞拍 Model
 *
 */

@ApiModel
public class PawnDetail {

    @ApiModelProperty("典当id")
    private String id;

    @ApiModelProperty("当品id")
    private String goodsId;

    @ApiModelProperty("当品名称")
    private String title;

    @ApiModelProperty("当品图片")
    private String image;

    @ApiModelProperty("当户id")
    private String collecterId;

    @ApiModelProperty("当户收款银行名称")
    private String collecterBankName;

    @ApiModelProperty("当户收款银行账户")
    private String collecterBankCardCode;

    @ApiModelProperty("估价")
    private String authPriceTest;

    @ApiModelProperty("鉴定价")
    private String authPrice;

    @ApiModelProperty("当户贷款期望额度")
    private String collecterMoney;

    @ApiModelProperty("当户期望利率")
    private String collecterRate;

    @ApiModelProperty("当期，即用户端去典当提交的当期")
    private String pawnDays;

    @ApiModelProperty("竞拍结束倒数秒数，如果为0，表示竞拍已经结束，机构将不能再出价竟拍（用户选择了中标机构、用户在倒计时结束前取消竞拍、倒计时走完")
    private String bidCountdownTime;

    @ApiModelProperty("对该藏品的竞拍出价的机构总数")
    protected int bidTimes;

    /*@ApiModelProperty("在我的竞拍（已中标）页面中，【查看当票】按钮，URL跳转H5页面，传递pawnId")
    private String pawnTickets;*/

    @ApiModelProperty("典当开始日期(中标后有效)")
    private String pawnBeginTime;

    @ApiModelProperty("典当结束日期(中标后有效)")
    private String pawnEndTime;

    @ApiModelProperty("在我的竞拍（已中标）页面中，点击【查看支付凭证】按钮后里面的典当付款凭证图片id")
    private String pawnVoucher;

    @ApiModelProperty("在我的竞拍（已中标）页面中，点击【查看支付凭证】按钮后里面的续当付款凭证图片id，若不止一个，用逗号隔开")
    private String repawnVoucher;

    @ApiModelProperty("在我的竞拍（已中标）页面中，点击【查看支付凭证】按钮后里面的赎当付款凭证图片id")
    private String redeemVoucher;

    @ApiModelProperty("本次拍当是否已失效（中标后1小时内未支付贷款）0-已失效 1-有效")
    private String isInvalid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCollecterId() {
        return collecterId;
    }

    public void setCollecterId(String collecterId) {
        this.collecterId = collecterId;
    }

    public String getCollecterBankName() {
        return collecterBankName;
    }

    public void setCollecterBankName(String collecterBankName) {
        this.collecterBankName = collecterBankName;
    }

    public String getCollecterBankCardCode() {
        return collecterBankCardCode;
    }

    public void setCollecterBankCardCode(String collecterBankCardCode) {
        this.collecterBankCardCode = collecterBankCardCode;
    }

    public String getAuthPriceTest() {
        return authPriceTest;
    }

    public void setAuthPriceTest(String authPriceTest) {
        this.authPriceTest = authPriceTest;
    }

    public String getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(String authPrice) {
        this.authPrice = authPrice;
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

    public String getPawnBeginTime() {
        return pawnBeginTime;
    }

    public void setPawnBeginTime(String pawnBeginTime) {
        this.pawnBeginTime = pawnBeginTime;
    }

    public String getPawnEndTime() {
        return pawnEndTime;
    }

    public String getPawnDays() {
        return pawnDays;
    }

    public void setPawnDays(String pawnDays) {
        this.pawnDays = pawnDays;
    }

    public void setPawnEndTime(String pawnEndTime) {
        this.pawnEndTime = pawnEndTime;
    }

    public String getBidCountdownTime() {
        return bidCountdownTime;
    }

    public void setBidCountdownTime(String bidCountdownTime) {
        this.bidCountdownTime = bidCountdownTime;
    }

    public int getBidTimes() {
        return bidTimes;
    }

    public void setBidTimes(int bidTimes) {
        this.bidTimes = bidTimes;
    }

   /* public String getPawnTickets() {
        return pawnTickets;
    }

    public void setPawnTickets(String pawnTickets) {
        this.pawnTickets = pawnTickets;
    }
*/
    public String getPawnVoucher() {
        return pawnVoucher;
    }

    public void setPawnVoucher(String pawnVoucher) {
        this.pawnVoucher = pawnVoucher;
    }

    public String getRepawnVoucher() {
        return repawnVoucher;
    }

    public void setRepawnVoucher(String repawnVoucher) {
        this.repawnVoucher = repawnVoucher;
    }

    public String getRedeemVoucher() {
        return redeemVoucher;
    }

    public void setRedeemVoucher(String redeemVoucher) {
        this.redeemVoucher = redeemVoucher;
    }

    public String getIsInvalid() {
        return isInvalid;
    }

    public void setIsInvalid(String isInvalid) {
        this.isInvalid = isInvalid;
    }
}
