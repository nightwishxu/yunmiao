package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.OrgBalanceLog;
import com.paidang.dao.model.OrgBalanceLogExample;

public interface OrgBalanceLogMapper {
	int countByExample(OrgBalanceLogExample example);

	int deleteByExample(OrgBalanceLogExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(OrgBalanceLog record);

	int insertSelective(OrgBalanceLog record);

	List<OrgBalanceLog> selectByExample(OrgBalanceLogExample example);

	OrgBalanceLog selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") OrgBalanceLog record,@Param("example") OrgBalanceLogExample example);

	int updateByExample(@Param("record") OrgBalanceLog record,@Param("example") OrgBalanceLogExample example);

	int updateByPrimaryKeySelective(OrgBalanceLog record);

	int updateByPrimaryKey(OrgBalanceLog record);

}
