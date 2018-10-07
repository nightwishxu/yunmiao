package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.Order;
import com.paidang.dao.model.OrderExample;

public interface OrderMapper {
	int countByExample(OrderExample example);

	int deleteByExample(OrderExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Order record);

	int insertSelective(Order record);

	List<Order> selectByExample(OrderExample example);

	Order selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Order record,@Param("example") OrderExample example);

	int updateByExample(@Param("record") Order record,@Param("example") OrderExample example);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKey(Order record);

}
