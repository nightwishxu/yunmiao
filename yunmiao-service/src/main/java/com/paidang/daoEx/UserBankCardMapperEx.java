package com.paidang.daoEx;

import com.paidang.daoEx.model.UserBankCardEx;

import java.util.Map; /**
@author sun
*/
public interface UserBankCardMapperEx {
    UserBankCardEx selectByUser(Map<String, Object> map);
}
