package com.paidang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.PlatformBalanceLogMapper;
import com.paidang.dao.model.PlatformBalanceLog;
import com.paidang.dao.model.PlatformBalanceLogExample;

@Service
public class PlatformBalanceLogService {
	@Autowired
	private PlatformBalanceLogMapper platformBalanceLogMapper;

	public int countByExample(PlatformBalanceLogExample example) {
		return this.platformBalanceLogMapper.countByExample(example);
	}

	public PlatformBalanceLog selectByPrimaryKey(Integer id) {
		return this.platformBalanceLogMapper.selectByPrimaryKey(id);
	}

	public List<PlatformBalanceLog> selectByExample(PlatformBalanceLogExample example) {
		return this.platformBalanceLogMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.platformBalanceLogMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(PlatformBalanceLog record) {
		return this.platformBalanceLogMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(PlatformBalanceLog record) {
		return this.platformBalanceLogMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(PlatformBalanceLogExample example) {
		return this.platformBalanceLogMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(PlatformBalanceLog record, PlatformBalanceLogExample example) {
		return this.platformBalanceLogMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(PlatformBalanceLog record, PlatformBalanceLogExample example) {
		return this.platformBalanceLogMapper.updateByExample(record, example);
	}

	public int insert(PlatformBalanceLog record) {
		return this.platformBalanceLogMapper.insert(record);
	}

	public int insertSelective(PlatformBalanceLog record) {
		return this.platformBalanceLogMapper.insertSelective(record);
	}

}
