package com.api.view.orgAuctionPawn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by Lee on 2017/9/25.
 *
 * 当品与竞拍详情页面 返回model
 */
@ApiModel
public class BidDetails {

    @ApiModelProperty("当品信息，如：藏品名称，鉴定价，当户贷款需求金额，当户id")
    private PawnDetail pawnDetail;

    @ApiModelProperty("该藏品所有机构出价记录列表：包括出价机构名称（用*隐藏真实名称）、最新出价费率、利率、出价时间,List的长度即为出价次数")
    private List<BidRecord> bidRecords;

    @ApiModelProperty("我（当前登陆人员所属机构）的出价次数")
    private int mybidTimes;

    @ApiModelProperty("登陆的该机构是够绑定了银行卡 0-否 1-已绑")
    private int isBindCard;

    @ApiModelProperty("是否显示【我要出价】按钮 0-否 1-显示")
    private int isShowBidButton;

    public PawnDetail getPawnDetail() {
        return pawnDetail;
    }

    public void setPawnDetail(PawnDetail pawnDetail) {
        this.pawnDetail = pawnDetail;
    }

    public int getMybidTimes() {
        return mybidTimes;
    }

    public void setMybidTimes(int mybidTimes) {
        this.mybidTimes = mybidTimes;
    }

    public List<BidRecord> getBidRecords() {
        return bidRecords;
    }

    public void setBidRecords(List<BidRecord> bidRecords) {
        this.bidRecords = bidRecords;
    }

    public int getIsBindCard() {
        return isBindCard;
    }

    public void setIsBindCard(int isBindCard) {
        this.isBindCard = isBindCard;
    }

    public int getIsShowBidButton() {
        return isShowBidButton;
    }

    public void setIsShowBidButton(int isShowBidButton) {
        this.isShowBidButton = isShowBidButton;
    }
}
