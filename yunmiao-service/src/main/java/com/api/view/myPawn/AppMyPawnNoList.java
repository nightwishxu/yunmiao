package com.api.view.myPawn;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * 我的典当--未典当列表
 * @author vonkira
 *
 */
@ApiModel
public class AppMyPawnNoList {

	private List<AppMyPawnNoDetail> list;

	public List<AppMyPawnNoDetail> getList() {
		return list;
	}

	public void setList(List<AppMyPawnNoDetail> list) {
		this.list = list;
	}
	
	
}
