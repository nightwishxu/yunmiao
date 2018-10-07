package com.api.view.myPawn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 我的竞拍--没有机构竞拍--宝祥兜底
 * @author vonkira
 *
 */
@ApiModel
public class APPMyPawnBxGet {
    @ApiModelProperty(value="当品id")
    private Integer id;
    @ApiModelProperty(value="当品名称")
    private String title;
    @ApiModelProperty(value="当品图片")
    private String image;
    @ApiModelProperty(value="鉴定价格")
    private String authPrice;
    @ApiModelProperty(value="期望当金")
    private String loansPrice;
    @ApiModelProperty(value="期望利率")
    private String loansRate;
    @ApiModelProperty(value="贷款时间(1:15天  2:30天)")
    private String pawnTime;
    @ApiModelProperty(value="平台提供当金")
    private String bxMoney;
    @ApiModelProperty(value="平台综合利率")
    private String bxRate;
    @ApiModelProperty(value="平台利息利率")
    private String bxMoneyRate;
    @ApiModelProperty(value="宝祥机构id")
    private String bxOrgId;

    @ApiModelProperty(value="公司名称")
    private String comName;
    @ApiModelProperty(value="公司地址")
    private String comaddress;
    @ApiModelProperty(value="公司注册资金")
    private String regMoney;
    @ApiModelProperty(value="法人代表")
    private String manager;
    @ApiModelProperty(value="联系电话")
    private String comPhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(String authPrice) {
        this.authPrice = authPrice;
    }

    public String getLoansPrice() {
        return loansPrice;
    }

    public void setLoansPrice(String loansPrice) {
        this.loansPrice = loansPrice;
    }

    public String getLoansRate() {
        return loansRate;
    }

    public void setLoansRate(String loansRate) {
        this.loansRate = loansRate;
    }

    public String getPawnTime() {
        return pawnTime;
    }

    public void setPawnTime(String pawnTime) {
        this.pawnTime = pawnTime;
    }

    public String getBxMoney() {
        return bxMoney;
    }

    public void setBxMoney(String bxMoney) {
        this.bxMoney = bxMoney;
    }

    public String getBxRate() {
        return bxRate;
    }

    public void setBxRate(String bxRate) {
        this.bxRate = bxRate;
    }

    public String getBxMoneyRate() {
        return bxMoneyRate;
    }

    public void setBxMoneyRate(String bxMoneyRate) {
        this.bxMoneyRate = bxMoneyRate;
    }

    public String getBxOrgId() {
        return bxOrgId;
    }

    public void setBxOrgId(String bxOrgId) {
        this.bxOrgId = bxOrgId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComaddress() {
        return comaddress;
    }

    public void setComaddress(String comaddress) {
        this.comaddress = comaddress;
    }

    public String getRegMoney() {
        return regMoney;
    }

    public void setRegMoney(String regMoney) {
        this.regMoney = regMoney;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getComPhone() {
        return comPhone;
    }

    public void setComPhone(String comPhone) {
        this.comPhone = comPhone;
    }
}
