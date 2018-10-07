package com.h5.view;

/**
 * Created by Lee on 2017/11/22.
 */
public class RepawnTicketModel {

    private String orgName;

    private String orgSeal;

    private String pawnTicketCode;

    private String pawnerName;

    private String contactor;
    //原典当金额
    private String loanMoney;
    //续当综合费
    private String cost;
    //用户应付上期利息
    private String moneyCost;
    //续当合计应交
    private String repawnTotal;

    private String loanMoneyCN;

    private String costCN;

    private String repawnTotalCN;

    private String moneyCostCN;

    //续当开始时间
    private String repawnBeginTime;
    //续结束时间
    private String repawnEndTime;
    //月费率
    private String rate;
    //月利率
    private String moneyRate;


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

    public String getPawnTicketCode() {
        return pawnTicketCode;
    }

    public void setPawnTicketCode(String pawnTicketCode) {
        this.pawnTicketCode = pawnTicketCode;
    }

    public String getPawnerName() {
        return pawnerName;
    }

    public void setPawnerName(String pawnerName) {
        this.pawnerName = pawnerName;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public String getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(String loanMoney) {
        this.loanMoney = loanMoney;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMoneyCost() {
        return moneyCost;
    }

    public void setMoneyCost(String moneyCost) {
        this.moneyCost = moneyCost;
    }

    public String getRepawnTotal() {
        return repawnTotal;
    }

    public void setRepawnTotal(String repawnTotal) {
        this.repawnTotal = repawnTotal;
    }

    public String getRepawnBeginTime() {
        return repawnBeginTime;
    }

    public void setRepawnBeginTime(String repawnBeginTime) {
        this.repawnBeginTime = repawnBeginTime;
    }

    public String getRepawnEndTime() {
        return repawnEndTime;
    }

    public void setRepawnEndTime(String repawnEndTime) {
        this.repawnEndTime = repawnEndTime;
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

    public String getLoanMoneyCN() {
        return loanMoneyCN;
    }

    public void setLoanMoneyCN(String loanMoneyCN) {
        this.loanMoneyCN = loanMoneyCN;
    }

    public String getCostCN() {
        return costCN;
    }

    public void setCostCN(String costCN) {
        this.costCN = costCN;
    }

    public String getMoneyCostCN() {
        return moneyCostCN;
    }

    public void setMoneyCostCN(String moneyCostCN) {
        this.moneyCostCN = moneyCostCN;
    }

    public String getRepawnTotalCN() {
        return repawnTotalCN;
    }

    public void setRepawnTotalCN(String repawnTotalCN) {
        this.repawnTotalCN = repawnTotalCN;
    }
}
