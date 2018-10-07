package com.item.daoEx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.daoEx.model.AdminEx;

public interface AdminMapperEx {

	AdminEx selectUser(String id);
	
	List<AdminEx> selectAdmins(@Param("group")String groupId, @Param("role")String roleId);
	
}
