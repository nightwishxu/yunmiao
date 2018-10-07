package com.item.daoEx;

import java.util.List;
import java.util.Map;

import com.item.daoEx.model.NotifyEx;

public interface NotifyMapperEx {

	List<NotifyEx> selectList(Map<String, Object> map);

}
