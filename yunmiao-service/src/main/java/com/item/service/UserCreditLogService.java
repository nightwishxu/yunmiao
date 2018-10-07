package com.item.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.UserCreditLogMapper;
import com.item.dao.model.UserCreditLog;
import com.item.dao.model.UserCreditLogExample;
import com.item.daoEx.UserCreditLogMapperEx;
import com.item.daoEx.model.UserCreditLogEx;

@Service
public class UserCreditLogService {
    @Autowired
    private UserCreditLogMapper userCreditLogMapper;
    @Autowired
    private UserCreditLogMapperEx userCreditLogMapperEx;

    private static final Logger logger = Logger.getLogger(UserCreditLogService.class);

    public int countByExample(UserCreditLogExample example) {
        return this.userCreditLogMapper.countByExample(example);
    }

    public UserCreditLog selectByPrimaryKey(String id) {
        return this.userCreditLogMapper.selectByPrimaryKey(id);
    }

    public List<UserCreditLog> selectByExample(UserCreditLogExample example) {
        return this.userCreditLogMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(String id) {
        return this.userCreditLogMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(UserCreditLog record) {
        return this.userCreditLogMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserCreditLog record) {
        return this.userCreditLogMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(UserCreditLogExample example) {
        return this.userCreditLogMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(UserCreditLog record, UserCreditLogExample example) {
        return this.userCreditLogMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(UserCreditLog record, UserCreditLogExample example) {
        return this.userCreditLogMapper.updateByExample(record, example);
    }

    public int insert(UserCreditLog record) {
        return this.userCreditLogMapper.insert(record);
    }

    public int insertSelective(UserCreditLog record) {
        return this.userCreditLogMapper.insertSelective(record);
    }

	public List<UserCreditLogEx> selectList(Map<String, Object> map) {
		return userCreditLogMapperEx.selectList(map);
	}
}