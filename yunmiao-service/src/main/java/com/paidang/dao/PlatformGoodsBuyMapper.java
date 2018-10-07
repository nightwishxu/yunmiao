package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.PlatformGoodsBuy;
import com.paidang.dao.model.PlatformGoodsBuyExample;

public interface PlatformGoodsBuyMapper {
	int countByExample(PlatformGoodsBuyExample example);

	int deleteByExample(PlatformGoodsBuyExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(PlatformGoodsBuy record);

	int insertSelective(PlatformGoodsBuy record);

	List<PlatformGoodsBuy> selectByExample(PlatformGoodsBuyExample example);

	PlatformGoodsBuy selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") PlatformGoodsBuy record,@Param("example") PlatformGoodsBuyExample example);

	int updateByExample(@Param("record") PlatformGoodsBuy record,@Param("example") PlatformGoodsBuyExample example);

	int updateByPrimaryKeySelective(PlatformGoodsBuy record);

	int updateByPrimaryKey(PlatformGoodsBuy record);

}
