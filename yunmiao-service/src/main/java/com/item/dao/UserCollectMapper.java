package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.UserCollect;
import com.item.dao.model.UserCollectExample;

public interface UserCollectMapper {
	int countByExample(UserCollectExample example);

	int deleteByExample(UserCollectExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserCollect record);

	int insertSelective(UserCollect record);

	List<UserCollect> selectByExample(UserCollectExample example);

	UserCollect selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserCollect record,@Param("example") UserCollectExample example);

	int updateByExample(@Param("record") UserCollect record,@Param("example") UserCollectExample example);

	int updateByPrimaryKeySelective(UserCollect record);

	int updateByPrimaryKey(UserCollect record);

}
