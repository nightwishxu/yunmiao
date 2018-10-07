package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.Express;
import com.paidang.dao.model.ExpressExample;

public interface ExpressMapper {
	int countByExample(ExpressExample example);

	int deleteByExample(ExpressExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Express record);

	int insertSelective(Express record);

	List<Express> selectByExample(ExpressExample example);

	List<Express> selectByExampleWithBLOBs(ExpressExample example);

	Express selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Express record,@Param("example") ExpressExample example);

	int updateByExampleWithBLOBs(@Param("record") Express record, @Param("example") ExpressExample example);

	int updateByExample(@Param("record") Express record,@Param("example") ExpressExample example);

	int updateByPrimaryKeySelective(Express record);

	int updateByPrimaryKeyWithBLOBs(Express record);

	int updateByPrimaryKey(Express record);

}
