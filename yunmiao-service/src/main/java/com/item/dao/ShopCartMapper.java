package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.ShopCart;
import com.item.dao.model.ShopCartExample;

public interface ShopCartMapper {
	int countByExample(ShopCartExample example);

	int deleteByExample(ShopCartExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(ShopCart record);

	int insertSelective(ShopCart record);

	List<ShopCart> selectByExample(ShopCartExample example);

	ShopCart selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") ShopCart record,@Param("example") ShopCartExample example);

	int updateByExample(@Param("record") ShopCart record,@Param("example") ShopCartExample example);

	int updateByPrimaryKeySelective(ShopCart record);

	int updateByPrimaryKey(ShopCart record);

}
