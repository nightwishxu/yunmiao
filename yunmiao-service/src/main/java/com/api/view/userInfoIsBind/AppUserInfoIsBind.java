package com.api.view.userInfoIsBind;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AppUserInfoIsBind {
    @ApiModelProperty(value="人脸是否已经识别过(1已经录入过 2未识别过)")
    private Integer faceBind;
    @ApiModelProperty(value="身份证是否已经绑定(1已绑定  2未绑定)")
    private Integer idCardBind;

    public Integer getFaceBind() {
        return faceBind;
    }

    public void setFaceBind(Integer faceBind) {
        this.faceBind = faceBind;
    }

    public Integer getIdCardBind() {
        return idCardBind;
    }

    public void setIdCardBind(Integer idCardBind) {
        this.idCardBind = idCardBind;
    }
}
