package com.paidang.daoEx;

import com.base.entity.QueryParams;
import com.paidang.dao.model.Goods;
import com.paidang.daoEx.model.GoodsEx;

import java.util.List;
import java.util.Map;

/**
@author sun
*/
public interface GoodsMapperEx {

    List<GoodsEx> selectGoodsList(QueryParams.Builder builder);

    List<GoodsEx> selectMyGoodsList(Map<String, Object> map);
    //审核状态
    int changeStateByPrimaryKey(GoodsEx record);
    //出售
    int updateCreatTime(Goods record);
    //个人中心 -- 绝当商场竞拍列表
    List<GoodsEx> selectMyAucList(Map<String, Object> map);

    GoodsEx selectByPrimaryId(Integer id);

    /**
     * 获取销量前三商品
     * @param orgId
     * @return
     */
    List<GoodsEx> getMostThreeGoods(Integer orgId);

    List<GoodsEx> findList(GoodsEx goodsEx);
}
