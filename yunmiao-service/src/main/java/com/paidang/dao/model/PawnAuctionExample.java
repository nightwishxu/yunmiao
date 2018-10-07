package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class PawnAuctionExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PawnAuctionExample(){
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

		public Criteria andPawnIdIsNull() {
			addCriterion("pawn_id is null");
			return (Criteria) this;
		}

		public Criteria andPawnIdIsNotNull() {
			addCriterion("pawn_id is not null");
			return (Criteria) this;
		}

		public Criteria andPawnIdEqualTo(Integer value) {
			addCriterion("pawn_id =", value, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdNotEqualTo(Integer value) {
			addCriterion("pawn_id <>", value, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdGreaterThan(Integer value) {
			addCriterion("pawn_id >", value, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("pawn_id >=", value, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdLessThan(Integer value) {
			addCriterion("pawn_id <", value, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdLessThanOrEqualTo(Integer value) {
			addCriterion("pawn_id <=", value, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdIn(List<Integer> values) {
			addCriterion("pawn_id in", values, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdNotIn(List<Integer> values) {
			addCriterion("pawn_id not in", values, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdBetween(Integer value1, Integer value2) {
			addCriterion("pawn_id between", value1, value2, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdNotBetween(Integer value1, Integer value2) {
			addCriterion("pawn_id not between", value1, value2, "pawnId");
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

		public Criteria andPawnCodeIsNull() {
			addCriterion("pawn_code is null");
			return (Criteria) this;
		}

		public Criteria andPawnCodeIsNotNull() {
			addCriterion("pawn_code is not null");
			return (Criteria) this;
		}

		public Criteria andPawnCodeEqualTo(String value) {
			addCriterion("pawn_code =", value, "pawnCode");
			return (Criteria) this;
		}

		public Criteria andPawnCodeNotEqualTo(String value) {
			addCriterion("pawn_code <>", value, "pawnCode");
			return (Criteria) this;
		}

		public Criteria andPawnCodeGreaterThan(String value) {
			addCriterion("pawn_code >", value, "pawnCode");
			return (Criteria) this;
		}

		public Criteria andPawnCodeGreaterThanOrEqualTo(String value) {
			addCriterion("pawn_code >=", value, "pawnCode");
			return (Criteria) this;
		}

		public Criteria andPawnCodeLessThan(String value) {
			addCriterion("pawn_code <", value, "pawnCode");
			return (Criteria) this;
		}

		public Criteria andPawnCodeLessThanOrEqualTo(String value) {
			addCriterion("pawn_code <=", value, "pawnCode");
			return (Criteria) this;
		}

		public Criteria andPawnCodeLike(String value) {
			addCriterion("pawn_code like", value, "pawnCode");
			return (Criteria) this;
		}

		public Criteria andPawnCodeNotLike(String value) {
			addCriterion("pawn_code not like", value, "pawnCode");
			return (Criteria) this;
		}

		public Criteria andPawnCodeIn(List<String> values) {
			addCriterion("pawn_code in", values, "pawnCode");
			return (Criteria) this;
		}

		public Criteria andPawnCodeNotIn(List<String> values) {
			addCriterion("pawn_code not in", values, "pawnCode");
			return (Criteria) this;
		}

		public Criteria andPawnCodeBetween(String value1, String value2) {
			addCriterion("pawn_code between", value1, value2, "pawnCode");
			return (Criteria) this;
		}

		public Criteria andPawnCodeNotBetween(String value1, String value2) {
			addCriterion("pawn_code not between", value1, value2, "pawnCode");
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

		public Criteria andRateIsNull() {
			addCriterion("rate is null");
			return (Criteria) this;
		}

		public Criteria andRateIsNotNull() {
			addCriterion("rate is not null");
			return (Criteria) this;
		}

		public Criteria andRateEqualTo(java.math.BigDecimal value) {
			addCriterion("rate =", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateNotEqualTo(java.math.BigDecimal value) {
			addCriterion("rate <>", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateGreaterThan(java.math.BigDecimal value) {
			addCriterion("rate >", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("rate >=", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateLessThan(java.math.BigDecimal value) {
			addCriterion("rate <", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("rate <=", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateIn(List<java.math.BigDecimal> values) {
			addCriterion("rate in", values, "rate");
			return (Criteria) this;
		}

		public Criteria andRateNotIn(List<java.math.BigDecimal> values) {
			addCriterion("rate not in", values, "rate");
			return (Criteria) this;
		}

		public Criteria andRateBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("rate between", value1, value2, "rate");
			return (Criteria) this;
		}

		public Criteria andRateNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("rate not between", value1, value2, "rate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateIsNull() {
			addCriterion("money_rate is null");
			return (Criteria) this;
		}

		public Criteria andMoneyRateIsNotNull() {
			addCriterion("money_rate is not null");
			return (Criteria) this;
		}

		public Criteria andMoneyRateEqualTo(java.math.BigDecimal value) {
			addCriterion("money_rate =", value, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateNotEqualTo(java.math.BigDecimal value) {
			addCriterion("money_rate <>", value, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateGreaterThan(java.math.BigDecimal value) {
			addCriterion("money_rate >", value, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("money_rate >=", value, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateLessThan(java.math.BigDecimal value) {
			addCriterion("money_rate <", value, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("money_rate <=", value, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateIn(List<java.math.BigDecimal> values) {
			addCriterion("money_rate in", values, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateNotIn(List<java.math.BigDecimal> values) {
			addCriterion("money_rate not in", values, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("money_rate between", value1, value2, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("money_rate not between", value1, value2, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdIsNull() {
			addCriterion("org_user_id is null");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdIsNotNull() {
			addCriterion("org_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdEqualTo(Integer value) {
			addCriterion("org_user_id =", value, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdNotEqualTo(Integer value) {
			addCriterion("org_user_id <>", value, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdGreaterThan(Integer value) {
			addCriterion("org_user_id >", value, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("org_user_id >=", value, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdLessThan(Integer value) {
			addCriterion("org_user_id <", value, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("org_user_id <=", value, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdIn(List<Integer> values) {
			addCriterion("org_user_id in", values, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdNotIn(List<Integer> values) {
			addCriterion("org_user_id not in", values, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdBetween(Integer value1, Integer value2) {
			addCriterion("org_user_id between", value1, value2, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("org_user_id not between", value1, value2, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andNumIsNull() {
			addCriterion("num is null");
			return (Criteria) this;
		}

		public Criteria andNumIsNotNull() {
			addCriterion("num is not null");
			return (Criteria) this;
		}

		public Criteria andNumEqualTo(Integer value) {
			addCriterion("num =", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumNotEqualTo(Integer value) {
			addCriterion("num <>", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumGreaterThan(Integer value) {
			addCriterion("num >", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("num >=", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumLessThan(Integer value) {
			addCriterion("num <", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumLessThanOrEqualTo(Integer value) {
			addCriterion("num <=", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumIn(List<Integer> values) {
			addCriterion("num in", values, "num");
			return (Criteria) this;
		}

		public Criteria andNumNotIn(List<Integer> values) {
			addCriterion("num not in", values, "num");
			return (Criteria) this;
		}

		public Criteria andNumBetween(Integer value1, Integer value2) {
			addCriterion("num between", value1, value2, "num");
			return (Criteria) this;
		}

		public Criteria andNumNotBetween(Integer value1, Integer value2) {
			addCriterion("num not between", value1, value2, "num");
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