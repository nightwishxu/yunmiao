package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class VideoOnlineExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public VideoOnlineExample(){
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

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
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

		public Criteria andVideoIsNull() {
			addCriterion("video is null");
			return (Criteria) this;
		}

		public Criteria andVideoIsNotNull() {
			addCriterion("video is not null");
			return (Criteria) this;
		}

		public Criteria andVideoEqualTo(String value) {
			addCriterion("video =", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoNotEqualTo(String value) {
			addCriterion("video <>", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoGreaterThan(String value) {
			addCriterion("video >", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoGreaterThanOrEqualTo(String value) {
			addCriterion("video >=", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoLessThan(String value) {
			addCriterion("video <", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoLessThanOrEqualTo(String value) {
			addCriterion("video <=", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoLike(String value) {
			addCriterion("video like", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoNotLike(String value) {
			addCriterion("video not like", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoIn(List<String> values) {
			addCriterion("video in", values, "video");
			return (Criteria) this;
		}

		public Criteria andVideoNotIn(List<String> values) {
			addCriterion("video not in", values, "video");
			return (Criteria) this;
		}

		public Criteria andVideoBetween(String value1, String value2) {
			addCriterion("video between", value1, value2, "video");
			return (Criteria) this;
		}

		public Criteria andVideoNotBetween(String value1, String value2) {
			addCriterion("video not between", value1, value2, "video");
			return (Criteria) this;
		}

		public Criteria andViewCntIsNull() {
			addCriterion("view_cnt is null");
			return (Criteria) this;
		}

		public Criteria andViewCntIsNotNull() {
			addCriterion("view_cnt is not null");
			return (Criteria) this;
		}

		public Criteria andViewCntEqualTo(Integer value) {
			addCriterion("view_cnt =", value, "viewCnt");
			return (Criteria) this;
		}

		public Criteria andViewCntNotEqualTo(Integer value) {
			addCriterion("view_cnt <>", value, "viewCnt");
			return (Criteria) this;
		}

		public Criteria andViewCntGreaterThan(Integer value) {
			addCriterion("view_cnt >", value, "viewCnt");
			return (Criteria) this;
		}

		public Criteria andViewCntGreaterThanOrEqualTo(Integer value) {
			addCriterion("view_cnt >=", value, "viewCnt");
			return (Criteria) this;
		}

		public Criteria andViewCntLessThan(Integer value) {
			addCriterion("view_cnt <", value, "viewCnt");
			return (Criteria) this;
		}

		public Criteria andViewCntLessThanOrEqualTo(Integer value) {
			addCriterion("view_cnt <=", value, "viewCnt");
			return (Criteria) this;
		}

		public Criteria andViewCntIn(List<Integer> values) {
			addCriterion("view_cnt in", values, "viewCnt");
			return (Criteria) this;
		}

		public Criteria andViewCntNotIn(List<Integer> values) {
			addCriterion("view_cnt not in", values, "viewCnt");
			return (Criteria) this;
		}

		public Criteria andViewCntBetween(Integer value1, Integer value2) {
			addCriterion("view_cnt between", value1, value2, "viewCnt");
			return (Criteria) this;
		}

		public Criteria andViewCntNotBetween(Integer value1, Integer value2) {
			addCriterion("view_cnt not between", value1, value2, "viewCnt");
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

		public Criteria andIsSuggestIsNull() {
			addCriterion("is_suggest is null");
			return (Criteria) this;
		}

		public Criteria andIsSuggestIsNotNull() {
			addCriterion("is_suggest is not null");
			return (Criteria) this;
		}

		public Criteria andIsSuggestEqualTo(Integer value) {
			addCriterion("is_suggest =", value, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestNotEqualTo(Integer value) {
			addCriterion("is_suggest <>", value, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestGreaterThan(Integer value) {
			addCriterion("is_suggest >", value, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_suggest >=", value, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestLessThan(Integer value) {
			addCriterion("is_suggest <", value, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestLessThanOrEqualTo(Integer value) {
			addCriterion("is_suggest <=", value, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestIn(List<Integer> values) {
			addCriterion("is_suggest in", values, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestNotIn(List<Integer> values) {
			addCriterion("is_suggest not in", values, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestBetween(Integer value1, Integer value2) {
			addCriterion("is_suggest between", value1, value2, "isSuggest");
			return (Criteria) this;
		}

		public Criteria andIsSuggestNotBetween(Integer value1, Integer value2) {
			addCriterion("is_suggest not between", value1, value2, "isSuggest");
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