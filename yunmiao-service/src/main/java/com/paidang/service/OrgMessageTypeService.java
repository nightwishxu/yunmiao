package com.paidang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.OrgMessageTypeMapper;
import com.paidang.dao.model.OrgMessageType;
import com.paidang.dao.model.OrgMessageTypeExample;

@Service
public class OrgMessageTypeService {
	@Autowired
	private OrgMessageTypeMapper orgMessageTypeMapper;

	public int countByExample(OrgMessageTypeExample example) {
		return this.orgMessageTypeMapper.countByExample(example);
	}

	public OrgMessageType selectByPrimaryKey(Integer id) {
		return this.orgMessageTypeMapper.selectByPrimaryKey(id);
	}

	public List<OrgMessageType> selectByExample(OrgMessageTypeExample example) {
		return this.orgMessageTypeMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.orgMessageTypeMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(OrgMessageType record) {
		return this.orgMessageTypeMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(OrgMessageType record) {
		return this.orgMessageTypeMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(OrgMessageTypeExample example) {
		return this.orgMessageTypeMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(OrgMessageType record, OrgMessageTypeExample example) {
		return this.orgMessageTypeMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(OrgMessageType record, OrgMessageTypeExample example) {
		return this.orgMessageTypeMapper.updateByExample(record, example);
	}

	public int insert(OrgMessageType record) {
		return this.orgMessageTypeMapper.insert(record);
	}

	public int insertSelective(OrgMessageType record) {
		return this.orgMessageTypeMapper.insertSelective(record);
	}

}
