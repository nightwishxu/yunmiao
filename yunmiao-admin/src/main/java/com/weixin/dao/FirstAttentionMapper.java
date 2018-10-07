package com.weixin.dao;

import com.weixin.dao.model.FirstAttention;
import com.weixin.dao.model.FirstAttentionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FirstAttentionMapper {
    int countByExample(FirstAttentionExample example);

    int deleteByExample(FirstAttentionExample example);

    int deleteByPrimaryKey(String fid);

    int insert(FirstAttention record);

    int insertSelective(FirstAttention record);

    List<FirstAttention> selectByExampleWithBLOBs(FirstAttentionExample example);

    List<FirstAttention> selectByExample(FirstAttentionExample example);

    FirstAttention selectByPrimaryKey(String fid);

    int updateByExampleSelective(@Param("record") FirstAttention record, @Param("example") FirstAttentionExample example);

    int updateByExampleWithBLOBs(@Param("record") FirstAttention record, @Param("example") FirstAttentionExample example);

    int updateByExample(@Param("record") FirstAttention record, @Param("example") FirstAttentionExample example);

    int updateByPrimaryKeySelective(FirstAttention record);

    int updateByPrimaryKeyWithBLOBs(FirstAttention record);

    int updateByPrimaryKey(FirstAttention record);
}