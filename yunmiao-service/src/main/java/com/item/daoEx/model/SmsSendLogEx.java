package com.item.daoEx.model;

import com.item.dao.model.SmsSendLog;

public class SmsSendLogEx extends SmsSendLog{

	private String errorName;

	public String getErrorName() {
		return errorName;
	}

	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	
}
