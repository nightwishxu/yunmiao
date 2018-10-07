package com.api.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@ApiModel
public class PageLimit {

	@ApiModelProperty(value="页数")
	@ApiParam(required = true)
	private Integer page;
	@ApiModelProperty(value="每页条数")
	@ApiParam(required = true)
	private Integer limit;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}
