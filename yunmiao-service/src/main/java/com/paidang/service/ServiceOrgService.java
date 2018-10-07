package com.paidang.service;

import java.util.List;

import com.base.des.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.ServiceOrgMapper;
import com.paidang.dao.model.ServiceOrg;
import com.paidang.dao.model.ServiceOrgExample;

@Service
public class ServiceOrgService {
	@Autowired
	private ServiceOrgMapper serviceOrgMapper;

	public int countByExample(ServiceOrgExample example) {
		return this.serviceOrgMapper.countByExample(example);
	}

	public ServiceOrg selectByPrimaryKey(Integer id) {
		return this.serviceOrgMapper.selectByPrimaryKey(id);
	}

	public List<ServiceOrg> selectByExample(ServiceOrgExample example) {
		return this.serviceOrgMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.serviceOrgMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(ServiceOrg record) {
		return this.serviceOrgMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ServiceOrg record) {
		return this.serviceOrgMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(ServiceOrgExample example) {
		return this.serviceOrgMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(ServiceOrg record, ServiceOrgExample example) {
		return this.serviceOrgMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(ServiceOrg record, ServiceOrgExample example) {
		return this.serviceOrgMapper.updateByExample(record, example);
	}

	public int insert(ServiceOrg record) {
		return this.serviceOrgMapper.insert(record);
	}

	public int insertSelective(ServiceOrg record) {
		return this.serviceOrgMapper.insertSelective(record);
	}

	public ServiceOrg login(String account, String password)throws Exception{
		ServiceOrgExample example = new ServiceOrgExample();
		example.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);
		List<ServiceOrg> list = serviceOrgMapper.selectByExample(example);
		if (list == null || list.size() == 0){
			return null;
		}else {
			return list.get(0);
		}
	}

	public int changePwd(Integer id, String password) throws Exception {
		ServiceOrg admin = new ServiceOrg();
		admin.setId(id);
		admin.setPassword(Md5.md5(password));
		return serviceOrgMapper.updateByPrimaryKeySelective(admin);
	}

}
