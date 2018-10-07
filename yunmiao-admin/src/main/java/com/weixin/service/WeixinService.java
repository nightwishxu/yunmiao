package com.weixin.service;

import com.weixin.dao.WeixinMapper;
import com.weixin.dao.model.Weixin;
import com.weixin.dao.model.WeixinExample;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeixinService {
    @Autowired
    private WeixinMapper weixinMapper;

    private static final Logger logger = Logger.getLogger(WeixinService.class);

    public int countByExample(WeixinExample example) {
        return this.weixinMapper.countByExample(example);
    }

    public Weixin selectByPrimaryKey(String userId) {
        return this.weixinMapper.selectByPrimaryKey(userId);
    }

    public List<Weixin> selectByExample(WeixinExample example) {
        return this.weixinMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(String userId) {
        return this.weixinMapper.deleteByPrimaryKey(userId);
    }

    public int updateByPrimaryKeySelective(Weixin record) {
        return this.weixinMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Weixin record) {
        return this.weixinMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(WeixinExample example) {
        return this.weixinMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Weixin record, WeixinExample example) {
        return this.weixinMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Weixin record, WeixinExample example) {
        return this.weixinMapper.updateByExample(record, example);
    }

    public int insert(Weixin record) {
        return this.weixinMapper.insert(record);
    }

    public int insertSelective(Weixin record) {
        return this.weixinMapper.insertSelective(record);
    }
}