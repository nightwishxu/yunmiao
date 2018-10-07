package com.paidang.service;

import java.util.List;

import com.paidang.daoEx.VideoOnlineMapperEx;
import com.paidang.daoEx.model.VideoOnlineEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.VideoOnlineMapper;
import com.paidang.dao.model.VideoOnline;
import com.paidang.dao.model.VideoOnlineExample;

@Service
public class VideoOnlineService {
	@Autowired
	private VideoOnlineMapper videoOnlineMapper;
	@Autowired
	private VideoOnlineMapperEx videoOnlineMapperEx;

	public int countByExample(VideoOnlineExample example) {
		return this.videoOnlineMapper.countByExample(example);
	}

	public VideoOnline selectByPrimaryKey(Integer id) {
		return this.videoOnlineMapper.selectByPrimaryKey(id);
	}

	public List<VideoOnline> selectByExample(VideoOnlineExample example) {
		return this.videoOnlineMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.videoOnlineMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(VideoOnline record) {
		return this.videoOnlineMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(VideoOnline record) {
		return this.videoOnlineMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(VideoOnlineExample example) {
		return this.videoOnlineMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(VideoOnline record, VideoOnlineExample example) {
		return this.videoOnlineMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(VideoOnline record, VideoOnlineExample example) {
		return this.videoOnlineMapper.updateByExample(record, example);
	}

	public int insert(VideoOnline record) {
		return this.videoOnlineMapper.insert(record);
	}

	public int insertSelective(VideoOnline record) {
		return this.videoOnlineMapper.insertSelective(record);
	}

    public List<VideoOnlineEx> selectByComment() {
		return this.videoOnlineMapperEx.selectByComment();
    }
}
