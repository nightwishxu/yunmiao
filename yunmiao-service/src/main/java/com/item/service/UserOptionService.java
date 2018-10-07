package com.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.UserOptionMapper;
import com.item.dao.model.UserOption;
import com.item.dao.model.UserOptionExample;

@Service
public class UserOptionService {
	@Autowired
	private UserOptionMapper userOptionMapper;

	public int countByExample(UserOptionExample example) {
		return this.userOptionMapper.countByExample(example);
	}

	public UserOption selectByPrimaryKey(Integer id) {
		return this.userOptionMapper.selectByPrimaryKey(id);
	}

	public List<UserOption> selectByExample(UserOptionExample example) {
		return this.userOptionMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userOptionMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserOption record) {
		return this.userOptionMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserOption record) {
		return this.userOptionMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserOptionExample example) {
		return this.userOptionMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(UserOption record, UserOptionExample example) {
		return this.userOptionMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(UserOption record, UserOptionExample example) {
		return this.userOptionMapper.updateByExample(record, example);
	}

	public int insert(UserOption record) {
		return this.userOptionMapper.insert(record);
	}

	public int insertSelective(UserOption record) {
		return this.userOptionMapper.insertSelective(record);
	}

}
