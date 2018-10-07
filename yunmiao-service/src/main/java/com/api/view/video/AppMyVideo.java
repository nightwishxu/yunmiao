package com.api.view.video;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AppMyVideo {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="图片")
    private String img;
    @ApiModelProperty(value="宝贝名字")
    private String goodName;
    @ApiModelProperty(value="鉴定价")
    private String authPrice;
    @ApiModelProperty(value="当号")
    private String code;
    @ApiModelProperty(value="机构名称")
    private String orgName;
    @ApiModelProperty(value="打包视频")
    private String goVideo;
    @ApiModelProperty(value="拆箱视频")
    private String openVideo;
    @ApiModelProperty(value="鉴定视频")
    private String platGoodsAuthVideo;
    @ApiModelProperty(value="时间")
    private String time;

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

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(String authPrice) {
        this.authPrice = authPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getGoVideo() {
        return goVideo;
    }

    public void setGoVideo(String goVideo) {
        this.goVideo = goVideo;
    }

    public String getOpenVideo() {
        return openVideo;
    }

    public void setOpenVideo(String openVideo) {
        this.openVideo = openVideo;
    }

    public String getPlatGoodsAuthVideo() {
        return platGoodsAuthVideo;
    }

    public void setPlatGoodsAuthVideo(String platGoodsAuthVideo) {
        this.platGoodsAuthVideo = platGoodsAuthVideo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
