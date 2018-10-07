package com.paidang.daoEx;

import com.paidang.daoEx.model.ExpressEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
@author sun
*/
public interface ExpressMapperEx {

    List<ExpressEx> searchByName(@Param("keyword")String keyword,@Param("orgId")String orgId);

    List<ExpressEx> selectByGoods(Map<String, Object> map);

    List<ExpressEx> findUnReceived(Map<String,Object> map);
}
