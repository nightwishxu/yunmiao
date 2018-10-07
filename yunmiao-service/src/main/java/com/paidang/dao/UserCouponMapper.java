package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.UserCoupon;
import com.paidang.dao.model.UserCouponExample;

public interface UserCouponMapper {
	int countByExample(UserCouponExample example);

	int deleteByExample(UserCouponExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserCoupon record);

	int insertSelective(UserCoupon record);

	List<UserCoupon> selectByExample(UserCouponExample example);

	UserCoupon selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserCoupon record,@Param("example") UserCouponExample example);

	int updateByExample(@Param("record") UserCoupon record,@Param("example") UserCouponExample example);

	int updateByPrimaryKeySelective(UserCoupon record);

	int updateByPrimaryKey(UserCoupon record);

}
