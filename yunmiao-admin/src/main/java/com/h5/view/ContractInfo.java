package com.h5.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 合同详情
 * @author vonkira
 *
 */
@ApiModel
public class ContractInfo {

    private Integer id;

    private String code;

    private String title;

    private String userName;

    private String authPrice;

    private String orgName;

    private String legalPerson;

    private String registeredCapital;

    private String address;

    private String money;

    private String pawnBeginTime;

    private String pawnEndTime;

    private String rate;

    private String serverRate;

    private String overdueRate;

    private String bankName;

    private String bankCodeNo;

    private String time;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
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

    public String getServerRate() {
        return serverRate;
    }

    public void setServerRate(String serverRate) {
        this.serverRate = serverRate;
    }

    public String getOverdueRate() {
        return overdueRate;
    }

    public void setOverdueRate(String overdueRate) {
        this.overdueRate = overdueRate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCodeNo() {
        return bankCodeNo;
    }

    public void setBankCodeNo(String bankCodeNo) {
        this.bankCodeNo = bankCodeNo;
    }

    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
