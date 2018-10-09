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


	/**
	 * 获取用户粉丝信息
	 * @param userId
	 * @return
	 */
	List<UserEx> getUserFollow(Integer userId);

	/**
	 * 返回自己关注人也关注的人
	 * @param userId
	 * @return
	 */
	List<UserEx> getUserFollowInterest(Integer userId);


	/**
	 * 根据粉丝数量排序
	 * @param userId
	 * @return
	 */
	List<UserEx> getUserFollowInterestByFans(Integer userId);
}