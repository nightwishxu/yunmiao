package com.item.daoEx;

import com.item.dao.model.Comment;
import com.item.daoEx.model.CommentEx;

import java.util.List;

/**
@author sun
*/
public interface CommentMapperEx {

    List<CommentEx> findList(Integer articleId);

    /**
     * 增加回复数
     * @param id
     * @return
     */
    Integer updateReplyNum(Integer id);
}
