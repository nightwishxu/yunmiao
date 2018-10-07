package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.OrgMessageType;
import com.paidang.dao.model.OrgMessageTypeExample;

public interface OrgMessageTypeMapper {
	int countByExample(OrgMessageTypeExample example);

	int deleteByExample(OrgMessageTypeExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(OrgMessageType record);

	int insertSelective(OrgMessageType record);

	List<OrgMessageType> selectByExample(OrgMessageTypeExample example);

	OrgMessageType selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") OrgMessageType record,@Param("example") OrgMessageTypeExample example);

	int updateByExample(@Param("record") OrgMessageType record,@Param("example") OrgMessageTypeExample example);

	int updateByPrimaryKeySelective(OrgMessageType record);

	int updateByPrimaryKey(OrgMessageType record);

}
