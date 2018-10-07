package com.paidang.service;

import java.math.BigDecimal;
import java.util.List;

import com.base.entity.QueryParams;
import com.paidang.daoEx.PlatformGoodsBuyMapperEx;
import com.paidang.daoEx.model.PlatformGoodsBuyEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.PlatformGoodsBuyMapper;
import com.paidang.dao.model.PlatformGoodsBuy;
import com.paidang.dao.model.PlatformGoodsBuyExample;

@Service
public class PlatformGoodsBuyService {
	@Autowired
	private PlatformGoodsBuyMapper platformGoodsBuyMapper;
	@Autowired
	private PlatformGoodsBuyMapperEx platformGoodsBuyMapperEx;

	public int countByExample(PlatformGoodsBuyExample example) {
		return this.platformGoodsBuyMapper.countByExample(example);
	}

	public PlatformGoodsBuy selectByPrimaryKey(Integer id) {
		return this.platformGoodsBuyMapper.selectByPrimaryKey(id);
	}

	public List<PlatformGoodsBuy> selectByExample(PlatformGoodsBuyExample example) {
		return this.platformGoodsBuyMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.platformGoodsBuyMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(PlatformGoodsBuy record) {
		return this.platformGoodsBuyMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(PlatformGoodsBuy record) {
		return this.platformGoodsBuyMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(PlatformGoodsBuyExample example) {
		return this.platformGoodsBuyMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(PlatformGoodsBuy record, PlatformGoodsBuyExample example) {
		return this.platformGoodsBuyMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(PlatformGoodsBuy record, PlatformGoodsBuyExample example) {
		return this.platformGoodsBuyMapper.updateByExample(record, example);
	}

	public int insert(PlatformGoodsBuy record) {
		return this.platformGoodsBuyMapper.insert(record);
	}

	public int insertSelective(PlatformGoodsBuy record) {
		return this.platformGoodsBuyMapper.insertSelective(record);
	}

	public List<PlatformGoodsBuyEx> selectPlatformGoods(QueryParams.Builder builder) {
		return this.platformGoodsBuyMapperEx.selectPlatformGoods(builder);
	}
	public int changeStateByPrimaryKey(PlatformGoodsBuyEx record) {
		return this.platformGoodsBuyMapperEx.changeStateByPrimaryKey(record);
	}

	public int updateByTickect(PlatformGoodsBuyEx record) {
		return this.platformGoodsBuyMapperEx.updateByTickect(record);
	}
}
