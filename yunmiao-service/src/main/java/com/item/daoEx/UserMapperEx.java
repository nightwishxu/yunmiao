package com.item.daoEx;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.item.daoEx.model.UserEx;


public interface UserMapperEx{

	List<UserEx> selectList(Map<String, Object> map);

	void updateBalance(Map<String, Object> map);

	List<Integer> selectIdByAccounts(@Param("accounts")List<String> accounts);
	
	Integer selectIdByAccount(String account);
	
	String selectAccountById(String id);

	//机构后台，用户列表
	List<UserEx> selectOrgUsersList(Map<String, Object> map);

	UserEx selectByAccount(String record);

} 