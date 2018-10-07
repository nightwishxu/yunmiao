package com.api.view.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 合同详情
 * @author vonkira
 *
 */
@ApiModel
public class ApiContractInfo {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="当号")
    private String code;
    @ApiModelProperty(value="藏品名称")
    private String title;
    @ApiModelProperty(value="藏品主人")
    private String userName;
    @ApiModelProperty(value="鉴定价")
    private String authPrice;
    @ApiModelProperty(value="典当行名称")
    private String orgName;
    @ApiModelProperty(value="法人代表")
    private String legalPerson;
    @ApiModelProperty(value="注册资金")
    private String registeredCapital;
    @ApiModelProperty(value="注册地址")
    private String address;
    @ApiModelProperty(value="当款")
    private String money;
    @ApiModelProperty(value="典当开始时间")
    private String pawnBeginTime;
    @ApiModelProperty(value="典当结束时间")
    private String pawnEndTime;
    @ApiModelProperty(value="综合费率")
    private String rate;
    @ApiModelProperty(value="服务费率")
    private String serverRate;
    @ApiModelProperty(value="逾期滞纳费率")
    private String overdueRate;
    @ApiModelProperty(value="银行卡名称")
    private String bankName;
    @ApiModelProperty(value="银行卡号")
    private String bankCodeNo;
    @ApiModelProperty(value="签订时间")
    private String time;
    @ApiModelProperty(value="状态0未完成 1已完成")
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
