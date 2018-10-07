package com.api.view.orgFirstPage.search;

import com.api.view.orgAuctionPawn.PawnDetail;
import com.api.view.orgDeadPawnage.DeadPawnMini;
import com.api.view.orgDeadPawnage.ExpressInfo;
import com.api.view.orgHome.deadPawnAuction.DeadPawnAuctionMini;
import com.api.view.orgRedeem.RedeemMini;
import com.api.view.orgRepawn.RepawnMini;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by Lee on 2017/10/24.
 */
@ApiModel
public class Search {

    @ApiModelProperty("典当/续当")
    private RepawnMini repawnMini ;

    @ApiModelProperty("竞拍：竞拍中/已中标")
    private PawnDetail pawnDetail;

    @ApiModelProperty("赎当")
    private RedeemMini redeemMini;

    @ApiModelProperty("绝当")
    private DeadPawnMini deadPawnMini;

    @ApiModelProperty("绝当竞拍")
    private DeadPawnAuctionMini deadPawnAuctionMini;

    @ApiModelProperty("物流")
    private ExpressInfo expressInfo;

    @ApiModelProperty("点击跳转目标：1.典当 2.续当 3.竞拍中 4.已中标 5.赎当 6.绝当 7.绝当竞拍 8.物流")
    private String des;

    public Search(){
        this.repawnMini = new RepawnMini();
        this.pawnDetail = new PawnDetail();
        this.redeemMini = new RedeemMini();
        this.deadPawnMini = new DeadPawnMini();
        this.deadPawnAuctionMini = new DeadPawnAuctionMini();
        this.expressInfo = new ExpressInfo();
    }

    public RepawnMini getRepawnMini() {
        return repawnMini;
    }

    public void setRepawnMini(RepawnMini repawnMini) {
        this.repawnMini = repawnMini;
    }

    public PawnDetail getPawnDetail() {
        return pawnDetail;
    }

    public void setPawnDetail(PawnDetail pawnDetail) {
        this.pawnDetail = pawnDetail;
    }

    public RedeemMini getRedeemMini() {
        return redeemMini;
    }

    public void setRedeemMini(RedeemMini redeemMini) {
        this.redeemMini = redeemMini;
    }

    public DeadPawnMini getDeadPawnMini() {
        return deadPawnMini;
    }

    public void setDeadPawnMini(DeadPawnMini deadPawnMini) {
        this.deadPawnMini = deadPawnMini;
    }

    public DeadPawnAuctionMini getDeadPawnAuctionMini() {
        return deadPawnAuctionMini;
    }

    public void setDeadPawnAuctionMini(DeadPawnAuctionMini deadPawnAuctionMini) {
        this.deadPawnAuctionMini = deadPawnAuctionMini;
    }

    public ExpressInfo getExpressInfo() {
        return expressInfo;
    }

    public void setExpressInfo(ExpressInfo expressInfo) {
        this.expressInfo = expressInfo;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
