package com.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.PayLogMapper;
import com.item.dao.model.PayLog;
import com.item.dao.model.PayLogExample;

@Service
public class PayLogService {
	@Autowired
	private PayLogMapper payLogMapper;

	public int countByExample(PayLogExample example) {
		return this.payLogMapper.countByExample(example);
	}

	public PayLog selectByPrimaryKey(Long id) {
		return this.payLogMapper.selectByPrimaryKey(id);
	}

	public List<PayLog> selectByExample(PayLogExample example) {
		return this.payLogMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Long id) {
		return this.payLogMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(PayLog record) {
		return this.payLogMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(PayLog record) {
		return this.payLogMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(PayLogExample example) {
		return this.payLogMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(PayLog record, PayLogExample example) {
		return this.payLogMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(PayLog record, PayLogExample example) {
		return this.payLogMapper.updateByExample(record, example);
	}

	public int insert(PayLog record) {
		return this.payLogMapper.insert(record);
	}

	public int insertSelective(PayLog record) {
		return this.payLogMapper.insertSelective(record);
	}

}
