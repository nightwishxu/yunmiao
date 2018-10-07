package com.api.view.orgHome.myPawners;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created by Lee on 2017/9/25.
 *
 * 我的当户，该当户详情 返回model
 */
@ApiModel
public class MyPawnerDetail extends MyPawner {

    @ApiModelProperty("该当户典当的所有当品")
    private List<PawnedMini> list;


    /*//计算该当户在本机构总计有多少贷款
    public String getTotalLoan(){
        Integer amount = 0;
        for (PawnedMini element:this.list) {
            if(StringUtils.isNotEmpty(element.getLoanMoney())){
                amount += Integer.valueOf(element.getLoanMoney());
            }else{
                continue;
            }
        }
        return amount.toString();
    }*/

    public List<PawnedMini> getList() {
        return list;
    }

    public void setList(List<PawnedMini> list) {
        this.list = list;
    }

}
