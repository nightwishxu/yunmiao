package com.item.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.RightMapper;
import com.item.dao.model.Right;
import com.item.dao.model.RightExample;
import com.item.daoEx.RightMapperEx;

@Service
public class RightService {
    @Autowired
    private RightMapper rightMapper;

    @Autowired
    private RightMapperEx rightMapperEx;
    
    private static final Logger logger = Logger.getLogger(RightService.class);

    public int countByExample(RightExample example) {
        return this.rightMapper.countByExample(example);
    }

    public Right selectByPrimaryKey(int id) {
        return this.rightMapper.selectByPrimaryKey(id);
    }

    public List<Right> selectByExample(RightExample example) {
        return this.rightMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(int id) {
        return this.rightMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Right record) {
        return this.rightMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Right record) {
        return this.rightMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(RightExample example) {
        return this.rightMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Right record, RightExample example) {
        return this.rightMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Right record, RightExample example) {
        return this.rightMapper.updateByExample(record, example);
    }

    public int insert(Right record) {
        return this.rightMapper.insert(record);
    }

    public int insertSelective(Right record) {
        return this.rightMapper.insertSelective(record);
    }
    
    public List<Right> selectByRole(Integer id){
    	return rightMapperEx.selectByRole(id);
    }
}