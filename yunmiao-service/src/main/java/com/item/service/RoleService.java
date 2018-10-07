package com.item.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.RoleMapper;
import com.item.dao.model.Role;
import com.item.dao.model.RoleExample;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    private static final Logger logger = Logger.getLogger(RoleService.class);

    public int countByExample(RoleExample example) {
        return this.roleMapper.countByExample(example);
    }

    public Role selectByPrimaryKey(Integer id) {
        return this.roleMapper.selectByPrimaryKey(id);
    }

    public List<Role> selectByExample(RoleExample example) {
        return this.roleMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.roleMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Role record) {
        return this.roleMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Role record) {
        return this.roleMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(RoleExample example) {
        return this.roleMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Role record, RoleExample example) {
        return this.roleMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Role record, RoleExample example) {
        return this.roleMapper.updateByExample(record, example);
    }

    public int insert(Role record) {
        return this.roleMapper.insert(record);
    }

    public int insertSelective(Role record) {
        return this.roleMapper.insertSelective(record);
    }
}