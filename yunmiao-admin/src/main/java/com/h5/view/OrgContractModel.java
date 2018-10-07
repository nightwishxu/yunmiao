package com.h5.view;

/**
 * Created by Lee on 2018/2/2.
 *
 * 该model应与com.api.view.orgHome.contractRecord.ContractDetail类保持字段一致
 * 该model为安卓端合同的h5页面提供数据，而com.api.view.orgHome.contractRecord.ContractDetai为ios端合同页面提供数据
 *
 * 废弃
 */
public class OrgContractModel {

    //当号
    private String pawnTicketCode;

    //当品名称
    private String goodsName;

    //当户姓名
    private String pawnerName;

    //鉴定价格
    private String authPrice;

    //典当公司名称
    private String orgName;

    //典当公司法人代表
    private String orgLegalPerson;

    //注册资金
    private String orgRegisteredCapital;

    //注册地址
    private String orgAddress;

    //当款
    private String loanMoney;

    //典当开始时间
    private String pawnBeginTime;

    //典当结束时间
    private String pawnEndTime;

    //综合费率
    private String rate;

    //服务费率
    private String moneyRate;

    //逾期滞纳费率
    private String demurrageRate;

    //入账银行卡
    private String bankCardCode;

    //状态 1-待确认 2-已完成
    private String state;

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
}
