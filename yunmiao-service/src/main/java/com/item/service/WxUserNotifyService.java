package com.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.WxUserNotifyMapper;
import com.item.dao.model.WxUserNotify;
import com.item.dao.model.WxUserNotifyExample;

@Service
public class WxUserNotifyService {
	@Autowired
	private WxUserNotifyMapper wxUserNotifyMapper;

	public int countByExample(WxUserNotifyExample example) {
		return this.wxUserNotifyMapper.countByExample(example);
	}

	public WxUserNotify selectByPrimaryKey(Integer id) {
		return this.wxUserNotifyMapper.selectByPrimaryKey(id);
	}

	public List<WxUserNotify> selectByExample(WxUserNotifyExample example) {
		return this.wxUserNotifyMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.wxUserNotifyMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(WxUserNotify record) {
		return this.wxUserNotifyMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(WxUserNotify record) {
		return this.wxUserNotifyMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(WxUserNotifyExample example) {
		return this.wxUserNotifyMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(WxUserNotify record, WxUserNotifyExample example) {
		return this.wxUserNotifyMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(WxUserNotify record, WxUserNotifyExample example) {
		return this.wxUserNotifyMapper.updateByExample(record, example);
	}

	public int insert(WxUserNotify record) {
		return this.wxUserNotifyMapper.insert(record);
	}

	public int insertSelective(WxUserNotify record) {
		return this.wxUserNotifyMapper.insertSelective(record);
	}

}
