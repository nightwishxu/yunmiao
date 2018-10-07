package com.api.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户优惠券
 */
@ApiModel
public class AppUserCoupon {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="优惠券id")
    private Integer couponId;
//    @ApiModelProperty(value="满")
//    private String full;
    @ApiModelProperty(value="减(优惠金额)")
    private String value;
    @ApiModelProperty(value="领取时间")
    private String createTime;
    @ApiModelProperty(value="过期时间")
    private String endTime;
    @ApiModelProperty(value="状态0已使用  1未使用")
    private Integer state;
    @ApiModelProperty(value="使用时间")
    private String useTime;
    @ApiModelProperty(value="优惠券来源 1:新用户注册  2看视频")
    private Integer source;
    @ApiModelProperty(value="描述内容")
    private String info;
    @ApiModelProperty(value="价格")
    private String price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

//    public String getFull() {
//        return full;
//    }
//
//    public void setFull(String full) {
//        this.full = full;
//    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
