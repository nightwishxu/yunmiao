package com.paidang.dao.model;



/**
 *
 */
public class Certificate {

	/**
	 *
	 */
	private Integer id;

	/**
	 *名称
	 */
	private String name;

	/**
	 *编号
	 */
	private String code;

	/**
	 *尺寸--长
	 */
	private String length;

	/**
	 *尺寸--宽
	 */
	private String width;

	/**
	 *尺寸--高
	 */
	private String height;

	/**
	 *重量
	 */
	private String weight;

	/**
	 *材质
	 */
	private String material;

	/**
	 *主体材质
	 */
	private String mainMaterial;

	/**
	 *其他辅材
	 */
	private String otherMaterial;

	/**
	 *创作年代
	 */
	private String createYear;

	/**
	 *其他
	 */
	private String other;

	/**
	 *图片概览
	 */
	private String imgs;

	/**
	 *市场流通性0-5分
	 */
	private Integer marketLiquidity;

	/**
	 *价值稳定性0-5分
	 */
	private Integer valueStability;

	/**
	 *材质易损性
	 */
	private Integer materialVulnerability;

	/**
	 *存放条件
	 */
	private String storageCondition;

	/**
	 *肉眼可见缺陷
	 */
	private String nakedEyeDefect;

	/**
	 *金融记录
	 */
	private String financeLog;

	/**
	 *其他事项
	 */
	private String otherBusiness;

	/**
	 *
	 */
	private java.util.Date createTime;

	/**
	 *
	 */
	private java.util.Date modifyTime;

	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name=name == null ? name : name.trim();
	}

	public String getName() {
		return name;
	}

	public void setCode(String code) {
		this.code=code == null ? code : code.trim();
	}

	public String getCode() {
		return code;
	}

	public void setLength(String length) {
		this.length=length == null ? length : length.trim();
	}

	public String getLength() {
		return length;
	}

	public void setWidth(String width) {
		this.width=width == null ? width : width.trim();
	}

	public String getWidth() {
		return width;
	}

	public void setHeight(String height) {
		this.height=height == null ? height : height.trim();
	}

	public String getHeight() {
		return height;
	}

	public void setWeight(String weight) {
		this.weight=weight == null ? weight : weight.trim();
	}

	public String getWeight() {
		return weight;
	}

	public void setMaterial(String material) {
		this.material=material == null ? material : material.trim();
	}

	public String getMaterial() {
		return material;
	}

	public void setMainMaterial(String mainMaterial) {
		this.mainMaterial=mainMaterial == null ? mainMaterial : mainMaterial.trim();
	}

	public String getMainMaterial() {
		return mainMaterial;
	}

	public void setOtherMaterial(String otherMaterial) {
		this.otherMaterial=otherMaterial == null ? otherMaterial : otherMaterial.trim();
	}

	public String getOtherMaterial() {
		return otherMaterial;
	}

	public void setCreateYear(String createYear) {
		this.createYear=createYear == null ? createYear : createYear.trim();
	}

	public String getCreateYear() {
		return createYear;
	}

	public void setOther(String other) {
		this.other=other == null ? other : other.trim();
	}

	public String getOther() {
		return other;
	}

	public void setImgs(String imgs) {
		this.imgs=imgs == null ? imgs : imgs.trim();
	}

	public String getImgs() {
		return imgs;
	}

	public void setMarketLiquidity(Integer marketLiquidity) {
		this.marketLiquidity=marketLiquidity;
	}

	public Integer getMarketLiquidity() {
		return marketLiquidity;
	}

	public void setValueStability(Integer valueStability) {
		this.valueStability=valueStability;
	}

	public Integer getValueStability() {
		return valueStability;
	}

	public void setMaterialVulnerability(Integer materialVulnerability) {
		this.materialVulnerability=materialVulnerability;
	}

	public Integer getMaterialVulnerability() {
		return materialVulnerability;
	}

	public void setStorageCondition(String storageCondition) {
		this.storageCondition=storageCondition == null ? storageCondition : storageCondition.trim();
	}

	public String getStorageCondition() {
		return storageCondition;
	}

	public void setNakedEyeDefect(String nakedEyeDefect) {
		this.nakedEyeDefect=nakedEyeDefect == null ? nakedEyeDefect : nakedEyeDefect.trim();
	}

	public String getNakedEyeDefect() {
		return nakedEyeDefect;
	}

	public void setFinanceLog(String financeLog) {
		this.financeLog=financeLog == null ? financeLog : financeLog.trim();
	}

	public String getFinanceLog() {
		return financeLog;
	}

	public void setOtherBusiness(String otherBusiness) {
		this.otherBusiness=otherBusiness == null ? otherBusiness : otherBusiness.trim();
	}

	public String getOtherBusiness() {
		return otherBusiness;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime=createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setModifyTime(java.util.Date modifyTime) {
		this.modifyTime=modifyTime;
	}

	public java.util.Date getModifyTime() {
		return modifyTime;
	}

}
