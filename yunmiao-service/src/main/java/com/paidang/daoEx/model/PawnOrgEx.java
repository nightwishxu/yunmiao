package com.paidang.daoEx.model;

import com.paidang.dao.model.PawnOrg;

/**
@author sun
*/
public class PawnOrgEx extends PawnOrg {

    //机构用户电话
    private String orgUserPhone;

    //机构用户id
    private Integer orgUserId;

    //该机构在平台成功典当的单数
    private String dealAmount;

    //机构商品照片
    private String goodsImgs;

    private String stateInfo;




    public String getOrgUserPhone() {
        return orgUserPhone;
    }

    public void setOrgUserPhone(String orgUserPhone) {
        this.orgUserPhone = orgUserPhone;
    }

    public Integer getOrgUserId() {
        return orgUserId;
    }

    public void setOrgUserId(Integer orgUserId) {
        this.orgUserId = orgUserId;
    }

    public String getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(String dealAmount) {
        this.dealAmount = dealAmount;
    }

    public String getGoodsImgs() {
        return goodsImgs;
    }

    public void setGoodsImgs(String goodsImgs) {
        this.goodsImgs = goodsImgs;
    }


    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}