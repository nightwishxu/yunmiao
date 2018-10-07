package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class PawnContinueExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PawnContinueExample(){
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

		public Criteria andPawnIdIsNull() {
			addCriterion("pawn_id is null");
			return (Criteria) this;
		}

		public Criteria andPawnIdIsNotNull() {
			addCriterion("pawn_id is not null");
			return (Criteria) this;
		}

		public Criteria andPawnIdEqualTo(Integer value) {
			addCriterion("pawn_id =", value, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdNotEqualTo(Integer value) {
			addCriterion("pawn_id <>", value, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdGreaterThan(Integer value) {
			addCriterion("pawn_id >", value, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("pawn_id >=", value, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdLessThan(Integer value) {
			addCriterion("pawn_id <", value, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdLessThanOrEqualTo(Integer value) {
			addCriterion("pawn_id <=", value, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdIn(List<Integer> values) {
			addCriterion("pawn_id in", values, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdNotIn(List<Integer> values) {
			addCriterion("pawn_id not in", values, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdBetween(Integer value1, Integer value2) {
			addCriterion("pawn_id between", value1, value2, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnIdNotBetween(Integer value1, Integer value2) {
			addCriterion("pawn_id not between", value1, value2, "pawnId");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeIsNull() {
			addCriterion("pawn_ticket_code is null");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeIsNotNull() {
			addCriterion("pawn_ticket_code is not null");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeEqualTo(String value) {
			addCriterion("pawn_ticket_code =", value, "pawnTicketCode");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeNotEqualTo(String value) {
			addCriterion("pawn_ticket_code <>", value, "pawnTicketCode");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeGreaterThan(String value) {
			addCriterion("pawn_ticket_code >", value, "pawnTicketCode");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeGreaterThanOrEqualTo(String value) {
			addCriterion("pawn_ticket_code >=", value, "pawnTicketCode");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeLessThan(String value) {
			addCriterion("pawn_ticket_code <", value, "pawnTicketCode");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeLessThanOrEqualTo(String value) {
			addCriterion("pawn_ticket_code <=", value, "pawnTicketCode");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeLike(String value) {
			addCriterion("pawn_ticket_code like", value, "pawnTicketCode");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeNotLike(String value) {
			addCriterion("pawn_ticket_code not like", value, "pawnTicketCode");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeIn(List<String> values) {
			addCriterion("pawn_ticket_code in", values, "pawnTicketCode");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeNotIn(List<String> values) {
			addCriterion("pawn_ticket_code not in", values, "pawnTicketCode");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeBetween(String value1, String value2) {
			addCriterion("pawn_ticket_code between", value1, value2, "pawnTicketCode");
			return (Criteria) this;
		}

		public Criteria andPawnTicketCodeNotBetween(String value1, String value2) {
			addCriterion("pawn_ticket_code not between", value1, value2, "pawnTicketCode");
			return (Criteria) this;
		}

		public Criteria andPawnLastEndTimeIsNull() {
			addCriterion("pawn_last_end_time is null");
			return (Criteria) this;
		}

		public Criteria andPawnLastEndTimeIsNotNull() {
			addCriterion("pawn_last_end_time is not null");
			return (Criteria) this;
		}

		public Criteria andPawnLastEndTimeEqualTo(java.util.Date value) {
			addCriterion("pawn_last_end_time =", value, "pawnLastEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnLastEndTimeNotEqualTo(java.util.Date value) {
			addCriterion("pawn_last_end_time <>", value, "pawnLastEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnLastEndTimeGreaterThan(java.util.Date value) {
			addCriterion("pawn_last_end_time >", value, "pawnLastEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnLastEndTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("pawn_last_end_time >=", value, "pawnLastEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnLastEndTimeLessThan(java.util.Date value) {
			addCriterion("pawn_last_end_time <", value, "pawnLastEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnLastEndTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("pawn_last_end_time <=", value, "pawnLastEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnLastEndTimeIn(List<java.util.Date> values) {
			addCriterion("pawn_last_end_time in", values, "pawnLastEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnLastEndTimeNotIn(List<java.util.Date> values) {
			addCriterion("pawn_last_end_time not in", values, "pawnLastEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnLastEndTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("pawn_last_end_time between", value1, value2, "pawnLastEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnLastEndTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("pawn_last_end_time not between", value1, value2, "pawnLastEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnEndTimeIsNull() {
			addCriterion("pawn_end_time is null");
			return (Criteria) this;
		}

		public Criteria andPawnEndTimeIsNotNull() {
			addCriterion("pawn_end_time is not null");
			return (Criteria) this;
		}

		public Criteria andPawnEndTimeEqualTo(java.util.Date value) {
			addCriterion("pawn_end_time =", value, "pawnEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnEndTimeNotEqualTo(java.util.Date value) {
			addCriterion("pawn_end_time <>", value, "pawnEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnEndTimeGreaterThan(java.util.Date value) {
			addCriterion("pawn_end_time >", value, "pawnEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnEndTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("pawn_end_time >=", value, "pawnEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnEndTimeLessThan(java.util.Date value) {
			addCriterion("pawn_end_time <", value, "pawnEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnEndTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("pawn_end_time <=", value, "pawnEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnEndTimeIn(List<java.util.Date> values) {
			addCriterion("pawn_end_time in", values, "pawnEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnEndTimeNotIn(List<java.util.Date> values) {
			addCriterion("pawn_end_time not in", values, "pawnEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnEndTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("pawn_end_time between", value1, value2, "pawnEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnEndTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("pawn_end_time not between", value1, value2, "pawnEndTime");
			return (Criteria) this;
		}

		public Criteria andPawnMonthIsNull() {
			addCriterion("pawn_month is null");
			return (Criteria) this;
		}

		public Criteria andPawnMonthIsNotNull() {
			addCriterion("pawn_month is not null");
			return (Criteria) this;
		}

		public Criteria andPawnMonthEqualTo(Integer value) {
			addCriterion("pawn_month =", value, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthNotEqualTo(Integer value) {
			addCriterion("pawn_month <>", value, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthGreaterThan(Integer value) {
			addCriterion("pawn_month >", value, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthGreaterThanOrEqualTo(Integer value) {
			addCriterion("pawn_month >=", value, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthLessThan(Integer value) {
			addCriterion("pawn_month <", value, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthLessThanOrEqualTo(Integer value) {
			addCriterion("pawn_month <=", value, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthIn(List<Integer> values) {
			addCriterion("pawn_month in", values, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthNotIn(List<Integer> values) {
			addCriterion("pawn_month not in", values, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthBetween(Integer value1, Integer value2) {
			addCriterion("pawn_month between", value1, value2, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMonthNotBetween(Integer value1, Integer value2) {
			addCriterion("pawn_month not between", value1, value2, "pawnMonth");
			return (Criteria) this;
		}

		public Criteria andPawnMoneyIsNull() {
			addCriterion("pawn_money is null");
			return (Criteria) this;
		}

		public Criteria andPawnMoneyIsNotNull() {
			addCriterion("pawn_money is not null");
			return (Criteria) this;
		}

		public Criteria andPawnMoneyEqualTo(java.math.BigDecimal value) {
			addCriterion("pawn_money =", value, "pawnMoney");
			return (Criteria) this;
		}

		public Criteria andPawnMoneyNotEqualTo(java.math.BigDecimal value) {
			addCriterion("pawn_money <>", value, "pawnMoney");
			return (Criteria) this;
		}

		public Criteria andPawnMoneyGreaterThan(java.math.BigDecimal value) {
			addCriterion("pawn_money >", value, "pawnMoney");
			return (Criteria) this;
		}

		public Criteria andPawnMoneyGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("pawn_money >=", value, "pawnMoney");
			return (Criteria) this;
		}

		public Criteria andPawnMoneyLessThan(java.math.BigDecimal value) {
			addCriterion("pawn_money <", value, "pawnMoney");
			return (Criteria) this;
		}

		public Criteria andPawnMoneyLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("pawn_money <=", value, "pawnMoney");
			return (Criteria) this;
		}

		public Criteria andPawnMoneyIn(List<java.math.BigDecimal> values) {
			addCriterion("pawn_money in", values, "pawnMoney");
			return (Criteria) this;
		}

		public Criteria andPawnMoneyNotIn(List<java.math.BigDecimal> values) {
			addCriterion("pawn_money not in", values, "pawnMoney");
			return (Criteria) this;
		}

		public Criteria andPawnMoneyBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("pawn_money between", value1, value2, "pawnMoney");
			return (Criteria) this;
		}

		public Criteria andPawnMoneyNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("pawn_money not between", value1, value2, "pawnMoney");
			return (Criteria) this;
		}

		public Criteria andPawnInterestIsNull() {
			addCriterion("pawn_interest is null");
			return (Criteria) this;
		}

		public Criteria andPawnInterestIsNotNull() {
			addCriterion("pawn_interest is not null");
			return (Criteria) this;
		}

		public Criteria andPawnInterestEqualTo(java.math.BigDecimal value) {
			addCriterion("pawn_interest =", value, "pawnInterest");
			return (Criteria) this;
		}

		public Criteria andPawnInterestNotEqualTo(java.math.BigDecimal value) {
			addCriterion("pawn_interest <>", value, "pawnInterest");
			return (Criteria) this;
		}

		public Criteria andPawnInterestGreaterThan(java.math.BigDecimal value) {
			addCriterion("pawn_interest >", value, "pawnInterest");
			return (Criteria) this;
		}

		public Criteria andPawnInterestGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("pawn_interest >=", value, "pawnInterest");
			return (Criteria) this;
		}

		public Criteria andPawnInterestLessThan(java.math.BigDecimal value) {
			addCriterion("pawn_interest <", value, "pawnInterest");
			return (Criteria) this;
		}

		public Criteria andPawnInterestLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("pawn_interest <=", value, "pawnInterest");
			return (Criteria) this;
		}

		public Criteria andPawnInterestIn(List<java.math.BigDecimal> values) {
			addCriterion("pawn_interest in", values, "pawnInterest");
			return (Criteria) this;
		}

		public Criteria andPawnInterestNotIn(List<java.math.BigDecimal> values) {
			addCriterion("pawn_interest not in", values, "pawnInterest");
			return (Criteria) this;
		}

		public Criteria andPawnInterestBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("pawn_interest between", value1, value2, "pawnInterest");
			return (Criteria) this;
		}

		public Criteria andPawnInterestNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("pawn_interest not between", value1, value2, "pawnInterest");
			return (Criteria) this;
		}

		public Criteria andPawnOverdueIsNull() {
			addCriterion("pawn_overdue is null");
			return (Criteria) this;
		}

		public Criteria andPawnOverdueIsNotNull() {
			addCriterion("pawn_overdue is not null");
			return (Criteria) this;
		}

		public Criteria andPawnOverdueEqualTo(java.math.BigDecimal value) {
			addCriterion("pawn_overdue =", value, "pawnOverdue");
			return (Criteria) this;
		}

		public Criteria andPawnOverdueNotEqualTo(java.math.BigDecimal value) {
			addCriterion("pawn_overdue <>", value, "pawnOverdue");
			return (Criteria) this;
		}

		public Criteria andPawnOverdueGreaterThan(java.math.BigDecimal value) {
			addCriterion("pawn_overdue >", value, "pawnOverdue");
			return (Criteria) this;
		}

		public Criteria andPawnOverdueGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("pawn_overdue >=", value, "pawnOverdue");
			return (Criteria) this;
		}

		public Criteria andPawnOverdueLessThan(java.math.BigDecimal value) {
			addCriterion("pawn_overdue <", value, "pawnOverdue");
			return (Criteria) this;
		}

		public Criteria andPawnOverdueLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("pawn_overdue <=", value, "pawnOverdue");
			return (Criteria) this;
		}

		public Criteria andPawnOverdueIn(List<java.math.BigDecimal> values) {
			addCriterion("pawn_overdue in", values, "pawnOverdue");
			return (Criteria) this;
		}

		public Criteria andPawnOverdueNotIn(List<java.math.BigDecimal> values) {
			addCriterion("pawn_overdue not in", values, "pawnOverdue");
			return (Criteria) this;
		}

		public Criteria andPawnOverdueBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("pawn_overdue between", value1, value2, "pawnOverdue");
			return (Criteria) this;
		}

		public Criteria andPawnOverdueNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("pawn_overdue not between", value1, value2, "pawnOverdue");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyIsNull() {
			addCriterion("platform_money is null");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyIsNotNull() {
			addCriterion("platform_money is not null");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_money =", value, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyNotEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_money <>", value, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyGreaterThan(java.math.BigDecimal value) {
			addCriterion("platform_money >", value, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_money >=", value, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyLessThan(java.math.BigDecimal value) {
			addCriterion("platform_money <", value, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_money <=", value, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyIn(List<java.math.BigDecimal> values) {
			addCriterion("platform_money in", values, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyNotIn(List<java.math.BigDecimal> values) {
			addCriterion("platform_money not in", values, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("platform_money between", value1, value2, "platformMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformMoneyNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("platform_money not between", value1, value2, "platformMoney");
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

		public Criteria andPlatformStateIsNull() {
			addCriterion("platform_state is null");
			return (Criteria) this;
		}

		public Criteria andPlatformStateIsNotNull() {
			addCriterion("platform_state is not null");
			return (Criteria) this;
		}

		public Criteria andPlatformStateEqualTo(Integer value) {
			addCriterion("platform_state =", value, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateNotEqualTo(Integer value) {
			addCriterion("platform_state <>", value, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateGreaterThan(Integer value) {
			addCriterion("platform_state >", value, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("platform_state >=", value, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateLessThan(Integer value) {
			addCriterion("platform_state <", value, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateLessThanOrEqualTo(Integer value) {
			addCriterion("platform_state <=", value, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateIn(List<Integer> values) {
			addCriterion("platform_state in", values, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateNotIn(List<Integer> values) {
			addCriterion("platform_state not in", values, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateBetween(Integer value1, Integer value2) {
			addCriterion("platform_state between", value1, value2, "platformState");
			return (Criteria) this;
		}

		public Criteria andPlatformStateNotBetween(Integer value1, Integer value2) {
			addCriterion("platform_state not between", value1, value2, "platformState");
			return (Criteria) this;
		}

		public Criteria andPayTicketIsNull() {
			addCriterion("pay_ticket is null");
			return (Criteria) this;
		}

		public Criteria andPayTicketIsNotNull() {
			addCriterion("pay_ticket is not null");
			return (Criteria) this;
		}

		public Criteria andPayTicketEqualTo(String value) {
			addCriterion("pay_ticket =", value, "payTicket");
			return (Criteria) this;
		}

		public Criteria andPayTicketNotEqualTo(String value) {
			addCriterion("pay_ticket <>", value, "payTicket");
			return (Criteria) this;
		}

		public Criteria andPayTicketGreaterThan(String value) {
			addCriterion("pay_ticket >", value, "payTicket");
			return (Criteria) this;
		}

		public Criteria andPayTicketGreaterThanOrEqualTo(String value) {
			addCriterion("pay_ticket >=", value, "payTicket");
			return (Criteria) this;
		}

		public Criteria andPayTicketLessThan(String value) {
			addCriterion("pay_ticket <", value, "payTicket");
			return (Criteria) this;
		}

		public Criteria andPayTicketLessThanOrEqualTo(String value) {
			addCriterion("pay_ticket <=", value, "payTicket");
			return (Criteria) this;
		}

		public Criteria andPayTicketLike(String value) {
			addCriterion("pay_ticket like", value, "payTicket");
			return (Criteria) this;
		}

		public Criteria andPayTicketNotLike(String value) {
			addCriterion("pay_ticket not like", value, "payTicket");
			return (Criteria) this;
		}

		public Criteria andPayTicketIn(List<String> values) {
			addCriterion("pay_ticket in", values, "payTicket");
			return (Criteria) this;
		}

		public Criteria andPayTicketNotIn(List<String> values) {
			addCriterion("pay_ticket not in", values, "payTicket");
			return (Criteria) this;
		}

		public Criteria andPayTicketBetween(String value1, String value2) {
			addCriterion("pay_ticket between", value1, value2, "payTicket");
			return (Criteria) this;
		}

		public Criteria andPayTicketNotBetween(String value1, String value2) {
			addCriterion("pay_ticket not between", value1, value2, "payTicket");
			return (Criteria) this;
		}

		public Criteria andPawnTicketIsNull() {
			addCriterion("pawn_ticket is null");
			return (Criteria) this;
		}

		public Criteria andPawnTicketIsNotNull() {
			addCriterion("pawn_ticket is not null");
			return (Criteria) this;
		}

		public Criteria andPawnTicketEqualTo(String value) {
			addCriterion("pawn_ticket =", value, "pawnTicket");
			return (Criteria) this;
		}

		public Criteria andPawnTicketNotEqualTo(String value) {
			addCriterion("pawn_ticket <>", value, "pawnTicket");
			return (Criteria) this;
		}

		public Criteria andPawnTicketGreaterThan(String value) {
			addCriterion("pawn_ticket >", value, "pawnTicket");
			return (Criteria) this;
		}

		public Criteria andPawnTicketGreaterThanOrEqualTo(String value) {
			addCriterion("pawn_ticket >=", value, "pawnTicket");
			return (Criteria) this;
		}

		public Criteria andPawnTicketLessThan(String value) {
			addCriterion("pawn_ticket <", value, "pawnTicket");
			return (Criteria) this;
		}

		public Criteria andPawnTicketLessThanOrEqualTo(String value) {
			addCriterion("pawn_ticket <=", value, "pawnTicket");
			return (Criteria) this;
		}

		public Criteria andPawnTicketLike(String value) {
			addCriterion("pawn_ticket like", value, "pawnTicket");
			return (Criteria) this;
		}

		public Criteria andPawnTicketNotLike(String value) {
			addCriterion("pawn_ticket not like", value, "pawnTicket");
			return (Criteria) this;
		}

		public Criteria andPawnTicketIn(List<String> values) {
			addCriterion("pawn_ticket in", values, "pawnTicket");
			return (Criteria) this;
		}

		public Criteria andPawnTicketNotIn(List<String> values) {
			addCriterion("pawn_ticket not in", values, "pawnTicket");
			return (Criteria) this;
		}

		public Criteria andPawnTicketBetween(String value1, String value2) {
			addCriterion("pawn_ticket between", value1, value2, "pawnTicket");
			return (Criteria) this;
		}

		public Criteria andPawnTicketNotBetween(String value1, String value2) {
			addCriterion("pawn_ticket not between", value1, value2, "pawnTicket");
			return (Criteria) this;
		}

		public Criteria andPayTimeIsNull() {
			addCriterion("pay_time is null");
			return (Criteria) this;
		}

		public Criteria andPayTimeIsNotNull() {
			addCriterion("pay_time is not null");
			return (Criteria) this;
		}

		public Criteria andPayTimeEqualTo(java.util.Date value) {
			addCriterion("pay_time =", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeNotEqualTo(java.util.Date value) {
			addCriterion("pay_time <>", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeGreaterThan(java.util.Date value) {
			addCriterion("pay_time >", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("pay_time >=", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeLessThan(java.util.Date value) {
			addCriterion("pay_time <", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("pay_time <=", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeIn(List<java.util.Date> values) {
			addCriterion("pay_time in", values, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeNotIn(List<java.util.Date> values) {
			addCriterion("pay_time not in", values, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("pay_time between", value1, value2, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("pay_time not between", value1, value2, "payTime");
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

		public Criteria andUserBankIsNull() {
			addCriterion("user_bank is null");
			return (Criteria) this;
		}

		public Criteria andUserBankIsNotNull() {
			addCriterion("user_bank is not null");
			return (Criteria) this;
		}

		public Criteria andUserBankEqualTo(String value) {
			addCriterion("user_bank =", value, "userBank");
			return (Criteria) this;
		}

		public Criteria andUserBankNotEqualTo(String value) {
			addCriterion("user_bank <>", value, "userBank");
			return (Criteria) this;
		}

		public Criteria andUserBankGreaterThan(String value) {
			addCriterion("user_bank >", value, "userBank");
			return (Criteria) this;
		}

		public Criteria andUserBankGreaterThanOrEqualTo(String value) {
			addCriterion("user_bank >=", value, "userBank");
			return (Criteria) this;
		}

		public Criteria andUserBankLessThan(String value) {
			addCriterion("user_bank <", value, "userBank");
			return (Criteria) this;
		}

		public Criteria andUserBankLessThanOrEqualTo(String value) {
			addCriterion("user_bank <=", value, "userBank");
			return (Criteria) this;
		}

		public Criteria andUserBankLike(String value) {
			addCriterion("user_bank like", value, "userBank");
			return (Criteria) this;
		}

		public Criteria andUserBankNotLike(String value) {
			addCriterion("user_bank not like", value, "userBank");
			return (Criteria) this;
		}

		public Criteria andUserBankIn(List<String> values) {
			addCriterion("user_bank in", values, "userBank");
			return (Criteria) this;
		}

		public Criteria andUserBankNotIn(List<String> values) {
			addCriterion("user_bank not in", values, "userBank");
			return (Criteria) this;
		}

		public Criteria andUserBankBetween(String value1, String value2) {
			addCriterion("user_bank between", value1, value2, "userBank");
			return (Criteria) this;
		}

		public Criteria andUserBankNotBetween(String value1, String value2) {
			addCriterion("user_bank not between", value1, value2, "userBank");
			return (Criteria) this;
		}

		public Criteria andUserBankCardIsNull() {
			addCriterion("user_bank_card is null");
			return (Criteria) this;
		}

		public Criteria andUserBankCardIsNotNull() {
			addCriterion("user_bank_card is not null");
			return (Criteria) this;
		}

		public Criteria andUserBankCardEqualTo(String value) {
			addCriterion("user_bank_card =", value, "userBankCard");
			return (Criteria) this;
		}

		public Criteria andUserBankCardNotEqualTo(String value) {
			addCriterion("user_bank_card <>", value, "userBankCard");
			return (Criteria) this;
		}

		public Criteria andUserBankCardGreaterThan(String value) {
			addCriterion("user_bank_card >", value, "userBankCard");
			return (Criteria) this;
		}

		public Criteria andUserBankCardGreaterThanOrEqualTo(String value) {
			addCriterion("user_bank_card >=", value, "userBankCard");
			return (Criteria) this;
		}

		public Criteria andUserBankCardLessThan(String value) {
			addCriterion("user_bank_card <", value, "userBankCard");
			return (Criteria) this;
		}

		public Criteria andUserBankCardLessThanOrEqualTo(String value) {
			addCriterion("user_bank_card <=", value, "userBankCard");
			return (Criteria) this;
		}

		public Criteria andUserBankCardLike(String value) {
			addCriterion("user_bank_card like", value, "userBankCard");
			return (Criteria) this;
		}

		public Criteria andUserBankCardNotLike(String value) {
			addCriterion("user_bank_card not like", value, "userBankCard");
			return (Criteria) this;
		}

		public Criteria andUserBankCardIn(List<String> values) {
			addCriterion("user_bank_card in", values, "userBankCard");
			return (Criteria) this;
		}

		public Criteria andUserBankCardNotIn(List<String> values) {
			addCriterion("user_bank_card not in", values, "userBankCard");
			return (Criteria) this;
		}

		public Criteria andUserBankCardBetween(String value1, String value2) {
			addCriterion("user_bank_card between", value1, value2, "userBankCard");
			return (Criteria) this;
		}

		public Criteria andUserBankCardNotBetween(String value1, String value2) {
			addCriterion("user_bank_card not between", value1, value2, "userBankCard");
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