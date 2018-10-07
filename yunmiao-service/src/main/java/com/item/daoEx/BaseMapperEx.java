package com.item.daoEx;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;


public interface BaseMapperEx {

	int updateNumById(@Param("tableName")String tableName, @Param("colum")String colum, @Param("idColum")String idColum, @Param("id")Serializable id, @Param("num")BigDecimal num);

	int updateMoneyById(@Param("tableName")String tableName, @Param("colum")String colum, @Param("idColum")String idColum, @Param("id")Serializable id, @Param("num")BigDecimal money);
}
