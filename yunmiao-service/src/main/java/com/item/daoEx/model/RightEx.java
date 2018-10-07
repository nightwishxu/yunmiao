package com.item.daoEx.model;

import com.item.dao.model.Right;

public class RightEx extends Right {

	private String state = "open";

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
