package com.weixin.dao;

import com.weixin.dao.model.Menu;
import com.weixin.dao.model.MenuExample;
import com.weixin.dao.model.MenuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(MenuKey key);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(MenuKey key);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}