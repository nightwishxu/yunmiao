package com.weixin.service;

import com.weixin.dao.FirstAttentionMapper;
import com.weixin.dao.model.FirstAttention;
import com.weixin.dao.model.FirstAttentionExample;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstAttentionService {
    @Autowired
    private FirstAttentionMapper firstAttentionMapper;

    private static final Logger logger = Logger.getLogger(FirstAttentionService.class);

    public int countByExample(FirstAttentionExample example) {
        return this.firstAttentionMapper.countByExample(example);
    }

    public FirstAttention selectByPrimaryKey(String id) {
        return this.firstAttentionMapper.selectByPrimaryKey(id);
    }

    public List<FirstAttention> selectByExample(FirstAttentionExample example) {
        return this.firstAttentionMapper.selectByExampleWithBLOBs(example);
    }

    public int deleteByPrimaryKey(String id) {
        return this.firstAttentionMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(FirstAttention record) {
        return this.firstAttentionMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(FirstAttention record) {
        return this.firstAttentionMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    public int deleteByExample(FirstAttentionExample example) {
        return this.firstAttentionMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(FirstAttention record, FirstAttentionExample example) {
        return this.firstAttentionMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(FirstAttention record, FirstAttentionExample example) {
        return this.firstAttentionMapper.updateByExampleWithBLOBs(record, example);
    }

    public int insert(FirstAttention record) {
        return this.firstAttentionMapper.insert(record);
    }

    public int insertSelective(FirstAttention record) {
        return this.firstAttentionMapper.insertSelective(record);
    }
}