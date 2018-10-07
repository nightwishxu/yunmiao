package com.item.dao.model;

import java.util.List;
import java.util.ArrayList;

public class UserNotifyExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserNotifyExample(){
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

		public Criteria andNidIsNull() {
			addCriterion("nid is null");
			return (Criteria) this;
		}

		public Criteria andNidIsNotNull() {
			addCriterion("nid is not null");
			return (Criteria) this;
		}

		public Criteria andNidEqualTo(Integer value) {
			addCriterion("nid =", value, "nid");
			return (Criteria) this;
		}

		public Criteria andNidNotEqualTo(Integer value) {
			addCriterion("nid <>", value, "nid");
			return (Criteria) this;
		}

		public Criteria andNidGreaterThan(Integer value) {
			addCriterion("nid >", value, "nid");
			return (Criteria) this;
		}

		public Criteria andNidGreaterThanOrEqualTo(Integer value) {
			addCriterion("nid >=", value, "nid");
			return (Criteria) this;
		}

		public Criteria andNidLessThan(Integer value) {
			addCriterion("nid <", value, "nid");
			return (Criteria) this;
		}

		public Criteria andNidLessThanOrEqualTo(Integer value) {
			addCriterion("nid <=", value, "nid");
			return (Criteria) this;
		}

		public Criteria andNidIn(List<Integer> values) {
			addCriterion("nid in", values, "nid");
			return (Criteria) this;
		}

		public Criteria andNidNotIn(List<Integer> values) {
			addCriterion("nid not in", values, "nid");
			return (Criteria) this;
		}

		public Criteria andNidBetween(Integer value1, Integer value2) {
			addCriterion("nid between", value1, value2, "nid");
			return (Criteria) this;
		}

		public Criteria andNidNotBetween(Integer value1, Integer value2) {
			addCriterion("nid not between", value1, value2, "nid");
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

		public Criteria andIsReadIsNull() {
			addCriterion("is_read is null");
			return (Criteria) this;
		}

		public Criteria andIsReadIsNotNull() {
			addCriterion("is_read is not null");
			return (Criteria) this;
		}

		public Criteria andIsReadEqualTo(Integer value) {
			addCriterion("is_read =", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadNotEqualTo(Integer value) {
			addCriterion("is_read <>", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadGreaterThan(Integer value) {
			addCriterion("is_read >", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_read >=", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadLessThan(Integer value) {
			addCriterion("is_read <", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadLessThanOrEqualTo(Integer value) {
			addCriterion("is_read <=", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadIn(List<Integer> values) {
			addCriterion("is_read in", values, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadNotIn(List<Integer> values) {
			addCriterion("is_read not in", values, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadBetween(Integer value1, Integer value2) {
			addCriterion("is_read between", value1, value2, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadNotBetween(Integer value1, Integer value2) {
			addCriterion("is_read not between", value1, value2, "isRead");
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