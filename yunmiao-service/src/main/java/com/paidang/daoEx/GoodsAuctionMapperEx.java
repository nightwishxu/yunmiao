package com.paidang.daoEx;

import com.paidang.daoEx.model.GoodsAuctionEx;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map; /**
@author sun
*/
public interface GoodsAuctionMapperEx {
    BigDecimal selectMaxPrice(Map<String, Object> map);

    List<GoodsAuctionEx> selectByAuctionUser(Map<String, Object> map);
}
