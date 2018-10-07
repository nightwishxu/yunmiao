package com.item.daoEx.model;

import com.item.dao.model.Notify;

public class NotifyEx extends Notify {
	private String nickName;
	private String account;
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	
}
