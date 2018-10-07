package com.item.daoEx.model;

import com.item.dao.model.Focus;

public class FocusEx extends Focus {
    //商品名称
    private String goodsName;

    private String redirectName;

    public String getRedirectName() {
        return redirectName;
    }

    public void setRedirectName(String redirectName) {
        this.redirectName = redirectName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
