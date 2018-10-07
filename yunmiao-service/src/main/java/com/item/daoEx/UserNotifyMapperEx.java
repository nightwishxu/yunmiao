package com.item.daoEx;

import java.util.List;
import java.util.Map;

import com.item.dao.model.UserNotify;
import com.item.daoEx.model.UserEx;
import com.item.daoEx.model.UserNotifyEx;


public interface UserNotifyMapperEx{

    int insertBatch(List<UserNotify> list);
}