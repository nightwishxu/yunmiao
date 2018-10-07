package com.weixin.daoEx.model;

import com.weixin.dao.model.Menu;

public class MenuEx extends Menu{

	private String state = "open";

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}