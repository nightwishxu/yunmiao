package com.paidang.daoEx;

import com.paidang.daoEx.model.UserAddressEx;

import java.util.List;
import java.util.Map; /**
@author sun
*/
public interface UserAddressMapperEx {
    List<UserAddressEx> selectByUser(Map<String, Object> map);
}
