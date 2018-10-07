package com.weixin.dao;

import com.weixin.dao.model.Keyword;
import com.weixin.dao.model.KeywordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeywordMapper {
    int countByExample(KeywordExample example);

    int deleteByExample(KeywordExample example);

    int deleteByPrimaryKey(String id);

    int insert(Keyword record);

    int insertSelective(Keyword record);

    List<Keyword> selectByExampleWithBLOBs(KeywordExample example);

    List<Keyword> selectByExample(KeywordExample example);

    Keyword selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Keyword record, @Param("example") KeywordExample example);

    int updateByExampleWithBLOBs(@Param("record") Keyword record, @Param("example") KeywordExample example);

    int updateByExample(@Param("record") Keyword record, @Param("example") KeywordExample example);

    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKeyWithBLOBs(Keyword record);

    int updateByPrimaryKey(Keyword record);
}