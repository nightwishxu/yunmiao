package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.UserNotify;
import com.item.dao.model.UserNotifyExample;

public interface UserNotifyMapper {
	int countByExample(UserNotifyExample example);

	int deleteByExample(UserNotifyExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserNotify record);

	int insertSelective(UserNotify record);

	List<UserNotify> selectByExample(UserNotifyExample example);

	UserNotify selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserNotify record,@Param("example") UserNotifyExample example);

	int updateByExample(@Param("record") UserNotify record,@Param("example") UserNotifyExample example);

	int updateByPrimaryKeySelective(UserNotify record);

	int updateByPrimaryKey(UserNotify record);

}
