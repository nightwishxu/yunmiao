package com.item.daoEx.model;

import com.item.dao.model.Ad;

/**
@author sun
*/
public class AdEx extends Ad {
	private Integer goodsId;

	private String cost;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}