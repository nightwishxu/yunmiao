package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.VideoOnlineComment;
import com.paidang.dao.model.VideoOnlineCommentExample;

public interface VideoOnlineCommentMapper {
	int countByExample(VideoOnlineCommentExample example);

	int deleteByExample(VideoOnlineCommentExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(VideoOnlineComment record);

	int insertSelective(VideoOnlineComment record);

	List<VideoOnlineComment> selectByExample(VideoOnlineCommentExample example);

	VideoOnlineComment selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") VideoOnlineComment record,@Param("example") VideoOnlineCommentExample example);

	int updateByExample(@Param("record") VideoOnlineComment record,@Param("example") VideoOnlineCommentExample example);

	int updateByPrimaryKeySelective(VideoOnlineComment record);

	int updateByPrimaryKey(VideoOnlineComment record);

}
