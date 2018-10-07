package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.UserBalanceLog;
import com.paidang.dao.model.UserBalanceLogExample;

public interface UserBalanceLogMapper {
	int countByExample(UserBalanceLogExample example);

	int deleteByExample(UserBalanceLogExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserBalanceLog record);

	int insertSelective(UserBalanceLog record);

	List<UserBalanceLog> selectByExample(UserBalanceLogExample example);

	UserBalanceLog selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserBalanceLog record,@Param("example") UserBalanceLogExample example);

	int updateByExample(@Param("record") UserBalanceLog record,@Param("example") UserBalanceLogExample example);

	int updateByPrimaryKeySelective(UserBalanceLog record);

	int updateByPrimaryKey(UserBalanceLog record);

}
