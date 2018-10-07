package com.item.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.UserGroupMapper;
import com.item.dao.model.UserGroup;
import com.item.dao.model.UserGroupExample;

@Service
public class UserGroupService {
    @Autowired
    private UserGroupMapper userGroupMapper;

    private static final Logger logger = Logger.getLogger(UserGroupService.class);

    public int countByExample(UserGroupExample example) {
        return this.userGroupMapper.countByExample(example);
    }

    public UserGroup selectByPrimaryKey(Integer id) {
        return this.userGroupMapper.selectByPrimaryKey(id);
    }

    public List<UserGroup> selectByExample(UserGroupExample example) {
        return this.userGroupMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.userGroupMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(UserGroup record) {
        return this.userGroupMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserGroup record) {
        return this.userGroupMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(UserGroupExample example) {
        return this.userGroupMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(UserGroup record, UserGroupExample example) {
        return this.userGroupMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(UserGroup record, UserGroupExample example) {
        return this.userGroupMapper.updateByExample(record, example);
    }

    public int insert(UserGroup record) {
        return this.userGroupMapper.insert(record);
    }

    public int insertSelective(UserGroup record) {
        return this.userGroupMapper.insertSelective(record);
    }
}