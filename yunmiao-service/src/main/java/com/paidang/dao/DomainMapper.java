package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.Domain;
import com.paidang.dao.model.DomainExample;

public interface DomainMapper {
	int countByExample(DomainExample example);

	int deleteByExample(DomainExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Domain record);

	int insertSelective(Domain record);

	List<Domain> selectByExample(DomainExample example);

	Domain selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Domain record,@Param("example") DomainExample example);

	int updateByExample(@Param("record") Domain record,@Param("example") DomainExample example);

	int updateByPrimaryKeySelective(Domain record);

	int updateByPrimaryKey(Domain record);

}
