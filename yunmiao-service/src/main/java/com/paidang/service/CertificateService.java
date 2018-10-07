package com.paidang.service;

import java.util.List;
import java.util.Map;

import com.paidang.daoEx.model.CertificateEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.CertificateMapper;
import com.paidang.dao.model.Certificate;
import com.paidang.dao.model.CertificateExample;

@Service
public class CertificateService {
	@Autowired
	private CertificateMapper certificateMapper;

	public int countByExample(CertificateExample example) {
		return this.certificateMapper.countByExample(example);
	}

	public Certificate selectByPrimaryKey(Integer id) {
		return this.certificateMapper.selectByPrimaryKey(id);
	}

	public List<Certificate> selectByExample(CertificateExample example) {
		return this.certificateMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.certificateMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Certificate record) {
		return this.certificateMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Certificate record) {
		return this.certificateMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(CertificateExample example) {
		return this.certificateMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(Certificate record, CertificateExample example) {
		return this.certificateMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(Certificate record, CertificateExample example) {
		return this.certificateMapper.updateByExample(record, example);
	}

	public int insert(Certificate record) {
		return this.certificateMapper.insert(record);
	}

	public int insertSelective(Certificate record) {
		return this.certificateMapper.insertSelective(record);
	}
}
