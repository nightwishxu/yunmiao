package com.api.view.orgHome.contractRecord;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2018/1/30.
 */
public class ContractType {

    @ApiModelProperty("典当id")
    private String pawnId;

    @ApiModelProperty("续当id")
    private String repawnId;

    @ApiModelProperty("合同类型 1-典当 2-续当")
    private String contractType;

    @ApiModelProperty("签订时间")
    private String pawnBeginTime;

    public String getPawnId() {
        return pawnId;
    }

    public void setPawnId(String pawnId) {
        this.pawnId = pawnId;
    }

    public String getRepawnId() {
        return repawnId;
    }

    public void setRepawnId(String repawnId) {
        this.repawnId = repawnId;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getPawnBeginTime() {
        return pawnBeginTime;
    }

    public void setPawnBeginTime(String pawnBeginTime) {
        this.pawnBeginTime = pawnBeginTime;
    }
}
