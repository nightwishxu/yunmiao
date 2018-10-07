package com.paidang.service;

import java.util.List;
import java.util.Map;

import com.paidang.daoEx.ExperterMapperEx;
import com.paidang.daoEx.model.ExperterEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.ExperterMapper;
import com.paidang.dao.model.Experter;
import com.paidang.dao.model.ExperterExample;

@Service
public class ExperterService {
	@Autowired
	private ExperterMapper experterMapper;
	@Autowired
	private ExperterMapperEx experterMapperEx;

	public int countByExample(ExperterExample example) {
		return this.experterMapper.countByExample(example);
	}

	public Experter selectByPrimaryKey(Integer id) {
		return this.experterMapper.selectByPrimaryKey(id);
	}

	public List<Experter> selectByExample(ExperterExample example) {
		return this.experterMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.experterMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Experter record) {
		return this.experterMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Experter record) {
		return this.experterMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(ExperterExample example) {
		return this.experterMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(Experter record, ExperterExample example) {
		return this.experterMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(Experter record, ExperterExample example) {
		return this.experterMapper.updateByExample(record, example);
	}

	public int insert(Experter record) {
		return this.experterMapper.insert(record);
	}

	public int insertSelective(Experter record) {
		return this.experterMapper.insertSelective(record);
	}

    public List<ExperterEx> selectList(Map<String, Object> map) {
		return this.experterMapperEx.selectList(map);

    }
}
