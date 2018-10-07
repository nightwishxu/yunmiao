package com.item.daoEx;

import com.item.daoEx.model.AdEx;

import java.util.List;
import java.util.Map; /**
@author sun
*/
public interface AdMapperEx {
    List<AdEx> selectRzList(Map<String, Object> map);
}
