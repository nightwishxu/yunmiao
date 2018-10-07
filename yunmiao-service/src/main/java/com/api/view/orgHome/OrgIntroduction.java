package com.api.view.orgHome;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/11/28.
 */
public class OrgIntroduction {

    @ApiModelProperty(value="机构id")
    private String orgId;

    @ApiModelProperty(value="机构名称")
    private String orgName;

    @ApiModelProperty(value="平台成交数量")
    private String dealAmount;

    @ApiModelProperty(value="注册资金")
    private String registeredCapital;

    @ApiModelProperty(value="法人代表")
    private String lagalPerson;

    @ApiModelProperty(value="注册地址")
    private String address;

    @ApiModelProperty(value="公司简介")
    private String introduction;

    @ApiModelProperty(value="公司环境")
    private String orgImages;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(String dealAmount) {
        this.dealAmount = dealAmount;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getLagalPerson() {
        return lagalPerson;
    }

    public void setLagalPerson(String lagalPerson) {
        this.lagalPerson = lagalPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getOrgImages() {
        return orgImages;
    }

    public void setOrgImages(String orgImages) {
        this.orgImages = orgImages;
    }
}
