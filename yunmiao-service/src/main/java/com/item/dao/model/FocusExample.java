package com.item.dao.model;

import java.util.List;
import java.util.ArrayList;

public class FocusExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public FocusExample(){
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

		public Criteria andAreaCodeIsNull() {
			addCriterion("area_code is null");
			return (Criteria) this;
		}

		public Criteria andAreaCodeIsNotNull() {
			addCriterion("area_code is not null");
			return (Criteria) this;
		}

		public Criteria andAreaCodeEqualTo(String value) {
			addCriterion("area_code =", value, "areaCode");
			return (Criteria) this;
		}

		public Criteria andAreaCodeNotEqualTo(String value) {
			addCriterion("area_code <>", value, "areaCode");
			return (Criteria) this;
		}

		public Criteria andAreaCodeGreaterThan(String value) {
			addCriterion("area_code >", value, "areaCode");
			return (Criteria) this;
		}

		public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
			addCriterion("area_code >=", value, "areaCode");
			return (Criteria) this;
		}

		public Criteria andAreaCodeLessThan(String value) {
			addCriterion("area_code <", value, "areaCode");
			return (Criteria) this;
		}

		public Criteria andAreaCodeLessThanOrEqualTo(String value) {
			addCriterion("area_code <=", value, "areaCode");
			return (Criteria) this;
		}

		public Criteria andAreaCodeLike(String value) {
			addCriterion("area_code like", value, "areaCode");
			return (Criteria) this;
		}

		public Criteria andAreaCodeNotLike(String value) {
			addCriterion("area_code not like", value, "areaCode");
			return (Criteria) this;
		}

		public Criteria andAreaCodeIn(List<String> values) {
			addCriterion("area_code in", values, "areaCode");
			return (Criteria) this;
		}

		public Criteria andAreaCodeNotIn(List<String> values) {
			addCriterion("area_code not in", values, "areaCode");
			return (Criteria) this;
		}

		public Criteria andAreaCodeBetween(String value1, String value2) {
			addCriterion("area_code between", value1, value2, "areaCode");
			return (Criteria) this;
		}

		public Criteria andAreaCodeNotBetween(String value1, String value2) {
			addCriterion("area_code not between", value1, value2, "areaCode");
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

		public Criteria andLocationIsNull() {
			addCriterion("location is null");
			return (Criteria) this;
		}

		public Criteria andLocationIsNotNull() {
			addCriterion("location is not null");
			return (Criteria) this;
		}

		public Criteria andLocationEqualTo(Integer value) {
			addCriterion("location =", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotEqualTo(Integer value) {
			addCriterion("location <>", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThan(Integer value) {
			addCriterion("location >", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThanOrEqualTo(Integer value) {
			addCriterion("location >=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThan(Integer value) {
			addCriterion("location <", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThanOrEqualTo(Integer value) {
			addCriterion("location <=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationIn(List<Integer> values) {
			addCriterion("location in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotIn(List<Integer> values) {
			addCriterion("location not in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationBetween(Integer value1, Integer value2) {
			addCriterion("location between", value1, value2, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotBetween(Integer value1, Integer value2) {
			addCriterion("location not between", value1, value2, "location");
			return (Criteria) this;
		}

		public Criteria andRestraintIsNull() {
			addCriterion("restraint is null");
			return (Criteria) this;
		}

		public Criteria andRestraintIsNotNull() {
			addCriterion("restraint is not null");
			return (Criteria) this;
		}

		public Criteria andRestraintEqualTo(String value) {
			addCriterion("restraint =", value, "restraint");
			return (Criteria) this;
		}

		public Criteria andRestraintNotEqualTo(String value) {
			addCriterion("restraint <>", value, "restraint");
			return (Criteria) this;
		}

		public Criteria andRestraintGreaterThan(String value) {
			addCriterion("restraint >", value, "restraint");
			return (Criteria) this;
		}

		public Criteria andRestraintGreaterThanOrEqualTo(String value) {
			addCriterion("restraint >=", value, "restraint");
			return (Criteria) this;
		}

		public Criteria andRestraintLessThan(String value) {
			addCriterion("restraint <", value, "restraint");
			return (Criteria) this;
		}

		public Criteria andRestraintLessThanOrEqualTo(String value) {
			addCriterion("restraint <=", value, "restraint");
			return (Criteria) this;
		}

		public Criteria andRestraintLike(String value) {
			addCriterion("restraint like", value, "restraint");
			return (Criteria) this;
		}

		public Criteria andRestraintNotLike(String value) {
			addCriterion("restraint not like", value, "restraint");
			return (Criteria) this;
		}

		public Criteria andRestraintIn(List<String> values) {
			addCriterion("restraint in", values, "restraint");
			return (Criteria) this;
		}

		public Criteria andRestraintNotIn(List<String> values) {
			addCriterion("restraint not in", values, "restraint");
			return (Criteria) this;
		}

		public Criteria andRestraintBetween(String value1, String value2) {
			addCriterion("restraint between", value1, value2, "restraint");
			return (Criteria) this;
		}

		public Criteria andRestraintNotBetween(String value1, String value2) {
			addCriterion("restraint not between", value1, value2, "restraint");
			return (Criteria) this;
		}

		public Criteria andRedirectTypeIsNull() {
			addCriterion("redirect_type is null");
			return (Criteria) this;
		}

		public Criteria andRedirectTypeIsNotNull() {
			addCriterion("redirect_type is not null");
			return (Criteria) this;
		}

		public Criteria andRedirectTypeEqualTo(Integer value) {
			addCriterion("redirect_type =", value, "redirectType");
			return (Criteria) this;
		}

		public Criteria andRedirectTypeNotEqualTo(Integer value) {
			addCriterion("redirect_type <>", value, "redirectType");
			return (Criteria) this;
		}

		public Criteria andRedirectTypeGreaterThan(Integer value) {
			addCriterion("redirect_type >", value, "redirectType");
			return (Criteria) this;
		}

		public Criteria andRedirectTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("redirect_type >=", value, "redirectType");
			return (Criteria) this;
		}

		public Criteria andRedirectTypeLessThan(Integer value) {
			addCriterion("redirect_type <", value, "redirectType");
			return (Criteria) this;
		}

		public Criteria andRedirectTypeLessThanOrEqualTo(Integer value) {
			addCriterion("redirect_type <=", value, "redirectType");
			return (Criteria) this;
		}

		public Criteria andRedirectTypeIn(List<Integer> values) {
			addCriterion("redirect_type in", values, "redirectType");
			return (Criteria) this;
		}

		public Criteria andRedirectTypeNotIn(List<Integer> values) {
			addCriterion("redirect_type not in", values, "redirectType");
			return (Criteria) this;
		}

		public Criteria andRedirectTypeBetween(Integer value1, Integer value2) {
			addCriterion("redirect_type between", value1, value2, "redirectType");
			return (Criteria) this;
		}

		public Criteria andRedirectTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("redirect_type not between", value1, value2, "redirectType");
			return (Criteria) this;
		}

		public Criteria andRedirectContentIsNull() {
			addCriterion("redirect_content is null");
			return (Criteria) this;
		}

		public Criteria andRedirectContentIsNotNull() {
			addCriterion("redirect_content is not null");
			return (Criteria) this;
		}

		public Criteria andRedirectContentEqualTo(String value) {
			addCriterion("redirect_content =", value, "redirectContent");
			return (Criteria) this;
		}

		public Criteria andRedirectContentNotEqualTo(String value) {
			addCriterion("redirect_content <>", value, "redirectContent");
			return (Criteria) this;
		}

		public Criteria andRedirectContentGreaterThan(String value) {
			addCriterion("redirect_content >", value, "redirectContent");
			return (Criteria) this;
		}

		public Criteria andRedirectContentGreaterThanOrEqualTo(String value) {
			addCriterion("redirect_content >=", value, "redirectContent");
			return (Criteria) this;
		}

		public Criteria andRedirectContentLessThan(String value) {
			addCriterion("redirect_content <", value, "redirectContent");
			return (Criteria) this;
		}

		public Criteria andRedirectContentLessThanOrEqualTo(String value) {
			addCriterion("redirect_content <=", value, "redirectContent");
			return (Criteria) this;
		}

		public Criteria andRedirectContentLike(String value) {
			addCriterion("redirect_content like", value, "redirectContent");
			return (Criteria) this;
		}

		public Criteria andRedirectContentNotLike(String value) {
			addCriterion("redirect_content not like", value, "redirectContent");
			return (Criteria) this;
		}

		public Criteria andRedirectContentIn(List<String> values) {
			addCriterion("redirect_content in", values, "redirectContent");
			return (Criteria) this;
		}

		public Criteria andRedirectContentNotIn(List<String> values) {
			addCriterion("redirect_content not in", values, "redirectContent");
			return (Criteria) this;
		}

		public Criteria andRedirectContentBetween(String value1, String value2) {
			addCriterion("redirect_content between", value1, value2, "redirectContent");
			return (Criteria) this;
		}

		public Criteria andRedirectContentNotBetween(String value1, String value2) {
			addCriterion("redirect_content not between", value1, value2, "redirectContent");
			return (Criteria) this;
		}

		public Criteria andContentIsNull() {
			addCriterion("content is null");
			return (Criteria) this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("content is not null");
			return (Criteria) this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("content =", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("content <>", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("content >", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("content >=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("content <", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("content <=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("content like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("content not like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentIn(List<String> values) {
			addCriterion("content in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotIn(List<String> values) {
			addCriterion("content not in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("content between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("content not between", value1, value2, "content");
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