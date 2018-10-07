package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.PawnContinue;
import com.paidang.dao.model.PawnContinueExample;

public interface PawnContinueMapper {
	int countByExample(PawnContinueExample example);

	int deleteByExample(PawnContinueExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(PawnContinue record);

	int insertSelective(PawnContinue record);

	List<PawnContinue> selectByExample(PawnContinueExample example);

	PawnContinue selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") PawnContinue record,@Param("example") PawnContinueExample example);

	int updateByExample(@Param("record") PawnContinue record,@Param("example") PawnContinueExample example);

	int updateByPrimaryKeySelective(PawnContinue record);

	int updateByPrimaryKey(PawnContinue record);

}
