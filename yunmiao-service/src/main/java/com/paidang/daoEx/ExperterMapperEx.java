package com.paidang.daoEx;

import com.paidang.daoEx.model.ExperterEx;

import java.util.List;
import java.util.Map; /**
@author sun
*/
public interface ExperterMapperEx {
    List<ExperterEx> selectList(Map<String, Object> map);
}
