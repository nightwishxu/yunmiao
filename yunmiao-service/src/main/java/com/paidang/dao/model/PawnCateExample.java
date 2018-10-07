package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class PawnCateExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PawnCateExample(){
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

		public Criteria andIconIsNull() {
			addCriterion("icon is null");
			return (Criteria) this;
		}

		public Criteria andIconIsNotNull() {
			addCriterion("icon is not null");
			return (Criteria) this;
		}

		public Criteria andIconEqualTo(String value) {
			addCriterion("icon =", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconNotEqualTo(String value) {
			addCriterion("icon <>", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconGreaterThan(String value) {
			addCriterion("icon >", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconGreaterThanOrEqualTo(String value) {
			addCriterion("icon >=", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconLessThan(String value) {
			addCriterion("icon <", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconLessThanOrEqualTo(String value) {
			addCriterion("icon <=", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconLike(String value) {
			addCriterion("icon like", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconNotLike(String value) {
			addCriterion("icon not like", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconIn(List<String> values) {
			addCriterion("icon in", values, "icon");
			return (Criteria) this;
		}

		public Criteria andIconNotIn(List<String> values) {
			addCriterion("icon not in", values, "icon");
			return (Criteria) this;
		}

		public Criteria andIconBetween(String value1, String value2) {
			addCriterion("icon between", value1, value2, "icon");
			return (Criteria) this;
		}

		public Criteria andIconNotBetween(String value1, String value2) {
			addCriterion("icon not between", value1, value2, "icon");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andCateTypeIsNull() {
			addCriterion("cate_type is null");
			return (Criteria) this;
		}

		public Criteria andCateTypeIsNotNull() {
			addCriterion("cate_type is not null");
			return (Criteria) this;
		}

		public Criteria andCateTypeEqualTo(String value) {
			addCriterion("cate_type =", value, "cateType");
			return (Criteria) this;
		}

		public Criteria andCateTypeNotEqualTo(String value) {
			addCriterion("cate_type <>", value, "cateType");
			return (Criteria) this;
		}

		public Criteria andCateTypeGreaterThan(String value) {
			addCriterion("cate_type >", value, "cateType");
			return (Criteria) this;
		}

		public Criteria andCateTypeGreaterThanOrEqualTo(String value) {
			addCriterion("cate_type >=", value, "cateType");
			return (Criteria) this;
		}

		public Criteria andCateTypeLessThan(String value) {
			addCriterion("cate_type <", value, "cateType");
			return (Criteria) this;
		}

		public Criteria andCateTypeLessThanOrEqualTo(String value) {
			addCriterion("cate_type <=", value, "cateType");
			return (Criteria) this;
		}

		public Criteria andCateTypeLike(String value) {
			addCriterion("cate_type like", value, "cateType");
			return (Criteria) this;
		}

		public Criteria andCateTypeNotLike(String value) {
			addCriterion("cate_type not like", value, "cateType");
			return (Criteria) this;
		}

		public Criteria andCateTypeIn(List<String> values) {
			addCriterion("cate_type in", values, "cateType");
			return (Criteria) this;
		}

		public Criteria andCateTypeNotIn(List<String> values) {
			addCriterion("cate_type not in", values, "cateType");
			return (Criteria) this;
		}

		public Criteria andCateTypeBetween(String value1, String value2) {
			addCriterion("cate_type between", value1, value2, "cateType");
			return (Criteria) this;
		}

		public Criteria andCateTypeNotBetween(String value1, String value2) {
			addCriterion("cate_type not between", value1, value2, "cateType");
			return (Criteria) this;
		}

		public Criteria andSortOrderIsNull() {
			addCriterion("sort_order is null");
			return (Criteria) this;
		}

		public Criteria andSortOrderIsNotNull() {
			addCriterion("sort_order is not null");
			return (Criteria) this;
		}

		public Criteria andSortOrderEqualTo(Integer value) {
			addCriterion("sort_order =", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderNotEqualTo(Integer value) {
			addCriterion("sort_order <>", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderGreaterThan(Integer value) {
			addCriterion("sort_order >", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
			addCriterion("sort_order >=", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderLessThan(Integer value) {
			addCriterion("sort_order <", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderLessThanOrEqualTo(Integer value) {
			addCriterion("sort_order <=", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderIn(List<Integer> values) {
			addCriterion("sort_order in", values, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderNotIn(List<Integer> values) {
			addCriterion("sort_order not in", values, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderBetween(Integer value1, Integer value2) {
			addCriterion("sort_order between", value1, value2, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
			addCriterion("sort_order not between", value1, value2, "sortOrder");
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