package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.PawnAuction;
import com.paidang.dao.model.PawnAuctionExample;

public interface PawnAuctionMapper {
	int countByExample(PawnAuctionExample example);

	int deleteByExample(PawnAuctionExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(PawnAuction record);

	int insertSelective(PawnAuction record);

	List<PawnAuction> selectByExample(PawnAuctionExample example);

	PawnAuction selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") PawnAuction record,@Param("example") PawnAuctionExample example);

	int updateByExample(@Param("record") PawnAuction record,@Param("example") PawnAuctionExample example);

	int updateByPrimaryKeySelective(PawnAuction record);

	int updateByPrimaryKey(PawnAuction record);

}
