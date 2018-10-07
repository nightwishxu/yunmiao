package com.paidang.dao.model;



/**
 *
 */
public class Diamond {

	/**
	 *
	 */
	private Integer id;

	/**
	 *亮度
	 */
	private String color;

	/**
	 *颜色
	 */
	private String light;

	/**
	 *起始重量
	 */
	private Float weightBegin;

	/**
	 *最后重量
	 */
	private Float weigthEnd;

	/**
	 *对应的值
	 */
	private String value;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setColor(String color) {
		this.color=color == null ? color : color.trim();
	}

	public String getColor() {
		return color;
	}

	public void setLight(String light) {
		this.light=light == null ? light : light.trim();
	}

	public String getLight() {
		return light;
	}

	public void setWeightBegin(Float weightBegin) {
		this.weightBegin=weightBegin;
	}

	public Float getWeightBegin() {
		return weightBegin;
	}

	public void setWeigthEnd(Float weigthEnd) {
		this.weigthEnd=weigthEnd;
	}

	public Float getWeigthEnd() {
		return weigthEnd;
	}

	public void setValue(String value) {
		this.value=value == null ? value : value.trim();
	}

	public String getValue() {
		return value;
	}

}
