package com.weixin.daoEx;

import java.util.List;
import java.util.Map;

import com.weixin.daoEx.model.ResourceEx;


public interface ResourceMapperEx{

	List<ResourceEx> selectList(Map<String, Object> map);

}