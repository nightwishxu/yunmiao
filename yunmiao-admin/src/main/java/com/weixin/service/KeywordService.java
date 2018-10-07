package com.weixin.service;

import com.weixin.dao.KeywordMapper;
import com.weixin.dao.model.Keyword;
import com.weixin.dao.model.KeywordExample;
import com.weixin.daoEx.KeywordMapperEx;
import com.weixin.daoEx.model.KeywordEx;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeywordService {
    @Autowired
    private KeywordMapper keywordMapper;
    @Autowired
    private KeywordMapperEx keywordMapperEx;

    private static final Logger logger = Logger.getLogger(KeywordService.class);

    public int countByExample(KeywordExample example) {
        return this.keywordMapper.countByExample(example);
    }

    public Keyword selectByPrimaryKey(String id) {
        return this.keywordMapper.selectByPrimaryKey(id);
    }

    public List<Keyword> selectByExample(KeywordExample example) {
        return this.keywordMapper.selectByExampleWithBLOBs(example);
    }

    public int deleteByPrimaryKey(String id) {
        return this.keywordMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Keyword record) {
        return this.keywordMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Keyword record) {
        return this.keywordMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    public int deleteByExample(KeywordExample example) {
        return this.keywordMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Keyword record, KeywordExample example) {
        return this.keywordMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Keyword record, KeywordExample example) {
        return this.keywordMapper.updateByExampleWithBLOBs(record, example);
    }

    public int insert(Keyword record) {
        return this.keywordMapper.insert(record);
    }

    public int insertSelective(Keyword record) {
        return this.keywordMapper.insertSelective(record);
    }

	public List<KeywordEx> selectList(String fid) {
		return keywordMapperEx.selectList(fid);
	}
}