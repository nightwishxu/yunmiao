package com.api.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户消息
 */
@ApiModel
public class AppUserNotify {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="用户id")
    private Integer user_id;
    @ApiModelProperty(value="群发id")
    private Integer nid;
    @ApiModelProperty(value="类型(1系统通知)")
    private Integer type;
    @ApiModelProperty(value="标题")
    private String title;
    @ApiModelProperty(value="内容")
    private String content;
    //@ApiModelProperty(value="0：鉴定真品 1:续当通知 2滞纳通知 3竞拍成功通知 4用户赎当 5绝当通知 6拍当 7系统消息 8到期提醒通知")
    @ApiModelProperty(value="0:鉴定为真品 1:典当成功通知  2续当到期通知  3赎当通知  4赎当邮寄通知  5邮寄通知  6到款通知 7鉴宝信息 8当品被竞拍通知  9绝当 10交易")
    private Integer redirectType;
    @ApiModelProperty(value="是否已读 0:未读 1:已读")
    private Integer isRead;
    @ApiModelProperty(value="时间")
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(Integer redirectType) {
        this.redirectType = redirectType;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
