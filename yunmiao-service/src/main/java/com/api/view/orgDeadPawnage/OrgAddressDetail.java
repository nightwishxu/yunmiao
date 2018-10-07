package com.api.view.orgDeadPawnage;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/11/17.
 *
 * 机构收货地址 model 用在绝当取回信息确认页面
 */
public class OrgAddressDetail {

    @ApiModelProperty("地址id")
    private String addressId;
    @ApiModelProperty("收件人")
    private String recipients;
    @ApiModelProperty("收件人电话")
    private String recipientsTel;
    @ApiModelProperty("地区（省市区）")
    private String area;
    @ApiModelProperty("具体地址")
    private String address;
    @ApiModelProperty("是否默认 : 1默认 0否")
    private Integer isDefault;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getRecipientsTel() {
        return recipientsTel;
    }

    public void setRecipientsTel(String recipientsTel) {
        this.recipientsTel = recipientsTel;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
}
