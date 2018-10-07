package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.UserReport;
import com.item.dao.model.UserReportExample;

public interface UserReportMapper {
	int countByExample(UserReportExample example);

	int deleteByExample(UserReportExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserReport record);

	int insertSelective(UserReport record);

	List<UserReport> selectByExample(UserReportExample example);

	UserReport selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserReport record,@Param("example") UserReportExample example);

	int updateByExample(@Param("record") UserReport record,@Param("example") UserReportExample example);

	int updateByPrimaryKeySelective(UserReport record);

	int updateByPrimaryKey(UserReport record);

}
