package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class GoodsExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GoodsExample(){
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

		public Criteria andSourceIsNull() {
			addCriterion("source is null");
			return (Criteria) this;
		}

		public Criteria andSourceIsNotNull() {
			addCriterion("source is not null");
			return (Criteria) this;
		}

		public Criteria andSourceEqualTo(Integer value) {
			addCriterion("source =", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotEqualTo(Integer value) {
			addCriterion("source <>", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceGreaterThan(Integer value) {
			addCriterion("source >", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
			addCriterion("source >=", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLessThan(Integer value) {
			addCriterion("source <", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLessThanOrEqualTo(Integer value) {
			addCriterion("source <=", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceIn(List<Integer> values) {
			addCriterion("source in", values, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotIn(List<Integer> values) {
			addCriterion("source not in", values, "source");
			return (Criteria) this;
		}

		public Criteria andSourceBetween(Integer value1, Integer value2) {
			addCriterion("source between", value1, value2, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotBetween(Integer value1, Integer value2) {
			addCriterion("source not between", value1, value2, "source");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(Integer value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Integer value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Integer value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Integer value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Integer value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Integer> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Integer> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Integer value1, Integer value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andCateCodeIsNull() {
			addCriterion("cate_code is null");
			return (Criteria) this;
		}

		public Criteria andCateCodeIsNotNull() {
			addCriterion("cate_code is not null");
			return (Criteria) this;
		}

		public Criteria andCateCodeEqualTo(Integer value) {
			addCriterion("cate_code =", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeNotEqualTo(Integer value) {
			addCriterion("cate_code <>", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeGreaterThan(Integer value) {
			addCriterion("cate_code >", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeGreaterThanOrEqualTo(Integer value) {
			addCriterion("cate_code >=", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeLessThan(Integer value) {
			addCriterion("cate_code <", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeLessThanOrEqualTo(Integer value) {
			addCriterion("cate_code <=", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeIn(List<Integer> values) {
			addCriterion("cate_code in", values, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeNotIn(List<Integer> values) {
			addCriterion("cate_code not in", values, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeBetween(Integer value1, Integer value2) {
			addCriterion("cate_code between", value1, value2, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeNotBetween(Integer value1, Integer value2) {
			addCriterion("cate_code not between", value1, value2, "cateCode");
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

		public Criteria andCostIsNull() {
			addCriterion("cost is null");
			return (Criteria) this;
		}

		public Criteria andCostIsNotNull() {
			addCriterion("cost is not null");
			return (Criteria) this;
		}

		public Criteria andCostEqualTo(java.math.BigDecimal value) {
			addCriterion("cost =", value, "cost");
			return (Criteria) this;
		}

		public Criteria andCostNotEqualTo(java.math.BigDecimal value) {
			addCriterion("cost <>", value, "cost");
			return (Criteria) this;
		}

		public Criteria andCostGreaterThan(java.math.BigDecimal value) {
			addCriterion("cost >", value, "cost");
			return (Criteria) this;
		}

		public Criteria andCostGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("cost >=", value, "cost");
			return (Criteria) this;
		}

		public Criteria andCostLessThan(java.math.BigDecimal value) {
			addCriterion("cost <", value, "cost");
			return (Criteria) this;
		}

		public Criteria andCostLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("cost <=", value, "cost");
			return (Criteria) this;
		}

		public Criteria andCostIn(List<java.math.BigDecimal> values) {
			addCriterion("cost in", values, "cost");
			return (Criteria) this;
		}

		public Criteria andCostNotIn(List<java.math.BigDecimal> values) {
			addCriterion("cost not in", values, "cost");
			return (Criteria) this;
		}

		public Criteria andCostBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("cost between", value1, value2, "cost");
			return (Criteria) this;
		}

		public Criteria andCostNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("cost not between", value1, value2, "cost");
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

		public Criteria andTotalIsNull() {
			addCriterion("total is null");
			return (Criteria) this;
		}

		public Criteria andTotalIsNotNull() {
			addCriterion("total is not null");
			return (Criteria) this;
		}

		public Criteria andTotalEqualTo(Integer value) {
			addCriterion("total =", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotEqualTo(Integer value) {
			addCriterion("total <>", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalGreaterThan(Integer value) {
			addCriterion("total >", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
			addCriterion("total >=", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalLessThan(Integer value) {
			addCriterion("total <", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalLessThanOrEqualTo(Integer value) {
			addCriterion("total <=", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalIn(List<Integer> values) {
			addCriterion("total in", values, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotIn(List<Integer> values) {
			addCriterion("total not in", values, "total");
			return (Criteria) this;
		}

		public Criteria andTotalBetween(Integer value1, Integer value2) {
			addCriterion("total between", value1, value2, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotBetween(Integer value1, Integer value2) {
			addCriterion("total not between", value1, value2, "total");
			return (Criteria) this;
		}

		public Criteria andSoldOutIsNull() {
			addCriterion("sold_out is null");
			return (Criteria) this;
		}

		public Criteria andSoldOutIsNotNull() {
			addCriterion("sold_out is not null");
			return (Criteria) this;
		}

		public Criteria andSoldOutEqualTo(Integer value) {
			addCriterion("sold_out =", value, "soldOut");
			return (Criteria) this;
		}

		public Criteria andSoldOutNotEqualTo(Integer value) {
			addCriterion("sold_out <>", value, "soldOut");
			return (Criteria) this;
		}

		public Criteria andSoldOutGreaterThan(Integer value) {
			addCriterion("sold_out >", value, "soldOut");
			return (Criteria) this;
		}

		public Criteria andSoldOutGreaterThanOrEqualTo(Integer value) {
			addCriterion("sold_out >=", value, "soldOut");
			return (Criteria) this;
		}

		public Criteria andSoldOutLessThan(Integer value) {
			addCriterion("sold_out <", value, "soldOut");
			return (Criteria) this;
		}

		public Criteria andSoldOutLessThanOrEqualTo(Integer value) {
			addCriterion("sold_out <=", value, "soldOut");
			return (Criteria) this;
		}

		public Criteria andSoldOutIn(List<Integer> values) {
			addCriterion("sold_out in", values, "soldOut");
			return (Criteria) this;
		}

		public Criteria andSoldOutNotIn(List<Integer> values) {
			addCriterion("sold_out not in", values, "soldOut");
			return (Criteria) this;
		}

		public Criteria andSoldOutBetween(Integer value1, Integer value2) {
			addCriterion("sold_out between", value1, value2, "soldOut");
			return (Criteria) this;
		}

		public Criteria andSoldOutNotBetween(Integer value1, Integer value2) {
			addCriterion("sold_out not between", value1, value2, "soldOut");
			return (Criteria) this;
		}

		public Criteria andIsOnlineIsNull() {
			addCriterion("is_online is null");
			return (Criteria) this;
		}

		public Criteria andIsOnlineIsNotNull() {
			addCriterion("is_online is not null");
			return (Criteria) this;
		}

		public Criteria andIsOnlineEqualTo(Integer value) {
			addCriterion("is_online =", value, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineNotEqualTo(Integer value) {
			addCriterion("is_online <>", value, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineGreaterThan(Integer value) {
			addCriterion("is_online >", value, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_online >=", value, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineLessThan(Integer value) {
			addCriterion("is_online <", value, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineLessThanOrEqualTo(Integer value) {
			addCriterion("is_online <=", value, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineIn(List<Integer> values) {
			addCriterion("is_online in", values, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineNotIn(List<Integer> values) {
			addCriterion("is_online not in", values, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineBetween(Integer value1, Integer value2) {
			addCriterion("is_online between", value1, value2, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineNotBetween(Integer value1, Integer value2) {
			addCriterion("is_online not between", value1, value2, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsVerfiyIsNull() {
			addCriterion("is_verfiy is null");
			return (Criteria) this;
		}

		public Criteria andIsVerfiyIsNotNull() {
			addCriterion("is_verfiy is not null");
			return (Criteria) this;
		}

		public Criteria andIsVerfiyEqualTo(Integer value) {
			addCriterion("is_verfiy =", value, "isVerfiy");
			return (Criteria) this;
		}

		public Criteria andIsVerfiyNotEqualTo(Integer value) {
			addCriterion("is_verfiy <>", value, "isVerfiy");
			return (Criteria) this;
		}

		public Criteria andIsVerfiyGreaterThan(Integer value) {
			addCriterion("is_verfiy >", value, "isVerfiy");
			return (Criteria) this;
		}

		public Criteria andIsVerfiyGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_verfiy >=", value, "isVerfiy");
			return (Criteria) this;
		}

		public Criteria andIsVerfiyLessThan(Integer value) {
			addCriterion("is_verfiy <", value, "isVerfiy");
			return (Criteria) this;
		}

		public Criteria andIsVerfiyLessThanOrEqualTo(Integer value) {
			addCriterion("is_verfiy <=", value, "isVerfiy");
			return (Criteria) this;
		}

		public Criteria andIsVerfiyIn(List<Integer> values) {
			addCriterion("is_verfiy in", values, "isVerfiy");
			return (Criteria) this;
		}

		public Criteria andIsVerfiyNotIn(List<Integer> values) {
			addCriterion("is_verfiy not in", values, "isVerfiy");
			return (Criteria) this;
		}

		public Criteria andIsVerfiyBetween(Integer value1, Integer value2) {
			addCriterion("is_verfiy between", value1, value2, "isVerfiy");
			return (Criteria) this;
		}

		public Criteria andIsVerfiyNotBetween(Integer value1, Integer value2) {
			addCriterion("is_verfiy not between", value1, value2, "isVerfiy");
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

		public Criteria andImgIsNull() {
			addCriterion("img is null");
			return (Criteria) this;
		}

		public Criteria andImgIsNotNull() {
			addCriterion("img is not null");
			return (Criteria) this;
		}

		public Criteria andImgEqualTo(String value) {
			addCriterion("img =", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotEqualTo(String value) {
			addCriterion("img <>", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgGreaterThan(String value) {
			addCriterion("img >", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgGreaterThanOrEqualTo(String value) {
			addCriterion("img >=", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgLessThan(String value) {
			addCriterion("img <", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgLessThanOrEqualTo(String value) {
			addCriterion("img <=", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgLike(String value) {
			addCriterion("img like", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotLike(String value) {
			addCriterion("img not like", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgIn(List<String> values) {
			addCriterion("img in", values, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotIn(List<String> values) {
			addCriterion("img not in", values, "img");
			return (Criteria) this;
		}

		public Criteria andImgBetween(String value1, String value2) {
			addCriterion("img between", value1, value2, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotBetween(String value1, String value2) {
			addCriterion("img not between", value1, value2, "img");
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

		public Criteria andInfoIsNull() {
			addCriterion("info is null");
			return (Criteria) this;
		}

		public Criteria andInfoIsNotNull() {
			addCriterion("info is not null");
			return (Criteria) this;
		}

		public Criteria andInfoEqualTo(String value) {
			addCriterion("info =", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotEqualTo(String value) {
			addCriterion("info <>", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoGreaterThan(String value) {
			addCriterion("info >", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoGreaterThanOrEqualTo(String value) {
			addCriterion("info >=", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLessThan(String value) {
			addCriterion("info <", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLessThanOrEqualTo(String value) {
			addCriterion("info <=", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLike(String value) {
			addCriterion("info like", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotLike(String value) {
			addCriterion("info not like", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoIn(List<String> values) {
			addCriterion("info in", values, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotIn(List<String> values) {
			addCriterion("info not in", values, "info");
			return (Criteria) this;
		}

		public Criteria andInfoBetween(String value1, String value2) {
			addCriterion("info between", value1, value2, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotBetween(String value1, String value2) {
			addCriterion("info not between", value1, value2, "info");
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

		public Criteria andMaxAutionIdIsNull() {
			addCriterion("max_aution_id is null");
			return (Criteria) this;
		}

		public Criteria andMaxAutionIdIsNotNull() {
			addCriterion("max_aution_id is not null");
			return (Criteria) this;
		}

		public Criteria andMaxAutionIdEqualTo(Integer value) {
			addCriterion("max_aution_id =", value, "maxAutionId");
			return (Criteria) this;
		}

		public Criteria andMaxAutionIdNotEqualTo(Integer value) {
			addCriterion("max_aution_id <>", value, "maxAutionId");
			return (Criteria) this;
		}

		public Criteria andMaxAutionIdGreaterThan(Integer value) {
			addCriterion("max_aution_id >", value, "maxAutionId");
			return (Criteria) this;
		}

		public Criteria andMaxAutionIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("max_aution_id >=", value, "maxAutionId");
			return (Criteria) this;
		}

		public Criteria andMaxAutionIdLessThan(Integer value) {
			addCriterion("max_aution_id <", value, "maxAutionId");
			return (Criteria) this;
		}

		public Criteria andMaxAutionIdLessThanOrEqualTo(Integer value) {
			addCriterion("max_aution_id <=", value, "maxAutionId");
			return (Criteria) this;
		}

		public Criteria andMaxAutionIdIn(List<Integer> values) {
			addCriterion("max_aution_id in", values, "maxAutionId");
			return (Criteria) this;
		}

		public Criteria andMaxAutionIdNotIn(List<Integer> values) {
			addCriterion("max_aution_id not in", values, "maxAutionId");
			return (Criteria) this;
		}

		public Criteria andMaxAutionIdBetween(Integer value1, Integer value2) {
			addCriterion("max_aution_id between", value1, value2, "maxAutionId");
			return (Criteria) this;
		}

		public Criteria andMaxAutionIdNotBetween(Integer value1, Integer value2) {
			addCriterion("max_aution_id not between", value1, value2, "maxAutionId");
			return (Criteria) this;
		}

		public Criteria andMaxAuctionIsNull() {
			addCriterion("max_auction is null");
			return (Criteria) this;
		}

		public Criteria andMaxAuctionIsNotNull() {
			addCriterion("max_auction is not null");
			return (Criteria) this;
		}

		public Criteria andMaxAuctionEqualTo(java.math.BigDecimal value) {
			addCriterion("max_auction =", value, "maxAuction");
			return (Criteria) this;
		}

		public Criteria andMaxAuctionNotEqualTo(java.math.BigDecimal value) {
			addCriterion("max_auction <>", value, "maxAuction");
			return (Criteria) this;
		}

		public Criteria andMaxAuctionGreaterThan(java.math.BigDecimal value) {
			addCriterion("max_auction >", value, "maxAuction");
			return (Criteria) this;
		}

		public Criteria andMaxAuctionGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("max_auction >=", value, "maxAuction");
			return (Criteria) this;
		}

		public Criteria andMaxAuctionLessThan(java.math.BigDecimal value) {
			addCriterion("max_auction <", value, "maxAuction");
			return (Criteria) this;
		}

		public Criteria andMaxAuctionLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("max_auction <=", value, "maxAuction");
			return (Criteria) this;
		}

		public Criteria andMaxAuctionIn(List<java.math.BigDecimal> values) {
			addCriterion("max_auction in", values, "maxAuction");
			return (Criteria) this;
		}

		public Criteria andMaxAuctionNotIn(List<java.math.BigDecimal> values) {
			addCriterion("max_auction not in", values, "maxAuction");
			return (Criteria) this;
		}

		public Criteria andMaxAuctionBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("max_auction between", value1, value2, "maxAuction");
			return (Criteria) this;
		}

		public Criteria andMaxAuctionNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("max_auction not between", value1, value2, "maxAuction");
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

		public Criteria andPlatformRateIsNull() {
			addCriterion("platform_rate is null");
			return (Criteria) this;
		}

		public Criteria andPlatformRateIsNotNull() {
			addCriterion("platform_rate is not null");
			return (Criteria) this;
		}

		public Criteria andPlatformRateEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_rate =", value, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateNotEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_rate <>", value, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateGreaterThan(java.math.BigDecimal value) {
			addCriterion("platform_rate >", value, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_rate >=", value, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateLessThan(java.math.BigDecimal value) {
			addCriterion("platform_rate <", value, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_rate <=", value, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateIn(List<java.math.BigDecimal> values) {
			addCriterion("platform_rate in", values, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateNotIn(List<java.math.BigDecimal> values) {
			addCriterion("platform_rate not in", values, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("platform_rate between", value1, value2, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("platform_rate not between", value1, value2, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyIsNull() {
			addCriterion("platform_money is null");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyIsNotNull() {
			addCriterion("platform_money is not null");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_money =", value, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyNotEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_money <>", value, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyGreaterThan(java.math.BigDecimal value) {
			addCriterion("platform_money >", value, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_money >=", value, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyLessThan(java.math.BigDecimal value) {
			addCriterion("platform_money <", value, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_money <=", value, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyIn(List<java.math.BigDecimal> values) {
			addCriterion("platform_money in", values, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyNotIn(List<java.math.BigDecimal> values) {
			addCriterion("platform_money not in", values, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("platform_money between", value1, value2, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("platform_money not between", value1, value2, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformStateIsNull() {
			addCriterion("platform_state is null");
			return (Criteria) this;
		}

		public Criteria andPlatformStateIsNotNull() {
			addCriterion("platform_state is not null");
			return (Criteria) this;
		}

		public Criteria andPlatformStateEqualTo(Integer value) {
			addCriterion("platform_state =", value, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateNotEqualTo(Integer value) {
			addCriterion("platform_state <>", value, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateGreaterThan(Integer value) {
			addCriterion("platform_state >", value, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("platform_state >=", value, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateLessThan(Integer value) {
			addCriterion("platform_state <", value, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateLessThanOrEqualTo(Integer value) {
			addCriterion("platform_state <=", value, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateIn(List<Integer> values) {
			addCriterion("platform_state in", values, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateNotIn(List<Integer> values) {
			addCriterion("platform_state not in", values, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateBetween(Integer value1, Integer value2) {
			addCriterion("platform_state between", value1, value2, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateNotBetween(Integer value1, Integer value2) {
			addCriterion("platform_state not between", value1, value2, "platformState");
			return (Criteria) this;
		}

		public Criteria andSortOrderIsNull() {
			addCriterion("sort_order is null");
			return (Criteria) this;
		}

		public Criteria andSortOrderIsNotNull() {
			addCriterion("sort_order is not null");
			return (Criteria) this;
		}

		public Criteria andSortOrderEqualTo(Integer value) {
			addCriterion("sort_order =", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderNotEqualTo(Integer value) {
			addCriterion("sort_order <>", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderGreaterThan(Integer value) {
			addCriterion("sort_order >", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
			addCriterion("sort_order >=", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderLessThan(Integer value) {
			addCriterion("sort_order <", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderLessThanOrEqualTo(Integer value) {
			addCriterion("sort_order <=", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderIn(List<Integer> values) {
			addCriterion("sort_order in", values, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderNotIn(List<Integer> values) {
			addCriterion("sort_order not in", values, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderBetween(Integer value1, Integer value2) {
			addCriterion("sort_order between", value1, value2, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
			addCriterion("sort_order not between", value1, value2, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andIsSuggestIsNull() {
			addCriterion("is_suggest is null");
			return (Criteria) this;
		}

		public Criteria andIsSuggestIsNotNull() {
			addCriterion("is_suggest is not null");
			return (Criteria) this;
		}

		public Criteria andIsSuggestEqualTo(Integer value) {
			addCriterion("is_suggest =", value, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestNotEqualTo(Integer value) {
			addCriterion("is_suggest <>", value, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestGreaterThan(Integer value) {
			addCriterion("is_suggest >", value, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_suggest >=", value, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestLessThan(Integer value) {
			addCriterion("is_suggest <", value, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestLessThanOrEqualTo(Integer value) {
			addCriterion("is_suggest <=", value, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestIn(List<Integer> values) {
			addCriterion("is_suggest in", values, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestNotIn(List<Integer> values) {
			addCriterion("is_suggest not in", values, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestBetween(Integer value1, Integer value2) {
			addCriterion("is_suggest between", value1, value2, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestNotBetween(Integer value1, Integer value2) {
			addCriterion("is_suggest not between", value1, value2, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andSpecIsNull() {
			addCriterion("spec is null");
			return (Criteria) this;
		}

		public Criteria andSpecIsNotNull() {
			addCriterion("spec is not null");
			return (Criteria) this;
		}

		public Criteria andSpecEqualTo(String value) {
			addCriterion("spec =", value, "spec");
			return (Criteria) this;
		}

		public Criteria andSpecNotEqualTo(String value) {
			addCriterion("spec <>", value, "spec");
			return (Criteria) this;
		}

		public Criteria andSpecGreaterThan(String value) {
			addCriterion("spec >", value, "spec");
			return (Criteria) this;
		}

		public Criteria andSpecGreaterThanOrEqualTo(String value) {
			addCriterion("spec >=", value, "spec");
			return (Criteria) this;
		}

		public Criteria andSpecLessThan(String value) {
			addCriterion("spec <", value, "spec");
			return (Criteria) this;
		}

		public Criteria andSpecLessThanOrEqualTo(String value) {
			addCriterion("spec <=", value, "spec");
			return (Criteria) this;
		}

		public Criteria andSpecLike(String value) {
			addCriterion("spec like", value, "spec");
			return (Criteria) this;
		}

		public Criteria andSpecNotLike(String value) {
			addCriterion("spec not like", value, "spec");
			return (Criteria) this;
		}

		public Criteria andSpecIn(List<String> values) {
			addCriterion("spec in", values, "spec");
			return (Criteria) this;
		}

		public Criteria andSpecNotIn(List<String> values) {
			addCriterion("spec not in", values, "spec");
			return (Criteria) this;
		}

		public Criteria andSpecBetween(String value1, String value2) {
			addCriterion("spec between", value1, value2, "spec");
			return (Criteria) this;
		}

		public Criteria andSpecNotBetween(String value1, String value2) {
			addCriterion("spec not between", value1, value2, "spec");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoIsNull() {
			addCriterion("refuse_info is null");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoIsNotNull() {
			addCriterion("refuse_info is not null");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoEqualTo(String value) {
			addCriterion("refuse_info =", value, "refuseInfo");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoNotEqualTo(String value) {
			addCriterion("refuse_info <>", value, "refuseInfo");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoGreaterThan(String value) {
			addCriterion("refuse_info >", value, "refuseInfo");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoGreaterThanOrEqualTo(String value) {
			addCriterion("refuse_info >=", value, "refuseInfo");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoLessThan(String value) {
			addCriterion("refuse_info <", value, "refuseInfo");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoLessThanOrEqualTo(String value) {
			addCriterion("refuse_info <=", value, "refuseInfo");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoLike(String value) {
			addCriterion("refuse_info like", value, "refuseInfo");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoNotLike(String value) {
			addCriterion("refuse_info not like", value, "refuseInfo");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoIn(List<String> values) {
			addCriterion("refuse_info in", values, "refuseInfo");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoNotIn(List<String> values) {
			addCriterion("refuse_info not in", values, "refuseInfo");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoBetween(String value1, String value2) {
			addCriterion("refuse_info between", value1, value2, "refuseInfo");
			return (Criteria) this;
		}

		public Criteria andRefuseInfoNotBetween(String value1, String value2) {
			addCriterion("refuse_info not between", value1, value2, "refuseInfo");
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