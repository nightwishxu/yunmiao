package com.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.SysDictMapper;
import com.item.dao.model.SysDict;
import com.item.dao.model.SysDictExample;

@Service
public class SysDictService {
	@Autowired
	private SysDictMapper sysDictMapper;

	public int countByExample(SysDictExample example) {
		return this.sysDictMapper.countByExample(example);
	}

	public SysDict selectByPrimaryKey(Integer id) {
		return this.sysDictMapper.selectByPrimaryKey(id);
	}

	public List<SysDict> selectByExample(SysDictExample example) {
		return this.sysDictMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.sysDictMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysDict record) {
		return this.sysDictMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysDict record) {
		return this.sysDictMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(SysDictExample example) {
		return this.sysDictMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(SysDict record, SysDictExample example) {
		return this.sysDictMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(SysDict record, SysDictExample example) {
		return this.sysDictMapper.updateByExample(record, example);
	}

	public int insert(SysDict record) {
		return this.sysDictMapper.insert(record);
	}

	public int insertSelective(SysDict record) {
		return this.sysDictMapper.insertSelective(record);
	}

}
