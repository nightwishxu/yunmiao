package com.paidang.daoEx.model;

import com.paidang.dao.model.VideoOnlineComment;

/**
@author sun
*/
public class VideoOnlineCommentEx extends VideoOnlineComment {

    private String nickName;
    private String headImg;

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}