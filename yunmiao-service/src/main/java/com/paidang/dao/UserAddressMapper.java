package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.UserAddress;
import com.paidang.dao.model.UserAddressExample;

public interface UserAddressMapper {
	int countByExample(UserAddressExample example);

	int deleteByExample(UserAddressExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserAddress record);

	int insertSelective(UserAddress record);

	List<UserAddress> selectByExample(UserAddressExample example);

	UserAddress selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserAddress record,@Param("example") UserAddressExample example);

	int updateByExample(@Param("record") UserAddress record,@Param("example") UserAddressExample example);

	int updateByPrimaryKeySelective(UserAddress record);

	int updateByPrimaryKey(UserAddress record);

}
