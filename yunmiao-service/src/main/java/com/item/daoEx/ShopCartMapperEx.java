package com.item.daoEx;

import com.item.daoEx.model.ShopCartEx;

import java.util.List;

/**
@author sun
*/
public interface ShopCartMapperEx {
    /**
     * 购物车列表
     * @param userId
     * @return
     */
    List<ShopCartEx> findList(Integer userId);

}
