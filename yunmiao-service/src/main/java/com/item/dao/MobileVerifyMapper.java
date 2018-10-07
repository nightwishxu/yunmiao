package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.MobileVerify;
import com.item.dao.model.MobileVerifyExample;

public interface MobileVerifyMapper {
	int countByExample(MobileVerifyExample example);

	int deleteByExample(MobileVerifyExample example);

	int deleteByPrimaryKey(String device_id);

	int insert(MobileVerify record);

	int insertSelective(MobileVerify record);

	List<MobileVerify> selectByExample(MobileVerifyExample example);

	MobileVerify selectByPrimaryKey(String device_id);

	int updateByExampleSelective(@Param("record") MobileVerify record,@Param("example") MobileVerifyExample example);

	int updateByExample(@Param("record") MobileVerify record,@Param("example") MobileVerifyExample example);

	int updateByPrimaryKeySelective(MobileVerify record);

	int updateByPrimaryKey(MobileVerify record);

}
