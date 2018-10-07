package com.api.view.orgFirstPage.message;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/11/2.
 */
public class OrgNotifyInfo {

    @ApiModelProperty(value="消息id")
    private int id;
    @ApiModelProperty(value="标题")
    private String title;
    @ApiModelProperty(value="创建时间")
    private String createTime;
    @ApiModelProperty(value="是否已读 0:未读 1:已读")
    private int isRead;
    @ApiModelProperty(value="内容")
    private String content;
/*    @ApiModelProperty(value="0:不跳转 1:续当通知 2滞纳通知 3竞拍成功通知 4用户赎当 5绝当通知 ")
    private int redirectType;
    @ApiModelProperty(value="")
    private String redirectContent;
    @ApiModelProperty(value="类型 1:系统通知")
    private int type;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

   /* public int getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(int redirectType) {
        this.redirectType = redirectType;
    }

    public String getRedirectContent() {
        return redirectContent;
    }

    public void setRedirectContent(String redirectContent) {
        this.redirectContent = redirectContent;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }*/
}
