package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.Coupon;
import com.paidang.dao.model.CouponExample;

public interface CouponMapper {
	int countByExample(CouponExample example);

	int deleteByExample(CouponExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Coupon record);

	int insertSelective(Coupon record);

	List<Coupon> selectByExample(CouponExample example);

	Coupon selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Coupon record,@Param("example") CouponExample example);

	int updateByExample(@Param("record") Coupon record,@Param("example") CouponExample example);

	int updateByPrimaryKeySelective(Coupon record);

	int updateByPrimaryKey(Coupon record);

}
