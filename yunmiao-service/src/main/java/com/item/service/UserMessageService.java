package com.item.service;

import java.util.List;

import com.item.daoEx.UserMessageMapperEx;
import com.item.daoEx.model.UserMessageEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.UserMessageMapper;
import com.item.dao.model.UserMessage;
import com.item.dao.model.UserMessageExample;

@Service
public class UserMessageService {
	@Autowired
	private UserMessageMapper userMessageMapper;

	@Autowired
	private UserMessageMapperEx userMessageMapperEx;

	public int countByExample(UserMessageExample example) {
		return this.userMessageMapper.countByExample(example);
	}

	public UserMessage selectByPrimaryKey(Integer id) {
		return this.userMessageMapper.selectByPrimaryKey(id);
	}

	public List<UserMessage> selectByExample(UserMessageExample example) {
		return this.userMessageMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userMessageMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserMessage record) {
		return this.userMessageMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserMessage record) {
		return this.userMessageMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserMessageExample example) {
		return this.userMessageMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(UserMessage record, UserMessageExample example) {
		return this.userMessageMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(UserMessage record, UserMessageExample example) {
		return this.userMessageMapper.updateByExample(record, example);
	}

	public int insert(UserMessage record) {
		return this.userMessageMapper.insert(record);
	}

	public int insertSelective(UserMessage record) {
		return this.userMessageMapper.insertSelective(record);
	}



	/**
	 * 获取私信列表
	 * @param message
	 * @return
	 */
	public List<UserMessageEx> findList(UserMessage message){
		return userMessageMapperEx.findList(message);
	}

	/**
	 * 获取私信对话列表
	 * @param message
	 * @return
	 */
	public List<UserMessageEx> findListEx(UserMessage message){
		return userMessageMapperEx.findListEx(message);
	}


}
