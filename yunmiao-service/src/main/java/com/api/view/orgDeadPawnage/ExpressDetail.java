package com.api.view.orgDeadPawnage;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by Lee on 2018/2/5.
 *
 * 物流详情 每个元素 model
 */
public class ExpressDetail {

    @ApiModelProperty("物流状态详细内容")
    private List<ExpressContext> data;

    @ApiModelProperty("快件当前状态 0：在途1：揽件2：疑难3：签收4：退签或异常签收5：派件6：退回")
    private String state;

    @ApiModelProperty("http请求返回状态值")
    private String status;

    public List<ExpressContext> getData() {
        return data;
    }

    public void setData(List<ExpressContext> data) {
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
