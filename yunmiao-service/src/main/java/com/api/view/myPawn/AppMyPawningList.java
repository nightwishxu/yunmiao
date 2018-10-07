package com.api.view.myPawn;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * 我的典当--竞拍中--列表
 * @author vonkira
 *
 */
@ApiModel
public class AppMyPawningList {

	private List<AppMyPawningDetail> list;

	public List<AppMyPawningDetail> getList() {
		return list;
	}

	public void setList(List<AppMyPawningDetail> list) {
		this.list = list;
	}
	
	
}
