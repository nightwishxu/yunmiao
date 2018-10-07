package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.OrgBankCard;
import com.paidang.dao.model.OrgBankCardExample;

public interface OrgBankCardMapper {
	int countByExample(OrgBankCardExample example);

	int deleteByExample(OrgBankCardExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(OrgBankCard record);

	int insertSelective(OrgBankCard record);

	List<OrgBankCard> selectByExample(OrgBankCardExample example);

	OrgBankCard selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") OrgBankCard record,@Param("example") OrgBankCardExample example);

	int updateByExample(@Param("record") OrgBankCard record,@Param("example") OrgBankCardExample example);

	int updateByPrimaryKeySelective(OrgBankCard record);

	int updateByPrimaryKey(OrgBankCard record);

}
