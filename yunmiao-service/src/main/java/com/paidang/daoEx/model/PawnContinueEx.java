package com.paidang.daoEx.model;

import com.paidang.dao.model.PawnContinue;

import java.math.BigDecimal;

/**
@author sun
*/
public class PawnContinueEx extends PawnContinue {

    private String goodsName;

	private String authPrice;

	private String pawnerName;//当户姓名

	private String orgName;//机构名称

    private String orgSeal;//机构印章

	private BigDecimal loanMoney;//典当金额

    private BigDecimal rate;//综合费率

    private BigDecimal moneyRate;//赎当利率


    public String getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(String authPrice) {
        this.authPrice = authPrice;
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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgSeal() {
        return orgSeal;
    }

    public void setOrgSeal(String orgSeal) {
        this.orgSeal = orgSeal;
    }

    public BigDecimal getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(BigDecimal loanMoney) {
        this.loanMoney = loanMoney;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getMoneyRate() {
        return moneyRate;
    }

    public void setMoneyRate(BigDecimal moneyRate) {
        this.moneyRate = moneyRate;
    }
}