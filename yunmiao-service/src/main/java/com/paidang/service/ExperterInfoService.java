package com.paidang.service;

import java.util.List;
import java.util.Map;

import com.paidang.daoEx.ExperterInfoMapperEx;
import com.paidang.daoEx.model.ExperterInfoEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.ExperterInfoMapper;
import com.paidang.dao.model.ExperterInfo;
import com.paidang.dao.model.ExperterInfoExample;

@Service
public class ExperterInfoService {
	@Autowired
	private ExperterInfoMapper experterInfoMapper;
	@Autowired
	private ExperterInfoMapperEx experterInfoMapperEx;


	public int countByExample(ExperterInfoExample example) {
		return this.experterInfoMapper.countByExample(example);
	}

	public ExperterInfo selectByPrimaryKey(Integer id) {
		return this.experterInfoMapper.selectByPrimaryKey(id);
	}

	public List<ExperterInfo> selectByExample(ExperterInfoExample example) {
		return this.experterInfoMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.experterInfoMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(ExperterInfo record) {
		return this.experterInfoMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ExperterInfo record) {
		return this.experterInfoMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(ExperterInfoExample example) {
		return this.experterInfoMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(ExperterInfo record, ExperterInfoExample example) {
		return this.experterInfoMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(ExperterInfo record, ExperterInfoExample example) {
		return this.experterInfoMapper.updateByExample(record, example);
	}

	public int insert(ExperterInfo record) {
		return this.experterInfoMapper.insert(record);
	}

	public int insertSelective(ExperterInfo record) {
		return this.experterInfoMapper.insertSelective(record);
	}

    public ExperterInfoEx selectH5List(Integer id) {
		return this.experterInfoMapperEx.selectH5List(id);
    }

    public List<ExperterInfoEx> selectList(Map<String, Object> map) {
		return this.experterInfoMapperEx.selectList(map);
    }
}
