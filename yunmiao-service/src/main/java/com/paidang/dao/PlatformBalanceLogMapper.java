package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.PlatformBalanceLog;
import com.paidang.dao.model.PlatformBalanceLogExample;

public interface PlatformBalanceLogMapper {
	int countByExample(PlatformBalanceLogExample example);

	int deleteByExample(PlatformBalanceLogExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(PlatformBalanceLog record);

	int insertSelective(PlatformBalanceLog record);

	List<PlatformBalanceLog> selectByExample(PlatformBalanceLogExample example);

	PlatformBalanceLog selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") PlatformBalanceLog record,@Param("example") PlatformBalanceLogExample example);

	int updateByExample(@Param("record") PlatformBalanceLog record,@Param("example") PlatformBalanceLogExample example);

	int updateByPrimaryKeySelective(PlatformBalanceLog record);

	int updateByPrimaryKey(PlatformBalanceLog record);

}
