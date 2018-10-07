package com.api.view.pawnCommon.logistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 物流信息
 * @author vonkira
 *
 */
@ApiModel
public class AppLogistics {

	@ApiModelProperty(value="物流公司id")
	private Integer id;
	@ApiModelProperty(value="物流公司名称")
	private String name;
	@ApiModelProperty(value="物流单号")
	private String code;
}
