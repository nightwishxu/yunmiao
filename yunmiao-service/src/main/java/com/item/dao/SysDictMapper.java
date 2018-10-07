package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.SysDict;
import com.item.dao.model.SysDictExample;

public interface SysDictMapper {
	int countByExample(SysDictExample example);

	int deleteByExample(SysDictExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SysDict record);

	int insertSelective(SysDict record);

	List<SysDict> selectByExample(SysDictExample example);

	SysDict selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") SysDict record,@Param("example") SysDictExample example);

	int updateByExample(@Param("record") SysDict record,@Param("example") SysDictExample example);

	int updateByPrimaryKeySelective(SysDict record);

	int updateByPrimaryKey(SysDict record);

}
