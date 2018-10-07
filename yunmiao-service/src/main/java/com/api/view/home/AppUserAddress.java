package com.api.view.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户地址管理
 * @author vonkira
 *
 */
@ApiModel
public class AppUserAddress {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="地区")
    private String area;
    @ApiModelProperty(value="详细地址")
    private String address;
    @ApiModelProperty(value="是否默认1默认0否")
    private Integer is_default;
    @ApiModelProperty(value="姓名")
    private String name;
    @ApiModelProperty(value="联系电话")
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIs_default() {
        return is_default;
    }

    public void setIs_default(Integer is_default) {
        this.is_default = is_default;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
