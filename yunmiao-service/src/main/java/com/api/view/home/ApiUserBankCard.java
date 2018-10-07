package com.api.view.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户地址管理
 * @author vonkira
 *
 */
@ApiModel
public class ApiUserBankCard {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="用户id")
    private Integer userId;
    @ApiModelProperty(value="银行卡号")
    private String bankCardNo;
    @ApiModelProperty(value="所属银行")
    private String bankCardName;
    @ApiModelProperty(value="是否默认(1默认0否)")
    private Integer isDefault;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getBankCardName() {
        return bankCardName;
    }

    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
}
