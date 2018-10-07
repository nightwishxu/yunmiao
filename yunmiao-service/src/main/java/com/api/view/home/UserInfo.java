package com.api.view.home;

import com.base.util.DFA;

import com.item.dao.model.Article;
import com.item.daoEx.model.ArticleEx;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.List;

@ApiModel(value="userInfo")
public class UserInfo {

	@ApiModelProperty(value="用户id")
	@ApiParam(hidden=true)
	private Integer id;
	@ApiModelProperty(value="账号")
	@ApiParam(hidden=true)
	private String account;
	@ApiModelProperty(value="昵称")
	private String nickName;
	@ApiModelProperty(value="头像")
	private String headImg;
	@ApiModelProperty(value="性别0:女 1:男")
	private Integer sex;
	@ApiModelProperty(value="用户余额")
	private String balance;
	@ApiModelProperty(value="地址")
	private String address;
	@ApiModelProperty(value="身份证正面")
	private String idCardImg;
	@ApiModelProperty(value="身份证反面")
	private String idCardReverse;
	@ApiModelProperty(value="身份证是否绑定0:未绑定 1绑定")
	private Integer isBind;

	/**
	 *是否实名认证 0未认证1认证中2认证通过
	 */
	@ApiModelProperty(value="是否实名认证 0未认证1认证中2认证通过")
	private Integer realNameAuthentication;

	/**
	 *是否平台认证 0未认证1认证中2认证通过
	 */
	@ApiModelProperty(value="是否平台认证 0未认证1认证中2认证通过")
	private Integer platformAuthentication;

	@ApiModelProperty(value="个人签名")
	private String signature;

	@ApiModelProperty(value="获赞数")
	private Integer praiseCount;

	@ApiModelProperty(value="关注数")
	private Integer followCount;

	@ApiModelProperty(value="粉丝数")
	private Integer fansCount;

	@ApiModelProperty(value="动态")
	private List<Article>  articles;

	@ApiModelProperty(value="是否关注0未关注1已关注")
	private Integer isFollow;

	public UserInfo(){};

	public UserInfo(Integer id,String nickName){
		this.id = id;
		this.nickName = nickName;
		this.sex = 0;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getNickName() {
		return DFA.replaceKeys(nickName);
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdCardImg() {
		return idCardImg;
	}

	public void setIdCardImg(String idCardImg) {
		this.idCardImg = idCardImg;
	}

	public String getIdCardReverse() {
		return idCardReverse;
	}

	public void setIdCardReverse(String idCardReverse) {
		this.idCardReverse = idCardReverse;
	}

	public Integer getIsBind() {
		return isBind;
	}

	public void setIsBind(Integer isBind) {
		this.isBind = isBind;
	}

	public Integer getRealNameAuthentication() {
		return realNameAuthentication;
	}

	public void setRealNameAuthentication(Integer realNameAuthentication) {
		this.realNameAuthentication = realNameAuthentication;
	}

	public Integer getPlatformAuthentication() {
		return platformAuthentication;
	}

	public void setPlatformAuthentication(Integer platformAuthentication) {
		this.platformAuthentication = platformAuthentication;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}

	public Integer getFollowCount() {
		return followCount;
	}

	public void setFollowCount(Integer followCount) {
		this.followCount = followCount;
	}

	public Integer getFansCount() {
		return fansCount;
	}

	public void setFansCount(Integer fansCount) {
		this.fansCount = fansCount;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Integer getIsFollow() {
		return isFollow;
	}

	public void setIsFollow(Integer isFollow) {
		this.isFollow = isFollow;
	}
}
