package com.api.view.orgHome.CapitalRunningAccount;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/9/26.
 *
 * 资金流水详情
 */
@ApiModel
public class CapitalRunningAccountDetail {

    @ApiModelProperty("交易卡号")
    private String tradeCardCode;

    @ApiModelProperty("交易银行名称")
    private String tradeCardBank;

    @ApiModelProperty("当户姓名")
    private String pawnerName;

    @ApiModelProperty("当户手机号码")
    private String pawnerTel;

    @ApiModelProperty("当号")
    private String pawnTicketCode;

    @ApiModelProperty("金额")
    private String amount;

    @ApiModelProperty("交易类型 1支出2收入")
    private String type;

    @ApiModelProperty("线下打款凭证")
    private String tradeTicket;

    @ApiModelProperty("交易时间")
    private String tradeTime;

    public String getTradeCardCode() {
        return tradeCardCode;
    }

    public void setTradeCardCode(String tradeCardCode) {
        this.tradeCardCode = tradeCardCode;
    }

    public String getTradeCardBank() {
        return tradeCardBank;
    }

    public void setTradeCardBank(String tradeCardBank) {
        this.tradeCardBank = tradeCardBank;
    }

    public String getPawnerName() {
        return pawnerName;
    }

    public void setPawnerName(String pawnerName) {
        this.pawnerName = pawnerName;
    }

    public String getPawnerTel() {
        return pawnerTel;
    }

    public void setPawnerTel(String pawnerTel) {
        this.pawnerTel = pawnerTel;
    }

    public String getPawnTicketCode() {
        return pawnTicketCode;
    }

    public void setPawnTicketCode(String pawnTicketCode) {
        this.pawnTicketCode = pawnTicketCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTradeTicket() {
        return tradeTicket;
    }

    public void setTradeTicket(String tradeTicket) {
        this.tradeTicket = tradeTicket;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }
}
