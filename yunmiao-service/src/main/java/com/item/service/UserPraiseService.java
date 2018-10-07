package com.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.UserPraiseMapper;
import com.item.dao.model.UserPraise;
import com.item.dao.model.UserPraiseExample;

@Service
public class UserPraiseService {
	@Autowired
	private UserPraiseMapper userPraiseMapper;

	public int countByExample(UserPraiseExample example) {
		return this.userPraiseMapper.countByExample(example);
	}

	public UserPraise selectByPrimaryKey(Integer id) {
		return this.userPraiseMapper.selectByPrimaryKey(id);
	}

	public List<UserPraise> selectByExample(UserPraiseExample example) {
		return this.userPraiseMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userPraiseMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserPraise record) {
		return this.userPraiseMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserPraise record) {
		return this.userPraiseMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserPraiseExample example) {
		return this.userPraiseMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(UserPraise record, UserPraiseExample example) {
		return this.userPraiseMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(UserPraise record, UserPraiseExample example) {
		return this.userPraiseMapper.updateByExample(record, example);
	}

	public int insert(UserPraise record) {
		return this.userPraiseMapper.insert(record);
	}

	public int insertSelective(UserPraise record) {
		return this.userPraiseMapper.insertSelective(record);
	}

}
