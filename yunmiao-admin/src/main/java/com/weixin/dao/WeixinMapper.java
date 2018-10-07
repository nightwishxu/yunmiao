package com.weixin.dao;

import com.weixin.dao.model.Weixin;
import com.weixin.dao.model.WeixinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeixinMapper {
    int countByExample(WeixinExample example);

    int deleteByExample(WeixinExample example);

    int deleteByPrimaryKey(String userId);

    int insert(Weixin record);

    int insertSelective(Weixin record);

    List<Weixin> selectByExample(WeixinExample example);

    Weixin selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") Weixin record, @Param("example") WeixinExample example);

    int updateByExample(@Param("record") Weixin record, @Param("example") WeixinExample example);

    int updateByPrimaryKeySelective(Weixin record);

    int updateByPrimaryKey(Weixin record);
}