package com.paidang.dao.model;



/**
 *
 */
public class VideoOnline {

	/**
	 *
	 */
	private Integer id;

	/**
	 *标题
	 */
	private String title;

	/**
	 *封面
	 */
	private String img;

	/**
	 *视频
	 */
	private String video;

	/**
	 *观看人数
	 */
	private Integer viewCnt;

	/**
	 *是否首页展示 0:否 1:是
	 */
	private Integer state;

	/**
	 *创建时间
	 */
	private java.util.Date createTime;

	/**
	 *是否设置为视频推荐 0不设置 1设置
	 */
	private Integer isSuggest;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title=title == null ? title : title.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setImg(String img) {
		this.img=img == null ? img : img.trim();
	}

	public String getImg() {
		return img;
	}

	public void setVideo(String video) {
		this.video=video == null ? video : video.trim();
	}

	public String getVideo() {
		return video;
	}

	public void setViewCnt(Integer viewCnt) {
		this.viewCnt=viewCnt;
	}

	public Integer getViewCnt() {
		return viewCnt;
	}

	public void setState(Integer state) {
		this.state=state;
	}

	public Integer getState() {
		return state;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setIsSuggest(Integer isSuggest) {
		this.isSuggest=isSuggest;
	}

	public Integer getIsSuggest() {
		return isSuggest;
	}

}
