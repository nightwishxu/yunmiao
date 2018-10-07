package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class DiamondExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public DiamondExample(){
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

		public Criteria andColorIsNull() {
			addCriterion("color is null");
			return (Criteria) this;
		}

		public Criteria andColorIsNotNull() {
			addCriterion("color is not null");
			return (Criteria) this;
		}

		public Criteria andColorEqualTo(String value) {
			addCriterion("color =", value, "color");
			return (Criteria) this;
		}

		public Criteria andColorNotEqualTo(String value) {
			addCriterion("color <>", value, "color");
			return (Criteria) this;
		}

		public Criteria andColorGreaterThan(String value) {
			addCriterion("color >", value, "color");
			return (Criteria) this;
		}

		public Criteria andColorGreaterThanOrEqualTo(String value) {
			addCriterion("color >=", value, "color");
			return (Criteria) this;
		}

		public Criteria andColorLessThan(String value) {
			addCriterion("color <", value, "color");
			return (Criteria) this;
		}

		public Criteria andColorLessThanOrEqualTo(String value) {
			addCriterion("color <=", value, "color");
			return (Criteria) this;
		}

		public Criteria andColorLike(String value) {
			addCriterion("color like", value, "color");
			return (Criteria) this;
		}

		public Criteria andColorNotLike(String value) {
			addCriterion("color not like", value, "color");
			return (Criteria) this;
		}

		public Criteria andColorIn(List<String> values) {
			addCriterion("color in", values, "color");
			return (Criteria) this;
		}

		public Criteria andColorNotIn(List<String> values) {
			addCriterion("color not in", values, "color");
			return (Criteria) this;
		}

		public Criteria andColorBetween(String value1, String value2) {
			addCriterion("color between", value1, value2, "color");
			return (Criteria) this;
		}

		public Criteria andColorNotBetween(String value1, String value2) {
			addCriterion("color not between", value1, value2, "color");
			return (Criteria) this;
		}

		public Criteria andLightIsNull() {
			addCriterion("light is null");
			return (Criteria) this;
		}

		public Criteria andLightIsNotNull() {
			addCriterion("light is not null");
			return (Criteria) this;
		}

		public Criteria andLightEqualTo(String value) {
			addCriterion("light =", value, "light");
			return (Criteria) this;
		}

		public Criteria andLightNotEqualTo(String value) {
			addCriterion("light <>", value, "light");
			return (Criteria) this;
		}

		public Criteria andLightGreaterThan(String value) {
			addCriterion("light >", value, "light");
			return (Criteria) this;
		}

		public Criteria andLightGreaterThanOrEqualTo(String value) {
			addCriterion("light >=", value, "light");
			return (Criteria) this;
		}

		public Criteria andLightLessThan(String value) {
			addCriterion("light <", value, "light");
			return (Criteria) this;
		}

		public Criteria andLightLessThanOrEqualTo(String value) {
			addCriterion("light <=", value, "light");
			return (Criteria) this;
		}

		public Criteria andLightLike(String value) {
			addCriterion("light like", value, "light");
			return (Criteria) this;
		}

		public Criteria andLightNotLike(String value) {
			addCriterion("light not like", value, "light");
			return (Criteria) this;
		}

		public Criteria andLightIn(List<String> values) {
			addCriterion("light in", values, "light");
			return (Criteria) this;
		}

		public Criteria andLightNotIn(List<String> values) {
			addCriterion("light not in", values, "light");
			return (Criteria) this;
		}

		public Criteria andLightBetween(String value1, String value2) {
			addCriterion("light between", value1, value2, "light");
			return (Criteria) this;
		}

		public Criteria andLightNotBetween(String value1, String value2) {
			addCriterion("light not between", value1, value2, "light");
			return (Criteria) this;
		}

		public Criteria andWeightBeginIsNull() {
			addCriterion("weight_begin is null");
			return (Criteria) this;
		}

		public Criteria andWeightBeginIsNotNull() {
			addCriterion("weight_begin is not null");
			return (Criteria) this;
		}

		public Criteria andWeightBeginEqualTo(Float value) {
			addCriterion("weight_begin =", value, "weightBegin");
			return (Criteria) this;
		}

		public Criteria andWeightBeginNotEqualTo(Float value) {
			addCriterion("weight_begin <>", value, "weightBegin");
			return (Criteria) this;
		}

		public Criteria andWeightBeginGreaterThan(Float value) {
			addCriterion("weight_begin >", value, "weightBegin");
			return (Criteria) this;
		}

		public Criteria andWeightBeginGreaterThanOrEqualTo(Float value) {
			addCriterion("weight_begin >=", value, "weightBegin");
			return (Criteria) this;
		}

		public Criteria andWeightBeginLessThan(Float value) {
			addCriterion("weight_begin <", value, "weightBegin");
			return (Criteria) this;
		}

		public Criteria andWeightBeginLessThanOrEqualTo(Float value) {
			addCriterion("weight_begin <=", value, "weightBegin");
			return (Criteria) this;
		}

		public Criteria andWeightBeginIn(List<Float> values) {
			addCriterion("weight_begin in", values, "weightBegin");
			return (Criteria) this;
		}

		public Criteria andWeightBeginNotIn(List<Float> values) {
			addCriterion("weight_begin not in", values, "weightBegin");
			return (Criteria) this;
		}

		public Criteria andWeightBeginBetween(Float value1, Float value2) {
			addCriterion("weight_begin between", value1, value2, "weightBegin");
			return (Criteria) this;
		}

		public Criteria andWeightBeginNotBetween(Float value1, Float value2) {
			addCriterion("weight_begin not between", value1, value2, "weightBegin");
			return (Criteria) this;
		}

		public Criteria andWeigthEndIsNull() {
			addCriterion("weigth_end is null");
			return (Criteria) this;
		}

		public Criteria andWeigthEndIsNotNull() {
			addCriterion("weigth_end is not null");
			return (Criteria) this;
		}

		public Criteria andWeigthEndEqualTo(Float value) {
			addCriterion("weigth_end =", value, "weigthEnd");
			return (Criteria) this;
		}

		public Criteria andWeigthEndNotEqualTo(Float value) {
			addCriterion("weigth_end <>", value, "weigthEnd");
			return (Criteria) this;
		}

		public Criteria andWeigthEndGreaterThan(Float value) {
			addCriterion("weigth_end >", value, "weigthEnd");
			return (Criteria) this;
		}

		public Criteria andWeigthEndGreaterThanOrEqualTo(Float value) {
			addCriterion("weigth_end >=", value, "weigthEnd");
			return (Criteria) this;
		}

		public Criteria andWeigthEndLessThan(Float value) {
			addCriterion("weigth_end <", value, "weigthEnd");
			return (Criteria) this;
		}

		public Criteria andWeigthEndLessThanOrEqualTo(Float value) {
			addCriterion("weigth_end <=", value, "weigthEnd");
			return (Criteria) this;
		}

		public Criteria andWeigthEndIn(List<Float> values) {
			addCriterion("weigth_end in", values, "weigthEnd");
			return (Criteria) this;
		}

		public Criteria andWeigthEndNotIn(List<Float> values) {
			addCriterion("weigth_end not in", values, "weigthEnd");
			return (Criteria) this;
		}

		public Criteria andWeigthEndBetween(Float value1, Float value2) {
			addCriterion("weigth_end between", value1, value2, "weigthEnd");
			return (Criteria) this;
		}

		public Criteria andWeigthEndNotBetween(Float value1, Float value2) {
			addCriterion("weigth_end not between", value1, value2, "weigthEnd");
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

		public Criteria andValueEqualTo(String value) {
			addCriterion("value =", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotEqualTo(String value) {
			addCriterion("value <>", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThan(String value) {
			addCriterion("value >", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThanOrEqualTo(String value) {
			addCriterion("value >=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThan(String value) {
			addCriterion("value <", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThanOrEqualTo(String value) {
			addCriterion("value <=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLike(String value) {
			addCriterion("value like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotLike(String value) {
			addCriterion("value not like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueIn(List<String> values) {
			addCriterion("value in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotIn(List<String> values) {
			addCriterion("value not in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueBetween(String value1, String value2) {
			addCriterion("value between", value1, value2, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotBetween(String value1, String value2) {
			addCriterion("value not between", value1, value2, "value");
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