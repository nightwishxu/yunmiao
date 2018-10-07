package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.UserFollow;
import com.item.dao.model.UserFollowExample;

public interface UserFollowMapper {
	int countByExample(UserFollowExample example);

	int deleteByExample(UserFollowExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserFollow record);

	int insertSelective(UserFollow record);

	List<UserFollow> selectByExample(UserFollowExample example);

	UserFollow selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserFollow record,@Param("example") UserFollowExample example);

	int updateByExample(@Param("record") UserFollow record,@Param("example") UserFollowExample example);

	int updateByPrimaryKeySelective(UserFollow record);

	int updateByPrimaryKey(UserFollow record);

}
