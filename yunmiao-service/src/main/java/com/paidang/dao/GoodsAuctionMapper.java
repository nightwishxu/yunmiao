package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.GoodsAuction;
import com.paidang.dao.model.GoodsAuctionExample;

public interface GoodsAuctionMapper {
	int countByExample(GoodsAuctionExample example);

	int deleteByExample(GoodsAuctionExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(GoodsAuction record);

	int insertSelective(GoodsAuction record);

	List<GoodsAuction> selectByExample(GoodsAuctionExample example);

	GoodsAuction selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") GoodsAuction record,@Param("example") GoodsAuctionExample example);

	int updateByExample(@Param("record") GoodsAuction record,@Param("example") GoodsAuctionExample example);

	int updateByPrimaryKeySelective(GoodsAuction record);

	int updateByPrimaryKey(GoodsAuction record);

}
