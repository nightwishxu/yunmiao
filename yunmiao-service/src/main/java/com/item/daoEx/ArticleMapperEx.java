package com.item.daoEx;

import org.apache.ibatis.annotations.Param;

/**
@author sun
*/
public interface ArticleMapperEx {

    /**
     *
     * @param id
     * @param num
     * @param type 0更新评论数1更新收藏数2更新点赞数
     * @return
     */
    Integer updateArticleCount(@Param("id")Integer id,@Param("num")Integer num,@Param("type")Integer type);

    /**
     * 获取用户发布的动态数
     * @param userId
     * @return
     */
    Integer getArticleCount(Integer userId);
}
