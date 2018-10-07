package com.paidang.daoEx.model;

import com.paidang.dao.model.PawnAuction;

/**
@author sun
*/
public class PawnAuctionEx extends PawnAuction {


    //竞拍机构名称
    private String auctionOrgname;

    //某机构对某当品出价次数
    private String times;

    //某机构成交的典当交易数
    private Integer pawnCount;


    public String getAuctionOrgname() {
        return auctionOrgname;
    }

    public void setAuctionOrgname(String auctionOrgname) {
        this.auctionOrgname = auctionOrgname;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Integer getPawnCount() {
        return pawnCount;
    }

    public void setPawnCount(Integer pawnCount) {
        this.pawnCount = pawnCount;
    }
}