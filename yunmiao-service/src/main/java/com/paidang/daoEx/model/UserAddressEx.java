package com.paidang.daoEx.model;

import com.paidang.dao.model.UserAddress;

/**
@author sun
*/
public class UserAddressEx extends UserAddress {
    private String name;
    private String account;
    private String full;
    private String value;
    private Integer couponId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }
}