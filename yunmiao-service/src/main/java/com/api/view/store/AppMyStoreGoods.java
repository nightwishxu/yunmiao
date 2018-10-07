package com.api.view.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class  AppMyStoreGoods {

    @ApiModelProperty(value="订单id")
    private Integer id;
    @ApiModelProperty(value="商品封面")
    private String images;
    @ApiModelProperty(value="商品id")
    private Integer goodsId;
    @ApiModelProperty(value="商品订单号")
    private String orderCode;
    @ApiModelProperty(value="商品名称")
    private String goodsName;
    @ApiModelProperty(value="商品鉴定价")
    private String authPrice;
    @ApiModelProperty(value="最终价格")
    private String price;
    @ApiModelProperty(value="商品售价")
    private String goodsPirce;
    @ApiModelProperty(value="市场预估文本")
    private String description;
    @ApiModelProperty(value="商品描述")
    private String goodsDescription;
    @ApiModelProperty(value="购买声明")
    private String declare;
    @ApiModelProperty(value=" 优惠券减免金额")
    private String couponPrice;
    @ApiModelProperty(value="订单状态-1已取消1待付款2已付款3已发货4确认收货5退款")
    private Integer state;
    @ApiModelProperty(value="物流状态0：在途1：揽件2：疑难3：签收4：退签或异常签收5：派件6：退回")
    private Integer expressState;
    @ApiModelProperty(value="快递公司名称")
    private String postAddress;
    @ApiModelProperty(value="快递公司单号")
    private String postCode;
    @ApiModelProperty(value="是否已经购买0未购买 1已购买")
    private Integer isBuy;

    @ApiModelProperty(value="联系人")
    private String shipUser;
    @ApiModelProperty(value="联系人电话号码")
    private String shipPhone;
    @ApiModelProperty(value="地址")
    private String shipAddress;
    @ApiModelProperty(value="商品类型 1认证商品 2绝当商品")
    private Integer goodsType;
    @ApiModelProperty(value="物流id")
    private Integer expressId;
    @ApiModelProperty(value = "退款状态 0未退款 1申请退款 2同意退款 3提交单号 4已退款 5拒绝退款")
    private Integer refState;
    @ApiModelProperty(value = "拒绝理由")
    private String refundNotVerifyReason;

    @ApiModelProperty(value = "评价状态 0未评价1已评价")
    private Integer commentState;

    public String getRefundNotVerifyReason() {
        return refundNotVerifyReason;
    }

    public void setRefundNotVerifyReason(String refundNotVerifyReason) {
        this.refundNotVerifyReason = refundNotVerifyReason;
    }

    public Integer getRefState() {
        return refState;
    }

    public void setRefState(Integer refState) {
        this.refState = refState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(String authPrice) {
        this.authPrice = authPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getDeclare() {
        return declare;
    }

    public void setDeclare(String declare) {
        this.declare = declare;
    }

    public String getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(String couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Integer getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(Integer isBuy) {
        this.isBuy = isBuy;
    }

    public Integer getExpressState() {
        return expressState;
    }

    public void setExpressState(Integer expressState) {
        this.expressState = expressState;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getShipUser() {
        return shipUser;
    }

    public void setShipUser(String shipUser) {
        this.shipUser = shipUser;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsPirce() {
        return goodsPirce;
    }

    public void setGoodsPirce(String goodsPirce) {
        this.goodsPirce = goodsPirce;
    }

    public Integer getExpressId() {
        return expressId;
    }

    public void setExpressId(Integer expressId) {
        this.expressId = expressId;
    }

    public Integer getCommentState() {
        return commentState;
    }

    public void setCommentState(Integer commentState) {
        this.commentState = commentState;
    }
}
