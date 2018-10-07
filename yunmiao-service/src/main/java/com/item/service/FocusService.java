package com.item.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.FocusMapper;
import com.item.dao.model.Focus;
import com.item.dao.model.FocusExample;
import com.item.daoEx.FocusMapperEx;
import com.item.daoEx.model.FocusEx;

@Service
public class FocusService {
    @Autowired
    private FocusMapper focusMapper;
    @Autowired
    private FocusMapperEx focusMapperEx;

    private static final Logger logger = Logger.getLogger(FocusService.class);

    public int countByExample(FocusExample example) {
        return this.focusMapper.countByExample(example);
    }

    public Focus selectByPrimaryKey(Integer id) {
        return this.focusMapper.selectByPrimaryKey(id);
    }

    public List<Focus> selectByExample(FocusExample example) {
        return this.focusMapper.selectByExampleWithBLOBs(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.focusMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Focus record) {
        return this.focusMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Focus record) {
        return this.focusMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    public int deleteByExample(FocusExample example) {
        return this.focusMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Focus record, FocusExample example) {
        return this.focusMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Focus record, FocusExample example) {
        return this.focusMapper.updateByExampleWithBLOBs(record, example);
    }

    public int insert(Focus record) {
        return this.focusMapper.insert(record);
    }

    public int insertSelective(Focus record) {
        return this.focusMapper.insertSelective(record);
    }

	public List<FocusEx> selectList(Map<String, Object> map) {
		return focusMapperEx.selectList(map);
	}

    public List<FocusEx> selectListTo(Map<String, Object> map) {
        return focusMapperEx.selectListTo(map);
    }

    public List<FocusEx> listToStore(Map<String, Object> map) {
        return focusMapperEx.listToStore(map);
    }

    public Focus findByLocation(Integer location) {
        return this.focusMapperEx.findByLocation(location);
    }
}