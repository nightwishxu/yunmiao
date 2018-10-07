package com.api.view.orgHome.myPawners;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Lee on 2017/10/19.
 *
 * 个人中心 点击打开 我的当户内每个元素返回model
 */
@ApiModel
public class MyPawner {

    @ApiModelProperty("当户id")
    private String pawnerId;

    @ApiModelProperty("当户名")
    private String pawnerName;

    @ApiModelProperty("用户头像图片")
    private String userPic;

    @ApiModelProperty("当户电话")
    private String pawnerTelNum;

    @ApiModelProperty("总借贷金额")
    private String totalLoan;

    @ApiModelProperty("当户身份证号码")
    private String idCardNum;

    @ApiModelProperty("当户地址")
    private String pawnerAddress;

    public String getPawnerId() {
        return pawnerId;
    }

    public void setPawnerId(String pawnerId) {
        this.pawnerId = pawnerId;
    }

    public String getPawnerName() {
        return pawnerName;
    }

    public void setPawnerName(String pawnerName) {
        this.pawnerName = pawnerName;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getPawnerTelNum() {
        return pawnerTelNum;
    }

    public void setPawnerTelNum(String pawnerTelNum) {
        this.pawnerTelNum = pawnerTelNum;
    }

    public String getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(String totalLoan) {
        this.totalLoan = totalLoan;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getPawnerAddress() {
        return pawnerAddress;
    }

    public void setPawnerAddress(String pawnerAddress) {
        this.pawnerAddress = pawnerAddress;
    }
}
