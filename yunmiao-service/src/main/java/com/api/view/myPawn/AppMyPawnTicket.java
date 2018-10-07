package com.api.view.myPawn;

import io.swagger.annotations.ApiModelProperty;

/**
 * 打款凭证
 */
public class AppMyPawnTicket {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="类型 1机构打款凭证 2续当打款凭证 3赎当打款凭证")
    private Integer state;
    @ApiModelProperty(value="凭证")
    private String ticket;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
