package com.paidang.daoEx;

import com.paidang.daoEx.model.OrgBalanceLogEx;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
@author sun
*/
public interface OrgBalanceLogMapperEx {

    //获取APP我的->资金流水记录
    List<OrgBalanceLogEx> getCapitalRunningAccountList(@Param("orgId")Integer orgId,@Param("beginDate") Date beginDate, @Param("endDate") Date endDate);
}
