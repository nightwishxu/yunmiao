package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.UserBankCard;
import com.paidang.dao.model.UserBankCardExample;

public interface UserBankCardMapper {
	int countByExample(UserBankCardExample example);

	int deleteByExample(UserBankCardExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserBankCard record);

	int insertSelective(UserBankCard record);

	List<UserBankCard> selectByExample(UserBankCardExample example);

	UserBankCard selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserBankCard record,@Param("example") UserBankCardExample example);

	int updateByExample(@Param("record") UserBankCard record,@Param("example") UserBankCardExample example);

	int updateByPrimaryKeySelective(UserBankCard record);

	int updateByPrimaryKey(UserBankCard record);

}
