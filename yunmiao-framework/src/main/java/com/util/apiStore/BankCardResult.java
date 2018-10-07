package com.util.apiStore;

import com.base.util.JSONUtils;

/**
 * 返回结果
 */
public class BankCardResult {
    private String bankcard;
    private String realName;
    private String cardNo;
    private String mobile;
    private BankCardInfo information;

    public BankCardInfo getInformation() {
        return information;
    }

    public void setInformation(BankCardInfo information) {
        this.information = information;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    @Override
    public String toString() {
        return JSONUtils.serialize(this);
    }
}
