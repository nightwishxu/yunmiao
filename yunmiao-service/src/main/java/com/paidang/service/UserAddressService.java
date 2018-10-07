package com.paidang.service;

import java.util.List;
import java.util.Map;

import com.paidang.daoEx.UserAddressMapperEx;
import com.paidang.daoEx.model.UserAddressEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.UserAddressMapper;
import com.paidang.dao.model.UserAddress;
import com.paidang.dao.model.UserAddressExample;

@Service
public class UserAddressService {
	@Autowired
	private UserAddressMapper userAddressMapper;
	@Autowired
	private UserAddressMapperEx userAddressMapperEx;

	public int countByExample(UserAddressExample example) {
		return this.userAddressMapper.countByExample(example);
	}

	public UserAddress selectByPrimaryKey(Integer id) {
		return this.userAddressMapper.selectByPrimaryKey(id);
	}

	public List<UserAddress> selectByExample(UserAddressExample example) {
		return this.userAddressMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userAddressMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserAddress record) {
		return this.userAddressMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserAddress record) {
		return this.userAddressMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserAddressExample example) {
		return this.userAddressMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(UserAddress record, UserAddressExample example) {
		return this.userAddressMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(UserAddress record, UserAddressExample example) {
		return this.userAddressMapper.updateByExample(record, example);
	}

	public int insert(UserAddress record) {
		return this.userAddressMapper.insert(record);
	}

	public int insertSelective(UserAddress record) {
		return this.userAddressMapper.insertSelective(record);
	}

    public List<UserAddressEx> selectByUser(Map<String, Object> map) {
		return this.userAddressMapperEx.selectByUser(map);
    }
}
