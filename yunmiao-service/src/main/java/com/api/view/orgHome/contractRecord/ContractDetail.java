package com.api.view.orgHome.contractRecord;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2018/1/30.
 */
public class ContractDetail {

    @ApiModelProperty("当号")
    private String pawnTicketCode;

    @ApiModelProperty("当品名称")
    private String goodsName;

    @ApiModelProperty("当户姓名")
    private String pawnerName;

    @ApiModelProperty("鉴定价格")
    private String authPrice;

    @ApiModelProperty("典当公司名称")
    private String orgName;

    @ApiModelProperty("典当公司法人代表")
    private String orgLegalPerson;

    @ApiModelProperty("注册资金")
    private String orgRegisteredCapital;

    @ApiModelProperty("注册地址")
    private String orgAddress;

    @ApiModelProperty("当款")
    private String loanMoney;

    @ApiModelProperty("典当开始时间")
    private String pawnBeginTime;

    @ApiModelProperty("典当结束时间")
    private String pawnEndTime;

    @ApiModelProperty("综合费率")
    private String rate;

    @ApiModelProperty("服务费率")
    private String moneyRate;

    @ApiModelProperty("逾期滞纳费率")
    private String demurrageRate;

    @ApiModelProperty("入账银行卡")
    private String bankCardCode;

    @ApiModelProperty("状态 1-待确认 2-已完成")
    private String state;

    @ApiModelProperty("合同法链接地址")
    private String hetongfa;

    @ApiModelProperty("民事法链接地址")
    private String minshifa;

    @ApiModelProperty("典当管理法链接地址")
    private String diandangguanlifa;

    @ApiModelProperty("典当签订时间")
    private String pawnSignTime;

    @ApiModelProperty("续当签订时间")
    private String repawnSignTime;

    public String getPawnTicketCode() {
        return pawnTicketCode;
    }

    public void setPawnTicketCode(String pawnTicketCode) {
        this.pawnTicketCode = pawnTicketCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPawnerName() {
        return pawnerName;
    }

    public void setPawnerName(String pawnerName) {
        this.pawnerName = pawnerName;
    }

    public String getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(String authPrice) {
        this.authPrice = authPrice;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgLegalPerson() {
        return orgLegalPerson;
    }

    public void setOrgLegalPerson(String orgLegalPerson) {
        this.orgLegalPerson = orgLegalPerson;
    }

    public String getOrgRegisteredCapital() {
        return orgRegisteredCapital;
    }

    public void setOrgRegisteredCapital(String orgRegisteredCapital) {
        this.orgRegisteredCapital = orgRegisteredCapital;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(String loanMoney) {
        this.loanMoney = loanMoney;
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

    public void setPawnEndTime(String pawnEndTime) {
        this.pawnEndTime = pawnEndTime;
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

    public String getDemurrageRate() {
        return demurrageRate;
    }

    public void setDemurrageRate(String demurrageRate) {
        this.demurrageRate = demurrageRate;
    }

    public String getBankCardCode() {
        return bankCardCode;
    }

    public void setBankCardCode(String bankCardCode) {
        this.bankCardCode = bankCardCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHetongfa() {
        return hetongfa;
    }

    public void setHetongfa(String hetongfa) {
        this.hetongfa = hetongfa;
    }

    public String getMinshifa() {
        return minshifa;
    }

    public void setMinshifa(String minshifa) {
        this.minshifa = minshifa;
    }

    public String getDiandangguanlifa() {
        return diandangguanlifa;
    }

    public void setDiandangguanlifa(String diandangguanlifa) {
        this.diandangguanlifa = diandangguanlifa;
    }

    public String getPawnSignTime() {
        return pawnSignTime;
    }

    public void setPawnSignTime(String pawnSignTime) {
        this.pawnSignTime = pawnSignTime;
    }

    public String getRepawnSignTime() {
        return repawnSignTime;
    }

    public void setRepawnSignTime(String repawnSignTime) {
        this.repawnSignTime = repawnSignTime;
    }
}
