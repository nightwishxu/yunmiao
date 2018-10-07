package com.paidang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.OrgBankCardMapper;
import com.paidang.dao.model.OrgBankCard;
import com.paidang.dao.model.OrgBankCardExample;

@Service
public class OrgBankCardService {
	@Autowired
	private OrgBankCardMapper orgBankCardMapper;

	public int countByExample(OrgBankCardExample example) {
		return this.orgBankCardMapper.countByExample(example);
	}

	public OrgBankCard selectByPrimaryKey(Integer id) {
		return this.orgBankCardMapper.selectByPrimaryKey(id);
	}

	public List<OrgBankCard> selectByExample(OrgBankCardExample example) {
		return this.orgBankCardMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.orgBankCardMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(OrgBankCard record) {
		return this.orgBankCardMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(OrgBankCard record) {
		return this.orgBankCardMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(OrgBankCardExample example) {
		return this.orgBankCardMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(OrgBankCard record, OrgBankCardExample example) {
		return this.orgBankCardMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(OrgBankCard record, OrgBankCardExample example) {
		return this.orgBankCardMapper.updateByExample(record, example);
	}

	public int insert(OrgBankCard record) {
		return this.orgBankCardMapper.insert(record);
	}

	public int insertSelective(OrgBankCard record) {
		return this.orgBankCardMapper.insertSelective(record);
	}

}
