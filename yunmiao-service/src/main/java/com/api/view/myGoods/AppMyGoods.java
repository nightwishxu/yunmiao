package com.api.view.myGoods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 我的鉴定--列表
 * @author vonkira
 *
 */
@ApiModel
public class AppMyGoods {
    @ApiModelProperty(value="宝贝id")
    private Integer id;
    @ApiModelProperty(value="名称")
    private String title;
    @ApiModelProperty(value="图片")
    private String image;
    @ApiModelProperty(value="鉴定结果(-1:无 0:未鉴定 1:鉴定中 2:无法鉴定 3:赝品 4:真品)")
    private Integer result;
    @ApiModelProperty(value="预估价")
    private String priceTest;
    @ApiModelProperty(value="鉴定价格")
    private String price;
    @ApiModelProperty(value="1未邮寄2邮寄中3平台确认")
    private Integer postState;
    @ApiModelProperty(value="用户把宝贝卖给平台，平台是否确认 -1:用户没有操作卖给平台  0：未确认 1：确认")
    private Integer platformIsVerify;
    @ApiModelProperty(value="用户把宝贝卖给平台，平台上传的打款凭证")
    private String platformPayTicket;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getPostState() {
        return postState;
    }

    public void setPostState(Integer postState) {
        this.postState = postState;
    }

    public String getPriceTest() {
        return priceTest;
    }

    public void setPriceTest(String priceTest) {
        this.priceTest = priceTest;
    }

    public Integer getPlatformIsVerify() {
        return platformIsVerify;
    }

    public void setPlatformIsVerify(Integer platformIsVerify) {
        this.platformIsVerify = platformIsVerify;
    }

    public String getPlatformPayTicket() {
        return platformPayTicket;
    }

    public void setPlatformPayTicket(String platformPayTicket) {
        this.platformPayTicket = platformPayTicket;
    }
}
