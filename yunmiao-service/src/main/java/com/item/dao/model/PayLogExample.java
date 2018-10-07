package com.item.dao.model;

import java.util.List;
import java.util.ArrayList;

public class PayLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PayLogExample(){
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

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
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

		public Criteria andOrderIdIsNull() {
			addCriterion("order_id is null");
			return (Criteria) this;
		}

		public Criteria andOrderIdIsNotNull() {
			addCriterion("order_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrderIdEqualTo(Integer value) {
			addCriterion("order_id =", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotEqualTo(Integer value) {
			addCriterion("order_id <>", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThan(Integer value) {
			addCriterion("order_id >", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_id >=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThan(Integer value) {
			addCriterion("order_id <", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
			addCriterion("order_id <=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdIn(List<Integer> values) {
			addCriterion("order_id in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotIn(List<Integer> values) {
			addCriterion("order_id not in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdBetween(Integer value1, Integer value2) {
			addCriterion("order_id between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
			addCriterion("order_id not between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andMoneyIsNull() {
			addCriterion("money is null");
			return (Criteria) this;
		}

		public Criteria andMoneyIsNotNull() {
			addCriterion("money is not null");
			return (Criteria) this;
		}

		public Criteria andMoneyEqualTo(java.math.BigDecimal value) {
			addCriterion("money =", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotEqualTo(java.math.BigDecimal value) {
			addCriterion("money <>", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThan(java.math.BigDecimal value) {
			addCriterion("money >", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("money >=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThan(java.math.BigDecimal value) {
			addCriterion("money <", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("money <=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyIn(List<java.math.BigDecimal> values) {
			addCriterion("money in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotIn(List<java.math.BigDecimal> values) {
			addCriterion("money not in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("money between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("money not between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andRealPayIsNull() {
			addCriterion("real_pay is null");
			return (Criteria) this;
		}

		public Criteria andRealPayIsNotNull() {
			addCriterion("real_pay is not null");
			return (Criteria) this;
		}

		public Criteria andRealPayEqualTo(java.math.BigDecimal value) {
			addCriterion("real_pay =", value, "realPay");
			return (Criteria) this;
		}

		public Criteria andRealPayNotEqualTo(java.math.BigDecimal value) {
			addCriterion("real_pay <>", value, "realPay");
			return (Criteria) this;
		}

		public Criteria andRealPayGreaterThan(java.math.BigDecimal value) {
			addCriterion("real_pay >", value, "realPay");
			return (Criteria) this;
		}

		public Criteria andRealPayGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("real_pay >=", value, "realPay");
			return (Criteria) this;
		}

		public Criteria andRealPayLessThan(java.math.BigDecimal value) {
			addCriterion("real_pay <", value, "realPay");
			return (Criteria) this;
		}

		public Criteria andRealPayLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("real_pay <=", value, "realPay");
			return (Criteria) this;
		}

		public Criteria andRealPayIn(List<java.math.BigDecimal> values) {
			addCriterion("real_pay in", values, "realPay");
			return (Criteria) this;
		}

		public Criteria andRealPayNotIn(List<java.math.BigDecimal> values) {
			addCriterion("real_pay not in", values, "realPay");
			return (Criteria) this;
		}

		public Criteria andRealPayBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("real_pay between", value1, value2, "realPay");
			return (Criteria) this;
		}

		public Criteria andRealPayNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("real_pay not between", value1, value2, "realPay");
			return (Criteria) this;
		}

		public Criteria andBuyerIsNull() {
			addCriterion("buyer is null");
			return (Criteria) this;
		}

		public Criteria andBuyerIsNotNull() {
			addCriterion("buyer is not null");
			return (Criteria) this;
		}

		public Criteria andBuyerEqualTo(String value) {
			addCriterion("buyer =", value, "buyer");
			return (Criteria) this;
		}

		public Criteria andBuyerNotEqualTo(String value) {
			addCriterion("buyer <>", value, "buyer");
			return (Criteria) this;
		}

		public Criteria andBuyerGreaterThan(String value) {
			addCriterion("buyer >", value, "buyer");
			return (Criteria) this;
		}

		public Criteria andBuyerGreaterThanOrEqualTo(String value) {
			addCriterion("buyer >=", value, "buyer");
			return (Criteria) this;
		}

		public Criteria andBuyerLessThan(String value) {
			addCriterion("buyer <", value, "buyer");
			return (Criteria) this;
		}

		public Criteria andBuyerLessThanOrEqualTo(String value) {
			addCriterion("buyer <=", value, "buyer");
			return (Criteria) this;
		}

		public Criteria andBuyerLike(String value) {
			addCriterion("buyer like", value, "buyer");
			return (Criteria) this;
		}

		public Criteria andBuyerNotLike(String value) {
			addCriterion("buyer not like", value, "buyer");
			return (Criteria) this;
		}

		public Criteria andBuyerIn(List<String> values) {
			addCriterion("buyer in", values, "buyer");
			return (Criteria) this;
		}

		public Criteria andBuyerNotIn(List<String> values) {
			addCriterion("buyer not in", values, "buyer");
			return (Criteria) this;
		}

		public Criteria andBuyerBetween(String value1, String value2) {
			addCriterion("buyer between", value1, value2, "buyer");
			return (Criteria) this;
		}

		public Criteria andBuyerNotBetween(String value1, String value2) {
			addCriterion("buyer not between", value1, value2, "buyer");
			return (Criteria) this;
		}

		public Criteria andSellerIsNull() {
			addCriterion("seller is null");
			return (Criteria) this;
		}

		public Criteria andSellerIsNotNull() {
			addCriterion("seller is not null");
			return (Criteria) this;
		}

		public Criteria andSellerEqualTo(String value) {
			addCriterion("seller =", value, "seller");
			return (Criteria) this;
		}

		public Criteria andSellerNotEqualTo(String value) {
			addCriterion("seller <>", value, "seller");
			return (Criteria) this;
		}

		public Criteria andSellerGreaterThan(String value) {
			addCriterion("seller >", value, "seller");
			return (Criteria) this;
		}

		public Criteria andSellerGreaterThanOrEqualTo(String value) {
			addCriterion("seller >=", value, "seller");
			return (Criteria) this;
		}

		public Criteria andSellerLessThan(String value) {
			addCriterion("seller <", value, "seller");
			return (Criteria) this;
		}

		public Criteria andSellerLessThanOrEqualTo(String value) {
			addCriterion("seller <=", value, "seller");
			return (Criteria) this;
		}

		public Criteria andSellerLike(String value) {
			addCriterion("seller like", value, "seller");
			return (Criteria) this;
		}

		public Criteria andSellerNotLike(String value) {
			addCriterion("seller not like", value, "seller");
			return (Criteria) this;
		}

		public Criteria andSellerIn(List<String> values) {
			addCriterion("seller in", values, "seller");
			return (Criteria) this;
		}

		public Criteria andSellerNotIn(List<String> values) {
			addCriterion("seller not in", values, "seller");
			return (Criteria) this;
		}

		public Criteria andSellerBetween(String value1, String value2) {
			addCriterion("seller between", value1, value2, "seller");
			return (Criteria) this;
		}

		public Criteria andSellerNotBetween(String value1, String value2) {
			addCriterion("seller not between", value1, value2, "seller");
			return (Criteria) this;
		}

		public Criteria andTradeNoIsNull() {
			addCriterion("trade_no is null");
			return (Criteria) this;
		}

		public Criteria andTradeNoIsNotNull() {
			addCriterion("trade_no is not null");
			return (Criteria) this;
		}

		public Criteria andTradeNoEqualTo(String value) {
			addCriterion("trade_no =", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoNotEqualTo(String value) {
			addCriterion("trade_no <>", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoGreaterThan(String value) {
			addCriterion("trade_no >", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
			addCriterion("trade_no >=", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoLessThan(String value) {
			addCriterion("trade_no <", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoLessThanOrEqualTo(String value) {
			addCriterion("trade_no <=", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoLike(String value) {
			addCriterion("trade_no like", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoNotLike(String value) {
			addCriterion("trade_no not like", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoIn(List<String> values) {
			addCriterion("trade_no in", values, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoNotIn(List<String> values) {
			addCriterion("trade_no not in", values, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoBetween(String value1, String value2) {
			addCriterion("trade_no between", value1, value2, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoNotBetween(String value1, String value2) {
			addCriterion("trade_no not between", value1, value2, "tradeNo");
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

		public Criteria andPlatformIsNull() {
			addCriterion("platform is null");
			return (Criteria) this;
		}

		public Criteria andPlatformIsNotNull() {
			addCriterion("platform is not null");
			return (Criteria) this;
		}

		public Criteria andPlatformEqualTo(Integer value) {
			addCriterion("platform =", value, "platform");
			return (Criteria) this;
		}

		public Criteria andPlatformNotEqualTo(Integer value) {
			addCriterion("platform <>", value, "platform");
			return (Criteria) this;
		}

		public Criteria andPlatformGreaterThan(Integer value) {
			addCriterion("platform >", value, "platform");
			return (Criteria) this;
		}

		public Criteria andPlatformGreaterThanOrEqualTo(Integer value) {
			addCriterion("platform >=", value, "platform");
			return (Criteria) this;
		}

		public Criteria andPlatformLessThan(Integer value) {
			addCriterion("platform <", value, "platform");
			return (Criteria) this;
		}

		public Criteria andPlatformLessThanOrEqualTo(Integer value) {
			addCriterion("platform <=", value, "platform");
			return (Criteria) this;
		}

		public Criteria andPlatformIn(List<Integer> values) {
			addCriterion("platform in", values, "platform");
			return (Criteria) this;
		}

		public Criteria andPlatformNotIn(List<Integer> values) {
			addCriterion("platform not in", values, "platform");
			return (Criteria) this;
		}

		public Criteria andPlatformBetween(Integer value1, Integer value2) {
			addCriterion("platform between", value1, value2, "platform");
			return (Criteria) this;
		}

		public Criteria andPlatformNotBetween(Integer value1, Integer value2) {
			addCriterion("platform not between", value1, value2, "platform");
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

		public Criteria andWxKeyIsNull() {
			addCriterion("wx_key is null");
			return (Criteria) this;
		}

		public Criteria andWxKeyIsNotNull() {
			addCriterion("wx_key is not null");
			return (Criteria) this;
		}

		public Criteria andWxKeyEqualTo(String value) {
			addCriterion("wx_key =", value, "wxKey");
			return (Criteria) this;
		}

		public Criteria andWxKeyNotEqualTo(String value) {
			addCriterion("wx_key <>", value, "wxKey");
			return (Criteria) this;
		}

		public Criteria andWxKeyGreaterThan(String value) {
			addCriterion("wx_key >", value, "wxKey");
			return (Criteria) this;
		}

		public Criteria andWxKeyGreaterThanOrEqualTo(String value) {
			addCriterion("wx_key >=", value, "wxKey");
			return (Criteria) this;
		}

		public Criteria andWxKeyLessThan(String value) {
			addCriterion("wx_key <", value, "wxKey");
			return (Criteria) this;
		}

		public Criteria andWxKeyLessThanOrEqualTo(String value) {
			addCriterion("wx_key <=", value, "wxKey");
			return (Criteria) this;
		}

		public Criteria andWxKeyLike(String value) {
			addCriterion("wx_key like", value, "wxKey");
			return (Criteria) this;
		}

		public Criteria andWxKeyNotLike(String value) {
			addCriterion("wx_key not like", value, "wxKey");
			return (Criteria) this;
		}

		public Criteria andWxKeyIn(List<String> values) {
			addCriterion("wx_key in", values, "wxKey");
			return (Criteria) this;
		}

		public Criteria andWxKeyNotIn(List<String> values) {
			addCriterion("wx_key not in", values, "wxKey");
			return (Criteria) this;
		}

		public Criteria andWxKeyBetween(String value1, String value2) {
			addCriterion("wx_key between", value1, value2, "wxKey");
			return (Criteria) this;
		}

		public Criteria andWxKeyNotBetween(String value1, String value2) {
			addCriterion("wx_key not between", value1, value2, "wxKey");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerIsNull() {
			addCriterion("alipay_partner is null");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerIsNotNull() {
			addCriterion("alipay_partner is not null");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerEqualTo(String value) {
			addCriterion("alipay_partner =", value, "alipayPartner");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerNotEqualTo(String value) {
			addCriterion("alipay_partner <>", value, "alipayPartner");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerGreaterThan(String value) {
			addCriterion("alipay_partner >", value, "alipayPartner");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerGreaterThanOrEqualTo(String value) {
			addCriterion("alipay_partner >=", value, "alipayPartner");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerLessThan(String value) {
			addCriterion("alipay_partner <", value, "alipayPartner");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerLessThanOrEqualTo(String value) {
			addCriterion("alipay_partner <=", value, "alipayPartner");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerLike(String value) {
			addCriterion("alipay_partner like", value, "alipayPartner");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerNotLike(String value) {
			addCriterion("alipay_partner not like", value, "alipayPartner");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerIn(List<String> values) {
			addCriterion("alipay_partner in", values, "alipayPartner");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerNotIn(List<String> values) {
			addCriterion("alipay_partner not in", values, "alipayPartner");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerBetween(String value1, String value2) {
			addCriterion("alipay_partner between", value1, value2, "alipayPartner");
			return (Criteria) this;
		}

		public Criteria andAlipayPartnerNotBetween(String value1, String value2) {
			addCriterion("alipay_partner not between", value1, value2, "alipayPartner");
			return (Criteria) this;
		}

		public Criteria andParamIsNull() {
			addCriterion("param is null");
			return (Criteria) this;
		}

		public Criteria andParamIsNotNull() {
			addCriterion("param is not null");
			return (Criteria) this;
		}

		public Criteria andParamEqualTo(String value) {
			addCriterion("param =", value, "param");
			return (Criteria) this;
		}

		public Criteria andParamNotEqualTo(String value) {
			addCriterion("param <>", value, "param");
			return (Criteria) this;
		}

		public Criteria andParamGreaterThan(String value) {
			addCriterion("param >", value, "param");
			return (Criteria) this;
		}

		public Criteria andParamGreaterThanOrEqualTo(String value) {
			addCriterion("param >=", value, "param");
			return (Criteria) this;
		}

		public Criteria andParamLessThan(String value) {
			addCriterion("param <", value, "param");
			return (Criteria) this;
		}

		public Criteria andParamLessThanOrEqualTo(String value) {
			addCriterion("param <=", value, "param");
			return (Criteria) this;
		}

		public Criteria andParamLike(String value) {
			addCriterion("param like", value, "param");
			return (Criteria) this;
		}

		public Criteria andParamNotLike(String value) {
			addCriterion("param not like", value, "param");
			return (Criteria) this;
		}

		public Criteria andParamIn(List<String> values) {
			addCriterion("param in", values, "param");
			return (Criteria) this;
		}

		public Criteria andParamNotIn(List<String> values) {
			addCriterion("param not in", values, "param");
			return (Criteria) this;
		}

		public Criteria andParamBetween(String value1, String value2) {
			addCriterion("param between", value1, value2, "param");
			return (Criteria) this;
		}

		public Criteria andParamNotBetween(String value1, String value2) {
			addCriterion("param not between", value1, value2, "param");
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