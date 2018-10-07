package com.paidang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.DiamondMapper;
import com.paidang.dao.model.Diamond;
import com.paidang.dao.model.DiamondExample;

@Service
public class DiamondService {
	@Autowired
	private DiamondMapper diamondMapper;

	public int countByExample(DiamondExample example) {
		return this.diamondMapper.countByExample(example);
	}

	public Diamond selectByPrimaryKey(Integer id) {
		return this.diamondMapper.selectByPrimaryKey(id);
	}

	public List<Diamond> selectByExample(DiamondExample example) {
		return this.diamondMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.diamondMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Diamond record) {
		return this.diamondMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Diamond record) {
		return this.diamondMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(DiamondExample example) {
		return this.diamondMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(Diamond record, DiamondExample example) {
		return this.diamondMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(Diamond record, DiamondExample example) {
		return this.diamondMapper.updateByExample(record, example);
	}

	public int insert(Diamond record) {
		return this.diamondMapper.insert(record);
	}

	public int insertSelective(Diamond record) {
		return this.diamondMapper.insertSelective(record);
	}

}
