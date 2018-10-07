package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class UserCouponExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserCouponExample(){
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

		public Criteria andFullIsNull() {
			addCriterion("full is null");
			return (Criteria) this;
		}

		public Criteria andFullIsNotNull() {
			addCriterion("full is not null");
			return (Criteria) this;
		}

		public Criteria andFullEqualTo(java.math.BigDecimal value) {
			addCriterion("full =", value, "full");
			return (Criteria) this;
		}

		public Criteria andFullNotEqualTo(java.math.BigDecimal value) {
			addCriterion("full <>", value, "full");
			return (Criteria) this;
		}

		public Criteria andFullGreaterThan(java.math.BigDecimal value) {
			addCriterion("full >", value, "full");
			return (Criteria) this;
		}

		public Criteria andFullGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("full >=", value, "full");
			return (Criteria) this;
		}

		public Criteria andFullLessThan(java.math.BigDecimal value) {
			addCriterion("full <", value, "full");
			return (Criteria) this;
		}

		public Criteria andFullLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("full <=", value, "full");
			return (Criteria) this;
		}

		public Criteria andFullIn(List<java.math.BigDecimal> values) {
			addCriterion("full in", values, "full");
			return (Criteria) this;
		}

		public Criteria andFullNotIn(List<java.math.BigDecimal> values) {
			addCriterion("full not in", values, "full");
			return (Criteria) this;
		}

		public Criteria andFullBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("full between", value1, value2, "full");
			return (Criteria) this;
		}

		public Criteria andFullNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("full not between", value1, value2, "full");
			return (Criteria) this;
		}

		public Criteria andValueIsNull() {
			addCriterion("value is null");
			return (Criteria) this;
		}

		public Criteria andValueIsNotNull() {
			addCriterion("value is not null");
			return (Criteria) this;
		}

		public Criteria andValueEqualTo(java.math.BigDecimal value) {
			addCriterion("value =", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotEqualTo(java.math.BigDecimal value) {
			addCriterion("value <>", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThan(java.math.BigDecimal value) {
			addCriterion("value >", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("value >=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThan(java.math.BigDecimal value) {
			addCriterion("value <", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("value <=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueIn(List<java.math.BigDecimal> values) {
			addCriterion("value in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotIn(List<java.math.BigDecimal> values) {
			addCriterion("value not in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("value between", value1, value2, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("value not between", value1, value2, "value");
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

		public Criteria andEndTimeIsNull() {
			addCriterion("end_time is null");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("end_time is not null");
			return (Criteria) this;
		}

		public Criteria andEndTimeEqualTo(java.util.Date value) {
			addCriterion("end_time =", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotEqualTo(java.util.Date value) {
			addCriterion("end_time <>", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThan(java.util.Date value) {
			addCriterion("end_time >", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("end_time >=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThan(java.util.Date value) {
			addCriterion("end_time <", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("end_time <=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIn(List<java.util.Date> values) {
			addCriterion("end_time in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotIn(List<java.util.Date> values) {
			addCriterion("end_time not in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("end_time between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("end_time not between", value1, value2, "endTime");
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

		public Criteria andUseTimeIsNull() {
			addCriterion("use_time is null");
			return (Criteria) this;
		}

		public Criteria andUseTimeIsNotNull() {
			addCriterion("use_time is not null");
			return (Criteria) this;
		}

		public Criteria andUseTimeEqualTo(java.util.Date value) {
			addCriterion("use_time =", value, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeNotEqualTo(java.util.Date value) {
			addCriterion("use_time <>", value, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeGreaterThan(java.util.Date value) {
			addCriterion("use_time >", value, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("use_time >=", value, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeLessThan(java.util.Date value) {
			addCriterion("use_time <", value, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("use_time <=", value, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeIn(List<java.util.Date> values) {
			addCriterion("use_time in", values, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeNotIn(List<java.util.Date> values) {
			addCriterion("use_time not in", values, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("use_time between", value1, value2, "useTime");
			return (Criteria) this;
		}

		public Criteria andUseTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("use_time not between", value1, value2, "useTime");
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

		public Criteria andFidIsNull() {
			addCriterion("fid is null");
			return (Criteria) this;
		}

		public Criteria andFidIsNotNull() {
			addCriterion("fid is not null");
			return (Criteria) this;
		}

		public Criteria andFidEqualTo(Integer value) {
			addCriterion("fid =", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidNotEqualTo(Integer value) {
			addCriterion("fid <>", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidGreaterThan(Integer value) {
			addCriterion("fid >", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidGreaterThanOrEqualTo(Integer value) {
			addCriterion("fid >=", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidLessThan(Integer value) {
			addCriterion("fid <", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidLessThanOrEqualTo(Integer value) {
			addCriterion("fid <=", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidIn(List<Integer> values) {
			addCriterion("fid in", values, "fid");
			return (Criteria) this;
		}

		public Criteria andFidNotIn(List<Integer> values) {
			addCriterion("fid not in", values, "fid");
			return (Criteria) this;
		}

		public Criteria andFidBetween(Integer value1, Integer value2) {
			addCriterion("fid between", value1, value2, "fid");
			return (Criteria) this;
		}

		public Criteria andFidNotBetween(Integer value1, Integer value2) {
			addCriterion("fid not between", value1, value2, "fid");
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