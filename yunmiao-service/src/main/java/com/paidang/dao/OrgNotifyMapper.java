package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.OrgNotify;
import com.paidang.dao.model.OrgNotifyExample;

public interface OrgNotifyMapper {
	int countByExample(OrgNotifyExample example);

	int deleteByExample(OrgNotifyExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(OrgNotify record);

	int insertSelective(OrgNotify record);

	List<OrgNotify> selectByExample(OrgNotifyExample example);

	OrgNotify selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") OrgNotify record,@Param("example") OrgNotifyExample example);

	int updateByExample(@Param("record") OrgNotify record,@Param("example") OrgNotifyExample example);

	int updateByPrimaryKeySelective(OrgNotify record);

	int updateByPrimaryKey(OrgNotify record);

}
