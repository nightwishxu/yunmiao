package com.paidang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.OrgAddressMapper;
import com.paidang.dao.model.OrgAddress;
import com.paidang.dao.model.OrgAddressExample;

@Service
public class OrgAddressService {
	@Autowired
	private OrgAddressMapper orgAddressMapper;

	public int countByExample(OrgAddressExample example) {
		return this.orgAddressMapper.countByExample(example);
	}

	public OrgAddress selectByPrimaryKey(Integer id) {
		return this.orgAddressMapper.selectByPrimaryKey(id);
	}

	public List<OrgAddress> selectByExample(OrgAddressExample example) {
		return this.orgAddressMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.orgAddressMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(OrgAddress record) {
		return this.orgAddressMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(OrgAddress record) {
		return this.orgAddressMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(OrgAddressExample example) {
		return this.orgAddressMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(OrgAddress record, OrgAddressExample example) {
		return this.orgAddressMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(OrgAddress record, OrgAddressExample example) {
		return this.orgAddressMapper.updateByExample(record, example);
	}

	public int insert(OrgAddress record) {
		return this.orgAddressMapper.insert(record);
	}

	public int insertSelective(OrgAddress record) {
		return this.orgAddressMapper.insertSelective(record);
	}

}
