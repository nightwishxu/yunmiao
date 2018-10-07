package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.CollectPraise;
import com.item.dao.model.CollectPraiseExample;

public interface CollectPraiseMapper {
	int countByExample(CollectPraiseExample example);

	int deleteByExample(CollectPraiseExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(CollectPraise record);

	int insertSelective(CollectPraise record);

	List<CollectPraise> selectByExample(CollectPraiseExample example);

	CollectPraise selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") CollectPraise record,@Param("example") CollectPraiseExample example);

	int updateByExample(@Param("record") CollectPraise record,@Param("example") CollectPraiseExample example);

	int updateByPrimaryKeySelective(CollectPraise record);

	int updateByPrimaryKey(CollectPraise record);

}
