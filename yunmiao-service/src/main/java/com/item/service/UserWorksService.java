package com.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.UserWorksMapper;
import com.item.dao.model.UserWorks;
import com.item.dao.model.UserWorksExample;

@Service
public class UserWorksService {
	@Autowired
	private UserWorksMapper userWorksMapper;

	public int countByExample(UserWorksExample example) {
		return this.userWorksMapper.countByExample(example);
	}

	public UserWorks selectByPrimaryKey(Integer id) {
		return this.userWorksMapper.selectByPrimaryKey(id);
	}

	public List<UserWorks> selectByExample(UserWorksExample example) {
		return this.userWorksMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userWorksMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserWorks record) {
		return this.userWorksMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserWorks record) {
		return this.userWorksMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserWorksExample example) {
		return this.userWorksMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(UserWorks record, UserWorksExample example) {
		return this.userWorksMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(UserWorks record, UserWorksExample example) {
		return this.userWorksMapper.updateByExample(record, example);
	}

	public int insert(UserWorks record) {
		return this.userWorksMapper.insert(record);
	}

	public int insertSelective(UserWorks record) {
		return this.userWorksMapper.insertSelective(record);
	}

}
