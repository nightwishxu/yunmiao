package com.item.daoEx;

import java.util.List;
import java.util.Map;

import com.item.daoEx.model.FeedbackEx;

public interface FeedbackMapperEx{

	List<FeedbackEx> selectList(Map<String, Object> map);

}