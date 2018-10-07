package com.paidang.daoEx;

import com.paidang.daoEx.model.PawnAuctionEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
@author sun
*/
public interface PawnAuctionMapperEx {

    //获得指定pawnId申请对应的竞拍记录
    List<PawnAuctionEx> getAuctionDetailsByPawnId(@Param("pawnId")String pawnId);

    //获取在对指定id的当品竞拍过程中指定id的机构的出价信息（包括上次出价价格，费率，利率，出价人和之前出价次数）
    PawnAuctionEx getPreviousBidInfo(@Param("pawnId")String pawnId,@Param("orgId")String orgId);

    //获得给定id的机构所竞拍的当品id(过滤重复)
    List<String> getMyBidPawnIdByOrgId(@Param("orgId")String orgId);

    //某pawnId对应的所有竞拍机构总数
    Integer getAllBidOrgCount(@Param("pawnId")int pawnId);


    Integer selectCount(@Param("id")Integer id);
}
