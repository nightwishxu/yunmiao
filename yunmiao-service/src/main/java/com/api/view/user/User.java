package com.api.view.user;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 用户信息
 * @author vonkira
 *
 */
@ApiModel
public class User {

	private Integer id;
	@ApiModelProperty(value="用户账号(手机号)")
	private Integer account;
	@ApiModelProperty(value="用户昵称")
	private String nickName;
	@ApiModelProperty(value="用户名称")
	private String name;
	@ApiModelProperty(value="用户性别(0:男 1:女  2;未知)")
	private Integer sex;
	@ApiModelProperty(value="身份证")
	private String idCard;
	@ApiModelProperty(value="身份证是否绑定(0:未绑定 1绑定)")
	private Integer inBind;
	@ApiModelProperty(value="默认地址")
	private String address;
	@ApiModelProperty(value="头像")
	private String headImage;
	
	private Date createTime;
	
	private Date modifyTime;

	
}
