package com.item.daoEx.model;

import com.item.dao.model.UserFollow;

/**
@author sun
*/
public class UserFollowEx extends UserFollow {

    private String userHeadImg;

    private String userNickName;

    private String followHeadImg;

    private String followNickName;

    private Integer userArticleCount;
    
    private Integer followArticleCount;

    private Integer userFansCount;

    private Integer followFansCount;

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getFollowHeadImg() {
        return followHeadImg;
    }

    public void setFollowHeadImg(String followHeadImg) {
        this.followHeadImg = followHeadImg;
    }

    public String getFollowNickName() {
        return followNickName;
    }

    public void setFollowNickName(String followNickName) {
        this.followNickName = followNickName;
    }

    public Integer getUserArticleCount() {
        return userArticleCount;
    }

    public void setUserArticleCount(Integer userArticleCount) {
        this.userArticleCount = userArticleCount;
    }

    public Integer getFollowArticleCount() {
        return followArticleCount;
    }

    public void setFollowArticleCount(Integer followArticleCount) {
        this.followArticleCount = followArticleCount;
    }

    public Integer getUserFansCount() {
        return userFansCount;
    }

    public void setUserFansCount(Integer userFansCount) {
        this.userFansCount = userFansCount;
    }

    public Integer getFollowFansCount() {
        return followFansCount;
    }

    public void setFollowFansCount(Integer followFansCount) {
        this.followFansCount = followFansCount;
    }
}