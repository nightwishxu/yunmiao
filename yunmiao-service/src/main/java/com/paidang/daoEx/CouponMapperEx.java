package com.paidang.daoEx;

import com.paidang.daoEx.model.CouponEx;

import java.util.List;
import java.util.Map;

/**
@author sun
*/
public interface CouponMapperEx {
    List<CouponEx> selectGoods(Map<String ,Object> map);
}
