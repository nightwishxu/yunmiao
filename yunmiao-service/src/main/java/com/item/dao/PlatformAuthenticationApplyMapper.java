package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.PlatformAuthenticationApply;
import com.item.dao.model.PlatformAuthenticationApplyExample;

public interface PlatformAuthenticationApplyMapper {
	int countByExample(PlatformAuthenticationApplyExample example);

	int deleteByExample(PlatformAuthenticationApplyExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(PlatformAuthenticationApply record);

	int insertSelective(PlatformAuthenticationApply record);

	List<PlatformAuthenticationApply> selectByExample(PlatformAuthenticationApplyExample example);

	PlatformAuthenticationApply selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") PlatformAuthenticationApply record,@Param("example") PlatformAuthenticationApplyExample example);

	int updateByExample(@Param("record") PlatformAuthenticationApply record,@Param("example") PlatformAuthenticationApplyExample example);

	int updateByPrimaryKeySelective(PlatformAuthenticationApply record);

	int updateByPrimaryKey(PlatformAuthenticationApply record);

}
