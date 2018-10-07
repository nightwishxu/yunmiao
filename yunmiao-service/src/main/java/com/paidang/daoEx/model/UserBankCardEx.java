package com.paidang.daoEx.model;

import com.paidang.dao.model.UserBankCard;

/**
@author sun
*/
public class UserBankCardEx extends UserBankCard {

    private String userName;

    private String userAccount;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}