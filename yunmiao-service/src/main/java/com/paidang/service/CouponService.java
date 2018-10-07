package com.paidang.service;

import java.util.List;
import java.util.Map;

import com.paidang.daoEx.CouponMapperEx;
import com.paidang.daoEx.model.CouponEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.CouponMapper;
import com.paidang.dao.model.Coupon;
import com.paidang.dao.model.CouponExample;

@Service
public class CouponService {
	@Autowired
	private CouponMapper couponMapper;
	@Autowired
	private CouponMapperEx couponMapperEx;

	public int countByExample(CouponExample example) {
		return this.couponMapper.countByExample(example);
	}

	public Coupon selectByPrimaryKey(Integer id) {
		return this.couponMapper.selectByPrimaryKey(id);
	}

	public List<Coupon> selectByExample(CouponExample example) {
		return this.couponMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.couponMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Coupon record) {
		return this.couponMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Coupon record) {
		return this.couponMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(CouponExample example) {
		return this.couponMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(Coupon record, CouponExample example) {
		return this.couponMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(Coupon record, CouponExample example) {
		return this.couponMapper.updateByExample(record, example);
	}

	public int insert(Coupon record) {
		return this.couponMapper.insert(record);
	}

	public int insertSelective(Coupon record) {
		return this.couponMapper.insertSelective(record);
	}

    public List<CouponEx> selectGoods(Map<String ,Object> map) {
		return this.couponMapperEx.selectGoods(map);
    }
}
