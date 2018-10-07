package com.api.view.mailGoodsByUser;

import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 邮寄宝贝
 * @author vonkira
 *
 */
@ApiModel
public class AppMailGoods {

	
	private Integer id;
	@ApiModelProperty(value="当品id")
	private Integer goodsId;
	@ApiModelProperty(value="当品名称")
	private String title;
	@ApiModelProperty(value="是否有图片(0:没有  1:有)")
	private Integer haveImage;
	@ApiModelProperty(value="是否有视频(0:没有  1:有)")
	private Integer haveVidio;
	@ApiModelProperty(value="图片")
	private List<String> images;
	@ApiModelProperty(value="视频")
	private List<String> vidios;
	@ApiModelProperty(value="用户id")
	private Integer UserId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getHaveImage() {
		return haveImage;
	}
	public void setHaveImage(Integer haveImage) {
		this.haveImage = haveImage;
	}
	public Integer getHaveVidio() {
		return haveVidio;
	}
	public void setHaveVidio(Integer haveVidio) {
		this.haveVidio = haveVidio;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public List<String> getVidios() {
		return vidios;
	}
	public void setVidios(List<String> vidios) {
		this.vidios = vidios;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	
	
	
	
	
}
