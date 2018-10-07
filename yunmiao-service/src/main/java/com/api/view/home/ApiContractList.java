package com.api.view.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 合同记录
 * @author vonkira
 *
 */
@ApiModel
public class ApiContractList {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="封面")
    private String img;
    @ApiModelProperty(value="名字")
    private String title;
    @ApiModelProperty(value="当号")
    private String code;
    @ApiModelProperty(value="当款")
    private String pawnMoney;
    @ApiModelProperty(value="签订时间")
    private String verifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPawnMoney() {
        return pawnMoney;
    }

    public void setPawnMoney(String pawnMoney) {
        this.pawnMoney = pawnMoney;
    }

    public String getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(String verifyTime) {
        this.verifyTime = verifyTime;
    }
}
