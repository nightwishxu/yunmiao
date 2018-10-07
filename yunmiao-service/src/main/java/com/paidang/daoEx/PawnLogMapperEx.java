package com.paidang.daoEx;

import com.paidang.dao.model.PawnLog;
import com.paidang.daoEx.model.PawnLogEx;

import java.util.List;
import java.util.Map;

/**
@author sun
*/
public interface PawnLogMapperEx {
    int updatePawnByid(PawnLog record);

    List<PawnLogEx> selectTradeRecordList(Map<String, Object> map);
}
