package com.item.daoEx.model;

import com.item.dao.model.UserMessage;

/**
@author sun
*/
public class UserMessageEx extends UserMessage {

    private String formUserNickName;
    private String formUserHeadImg;

    private String toUserNickName;
    private String toUserHeadImg;


    public String getFormUserNickName() {
        return formUserNickName;
    }

    public void setFormUserNickName(String formUserNickName) {
        this.formUserNickName = formUserNickName;
    }

    public String getFormUserHeadImg() {
        return formUserHeadImg;
    }

    public void setFormUserHeadImg(String formUserHeadImg) {
        this.formUserHeadImg = formUserHeadImg;
    }

    public String getToUserNickName() {
        return toUserNickName;
    }

    public void setToUserNickName(String toUserNickName) {
        this.toUserNickName = toUserNickName;
    }

    public String getToUserHeadImg() {
        return toUserHeadImg;
    }

    public void setToUserHeadImg(String toUserHeadImg) {
        this.toUserHeadImg = toUserHeadImg;
    }
}