package com.item.dao.model;

import java.util.List;
import java.util.ArrayList;

public class SmsSendLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SmsSendLogExample(){
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

		public Criteria andPhoneIsNull() {
			addCriterion("phone is null");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNotNull() {
			addCriterion("phone is not null");
			return (Criteria) this;
		}

		public Criteria andPhoneEqualTo(String value) {
			addCriterion("phone =", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotEqualTo(String value) {
			addCriterion("phone <>", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThan(String value) {
			addCriterion("phone >", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("phone >=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThan(String value) {
			addCriterion("phone <", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThanOrEqualTo(String value) {
			addCriterion("phone <=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLike(String value) {
			addCriterion("phone like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotLike(String value) {
			addCriterion("phone not like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneIn(List<String> values) {
			addCriterion("phone in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotIn(List<String> values) {
			addCriterion("phone not in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneBetween(String value1, String value2) {
			addCriterion("phone between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotBetween(String value1, String value2) {
			addCriterion("phone not between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andDeviceIdIsNull() {
			addCriterion("device_id is null");
			return (Criteria) this;
		}

		public Criteria andDeviceIdIsNotNull() {
			addCriterion("device_id is not null");
			return (Criteria) this;
		}

		public Criteria andDeviceIdEqualTo(String value) {
			addCriterion("device_id =", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdNotEqualTo(String value) {
			addCriterion("device_id <>", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdGreaterThan(String value) {
			addCriterion("device_id >", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
			addCriterion("device_id >=", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdLessThan(String value) {
			addCriterion("device_id <", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdLessThanOrEqualTo(String value) {
			addCriterion("device_id <=", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdLike(String value) {
			addCriterion("device_id like", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdNotLike(String value) {
			addCriterion("device_id not like", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdIn(List<String> values) {
			addCriterion("device_id in", values, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdNotIn(List<String> values) {
			addCriterion("device_id not in", values, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdBetween(String value1, String value2) {
			addCriterion("device_id between", value1, value2, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdNotBetween(String value1, String value2) {
			addCriterion("device_id not between", value1, value2, "deviceId");
			return (Criteria) this;
		}

		public Criteria andIpIsNull() {
			addCriterion("ip is null");
			return (Criteria) this;
		}

		public Criteria andIpIsNotNull() {
			addCriterion("ip is not null");
			return (Criteria) this;
		}

		public Criteria andIpEqualTo(String value) {
			addCriterion("ip =", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotEqualTo(String value) {
			addCriterion("ip <>", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThan(String value) {
			addCriterion("ip >", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThanOrEqualTo(String value) {
			addCriterion("ip >=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThan(String value) {
			addCriterion("ip <", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThanOrEqualTo(String value) {
			addCriterion("ip <=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLike(String value) {
			addCriterion("ip like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotLike(String value) {
			addCriterion("ip not like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpIn(List<String> values) {
			addCriterion("ip in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotIn(List<String> values) {
			addCriterion("ip not in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpBetween(String value1, String value2) {
			addCriterion("ip between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotBetween(String value1, String value2) {
			addCriterion("ip not between", value1, value2, "ip");
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