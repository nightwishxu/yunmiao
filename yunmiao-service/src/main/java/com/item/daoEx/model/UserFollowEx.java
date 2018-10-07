package com.item.daoEx.model;

import com.item.dao.model.UserFollow;

/**
@author sun
*/
public class UserFollowEx extends UserFollow {

    private String userHeadImg;

    private String userNickName;

    private String operateHeadImg;

    private String operateNickName;

    private Integer userArticleCount;
    
    private Integer operateArticleCount;

    private Integer userFansCount;

    private Integer operateFansCount;

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

    public String getOperateHeadImg() {
        return operateHeadImg;
    }

    public void setOperateHeadImg(String operateHeadImg) {
        this.operateHeadImg = operateHeadImg;
    }

    public String getOperateNickName() {
        return operateNickName;
    }

    public void setOperateNickName(String operateNickName) {
        this.operateNickName = operateNickName;
    }

    public Integer getUserArticleCount() {
        return userArticleCount;
    }

    public void setUserArticleCount(Integer userArticleCount) {
        this.userArticleCount = userArticleCount;
    }

    public Integer getOperateArticleCount() {
        return operateArticleCount;
    }

    public void setOperateArticleCount(Integer operateArticleCount) {
        this.operateArticleCount = operateArticleCount;
    }

    public Integer getUserFansCount() {
        return userFansCount;
    }

    public void setUserFansCount(Integer userFansCount) {
        this.userFansCount = userFansCount;
    }

    public Integer getOperateFansCount() {
        return operateFansCount;
    }

    public void setOperateFansCount(Integer operateFansCount) {
        this.operateFansCount = operateFansCount;
    }
}