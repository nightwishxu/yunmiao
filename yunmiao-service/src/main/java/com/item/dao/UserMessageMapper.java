package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.UserMessage;
import com.item.dao.model.UserMessageExample;

public interface UserMessageMapper {
	int countByExample(UserMessageExample example);

	int deleteByExample(UserMessageExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserMessage record);

	int insertSelective(UserMessage record);

	List<UserMessage> selectByExample(UserMessageExample example);

	UserMessage selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserMessage record,@Param("example") UserMessageExample example);

	int updateByExample(@Param("record") UserMessage record,@Param("example") UserMessageExample example);

	int updateByPrimaryKeySelective(UserMessage record);

	int updateByPrimaryKey(UserMessage record);

}
