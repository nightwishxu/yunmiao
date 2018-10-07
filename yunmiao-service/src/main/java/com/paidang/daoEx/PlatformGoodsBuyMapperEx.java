package com.paidang.daoEx;

import com.base.entity.QueryParams;
import com.paidang.daoEx.model.PlatformGoodsBuyEx;

import java.util.List;
import java.util.Map;
/**
@author sun
*/
public interface PlatformGoodsBuyMapperEx {
    List<PlatformGoodsBuyEx> selectPlatformGoods(QueryParams.Builder builder);

    int changeStateByPrimaryKey(PlatformGoodsBuyEx record);

    int updateByTickect(PlatformGoodsBuyEx record);
}
