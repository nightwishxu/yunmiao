package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.ExperterInfo;
import com.paidang.dao.model.ExperterInfoExample;

public interface ExperterInfoMapper {
	int countByExample(ExperterInfoExample example);

	int deleteByExample(ExperterInfoExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(ExperterInfo record);

	int insertSelective(ExperterInfo record);

	List<ExperterInfo> selectByExample(ExperterInfoExample example);

	ExperterInfo selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") ExperterInfo record,@Param("example") ExperterInfoExample example);

	int updateByExample(@Param("record") ExperterInfo record,@Param("example") ExperterInfoExample example);

	int updateByPrimaryKeySelective(ExperterInfo record);

	int updateByPrimaryKey(ExperterInfo record);

}
