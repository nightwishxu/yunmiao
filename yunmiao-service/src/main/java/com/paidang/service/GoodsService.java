package com.paidang.service;

import java.util.List;
import java.util.Map;

import com.base.entity.QueryParams;
import com.paidang.daoEx.GoodsMapperEx;
import com.paidang.daoEx.model.GoodsEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.GoodsMapper;
import com.paidang.dao.model.Goods;
import com.paidang.dao.model.GoodsExample;

@Service
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsMapperEx goodsMapperEx;

	public int countByExample(GoodsExample example) {
		return this.goodsMapper.countByExample(example);
	}

	public Goods selectByPrimaryKey(Integer id) {
		return this.goodsMapper.selectByPrimaryKey(id);
	}

	public List<Goods> selectByExample(GoodsExample example) {
		return this.goodsMapper.selectByExample(example);
	}

	public List<Goods> selectByExampleWithBLOBs(GoodsExample example) {
		return this.goodsMapper.selectByExampleWithBLOBs(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.goodsMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Goods record) {
		return this.goodsMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(Goods record) {
		return this.goodsMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(Goods record) {
		return this.goodsMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(GoodsExample example) {
		return this.goodsMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(Goods record, GoodsExample example) {
		return this.goodsMapper.updateByExampleSelective(record, example);
	}

	public int updateByExampleWithBLOBs(Goods record, GoodsExample example) {
		return this.goodsMapper.updateByExampleWithBLOBs(record, example);
	}

	public int updateByExample(Goods record, GoodsExample example) {
		return this.goodsMapper.updateByExample(record, example);
	}

	public int insert(Goods record) {
		return this.goodsMapper.insert(record);
	}

	public int insertSelective(Goods record) {
		return this.goodsMapper.insertSelective(record);
	}

	public List<GoodsEx> selectGoodsList(QueryParams.Builder builder){
		return this.goodsMapperEx.selectGoodsList(builder);
	}

    public List<GoodsEx> selectMyGoodsList(Map<String, Object> map) {
		return this.goodsMapperEx.selectMyGoodsList(map);
    }

	public int changeStateByPrimaryKey(GoodsEx record) {
		return this.goodsMapperEx.changeStateByPrimaryKey(record);
	}

    public List<GoodsEx> selectMyAucList(Map<String, Object> map) {
		return this.goodsMapperEx.selectMyAucList(map);
    }

    public GoodsEx selectByPrimaryId(Integer id) {
		return this.goodsMapperEx.selectByPrimaryId(id);
	}

	public int updateCreatTime(Goods record) {
		return this.goodsMapperEx.updateCreatTime(record);
	}

	public List<GoodsEx> getMostThreeGoods(Integer orgId){
		return goodsMapperEx.getMostThreeGoods(orgId);
	}

	public List<GoodsEx> findList(GoodsEx goodsEx){
		return goodsMapperEx.findList(goodsEx);
	}
}
