package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.Experter;
import com.paidang.dao.model.ExperterExample;

public interface ExperterMapper {
	int countByExample(ExperterExample example);

	int deleteByExample(ExperterExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Experter record);

	int insertSelective(Experter record);

	List<Experter> selectByExample(ExperterExample example);

	Experter selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Experter record,@Param("example") ExperterExample example);

	int updateByExample(@Param("record") Experter record,@Param("example") ExperterExample example);

	int updateByPrimaryKeySelective(Experter record);

	int updateByPrimaryKey(Experter record);

}
