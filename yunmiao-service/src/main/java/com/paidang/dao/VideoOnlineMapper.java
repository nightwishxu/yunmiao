package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.VideoOnline;
import com.paidang.dao.model.VideoOnlineExample;

public interface VideoOnlineMapper {
	int countByExample(VideoOnlineExample example);

	int deleteByExample(VideoOnlineExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(VideoOnline record);

	int insertSelective(VideoOnline record);

	List<VideoOnline> selectByExample(VideoOnlineExample example);

	VideoOnline selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") VideoOnline record,@Param("example") VideoOnlineExample example);

	int updateByExample(@Param("record") VideoOnline record,@Param("example") VideoOnlineExample example);

	int updateByPrimaryKeySelective(VideoOnline record);

	int updateByPrimaryKey(VideoOnline record);

}
