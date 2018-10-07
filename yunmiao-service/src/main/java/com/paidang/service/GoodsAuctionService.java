package com.paidang.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.paidang.daoEx.GoodsAuctionMapperEx;
import com.paidang.daoEx.model.GoodsAuctionEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.GoodsAuctionMapper;
import com.paidang.dao.model.GoodsAuction;
import com.paidang.dao.model.GoodsAuctionExample;

@Service
public class GoodsAuctionService {
	@Autowired
	private GoodsAuctionMapper goodsAuctionMapper;
	@Autowired
	private GoodsAuctionMapperEx goodsAuctionMapperEx;

	public int countByExample(GoodsAuctionExample example) {
		return this.goodsAuctionMapper.countByExample(example);
	}

	public GoodsAuction selectByPrimaryKey(Integer id) {
		return this.goodsAuctionMapper.selectByPrimaryKey(id);
	}

	public List<GoodsAuction> selectByExample(GoodsAuctionExample example) {
		return this.goodsAuctionMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.goodsAuctionMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(GoodsAuction record) {
		return this.goodsAuctionMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(GoodsAuction record) {
		return this.goodsAuctionMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(GoodsAuctionExample example) {
		return this.goodsAuctionMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(GoodsAuction record, GoodsAuctionExample example) {
		return this.goodsAuctionMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(GoodsAuction record, GoodsAuctionExample example) {
		return this.goodsAuctionMapper.updateByExample(record, example);
	}

	public int insert(GoodsAuction record) {
		return this.goodsAuctionMapper.insert(record);
	}

	public int insertSelective(GoodsAuction record) {
		return this.goodsAuctionMapper.insertSelective(record);
	}

    public BigDecimal selectMaxPrice(Map<String, Object> map) {
		return this.goodsAuctionMapperEx.selectMaxPrice(map);
    }

    public List<GoodsAuctionEx> selectByAuctionUser(Map<String, Object> map) {
		return this.goodsAuctionMapperEx.selectByAuctionUser(map);
    }
}
