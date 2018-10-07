package com.paidang.daoEx.model;

import com.paidang.dao.model.PlatformGoodsBuy;

/**
@author sun
*/
public class PlatformGoodsBuyEx extends PlatformGoodsBuy {
    /**
     * 付款凭条
     */
    private String ticket;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}