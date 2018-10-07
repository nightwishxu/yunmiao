package com.item.dao.model;

import java.util.List;
import java.util.ArrayList;

public class UserCommentExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserCommentExample(){
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

		public Criteria andOrderIdIsNull() {
			addCriterion("order_id is null");
			return (Criteria) this;
		}

		public Criteria andOrderIdIsNotNull() {
			addCriterion("order_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrderIdEqualTo(Integer value) {
			addCriterion("order_id =", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotEqualTo(Integer value) {
			addCriterion("order_id <>", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThan(Integer value) {
			addCriterion("order_id >", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_id >=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThan(Integer value) {
			addCriterion("order_id <", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
			addCriterion("order_id <=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdIn(List<Integer> values) {
			addCriterion("order_id in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotIn(List<Integer> values) {
			addCriterion("order_id not in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdBetween(Integer value1, Integer value2) {
			addCriterion("order_id between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
			addCriterion("order_id not between", value1, value2, "orderId");
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

		public Criteria andScoreIsNull() {
			addCriterion("score is null");
			return (Criteria) this;
		}

		public Criteria andScoreIsNotNull() {
			addCriterion("score is not null");
			return (Criteria) this;
		}

		public Criteria andScoreEqualTo(Integer value) {
			addCriterion("score =", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreNotEqualTo(Integer value) {
			addCriterion("score <>", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreGreaterThan(Integer value) {
			addCriterion("score >", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("score >=", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreLessThan(Integer value) {
			addCriterion("score <", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreLessThanOrEqualTo(Integer value) {
			addCriterion("score <=", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreIn(List<Integer> values) {
			addCriterion("score in", values, "score");
			return (Criteria) this;
		}

		public Criteria andScoreNotIn(List<Integer> values) {
			addCriterion("score not in", values, "score");
			return (Criteria) this;
		}

		public Criteria andScoreBetween(Integer value1, Integer value2) {
			addCriterion("score between", value1, value2, "score");
			return (Criteria) this;
		}

		public Criteria andScoreNotBetween(Integer value1, Integer value2) {
			addCriterion("score not between", value1, value2, "score");
			return (Criteria) this;
		}

		public Criteria andExpressScoreIsNull() {
			addCriterion("express_score is null");
			return (Criteria) this;
		}

		public Criteria andExpressScoreIsNotNull() {
			addCriterion("express_score is not null");
			return (Criteria) this;
		}

		public Criteria andExpressScoreEqualTo(Integer value) {
			addCriterion("express_score =", value, "expressScore");
			return (Criteria) this;
		}

		public Criteria andExpressScoreNotEqualTo(Integer value) {
			addCriterion("express_score <>", value, "expressScore");
			return (Criteria) this;
		}

		public Criteria andExpressScoreGreaterThan(Integer value) {
			addCriterion("express_score >", value, "expressScore");
			return (Criteria) this;
		}

		public Criteria andExpressScoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("express_score >=", value, "expressScore");
			return (Criteria) this;
		}

		public Criteria andExpressScoreLessThan(Integer value) {
			addCriterion("express_score <", value, "expressScore");
			return (Criteria) this;
		}

		public Criteria andExpressScoreLessThanOrEqualTo(Integer value) {
			addCriterion("express_score <=", value, "expressScore");
			return (Criteria) this;
		}

		public Criteria andExpressScoreIn(List<Integer> values) {
			addCriterion("express_score in", values, "expressScore");
			return (Criteria) this;
		}

		public Criteria andExpressScoreNotIn(List<Integer> values) {
			addCriterion("express_score not in", values, "expressScore");
			return (Criteria) this;
		}

		public Criteria andExpressScoreBetween(Integer value1, Integer value2) {
			addCriterion("express_score between", value1, value2, "expressScore");
			return (Criteria) this;
		}

		public Criteria andExpressScoreNotBetween(Integer value1, Integer value2) {
			addCriterion("express_score not between", value1, value2, "expressScore");
			return (Criteria) this;
		}

		public Criteria andServiceScoreIsNull() {
			addCriterion("service_score is null");
			return (Criteria) this;
		}

		public Criteria andServiceScoreIsNotNull() {
			addCriterion("service_score is not null");
			return (Criteria) this;
		}

		public Criteria andServiceScoreEqualTo(Integer value) {
			addCriterion("service_score =", value, "serviceScore");
			return (Criteria) this;
		}

		public Criteria andServiceScoreNotEqualTo(Integer value) {
			addCriterion("service_score <>", value, "serviceScore");
			return (Criteria) this;
		}

		public Criteria andServiceScoreGreaterThan(Integer value) {
			addCriterion("service_score >", value, "serviceScore");
			return (Criteria) this;
		}

		public Criteria andServiceScoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("service_score >=", value, "serviceScore");
			return (Criteria) this;
		}

		public Criteria andServiceScoreLessThan(Integer value) {
			addCriterion("service_score <", value, "serviceScore");
			return (Criteria) this;
		}

		public Criteria andServiceScoreLessThanOrEqualTo(Integer value) {
			addCriterion("service_score <=", value, "serviceScore");
			return (Criteria) this;
		}

		public Criteria andServiceScoreIn(List<Integer> values) {
			addCriterion("service_score in", values, "serviceScore");
			return (Criteria) this;
		}

		public Criteria andServiceScoreNotIn(List<Integer> values) {
			addCriterion("service_score not in", values, "serviceScore");
			return (Criteria) this;
		}

		public Criteria andServiceScoreBetween(Integer value1, Integer value2) {
			addCriterion("service_score between", value1, value2, "serviceScore");
			return (Criteria) this;
		}

		public Criteria andServiceScoreNotBetween(Integer value1, Integer value2) {
			addCriterion("service_score not between", value1, value2, "serviceScore");
			return (Criteria) this;
		}

		public Criteria andReplayUserIdIsNull() {
			addCriterion("replay_user_id is null");
			return (Criteria) this;
		}

		public Criteria andReplayUserIdIsNotNull() {
			addCriterion("replay_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andReplayUserIdEqualTo(Integer value) {
			addCriterion("replay_user_id =", value, "replayUserId");
			return (Criteria) this;
		}

		public Criteria andReplayUserIdNotEqualTo(Integer value) {
			addCriterion("replay_user_id <>", value, "replayUserId");
			return (Criteria) this;
		}

		public Criteria andReplayUserIdGreaterThan(Integer value) {
			addCriterion("replay_user_id >", value, "replayUserId");
			return (Criteria) this;
		}

		public Criteria andReplayUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("replay_user_id >=", value, "replayUserId");
			return (Criteria) this;
		}

		public Criteria andReplayUserIdLessThan(Integer value) {
			addCriterion("replay_user_id <", value, "replayUserId");
			return (Criteria) this;
		}

		public Criteria andReplayUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("replay_user_id <=", value, "replayUserId");
			return (Criteria) this;
		}

		public Criteria andReplayUserIdIn(List<Integer> values) {
			addCriterion("replay_user_id in", values, "replayUserId");
			return (Criteria) this;
		}

		public Criteria andReplayUserIdNotIn(List<Integer> values) {
			addCriterion("replay_user_id not in", values, "replayUserId");
			return (Criteria) this;
		}

		public Criteria andReplayUserIdBetween(Integer value1, Integer value2) {
			addCriterion("replay_user_id between", value1, value2, "replayUserId");
			return (Criteria) this;
		}

		public Criteria andReplayUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("replay_user_id not between", value1, value2, "replayUserId");
			return (Criteria) this;
		}

		public Criteria andReplayInfoIsNull() {
			addCriterion("replay_info is null");
			return (Criteria) this;
		}

		public Criteria andReplayInfoIsNotNull() {
			addCriterion("replay_info is not null");
			return (Criteria) this;
		}

		public Criteria andReplayInfoEqualTo(String value) {
			addCriterion("replay_info =", value, "replayInfo");
			return (Criteria) this;
		}

		public Criteria andReplayInfoNotEqualTo(String value) {
			addCriterion("replay_info <>", value, "replayInfo");
			return (Criteria) this;
		}

		public Criteria andReplayInfoGreaterThan(String value) {
			addCriterion("replay_info >", value, "replayInfo");
			return (Criteria) this;
		}

		public Criteria andReplayInfoGreaterThanOrEqualTo(String value) {
			addCriterion("replay_info >=", value, "replayInfo");
			return (Criteria) this;
		}

		public Criteria andReplayInfoLessThan(String value) {
			addCriterion("replay_info <", value, "replayInfo");
			return (Criteria) this;
		}

		public Criteria andReplayInfoLessThanOrEqualTo(String value) {
			addCriterion("replay_info <=", value, "replayInfo");
			return (Criteria) this;
		}

		public Criteria andReplayInfoLike(String value) {
			addCriterion("replay_info like", value, "replayInfo");
			return (Criteria) this;
		}

		public Criteria andReplayInfoNotLike(String value) {
			addCriterion("replay_info not like", value, "replayInfo");
			return (Criteria) this;
		}

		public Criteria andReplayInfoIn(List<String> values) {
			addCriterion("replay_info in", values, "replayInfo");
			return (Criteria) this;
		}

		public Criteria andReplayInfoNotIn(List<String> values) {
			addCriterion("replay_info not in", values, "replayInfo");
			return (Criteria) this;
		}

		public Criteria andReplayInfoBetween(String value1, String value2) {
			addCriterion("replay_info between", value1, value2, "replayInfo");
			return (Criteria) this;
		}

		public Criteria andReplayInfoNotBetween(String value1, String value2) {
			addCriterion("replay_info not between", value1, value2, "replayInfo");
			return (Criteria) this;
		}

		public Criteria andReplayTimeIsNull() {
			addCriterion("replay_time is null");
			return (Criteria) this;
		}

		public Criteria andReplayTimeIsNotNull() {
			addCriterion("replay_time is not null");
			return (Criteria) this;
		}

		public Criteria andReplayTimeEqualTo(java.util.Date value) {
			addCriterion("replay_time =", value, "replayTime");
			return (Criteria) this;
		}

		public Criteria andReplayTimeNotEqualTo(java.util.Date value) {
			addCriterion("replay_time <>", value, "replayTime");
			return (Criteria) this;
		}

		public Criteria andReplayTimeGreaterThan(java.util.Date value) {
			addCriterion("replay_time >", value, "replayTime");
			return (Criteria) this;
		}

		public Criteria andReplayTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("replay_time >=", value, "replayTime");
			return (Criteria) this;
		}

		public Criteria andReplayTimeLessThan(java.util.Date value) {
			addCriterion("replay_time <", value, "replayTime");
			return (Criteria) this;
		}

		public Criteria andReplayTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("replay_time <=", value, "replayTime");
			return (Criteria) this;
		}

		public Criteria andReplayTimeIn(List<java.util.Date> values) {
			addCriterion("replay_time in", values, "replayTime");
			return (Criteria) this;
		}

		public Criteria andReplayTimeNotIn(List<java.util.Date> values) {
			addCriterion("replay_time not in", values, "replayTime");
			return (Criteria) this;
		}

		public Criteria andReplayTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("replay_time between", value1, value2, "replayTime");
			return (Criteria) this;
		}

		public Criteria andReplayTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("replay_time not between", value1, value2, "replayTime");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andShowNameIsNull() {
			addCriterion("show_name is null");
			return (Criteria) this;
		}

		public Criteria andShowNameIsNotNull() {
			addCriterion("show_name is not null");
			return (Criteria) this;
		}

		public Criteria andShowNameEqualTo(Integer value) {
			addCriterion("show_name =", value, "showName");
			return (Criteria) this;
		}

		public Criteria andShowNameNotEqualTo(Integer value) {
			addCriterion("show_name <>", value, "showName");
			return (Criteria) this;
		}

		public Criteria andShowNameGreaterThan(Integer value) {
			addCriterion("show_name >", value, "showName");
			return (Criteria) this;
		}

		public Criteria andShowNameGreaterThanOrEqualTo(Integer value) {
			addCriterion("show_name >=", value, "showName");
			return (Criteria) this;
		}

		public Criteria andShowNameLessThan(Integer value) {
			addCriterion("show_name <", value, "showName");
			return (Criteria) this;
		}

		public Criteria andShowNameLessThanOrEqualTo(Integer value) {
			addCriterion("show_name <=", value, "showName");
			return (Criteria) this;
		}

		public Criteria andShowNameIn(List<Integer> values) {
			addCriterion("show_name in", values, "showName");
			return (Criteria) this;
		}

		public Criteria andShowNameNotIn(List<Integer> values) {
			addCriterion("show_name not in", values, "showName");
			return (Criteria) this;
		}

		public Criteria andShowNameBetween(Integer value1, Integer value2) {
			addCriterion("show_name between", value1, value2, "showName");
			return (Criteria) this;
		}

		public Criteria andShowNameNotBetween(Integer value1, Integer value2) {
			addCriterion("show_name not between", value1, value2, "showName");
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