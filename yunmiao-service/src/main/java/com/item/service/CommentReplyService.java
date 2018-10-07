package com.item.service;

import java.util.List;

import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.CommentReplyMapper;
import com.item.dao.model.CommentReply;
import com.item.dao.model.CommentReplyExample;

@Service
public class CommentReplyService {
	@Autowired
	private CommentReplyMapper commentReplyMapper;

	public int countByExample(CommentReplyExample example) {
		return this.commentReplyMapper.countByExample(example);
	}

	public CommentReply selectByPrimaryKey(Integer id) {
		return this.commentReplyMapper.selectByPrimaryKey(id);
	}

	public List<CommentReply> selectByExample(CommentReplyExample example) {
		return this.commentReplyMapper.selectByExample(example);
	}

	public List<CommentReply> selectByExampleWithBLOBs(CommentReplyExample example) {
		return this.commentReplyMapper.selectByExampleWithBLOBs(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.commentReplyMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(CommentReply record) {
		return this.commentReplyMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(CommentReply record) {
		return this.commentReplyMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(CommentReply record) {
		return this.commentReplyMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(CommentReplyExample example) {
		return this.commentReplyMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(CommentReply record, CommentReplyExample example) {
		return this.commentReplyMapper.updateByExampleSelective(record, example);
	}

	public int updateByExampleWithBLOBs(CommentReply record, CommentReplyExample example) {
		return this.commentReplyMapper.updateByExampleWithBLOBs(record, example);
	}

	public int updateByExample(CommentReply record, CommentReplyExample example) {
		return this.commentReplyMapper.updateByExample(record, example);
	}

	public int insert(CommentReply record) {
		return this.commentReplyMapper.insert(record);
	}

	public int insertSelective(CommentReply record) {
		return this.commentReplyMapper.insertSelective(record);
	}

}
