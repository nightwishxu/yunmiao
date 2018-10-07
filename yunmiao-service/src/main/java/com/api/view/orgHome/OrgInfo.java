package com.api.view.orgHome;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/10/11.
 *
 * 机构端个人信息
 */
@ApiModel
public class OrgInfo {

    @ApiModelProperty(value="机构id")
    private Integer id;

    @ApiModelProperty(value="账号")
    private String account;

    @ApiModelProperty(value="机构名称")
    private String name;

    @ApiModelProperty(value="手机号码")
    private String tel;

    @ApiModelProperty(value="机构法人")
    private String legalPerson;

    @ApiModelProperty(value="注册资金")
    private String registeredCapital;

    @ApiModelProperty(value="地址")
    private String adress;

    @ApiModelProperty(value="工商许可证")
    private String businessLicense;

    @ApiModelProperty(value="工商许可证号")
    private String businessLicenseCode;

    @ApiModelProperty(value="机构LOGO")
    private String orgLogo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getBusinessLicenseCode() {
        return businessLicenseCode;
    }

    public void setBusinessLicenseCode(String businessLicenseCode) {
        this.businessLicenseCode = businessLicenseCode;
    }

    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo;
    }
}
