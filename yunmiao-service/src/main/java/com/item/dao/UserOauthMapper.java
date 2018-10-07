package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.UserOauth;
import com.item.dao.model.UserOauthExample;

public interface UserOauthMapper {
	int countByExample(UserOauthExample example);

	int deleteByExample(UserOauthExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserOauth record);

	int insertSelective(UserOauth record);

	List<UserOauth> selectByExample(UserOauthExample example);

	UserOauth selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserOauth record,@Param("example") UserOauthExample example);

	int updateByExample(@Param("record") UserOauth record,@Param("example") UserOauthExample example);

	int updateByPrimaryKeySelective(UserOauth record);

	int updateByPrimaryKey(UserOauth record);

}
