package com.api.view.authApply;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 我要典当
 * @author vonkira
 *
 */
@ApiModel
public class AppMyAuth {

	private Integer id;
	@ApiModelProperty(value="当品id")
	private Integer cid;
	@ApiModelProperty(value="宝贝图片")
	private List<String> images;
	@ApiModelProperty(value="宝贝名称")
	private String title;
	@ApiModelProperty(value="鉴定价格")
	private String authPrice;
	@ApiModelProperty(value="贷款额度")
	private BigDecimal loansPrice;
	@ApiModelProperty(value="借款日期")
	private Date loansTime;
	@ApiModelProperty(value="借款时长")
	private String loansTotalTime;
	@ApiModelProperty(value="用户id")
	private Integer userId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
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
	public BigDecimal getLoansPrice() {
		return loansPrice;
	}
	public void setLoansPrice(BigDecimal loansPrice) {
		this.loansPrice = loansPrice;
	}
	public Date getLoansTime() {
		return loansTime;
	}
	public void setLoansTime(Date loansTime) {
		this.loansTime = loansTime;
	}
	public String getLoansTotalTime() {
		return loansTotalTime;
	}
	public void setLoansTotalTime(String loansTotalTime) {
		this.loansTotalTime = loansTotalTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
