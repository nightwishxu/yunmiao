package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class ExpressExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ExpressExample(){
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

		public Criteria andSourceIsNull() {
			addCriterion("source is null");
			return (Criteria) this;
		}

		public Criteria andSourceIsNotNull() {
			addCriterion("source is not null");
			return (Criteria) this;
		}

		public Criteria andSourceEqualTo(Integer value) {
			addCriterion("source =", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotEqualTo(Integer value) {
			addCriterion("source <>", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceGreaterThan(Integer value) {
			addCriterion("source >", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
			addCriterion("source >=", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLessThan(Integer value) {
			addCriterion("source <", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLessThanOrEqualTo(Integer value) {
			addCriterion("source <=", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceIn(List<Integer> values) {
			addCriterion("source in", values, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotIn(List<Integer> values) {
			addCriterion("source not in", values, "source");
			return (Criteria) this;
		}

		public Criteria andSourceBetween(Integer value1, Integer value2) {
			addCriterion("source between", value1, value2, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotBetween(Integer value1, Integer value2) {
			addCriterion("source not between", value1, value2, "source");
			return (Criteria) this;
		}

		public Criteria andSourceIdIsNull() {
			addCriterion("source_id is null");
			return (Criteria) this;
		}

		public Criteria andSourceIdIsNotNull() {
			addCriterion("source_id is not null");
			return (Criteria) this;
		}

		public Criteria andSourceIdEqualTo(Integer value) {
			addCriterion("source_id =", value, "sourceId");
			return (Criteria) this;
		}

		public Criteria andSourceIdNotEqualTo(Integer value) {
			addCriterion("source_id <>", value, "sourceId");
			return (Criteria) this;
		}

		public Criteria andSourceIdGreaterThan(Integer value) {
			addCriterion("source_id >", value, "sourceId");
			return (Criteria) this;
		}

		public Criteria andSourceIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("source_id >=", value, "sourceId");
			return (Criteria) this;
		}

		public Criteria andSourceIdLessThan(Integer value) {
			addCriterion("source_id <", value, "sourceId");
			return (Criteria) this;
		}

		public Criteria andSourceIdLessThanOrEqualTo(Integer value) {
			addCriterion("source_id <=", value, "sourceId");
			return (Criteria) this;
		}

		public Criteria andSourceIdIn(List<Integer> values) {
			addCriterion("source_id in", values, "sourceId");
			return (Criteria) this;
		}

		public Criteria andSourceIdNotIn(List<Integer> values) {
			addCriterion("source_id not in", values, "sourceId");
			return (Criteria) this;
		}

		public Criteria andSourceIdBetween(Integer value1, Integer value2) {
			addCriterion("source_id between", value1, value2, "sourceId");
			return (Criteria) this;
		}

		public Criteria andSourceIdNotBetween(Integer value1, Integer value2) {
			addCriterion("source_id not between", value1, value2, "sourceId");
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

		public Criteria andExpressNameIsNull() {
			addCriterion("express_name is null");
			return (Criteria) this;
		}

		public Criteria andExpressNameIsNotNull() {
			addCriterion("express_name is not null");
			return (Criteria) this;
		}

		public Criteria andExpressNameEqualTo(String value) {
			addCriterion("express_name =", value, "expressName");
			return (Criteria) this;
		}

		public Criteria andExpressNameNotEqualTo(String value) {
			addCriterion("express_name <>", value, "expressName");
			return (Criteria) this;
		}

		public Criteria andExpressNameGreaterThan(String value) {
			addCriterion("express_name >", value, "expressName");
			return (Criteria) this;
		}

		public Criteria andExpressNameGreaterThanOrEqualTo(String value) {
			addCriterion("express_name >=", value, "expressName");
			return (Criteria) this;
		}

		public Criteria andExpressNameLessThan(String value) {
			addCriterion("express_name <", value, "expressName");
			return (Criteria) this;
		}

		public Criteria andExpressNameLessThanOrEqualTo(String value) {
			addCriterion("express_name <=", value, "expressName");
			return (Criteria) this;
		}

		public Criteria andExpressNameLike(String value) {
			addCriterion("express_name like", value, "expressName");
			return (Criteria) this;
		}

		public Criteria andExpressNameNotLike(String value) {
			addCriterion("express_name not like", value, "expressName");
			return (Criteria) this;
		}

		public Criteria andExpressNameIn(List<String> values) {
			addCriterion("express_name in", values, "expressName");
			return (Criteria) this;
		}

		public Criteria andExpressNameNotIn(List<String> values) {
			addCriterion("express_name not in", values, "expressName");
			return (Criteria) this;
		}

		public Criteria andExpressNameBetween(String value1, String value2) {
			addCriterion("express_name between", value1, value2, "expressName");
			return (Criteria) this;
		}

		public Criteria andExpressNameNotBetween(String value1, String value2) {
			addCriterion("express_name not between", value1, value2, "expressName");
			return (Criteria) this;
		}

		public Criteria andExpressCodeIsNull() {
			addCriterion("express_code is null");
			return (Criteria) this;
		}

		public Criteria andExpressCodeIsNotNull() {
			addCriterion("express_code is not null");
			return (Criteria) this;
		}

		public Criteria andExpressCodeEqualTo(String value) {
			addCriterion("express_code =", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeNotEqualTo(String value) {
			addCriterion("express_code <>", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeGreaterThan(String value) {
			addCriterion("express_code >", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
			addCriterion("express_code >=", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeLessThan(String value) {
			addCriterion("express_code <", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeLessThanOrEqualTo(String value) {
			addCriterion("express_code <=", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeLike(String value) {
			addCriterion("express_code like", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeNotLike(String value) {
			addCriterion("express_code not like", value, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeIn(List<String> values) {
			addCriterion("express_code in", values, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeNotIn(List<String> values) {
			addCriterion("express_code not in", values, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeBetween(String value1, String value2) {
			addCriterion("express_code between", value1, value2, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressCodeNotBetween(String value1, String value2) {
			addCriterion("express_code not between", value1, value2, "expressCode");
			return (Criteria) this;
		}

		public Criteria andExpressStateIsNull() {
			addCriterion("express_state is null");
			return (Criteria) this;
		}

		public Criteria andExpressStateIsNotNull() {
			addCriterion("express_state is not null");
			return (Criteria) this;
		}

		public Criteria andExpressStateEqualTo(Integer value) {
			addCriterion("express_state =", value, "expressState");
			return (Criteria) this;
		}

		public Criteria andExpressStateNotEqualTo(Integer value) {
			addCriterion("express_state <>", value, "expressState");
			return (Criteria) this;
		}

		public Criteria andExpressStateGreaterThan(Integer value) {
			addCriterion("express_state >", value, "expressState");
			return (Criteria) this;
		}

		public Criteria andExpressStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("express_state >=", value, "expressState");
			return (Criteria) this;
		}

		public Criteria andExpressStateLessThan(Integer value) {
			addCriterion("express_state <", value, "expressState");
			return (Criteria) this;
		}

		public Criteria andExpressStateLessThanOrEqualTo(Integer value) {
			addCriterion("express_state <=", value, "expressState");
			return (Criteria) this;
		}

		public Criteria andExpressStateIn(List<Integer> values) {
			addCriterion("express_state in", values, "expressState");
			return (Criteria) this;
		}

		public Criteria andExpressStateNotIn(List<Integer> values) {
			addCriterion("express_state not in", values, "expressState");
			return (Criteria) this;
		}

		public Criteria andExpressStateBetween(Integer value1, Integer value2) {
			addCriterion("express_state between", value1, value2, "expressState");
			return (Criteria) this;
		}

		public Criteria andExpressStateNotBetween(Integer value1, Integer value2) {
			addCriterion("express_state not between", value1, value2, "expressState");
			return (Criteria) this;
		}

		public Criteria andExpressDataIsNull() {
			addCriterion("express_data is null");
			return (Criteria) this;
		}

		public Criteria andExpressDataIsNotNull() {
			addCriterion("express_data is not null");
			return (Criteria) this;
		}

		public Criteria andExpressDataEqualTo(String value) {
			addCriterion("express_data =", value, "expressData");
			return (Criteria) this;
		}

		public Criteria andExpressDataNotEqualTo(String value) {
			addCriterion("express_data <>", value, "expressData");
			return (Criteria) this;
		}

		public Criteria andExpressDataGreaterThan(String value) {
			addCriterion("express_data >", value, "expressData");
			return (Criteria) this;
		}

		public Criteria andExpressDataGreaterThanOrEqualTo(String value) {
			addCriterion("express_data >=", value, "expressData");
			return (Criteria) this;
		}

		public Criteria andExpressDataLessThan(String value) {
			addCriterion("express_data <", value, "expressData");
			return (Criteria) this;
		}

		public Criteria andExpressDataLessThanOrEqualTo(String value) {
			addCriterion("express_data <=", value, "expressData");
			return (Criteria) this;
		}

		public Criteria andExpressDataLike(String value) {
			addCriterion("express_data like", value, "expressData");
			return (Criteria) this;
		}

		public Criteria andExpressDataNotLike(String value) {
			addCriterion("express_data not like", value, "expressData");
			return (Criteria) this;
		}

		public Criteria andExpressDataIn(List<String> values) {
			addCriterion("express_data in", values, "expressData");
			return (Criteria) this;
		}

		public Criteria andExpressDataNotIn(List<String> values) {
			addCriterion("express_data not in", values, "expressData");
			return (Criteria) this;
		}

		public Criteria andExpressDataBetween(String value1, String value2) {
			addCriterion("express_data between", value1, value2, "expressData");
			return (Criteria) this;
		}

		public Criteria andExpressDataNotBetween(String value1, String value2) {
			addCriterion("express_data not between", value1, value2, "expressData");
			return (Criteria) this;
		}

		public Criteria andPostNameIsNull() {
			addCriterion("post_name is null");
			return (Criteria) this;
		}

		public Criteria andPostNameIsNotNull() {
			addCriterion("post_name is not null");
			return (Criteria) this;
		}

		public Criteria andPostNameEqualTo(String value) {
			addCriterion("post_name =", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameNotEqualTo(String value) {
			addCriterion("post_name <>", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameGreaterThan(String value) {
			addCriterion("post_name >", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameGreaterThanOrEqualTo(String value) {
			addCriterion("post_name >=", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameLessThan(String value) {
			addCriterion("post_name <", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameLessThanOrEqualTo(String value) {
			addCriterion("post_name <=", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameLike(String value) {
			addCriterion("post_name like", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameNotLike(String value) {
			addCriterion("post_name not like", value, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameIn(List<String> values) {
			addCriterion("post_name in", values, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameNotIn(List<String> values) {
			addCriterion("post_name not in", values, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameBetween(String value1, String value2) {
			addCriterion("post_name between", value1, value2, "postName");
			return (Criteria) this;
		}

		public Criteria andPostNameNotBetween(String value1, String value2) {
			addCriterion("post_name not between", value1, value2, "postName");
			return (Criteria) this;
		}

		public Criteria andPostPhoneIsNull() {
			addCriterion("post_phone is null");
			return (Criteria) this;
		}

		public Criteria andPostPhoneIsNotNull() {
			addCriterion("post_phone is not null");
			return (Criteria) this;
		}

		public Criteria andPostPhoneEqualTo(String value) {
			addCriterion("post_phone =", value, "postPhone");
			return (Criteria) this;
		}

		public Criteria andPostPhoneNotEqualTo(String value) {
			addCriterion("post_phone <>", value, "postPhone");
			return (Criteria) this;
		}

		public Criteria andPostPhoneGreaterThan(String value) {
			addCriterion("post_phone >", value, "postPhone");
			return (Criteria) this;
		}

		public Criteria andPostPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("post_phone >=", value, "postPhone");
			return (Criteria) this;
		}

		public Criteria andPostPhoneLessThan(String value) {
			addCriterion("post_phone <", value, "postPhone");
			return (Criteria) this;
		}

		public Criteria andPostPhoneLessThanOrEqualTo(String value) {
			addCriterion("post_phone <=", value, "postPhone");
			return (Criteria) this;
		}

		public Criteria andPostPhoneLike(String value) {
			addCriterion("post_phone like", value, "postPhone");
			return (Criteria) this;
		}

		public Criteria andPostPhoneNotLike(String value) {
			addCriterion("post_phone not like", value, "postPhone");
			return (Criteria) this;
		}

		public Criteria andPostPhoneIn(List<String> values) {
			addCriterion("post_phone in", values, "postPhone");
			return (Criteria) this;
		}

		public Criteria andPostPhoneNotIn(List<String> values) {
			addCriterion("post_phone not in", values, "postPhone");
			return (Criteria) this;
		}

		public Criteria andPostPhoneBetween(String value1, String value2) {
			addCriterion("post_phone between", value1, value2, "postPhone");
			return (Criteria) this;
		}

		public Criteria andPostPhoneNotBetween(String value1, String value2) {
			addCriterion("post_phone not between", value1, value2, "postPhone");
			return (Criteria) this;
		}

		public Criteria andReceiveNameIsNull() {
			addCriterion("receive_name is null");
			return (Criteria) this;
		}

		public Criteria andReceiveNameIsNotNull() {
			addCriterion("receive_name is not null");
			return (Criteria) this;
		}

		public Criteria andReceiveNameEqualTo(String value) {
			addCriterion("receive_name =", value, "receiveName");
			return (Criteria) this;
		}

		public Criteria andReceiveNameNotEqualTo(String value) {
			addCriterion("receive_name <>", value, "receiveName");
			return (Criteria) this;
		}

		public Criteria andReceiveNameGreaterThan(String value) {
			addCriterion("receive_name >", value, "receiveName");
			return (Criteria) this;
		}

		public Criteria andReceiveNameGreaterThanOrEqualTo(String value) {
			addCriterion("receive_name >=", value, "receiveName");
			return (Criteria) this;
		}

		public Criteria andReceiveNameLessThan(String value) {
			addCriterion("receive_name <", value, "receiveName");
			return (Criteria) this;
		}

		public Criteria andReceiveNameLessThanOrEqualTo(String value) {
			addCriterion("receive_name <=", value, "receiveName");
			return (Criteria) this;
		}

		public Criteria andReceiveNameLike(String value) {
			addCriterion("receive_name like", value, "receiveName");
			return (Criteria) this;
		}

		public Criteria andReceiveNameNotLike(String value) {
			addCriterion("receive_name not like", value, "receiveName");
			return (Criteria) this;
		}

		public Criteria andReceiveNameIn(List<String> values) {
			addCriterion("receive_name in", values, "receiveName");
			return (Criteria) this;
		}

		public Criteria andReceiveNameNotIn(List<String> values) {
			addCriterion("receive_name not in", values, "receiveName");
			return (Criteria) this;
		}

		public Criteria andReceiveNameBetween(String value1, String value2) {
			addCriterion("receive_name between", value1, value2, "receiveName");
			return (Criteria) this;
		}

		public Criteria andReceiveNameNotBetween(String value1, String value2) {
			addCriterion("receive_name not between", value1, value2, "receiveName");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneIsNull() {
			addCriterion("receive_phone is null");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneIsNotNull() {
			addCriterion("receive_phone is not null");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneEqualTo(String value) {
			addCriterion("receive_phone =", value, "receivePhone");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneNotEqualTo(String value) {
			addCriterion("receive_phone <>", value, "receivePhone");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneGreaterThan(String value) {
			addCriterion("receive_phone >", value, "receivePhone");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneGreaterThanOrEqualTo(String value) {
			addCriterion("receive_phone >=", value, "receivePhone");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneLessThan(String value) {
			addCriterion("receive_phone <", value, "receivePhone");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneLessThanOrEqualTo(String value) {
			addCriterion("receive_phone <=", value, "receivePhone");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneLike(String value) {
			addCriterion("receive_phone like", value, "receivePhone");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneNotLike(String value) {
			addCriterion("receive_phone not like", value, "receivePhone");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneIn(List<String> values) {
			addCriterion("receive_phone in", values, "receivePhone");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneNotIn(List<String> values) {
			addCriterion("receive_phone not in", values, "receivePhone");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneBetween(String value1, String value2) {
			addCriterion("receive_phone between", value1, value2, "receivePhone");
			return (Criteria) this;
		}

		public Criteria andReceivePhoneNotBetween(String value1, String value2) {
			addCriterion("receive_phone not between", value1, value2, "receivePhone");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressIsNull() {
			addCriterion("recevice_address is null");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressIsNotNull() {
			addCriterion("recevice_address is not null");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressEqualTo(String value) {
			addCriterion("recevice_address =", value, "receviceAddress");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressNotEqualTo(String value) {
			addCriterion("recevice_address <>", value, "receviceAddress");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressGreaterThan(String value) {
			addCriterion("recevice_address >", value, "receviceAddress");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressGreaterThanOrEqualTo(String value) {
			addCriterion("recevice_address >=", value, "receviceAddress");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressLessThan(String value) {
			addCriterion("recevice_address <", value, "receviceAddress");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressLessThanOrEqualTo(String value) {
			addCriterion("recevice_address <=", value, "receviceAddress");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressLike(String value) {
			addCriterion("recevice_address like", value, "receviceAddress");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressNotLike(String value) {
			addCriterion("recevice_address not like", value, "receviceAddress");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressIn(List<String> values) {
			addCriterion("recevice_address in", values, "receviceAddress");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressNotIn(List<String> values) {
			addCriterion("recevice_address not in", values, "receviceAddress");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressBetween(String value1, String value2) {
			addCriterion("recevice_address between", value1, value2, "receviceAddress");
			return (Criteria) this;
		}

		public Criteria andReceviceAddressNotBetween(String value1, String value2) {
			addCriterion("recevice_address not between", value1, value2, "receviceAddress");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIsNull() {
			addCriterion("modify_time is null");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIsNotNull() {
			addCriterion("modify_time is not null");
			return (Criteria) this;
		}

		public Criteria andModifyTimeEqualTo(java.util.Date value) {
			addCriterion("modify_time =", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotEqualTo(java.util.Date value) {
			addCriterion("modify_time <>", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeGreaterThan(java.util.Date value) {
			addCriterion("modify_time >", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("modify_time >=", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeLessThan(java.util.Date value) {
			addCriterion("modify_time <", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("modify_time <=", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIn(List<java.util.Date> values) {
			addCriterion("modify_time in", values, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotIn(List<java.util.Date> values) {
			addCriterion("modify_time not in", values, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("modify_time between", value1, value2, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("modify_time not between", value1, value2, "modifyTime");
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