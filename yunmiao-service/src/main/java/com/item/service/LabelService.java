package com.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.LabelMapper;
import com.item.dao.model.Label;
import com.item.dao.model.LabelExample;

@Service
public class LabelService {
	@Autowired
	private LabelMapper labelMapper;

	public int countByExample(LabelExample example) {
		return this.labelMapper.countByExample(example);
	}

	public Label selectByPrimaryKey(Integer id) {
		return this.labelMapper.selectByPrimaryKey(id);
	}

	public List<Label> selectByExample(LabelExample example) {
		return this.labelMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.labelMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Label record) {
		return this.labelMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Label record) {
		return this.labelMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(LabelExample example) {
		return this.labelMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(Label record, LabelExample example) {
		return this.labelMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(Label record, LabelExample example) {
		return this.labelMapper.updateByExample(record, example);
	}

	public int insert(Label record) {
		return this.labelMapper.insert(record);
	}

	public int insertSelective(Label record) {
		return this.labelMapper.insertSelective(record);
	}

}
