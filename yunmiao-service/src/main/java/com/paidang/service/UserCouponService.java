package com.paidang.service;

import java.util.List;
import java.util.Map;

import com.paidang.daoEx.UserCouponMapperEx;
import com.paidang.daoEx.model.UserCouponEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.UserCouponMapper;
import com.paidang.dao.model.UserCoupon;
import com.paidang.dao.model.UserCouponExample;

@Service
public class UserCouponService {
	@Autowired
	private UserCouponMapper userCouponMapper;
	@Autowired
	private UserCouponMapperEx userCouponMapperEx;

	public int countByExample(UserCouponExample example) {
		return this.userCouponMapper.countByExample(example);
	}

	public UserCoupon selectByPrimaryKey(Integer id) {
		return this.userCouponMapper.selectByPrimaryKey(id);
	}

	public List<UserCoupon> selectByExample(UserCouponExample example) {
		return this.userCouponMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userCouponMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserCoupon record) {
		return this.userCouponMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserCoupon record) {
		return this.userCouponMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserCouponExample example) {
		return this.userCouponMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(UserCoupon record, UserCouponExample example) {
		return this.userCouponMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(UserCoupon record, UserCouponExample example) {
		return this.userCouponMapper.updateByExample(record, example);
	}

	public int insert(UserCoupon record) {
		return this.userCouponMapper.insert(record);
	}

	public int insertSelective(UserCoupon record) {
		return this.userCouponMapper.insertSelective(record);
	}

    public List<UserCouponEx> selectByGoods(Map<String, Object> map) {
		return this.userCouponMapperEx.selectByGoods(map);
    }
}
