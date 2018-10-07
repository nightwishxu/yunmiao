package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class PawnLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PawnLogExample(){
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

		public Criteria andAuthPriceIsNull() {
			addCriterion("auth_price is null");
			return (Criteria) this;
		}

		public Criteria andAuthPriceIsNotNull() {
			addCriterion("auth_price is not null");
			return (Criteria) this;
		}

		public Criteria andAuthPriceEqualTo(java.math.BigDecimal value) {
			addCriterion("auth_price =", value, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceNotEqualTo(java.math.BigDecimal value) {
			addCriterion("auth_price <>", value, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceGreaterThan(java.math.BigDecimal value) {
			addCriterion("auth_price >", value, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("auth_price >=", value, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceLessThan(java.math.BigDecimal value) {
			addCriterion("auth_price <", value, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("auth_price <=", value, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceIn(List<java.math.BigDecimal> values) {
			addCriterion("auth_price in", values, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceNotIn(List<java.math.BigDecimal> values) {
			addCriterion("auth_price not in", values, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("auth_price between", value1, value2, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("auth_price not between", value1, value2, "authPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIsNull() {
			addCriterion("goods_cate is null");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIsNotNull() {
			addCriterion("goods_cate is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsCateEqualTo(String value) {
			addCriterion("goods_cate =", value, "goodsCate");
			return (Criteria) this;
		}

		public Criteria andGoodsCateNotEqualTo(String value) {
			addCriterion("goods_cate <>", value, "goodsCate");
			return (Criteria) this;
		}

		public Criteria andGoodsCateGreaterThan(String value) {
			addCriterion("goods_cate >", value, "goodsCate");
			return (Criteria) this;
		}

		public Criteria andGoodsCateGreaterThanOrEqualTo(String value) {
			addCriterion("goods_cate >=", value, "goodsCate");
			return (Criteria) this;
		}

		public Criteria andGoodsCateLessThan(String value) {
			addCriterion("goods_cate <", value, "goodsCate");
			return (Criteria) this;
		}

		public Criteria andGoodsCateLessThanOrEqualTo(String value) {
			addCriterion("goods_cate <=", value, "goodsCate");
			return (Criteria) this;
		}

		public Criteria andGoodsCateLike(String value) {
			addCriterion("goods_cate like", value, "goodsCate");
			return (Criteria) this;
		}

		public Criteria andGoodsCateNotLike(String value) {
			addCriterion("goods_cate not like", value, "goodsCate");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIn(List<String> values) {
			addCriterion("goods_cate in", values, "goodsCate");
			return (Criteria) this;
		}

		public Criteria andGoodsCateNotIn(List<String> values) {
			addCriterion("goods_cate not in", values, "goodsCate");
			return (Criteria) this;
		}

		public Criteria andGoodsCateBetween(String value1, String value2) {
			addCriterion("goods_cate between", value1, value2, "goodsCate");
			return (Criteria) this;
		}

		public Criteria andGoodsCateNotBetween(String value1, String value2) {
			addCriterion("goods_cate not between", value1, value2, "goodsCate");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIdIsNull() {
			addCriterion("goods_cate_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIdIsNotNull() {
			addCriterion("goods_cate_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIdEqualTo(Integer value) {
			addCriterion("goods_cate_id =", value, "goodsCateId");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIdNotEqualTo(Integer value) {
			addCriterion("goods_cate_id <>", value, "goodsCateId");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIdGreaterThan(Integer value) {
			addCriterion("goods_cate_id >", value, "goodsCateId");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_cate_id >=", value, "goodsCateId");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIdLessThan(Integer value) {
			addCriterion("goods_cate_id <", value, "goodsCateId");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIdLessThanOrEqualTo(Integer value) {
			addCriterion("goods_cate_id <=", value, "goodsCateId");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIdIn(List<Integer> values) {
			addCriterion("goods_cate_id in", values, "goodsCateId");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIdNotIn(List<Integer> values) {
			addCriterion("goods_cate_id not in", values, "goodsCateId");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIdBetween(Integer value1, Integer value2) {
			addCriterion("goods_cate_id between", value1, value2, "goodsCateId");
			return (Criteria) this;
		}

		public Criteria andGoodsCateIdNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_cate_id not between", value1, value2, "goodsCateId");
			return (Criteria) this;
		}

		public Criteria andOrgNameIsNull() {
			addCriterion("org_name is null");
			return (Criteria) this;
		}

		public Criteria andOrgNameIsNotNull() {
			addCriterion("org_name is not null");
			return (Criteria) this;
		}

		public Criteria andOrgNameEqualTo(String value) {
			addCriterion("org_name =", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameNotEqualTo(String value) {
			addCriterion("org_name <>", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameGreaterThan(String value) {
			addCriterion("org_name >", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
			addCriterion("org_name >=", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameLessThan(String value) {
			addCriterion("org_name <", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameLessThanOrEqualTo(String value) {
			addCriterion("org_name <=", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameLike(String value) {
			addCriterion("org_name like", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameNotLike(String value) {
			addCriterion("org_name not like", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameIn(List<String> values) {
			addCriterion("org_name in", values, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameNotIn(List<String> values) {
			addCriterion("org_name not in", values, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameBetween(String value1, String value2) {
			addCriterion("org_name between", value1, value2, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameNotBetween(String value1, String value2) {
			addCriterion("org_name not between", value1, value2, "orgName");
			return (Criteria) this;
		}

		public Criteria andMoneyIsNull() {
			addCriterion("money is null");
			return (Criteria) this;
		}

		public Criteria andMoneyIsNotNull() {
			addCriterion("money is not null");
			return (Criteria) this;
		}

		public Criteria andMoneyEqualTo(java.math.BigDecimal value) {
			addCriterion("money =", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotEqualTo(java.math.BigDecimal value) {
			addCriterion("money <>", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThan(java.math.BigDecimal value) {
			addCriterion("money >", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("money >=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThan(java.math.BigDecimal value) {
			addCriterion("money <", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("money <=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyIn(List<java.math.BigDecimal> values) {
			addCriterion("money in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotIn(List<java.math.BigDecimal> values) {
			addCriterion("money not in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("money between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("money not between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andPawnMonthIsNull() {
			addCriterion("pawn_month is null");
			return (Criteria) this;
		}

		public Criteria andPawnMonthIsNotNull() {
			addCriterion("pawn_month is not null");
			return (Criteria) this;
		}

		public Criteria andPawnMonthEqualTo(Integer value) {
			addCriterion("pawn_month =", value, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthNotEqualTo(Integer value) {
			addCriterion("pawn_month <>", value, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthGreaterThan(Integer value) {
			addCriterion("pawn_month >", value, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthGreaterThanOrEqualTo(Integer value) {
			addCriterion("pawn_month >=", value, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthLessThan(Integer value) {
			addCriterion("pawn_month <", value, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthLessThanOrEqualTo(Integer value) {
			addCriterion("pawn_month <=", value, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthIn(List<Integer> values) {
			addCriterion("pawn_month in", values, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthNotIn(List<Integer> values) {
			addCriterion("pawn_month not in", values, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthBetween(Integer value1, Integer value2) {
			addCriterion("pawn_month between", value1, value2, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthNotBetween(Integer value1, Integer value2) {
			addCriterion("pawn_month not between", value1, value2, "pawnMonth");
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

		public Criteria andUserNameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_name =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_name >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_name <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("user_name like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("user_name not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_name in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankIsNull() {
			addCriterion("trade_card_bank is null");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankIsNotNull() {
			addCriterion("trade_card_bank is not null");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankEqualTo(String value) {
			addCriterion("trade_card_bank =", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankNotEqualTo(String value) {
			addCriterion("trade_card_bank <>", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankGreaterThan(String value) {
			addCriterion("trade_card_bank >", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankGreaterThanOrEqualTo(String value) {
			addCriterion("trade_card_bank >=", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankLessThan(String value) {
			addCriterion("trade_card_bank <", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankLessThanOrEqualTo(String value) {
			addCriterion("trade_card_bank <=", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankLike(String value) {
			addCriterion("trade_card_bank like", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankNotLike(String value) {
			addCriterion("trade_card_bank not like", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankIn(List<String> values) {
			addCriterion("trade_card_bank in", values, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankNotIn(List<String> values) {
			addCriterion("trade_card_bank not in", values, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankBetween(String value1, String value2) {
			addCriterion("trade_card_bank between", value1, value2, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankNotBetween(String value1, String value2) {
			addCriterion("trade_card_bank not between", value1, value2, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeIsNull() {
			addCriterion("trade_card_code is null");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeIsNotNull() {
			addCriterion("trade_card_code is not null");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeEqualTo(String value) {
			addCriterion("trade_card_code =", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeNotEqualTo(String value) {
			addCriterion("trade_card_code <>", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeGreaterThan(String value) {
			addCriterion("trade_card_code >", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeGreaterThanOrEqualTo(String value) {
			addCriterion("trade_card_code >=", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeLessThan(String value) {
			addCriterion("trade_card_code <", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeLessThanOrEqualTo(String value) {
			addCriterion("trade_card_code <=", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeLike(String value) {
			addCriterion("trade_card_code like", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeNotLike(String value) {
			addCriterion("trade_card_code not like", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeIn(List<String> values) {
			addCriterion("trade_card_code in", values, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeNotIn(List<String> values) {
			addCriterion("trade_card_code not in", values, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeBetween(String value1, String value2) {
			addCriterion("trade_card_code between", value1, value2, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeNotBetween(String value1, String value2) {
			addCriterion("trade_card_code not between", value1, value2, "tradeCardCode");
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