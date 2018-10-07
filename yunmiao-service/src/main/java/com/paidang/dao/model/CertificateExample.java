package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class CertificateExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CertificateExample(){
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andCodeIsNull() {
			addCriterion("code is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("code is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("code =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("code <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("code >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("code >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("code <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("code <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("code like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("code not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("code in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("code not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("code between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("code not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andLengthIsNull() {
			addCriterion("length is null");
			return (Criteria) this;
		}

		public Criteria andLengthIsNotNull() {
			addCriterion("length is not null");
			return (Criteria) this;
		}

		public Criteria andLengthEqualTo(String value) {
			addCriterion("length =", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthNotEqualTo(String value) {
			addCriterion("length <>", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthGreaterThan(String value) {
			addCriterion("length >", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthGreaterThanOrEqualTo(String value) {
			addCriterion("length >=", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthLessThan(String value) {
			addCriterion("length <", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthLessThanOrEqualTo(String value) {
			addCriterion("length <=", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthLike(String value) {
			addCriterion("length like", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthNotLike(String value) {
			addCriterion("length not like", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthIn(List<String> values) {
			addCriterion("length in", values, "length");
			return (Criteria) this;
		}

		public Criteria andLengthNotIn(List<String> values) {
			addCriterion("length not in", values, "length");
			return (Criteria) this;
		}

		public Criteria andLengthBetween(String value1, String value2) {
			addCriterion("length between", value1, value2, "length");
			return (Criteria) this;
		}

		public Criteria andLengthNotBetween(String value1, String value2) {
			addCriterion("length not between", value1, value2, "length");
			return (Criteria) this;
		}

		public Criteria andWidthIsNull() {
			addCriterion("width is null");
			return (Criteria) this;
		}

		public Criteria andWidthIsNotNull() {
			addCriterion("width is not null");
			return (Criteria) this;
		}

		public Criteria andWidthEqualTo(String value) {
			addCriterion("width =", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotEqualTo(String value) {
			addCriterion("width <>", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthGreaterThan(String value) {
			addCriterion("width >", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthGreaterThanOrEqualTo(String value) {
			addCriterion("width >=", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthLessThan(String value) {
			addCriterion("width <", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthLessThanOrEqualTo(String value) {
			addCriterion("width <=", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthLike(String value) {
			addCriterion("width like", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotLike(String value) {
			addCriterion("width not like", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthIn(List<String> values) {
			addCriterion("width in", values, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotIn(List<String> values) {
			addCriterion("width not in", values, "width");
			return (Criteria) this;
		}

		public Criteria andWidthBetween(String value1, String value2) {
			addCriterion("width between", value1, value2, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotBetween(String value1, String value2) {
			addCriterion("width not between", value1, value2, "width");
			return (Criteria) this;
		}

		public Criteria andHeightIsNull() {
			addCriterion("height is null");
			return (Criteria) this;
		}

		public Criteria andHeightIsNotNull() {
			addCriterion("height is not null");
			return (Criteria) this;
		}

		public Criteria andHeightEqualTo(String value) {
			addCriterion("height =", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotEqualTo(String value) {
			addCriterion("height <>", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightGreaterThan(String value) {
			addCriterion("height >", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightGreaterThanOrEqualTo(String value) {
			addCriterion("height >=", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightLessThan(String value) {
			addCriterion("height <", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightLessThanOrEqualTo(String value) {
			addCriterion("height <=", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightLike(String value) {
			addCriterion("height like", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotLike(String value) {
			addCriterion("height not like", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightIn(List<String> values) {
			addCriterion("height in", values, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotIn(List<String> values) {
			addCriterion("height not in", values, "height");
			return (Criteria) this;
		}

		public Criteria andHeightBetween(String value1, String value2) {
			addCriterion("height between", value1, value2, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotBetween(String value1, String value2) {
			addCriterion("height not between", value1, value2, "height");
			return (Criteria) this;
		}

		public Criteria andWeightIsNull() {
			addCriterion("weight is null");
			return (Criteria) this;
		}

		public Criteria andWeightIsNotNull() {
			addCriterion("weight is not null");
			return (Criteria) this;
		}

		public Criteria andWeightEqualTo(String value) {
			addCriterion("weight =", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightNotEqualTo(String value) {
			addCriterion("weight <>", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightGreaterThan(String value) {
			addCriterion("weight >", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightGreaterThanOrEqualTo(String value) {
			addCriterion("weight >=", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightLessThan(String value) {
			addCriterion("weight <", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightLessThanOrEqualTo(String value) {
			addCriterion("weight <=", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightLike(String value) {
			addCriterion("weight like", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightNotLike(String value) {
			addCriterion("weight not like", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightIn(List<String> values) {
			addCriterion("weight in", values, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightNotIn(List<String> values) {
			addCriterion("weight not in", values, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightBetween(String value1, String value2) {
			addCriterion("weight between", value1, value2, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightNotBetween(String value1, String value2) {
			addCriterion("weight not between", value1, value2, "weight");
			return (Criteria) this;
		}

		public Criteria andMaterialIsNull() {
			addCriterion("material is null");
			return (Criteria) this;
		}

		public Criteria andMaterialIsNotNull() {
			addCriterion("material is not null");
			return (Criteria) this;
		}

		public Criteria andMaterialEqualTo(String value) {
			addCriterion("material =", value, "material");
			return (Criteria) this;
		}

		public Criteria andMaterialNotEqualTo(String value) {
			addCriterion("material <>", value, "material");
			return (Criteria) this;
		}

		public Criteria andMaterialGreaterThan(String value) {
			addCriterion("material >", value, "material");
			return (Criteria) this;
		}

		public Criteria andMaterialGreaterThanOrEqualTo(String value) {
			addCriterion("material >=", value, "material");
			return (Criteria) this;
		}

		public Criteria andMaterialLessThan(String value) {
			addCriterion("material <", value, "material");
			return (Criteria) this;
		}

		public Criteria andMaterialLessThanOrEqualTo(String value) {
			addCriterion("material <=", value, "material");
			return (Criteria) this;
		}

		public Criteria andMaterialLike(String value) {
			addCriterion("material like", value, "material");
			return (Criteria) this;
		}

		public Criteria andMaterialNotLike(String value) {
			addCriterion("material not like", value, "material");
			return (Criteria) this;
		}

		public Criteria andMaterialIn(List<String> values) {
			addCriterion("material in", values, "material");
			return (Criteria) this;
		}

		public Criteria andMaterialNotIn(List<String> values) {
			addCriterion("material not in", values, "material");
			return (Criteria) this;
		}

		public Criteria andMaterialBetween(String value1, String value2) {
			addCriterion("material between", value1, value2, "material");
			return (Criteria) this;
		}

		public Criteria andMaterialNotBetween(String value1, String value2) {
			addCriterion("material not between", value1, value2, "material");
			return (Criteria) this;
		}

		public Criteria andMainMaterialIsNull() {
			addCriterion("main_material is null");
			return (Criteria) this;
		}

		public Criteria andMainMaterialIsNotNull() {
			addCriterion("main_material is not null");
			return (Criteria) this;
		}

		public Criteria andMainMaterialEqualTo(String value) {
			addCriterion("main_material =", value, "mainMaterial");
			return (Criteria) this;
		}

		public Criteria andMainMaterialNotEqualTo(String value) {
			addCriterion("main_material <>", value, "mainMaterial");
			return (Criteria) this;
		}

		public Criteria andMainMaterialGreaterThan(String value) {
			addCriterion("main_material >", value, "mainMaterial");
			return (Criteria) this;
		}

		public Criteria andMainMaterialGreaterThanOrEqualTo(String value) {
			addCriterion("main_material >=", value, "mainMaterial");
			return (Criteria) this;
		}

		public Criteria andMainMaterialLessThan(String value) {
			addCriterion("main_material <", value, "mainMaterial");
			return (Criteria) this;
		}

		public Criteria andMainMaterialLessThanOrEqualTo(String value) {
			addCriterion("main_material <=", value, "mainMaterial");
			return (Criteria) this;
		}

		public Criteria andMainMaterialLike(String value) {
			addCriterion("main_material like", value, "mainMaterial");
			return (Criteria) this;
		}

		public Criteria andMainMaterialNotLike(String value) {
			addCriterion("main_material not like", value, "mainMaterial");
			return (Criteria) this;
		}

		public Criteria andMainMaterialIn(List<String> values) {
			addCriterion("main_material in", values, "mainMaterial");
			return (Criteria) this;
		}

		public Criteria andMainMaterialNotIn(List<String> values) {
			addCriterion("main_material not in", values, "mainMaterial");
			return (Criteria) this;
		}

		public Criteria andMainMaterialBetween(String value1, String value2) {
			addCriterion("main_material between", value1, value2, "mainMaterial");
			return (Criteria) this;
		}

		public Criteria andMainMaterialNotBetween(String value1, String value2) {
			addCriterion("main_material not between", value1, value2, "mainMaterial");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialIsNull() {
			addCriterion("other_material is null");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialIsNotNull() {
			addCriterion("other_material is not null");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialEqualTo(String value) {
			addCriterion("other_material =", value, "otherMaterial");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialNotEqualTo(String value) {
			addCriterion("other_material <>", value, "otherMaterial");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialGreaterThan(String value) {
			addCriterion("other_material >", value, "otherMaterial");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialGreaterThanOrEqualTo(String value) {
			addCriterion("other_material >=", value, "otherMaterial");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialLessThan(String value) {
			addCriterion("other_material <", value, "otherMaterial");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialLessThanOrEqualTo(String value) {
			addCriterion("other_material <=", value, "otherMaterial");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialLike(String value) {
			addCriterion("other_material like", value, "otherMaterial");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialNotLike(String value) {
			addCriterion("other_material not like", value, "otherMaterial");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialIn(List<String> values) {
			addCriterion("other_material in", values, "otherMaterial");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialNotIn(List<String> values) {
			addCriterion("other_material not in", values, "otherMaterial");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialBetween(String value1, String value2) {
			addCriterion("other_material between", value1, value2, "otherMaterial");
			return (Criteria) this;
		}

		public Criteria andOtherMaterialNotBetween(String value1, String value2) {
			addCriterion("other_material not between", value1, value2, "otherMaterial");
			return (Criteria) this;
		}

		public Criteria andCreateYearIsNull() {
			addCriterion("create_year is null");
			return (Criteria) this;
		}

		public Criteria andCreateYearIsNotNull() {
			addCriterion("create_year is not null");
			return (Criteria) this;
		}

		public Criteria andCreateYearEqualTo(String value) {
			addCriterion("create_year =", value, "createYear");
			return (Criteria) this;
		}

		public Criteria andCreateYearNotEqualTo(String value) {
			addCriterion("create_year <>", value, "createYear");
			return (Criteria) this;
		}

		public Criteria andCreateYearGreaterThan(String value) {
			addCriterion("create_year >", value, "createYear");
			return (Criteria) this;
		}

		public Criteria andCreateYearGreaterThanOrEqualTo(String value) {
			addCriterion("create_year >=", value, "createYear");
			return (Criteria) this;
		}

		public Criteria andCreateYearLessThan(String value) {
			addCriterion("create_year <", value, "createYear");
			return (Criteria) this;
		}

		public Criteria andCreateYearLessThanOrEqualTo(String value) {
			addCriterion("create_year <=", value, "createYear");
			return (Criteria) this;
		}

		public Criteria andCreateYearLike(String value) {
			addCriterion("create_year like", value, "createYear");
			return (Criteria) this;
		}

		public Criteria andCreateYearNotLike(String value) {
			addCriterion("create_year not like", value, "createYear");
			return (Criteria) this;
		}

		public Criteria andCreateYearIn(List<String> values) {
			addCriterion("create_year in", values, "createYear");
			return (Criteria) this;
		}

		public Criteria andCreateYearNotIn(List<String> values) {
			addCriterion("create_year not in", values, "createYear");
			return (Criteria) this;
		}

		public Criteria andCreateYearBetween(String value1, String value2) {
			addCriterion("create_year between", value1, value2, "createYear");
			return (Criteria) this;
		}

		public Criteria andCreateYearNotBetween(String value1, String value2) {
			addCriterion("create_year not between", value1, value2, "createYear");
			return (Criteria) this;
		}

		public Criteria andOtherIsNull() {
			addCriterion("other is null");
			return (Criteria) this;
		}

		public Criteria andOtherIsNotNull() {
			addCriterion("other is not null");
			return (Criteria) this;
		}

		public Criteria andOtherEqualTo(String value) {
			addCriterion("other =", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotEqualTo(String value) {
			addCriterion("other <>", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherGreaterThan(String value) {
			addCriterion("other >", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherGreaterThanOrEqualTo(String value) {
			addCriterion("other >=", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherLessThan(String value) {
			addCriterion("other <", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherLessThanOrEqualTo(String value) {
			addCriterion("other <=", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherLike(String value) {
			addCriterion("other like", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotLike(String value) {
			addCriterion("other not like", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherIn(List<String> values) {
			addCriterion("other in", values, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotIn(List<String> values) {
			addCriterion("other not in", values, "other");
			return (Criteria) this;
		}

		public Criteria andOtherBetween(String value1, String value2) {
			addCriterion("other between", value1, value2, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotBetween(String value1, String value2) {
			addCriterion("other not between", value1, value2, "other");
			return (Criteria) this;
		}

		public Criteria andImgsIsNull() {
			addCriterion("imgs is null");
			return (Criteria) this;
		}

		public Criteria andImgsIsNotNull() {
			addCriterion("imgs is not null");
			return (Criteria) this;
		}

		public Criteria andImgsEqualTo(String value) {
			addCriterion("imgs =", value, "imgs");
			return (Criteria) this;
		}

		public Criteria andImgsNotEqualTo(String value) {
			addCriterion("imgs <>", value, "imgs");
			return (Criteria) this;
		}

		public Criteria andImgsGreaterThan(String value) {
			addCriterion("imgs >", value, "imgs");
			return (Criteria) this;
		}

		public Criteria andImgsGreaterThanOrEqualTo(String value) {
			addCriterion("imgs >=", value, "imgs");
			return (Criteria) this;
		}

		public Criteria andImgsLessThan(String value) {
			addCriterion("imgs <", value, "imgs");
			return (Criteria) this;
		}

		public Criteria andImgsLessThanOrEqualTo(String value) {
			addCriterion("imgs <=", value, "imgs");
			return (Criteria) this;
		}

		public Criteria andImgsLike(String value) {
			addCriterion("imgs like", value, "imgs");
			return (Criteria) this;
		}

		public Criteria andImgsNotLike(String value) {
			addCriterion("imgs not like", value, "imgs");
			return (Criteria) this;
		}

		public Criteria andImgsIn(List<String> values) {
			addCriterion("imgs in", values, "imgs");
			return (Criteria) this;
		}

		public Criteria andImgsNotIn(List<String> values) {
			addCriterion("imgs not in", values, "imgs");
			return (Criteria) this;
		}

		public Criteria andImgsBetween(String value1, String value2) {
			addCriterion("imgs between", value1, value2, "imgs");
			return (Criteria) this;
		}

		public Criteria andImgsNotBetween(String value1, String value2) {
			addCriterion("imgs not between", value1, value2, "imgs");
			return (Criteria) this;
		}

		public Criteria andMarketLiquidityIsNull() {
			addCriterion("market_liquidity is null");
			return (Criteria) this;
		}

		public Criteria andMarketLiquidityIsNotNull() {
			addCriterion("market_liquidity is not null");
			return (Criteria) this;
		}

		public Criteria andMarketLiquidityEqualTo(Integer value) {
			addCriterion("market_liquidity =", value, "marketLiquidity");
			return (Criteria) this;
		}

		public Criteria andMarketLiquidityNotEqualTo(Integer value) {
			addCriterion("market_liquidity <>", value, "marketLiquidity");
			return (Criteria) this;
		}

		public Criteria andMarketLiquidityGreaterThan(Integer value) {
			addCriterion("market_liquidity >", value, "marketLiquidity");
			return (Criteria) this;
		}

		public Criteria andMarketLiquidityGreaterThanOrEqualTo(Integer value) {
			addCriterion("market_liquidity >=", value, "marketLiquidity");
			return (Criteria) this;
		}

		public Criteria andMarketLiquidityLessThan(Integer value) {
			addCriterion("market_liquidity <", value, "marketLiquidity");
			return (Criteria) this;
		}

		public Criteria andMarketLiquidityLessThanOrEqualTo(Integer value) {
			addCriterion("market_liquidity <=", value, "marketLiquidity");
			return (Criteria) this;
		}

		public Criteria andMarketLiquidityIn(List<Integer> values) {
			addCriterion("market_liquidity in", values, "marketLiquidity");
			return (Criteria) this;
		}

		public Criteria andMarketLiquidityNotIn(List<Integer> values) {
			addCriterion("market_liquidity not in", values, "marketLiquidity");
			return (Criteria) this;
		}

		public Criteria andMarketLiquidityBetween(Integer value1, Integer value2) {
			addCriterion("market_liquidity between", value1, value2, "marketLiquidity");
			return (Criteria) this;
		}

		public Criteria andMarketLiquidityNotBetween(Integer value1, Integer value2) {
			addCriterion("market_liquidity not between", value1, value2, "marketLiquidity");
			return (Criteria) this;
		}

		public Criteria andValueStabilityIsNull() {
			addCriterion("value_stability is null");
			return (Criteria) this;
		}

		public Criteria andValueStabilityIsNotNull() {
			addCriterion("value_stability is not null");
			return (Criteria) this;
		}

		public Criteria andValueStabilityEqualTo(Integer value) {
			addCriterion("value_stability =", value, "valueStability");
			return (Criteria) this;
		}

		public Criteria andValueStabilityNotEqualTo(Integer value) {
			addCriterion("value_stability <>", value, "valueStability");
			return (Criteria) this;
		}

		public Criteria andValueStabilityGreaterThan(Integer value) {
			addCriterion("value_stability >", value, "valueStability");
			return (Criteria) this;
		}

		public Criteria andValueStabilityGreaterThanOrEqualTo(Integer value) {
			addCriterion("value_stability >=", value, "valueStability");
			return (Criteria) this;
		}

		public Criteria andValueStabilityLessThan(Integer value) {
			addCriterion("value_stability <", value, "valueStability");
			return (Criteria) this;
		}

		public Criteria andValueStabilityLessThanOrEqualTo(Integer value) {
			addCriterion("value_stability <=", value, "valueStability");
			return (Criteria) this;
		}

		public Criteria andValueStabilityIn(List<Integer> values) {
			addCriterion("value_stability in", values, "valueStability");
			return (Criteria) this;
		}

		public Criteria andValueStabilityNotIn(List<Integer> values) {
			addCriterion("value_stability not in", values, "valueStability");
			return (Criteria) this;
		}

		public Criteria andValueStabilityBetween(Integer value1, Integer value2) {
			addCriterion("value_stability between", value1, value2, "valueStability");
			return (Criteria) this;
		}

		public Criteria andValueStabilityNotBetween(Integer value1, Integer value2) {
			addCriterion("value_stability not between", value1, value2, "valueStability");
			return (Criteria) this;
		}

		public Criteria andMaterialVulnerabilityIsNull() {
			addCriterion("material_vulnerability is null");
			return (Criteria) this;
		}

		public Criteria andMaterialVulnerabilityIsNotNull() {
			addCriterion("material_vulnerability is not null");
			return (Criteria) this;
		}

		public Criteria andMaterialVulnerabilityEqualTo(Integer value) {
			addCriterion("material_vulnerability =", value, "materialVulnerability");
			return (Criteria) this;
		}

		public Criteria andMaterialVulnerabilityNotEqualTo(Integer value) {
			addCriterion("material_vulnerability <>", value, "materialVulnerability");
			return (Criteria) this;
		}

		public Criteria andMaterialVulnerabilityGreaterThan(Integer value) {
			addCriterion("material_vulnerability >", value, "materialVulnerability");
			return (Criteria) this;
		}

		public Criteria andMaterialVulnerabilityGreaterThanOrEqualTo(Integer value) {
			addCriterion("material_vulnerability >=", value, "materialVulnerability");
			return (Criteria) this;
		}

		public Criteria andMaterialVulnerabilityLessThan(Integer value) {
			addCriterion("material_vulnerability <", value, "materialVulnerability");
			return (Criteria) this;
		}

		public Criteria andMaterialVulnerabilityLessThanOrEqualTo(Integer value) {
			addCriterion("material_vulnerability <=", value, "materialVulnerability");
			return (Criteria) this;
		}

		public Criteria andMaterialVulnerabilityIn(List<Integer> values) {
			addCriterion("material_vulnerability in", values, "materialVulnerability");
			return (Criteria) this;
		}

		public Criteria andMaterialVulnerabilityNotIn(List<Integer> values) {
			addCriterion("material_vulnerability not in", values, "materialVulnerability");
			return (Criteria) this;
		}

		public Criteria andMaterialVulnerabilityBetween(Integer value1, Integer value2) {
			addCriterion("material_vulnerability between", value1, value2, "materialVulnerability");
			return (Criteria) this;
		}

		public Criteria andMaterialVulnerabilityNotBetween(Integer value1, Integer value2) {
			addCriterion("material_vulnerability not between", value1, value2, "materialVulnerability");
			return (Criteria) this;
		}

		public Criteria andStorageConditionIsNull() {
			addCriterion("storage_condition is null");
			return (Criteria) this;
		}

		public Criteria andStorageConditionIsNotNull() {
			addCriterion("storage_condition is not null");
			return (Criteria) this;
		}

		public Criteria andStorageConditionEqualTo(String value) {
			addCriterion("storage_condition =", value, "storageCondition");
			return (Criteria) this;
		}

		public Criteria andStorageConditionNotEqualTo(String value) {
			addCriterion("storage_condition <>", value, "storageCondition");
			return (Criteria) this;
		}

		public Criteria andStorageConditionGreaterThan(String value) {
			addCriterion("storage_condition >", value, "storageCondition");
			return (Criteria) this;
		}

		public Criteria andStorageConditionGreaterThanOrEqualTo(String value) {
			addCriterion("storage_condition >=", value, "storageCondition");
			return (Criteria) this;
		}

		public Criteria andStorageConditionLessThan(String value) {
			addCriterion("storage_condition <", value, "storageCondition");
			return (Criteria) this;
		}

		public Criteria andStorageConditionLessThanOrEqualTo(String value) {
			addCriterion("storage_condition <=", value, "storageCondition");
			return (Criteria) this;
		}

		public Criteria andStorageConditionLike(String value) {
			addCriterion("storage_condition like", value, "storageCondition");
			return (Criteria) this;
		}

		public Criteria andStorageConditionNotLike(String value) {
			addCriterion("storage_condition not like", value, "storageCondition");
			return (Criteria) this;
		}

		public Criteria andStorageConditionIn(List<String> values) {
			addCriterion("storage_condition in", values, "storageCondition");
			return (Criteria) this;
		}

		public Criteria andStorageConditionNotIn(List<String> values) {
			addCriterion("storage_condition not in", values, "storageCondition");
			return (Criteria) this;
		}

		public Criteria andStorageConditionBetween(String value1, String value2) {
			addCriterion("storage_condition between", value1, value2, "storageCondition");
			return (Criteria) this;
		}

		public Criteria andStorageConditionNotBetween(String value1, String value2) {
			addCriterion("storage_condition not between", value1, value2, "storageCondition");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectIsNull() {
			addCriterion("naked_eye_defect is null");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectIsNotNull() {
			addCriterion("naked_eye_defect is not null");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectEqualTo(String value) {
			addCriterion("naked_eye_defect =", value, "nakedEyeDefect");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectNotEqualTo(String value) {
			addCriterion("naked_eye_defect <>", value, "nakedEyeDefect");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectGreaterThan(String value) {
			addCriterion("naked_eye_defect >", value, "nakedEyeDefect");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectGreaterThanOrEqualTo(String value) {
			addCriterion("naked_eye_defect >=", value, "nakedEyeDefect");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectLessThan(String value) {
			addCriterion("naked_eye_defect <", value, "nakedEyeDefect");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectLessThanOrEqualTo(String value) {
			addCriterion("naked_eye_defect <=", value, "nakedEyeDefect");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectLike(String value) {
			addCriterion("naked_eye_defect like", value, "nakedEyeDefect");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectNotLike(String value) {
			addCriterion("naked_eye_defect not like", value, "nakedEyeDefect");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectIn(List<String> values) {
			addCriterion("naked_eye_defect in", values, "nakedEyeDefect");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectNotIn(List<String> values) {
			addCriterion("naked_eye_defect not in", values, "nakedEyeDefect");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectBetween(String value1, String value2) {
			addCriterion("naked_eye_defect between", value1, value2, "nakedEyeDefect");
			return (Criteria) this;
		}

		public Criteria andNakedEyeDefectNotBetween(String value1, String value2) {
			addCriterion("naked_eye_defect not between", value1, value2, "nakedEyeDefect");
			return (Criteria) this;
		}

		public Criteria andFinanceLogIsNull() {
			addCriterion("finance_log is null");
			return (Criteria) this;
		}

		public Criteria andFinanceLogIsNotNull() {
			addCriterion("finance_log is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceLogEqualTo(String value) {
			addCriterion("finance_log =", value, "financeLog");
			return (Criteria) this;
		}

		public Criteria andFinanceLogNotEqualTo(String value) {
			addCriterion("finance_log <>", value, "financeLog");
			return (Criteria) this;
		}

		public Criteria andFinanceLogGreaterThan(String value) {
			addCriterion("finance_log >", value, "financeLog");
			return (Criteria) this;
		}

		public Criteria andFinanceLogGreaterThanOrEqualTo(String value) {
			addCriterion("finance_log >=", value, "financeLog");
			return (Criteria) this;
		}

		public Criteria andFinanceLogLessThan(String value) {
			addCriterion("finance_log <", value, "financeLog");
			return (Criteria) this;
		}

		public Criteria andFinanceLogLessThanOrEqualTo(String value) {
			addCriterion("finance_log <=", value, "financeLog");
			return (Criteria) this;
		}

		public Criteria andFinanceLogLike(String value) {
			addCriterion("finance_log like", value, "financeLog");
			return (Criteria) this;
		}

		public Criteria andFinanceLogNotLike(String value) {
			addCriterion("finance_log not like", value, "financeLog");
			return (Criteria) this;
		}

		public Criteria andFinanceLogIn(List<String> values) {
			addCriterion("finance_log in", values, "financeLog");
			return (Criteria) this;
		}

		public Criteria andFinanceLogNotIn(List<String> values) {
			addCriterion("finance_log not in", values, "financeLog");
			return (Criteria) this;
		}

		public Criteria andFinanceLogBetween(String value1, String value2) {
			addCriterion("finance_log between", value1, value2, "financeLog");
			return (Criteria) this;
		}

		public Criteria andFinanceLogNotBetween(String value1, String value2) {
			addCriterion("finance_log not between", value1, value2, "financeLog");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessIsNull() {
			addCriterion("other_business is null");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessIsNotNull() {
			addCriterion("other_business is not null");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessEqualTo(String value) {
			addCriterion("other_business =", value, "otherBusiness");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessNotEqualTo(String value) {
			addCriterion("other_business <>", value, "otherBusiness");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessGreaterThan(String value) {
			addCriterion("other_business >", value, "otherBusiness");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessGreaterThanOrEqualTo(String value) {
			addCriterion("other_business >=", value, "otherBusiness");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessLessThan(String value) {
			addCriterion("other_business <", value, "otherBusiness");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessLessThanOrEqualTo(String value) {
			addCriterion("other_business <=", value, "otherBusiness");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessLike(String value) {
			addCriterion("other_business like", value, "otherBusiness");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessNotLike(String value) {
			addCriterion("other_business not like", value, "otherBusiness");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessIn(List<String> values) {
			addCriterion("other_business in", values, "otherBusiness");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessNotIn(List<String> values) {
			addCriterion("other_business not in", values, "otherBusiness");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessBetween(String value1, String value2) {
			addCriterion("other_business between", value1, value2, "otherBusiness");
			return (Criteria) this;
		}

		public Criteria andOtherBusinessNotBetween(String value1, String value2) {
			addCriterion("other_business not between", value1, value2, "otherBusiness");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(java.util.Date value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(java.util.Date value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(java.util.Date value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(java.util.Date value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<java.util.Date> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<java.util.Date> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIsNull() {
			addCriterion("modify_time is null");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIsNotNull() {
			addCriterion("modify_time is not null");
			return (Criteria) this;
		}

		public Criteria andModifyTimeEqualTo(java.util.Date value) {
			addCriterion("modify_time =", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotEqualTo(java.util.Date value) {
			addCriterion("modify_time <>", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeGreaterThan(java.util.Date value) {
			addCriterion("modify_time >", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("modify_time >=", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeLessThan(java.util.Date value) {
			addCriterion("modify_time <", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("modify_time <=", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIn(List<java.util.Date> values) {
			addCriterion("modify_time in", values, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotIn(List<java.util.Date> values) {
			addCriterion("modify_time not in", values, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("modify_time between", value1, value2, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("modify_time not between", value1, value2, "modifyTime");
			return (Criteria) this;
		}

}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
		return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}