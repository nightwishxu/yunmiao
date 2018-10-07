package com.api.view.orgFirstPage.message;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/11/2.
 */
public class MessageIndex {

    @ApiModelProperty(value="消息类型id  1-续当通知2-滞纳通知3-竞拍成功通知4-赎当通知5-绝当通知 ...")
    private String typeId;
    @ApiModelProperty(value="消息类型名称")
    private String typeName;
    @ApiModelProperty(value="消息类型图片")
    private String typePic;
    @ApiModelProperty(value="内容：该类型里最新的一条")
    private OrgNotifyInfo orgNotifyInfo;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypePic() {
        return typePic;
    }

    public void setTypePic(String typePic) {
        this.typePic = typePic;
    }

    public OrgNotifyInfo getOrgNotifyInfo() {
        return orgNotifyInfo;
    }

    public void setOrgNotifyInfo(OrgNotifyInfo orgNotifyInfo) {
        this.orgNotifyInfo = orgNotifyInfo;
    }
}
