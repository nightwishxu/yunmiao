package com.api.view.orgDeadPawnage;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/11/13.
 */
public class MyBankCard {
    @ApiModelProperty("银行名称")
    private String bankName;
    @ApiModelProperty("账号")
    private String bankCode;
    @ApiModelProperty("是否是默认卡 1-默认 0-否")
    private Integer isDefault;

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

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
}
