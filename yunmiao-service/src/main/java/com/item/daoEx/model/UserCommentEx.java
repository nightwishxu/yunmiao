package com.item.daoEx.model;

import com.item.dao.model.UserComment;

/**
@author sun
*/
public class UserCommentEx extends UserComment {

    //用户头像
    private String userHeadImg;

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }
}