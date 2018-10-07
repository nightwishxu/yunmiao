package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class PlatformGoodsBuyExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PlatformGoodsBuyExample(){
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

		public Criteria andGoodsIdIsNull() {
			addCriterion("goods_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIsNotNull() {
			addCriterion("goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdEqualTo(Integer value) {
			addCriterion("goods_id =", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotEqualTo(Integer value) {
			addCriterion("goods_id <>", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThan(Integer value) {
			addCriterion("goods_id >", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_id >=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThan(Integer value) {
			addCriterion("goods_id <", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
			addCriterion("goods_id <=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIn(List<Integer> values) {
			addCriterion("goods_id in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotIn(List<Integer> values) {
			addCriterion("goods_id not in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
			addCriterion("goods_id between", value1, value2, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_id not between", value1, value2, "goodsId");
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

		public Criteria andBankCardNameIsNull() {
			addCriterion("bank_card_name is null");
			return (Criteria) this;
		}

		public Criteria andBankCardNameIsNotNull() {
			addCriterion("bank_card_name is not null");
			return (Criteria) this;
		}

		public Criteria andBankCardNameEqualTo(String value) {
			addCriterion("bank_card_name =", value, "bankCardName");
			return (Criteria) this;
		}

		public Criteria andBankCardNameNotEqualTo(String value) {
			addCriterion("bank_card_name <>", value, "bankCardName");
			return (Criteria) this;
		}

		public Criteria andBankCardNameGreaterThan(String value) {
			addCriterion("bank_card_name >", value, "bankCardName");
			return (Criteria) this;
		}

		public Criteria andBankCardNameGreaterThanOrEqualTo(String value) {
			addCriterion("bank_card_name >=", value, "bankCardName");
			return (Criteria) this;
		}

		public Criteria andBankCardNameLessThan(String value) {
			addCriterion("bank_card_name <", value, "bankCardName");
			return (Criteria) this;
		}

		public Criteria andBankCardNameLessThanOrEqualTo(String value) {
			addCriterion("bank_card_name <=", value, "bankCardName");
			return (Criteria) this;
		}

		public Criteria andBankCardNameLike(String value) {
			addCriterion("bank_card_name like", value, "bankCardName");
			return (Criteria) this;
		}

		public Criteria andBankCardNameNotLike(String value) {
			addCriterion("bank_card_name not like", value, "bankCardName");
			return (Criteria) this;
		}

		public Criteria andBankCardNameIn(List<String> values) {
			addCriterion("bank_card_name in", values, "bankCardName");
			return (Criteria) this;
		}

		public Criteria andBankCardNameNotIn(List<String> values) {
			addCriterion("bank_card_name not in", values, "bankCardName");
			return (Criteria) this;
		}

		public Criteria andBankCardNameBetween(String value1, String value2) {
			addCriterion("bank_card_name between", value1, value2, "bankCardName");
			return (Criteria) this;
		}

		public Criteria andBankCardNameNotBetween(String value1, String value2) {
			addCriterion("bank_card_name not between", value1, value2, "bankCardName");
			return (Criteria) this;
		}

		public Criteria andBankCardNoIsNull() {
			addCriterion("bank_card_no is null");
			return (Criteria) this;
		}

		public Criteria andBankCardNoIsNotNull() {
			addCriterion("bank_card_no is not null");
			return (Criteria) this;
		}

		public Criteria andBankCardNoEqualTo(String value) {
			addCriterion("bank_card_no =", value, "bankCardNo");
			return (Criteria) this;
		}

		public Criteria andBankCardNoNotEqualTo(String value) {
			addCriterion("bank_card_no <>", value, "bankCardNo");
			return (Criteria) this;
		}

		public Criteria andBankCardNoGreaterThan(String value) {
			addCriterion("bank_card_no >", value, "bankCardNo");
			return (Criteria) this;
		}

		public Criteria andBankCardNoGreaterThanOrEqualTo(String value) {
			addCriterion("bank_card_no >=", value, "bankCardNo");
			return (Criteria) this;
		}

		public Criteria andBankCardNoLessThan(String value) {
			addCriterion("bank_card_no <", value, "bankCardNo");
			return (Criteria) this;
		}

		public Criteria andBankCardNoLessThanOrEqualTo(String value) {
			addCriterion("bank_card_no <=", value, "bankCardNo");
			return (Criteria) this;
		}

		public Criteria andBankCardNoLike(String value) {
			addCriterion("bank_card_no like", value, "bankCardNo");
			return (Criteria) this;
		}

		public Criteria andBankCardNoNotLike(String value) {
			addCriterion("bank_card_no not like", value, "bankCardNo");
			return (Criteria) this;
		}

		public Criteria andBankCardNoIn(List<String> values) {
			addCriterion("bank_card_no in", values, "bankCardNo");
			return (Criteria) this;
		}

		public Criteria andBankCardNoNotIn(List<String> values) {
			addCriterion("bank_card_no not in", values, "bankCardNo");
			return (Criteria) this;
		}

		public Criteria andBankCardNoBetween(String value1, String value2) {
			addCriterion("bank_card_no between", value1, value2, "bankCardNo");
			return (Criteria) this;
		}

		public Criteria andBankCardNoNotBetween(String value1, String value2) {
			addCriterion("bank_card_no not between", value1, value2, "bankCardNo");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_name =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_name >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_name <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("user_name like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("user_name not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_name in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserPhoneIsNull() {
			addCriterion("user_phone is null");
			return (Criteria) this;
		}

		public Criteria andUserPhoneIsNotNull() {
			addCriterion("user_phone is not null");
			return (Criteria) this;
		}

		public Criteria andUserPhoneEqualTo(String value) {
			addCriterion("user_phone =", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneNotEqualTo(String value) {
			addCriterion("user_phone <>", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneGreaterThan(String value) {
			addCriterion("user_phone >", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("user_phone >=", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneLessThan(String value) {
			addCriterion("user_phone <", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneLessThanOrEqualTo(String value) {
			addCriterion("user_phone <=", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneLike(String value) {
			addCriterion("user_phone like", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneNotLike(String value) {
			addCriterion("user_phone not like", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneIn(List<String> values) {
			addCriterion("user_phone in", values, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneNotIn(List<String> values) {
			addCriterion("user_phone not in", values, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneBetween(String value1, String value2) {
			addCriterion("user_phone between", value1, value2, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneNotBetween(String value1, String value2) {
			addCriterion("user_phone not between", value1, value2, "userPhone");
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

		public Criteria andTicketIsNull() {
			addCriterion("ticket is null");
			return (Criteria) this;
		}

		public Criteria andTicketIsNotNull() {
			addCriterion("ticket is not null");
			return (Criteria) this;
		}

		public Criteria andTicketEqualTo(String value) {
			addCriterion("ticket =", value, "ticket");
			return (Criteria) this;
		}

		public Criteria andTicketNotEqualTo(String value) {
			addCriterion("ticket <>", value, "ticket");
			return (Criteria) this;
		}

		public Criteria andTicketGreaterThan(String value) {
			addCriterion("ticket >", value, "ticket");
			return (Criteria) this;
		}

		public Criteria andTicketGreaterThanOrEqualTo(String value) {
			addCriterion("ticket >=", value, "ticket");
			return (Criteria) this;
		}

		public Criteria andTicketLessThan(String value) {
			addCriterion("ticket <", value, "ticket");
			return (Criteria) this;
		}

		public Criteria andTicketLessThanOrEqualTo(String value) {
			addCriterion("ticket <=", value, "ticket");
			return (Criteria) this;
		}

		public Criteria andTicketLike(String value) {
			addCriterion("ticket like", value, "ticket");
			return (Criteria) this;
		}

		public Criteria andTicketNotLike(String value) {
			addCriterion("ticket not like", value, "ticket");
			return (Criteria) this;
		}

		public Criteria andTicketIn(List<String> values) {
			addCriterion("ticket in", values, "ticket");
			return (Criteria) this;
		}

		public Criteria andTicketNotIn(List<String> values) {
			addCriterion("ticket not in", values, "ticket");
			return (Criteria) this;
		}

		public Criteria andTicketBetween(String value1, String value2) {
			addCriterion("ticket between", value1, value2, "ticket");
			return (Criteria) this;
		}

		public Criteria andTicketNotBetween(String value1, String value2) {
			addCriterion("ticket not between", value1, value2, "ticket");
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