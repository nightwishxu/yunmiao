package com.paidang.daoEx.model;

import com.paidang.dao.model.UserCoupon;

/**
@author sun
*/
public class UserCouponEx extends UserCoupon {
    //商品名称
    private String goodsName;

    private String goodsPrice;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}