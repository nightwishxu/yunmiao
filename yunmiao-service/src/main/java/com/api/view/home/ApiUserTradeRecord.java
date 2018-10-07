package com.api.view.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 用户交易记录
 * @author vonkira
 *
 */
@ApiModel
public class ApiUserTradeRecord {

    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="宝贝id")
    private Integer goodsId;
    @ApiModelProperty(value="图片")
    private String images;
    @ApiModelProperty(value="宝贝名称")
    private String title;
    @ApiModelProperty(value="类型 -1已取消 1竞拍中  2已典当 3赎当 4绝当 5宝祥兜底")
    private Integer type;
    @ApiModelProperty(value="鉴定价")
    private String authPrice;
    @ApiModelProperty(value="录入时间")
    private String createTime;
    @ApiModelProperty(value="当前典当机构名称")
    private String orgName;
    @ApiModelProperty(value="当号")
    private String pawnTicketCode;
    @ApiModelProperty(value="流通记录")
    private List<ApiUserPawnRecord> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(String authPrice) {
        this.authPrice = authPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPawnTicketCode() {
        return pawnTicketCode;
    }

    public void setPawnTicketCode(String pawnTicketCode) {
        this.pawnTicketCode = pawnTicketCode;
    }

    public List<ApiUserPawnRecord> getList() {
        return list;
    }

    public void setList(List<ApiUserPawnRecord> list) {
        this.list = list;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
