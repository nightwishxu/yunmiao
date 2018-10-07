package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.PawnLog;
import com.paidang.dao.model.PawnLogExample;

public interface PawnLogMapper {
	int countByExample(PawnLogExample example);

	int deleteByExample(PawnLogExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(PawnLog record);

	int insertSelective(PawnLog record);

	List<PawnLog> selectByExample(PawnLogExample example);

	PawnLog selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") PawnLog record,@Param("example") PawnLogExample example);

	int updateByExample(@Param("record") PawnLog record,@Param("example") PawnLogExample example);

	int updateByPrimaryKeySelective(PawnLog record);

	int updateByPrimaryKey(PawnLog record);

}
