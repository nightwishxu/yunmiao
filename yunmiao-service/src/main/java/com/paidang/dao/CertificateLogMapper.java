package com.paidang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paidang.dao.model.CertificateLog;
import com.paidang.dao.model.CertificateLogExample;

public interface CertificateLogMapper {
	int countByExample(CertificateLogExample example);

	int deleteByExample(CertificateLogExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(CertificateLog record);

	int insertSelective(CertificateLog record);

	List<CertificateLog> selectByExample(CertificateLogExample example);

	CertificateLog selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") CertificateLog record,@Param("example") CertificateLogExample example);

	int updateByExample(@Param("record") CertificateLog record,@Param("example") CertificateLogExample example);

	int updateByPrimaryKeySelective(CertificateLog record);

	int updateByPrimaryKey(CertificateLog record);

}
