package com.paidang.daoEx.model;

import com.paidang.dao.model.ExperterInfo;

/**
@author sun
*/
public class ExperterInfoEx extends ExperterInfo {

    private String images;

    private String experterName;

    private String goodsName;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getExperterName() {
        return experterName;
    }

    public void setExperterName(String experterName) {
        this.experterName = experterName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}