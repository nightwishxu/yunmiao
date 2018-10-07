package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.OrgAddress;
import com.paidang.dao.model.OrgAddressExample;

public interface OrgAddressMapper {
	int countByExample(OrgAddressExample example);

	int deleteByExample(OrgAddressExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(OrgAddress record);

	int insertSelective(OrgAddress record);

	List<OrgAddress> selectByExample(OrgAddressExample example);

	OrgAddress selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") OrgAddress record,@Param("example") OrgAddressExample example);

	int updateByExample(@Param("record") OrgAddress record,@Param("example") OrgAddressExample example);

	int updateByPrimaryKeySelective(OrgAddress record);

	int updateByPrimaryKey(OrgAddress record);

}
