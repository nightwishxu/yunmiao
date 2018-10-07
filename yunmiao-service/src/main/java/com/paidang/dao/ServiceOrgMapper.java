package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.ServiceOrg;
import com.paidang.dao.model.ServiceOrgExample;

public interface ServiceOrgMapper {
	int countByExample(ServiceOrgExample example);

	int deleteByExample(ServiceOrgExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(ServiceOrg record);

	int insertSelective(ServiceOrg record);

	List<ServiceOrg> selectByExample(ServiceOrgExample example);

	ServiceOrg selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") ServiceOrg record,@Param("example") ServiceOrgExample example);

	int updateByExample(@Param("record") ServiceOrg record,@Param("example") ServiceOrgExample example);

	int updateByPrimaryKeySelective(ServiceOrg record);

	int updateByPrimaryKey(ServiceOrg record);

}
