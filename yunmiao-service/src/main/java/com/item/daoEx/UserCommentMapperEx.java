package com.item.daoEx;

import com.item.dao.model.UserComment;
import com.item.daoEx.model.UserCommentEx;

import java.util.List;

/**
@author sun
*/
public interface UserCommentMapperEx {
    List<UserCommentEx> findList(UserComment comment);
}
