package com.weixin.service;

import com.weixin.dao.ResourceMapper;
import com.weixin.dao.model.Resource;
import com.weixin.dao.model.ResourceExample;
import com.weixin.daoEx.ResourceMapperEx;
import com.weixin.daoEx.model.ResourceEx;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourceMapperEx resourceMapperEx;

    private static final Logger logger = Logger.getLogger(ResourceService.class);

    public int countByExample(ResourceExample example) {
        return this.resourceMapper.countByExample(example);
    }

    public Resource selectByPrimaryKey(String id) {
        return this.resourceMapper.selectByPrimaryKey(id);
    }

    public List<Resource> selectByExample(ResourceExample example) {
        return this.resourceMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(String id) {
        return this.resourceMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Resource record) {
        return this.resourceMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Resource record) {
        return this.resourceMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(ResourceExample example) {
        return this.resourceMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Resource record, ResourceExample example) {
        return this.resourceMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Resource record, ResourceExample example) {
        return this.resourceMapper.updateByExample(record, example);
    }

    public int insert(Resource record) {
        return this.resourceMapper.insert(record);
    }

    public int insertSelective(Resource record) {
        return this.resourceMapper.insertSelective(record);
    }

	public List<ResourceEx> selectList(Map<String, Object> map) {
		return resourceMapperEx.selectList(map);
	}
}