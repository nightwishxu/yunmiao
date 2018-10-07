package com.api.view.orgDeadPawnage;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/11/28.
 *
 * 我的->物流列表 页面model
 */
public class ExpressInfo {

    @ApiModelProperty("快递id")
    private String expressId;

    @ApiModelProperty("快递单号")
    private String expressCode;

    @ApiModelProperty("物流状态 0：在途1：揽件2：疑难3：签收4：退签或异常签收5：派件6：退回")
    private String expressState;

    @ApiModelProperty("当品id")
    private String goodsId;

    @ApiModelProperty("当品名称")
    private String goodsName;

    @ApiModelProperty("当品图片")
    private String goodsImage;

    @ApiModelProperty("当号")
    private String pawnTicketCode;

    @ApiModelProperty("是否展示【签收】按钮 0-不显示 1-显示 该字段仅在获取物流->【平台取回】列表时有效，在寄给当户列表时忽略该字段")
    private String isSign;


    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

    public String getExpressState() {
        return expressState;
    }

    public void setExpressState(String expressState) {
        this.expressState = expressState;
    }

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

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getPawnTicketCode() {
        return pawnTicketCode;
    }

    public void setPawnTicketCode(String pawnTicketCode) {
        this.pawnTicketCode = pawnTicketCode;
    }

    public String getIsSign() {
        return isSign;
    }

    public void setIsSign(String isSign) {
        this.isSign = isSign;
    }
}
