package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.PayLog;
import com.item.dao.model.PayLogExample;

public interface PayLogMapper {
	int countByExample(PayLogExample example);

	int deleteByExample(PayLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PayLog record);

	int insertSelective(PayLog record);

	List<PayLog> selectByExample(PayLogExample example);

	PayLog selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PayLog record,@Param("example") PayLogExample example);

	int updateByExample(@Param("record") PayLog record,@Param("example") PayLogExample example);

	int updateByPrimaryKeySelective(PayLog record);

	int updateByPrimaryKey(PayLog record);

}
