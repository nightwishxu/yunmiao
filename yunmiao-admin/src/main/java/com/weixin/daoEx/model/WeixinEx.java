package com.weixin.daoEx.model;

import com.weixin.dao.model.Weixin;

public class WeixinEx extends Weixin {

	private String token;
	private String url;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
