package com.paidang.daoEx.model;

import com.paidang.dao.model.VideoOnline;

/**
@author sun
*/
public class VideoOnlineEx extends VideoOnline {
    private Integer commCount;

    public Integer getCommCount() {
        return commCount;
    }

    public void setCommCount(Integer commCount) {
        this.commCount = commCount;
    }
}