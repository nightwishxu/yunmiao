package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.Right;
import com.item.dao.model.RightExample;

public interface RightMapper {
	int countByExample(RightExample example);

	int deleteByExample(RightExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Right record);

	int insertSelective(Right record);

	List<Right> selectByExample(RightExample example);

	Right selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Right record,@Param("example") RightExample example);

	int updateByExample(@Param("record") Right record,@Param("example") RightExample example);

	int updateByPrimaryKeySelective(Right record);

	int updateByPrimaryKey(Right record);

}
