package com.item.dao.model;

import java.util.List;
import java.util.ArrayList;

public class UserOptionExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserOptionExample(){
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

		public Criteria andProcessStateIsNull() {
			addCriterion("process_state is null");
			return (Criteria) this;
		}

		public Criteria andProcessStateIsNotNull() {
			addCriterion("process_state is not null");
			return (Criteria) this;
		}

		public Criteria andProcessStateEqualTo(Integer value) {
			addCriterion("process_state =", value, "processState");
			return (Criteria) this;
		}

		public Criteria andProcessStateNotEqualTo(Integer value) {
			addCriterion("process_state <>", value, "processState");
			return (Criteria) this;
		}

		public Criteria andProcessStateGreaterThan(Integer value) {
			addCriterion("process_state >", value, "processState");
			return (Criteria) this;
		}

		public Criteria andProcessStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("process_state >=", value, "processState");
			return (Criteria) this;
		}

		public Criteria andProcessStateLessThan(Integer value) {
			addCriterion("process_state <", value, "processState");
			return (Criteria) this;
		}

		public Criteria andProcessStateLessThanOrEqualTo(Integer value) {
			addCriterion("process_state <=", value, "processState");
			return (Criteria) this;
		}

		public Criteria andProcessStateIn(List<Integer> values) {
			addCriterion("process_state in", values, "processState");
			return (Criteria) this;
		}

		public Criteria andProcessStateNotIn(List<Integer> values) {
			addCriterion("process_state not in", values, "processState");
			return (Criteria) this;
		}

		public Criteria andProcessStateBetween(Integer value1, Integer value2) {
			addCriterion("process_state between", value1, value2, "processState");
			return (Criteria) this;
		}

		public Criteria andProcessStateNotBetween(Integer value1, Integer value2) {
			addCriterion("process_state not between", value1, value2, "processState");
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

		public Criteria andReplyInfoIsNull() {
			addCriterion("reply_info is null");
			return (Criteria) this;
		}

		public Criteria andReplyInfoIsNotNull() {
			addCriterion("reply_info is not null");
			return (Criteria) this;
		}

		public Criteria andReplyInfoEqualTo(String value) {
			addCriterion("reply_info =", value, "replyInfo");
			return (Criteria) this;
		}

		public Criteria andReplyInfoNotEqualTo(String value) {
			addCriterion("reply_info <>", value, "replyInfo");
			return (Criteria) this;
		}

		public Criteria andReplyInfoGreaterThan(String value) {
			addCriterion("reply_info >", value, "replyInfo");
			return (Criteria) this;
		}

		public Criteria andReplyInfoGreaterThanOrEqualTo(String value) {
			addCriterion("reply_info >=", value, "replyInfo");
			return (Criteria) this;
		}

		public Criteria andReplyInfoLessThan(String value) {
			addCriterion("reply_info <", value, "replyInfo");
			return (Criteria) this;
		}

		public Criteria andReplyInfoLessThanOrEqualTo(String value) {
			addCriterion("reply_info <=", value, "replyInfo");
			return (Criteria) this;
		}

		public Criteria andReplyInfoLike(String value) {
			addCriterion("reply_info like", value, "replyInfo");
			return (Criteria) this;
		}

		public Criteria andReplyInfoNotLike(String value) {
			addCriterion("reply_info not like", value, "replyInfo");
			return (Criteria) this;
		}

		public Criteria andReplyInfoIn(List<String> values) {
			addCriterion("reply_info in", values, "replyInfo");
			return (Criteria) this;
		}

		public Criteria andReplyInfoNotIn(List<String> values) {
			addCriterion("reply_info not in", values, "replyInfo");
			return (Criteria) this;
		}

		public Criteria andReplyInfoBetween(String value1, String value2) {
			addCriterion("reply_info between", value1, value2, "replyInfo");
			return (Criteria) this;
		}

		public Criteria andReplyInfoNotBetween(String value1, String value2) {
			addCriterion("reply_info not between", value1, value2, "replyInfo");
			return (Criteria) this;
		}

		public Criteria andReplyTimeIsNull() {
			addCriterion("reply_time is null");
			return (Criteria) this;
		}

		public Criteria andReplyTimeIsNotNull() {
			addCriterion("reply_time is not null");
			return (Criteria) this;
		}

		public Criteria andReplyTimeEqualTo(java.util.Date value) {
			addCriterion("reply_time =", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeNotEqualTo(java.util.Date value) {
			addCriterion("reply_time <>", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeGreaterThan(java.util.Date value) {
			addCriterion("reply_time >", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("reply_time >=", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeLessThan(java.util.Date value) {
			addCriterion("reply_time <", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("reply_time <=", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeIn(List<java.util.Date> values) {
			addCriterion("reply_time in", values, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeNotIn(List<java.util.Date> values) {
			addCriterion("reply_time not in", values, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("reply_time between", value1, value2, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("reply_time not between", value1, value2, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyAccountIsNull() {
			addCriterion("reply_account is null");
			return (Criteria) this;
		}

		public Criteria andReplyAccountIsNotNull() {
			addCriterion("reply_account is not null");
			return (Criteria) this;
		}

		public Criteria andReplyAccountEqualTo(Integer value) {
			addCriterion("reply_account =", value, "replyAccount");
			return (Criteria) this;
		}

		public Criteria andReplyAccountNotEqualTo(Integer value) {
			addCriterion("reply_account <>", value, "replyAccount");
			return (Criteria) this;
		}

		public Criteria andReplyAccountGreaterThan(Integer value) {
			addCriterion("reply_account >", value, "replyAccount");
			return (Criteria) this;
		}

		public Criteria andReplyAccountGreaterThanOrEqualTo(Integer value) {
			addCriterion("reply_account >=", value, "replyAccount");
			return (Criteria) this;
		}

		public Criteria andReplyAccountLessThan(Integer value) {
			addCriterion("reply_account <", value, "replyAccount");
			return (Criteria) this;
		}

		public Criteria andReplyAccountLessThanOrEqualTo(Integer value) {
			addCriterion("reply_account <=", value, "replyAccount");
			return (Criteria) this;
		}

		public Criteria andReplyAccountIn(List<Integer> values) {
			addCriterion("reply_account in", values, "replyAccount");
			return (Criteria) this;
		}

		public Criteria andReplyAccountNotIn(List<Integer> values) {
			addCriterion("reply_account not in", values, "replyAccount");
			return (Criteria) this;
		}

		public Criteria andReplyAccountBetween(Integer value1, Integer value2) {
			addCriterion("reply_account between", value1, value2, "replyAccount");
			return (Criteria) this;
		}

		public Criteria andReplyAccountNotBetween(Integer value1, Integer value2) {
			addCriterion("reply_account not between", value1, value2, "replyAccount");
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