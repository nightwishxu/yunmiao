package com.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.UserCollectMapper;
import com.item.dao.model.UserCollect;
import com.item.dao.model.UserCollectExample;

@Service
public class UserCollectService {
	@Autowired
	private UserCollectMapper userCollectMapper;

	public int countByExample(UserCollectExample example) {
		return this.userCollectMapper.countByExample(example);
	}

	public UserCollect selectByPrimaryKey(Integer id) {
		return this.userCollectMapper.selectByPrimaryKey(id);
	}

	public List<UserCollect> selectByExample(UserCollectExample example) {
		return this.userCollectMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userCollectMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserCollect record) {
		return this.userCollectMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserCollect record) {
		return this.userCollectMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserCollectExample example) {
		return this.userCollectMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(UserCollect record, UserCollectExample example) {
		return this.userCollectMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(UserCollect record, UserCollectExample example) {
		return this.userCollectMapper.updateByExample(record, example);
	}

	public int insert(UserCollect record) {
		return this.userCollectMapper.insert(record);
	}

	public int insertSelective(UserCollect record) {
		return this.userCollectMapper.insertSelective(record);
	}

}
