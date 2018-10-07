package com.paidang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.DomainMapper;
import com.paidang.dao.model.Domain;
import com.paidang.dao.model.DomainExample;

@Service
public class DomainService {
	@Autowired
	private DomainMapper domainMapper;

	public int countByExample(DomainExample example) {
		return this.domainMapper.countByExample(example);
	}

	public Domain selectByPrimaryKey(Integer id) {
		return this.domainMapper.selectByPrimaryKey(id);
	}

	public List<Domain> selectByExample(DomainExample example) {
		return this.domainMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.domainMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Domain record) {
		return this.domainMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Domain record) {
		return this.domainMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(DomainExample example) {
		return this.domainMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(Domain record, DomainExample example) {
		return this.domainMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(Domain record, DomainExample example) {
		return this.domainMapper.updateByExample(record, example);
	}

	public int insert(Domain record) {
		return this.domainMapper.insert(record);
	}

	public int insertSelective(Domain record) {
		return this.domainMapper.insertSelective(record);
	}

}
