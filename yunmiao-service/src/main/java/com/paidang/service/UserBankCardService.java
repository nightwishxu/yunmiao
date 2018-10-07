package com.paidang.service;

import java.util.List;
import java.util.Map;

import com.paidang.daoEx.UserBankCardMapperEx;
import com.paidang.daoEx.model.UserBankCardEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.UserBankCardMapper;
import com.paidang.dao.model.UserBankCard;
import com.paidang.dao.model.UserBankCardExample;

@Service
public class UserBankCardService {
	@Autowired
	private UserBankCardMapper userBankCardMapper;
	@Autowired
	private UserBankCardMapperEx userBankCardMapperEx;

	public int countByExample(UserBankCardExample example) {
		return this.userBankCardMapper.countByExample(example);
	}

	public UserBankCard selectByPrimaryKey(Integer id) {
		return this.userBankCardMapper.selectByPrimaryKey(id);
	}

	public List<UserBankCard> selectByExample(UserBankCardExample example) {
		return this.userBankCardMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userBankCardMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserBankCard record) {
		return this.userBankCardMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserBankCard record) {
		return this.userBankCardMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserBankCardExample example) {
		return this.userBankCardMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(UserBankCard record, UserBankCardExample example) {
		return this.userBankCardMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(UserBankCard record, UserBankCardExample example) {
		return this.userBankCardMapper.updateByExample(record, example);
	}

	public int insert(UserBankCard record) {
		return this.userBankCardMapper.insert(record);
	}

	public int insertSelective(UserBankCard record) {
		return this.userBankCardMapper.insertSelective(record);
	}

    public UserBankCardEx selectByUser(Map<String, Object> map) {
		return this.userBankCardMapperEx.selectByUser(map);
    }
}
