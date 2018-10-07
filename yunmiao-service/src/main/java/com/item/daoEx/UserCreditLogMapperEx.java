package com.item.daoEx;

import java.util.List;
import java.util.Map;

import com.item.daoEx.model.UserCreditLogEx;


public interface UserCreditLogMapperEx{

	List<UserCreditLogEx> selectList(Map<String, Object> map);

}