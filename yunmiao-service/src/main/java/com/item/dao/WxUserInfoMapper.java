package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.WxUserInfo;
import com.item.dao.model.WxUserInfoExample;

public interface WxUserInfoMapper {
	int countByExample(WxUserInfoExample example);

	int deleteByExample(WxUserInfoExample example);

	int deleteByPrimaryKey(Integer user_id);

	int insert(WxUserInfo record);

	int insertSelective(WxUserInfo record);

	List<WxUserInfo> selectByExample(WxUserInfoExample example);

	WxUserInfo selectByPrimaryKey(Integer user_id);

	int updateByExampleSelective(@Param("record") WxUserInfo record,@Param("example") WxUserInfoExample example);

	int updateByExample(@Param("record") WxUserInfo record,@Param("example") WxUserInfoExample example);

	int updateByPrimaryKeySelective(WxUserInfo record);

	int updateByPrimaryKey(WxUserInfo record);

}
