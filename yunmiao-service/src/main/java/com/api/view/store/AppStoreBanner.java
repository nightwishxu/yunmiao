package com.api.view.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 拍档商城轮播图
 * @author vonkira
 *
 */
@ApiModel
public class AppStoreBanner {

	@ApiModelProperty(value="图片id")
	private Integer id;
	@ApiModelProperty(value="图片连接")
	private String url;
	@ApiModelProperty(value="类型 0不跳转；1网址；2富文本；3认证商城商品详情页；4绝当商城商品详情页；5视频详情页")
	private Integer type;
	@ApiModelProperty(value="内容 null、跳转url、富文本内容、商品id、视频id")
	private String content;
	@ApiModelProperty(value="类型1绝当竞拍  2绝当普通拍卖")
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
