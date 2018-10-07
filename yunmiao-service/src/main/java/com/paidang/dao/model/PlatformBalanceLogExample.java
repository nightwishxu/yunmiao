package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class PlatformBalanceLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PlatformBalanceLogExample(){
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

		public Criteria andAmountIsNull() {
			addCriterion("amount is null");
			return (Criteria) this;
		}

		public Criteria andAmountIsNotNull() {
			addCriterion("amount is not null");
			return (Criteria) this;
		}

		public Criteria andAmountEqualTo(java.math.BigDecimal value) {
			addCriterion("amount =", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotEqualTo(java.math.BigDecimal value) {
			addCriterion("amount <>", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountGreaterThan(java.math.BigDecimal value) {
			addCriterion("amount >", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("amount >=", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountLessThan(java.math.BigDecimal value) {
			addCriterion("amount <", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("amount <=", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountIn(List<java.math.BigDecimal> values) {
			addCriterion("amount in", values, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotIn(List<java.math.BigDecimal> values) {
			addCriterion("amount not in", values, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("amount between", value1, value2, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("amount not between", value1, value2, "amount");
			return (Criteria) this;
		}

		public Criteria andItemIsNull() {
			addCriterion("item is null");
			return (Criteria) this;
		}

		public Criteria andItemIsNotNull() {
			addCriterion("item is not null");
			return (Criteria) this;
		}

		public Criteria andItemEqualTo(String value) {
			addCriterion("item =", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemNotEqualTo(String value) {
			addCriterion("item <>", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemGreaterThan(String value) {
			addCriterion("item >", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemGreaterThanOrEqualTo(String value) {
			addCriterion("item >=", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemLessThan(String value) {
			addCriterion("item <", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemLessThanOrEqualTo(String value) {
			addCriterion("item <=", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemLike(String value) {
			addCriterion("item like", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemNotLike(String value) {
			addCriterion("item not like", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemIn(List<String> values) {
			addCriterion("item in", values, "item");
			return (Criteria) this;
		}

		public Criteria andItemNotIn(List<String> values) {
			addCriterion("item not in", values, "item");
			return (Criteria) this;
		}

		public Criteria andItemBetween(String value1, String value2) {
			addCriterion("item between", value1, value2, "item");
			return (Criteria) this;
		}

		public Criteria andItemNotBetween(String value1, String value2) {
			addCriterion("item not between", value1, value2, "item");
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

		public Criteria andPayLogIdIsNull() {
			addCriterion("pay_log_id is null");
			return (Criteria) this;
		}

		public Criteria andPayLogIdIsNotNull() {
			addCriterion("pay_log_id is not null");
			return (Criteria) this;
		}

		public Criteria andPayLogIdEqualTo(Long value) {
			addCriterion("pay_log_id =", value, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdNotEqualTo(Long value) {
			addCriterion("pay_log_id <>", value, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdGreaterThan(Long value) {
			addCriterion("pay_log_id >", value, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdGreaterThanOrEqualTo(Long value) {
			addCriterion("pay_log_id >=", value, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdLessThan(Long value) {
			addCriterion("pay_log_id <", value, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdLessThanOrEqualTo(Long value) {
			addCriterion("pay_log_id <=", value, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdIn(List<Long> values) {
			addCriterion("pay_log_id in", values, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdNotIn(List<Long> values) {
			addCriterion("pay_log_id not in", values, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdBetween(Long value1, Long value2) {
			addCriterion("pay_log_id between", value1, value2, "payLogId");
			return (Criteria) this;
		}

		public Criteria andPayLogIdNotBetween(Long value1, Long value2) {
			addCriterion("pay_log_id not between", value1, value2, "payLogId");
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