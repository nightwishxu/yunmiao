package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.UserGroup;
import com.item.dao.model.UserGroupExample;

public interface UserGroupMapper {
	int countByExample(UserGroupExample example);

	int deleteByExample(UserGroupExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserGroup record);

	int insertSelective(UserGroup record);

	List<UserGroup> selectByExample(UserGroupExample example);

	UserGroup selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserGroup record,@Param("example") UserGroupExample example);

	int updateByExample(@Param("record") UserGroup record,@Param("example") UserGroupExample example);

	int updateByPrimaryKeySelective(UserGroup record);

	int updateByPrimaryKey(UserGroup record);

}
