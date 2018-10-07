package com.api.view.userComment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AppUserComment {

    /**
     *
     */
    private Integer id;

    /**
     *用户id
     */
    @ApiModelProperty(value="用户id",required = true)
    private Integer userId;


    /**
     *用户id
     */
    @ApiModelProperty(value="订单id",required = true)
    private Integer orderId;


    /**
     *用户名
     */
    @ApiModelProperty(value="用户名")
    private String userName;

    /**
     *商品id
     */
    @ApiModelProperty(value="商品id",required = true)
    private Integer goodsId;

    /**
     *商品名称
     */
    @ApiModelProperty(value="商品名称")
    private String goodsName;

    /**
     *机构id
     */
    @ApiModelProperty(value="机构id")
    private Integer orgId;

    /**
     *评价信息
     */
    @ApiModelProperty(value="评价信息")
    private String info;

    /**
     *评论图片，,隔开
     */
    @ApiModelProperty(value="评论图片")
    private String img;

    /**
     *评分 1-5
     */
    @ApiModelProperty(value="评分（1-5）",required = true)
    private Integer score;

    /**
     *后台回复人ID
     */
    private Integer replayUserId;

    /**
     *回复信息
     */
    private String replayInfo;

    /**
     *回复时间
     */
    private java.util.Date replayTime;

    /**
     *评价状态 0.删除，1.已评价， 2.客服已回复
     */
    private Integer status;

    /**
     *是否匿名（0不匿名 1  匿名）
     */
    @ApiModelProperty(value="匿名状态")
    private Integer showName;

    /**
     *创建时间
     */
    private java.util.Date createTime;

    /**
     *修改时间
     */
    private java.util.Date modifyTime;


}
