package com.api.view.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户典当记录流水
 * @author vonkira
 *
 */
@ApiModel
public class ApiUserPawnRecord {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="时间")
    private String beginTime;
    @ApiModelProperty(value="类型 0鉴定真品1典当2续当3赎当4绝当5交易6卖给平台")
    private Integer state;
    @ApiModelProperty(value="价格")
    private String price;
    @ApiModelProperty(value="典当行名称")
    private String orgName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
