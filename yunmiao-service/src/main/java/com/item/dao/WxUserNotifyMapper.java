package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.WxUserNotify;
import com.item.dao.model.WxUserNotifyExample;

public interface WxUserNotifyMapper {
	int countByExample(WxUserNotifyExample example);

	int deleteByExample(WxUserNotifyExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(WxUserNotify record);

	int insertSelective(WxUserNotify record);

	List<WxUserNotify> selectByExample(WxUserNotifyExample example);

	WxUserNotify selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") WxUserNotify record,@Param("example") WxUserNotifyExample example);

	int updateByExample(@Param("record") WxUserNotify record,@Param("example") WxUserNotifyExample example);

	int updateByPrimaryKeySelective(WxUserNotify record);

	int updateByPrimaryKey(WxUserNotify record);

}
