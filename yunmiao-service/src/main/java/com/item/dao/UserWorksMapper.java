package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.UserWorks;
import com.item.dao.model.UserWorksExample;

public interface UserWorksMapper {
	int countByExample(UserWorksExample example);

	int deleteByExample(UserWorksExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserWorks record);

	int insertSelective(UserWorks record);

	List<UserWorks> selectByExample(UserWorksExample example);

	UserWorks selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserWorks record,@Param("example") UserWorksExample example);

	int updateByExample(@Param("record") UserWorks record,@Param("example") UserWorksExample example);

	int updateByPrimaryKeySelective(UserWorks record);

	int updateByPrimaryKey(UserWorks record);

}
