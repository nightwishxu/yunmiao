package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.PawnOrg;
import com.paidang.dao.model.PawnOrgExample;

public interface PawnOrgMapper {
	int countByExample(PawnOrgExample example);

	int deleteByExample(PawnOrgExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(PawnOrg record);

	int insertSelective(PawnOrg record);

	List<PawnOrg> selectByExample(PawnOrgExample example);

	List<PawnOrg> selectByExampleWithBLOBs(PawnOrgExample example);

	PawnOrg selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") PawnOrg record,@Param("example") PawnOrgExample example);

	int updateByExampleWithBLOBs(@Param("record") PawnOrg record, @Param("example") PawnOrgExample example);

	int updateByExample(@Param("record") PawnOrg record,@Param("example") PawnOrgExample example);

	int updateByPrimaryKeySelective(PawnOrg record);

	int updateByPrimaryKeyWithBLOBs(PawnOrg record);

	int updateByPrimaryKey(PawnOrg record);

}
