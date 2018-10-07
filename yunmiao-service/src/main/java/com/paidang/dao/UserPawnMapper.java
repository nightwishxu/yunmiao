package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.UserPawn;
import com.paidang.dao.model.UserPawnExample;

public interface UserPawnMapper {
	int countByExample(UserPawnExample example);

	int deleteByExample(UserPawnExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserPawn record);

	int insertSelective(UserPawn record);

	List<UserPawn> selectByExample(UserPawnExample example);

	UserPawn selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserPawn record,@Param("example") UserPawnExample example);

	int updateByExample(@Param("record") UserPawn record,@Param("example") UserPawnExample example);

	int updateByPrimaryKeySelective(UserPawn record);

	int updateByPrimaryKey(UserPawn record);

}
