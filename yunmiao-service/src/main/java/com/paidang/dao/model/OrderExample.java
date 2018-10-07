package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class OrderExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderExample(){
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

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Integer value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Integer value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Integer value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Integer value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Integer> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Integer> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Integer value1, Integer value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIsNull() {
			addCriterion("goods_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIsNotNull() {
			addCriterion("goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdEqualTo(Integer value) {
			addCriterion("goods_id =", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotEqualTo(Integer value) {
			addCriterion("goods_id <>", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThan(Integer value) {
			addCriterion("goods_id >", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_id >=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThan(Integer value) {
			addCriterion("goods_id <", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
			addCriterion("goods_id <=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIn(List<Integer> values) {
			addCriterion("goods_id in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotIn(List<Integer> values) {
			addCriterion("goods_id not in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
			addCriterion("goods_id between", value1, value2, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_id not between", value1, value2, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIsNull() {
			addCriterion("goods_name is null");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIsNotNull() {
			addCriterion("goods_name is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsNameEqualTo(String value) {
			addCriterion("goods_name =", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotEqualTo(String value) {
			addCriterion("goods_name <>", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameGreaterThan(String value) {
			addCriterion("goods_name >", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
			addCriterion("goods_name >=", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLessThan(String value) {
			addCriterion("goods_name <", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLessThanOrEqualTo(String value) {
			addCriterion("goods_name <=", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLike(String value) {
			addCriterion("goods_name like", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotLike(String value) {
			addCriterion("goods_name not like", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIn(List<String> values) {
			addCriterion("goods_name in", values, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotIn(List<String> values) {
			addCriterion("goods_name not in", values, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameBetween(String value1, String value2) {
			addCriterion("goods_name between", value1, value2, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotBetween(String value1, String value2) {
			addCriterion("goods_name not between", value1, value2, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsImgIsNull() {
			addCriterion("goods_img is null");
			return (Criteria) this;
		}

		public Criteria andGoodsImgIsNotNull() {
			addCriterion("goods_img is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsImgEqualTo(String value) {
			addCriterion("goods_img =", value, "goodsImg");
			return (Criteria) this;
		}

		public Criteria andGoodsImgNotEqualTo(String value) {
			addCriterion("goods_img <>", value, "goodsImg");
			return (Criteria) this;
		}

		public Criteria andGoodsImgGreaterThan(String value) {
			addCriterion("goods_img >", value, "goodsImg");
			return (Criteria) this;
		}

		public Criteria andGoodsImgGreaterThanOrEqualTo(String value) {
			addCriterion("goods_img >=", value, "goodsImg");
			return (Criteria) this;
		}

		public Criteria andGoodsImgLessThan(String value) {
			addCriterion("goods_img <", value, "goodsImg");
			return (Criteria) this;
		}

		public Criteria andGoodsImgLessThanOrEqualTo(String value) {
			addCriterion("goods_img <=", value, "goodsImg");
			return (Criteria) this;
		}

		public Criteria andGoodsImgLike(String value) {
			addCriterion("goods_img like", value, "goodsImg");
			return (Criteria) this;
		}

		public Criteria andGoodsImgNotLike(String value) {
			addCriterion("goods_img not like", value, "goodsImg");
			return (Criteria) this;
		}

		public Criteria andGoodsImgIn(List<String> values) {
			addCriterion("goods_img in", values, "goodsImg");
			return (Criteria) this;
		}

		public Criteria andGoodsImgNotIn(List<String> values) {
			addCriterion("goods_img not in", values, "goodsImg");
			return (Criteria) this;
		}

		public Criteria andGoodsImgBetween(String value1, String value2) {
			addCriterion("goods_img between", value1, value2, "goodsImg");
			return (Criteria) this;
		}

		public Criteria andGoodsImgNotBetween(String value1, String value2) {
			addCriterion("goods_img not between", value1, value2, "goodsImg");
			return (Criteria) this;
		}

		public Criteria andGoodsSourceIsNull() {
			addCriterion("goods_source is null");
			return (Criteria) this;
		}

		public Criteria andGoodsSourceIsNotNull() {
			addCriterion("goods_source is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsSourceEqualTo(Integer value) {
			addCriterion("goods_source =", value, "goodsSource");
			return (Criteria) this;
		}

		public Criteria andGoodsSourceNotEqualTo(Integer value) {
			addCriterion("goods_source <>", value, "goodsSource");
			return (Criteria) this;
		}

		public Criteria andGoodsSourceGreaterThan(Integer value) {
			addCriterion("goods_source >", value, "goodsSource");
			return (Criteria) this;
		}

		public Criteria andGoodsSourceGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_source >=", value, "goodsSource");
			return (Criteria) this;
		}

		public Criteria andGoodsSourceLessThan(Integer value) {
			addCriterion("goods_source <", value, "goodsSource");
			return (Criteria) this;
		}

		public Criteria andGoodsSourceLessThanOrEqualTo(Integer value) {
			addCriterion("goods_source <=", value, "goodsSource");
			return (Criteria) this;
		}

		public Criteria andGoodsSourceIn(List<Integer> values) {
			addCriterion("goods_source in", values, "goodsSource");
			return (Criteria) this;
		}

		public Criteria andGoodsSourceNotIn(List<Integer> values) {
			addCriterion("goods_source not in", values, "goodsSource");
			return (Criteria) this;
		}

		public Criteria andGoodsSourceBetween(Integer value1, Integer value2) {
			addCriterion("goods_source between", value1, value2, "goodsSource");
			return (Criteria) this;
		}

		public Criteria andGoodsSourceNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_source not between", value1, value2, "goodsSource");
			return (Criteria) this;
		}

		public Criteria andOrgIdIsNull() {
			addCriterion("org_id is null");
			return (Criteria) this;
		}

		public Criteria andOrgIdIsNotNull() {
			addCriterion("org_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrgIdEqualTo(Integer value) {
			addCriterion("org_id =", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdNotEqualTo(Integer value) {
			addCriterion("org_id <>", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdGreaterThan(Integer value) {
			addCriterion("org_id >", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("org_id >=", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdLessThan(Integer value) {
			addCriterion("org_id <", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
			addCriterion("org_id <=", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdIn(List<Integer> values) {
			addCriterion("org_id in", values, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdNotIn(List<Integer> values) {
			addCriterion("org_id not in", values, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdBetween(Integer value1, Integer value2) {
			addCriterion("org_id between", value1, value2, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
			addCriterion("org_id not between", value1, value2, "orgId");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIsNull() {
			addCriterion("goods_price is null");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIsNotNull() {
			addCriterion("goods_price is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceEqualTo(java.math.BigDecimal value) {
			addCriterion("goods_price =", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotEqualTo(java.math.BigDecimal value) {
			addCriterion("goods_price <>", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThan(java.math.BigDecimal value) {
			addCriterion("goods_price >", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("goods_price >=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThan(java.math.BigDecimal value) {
			addCriterion("goods_price <", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("goods_price <=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIn(List<java.math.BigDecimal> values) {
			addCriterion("goods_price in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotIn(List<java.math.BigDecimal> values) {
			addCriterion("goods_price not in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("goods_price between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("goods_price not between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsCostIsNull() {
			addCriterion("goods_cost is null");
			return (Criteria) this;
		}

		public Criteria andGoodsCostIsNotNull() {
			addCriterion("goods_cost is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsCostEqualTo(java.math.BigDecimal value) {
			addCriterion("goods_cost =", value, "goodsCost");
			return (Criteria) this;
		}

		public Criteria andGoodsCostNotEqualTo(java.math.BigDecimal value) {
			addCriterion("goods_cost <>", value, "goodsCost");
			return (Criteria) this;
		}

		public Criteria andGoodsCostGreaterThan(java.math.BigDecimal value) {
			addCriterion("goods_cost >", value, "goodsCost");
			return (Criteria) this;
		}

		public Criteria andGoodsCostGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("goods_cost >=", value, "goodsCost");
			return (Criteria) this;
		}

		public Criteria andGoodsCostLessThan(java.math.BigDecimal value) {
			addCriterion("goods_cost <", value, "goodsCost");
			return (Criteria) this;
		}

		public Criteria andGoodsCostLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("goods_cost <=", value, "goodsCost");
			return (Criteria) this;
		}

		public Criteria andGoodsCostIn(List<java.math.BigDecimal> values) {
			addCriterion("goods_cost in", values, "goodsCost");
			return (Criteria) this;
		}

		public Criteria andGoodsCostNotIn(List<java.math.BigDecimal> values) {
			addCriterion("goods_cost not in", values, "goodsCost");
			return (Criteria) this;
		}

		public Criteria andGoodsCostBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("goods_cost between", value1, value2, "goodsCost");
			return (Criteria) this;
		}

		public Criteria andGoodsCostNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("goods_cost not between", value1, value2, "goodsCost");
			return (Criteria) this;
		}

		public Criteria andPriceIsNull() {
			addCriterion("price is null");
			return (Criteria) this;
		}

		public Criteria andPriceIsNotNull() {
			addCriterion("price is not null");
			return (Criteria) this;
		}

		public Criteria andPriceEqualTo(java.math.BigDecimal value) {
			addCriterion("price =", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotEqualTo(java.math.BigDecimal value) {
			addCriterion("price <>", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThan(java.math.BigDecimal value) {
			addCriterion("price >", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("price >=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThan(java.math.BigDecimal value) {
			addCriterion("price <", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("price <=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceIn(List<java.math.BigDecimal> values) {
			addCriterion("price in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotIn(List<java.math.BigDecimal> values) {
			addCriterion("price not in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("price between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("price not between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andVideoIsNull() {
			addCriterion("video is null");
			return (Criteria) this;
		}

		public Criteria andVideoIsNotNull() {
			addCriterion("video is not null");
			return (Criteria) this;
		}

		public Criteria andVideoEqualTo(String value) {
			addCriterion("video =", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoNotEqualTo(String value) {
			addCriterion("video <>", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoGreaterThan(String value) {
			addCriterion("video >", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoGreaterThanOrEqualTo(String value) {
			addCriterion("video >=", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoLessThan(String value) {
			addCriterion("video <", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoLessThanOrEqualTo(String value) {
			addCriterion("video <=", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoLike(String value) {
			addCriterion("video like", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoNotLike(String value) {
			addCriterion("video not like", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoIn(List<String> values) {
			addCriterion("video in", values, "video");
			return (Criteria) this;
		}

		public Criteria andVideoNotIn(List<String> values) {
			addCriterion("video not in", values, "video");
			return (Criteria) this;
		}

		public Criteria andVideoBetween(String value1, String value2) {
			addCriterion("video between", value1, value2, "video");
			return (Criteria) this;
		}

		public Criteria andVideoNotBetween(String value1, String value2) {
			addCriterion("video not between", value1, value2, "video");
			return (Criteria) this;
		}

		public Criteria andStateIsNull() {
			addCriterion("state is null");
			return (Criteria) this;
		}

		public Criteria andStateIsNotNull() {
			addCriterion("state is not null");
			return (Criteria) this;
		}

		public Criteria andStateEqualTo(Integer value) {
			addCriterion("state =", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotEqualTo(Integer value) {
			addCriterion("state <>", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThan(Integer value) {
			addCriterion("state >", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("state >=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThan(Integer value) {
			addCriterion("state <", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThanOrEqualTo(Integer value) {
			addCriterion("state <=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateIn(List<Integer> values) {
			addCriterion("state in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotIn(List<Integer> values) {
			addCriterion("state not in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateBetween(Integer value1, Integer value2) {
			addCriterion("state between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotBetween(Integer value1, Integer value2) {
			addCriterion("state not between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andRefStateIsNull() {
			addCriterion("ref_state is null");
			return (Criteria) this;
		}

		public Criteria andRefStateIsNotNull() {
			addCriterion("ref_state is not null");
			return (Criteria) this;
		}

		public Criteria andRefStateEqualTo(Integer value) {
			addCriterion("ref_state =", value, "refState");
			return (Criteria) this;
		}

		public Criteria andRefStateNotEqualTo(Integer value) {
			addCriterion("ref_state <>", value, "refState");
			return (Criteria) this;
		}

		public Criteria andRefStateGreaterThan(Integer value) {
			addCriterion("ref_state >", value, "refState");
			return (Criteria) this;
		}

		public Criteria andRefStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("ref_state >=", value, "refState");
			return (Criteria) this;
		}

		public Criteria andRefStateLessThan(Integer value) {
			addCriterion("ref_state <", value, "refState");
			return (Criteria) this;
		}

		public Criteria andRefStateLessThanOrEqualTo(Integer value) {
			addCriterion("ref_state <=", value, "refState");
			return (Criteria) this;
		}

		public Criteria andRefStateIn(List<Integer> values) {
			addCriterion("ref_state in", values, "refState");
			return (Criteria) this;
		}

		public Criteria andRefStateNotIn(List<Integer> values) {
			addCriterion("ref_state not in", values, "refState");
			return (Criteria) this;
		}

		public Criteria andRefStateBetween(Integer value1, Integer value2) {
			addCriterion("ref_state between", value1, value2, "refState");
			return (Criteria) this;
		}

		public Criteria andRefStateNotBetween(Integer value1, Integer value2) {
			addCriterion("ref_state not between", value1, value2, "refState");
			return (Criteria) this;
		}

		public Criteria andPayLogIdIsNull() {
			addCriterion("pay_log_id is null");
			return (Criteria) this;
		}

		public Criteria andPayLogIdIsNotNull() {
			addCriterion("pay_log_id is not null");
			return (Criteria) this;
		}

		public Criteria andPayLogIdEqualTo(Integer value) {
			addCriterion("pay_log_id =", value, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdNotEqualTo(Integer value) {
			addCriterion("pay_log_id <>", value, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdGreaterThan(Integer value) {
			addCriterion("pay_log_id >", value, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("pay_log_id >=", value, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdLessThan(Integer value) {
			addCriterion("pay_log_id <", value, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdLessThanOrEqualTo(Integer value) {
			addCriterion("pay_log_id <=", value, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdIn(List<Integer> values) {
			addCriterion("pay_log_id in", values, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdNotIn(List<Integer> values) {
			addCriterion("pay_log_id not in", values, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdBetween(Integer value1, Integer value2) {
			addCriterion("pay_log_id between", value1, value2, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdNotBetween(Integer value1, Integer value2) {
			addCriterion("pay_log_id not between", value1, value2, "payLogId");
			return (Criteria) this;
		}

		public Criteria andIsBalanceIsNull() {
			addCriterion("is_balance is null");
			return (Criteria) this;
		}

		public Criteria andIsBalanceIsNotNull() {
			addCriterion("is_balance is not null");
			return (Criteria) this;
		}

		public Criteria andIsBalanceEqualTo(Integer value) {
			addCriterion("is_balance =", value, "isBalance");
			return (Criteria) this;
		}

		public Criteria andIsBalanceNotEqualTo(Integer value) {
			addCriterion("is_balance <>", value, "isBalance");
			return (Criteria) this;
		}

		public Criteria andIsBalanceGreaterThan(Integer value) {
			addCriterion("is_balance >", value, "isBalance");
			return (Criteria) this;
		}

		public Criteria andIsBalanceGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_balance >=", value, "isBalance");
			return (Criteria) this;
		}

		public Criteria andIsBalanceLessThan(Integer value) {
			addCriterion("is_balance <", value, "isBalance");
			return (Criteria) this;
		}

		public Criteria andIsBalanceLessThanOrEqualTo(Integer value) {
			addCriterion("is_balance <=", value, "isBalance");
			return (Criteria) this;
		}

		public Criteria andIsBalanceIn(List<Integer> values) {
			addCriterion("is_balance in", values, "isBalance");
			return (Criteria) this;
		}

		public Criteria andIsBalanceNotIn(List<Integer> values) {
			addCriterion("is_balance not in", values, "isBalance");
			return (Criteria) this;
		}

		public Criteria andIsBalanceBetween(Integer value1, Integer value2) {
			addCriterion("is_balance between", value1, value2, "isBalance");
			return (Criteria) this;
		}

		public Criteria andIsBalanceNotBetween(Integer value1, Integer value2) {
			addCriterion("is_balance not between", value1, value2, "isBalance");
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

		public Criteria andBalanceTimeIsNull() {
			addCriterion("balance_time is null");
			return (Criteria) this;
		}

		public Criteria andBalanceTimeIsNotNull() {
			addCriterion("balance_time is not null");
			return (Criteria) this;
		}

		public Criteria andBalanceTimeEqualTo(java.util.Date value) {
			addCriterion("balance_time =", value, "balanceTime");
			return (Criteria) this;
		}

		public Criteria andBalanceTimeNotEqualTo(java.util.Date value) {
			addCriterion("balance_time <>", value, "balanceTime");
			return (Criteria) this;
		}

		public Criteria andBalanceTimeGreaterThan(java.util.Date value) {
			addCriterion("balance_time >", value, "balanceTime");
			return (Criteria) this;
		}

		public Criteria andBalanceTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("balance_time >=", value, "balanceTime");
			return (Criteria) this;
		}

		public Criteria andBalanceTimeLessThan(java.util.Date value) {
			addCriterion("balance_time <", value, "balanceTime");
			return (Criteria) this;
		}

		public Criteria andBalanceTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("balance_time <=", value, "balanceTime");
			return (Criteria) this;
		}

		public Criteria andBalanceTimeIn(List<java.util.Date> values) {
			addCriterion("balance_time in", values, "balanceTime");
			return (Criteria) this;
		}

		public Criteria andBalanceTimeNotIn(List<java.util.Date> values) {
			addCriterion("balance_time not in", values, "balanceTime");
			return (Criteria) this;
		}

		public Criteria andBalanceTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("balance_time between", value1, value2, "balanceTime");
			return (Criteria) this;
		}

		public Criteria andBalanceTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("balance_time not between", value1, value2, "balanceTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeIsNull() {
			addCriterion("pay_time is null");
			return (Criteria) this;
		}

		public Criteria andPayTimeIsNotNull() {
			addCriterion("pay_time is not null");
			return (Criteria) this;
		}

		public Criteria andPayTimeEqualTo(java.util.Date value) {
			addCriterion("pay_time =", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeNotEqualTo(java.util.Date value) {
			addCriterion("pay_time <>", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeGreaterThan(java.util.Date value) {
			addCriterion("pay_time >", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("pay_time >=", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeLessThan(java.util.Date value) {
			addCriterion("pay_time <", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("pay_time <=", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeIn(List<java.util.Date> values) {
			addCriterion("pay_time in", values, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeNotIn(List<java.util.Date> values) {
			addCriterion("pay_time not in", values, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("pay_time between", value1, value2, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("pay_time not between", value1, value2, "payTime");
			return (Criteria) this;
		}

		public Criteria andShipUserIsNull() {
			addCriterion("ship_user is null");
			return (Criteria) this;
		}

		public Criteria andShipUserIsNotNull() {
			addCriterion("ship_user is not null");
			return (Criteria) this;
		}

		public Criteria andShipUserEqualTo(String value) {
			addCriterion("ship_user =", value, "shipUser");
			return (Criteria) this;
		}

		public Criteria andShipUserNotEqualTo(String value) {
			addCriterion("ship_user <>", value, "shipUser");
			return (Criteria) this;
		}

		public Criteria andShipUserGreaterThan(String value) {
			addCriterion("ship_user >", value, "shipUser");
			return (Criteria) this;
		}

		public Criteria andShipUserGreaterThanOrEqualTo(String value) {
			addCriterion("ship_user >=", value, "shipUser");
			return (Criteria) this;
		}

		public Criteria andShipUserLessThan(String value) {
			addCriterion("ship_user <", value, "shipUser");
			return (Criteria) this;
		}

		public Criteria andShipUserLessThanOrEqualTo(String value) {
			addCriterion("ship_user <=", value, "shipUser");
			return (Criteria) this;
		}

		public Criteria andShipUserLike(String value) {
			addCriterion("ship_user like", value, "shipUser");
			return (Criteria) this;
		}

		public Criteria andShipUserNotLike(String value) {
			addCriterion("ship_user not like", value, "shipUser");
			return (Criteria) this;
		}

		public Criteria andShipUserIn(List<String> values) {
			addCriterion("ship_user in", values, "shipUser");
			return (Criteria) this;
		}

		public Criteria andShipUserNotIn(List<String> values) {
			addCriterion("ship_user not in", values, "shipUser");
			return (Criteria) this;
		}

		public Criteria andShipUserBetween(String value1, String value2) {
			addCriterion("ship_user between", value1, value2, "shipUser");
			return (Criteria) this;
		}

		public Criteria andShipUserNotBetween(String value1, String value2) {
			addCriterion("ship_user not between", value1, value2, "shipUser");
			return (Criteria) this;
		}

		public Criteria andShipFirmIsNull() {
			addCriterion("ship_firm is null");
			return (Criteria) this;
		}

		public Criteria andShipFirmIsNotNull() {
			addCriterion("ship_firm is not null");
			return (Criteria) this;
		}

		public Criteria andShipFirmEqualTo(String value) {
			addCriterion("ship_firm =", value, "shipFirm");
			return (Criteria) this;
		}

		public Criteria andShipFirmNotEqualTo(String value) {
			addCriterion("ship_firm <>", value, "shipFirm");
			return (Criteria) this;
		}

		public Criteria andShipFirmGreaterThan(String value) {
			addCriterion("ship_firm >", value, "shipFirm");
			return (Criteria) this;
		}

		public Criteria andShipFirmGreaterThanOrEqualTo(String value) {
			addCriterion("ship_firm >=", value, "shipFirm");
			return (Criteria) this;
		}

		public Criteria andShipFirmLessThan(String value) {
			addCriterion("ship_firm <", value, "shipFirm");
			return (Criteria) this;
		}

		public Criteria andShipFirmLessThanOrEqualTo(String value) {
			addCriterion("ship_firm <=", value, "shipFirm");
			return (Criteria) this;
		}

		public Criteria andShipFirmLike(String value) {
			addCriterion("ship_firm like", value, "shipFirm");
			return (Criteria) this;
		}

		public Criteria andShipFirmNotLike(String value) {
			addCriterion("ship_firm not like", value, "shipFirm");
			return (Criteria) this;
		}

		public Criteria andShipFirmIn(List<String> values) {
			addCriterion("ship_firm in", values, "shipFirm");
			return (Criteria) this;
		}

		public Criteria andShipFirmNotIn(List<String> values) {
			addCriterion("ship_firm not in", values, "shipFirm");
			return (Criteria) this;
		}

		public Criteria andShipFirmBetween(String value1, String value2) {
			addCriterion("ship_firm between", value1, value2, "shipFirm");
			return (Criteria) this;
		}

		public Criteria andShipFirmNotBetween(String value1, String value2) {
			addCriterion("ship_firm not between", value1, value2, "shipFirm");
			return (Criteria) this;
		}

		public Criteria andShipCodeIsNull() {
			addCriterion("ship_code is null");
			return (Criteria) this;
		}

		public Criteria andShipCodeIsNotNull() {
			addCriterion("ship_code is not null");
			return (Criteria) this;
		}

		public Criteria andShipCodeEqualTo(String value) {
			addCriterion("ship_code =", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeNotEqualTo(String value) {
			addCriterion("ship_code <>", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeGreaterThan(String value) {
			addCriterion("ship_code >", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeGreaterThanOrEqualTo(String value) {
			addCriterion("ship_code >=", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeLessThan(String value) {
			addCriterion("ship_code <", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeLessThanOrEqualTo(String value) {
			addCriterion("ship_code <=", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeLike(String value) {
			addCriterion("ship_code like", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeNotLike(String value) {
			addCriterion("ship_code not like", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeIn(List<String> values) {
			addCriterion("ship_code in", values, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeNotIn(List<String> values) {
			addCriterion("ship_code not in", values, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeBetween(String value1, String value2) {
			addCriterion("ship_code between", value1, value2, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeNotBetween(String value1, String value2) {
			addCriterion("ship_code not between", value1, value2, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipAddressIsNull() {
			addCriterion("ship_address is null");
			return (Criteria) this;
		}

		public Criteria andShipAddressIsNotNull() {
			addCriterion("ship_address is not null");
			return (Criteria) this;
		}

		public Criteria andShipAddressEqualTo(String value) {
			addCriterion("ship_address =", value, "shipAddress");
			return (Criteria) this;
		}

		public Criteria andShipAddressNotEqualTo(String value) {
			addCriterion("ship_address <>", value, "shipAddress");
			return (Criteria) this;
		}

		public Criteria andShipAddressGreaterThan(String value) {
			addCriterion("ship_address >", value, "shipAddress");
			return (Criteria) this;
		}

		public Criteria andShipAddressGreaterThanOrEqualTo(String value) {
			addCriterion("ship_address >=", value, "shipAddress");
			return (Criteria) this;
		}

		public Criteria andShipAddressLessThan(String value) {
			addCriterion("ship_address <", value, "shipAddress");
			return (Criteria) this;
		}

		public Criteria andShipAddressLessThanOrEqualTo(String value) {
			addCriterion("ship_address <=", value, "shipAddress");
			return (Criteria) this;
		}

		public Criteria andShipAddressLike(String value) {
			addCriterion("ship_address like", value, "shipAddress");
			return (Criteria) this;
		}

		public Criteria andShipAddressNotLike(String value) {
			addCriterion("ship_address not like", value, "shipAddress");
			return (Criteria) this;
		}

		public Criteria andShipAddressIn(List<String> values) {
			addCriterion("ship_address in", values, "shipAddress");
			return (Criteria) this;
		}

		public Criteria andShipAddressNotIn(List<String> values) {
			addCriterion("ship_address not in", values, "shipAddress");
			return (Criteria) this;
		}

		public Criteria andShipAddressBetween(String value1, String value2) {
			addCriterion("ship_address between", value1, value2, "shipAddress");
			return (Criteria) this;
		}

		public Criteria andShipAddressNotBetween(String value1, String value2) {
			addCriterion("ship_address not between", value1, value2, "shipAddress");
			return (Criteria) this;
		}

		public Criteria andShipPhoneIsNull() {
			addCriterion("ship_phone is null");
			return (Criteria) this;
		}

		public Criteria andShipPhoneIsNotNull() {
			addCriterion("ship_phone is not null");
			return (Criteria) this;
		}

		public Criteria andShipPhoneEqualTo(String value) {
			addCriterion("ship_phone =", value, "shipPhone");
			return (Criteria) this;
		}

		public Criteria andShipPhoneNotEqualTo(String value) {
			addCriterion("ship_phone <>", value, "shipPhone");
			return (Criteria) this;
		}

		public Criteria andShipPhoneGreaterThan(String value) {
			addCriterion("ship_phone >", value, "shipPhone");
			return (Criteria) this;
		}

		public Criteria andShipPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("ship_phone >=", value, "shipPhone");
			return (Criteria) this;
		}

		public Criteria andShipPhoneLessThan(String value) {
			addCriterion("ship_phone <", value, "shipPhone");
			return (Criteria) this;
		}

		public Criteria andShipPhoneLessThanOrEqualTo(String value) {
			addCriterion("ship_phone <=", value, "shipPhone");
			return (Criteria) this;
		}

		public Criteria andShipPhoneLike(String value) {
			addCriterion("ship_phone like", value, "shipPhone");
			return (Criteria) this;
		}

		public Criteria andShipPhoneNotLike(String value) {
			addCriterion("ship_phone not like", value, "shipPhone");
			return (Criteria) this;
		}

		public Criteria andShipPhoneIn(List<String> values) {
			addCriterion("ship_phone in", values, "shipPhone");
			return (Criteria) this;
		}

		public Criteria andShipPhoneNotIn(List<String> values) {
			addCriterion("ship_phone not in", values, "shipPhone");
			return (Criteria) this;
		}

		public Criteria andShipPhoneBetween(String value1, String value2) {
			addCriterion("ship_phone between", value1, value2, "shipPhone");
			return (Criteria) this;
		}

		public Criteria andShipPhoneNotBetween(String value1, String value2) {
			addCriterion("ship_phone not between", value1, value2, "shipPhone");
			return (Criteria) this;
		}

		public Criteria andCouponIdIsNull() {
			addCriterion("coupon_id is null");
			return (Criteria) this;
		}

		public Criteria andCouponIdIsNotNull() {
			addCriterion("coupon_id is not null");
			return (Criteria) this;
		}

		public Criteria andCouponIdEqualTo(Integer value) {
			addCriterion("coupon_id =", value, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdNotEqualTo(Integer value) {
			addCriterion("coupon_id <>", value, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdGreaterThan(Integer value) {
			addCriterion("coupon_id >", value, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("coupon_id >=", value, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdLessThan(Integer value) {
			addCriterion("coupon_id <", value, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdLessThanOrEqualTo(Integer value) {
			addCriterion("coupon_id <=", value, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdIn(List<Integer> values) {
			addCriterion("coupon_id in", values, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdNotIn(List<Integer> values) {
			addCriterion("coupon_id not in", values, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdBetween(Integer value1, Integer value2) {
			addCriterion("coupon_id between", value1, value2, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdNotBetween(Integer value1, Integer value2) {
			addCriterion("coupon_id not between", value1, value2, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponValueIsNull() {
			addCriterion("coupon_value is null");
			return (Criteria) this;
		}

		public Criteria andCouponValueIsNotNull() {
			addCriterion("coupon_value is not null");
			return (Criteria) this;
		}

		public Criteria andCouponValueEqualTo(java.math.BigDecimal value) {
			addCriterion("coupon_value =", value, "couponValue");
			return (Criteria) this;
		}

		public Criteria andCouponValueNotEqualTo(java.math.BigDecimal value) {
			addCriterion("coupon_value <>", value, "couponValue");
			return (Criteria) this;
		}

		public Criteria andCouponValueGreaterThan(java.math.BigDecimal value) {
			addCriterion("coupon_value >", value, "couponValue");
			return (Criteria) this;
		}

		public Criteria andCouponValueGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("coupon_value >=", value, "couponValue");
			return (Criteria) this;
		}

		public Criteria andCouponValueLessThan(java.math.BigDecimal value) {
			addCriterion("coupon_value <", value, "couponValue");
			return (Criteria) this;
		}

		public Criteria andCouponValueLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("coupon_value <=", value, "couponValue");
			return (Criteria) this;
		}

		public Criteria andCouponValueIn(List<java.math.BigDecimal> values) {
			addCriterion("coupon_value in", values, "couponValue");
			return (Criteria) this;
		}

		public Criteria andCouponValueNotIn(List<java.math.BigDecimal> values) {
			addCriterion("coupon_value not in", values, "couponValue");
			return (Criteria) this;
		}

		public Criteria andCouponValueBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("coupon_value between", value1, value2, "couponValue");
			return (Criteria) this;
		}

		public Criteria andCouponValueNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("coupon_value not between", value1, value2, "couponValue");
			return (Criteria) this;
		}

		public Criteria andCouponInfoIsNull() {
			addCriterion("coupon_info is null");
			return (Criteria) this;
		}

		public Criteria andCouponInfoIsNotNull() {
			addCriterion("coupon_info is not null");
			return (Criteria) this;
		}

		public Criteria andCouponInfoEqualTo(String value) {
			addCriterion("coupon_info =", value, "couponInfo");
			return (Criteria) this;
		}

		public Criteria andCouponInfoNotEqualTo(String value) {
			addCriterion("coupon_info <>", value, "couponInfo");
			return (Criteria) this;
		}

		public Criteria andCouponInfoGreaterThan(String value) {
			addCriterion("coupon_info >", value, "couponInfo");
			return (Criteria) this;
		}

		public Criteria andCouponInfoGreaterThanOrEqualTo(String value) {
			addCriterion("coupon_info >=", value, "couponInfo");
			return (Criteria) this;
		}

		public Criteria andCouponInfoLessThan(String value) {
			addCriterion("coupon_info <", value, "couponInfo");
			return (Criteria) this;
		}

		public Criteria andCouponInfoLessThanOrEqualTo(String value) {
			addCriterion("coupon_info <=", value, "couponInfo");
			return (Criteria) this;
		}

		public Criteria andCouponInfoLike(String value) {
			addCriterion("coupon_info like", value, "couponInfo");
			return (Criteria) this;
		}

		public Criteria andCouponInfoNotLike(String value) {
			addCriterion("coupon_info not like", value, "couponInfo");
			return (Criteria) this;
		}

		public Criteria andCouponInfoIn(List<String> values) {
			addCriterion("coupon_info in", values, "couponInfo");
			return (Criteria) this;
		}

		public Criteria andCouponInfoNotIn(List<String> values) {
			addCriterion("coupon_info not in", values, "couponInfo");
			return (Criteria) this;
		}

		public Criteria andCouponInfoBetween(String value1, String value2) {
			addCriterion("coupon_info between", value1, value2, "couponInfo");
			return (Criteria) this;
		}

		public Criteria andCouponInfoNotBetween(String value1, String value2) {
			addCriterion("coupon_info not between", value1, value2, "couponInfo");
			return (Criteria) this;
		}

		public Criteria andIsDelIsNull() {
			addCriterion("is_del is null");
			return (Criteria) this;
		}

		public Criteria andIsDelIsNotNull() {
			addCriterion("is_del is not null");
			return (Criteria) this;
		}

		public Criteria andIsDelEqualTo(Integer value) {
			addCriterion("is_del =", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotEqualTo(Integer value) {
			addCriterion("is_del <>", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThan(Integer value) {
			addCriterion("is_del >", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_del >=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThan(Integer value) {
			addCriterion("is_del <", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThanOrEqualTo(Integer value) {
			addCriterion("is_del <=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelIn(List<Integer> values) {
			addCriterion("is_del in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotIn(List<Integer> values) {
			addCriterion("is_del not in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelBetween(Integer value1, Integer value2) {
			addCriterion("is_del between", value1, value2, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
			addCriterion("is_del not between", value1, value2, "isDel");
			return (Criteria) this;
		}

		public Criteria andRefundReasonIsNull() {
			addCriterion("refund_reason is null");
			return (Criteria) this;
		}

		public Criteria andRefundReasonIsNotNull() {
			addCriterion("refund_reason is not null");
			return (Criteria) this;
		}

		public Criteria andRefundReasonEqualTo(String value) {
			addCriterion("refund_reason =", value, "refundReason");
			return (Criteria) this;
		}

		public Criteria andRefundReasonNotEqualTo(String value) {
			addCriterion("refund_reason <>", value, "refundReason");
			return (Criteria) this;
		}

		public Criteria andRefundReasonGreaterThan(String value) {
			addCriterion("refund_reason >", value, "refundReason");
			return (Criteria) this;
		}

		public Criteria andRefundReasonGreaterThanOrEqualTo(String value) {
			addCriterion("refund_reason >=", value, "refundReason");
			return (Criteria) this;
		}

		public Criteria andRefundReasonLessThan(String value) {
			addCriterion("refund_reason <", value, "refundReason");
			return (Criteria) this;
		}

		public Criteria andRefundReasonLessThanOrEqualTo(String value) {
			addCriterion("refund_reason <=", value, "refundReason");
			return (Criteria) this;
		}

		public Criteria andRefundReasonLike(String value) {
			addCriterion("refund_reason like", value, "refundReason");
			return (Criteria) this;
		}

		public Criteria andRefundReasonNotLike(String value) {
			addCriterion("refund_reason not like", value, "refundReason");
			return (Criteria) this;
		}

		public Criteria andRefundReasonIn(List<String> values) {
			addCriterion("refund_reason in", values, "refundReason");
			return (Criteria) this;
		}

		public Criteria andRefundReasonNotIn(List<String> values) {
			addCriterion("refund_reason not in", values, "refundReason");
			return (Criteria) this;
		}

		public Criteria andRefundReasonBetween(String value1, String value2) {
			addCriterion("refund_reason between", value1, value2, "refundReason");
			return (Criteria) this;
		}

		public Criteria andRefundReasonNotBetween(String value1, String value2) {
			addCriterion("refund_reason not between", value1, value2, "refundReason");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonIsNull() {
			addCriterion("refund_not_verify_reason is null");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonIsNotNull() {
			addCriterion("refund_not_verify_reason is not null");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonEqualTo(String value) {
			addCriterion("refund_not_verify_reason =", value, "refundNotVerifyReason");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonNotEqualTo(String value) {
			addCriterion("refund_not_verify_reason <>", value, "refundNotVerifyReason");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonGreaterThan(String value) {
			addCriterion("refund_not_verify_reason >", value, "refundNotVerifyReason");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonGreaterThanOrEqualTo(String value) {
			addCriterion("refund_not_verify_reason >=", value, "refundNotVerifyReason");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonLessThan(String value) {
			addCriterion("refund_not_verify_reason <", value, "refundNotVerifyReason");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonLessThanOrEqualTo(String value) {
			addCriterion("refund_not_verify_reason <=", value, "refundNotVerifyReason");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonLike(String value) {
			addCriterion("refund_not_verify_reason like", value, "refundNotVerifyReason");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonNotLike(String value) {
			addCriterion("refund_not_verify_reason not like", value, "refundNotVerifyReason");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonIn(List<String> values) {
			addCriterion("refund_not_verify_reason in", values, "refundNotVerifyReason");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonNotIn(List<String> values) {
			addCriterion("refund_not_verify_reason not in", values, "refundNotVerifyReason");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonBetween(String value1, String value2) {
			addCriterion("refund_not_verify_reason between", value1, value2, "refundNotVerifyReason");
			return (Criteria) this;
		}

		public Criteria andRefundNotVerifyReasonNotBetween(String value1, String value2) {
			addCriterion("refund_not_verify_reason not between", value1, value2, "refundNotVerifyReason");
			return (Criteria) this;
		}

		public Criteria andBackCodeIsNull() {
			addCriterion("back_code is null");
			return (Criteria) this;
		}

		public Criteria andBackCodeIsNotNull() {
			addCriterion("back_code is not null");
			return (Criteria) this;
		}

		public Criteria andBackCodeEqualTo(String value) {
			addCriterion("back_code =", value, "backCode");
			return (Criteria) this;
		}

		public Criteria andBackCodeNotEqualTo(String value) {
			addCriterion("back_code <>", value, "backCode");
			return (Criteria) this;
		}

		public Criteria andBackCodeGreaterThan(String value) {
			addCriterion("back_code >", value, "backCode");
			return (Criteria) this;
		}

		public Criteria andBackCodeGreaterThanOrEqualTo(String value) {
			addCriterion("back_code >=", value, "backCode");
			return (Criteria) this;
		}

		public Criteria andBackCodeLessThan(String value) {
			addCriterion("back_code <", value, "backCode");
			return (Criteria) this;
		}

		public Criteria andBackCodeLessThanOrEqualTo(String value) {
			addCriterion("back_code <=", value, "backCode");
			return (Criteria) this;
		}

		public Criteria andBackCodeLike(String value) {
			addCriterion("back_code like", value, "backCode");
			return (Criteria) this;
		}

		public Criteria andBackCodeNotLike(String value) {
			addCriterion("back_code not like", value, "backCode");
			return (Criteria) this;
		}

		public Criteria andBackCodeIn(List<String> values) {
			addCriterion("back_code in", values, "backCode");
			return (Criteria) this;
		}

		public Criteria andBackCodeNotIn(List<String> values) {
			addCriterion("back_code not in", values, "backCode");
			return (Criteria) this;
		}

		public Criteria andBackCodeBetween(String value1, String value2) {
			addCriterion("back_code between", value1, value2, "backCode");
			return (Criteria) this;
		}

		public Criteria andBackCodeNotBetween(String value1, String value2) {
			addCriterion("back_code not between", value1, value2, "backCode");
			return (Criteria) this;
		}

		public Criteria andBackAddressIsNull() {
			addCriterion("back_address is null");
			return (Criteria) this;
		}

		public Criteria andBackAddressIsNotNull() {
			addCriterion("back_address is not null");
			return (Criteria) this;
		}

		public Criteria andBackAddressEqualTo(String value) {
			addCriterion("back_address =", value, "backAddress");
			return (Criteria) this;
		}

		public Criteria andBackAddressNotEqualTo(String value) {
			addCriterion("back_address <>", value, "backAddress");
			return (Criteria) this;
		}

		public Criteria andBackAddressGreaterThan(String value) {
			addCriterion("back_address >", value, "backAddress");
			return (Criteria) this;
		}

		public Criteria andBackAddressGreaterThanOrEqualTo(String value) {
			addCriterion("back_address >=", value, "backAddress");
			return (Criteria) this;
		}

		public Criteria andBackAddressLessThan(String value) {
			addCriterion("back_address <", value, "backAddress");
			return (Criteria) this;
		}

		public Criteria andBackAddressLessThanOrEqualTo(String value) {
			addCriterion("back_address <=", value, "backAddress");
			return (Criteria) this;
		}

		public Criteria andBackAddressLike(String value) {
			addCriterion("back_address like", value, "backAddress");
			return (Criteria) this;
		}

		public Criteria andBackAddressNotLike(String value) {
			addCriterion("back_address not like", value, "backAddress");
			return (Criteria) this;
		}

		public Criteria andBackAddressIn(List<String> values) {
			addCriterion("back_address in", values, "backAddress");
			return (Criteria) this;
		}

		public Criteria andBackAddressNotIn(List<String> values) {
			addCriterion("back_address not in", values, "backAddress");
			return (Criteria) this;
		}

		public Criteria andBackAddressBetween(String value1, String value2) {
			addCriterion("back_address between", value1, value2, "backAddress");
			return (Criteria) this;
		}

		public Criteria andBackAddressNotBetween(String value1, String value2) {
			addCriterion("back_address not between", value1, value2, "backAddress");
			return (Criteria) this;
		}

		public Criteria andBackUserIsNull() {
			addCriterion("back_user is null");
			return (Criteria) this;
		}

		public Criteria andBackUserIsNotNull() {
			addCriterion("back_user is not null");
			return (Criteria) this;
		}

		public Criteria andBackUserEqualTo(String value) {
			addCriterion("back_user =", value, "backUser");
			return (Criteria) this;
		}

		public Criteria andBackUserNotEqualTo(String value) {
			addCriterion("back_user <>", value, "backUser");
			return (Criteria) this;
		}

		public Criteria andBackUserGreaterThan(String value) {
			addCriterion("back_user >", value, "backUser");
			return (Criteria) this;
		}

		public Criteria andBackUserGreaterThanOrEqualTo(String value) {
			addCriterion("back_user >=", value, "backUser");
			return (Criteria) this;
		}

		public Criteria andBackUserLessThan(String value) {
			addCriterion("back_user <", value, "backUser");
			return (Criteria) this;
		}

		public Criteria andBackUserLessThanOrEqualTo(String value) {
			addCriterion("back_user <=", value, "backUser");
			return (Criteria) this;
		}

		public Criteria andBackUserLike(String value) {
			addCriterion("back_user like", value, "backUser");
			return (Criteria) this;
		}

		public Criteria andBackUserNotLike(String value) {
			addCriterion("back_user not like", value, "backUser");
			return (Criteria) this;
		}

		public Criteria andBackUserIn(List<String> values) {
			addCriterion("back_user in", values, "backUser");
			return (Criteria) this;
		}

		public Criteria andBackUserNotIn(List<String> values) {
			addCriterion("back_user not in", values, "backUser");
			return (Criteria) this;
		}

		public Criteria andBackUserBetween(String value1, String value2) {
			addCriterion("back_user between", value1, value2, "backUser");
			return (Criteria) this;
		}

		public Criteria andBackUserNotBetween(String value1, String value2) {
			addCriterion("back_user not between", value1, value2, "backUser");
			return (Criteria) this;
		}

		public Criteria andBackPhoneIsNull() {
			addCriterion("back_phone is null");
			return (Criteria) this;
		}

		public Criteria andBackPhoneIsNotNull() {
			addCriterion("back_phone is not null");
			return (Criteria) this;
		}

		public Criteria andBackPhoneEqualTo(String value) {
			addCriterion("back_phone =", value, "backPhone");
			return (Criteria) this;
		}

		public Criteria andBackPhoneNotEqualTo(String value) {
			addCriterion("back_phone <>", value, "backPhone");
			return (Criteria) this;
		}

		public Criteria andBackPhoneGreaterThan(String value) {
			addCriterion("back_phone >", value, "backPhone");
			return (Criteria) this;
		}

		public Criteria andBackPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("back_phone >=", value, "backPhone");
			return (Criteria) this;
		}

		public Criteria andBackPhoneLessThan(String value) {
			addCriterion("back_phone <", value, "backPhone");
			return (Criteria) this;
		}

		public Criteria andBackPhoneLessThanOrEqualTo(String value) {
			addCriterion("back_phone <=", value, "backPhone");
			return (Criteria) this;
		}

		public Criteria andBackPhoneLike(String value) {
			addCriterion("back_phone like", value, "backPhone");
			return (Criteria) this;
		}

		public Criteria andBackPhoneNotLike(String value) {
			addCriterion("back_phone not like", value, "backPhone");
			return (Criteria) this;
		}

		public Criteria andBackPhoneIn(List<String> values) {
			addCriterion("back_phone in", values, "backPhone");
			return (Criteria) this;
		}

		public Criteria andBackPhoneNotIn(List<String> values) {
			addCriterion("back_phone not in", values, "backPhone");
			return (Criteria) this;
		}

		public Criteria andBackPhoneBetween(String value1, String value2) {
			addCriterion("back_phone between", value1, value2, "backPhone");
			return (Criteria) this;
		}

		public Criteria andBackPhoneNotBetween(String value1, String value2) {
			addCriterion("back_phone not between", value1, value2, "backPhone");
			return (Criteria) this;
		}

		public Criteria andBackStateIsNull() {
			addCriterion("back_state is null");
			return (Criteria) this;
		}

		public Criteria andBackStateIsNotNull() {
			addCriterion("back_state is not null");
			return (Criteria) this;
		}

		public Criteria andBackStateEqualTo(Integer value) {
			addCriterion("back_state =", value, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateNotEqualTo(Integer value) {
			addCriterion("back_state <>", value, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateGreaterThan(Integer value) {
			addCriterion("back_state >", value, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("back_state >=", value, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateLessThan(Integer value) {
			addCriterion("back_state <", value, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateLessThanOrEqualTo(Integer value) {
			addCriterion("back_state <=", value, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateIn(List<Integer> values) {
			addCriterion("back_state in", values, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateNotIn(List<Integer> values) {
			addCriterion("back_state not in", values, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateBetween(Integer value1, Integer value2) {
			addCriterion("back_state between", value1, value2, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateNotBetween(Integer value1, Integer value2) {
			addCriterion("back_state not between", value1, value2, "backState");
			return (Criteria) this;
		}

		public Criteria andPayTypeIsNull() {
			addCriterion("pay_type is null");
			return (Criteria) this;
		}

		public Criteria andPayTypeIsNotNull() {
			addCriterion("pay_type is not null");
			return (Criteria) this;
		}

		public Criteria andPayTypeEqualTo(Integer value) {
			addCriterion("pay_type =", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotEqualTo(Integer value) {
			addCriterion("pay_type <>", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeGreaterThan(Integer value) {
			addCriterion("pay_type >", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("pay_type >=", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLessThan(Integer value) {
			addCriterion("pay_type <", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
			addCriterion("pay_type <=", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeIn(List<Integer> values) {
			addCriterion("pay_type in", values, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotIn(List<Integer> values) {
			addCriterion("pay_type not in", values, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeBetween(Integer value1, Integer value2) {
			addCriterion("pay_type between", value1, value2, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("pay_type not between", value1, value2, "payType");
			return (Criteria) this;
		}

		public Criteria andCommentStateIsNull() {
			addCriterion("comment_state is null");
			return (Criteria) this;
		}

		public Criteria andCommentStateIsNotNull() {
			addCriterion("comment_state is not null");
			return (Criteria) this;
		}

		public Criteria andCommentStateEqualTo(Integer value) {
			addCriterion("comment_state =", value, "commentState");
			return (Criteria) this;
		}

		public Criteria andCommentStateNotEqualTo(Integer value) {
			addCriterion("comment_state <>", value, "commentState");
			return (Criteria) this;
		}

		public Criteria andCommentStateGreaterThan(Integer value) {
			addCriterion("comment_state >", value, "commentState");
			return (Criteria) this;
		}

		public Criteria andCommentStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("comment_state >=", value, "commentState");
			return (Criteria) this;
		}

		public Criteria andCommentStateLessThan(Integer value) {
			addCriterion("comment_state <", value, "commentState");
			return (Criteria) this;
		}

		public Criteria andCommentStateLessThanOrEqualTo(Integer value) {
			addCriterion("comment_state <=", value, "commentState");
			return (Criteria) this;
		}

		public Criteria andCommentStateIn(List<Integer> values) {
			addCriterion("comment_state in", values, "commentState");
			return (Criteria) this;
		}

		public Criteria andCommentStateNotIn(List<Integer> values) {
			addCriterion("comment_state not in", values, "commentState");
			return (Criteria) this;
		}

		public Criteria andCommentStateBetween(Integer value1, Integer value2) {
			addCriterion("comment_state between", value1, value2, "commentState");
			return (Criteria) this;
		}

		public Criteria andCommentStateNotBetween(Integer value1, Integer value2) {
			addCriterion("comment_state not between", value1, value2, "commentState");
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