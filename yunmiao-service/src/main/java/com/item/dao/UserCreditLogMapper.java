package com.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.dao.model.UserCreditLog;
import com.item.dao.model.UserCreditLogExample;

public interface UserCreditLogMapper {
    int countByExample(UserCreditLogExample example);

    int deleteByExample(UserCreditLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserCreditLog record);

    int insertSelective(UserCreditLog record);

    List<UserCreditLog> selectByExample(UserCreditLogExample example);

    UserCreditLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserCreditLog record, @Param("example") UserCreditLogExample example);

    int updateByExample(@Param("record") UserCreditLog record, @Param("example") UserCreditLogExample example);

    int updateByPrimaryKeySelective(UserCreditLog record);

    int updateByPrimaryKey(UserCreditLog record);
}