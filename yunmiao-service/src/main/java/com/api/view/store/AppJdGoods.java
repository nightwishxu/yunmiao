package com.api.view.store;

import com.paidang.dao.model.GoodsAuction;
import com.paidang.daoEx.model.GoodsAuctionEx;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 绝当商城商品
 */
public class AppJdGoods {
    @ApiModelProperty(value="商品id")
    private Integer id;
    @ApiModelProperty(value="商品图片")
    private String images;
    @ApiModelProperty(value="商品名字")
    private String goodsName;
    @ApiModelProperty(value="鉴定价--起价")
    private String authPrice;
    @ApiModelProperty(value="当前价")
    private String price;
    @ApiModelProperty(value="倒计时")
    private String time;
    @ApiModelProperty(value="竞拍记录")
    private List<GoodsAuctionEx> goodsAuctionList;
    @ApiModelProperty(value="物品描述")
    private String content;

    @ApiModelProperty(value="机构id")
    private Integer orgId;
    @ApiModelProperty(value="机构名称")
    private String orgName;
    @ApiModelProperty(value="机构介绍")
    private String orgIntroduction;

    @ApiModelProperty(value="机构Logo")
    private String orgLogo;

    @ApiModelProperty(value="商品来源2机构3服务商4供应商")
    private Integer source;

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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(String authPrice) {
        this.authPrice = authPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<GoodsAuctionEx> getGoodsAuctionList() {
        return goodsAuctionList;
    }

    public void setGoodsAuctionList(List<GoodsAuctionEx> goodsAuctionList) {
        this.goodsAuctionList = goodsAuctionList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    public String getOrgIntroduction() {
        return orgIntroduction;
    }

    public void setOrgIntroduction(String orgIntroduction) {
        this.orgIntroduction = orgIntroduction;
    }

    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}
