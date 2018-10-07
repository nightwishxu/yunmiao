package com.api.view.orgDeadPawnage;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2018/2/5.
 *
 * ExpressDetail内快递状态详细内容
 */
public class ExpressContext {

    @ApiModelProperty("物流状态详细内容")
    private String context;

    @ApiModelProperty("ftime")
    private String ftime;

    @ApiModelProperty("time")
    private String time;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getFtime() {
        return ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
