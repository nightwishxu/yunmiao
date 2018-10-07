package com.paidang.daoEx;

import com.paidang.dao.model.UserPawn;
import com.paidang.daoEx.model.UserPawnEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
@author sun
*/
public interface UserPawnMapperEx {

     List<UserPawnEx> selectAppList(Map<String, Object> map);

     //获取当票信息
     UserPawnEx getPawnTicketInfo(String pawnId);

     //最新当品
     List<UserPawnEx> LatestPawnList(@Param("auctionTime")int auctionTime);

     //热门竞拍
     List<UserPawnEx> hotAuctionsList(@Param("auctionTime")int auctionTime);

     //获取指定id的UserPawnEx扩展类
     UserPawnEx getUserPawnExById(@Param("pawnId") String pawnId);

     //获取已中标典当记录
     List<UserPawnEx> getMyBidWonList(@Param("orgId") String orgId);

     //获取宝祥机构兜底典当
     List<UserPawnEx> getBaoXiangList(@Param("orgId") String orgId);

     //获取点击我的当户后的列表(本机构所属当户)
     List<UserPawnEx> getMyPawnersList(@Param("orgId") String orgId);

     //获取 我的 当户和当品信息 页面下部当品列表
     List<UserPawnEx> getPawnerzPawnList(@Param("pawnerId") String pawnerId,@Param("orgId") String orgId);

     //获取登陆机构的用户赎当申请列表
     List<UserPawnEx> getOrgRedeemList(@Param("orgId") String orgId);

     //获取登陆机构绝当列表
     List<UserPawnEx> getOrgDeadPawnList(@Param("orgId") String orgId);

     //获取合同记录列表
     List<UserPawnEx> getContractPawnList(@Param("orgId") String orgId);

     //续当详情
     UserPawnEx selectByPawnConinueDetail(Map<String, Object> map);

     UserPawnEx selectUserName(Map<String, Object> map);

     int updatebyPawnContinue(Map<String, Object> map);

     //拍档详情
     UserPawnEx selectPawningDetail(Map<String, Object> map);

     //已取消列表
    List<UserPawnEx> selectCancelPawnList(Map<String, Object> map);

     UserPawnEx selectByGoodsId(Integer id);

     //定时任务--竞拍时间结束没有人竞拍
    List<UserPawnEx> selectTask(Map<String, Object> map);

     //我的典当列表--竞拍中
    List<UserPawnEx> selectPawningList(Map<String, Object> map);

    //我的典当列表--典当中
     List<UserPawnEx> selectMyPawnedList(Map<String, Object> map);

     //平台查看所有典当记录
    List<UserPawnEx> selectPawnRecord(Map<String, Object> map);

    //更新
    int updateUserPawn(UserPawn userPawn);

    List<UserPawnEx> selectConList(Map<String, Object> map);

    //宝箱兜底
    List<UserPawnEx> selectBxGet(Map<String, Object> map);

    List<UserPawnEx> selectTradeRecordList(Map<String, Object> map);
}
