package com.paidang.service;

import java.util.List;

import com.paidang.daoEx.model.CertificateLogEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.CertificateLogMapper;
import com.paidang.dao.model.CertificateLog;
import com.paidang.dao.model.CertificateLogExample;

@Service
public class CertificateLogService {
	@Autowired
	private CertificateLogMapper certificateLogMapper;

	public int countByExample(CertificateLogExample example) {
		return this.certificateLogMapper.countByExample(example);
	}

	public CertificateLog selectByPrimaryKey(Integer id) {
		return this.certificateLogMapper.selectByPrimaryKey(id);
	}

	public List<CertificateLog> selectByExample(CertificateLogExample example) {
		return this.certificateLogMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.certificateLogMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(CertificateLog record) {
		return this.certificateLogMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(CertificateLog record) {
		return this.certificateLogMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(CertificateLogExample example) {
		return this.certificateLogMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(CertificateLog record, CertificateLogExample example) {
		return this.certificateLogMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(CertificateLog record, CertificateLogExample example) {
		return this.certificateLogMapper.updateByExample(record, example);
	}

	public int insert(CertificateLog record) {
		return this.certificateLogMapper.insert(record);
	}

	public int insertSelective(CertificateLog record) {
		return this.certificateLogMapper.insertSelective(record);
	}
}
