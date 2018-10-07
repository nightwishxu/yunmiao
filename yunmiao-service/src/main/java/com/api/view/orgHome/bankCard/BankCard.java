package com.api.view.orgHome.bankCard;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/11/17.
 */
public class BankCard {


    @ApiModelProperty("id")
    private String cardId;
    @ApiModelProperty("银行名称")
    private String bankName;
    @ApiModelProperty("卡号")
    private String bankCardNo;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }
}
