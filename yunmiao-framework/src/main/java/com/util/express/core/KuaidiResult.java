package com.util.express.core;

import com.base.util.JSONUtils;

import java.util.List;

/**
 * 快递结果
 */
public class KuaidiResult {

    public KuaidiResult(){
    }

    public KuaidiResult(String json){
        KuaidiResult result = JSONUtils.deserialize(json,KuaidiResult.class);
        this.state = result.getState();
        this.data = result.getData();
        this.status = result.getStatus();
    }

    /**
     * 快递单当前的状态 ：　
     0：在途，即货物处于运输过程中；
     1：揽件，货物已由快递公司揽收并且产生了第一条跟踪信息；
     2：疑难，货物寄送过程出了问题；
     3：签收，收件人已签收；
     4：退签，即货物由于用户拒签、超区等原因退回，而且发件人已经签收；
     5：派件，即快递正在进行同城派件；
     6：退回，货物正处于退回发件人的途中；
     */
    private int state;
    /**
     * 0：物流单暂无结果，
     1：查询成功，
     2：接口出现异常，
     */
    private int status;
    /**
     * 物流数据
     */
    private List<KuaidiData> data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<KuaidiData> getData() {
        return data;
    }

    public void setData(List<KuaidiData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSONUtils.serialize(this);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
