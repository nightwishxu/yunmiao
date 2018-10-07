package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.Diamond;
import com.paidang.dao.model.DiamondExample;

public interface DiamondMapper {
	int countByExample(DiamondExample example);

	int deleteByExample(DiamondExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Diamond record);

	int insertSelective(Diamond record);

	List<Diamond> selectByExample(DiamondExample example);

	Diamond selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Diamond record,@Param("example") DiamondExample example);

	int updateByExample(@Param("record") Diamond record,@Param("example") DiamondExample example);

	int updateByPrimaryKeySelective(Diamond record);

	int updateByPrimaryKey(Diamond record);

}
