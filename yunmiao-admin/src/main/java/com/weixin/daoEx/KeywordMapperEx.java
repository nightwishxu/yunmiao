package com.weixin.daoEx;

import java.util.List;

import com.weixin.daoEx.model.KeywordEx;


public interface KeywordMapperEx{

	List<KeywordEx> selectList(String fid);

}