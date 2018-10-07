package com.api.view.myPawn;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 续当详情+赎当详情
 */
@ApiModel
public class AppMyPawnConinue {
    @ApiModelProperty(value="当品id")
    private Integer id;
    @ApiModelProperty(value="当品当号")
    private String goodsId;
    @ApiModelProperty(value="当品名称")
    private String title;
    @ApiModelProperty(value="鉴定价")
    private String authPrice;
    @ApiModelProperty(value="图片")
    private String images;
    @ApiModelProperty(value="典当机构名称")
    private String orgName;
    @ApiModelProperty(value="综合利率")
    private String rate;
    @ApiModelProperty(value="利息利率")
    private String moneyRate;
    @ApiModelProperty(value="逾期滞纳利率")
    private String overdueRate;
    @ApiModelProperty(value="已贷款额度")
    private String loansPrice;
    @ApiModelProperty(value="借款日期")
    private String beginTime;
    @ApiModelProperty(value="当前应还款日期")
    private String endTime;
    @ApiModelProperty(value="续当至日期")
    private String coninueTime;
    @ApiModelProperty(value="到期应还款额度")
    private String money;
    @ApiModelProperty(value="预缴综合费")
    private String comMoney;

    @ApiModelProperty(value="综合利息")
    private String zhlxMoney;
    @ApiModelProperty(value="利息")
    private String lxMoney;
    @ApiModelProperty(value="逾期滞纳金")
    private String redeemOverdue;
    @ApiModelProperty(value="费用合计")
    private String TotalMoney;
    @ApiModelProperty(value="收款账户--户名")
    private String payeeName;
    @ApiModelProperty(value="收款账户--银行名称")
    private String payeeBankName;
    @ApiModelProperty(value="收款账户--银行卡号")
    private String payeeBankCardCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getLoansPrice() {
        return loansPrice;
    }

    public void setLoansPrice(String loansPrice) {
        this.loansPrice = loansPrice;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getConinueTime() {
        return coninueTime;
    }

    public void setConinueTime(String coninueTime) {
        this.coninueTime = coninueTime;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getComMoney() {
        return comMoney;
    }

    public void setComMoney(String comMoney) {
        this.comMoney = comMoney;
    }

    public String getMoneyRate() {
        return moneyRate;
    }

    public void setMoneyRate(String moneyRate) {
        this.moneyRate = moneyRate;
    }

    public String getOverdueRate() {
        return overdueRate;
    }

    public void setOverdueRate(String overdueRate) {
        this.overdueRate = overdueRate;
    }

    public String getZhlxMoney() {
        return zhlxMoney;
    }

    public void setZhlxMoney(String zhlxMoney) {
        this.zhlxMoney = zhlxMoney;
    }

    public String getLxMoney() {
        return lxMoney;
    }

    public void setLxMoney(String lxMoney) {
        this.lxMoney = lxMoney;
    }

    public String getRedeemOverdue() {
        return redeemOverdue;
    }

    public void setRedeemOverdue(String redeemOverdue) {
        this.redeemOverdue = redeemOverdue;
    }

    public String getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        TotalMoney = totalMoney;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeBankName() {
        return payeeBankName;
    }

    public void setPayeeBankName(String payeeBankName) {
        this.payeeBankName = payeeBankName;
    }

    public String getPayeeBankCardCode() {
        return payeeBankCardCode;
    }

    public void setPayeeBankCardCode(String payeeBankCardCode) {
        this.payeeBankCardCode = payeeBankCardCode;
    }
}
