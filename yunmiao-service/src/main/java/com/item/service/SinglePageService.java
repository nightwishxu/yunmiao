package com.item.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.SinglePageMapper;
import com.item.dao.model.SinglePage;
import com.item.dao.model.SinglePageExample;


@Service
public class SinglePageService {
    @Autowired
    private SinglePageMapper singlePageMapper;

    private static final Logger logger = Logger.getLogger(SinglePageService.class);

    public int countByExample(SinglePageExample example) {
        return this.singlePageMapper.countByExample(example);
    }

    public SinglePage selectByPrimaryKey(String code) {
        return this.singlePageMapper.selectByPrimaryKey(code);
    }

    public List<SinglePage> selectByExample(SinglePageExample example) {
        return this.singlePageMapper.selectByExampleWithBLOBs(example);
    }

    public int deleteByPrimaryKey(String code) {
        return this.singlePageMapper.deleteByPrimaryKey(code);
    }

    public int updateByPrimaryKeySelective(SinglePage record) {
        return this.singlePageMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SinglePage record) {
        return this.singlePageMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    public int deleteByExample(SinglePageExample example) {
        return this.singlePageMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(SinglePage record, SinglePageExample example) {
        return this.singlePageMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SinglePage record, SinglePageExample example) {
        return this.singlePageMapper.updateByExampleWithBLOBs(record, example);
    }

    public int insert(SinglePage record) {
        return this.singlePageMapper.insert(record);
    }

    public int insertSelective(SinglePage record) {
        return this.singlePageMapper.insertSelective(record);
    }
}