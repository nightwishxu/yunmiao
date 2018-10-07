package com.item.dao.model;

import java.util.List;
import java.util.ArrayList;

public class WxUserInfoExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public WxUserInfoExample(){
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

		public Criteria andFollowCountIsNull() {
			addCriterion("follow_count is null");
			return (Criteria) this;
		}

		public Criteria andFollowCountIsNotNull() {
			addCriterion("follow_count is not null");
			return (Criteria) this;
		}

		public Criteria andFollowCountEqualTo(Integer value) {
			addCriterion("follow_count =", value, "followCount");
			return (Criteria) this;
		}

		public Criteria andFollowCountNotEqualTo(Integer value) {
			addCriterion("follow_count <>", value, "followCount");
			return (Criteria) this;
		}

		public Criteria andFollowCountGreaterThan(Integer value) {
			addCriterion("follow_count >", value, "followCount");
			return (Criteria) this;
		}

		public Criteria andFollowCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("follow_count >=", value, "followCount");
			return (Criteria) this;
		}

		public Criteria andFollowCountLessThan(Integer value) {
			addCriterion("follow_count <", value, "followCount");
			return (Criteria) this;
		}

		public Criteria andFollowCountLessThanOrEqualTo(Integer value) {
			addCriterion("follow_count <=", value, "followCount");
			return (Criteria) this;
		}

		public Criteria andFollowCountIn(List<Integer> values) {
			addCriterion("follow_count in", values, "followCount");
			return (Criteria) this;
		}

		public Criteria andFollowCountNotIn(List<Integer> values) {
			addCriterion("follow_count not in", values, "followCount");
			return (Criteria) this;
		}

		public Criteria andFollowCountBetween(Integer value1, Integer value2) {
			addCriterion("follow_count between", value1, value2, "followCount");
			return (Criteria) this;
		}

		public Criteria andFollowCountNotBetween(Integer value1, Integer value2) {
			addCriterion("follow_count not between", value1, value2, "followCount");
			return (Criteria) this;
		}

		public Criteria andFansCountIsNull() {
			addCriterion("fans_count is null");
			return (Criteria) this;
		}

		public Criteria andFansCountIsNotNull() {
			addCriterion("fans_count is not null");
			return (Criteria) this;
		}

		public Criteria andFansCountEqualTo(Integer value) {
			addCriterion("fans_count =", value, "fansCount");
			return (Criteria) this;
		}

		public Criteria andFansCountNotEqualTo(Integer value) {
			addCriterion("fans_count <>", value, "fansCount");
			return (Criteria) this;
		}

		public Criteria andFansCountGreaterThan(Integer value) {
			addCriterion("fans_count >", value, "fansCount");
			return (Criteria) this;
		}

		public Criteria andFansCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("fans_count >=", value, "fansCount");
			return (Criteria) this;
		}

		public Criteria andFansCountLessThan(Integer value) {
			addCriterion("fans_count <", value, "fansCount");
			return (Criteria) this;
		}

		public Criteria andFansCountLessThanOrEqualTo(Integer value) {
			addCriterion("fans_count <=", value, "fansCount");
			return (Criteria) this;
		}

		public Criteria andFansCountIn(List<Integer> values) {
			addCriterion("fans_count in", values, "fansCount");
			return (Criteria) this;
		}

		public Criteria andFansCountNotIn(List<Integer> values) {
			addCriterion("fans_count not in", values, "fansCount");
			return (Criteria) this;
		}

		public Criteria andFansCountBetween(Integer value1, Integer value2) {
			addCriterion("fans_count between", value1, value2, "fansCount");
			return (Criteria) this;
		}

		public Criteria andFansCountNotBetween(Integer value1, Integer value2) {
			addCriterion("fans_count not between", value1, value2, "fansCount");
			return (Criteria) this;
		}

		public Criteria andArticleCountIsNull() {
			addCriterion("article_count is null");
			return (Criteria) this;
		}

		public Criteria andArticleCountIsNotNull() {
			addCriterion("article_count is not null");
			return (Criteria) this;
		}

		public Criteria andArticleCountEqualTo(Integer value) {
			addCriterion("article_count =", value, "articleCount");
			return (Criteria) this;
		}

		public Criteria andArticleCountNotEqualTo(Integer value) {
			addCriterion("article_count <>", value, "articleCount");
			return (Criteria) this;
		}

		public Criteria andArticleCountGreaterThan(Integer value) {
			addCriterion("article_count >", value, "articleCount");
			return (Criteria) this;
		}

		public Criteria andArticleCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("article_count >=", value, "articleCount");
			return (Criteria) this;
		}

		public Criteria andArticleCountLessThan(Integer value) {
			addCriterion("article_count <", value, "articleCount");
			return (Criteria) this;
		}

		public Criteria andArticleCountLessThanOrEqualTo(Integer value) {
			addCriterion("article_count <=", value, "articleCount");
			return (Criteria) this;
		}

		public Criteria andArticleCountIn(List<Integer> values) {
			addCriterion("article_count in", values, "articleCount");
			return (Criteria) this;
		}

		public Criteria andArticleCountNotIn(List<Integer> values) {
			addCriterion("article_count not in", values, "articleCount");
			return (Criteria) this;
		}

		public Criteria andArticleCountBetween(Integer value1, Integer value2) {
			addCriterion("article_count between", value1, value2, "articleCount");
			return (Criteria) this;
		}

		public Criteria andArticleCountNotBetween(Integer value1, Integer value2) {
			addCriterion("article_count not between", value1, value2, "articleCount");
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