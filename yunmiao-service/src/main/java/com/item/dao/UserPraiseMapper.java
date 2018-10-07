package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.UserPraise;
import com.item.dao.model.UserPraiseExample;

public interface UserPraiseMapper {
	int countByExample(UserPraiseExample example);

	int deleteByExample(UserPraiseExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserPraise record);

	int insertSelective(UserPraise record);

	List<UserPraise> selectByExample(UserPraiseExample example);

	UserPraise selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserPraise record,@Param("example") UserPraiseExample example);

	int updateByExample(@Param("record") UserPraise record,@Param("example") UserPraiseExample example);

	int updateByPrimaryKeySelective(UserPraise record);

	int updateByPrimaryKey(UserPraise record);

}
