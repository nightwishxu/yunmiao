package com.item.daoEx;

import com.item.dao.model.UserMessage;
import com.item.daoEx.model.UserMessageEx;

import java.util.List;

/**
@author sun
*/
public interface UserMessageMapperEx {

    /**
     * 获取私信列表
     * @param message
     * @return
     */
    List<UserMessageEx> findList(UserMessage message);

    /**
     * 获取私信对话列表
     * @param message
     * @return
     */
    List<UserMessageEx> findListEx(UserMessage message);
}
