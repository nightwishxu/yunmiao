package com.api.view.toutiao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.view.home.UserInfo;
import com.base.util.DFA;

@ApiModel
public class AppNews {

	private Integer id;
	@ApiModelProperty(value="标题")
	private String title;
	@ApiModelProperty(value="1图文2图片3视频")
	private Integer type;
	@ApiModelProperty(value="1热门")
	private Integer isHot;
	@ApiModelProperty(value="1置顶")
	private Integer isTop;
	@ApiModelProperty(value="图片")
	private List<String> imgs;
	@ApiModelProperty(value="时间")
	private String time;
	@ApiModelProperty(value="用户信息")
	private UserInfo userInfo;
	@ApiModelProperty(value="内容")
	private Object content;
	@ApiModelProperty(value="评论数量")
	private Integer commentCnt;
	@ApiModelProperty(value="赞数量")
	private Integer praiseCnt;
	@ApiModelProperty(value="是否收藏")
	private Integer isCollect;
	@ApiModelProperty(value="来源")
	private String source;
	public String getTitle() {
		return DFA.replaceKeys(title);
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getIsHot() {
		return isHot;
	}
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	public Integer getIsTop() {
		return isTop;
	}
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}
	public List<String> getImgs() {
		return imgs;
	}
	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Object getContent() {
		if (this.type == 3){
			return content;
		}else{
			JSONArray array = (JSONArray) content;
			for (int i = 0; i < array.size(); i++){
				JSONObject json = array.getJSONObject(i);
				String content = json.getString("content");
				if (StringUtils.isNotBlank(content)){
					json.put("content", DFA.replaceKeys(content));
				}
			}
			return array;
		}
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public Integer getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(Integer commentCnt) {
		this.commentCnt = commentCnt;
	}
	public Integer getPraiseCnt() {
		return praiseCnt;
	}
	public void setPraiseCnt(Integer praiseCnt) {
		this.praiseCnt = praiseCnt;
	}
	public Integer getIsCollect() {
		return isCollect;
	}
	public void setIsCollect(Integer isCollect) {
		this.isCollect = isCollect;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
}
