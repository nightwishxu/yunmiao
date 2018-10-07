package com.paidang.daoEx.model;

import com.paidang.dao.model.PawnLog;

/**
@author sun
*/
public class PawnLogEx extends PawnLog {
    //机构名称
    private String orgName;
    //机构联系电话
    private String orgPhone;

    private String goodsImages;

    @Override
    public String getOrgName() {
        return orgName;
    }

    @Override
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public String getGoodsImages() {
        return goodsImages;
    }

    public void setGoodsImages(String goodsImages) {
        this.goodsImages = goodsImages;
    }
}