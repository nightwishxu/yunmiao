package com.weixin.service;

import com.weixin.dao.ArticleMapper;
import com.weixin.dao.model.Article;
import com.weixin.dao.model.ArticleExample;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    private static final Logger logger = Logger.getLogger(ArticleService.class);

    public int countByExample(ArticleExample example) {
        return this.articleMapper.countByExample(example);
    }

    public Article selectByPrimaryKey(String id) {
        return this.articleMapper.selectByPrimaryKey(id);
    }

    public List<Article> selectByExample(ArticleExample example) {
        return this.articleMapper.selectByExampleWithBLOBs(example);
    }

    public int deleteByPrimaryKey(String id) {
        return this.articleMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Article record) {
        return this.articleMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Article record) {
        return this.articleMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    public int deleteByExample(ArticleExample example) {
        return this.articleMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Article record, ArticleExample example) {
        return this.articleMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Article record, ArticleExample example) {
        return this.articleMapper.updateByExampleWithBLOBs(record, example);
    }

    public int insert(Article record) {
        return this.articleMapper.insert(record);
    }

    public int insertSelective(Article record) {
        return this.articleMapper.insertSelective(record);
    }
}