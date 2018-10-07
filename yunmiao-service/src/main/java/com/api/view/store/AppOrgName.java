package com.api.view.store;

import io.swagger.annotations.ApiModelProperty;

/**
 * 绝当商场商家
 */
public class AppOrgName {
    @ApiModelProperty(value="商家id")
    private Integer orgId;
    @ApiModelProperty(value="商家名称")
    private String orgName;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
