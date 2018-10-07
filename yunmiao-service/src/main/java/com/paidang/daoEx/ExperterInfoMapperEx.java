package com.paidang.daoEx;

import com.paidang.daoEx.model.ExperterInfoEx;

import java.util.List;
import java.util.Map;

/**
@author sun
*/
public interface ExperterInfoMapperEx {
    ExperterInfoEx selectH5List(Integer id);

    List<ExperterInfoEx> selectList(Map<String, Object> map);
}
