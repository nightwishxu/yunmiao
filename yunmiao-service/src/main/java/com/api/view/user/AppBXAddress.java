package com.api.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 宝祥地址
 */
@ApiModel
public class AppBXAddress {
    @ApiModelProperty(value="name")
    private String name;
    @ApiModelProperty(value="address")
    private String address;
    @ApiModelProperty(value="phone")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
