package com.api.view.indexInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
/**
 * 首页轮播图
 */
public class IndexInfo {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="首页轮播图片")
    private String index_images;
    @ApiModelProperty(value="首页拍档头条")
    private String pawnMsg;
    @ApiModelProperty(value="类型1 首页轮播图  2拍档头条")
    private Integer state;
    @ApiModelProperty(value="类型 0不跳转；1网址；2富文本；3认证商城商品详情页；4绝当商城商品详情页；5视频详情页")
    private Integer type;
    @ApiModelProperty(value="内容 null、跳转url、富文本内容、商品id、视频id")
    private String content;
    @ApiModelProperty(value="类型1绝当竞拍  2绝当普通拍卖")
    private Integer cstate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndex_images() {
        return index_images;
    }

    public void setIndex_images(String index_images) {
        this.index_images = index_images;
    }

    public String getPawnMsg() {
        return pawnMsg;
    }

    public void setPawnMsg(String pawnMsg) {
        this.pawnMsg = pawnMsg;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCstate() {
        return cstate;
    }

    public void setCstate(Integer cstate) {
        this.cstate = cstate;
    }
}
