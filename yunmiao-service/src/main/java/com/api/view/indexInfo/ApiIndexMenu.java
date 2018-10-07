package com.api.view.indexInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiIndexMenu {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="封面")
    private String img;
    @ApiModelProperty(value="标题")
    private String title;
    @ApiModelProperty(value="价格")
    private String price;
    @ApiModelProperty(value="竞拍次数")
    private Integer aucCount;
    @ApiModelProperty(value="结束竞拍时间--年月日")
    private String endTime;
    @ApiModelProperty(value="结束竞拍时间--秒")
    private String endTime2;
    @ApiModelProperty(value="类型(1.认证商场 2.绝当新品 3.热门竞拍 4.视频)")
    private Integer state;
    @ApiModelProperty(value="当前最高价")
    private String maxPrice;
    @ApiModelProperty(value="我的出价 ")
    private String myPrice;
    @ApiModelProperty(value="商品类型 ")
    private String goodsType;

    @ApiModelProperty(value="机构id ")
    private Integer orgId;

    @ApiModelProperty(value="机构名称 ")
    private String orgName;

    @ApiModelProperty(value="商品来源2机构3服务商4供应商 ")
    private Integer source;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getAucCount() {
        return aucCount;
    }

    public void setAucCount(Integer aucCount) {
        this.aucCount = aucCount;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getEndTime2() {
        return endTime2;
    }

    public void setEndTime2(String endTime2) {
        this.endTime2 = endTime2;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMyPrice() {
        return myPrice;
    }

    public void setMyPrice(String myPrice) {
        this.myPrice = myPrice;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}
