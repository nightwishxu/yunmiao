package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class UserBalanceLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserBalanceLogExample(){
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

		public Criteria andCidIsNull() {
			addCriterion("cid is null");
			return (Criteria) this;
		}

		public Criteria andCidIsNotNull() {
			addCriterion("cid is not null");
			return (Criteria) this;
		}

		public Criteria andCidEqualTo(Integer value) {
			addCriterion("cid =", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotEqualTo(Integer value) {
			addCriterion("cid <>", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidGreaterThan(Integer value) {
			addCriterion("cid >", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidGreaterThanOrEqualTo(Integer value) {
			addCriterion("cid >=", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidLessThan(Integer value) {
			addCriterion("cid <", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidLessThanOrEqualTo(Integer value) {
			addCriterion("cid <=", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidIn(List<Integer> values) {
			addCriterion("cid in", values, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotIn(List<Integer> values) {
			addCriterion("cid not in", values, "cid");
			return (Criteria) this;
		}

		public Criteria andCidBetween(Integer value1, Integer value2) {
			addCriterion("cid between", value1, value2, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotBetween(Integer value1, Integer value2) {
			addCriterion("cid not between", value1, value2, "cid");
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

		public Criteria andAmountIsNull() {
			addCriterion("amount is null");
			return (Criteria) this;
		}

		public Criteria andAmountIsNotNull() {
			addCriterion("amount is not null");
			return (Criteria) this;
		}

		public Criteria andAmountEqualTo(java.math.BigDecimal value) {
			addCriterion("amount =", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotEqualTo(java.math.BigDecimal value) {
			addCriterion("amount <>", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountGreaterThan(java.math.BigDecimal value) {
			addCriterion("amount >", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("amount >=", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountLessThan(java.math.BigDecimal value) {
			addCriterion("amount <", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("amount <=", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountIn(List<java.math.BigDecimal> values) {
			addCriterion("amount in", values, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotIn(List<java.math.BigDecimal> values) {
			addCriterion("amount not in", values, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("amount between", value1, value2, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("amount not between", value1, value2, "amount");
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

		public Criteria andItemIsNull() {
			addCriterion("item is null");
			return (Criteria) this;
		}

		public Criteria andItemIsNotNull() {
			addCriterion("item is not null");
			return (Criteria) this;
		}

		public Criteria andItemEqualTo(String value) {
			addCriterion("item =", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemNotEqualTo(String value) {
			addCriterion("item <>", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemGreaterThan(String value) {
			addCriterion("item >", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemGreaterThanOrEqualTo(String value) {
			addCriterion("item >=", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemLessThan(String value) {
			addCriterion("item <", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemLessThanOrEqualTo(String value) {
			addCriterion("item <=", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemLike(String value) {
			addCriterion("item like", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemNotLike(String value) {
			addCriterion("item not like", value, "item");
			return (Criteria) this;
		}

		public Criteria andItemIn(List<String> values) {
			addCriterion("item in", values, "item");
			return (Criteria) this;
		}

		public Criteria andItemNotIn(List<String> values) {
			addCriterion("item not in", values, "item");
			return (Criteria) this;
		}

		public Criteria andItemBetween(String value1, String value2) {
			addCriterion("item between", value1, value2, "item");
			return (Criteria) this;
		}

		public Criteria andItemNotBetween(String value1, String value2) {
			addCriterion("item not between", value1, value2, "item");
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

		public Criteria andTradeTypeIsNull() {
			addCriterion("trade_type is null");
			return (Criteria) this;
		}

		public Criteria andTradeTypeIsNotNull() {
			addCriterion("trade_type is not null");
			return (Criteria) this;
		}

		public Criteria andTradeTypeEqualTo(Integer value) {
			addCriterion("trade_type =", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeNotEqualTo(Integer value) {
			addCriterion("trade_type <>", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeGreaterThan(Integer value) {
			addCriterion("trade_type >", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("trade_type >=", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeLessThan(Integer value) {
			addCriterion("trade_type <", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeLessThanOrEqualTo(Integer value) {
			addCriterion("trade_type <=", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeIn(List<Integer> values) {
			addCriterion("trade_type in", values, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeNotIn(List<Integer> values) {
			addCriterion("trade_type not in", values, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeBetween(Integer value1, Integer value2) {
			addCriterion("trade_type between", value1, value2, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("trade_type not between", value1, value2, "tradeType");
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

		public Criteria andTradeTicketIsNull() {
			addCriterion("trade_ticket is null");
			return (Criteria) this;
		}

		public Criteria andTradeTicketIsNotNull() {
			addCriterion("trade_ticket is not null");
			return (Criteria) this;
		}

		public Criteria andTradeTicketEqualTo(String value) {
			addCriterion("trade_ticket =", value, "tradeTicket");
			return (Criteria) this;
		}

		public Criteria andTradeTicketNotEqualTo(String value) {
			addCriterion("trade_ticket <>", value, "tradeTicket");
			return (Criteria) this;
		}

		public Criteria andTradeTicketGreaterThan(String value) {
			addCriterion("trade_ticket >", value, "tradeTicket");
			return (Criteria) this;
		}

		public Criteria andTradeTicketGreaterThanOrEqualTo(String value) {
			addCriterion("trade_ticket >=", value, "tradeTicket");
			return (Criteria) this;
		}

		public Criteria andTradeTicketLessThan(String value) {
			addCriterion("trade_ticket <", value, "tradeTicket");
			return (Criteria) this;
		}

		public Criteria andTradeTicketLessThanOrEqualTo(String value) {
			addCriterion("trade_ticket <=", value, "tradeTicket");
			return (Criteria) this;
		}

		public Criteria andTradeTicketLike(String value) {
			addCriterion("trade_ticket like", value, "tradeTicket");
			return (Criteria) this;
		}

		public Criteria andTradeTicketNotLike(String value) {
			addCriterion("trade_ticket not like", value, "tradeTicket");
			return (Criteria) this;
		}

		public Criteria andTradeTicketIn(List<String> values) {
			addCriterion("trade_ticket in", values, "tradeTicket");
			return (Criteria) this;
		}

		public Criteria andTradeTicketNotIn(List<String> values) {
			addCriterion("trade_ticket not in", values, "tradeTicket");
			return (Criteria) this;
		}

		public Criteria andTradeTicketBetween(String value1, String value2) {
			addCriterion("trade_ticket between", value1, value2, "tradeTicket");
			return (Criteria) this;
		}

		public Criteria andTradeTicketNotBetween(String value1, String value2) {
			addCriterion("trade_ticket not between", value1, value2, "tradeTicket");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankIsNull() {
			addCriterion("trade_card_bank is null");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankIsNotNull() {
			addCriterion("trade_card_bank is not null");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankEqualTo(String value) {
			addCriterion("trade_card_bank =", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankNotEqualTo(String value) {
			addCriterion("trade_card_bank <>", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankGreaterThan(String value) {
			addCriterion("trade_card_bank >", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankGreaterThanOrEqualTo(String value) {
			addCriterion("trade_card_bank >=", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankLessThan(String value) {
			addCriterion("trade_card_bank <", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankLessThanOrEqualTo(String value) {
			addCriterion("trade_card_bank <=", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankLike(String value) {
			addCriterion("trade_card_bank like", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankNotLike(String value) {
			addCriterion("trade_card_bank not like", value, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankIn(List<String> values) {
			addCriterion("trade_card_bank in", values, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankNotIn(List<String> values) {
			addCriterion("trade_card_bank not in", values, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankBetween(String value1, String value2) {
			addCriterion("trade_card_bank between", value1, value2, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardBankNotBetween(String value1, String value2) {
			addCriterion("trade_card_bank not between", value1, value2, "tradeCardBank");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeIsNull() {
			addCriterion("trade_card_code is null");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeIsNotNull() {
			addCriterion("trade_card_code is not null");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeEqualTo(String value) {
			addCriterion("trade_card_code =", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeNotEqualTo(String value) {
			addCriterion("trade_card_code <>", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeGreaterThan(String value) {
			addCriterion("trade_card_code >", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeGreaterThanOrEqualTo(String value) {
			addCriterion("trade_card_code >=", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeLessThan(String value) {
			addCriterion("trade_card_code <", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeLessThanOrEqualTo(String value) {
			addCriterion("trade_card_code <=", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeLike(String value) {
			addCriterion("trade_card_code like", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeNotLike(String value) {
			addCriterion("trade_card_code not like", value, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeIn(List<String> values) {
			addCriterion("trade_card_code in", values, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeNotIn(List<String> values) {
			addCriterion("trade_card_code not in", values, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeBetween(String value1, String value2) {
			addCriterion("trade_card_code between", value1, value2, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andTradeCardCodeNotBetween(String value1, String value2) {
			addCriterion("trade_card_code not between", value1, value2, "tradeCardCode");
			return (Criteria) this;
		}

		public Criteria andOrgIdIsNull() {
			addCriterion("org_id is null");
			return (Criteria) this;
		}

		public Criteria andOrgIdIsNotNull() {
			addCriterion("org_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrgIdEqualTo(Integer value) {
			addCriterion("org_id =", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdNotEqualTo(Integer value) {
			addCriterion("org_id <>", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdGreaterThan(Integer value) {
			addCriterion("org_id >", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("org_id >=", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdLessThan(Integer value) {
			addCriterion("org_id <", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
			addCriterion("org_id <=", value, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdIn(List<Integer> values) {
			addCriterion("org_id in", values, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdNotIn(List<Integer> values) {
			addCriterion("org_id not in", values, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdBetween(Integer value1, Integer value2) {
			addCriterion("org_id between", value1, value2, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
			addCriterion("org_id not between", value1, value2, "orgId");
			return (Criteria) this;
		}

		public Criteria andOrgNameIsNull() {
			addCriterion("org_name is null");
			return (Criteria) this;
		}

		public Criteria andOrgNameIsNotNull() {
			addCriterion("org_name is not null");
			return (Criteria) this;
		}

		public Criteria andOrgNameEqualTo(String value) {
			addCriterion("org_name =", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameNotEqualTo(String value) {
			addCriterion("org_name <>", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameGreaterThan(String value) {
			addCriterion("org_name >", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
			addCriterion("org_name >=", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameLessThan(String value) {
			addCriterion("org_name <", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameLessThanOrEqualTo(String value) {
			addCriterion("org_name <=", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameLike(String value) {
			addCriterion("org_name like", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameNotLike(String value) {
			addCriterion("org_name not like", value, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameIn(List<String> values) {
			addCriterion("org_name in", values, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameNotIn(List<String> values) {
			addCriterion("org_name not in", values, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameBetween(String value1, String value2) {
			addCriterion("org_name between", value1, value2, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgNameNotBetween(String value1, String value2) {
			addCriterion("org_name not between", value1, value2, "orgName");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneIsNull() {
			addCriterion("org_phone is null");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneIsNotNull() {
			addCriterion("org_phone is not null");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneEqualTo(String value) {
			addCriterion("org_phone =", value, "orgPhone");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneNotEqualTo(String value) {
			addCriterion("org_phone <>", value, "orgPhone");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneGreaterThan(String value) {
			addCriterion("org_phone >", value, "orgPhone");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("org_phone >=", value, "orgPhone");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneLessThan(String value) {
			addCriterion("org_phone <", value, "orgPhone");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneLessThanOrEqualTo(String value) {
			addCriterion("org_phone <=", value, "orgPhone");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneLike(String value) {
			addCriterion("org_phone like", value, "orgPhone");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneNotLike(String value) {
			addCriterion("org_phone not like", value, "orgPhone");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneIn(List<String> values) {
			addCriterion("org_phone in", values, "orgPhone");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneNotIn(List<String> values) {
			addCriterion("org_phone not in", values, "orgPhone");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneBetween(String value1, String value2) {
			addCriterion("org_phone between", value1, value2, "orgPhone");
			return (Criteria) this;
		}

		public Criteria andOrgPhoneNotBetween(String value1, String value2) {
			addCriterion("org_phone not between", value1, value2, "orgPhone");
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