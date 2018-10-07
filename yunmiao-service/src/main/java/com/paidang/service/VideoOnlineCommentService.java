package com.paidang.service;

import java.util.List;
import java.util.Map;

import com.paidang.daoEx.VideoOnlineCommentMapperEx;
import com.paidang.daoEx.model.VideoOnlineCommentEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.VideoOnlineCommentMapper;
import com.paidang.dao.model.VideoOnlineComment;
import com.paidang.dao.model.VideoOnlineCommentExample;

@Service
public class VideoOnlineCommentService {
	@Autowired
	private VideoOnlineCommentMapper videoOnlineCommentMapper;
	@Autowired
	private VideoOnlineCommentMapperEx videoOnlineCommentMapperEx;

	public int countByExample(VideoOnlineCommentExample example) {
		return this.videoOnlineCommentMapper.countByExample(example);
	}

	public VideoOnlineComment selectByPrimaryKey(Integer id) {
		return this.videoOnlineCommentMapper.selectByPrimaryKey(id);
	}

	public List<VideoOnlineComment> selectByExample(VideoOnlineCommentExample example) {
		return this.videoOnlineCommentMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.videoOnlineCommentMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(VideoOnlineComment record) {
		return this.videoOnlineCommentMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(VideoOnlineComment record) {
		return this.videoOnlineCommentMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(VideoOnlineCommentExample example) {
		return this.videoOnlineCommentMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(VideoOnlineComment record, VideoOnlineCommentExample example) {
		return this.videoOnlineCommentMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(VideoOnlineComment record, VideoOnlineCommentExample example) {
		return this.videoOnlineCommentMapper.updateByExample(record, example);
	}

	public int insert(VideoOnlineComment record) {
		return this.videoOnlineCommentMapper.insert(record);
	}

	public int insertSelective(VideoOnlineComment record) {
		return this.videoOnlineCommentMapper.insertSelective(record);
	}

    public List<VideoOnlineCommentEx> selectByUser(Map<String, Object> map) {
		return this.videoOnlineCommentMapperEx.selectByUser(map);
    }
}
