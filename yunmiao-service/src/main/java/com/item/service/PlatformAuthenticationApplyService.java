package com.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.PlatformAuthenticationApplyMapper;
import com.item.dao.model.PlatformAuthenticationApply;
import com.item.dao.model.PlatformAuthenticationApplyExample;

@Service
public class PlatformAuthenticationApplyService {
	@Autowired
	private PlatformAuthenticationApplyMapper platformAuthenticationApplyMapper;

	public int countByExample(PlatformAuthenticationApplyExample example) {
		return this.platformAuthenticationApplyMapper.countByExample(example);
	}

	public PlatformAuthenticationApply selectByPrimaryKey(Integer id) {
		return this.platformAuthenticationApplyMapper.selectByPrimaryKey(id);
	}

	public List<PlatformAuthenticationApply> selectByExample(PlatformAuthenticationApplyExample example) {
		return this.platformAuthenticationApplyMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.platformAuthenticationApplyMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(PlatformAuthenticationApply record) {
		return this.platformAuthenticationApplyMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(PlatformAuthenticationApply record) {
		return this.platformAuthenticationApplyMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(PlatformAuthenticationApplyExample example) {
		return this.platformAuthenticationApplyMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(PlatformAuthenticationApply record, PlatformAuthenticationApplyExample example) {
		return this.platformAuthenticationApplyMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(PlatformAuthenticationApply record, PlatformAuthenticationApplyExample example) {
		return this.platformAuthenticationApplyMapper.updateByExample(record, example);
	}

	public int insert(PlatformAuthenticationApply record) {
		return this.platformAuthenticationApplyMapper.insert(record);
	}

	public int insertSelective(PlatformAuthenticationApply record) {
		return this.platformAuthenticationApplyMapper.insertSelective(record);
	}

}
