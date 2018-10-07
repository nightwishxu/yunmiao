package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class CouponExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CouponExample(){
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

		public Criteria andDaysIsNull() {
			addCriterion("days is null");
			return (Criteria) this;
		}

		public Criteria andDaysIsNotNull() {
			addCriterion("days is not null");
			return (Criteria) this;
		}

		public Criteria andDaysEqualTo(Integer value) {
			addCriterion("days =", value, "days");
			return (Criteria) this;
		}

		public Criteria andDaysNotEqualTo(Integer value) {
			addCriterion("days <>", value, "days");
			return (Criteria) this;
		}

		public Criteria andDaysGreaterThan(Integer value) {
			addCriterion("days >", value, "days");
			return (Criteria) this;
		}

		public Criteria andDaysGreaterThanOrEqualTo(Integer value) {
			addCriterion("days >=", value, "days");
			return (Criteria) this;
		}

		public Criteria andDaysLessThan(Integer value) {
			addCriterion("days <", value, "days");
			return (Criteria) this;
		}

		public Criteria andDaysLessThanOrEqualTo(Integer value) {
			addCriterion("days <=", value, "days");
			return (Criteria) this;
		}

		public Criteria andDaysIn(List<Integer> values) {
			addCriterion("days in", values, "days");
			return (Criteria) this;
		}

		public Criteria andDaysNotIn(List<Integer> values) {
			addCriterion("days not in", values, "days");
			return (Criteria) this;
		}

		public Criteria andDaysBetween(Integer value1, Integer value2) {
			addCriterion("days between", value1, value2, "days");
			return (Criteria) this;
		}

		public Criteria andDaysNotBetween(Integer value1, Integer value2) {
			addCriterion("days not between", value1, value2, "days");
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