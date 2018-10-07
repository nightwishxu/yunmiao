package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.UserOption;
import com.item.dao.model.UserOptionExample;

public interface UserOptionMapper {
	int countByExample(UserOptionExample example);

	int deleteByExample(UserOptionExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserOption record);

	int insertSelective(UserOption record);

	List<UserOption> selectByExample(UserOptionExample example);

	UserOption selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserOption record,@Param("example") UserOptionExample example);

	int updateByExample(@Param("record") UserOption record,@Param("example") UserOptionExample example);

	int updateByPrimaryKeySelective(UserOption record);

	int updateByPrimaryKey(UserOption record);

}
