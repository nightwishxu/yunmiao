package com.api.view.orgHome.contractRecord;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2018/1/30.
 */
public class ContractPawn {

    @ApiModelProperty("典当id")
    private String pawnId;

    /*@ApiModelProperty("续当id")
    private String repawnId;*/

    @ApiModelProperty("当品id")
    private String goodsId;

    @ApiModelProperty("当品名称")
    private String goodsName;

    @ApiModelProperty("当品图片")
    private String images;

    @ApiModelProperty("已贷额度：本金")
    private String loanMoney;

    @ApiModelProperty("签订时间（典当开始时间）")
    private String pawnBeginTime;

    @ApiModelProperty("典当结束时间")
    private String pawnEndTime;

    public String getPawnId() {
        return pawnId;
    }

    public void setPawnId(String pawnId) {
        this.pawnId = pawnId;
    }

   /* public String getRepawnId() {
        return repawnId;
    }

    public void setRepawnId(String repawnId) {
        this.repawnId = repawnId;
    }*/

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(String loanMoney) {
        this.loanMoney = loanMoney;
    }

    public String getPawnBeginTime() {
        return pawnBeginTime;
    }

    public void setPawnBeginTime(String pawnBeginTime) {
        this.pawnBeginTime = pawnBeginTime;
    }

    public String getPawnEndTime() {
        return pawnEndTime;
    }

    public void setPawnEndTime(String pawnEndTime) {
        this.pawnEndTime = pawnEndTime;
    }
}
