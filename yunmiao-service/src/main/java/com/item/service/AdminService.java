package com.item.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.des.Md5;
import com.item.dao.AdminMapper;
import com.item.dao.model.Admin;
import com.item.dao.model.AdminExample;
import com.item.daoEx.AdminMapperEx;
import com.item.daoEx.model.AdminEx;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminMapperEx adminMapperEx;
    
    private static final Logger logger = Logger.getLogger(AdminService.class);

    public int countByExample(AdminExample example) {
        return this.adminMapper.countByExample(example);
    }

    public Admin selectByPrimaryKey(Integer id) {
        return this.adminMapper.selectByPrimaryKey(id);
    }

    public List<Admin> selectByExample(AdminExample example) {
        return this.adminMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.adminMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Admin record) {
        return this.adminMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Admin record) {
        return this.adminMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(AdminExample example) {
        return this.adminMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Admin record, AdminExample example) {
        return this.adminMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Admin record, AdminExample example) {
        return this.adminMapper.updateByExample(record, example);
    }

    public int insert(Admin record) {
        return this.adminMapper.insert(record);
    }

    public int insertSelective(Admin record) {
        return this.adminMapper.insertSelective(record);
    }
    
    public List<AdminEx> selectAdmins(String groupId, String roleId){
    	return adminMapperEx.selectAdmins(groupId, roleId);
    }
    
    public Admin login(String account, String password)throws Exception{
    	AdminExample example = new AdminExample();
    	example.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);
    	List<Admin> list = adminMapper.selectByExample(example);
    	if (list == null || list.size() == 0){
    		return null;
    	}else {
			return list.get(0);
		}
    }
    
    public int changePwd(Integer id, String password) throws Exception {
    	Admin admin = new Admin();
    	admin.setId(id);
    	admin.setPassword(Md5.md5(password));
    	return adminMapper.updateByPrimaryKeySelective(admin);
    }
}