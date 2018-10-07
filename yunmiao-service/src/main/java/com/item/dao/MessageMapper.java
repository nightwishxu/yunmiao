package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.Message;
import com.item.dao.model.MessageExample;

public interface MessageMapper {
	int countByExample(MessageExample example);

	int deleteByExample(MessageExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Message record);

	int insertSelective(Message record);

	List<Message> selectByExample(MessageExample example);

	Message selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Message record,@Param("example") MessageExample example);

	int updateByExample(@Param("record") Message record,@Param("example") MessageExample example);

	int updateByPrimaryKeySelective(Message record);

	int updateByPrimaryKey(Message record);

}
