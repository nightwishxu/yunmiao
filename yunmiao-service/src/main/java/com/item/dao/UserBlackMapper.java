package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.UserBlack;
import com.item.dao.model.UserBlackExample;

public interface UserBlackMapper {
	int countByExample(UserBlackExample example);

	int deleteByExample(UserBlackExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserBlack record);

	int insertSelective(UserBlack record);

	List<UserBlack> selectByExample(UserBlackExample example);

	UserBlack selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserBlack record,@Param("example") UserBlackExample example);

	int updateByExample(@Param("record") UserBlack record,@Param("example") UserBlackExample example);

	int updateByPrimaryKeySelective(UserBlack record);

	int updateByPrimaryKey(UserBlack record);

}
