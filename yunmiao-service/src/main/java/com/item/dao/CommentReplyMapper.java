package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.CommentReply;
import com.item.dao.model.CommentReplyExample;

public interface CommentReplyMapper {
	int countByExample(CommentReplyExample example);

	int deleteByExample(CommentReplyExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(CommentReply record);

	int insertSelective(CommentReply record);

	List<CommentReply> selectByExample(CommentReplyExample example);

	List<CommentReply> selectByExampleWithBLOBs(CommentReplyExample example);

	CommentReply selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") CommentReply record,@Param("example") CommentReplyExample example);

	int updateByExampleWithBLOBs(@Param("record") CommentReply record, @Param("example") CommentReplyExample example);

	int updateByExample(@Param("record") CommentReply record,@Param("example") CommentReplyExample example);

	int updateByPrimaryKeySelective(CommentReply record);

	int updateByPrimaryKeyWithBLOBs(CommentReply record);

	int updateByPrimaryKey(CommentReply record);

}
