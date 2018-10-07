package com.api.view.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 合同类型记录列表
 * @author vonkira
 *
 */
@ApiModel
public class ApiContractType {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="类型(1典当合同 2续当合同)")
    private Integer type;
    @ApiModelProperty(value="合同签订时间")
    private String verifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(String verifyTime) {
        this.verifyTime = verifyTime;
    }
}
