package com.api.view.myPawn;
import java.util.List;

import com.paidang.dao.model.PawnAuction;
import com.paidang.daoEx.model.PawnAuctionEx;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 我的典当--详情
 * @author vonkira
 *
 */
@ApiModel
public class AppMyPawnList {

    @ApiModelProperty(value="当品id")
    private Integer id;
    @ApiModelProperty(value="当品名称")
    private String title;
    @ApiModelProperty(value="当品图片")
    private String image;
    @ApiModelProperty(value="鉴定价格")
    private String authPrice;
    @ApiModelProperty(value="出价次数")
    private Integer count;
    @ApiModelProperty(value="状态(0:进行中 1:已结束)")
    private Integer state;
    @ApiModelProperty(value="用户id")
    private Integer userId;
    @ApiModelProperty(value="已贷款额度")
    private String money;
    @ApiModelProperty(value="到期时间")
    private String time;
    @ApiModelProperty(value="我的需求贷款额度")
    private String loansPrice;
    @ApiModelProperty(value="我的需求贷款利率")
    private String loansRate;
    @ApiModelProperty(value="贷款时间")
    private String pawnTime;
    @ApiModelProperty(value="贷款机构列表")
    private List<PawnAuctionEx> pawnAuctionList;
    @ApiModelProperty(value="机构打款凭证")
    private String payeeTicket;
    @ApiModelProperty(value="当票")
    private String pawnTicket;
    @ApiModelProperty(value="0无1已到账")
    private Integer isVerify;
    @ApiModelProperty(value="0未逾期  1逾期")
    private Integer type;
    @ApiModelProperty(value="赎当状态  0没有赎当操作 1赎当处理中 ")
    private Integer redeemState;
    @ApiModelProperty(value="续当状态 0没有续当操作 1续当处理中 ")
    private Integer continueState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(String authPrice) {
        this.authPrice = authPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLoansPrice() {
        return loansPrice;
    }

    public void setLoansPrice(String loansPrice) {
        this.loansPrice = loansPrice;
    }

    public String getLoansRate() {
        return loansRate;
    }

    public void setLoansRate(String loansRate) {
        this.loansRate = loansRate;
    }

    public String getPawnTime() {
        return pawnTime;
    }

    public List<PawnAuctionEx> getPawnAuctionList() {
        return pawnAuctionList;
    }

    public void setPawnAuctionList(List<PawnAuctionEx> pawnAuctionList) {
        this.pawnAuctionList = pawnAuctionList;
    }

    public void setPawnTime(String pawnTime) {
        this.pawnTime = pawnTime;
    }

    public String getPayeeTicket() {
        return payeeTicket;
    }

    public void setPayeeTicket(String payeeTicket) {
        this.payeeTicket = payeeTicket;
    }

    public Integer getIsVerify() {
        return isVerify;
    }

    public void setIsVerify(Integer isVerify) {
        this.isVerify = isVerify;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRedeemState() {
        return redeemState;
    }

    public void setRedeemState(Integer redeemState) {
        this.redeemState = redeemState;
    }

    public Integer getContinueState() {
        return continueState;
    }

    public void setContinueState(Integer continueState) {
        this.continueState = continueState;
    }

    public String getPawnTicket() {
        return pawnTicket;
    }

    public void setPawnTicket(String pawnTicket) {
        this.pawnTicket = pawnTicket;
    }
}
