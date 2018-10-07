package com.api.view.myPawn;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 我的典当--已典当--操作
 * @author vonkira
 *
 */
@ApiModel
public class AppMyPawnPerate {

	@ApiModelProperty(value="当品id")
	private Integer id;
	@ApiModelProperty(value="当品图片")
	private List<String> images;
	@ApiModelProperty(value="当品名称")
	private String title;
	@ApiModelProperty(value="鉴定价格")
	private String authPrice;
	@ApiModelProperty(value="当铺机构名称")
	private Integer orgName;
	@ApiModelProperty(value="当款额")
	private String money;
	@ApiModelProperty(value="贷款利率")
	private String rate;
	@ApiModelProperty(value="电话")
	private String phone;
	@ApiModelProperty(value="状态(0:未放款 1:已放款)")
	private Integer state;
	@ApiModelProperty(value="借款日期")
	private Date beginTime;
	@ApiModelProperty(value="还款日期")
	private Date backTime;
	@ApiModelProperty(value="到期应还款额度")
	private String Cmoney;
	@ApiModelProperty(value="本金")
	private String principal;
	@ApiModelProperty(value="综合费")
	private String comMoney;
	@ApiModelProperty(value="服务费")
	private String serviceMoney;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthPrice() {
		return authPrice;
	}
	public void setAuthPrice(String authPrice) {
		this.authPrice = authPrice;
	}
	public Integer getOrgName() {
		return orgName;
	}
	public void setOrgName(Integer orgName) {
		this.orgName = orgName;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getBackTime() {
		return backTime;
	}
	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}
	public String getCmoney() {
		return Cmoney;
	}
	public void setCmoney(String cmoney) {
		Cmoney = cmoney;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getComMoney() {
		return comMoney;
	}
	public void setComMoney(String comMoney) {
		this.comMoney = comMoney;
	}
	public String getServiceMoney() {
		return serviceMoney;
	}
	public void setServiceMoney(String serviceMoney) {
		this.serviceMoney = serviceMoney;
	}
	
	
}
