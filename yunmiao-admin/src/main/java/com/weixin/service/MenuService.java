package com.weixin.service;

import com.weixin.dao.MenuMapper;
import com.weixin.dao.model.Menu;
import com.weixin.dao.model.MenuExample;
import com.weixin.dao.model.MenuKey;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    private static final Logger logger = Logger.getLogger(MenuService.class);

    public int countByExample(MenuExample example) {
        return this.menuMapper.countByExample(example);
    }

    public Menu selectByPrimaryKey(MenuKey key) {
        return this.menuMapper.selectByPrimaryKey(key);
    }

    public List<Menu> selectByExample(MenuExample example) {
        return this.menuMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(MenuKey key) {
        return this.menuMapper.deleteByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(Menu record) {
        return this.menuMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Menu record) {
        return this.menuMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(MenuExample example) {
        return this.menuMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Menu record, MenuExample example) {
        return this.menuMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Menu record, MenuExample example) {
        return this.menuMapper.updateByExample(record, example);
    }

    public int insert(Menu record) {
        return this.menuMapper.insert(record);
    }

    public int insertSelective(Menu record) {
        return this.menuMapper.insertSelective(record);
    }
}