package com.paidang.daoEx.model;

import com.paidang.dao.model.Coupon;

/**
@author sun
*/
public class CouponEx extends Coupon {

    private String goodsPrice;

    private String goodsName;

    private Integer cnt;

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}