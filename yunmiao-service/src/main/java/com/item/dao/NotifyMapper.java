package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.Notify;
import com.item.dao.model.NotifyExample;

public interface NotifyMapper {
	int countByExample(NotifyExample example);

	int deleteByExample(NotifyExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Notify record);

	int insertSelective(Notify record);

	List<Notify> selectByExample(NotifyExample example);

	Notify selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Notify record,@Param("example") NotifyExample example);

	int updateByExample(@Param("record") Notify record,@Param("example") NotifyExample example);

	int updateByPrimaryKeySelective(Notify record);

	int updateByPrimaryKey(Notify record);

}
