package com.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.UserReportMapper;
import com.item.dao.model.UserReport;
import com.item.dao.model.UserReportExample;

@Service
public class UserReportService {
	@Autowired
	private UserReportMapper userReportMapper;

	public int countByExample(UserReportExample example) {
		return this.userReportMapper.countByExample(example);
	}

	public UserReport selectByPrimaryKey(Integer id) {
		return this.userReportMapper.selectByPrimaryKey(id);
	}

	public List<UserReport> selectByExample(UserReportExample example) {
		return this.userReportMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userReportMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserReport record) {
		return this.userReportMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserReport record) {
		return this.userReportMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserReportExample example) {
		return this.userReportMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(UserReport record, UserReportExample example) {
		return this.userReportMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(UserReport record, UserReportExample example) {
		return this.userReportMapper.updateByExample(record, example);
	}

	public int insert(UserReport record) {
		return this.userReportMapper.insert(record);
	}

	public int insertSelective(UserReport record) {
		return this.userReportMapper.insertSelective(record);
	}

}
