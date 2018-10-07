package com.api.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户资金明细
 */
@ApiModel
public class AppUserCapital {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="金额")
    private String money;
    @ApiModelProperty(value="时间")
    private String time;
    @ApiModelProperty(value="相关机构名称")
    private String orgName;
    @ApiModelProperty(value="电话")
    private String phone;
    @ApiModelProperty(value="当号")
    private String pawnCode;
    @ApiModelProperty(value="银行名称")
    private String bankName;
    @ApiModelProperty(value="银行卡号")
    private String bankCode;
    @ApiModelProperty(value="1典当  2续当  3赎当 4卖给平台 5宝祥兜底")
    private String state;
    @ApiModelProperty(value="凭证")
    private String ticket;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPawnCode() {
        return pawnCode;
    }

    public void setPawnCode(String pawnCode) {
        this.pawnCode = pawnCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
