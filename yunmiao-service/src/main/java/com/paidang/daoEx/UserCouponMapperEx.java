package com.paidang.daoEx;

import com.paidang.daoEx.model.UserCouponEx;

import java.util.List;
import java.util.Map; /**
@author sun
*/
public interface UserCouponMapperEx {
    List<UserCouponEx> selectByGoods(Map<String, Object> map);
}
