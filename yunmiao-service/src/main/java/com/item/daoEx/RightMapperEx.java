package com.item.daoEx;

import java.util.List;

import com.item.dao.model.Right;

public interface RightMapperEx {
	List<Right> selectByRole(Integer roleId);
}
