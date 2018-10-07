package com.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.CollectPraiseMapper;
import com.item.dao.model.CollectPraise;
import com.item.dao.model.CollectPraiseExample;

@Service
public class CollectPraiseService {
	@Autowired
	private CollectPraiseMapper collectPraiseMapper;

	public int countByExample(CollectPraiseExample example) {
		return this.collectPraiseMapper.countByExample(example);
	}

	public CollectPraise selectByPrimaryKey(Integer id) {
		return this.collectPraiseMapper.selectByPrimaryKey(id);
	}

	public List<CollectPraise> selectByExample(CollectPraiseExample example) {
		return this.collectPraiseMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.collectPraiseMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(CollectPraise record) {
		return this.collectPraiseMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(CollectPraise record) {
		return this.collectPraiseMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(CollectPraiseExample example) {
		return this.collectPraiseMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(CollectPraise record, CollectPraiseExample example) {
		return this.collectPraiseMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(CollectPraise record, CollectPraiseExample example) {
		return this.collectPraiseMapper.updateByExample(record, example);
	}

	public int insert(CollectPraise record) {
		return this.collectPraiseMapper.insert(record);
	}

	public int insertSelective(CollectPraise record) {
		return this.collectPraiseMapper.insertSelective(record);
	}

}
