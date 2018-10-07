package com.item.service;

import java.util.List;
import java.util.Map;

import com.item.daoEx.AdMapperEx;
import com.item.daoEx.model.AdEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.AdMapper;
import com.item.dao.model.Ad;
import com.item.dao.model.AdExample;

@Service
public class AdService {
	@Autowired
	private AdMapper adMapper;
	@Autowired
	private AdMapperEx adMapperEx;

	public int countByExample(AdExample example) {
		return this.adMapper.countByExample(example);
	}

	public Ad selectByPrimaryKey(Integer id) {
		return this.adMapper.selectByPrimaryKey(id);
	}

	public List<Ad> selectByExample(AdExample example) {
		return this.adMapper.selectByExample(example);
	}

	public List<Ad> selectByExampleWithBLOBs(AdExample example) {
		return this.adMapper.selectByExampleWithBLOBs(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.adMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Ad record) {
		return this.adMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(Ad record) {
		return this.adMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(Ad record) {
		return this.adMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(AdExample example) {
		return this.adMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(Ad record, AdExample example) {
		return this.adMapper.updateByExampleSelective(record, example);
	}

	public int updateByExampleWithBLOBs(Ad record, AdExample example) {
		return this.adMapper.updateByExampleWithBLOBs(record, example);
	}

	public int updateByExample(Ad record, AdExample example) {
		return this.adMapper.updateByExample(record, example);
	}

	public int insert(Ad record) {
		return this.adMapper.insert(record);
	}

	public int insertSelective(Ad record) {
		return this.adMapper.insertSelective(record);
	}

    public List<AdEx> selectRzList(Map<String, Object> map) {
		return this.adMapperEx.selectRzList(map);
    }
}
