package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class CertificateLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CertificateLogExample(){
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

		public Criteria andCertificateIdIsNull() {
			addCriterion("certificate_id is null");
			return (Criteria) this;
		}

		public Criteria andCertificateIdIsNotNull() {
			addCriterion("certificate_id is not null");
			return (Criteria) this;
		}

		public Criteria andCertificateIdEqualTo(Integer value) {
			addCriterion("certificate_id =", value, "certificateId");
			return (Criteria) this;
		}

		public Criteria andCertificateIdNotEqualTo(Integer value) {
			addCriterion("certificate_id <>", value, "certificateId");
			return (Criteria) this;
		}

		public Criteria andCertificateIdGreaterThan(Integer value) {
			addCriterion("certificate_id >", value, "certificateId");
			return (Criteria) this;
		}

		public Criteria andCertificateIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("certificate_id >=", value, "certificateId");
			return (Criteria) this;
		}

		public Criteria andCertificateIdLessThan(Integer value) {
			addCriterion("certificate_id <", value, "certificateId");
			return (Criteria) this;
		}

		public Criteria andCertificateIdLessThanOrEqualTo(Integer value) {
			addCriterion("certificate_id <=", value, "certificateId");
			return (Criteria) this;
		}

		public Criteria andCertificateIdIn(List<Integer> values) {
			addCriterion("certificate_id in", values, "certificateId");
			return (Criteria) this;
		}

		public Criteria andCertificateIdNotIn(List<Integer> values) {
			addCriterion("certificate_id not in", values, "certificateId");
			return (Criteria) this;
		}

		public Criteria andCertificateIdBetween(Integer value1, Integer value2) {
			addCriterion("certificate_id between", value1, value2, "certificateId");
			return (Criteria) this;
		}

		public Criteria andCertificateIdNotBetween(Integer value1, Integer value2) {
			addCriterion("certificate_id not between", value1, value2, "certificateId");
			return (Criteria) this;
		}

		public Criteria andLogTimeIsNull() {
			addCriterion("log_time is null");
			return (Criteria) this;
		}

		public Criteria andLogTimeIsNotNull() {
			addCriterion("log_time is not null");
			return (Criteria) this;
		}

		public Criteria andLogTimeEqualTo(java.util.Date value) {
			addCriterion("log_time =", value, "logTime");
			return (Criteria) this;
		}

		public Criteria andLogTimeNotEqualTo(java.util.Date value) {
			addCriterion("log_time <>", value, "logTime");
			return (Criteria) this;
		}

		public Criteria andLogTimeGreaterThan(java.util.Date value) {
			addCriterion("log_time >", value, "logTime");
			return (Criteria) this;
		}

		public Criteria andLogTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("log_time >=", value, "logTime");
			return (Criteria) this;
		}

		public Criteria andLogTimeLessThan(java.util.Date value) {
			addCriterion("log_time <", value, "logTime");
			return (Criteria) this;
		}

		public Criteria andLogTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("log_time <=", value, "logTime");
			return (Criteria) this;
		}

		public Criteria andLogTimeIn(List<java.util.Date> values) {
			addCriterion("log_time in", values, "logTime");
			return (Criteria) this;
		}

		public Criteria andLogTimeNotIn(List<java.util.Date> values) {
			addCriterion("log_time not in", values, "logTime");
			return (Criteria) this;
		}

		public Criteria andLogTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("log_time between", value1, value2, "logTime");
			return (Criteria) this;
		}

		public Criteria andLogTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("log_time not between", value1, value2, "logTime");
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