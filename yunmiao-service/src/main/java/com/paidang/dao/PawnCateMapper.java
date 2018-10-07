package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.PawnCate;
import com.paidang.dao.model.PawnCateExample;

public interface PawnCateMapper {
	int countByExample(PawnCateExample example);

	int deleteByExample(PawnCateExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(PawnCate record);

	int insertSelective(PawnCate record);

	List<PawnCate> selectByExample(PawnCateExample example);

	PawnCate selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") PawnCate record,@Param("example") PawnCateExample example);

	int updateByExample(@Param("record") PawnCate record,@Param("example") PawnCateExample example);

	int updateByPrimaryKeySelective(PawnCate record);

	int updateByPrimaryKey(PawnCate record);

}
