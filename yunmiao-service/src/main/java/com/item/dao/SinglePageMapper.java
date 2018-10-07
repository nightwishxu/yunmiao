package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.SinglePage;
import com.item.dao.model.SinglePageExample;

public interface SinglePageMapper {
	int countByExample(SinglePageExample example);

	int deleteByExample(SinglePageExample example);

	int deleteByPrimaryKey(String code);

	int insert(SinglePage record);

	int insertSelective(SinglePage record);

	List<SinglePage> selectByExample(SinglePageExample example);

	List<SinglePage> selectByExampleWithBLOBs(SinglePageExample example);

	SinglePage selectByPrimaryKey(String code);

	int updateByExampleSelective(@Param("record") SinglePage record,@Param("example") SinglePageExample example);

	int updateByExampleWithBLOBs(@Param("record") SinglePage record, @Param("example") SinglePageExample example);

	int updateByExample(@Param("record") SinglePage record,@Param("example") SinglePageExample example);

	int updateByPrimaryKeySelective(SinglePage record);

	int updateByPrimaryKeyWithBLOBs(SinglePage record);

	int updateByPrimaryKey(SinglePage record);

}
