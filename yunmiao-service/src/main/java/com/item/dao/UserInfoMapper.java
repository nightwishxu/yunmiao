package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.UserInfo;
import com.item.dao.model.UserInfoExample;

public interface UserInfoMapper {
	int countByExample(UserInfoExample example);

	int deleteByExample(UserInfoExample example);

	int deleteByPrimaryKey(Integer user_id);

	int insert(UserInfo record);

	int insertSelective(UserInfo record);

	List<UserInfo> selectByExample(UserInfoExample example);

	UserInfo selectByPrimaryKey(Integer user_id);

	int updateByExampleSelective(@Param("record") UserInfo record,@Param("example") UserInfoExample example);

	int updateByExample(@Param("record") UserInfo record,@Param("example") UserInfoExample example);

	int updateByPrimaryKeySelective(UserInfo record);

	int updateByPrimaryKey(UserInfo record);

}
