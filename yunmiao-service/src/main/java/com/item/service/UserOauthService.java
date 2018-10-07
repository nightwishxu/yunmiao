package com.item.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.UserOauthMapper;
import com.item.dao.model.UserOauth;
import com.item.dao.model.UserOauthExample;

@Service
public class UserOauthService {
    @Autowired
    private UserOauthMapper userOauthMapper;

    private static final Logger logger = Logger.getLogger(UserOauthService.class);

    public int countByExample(UserOauthExample example) {
        return this.userOauthMapper.countByExample(example);
    }

    public UserOauth selectByPrimaryKey(Integer id) {
        return this.userOauthMapper.selectByPrimaryKey(id);
    }

    public List<UserOauth> selectByExample(UserOauthExample example) {
        return this.userOauthMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.userOauthMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(UserOauth record) {
        return this.userOauthMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserOauth record) {
        return this.userOauthMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(UserOauthExample example) {
        return this.userOauthMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(UserOauth record, UserOauthExample example) {
        return this.userOauthMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(UserOauth record, UserOauthExample example) {
        return this.userOauthMapper.updateByExample(record, example);
    }

    public int insert(UserOauth record) {
        return this.userOauthMapper.insert(record);
    }

    public int insertSelective(UserOauth record) {
        return this.userOauthMapper.insertSelective(record);
    }
}