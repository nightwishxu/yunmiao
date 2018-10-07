package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class UserPawnExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserPawnExample(){
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

		public Criteria andLoansPriceIsNull() {
			addCriterion("loans_price is null");
			return (Criteria) this;
		}

		public Criteria andLoansPriceIsNotNull() {
			addCriterion("loans_price is not null");
			return (Criteria) this;
		}

		public Criteria andLoansPriceEqualTo(java.math.BigDecimal value) {
			addCriterion("loans_price =", value, "loansPrice");
			return (Criteria) this;
		}

		public Criteria andLoansPriceNotEqualTo(java.math.BigDecimal value) {
			addCriterion("loans_price <>", value, "loansPrice");
			return (Criteria) this;
		}

		public Criteria andLoansPriceGreaterThan(java.math.BigDecimal value) {
			addCriterion("loans_price >", value, "loansPrice");
			return (Criteria) this;
		}

		public Criteria andLoansPriceGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("loans_price >=", value, "loansPrice");
			return (Criteria) this;
		}

		public Criteria andLoansPriceLessThan(java.math.BigDecimal value) {
			addCriterion("loans_price <", value, "loansPrice");
			return (Criteria) this;
		}

		public Criteria andLoansPriceLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("loans_price <=", value, "loansPrice");
			return (Criteria) this;
		}

		public Criteria andLoansPriceIn(List<java.math.BigDecimal> values) {
			addCriterion("loans_price in", values, "loansPrice");
			return (Criteria) this;
		}

		public Criteria andLoansPriceNotIn(List<java.math.BigDecimal> values) {
			addCriterion("loans_price not in", values, "loansPrice");
			return (Criteria) this;
		}

		public Criteria andLoansPriceBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("loans_price between", value1, value2, "loansPrice");
			return (Criteria) this;
		}

		public Criteria andLoansPriceNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("loans_price not between", value1, value2, "loansPrice");
			return (Criteria) this;
		}

		public Criteria andLoansRateIsNull() {
			addCriterion("loans_rate is null");
			return (Criteria) this;
		}

		public Criteria andLoansRateIsNotNull() {
			addCriterion("loans_rate is not null");
			return (Criteria) this;
		}

		public Criteria andLoansRateEqualTo(java.math.BigDecimal value) {
			addCriterion("loans_rate =", value, "loansRate");
			return (Criteria) this;
		}

		public Criteria andLoansRateNotEqualTo(java.math.BigDecimal value) {
			addCriterion("loans_rate <>", value, "loansRate");
			return (Criteria) this;
		}

		public Criteria andLoansRateGreaterThan(java.math.BigDecimal value) {
			addCriterion("loans_rate >", value, "loansRate");
			return (Criteria) this;
		}

		public Criteria andLoansRateGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("loans_rate >=", value, "loansRate");
			return (Criteria) this;
		}

		public Criteria andLoansRateLessThan(java.math.BigDecimal value) {
			addCriterion("loans_rate <", value, "loansRate");
			return (Criteria) this;
		}

		public Criteria andLoansRateLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("loans_rate <=", value, "loansRate");
			return (Criteria) this;
		}

		public Criteria andLoansRateIn(List<java.math.BigDecimal> values) {
			addCriterion("loans_rate in", values, "loansRate");
			return (Criteria) this;
		}

		public Criteria andLoansRateNotIn(List<java.math.BigDecimal> values) {
			addCriterion("loans_rate not in", values, "loansRate");
			return (Criteria) this;
		}

		public Criteria andLoansRateBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("loans_rate between", value1, value2, "loansRate");
			return (Criteria) this;
		}

		public Criteria andLoansRateNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("loans_rate not between", value1, value2, "loansRate");
			return (Criteria) this;
		}

		public Criteria andIsVerifyIsNull() {
			addCriterion("is_verify is null");
			return (Criteria) this;
		}

		public Criteria andIsVerifyIsNotNull() {
			addCriterion("is_verify is not null");
			return (Criteria) this;
		}

		public Criteria andIsVerifyEqualTo(Integer value) {
			addCriterion("is_verify =", value, "isVerify");
			return (Criteria) this;
		}

		public Criteria andIsVerifyNotEqualTo(Integer value) {
			addCriterion("is_verify <>", value, "isVerify");
			return (Criteria) this;
		}

		public Criteria andIsVerifyGreaterThan(Integer value) {
			addCriterion("is_verify >", value, "isVerify");
			return (Criteria) this;
		}

		public Criteria andIsVerifyGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_verify >=", value, "isVerify");
			return (Criteria) this;
		}

		public Criteria andIsVerifyLessThan(Integer value) {
			addCriterion("is_verify <", value, "isVerify");
			return (Criteria) this;
		}

		public Criteria andIsVerifyLessThanOrEqualTo(Integer value) {
			addCriterion("is_verify <=", value, "isVerify");
			return (Criteria) this;
		}

		public Criteria andIsVerifyIn(List<Integer> values) {
			addCriterion("is_verify in", values, "isVerify");
			return (Criteria) this;
		}

		public Criteria andIsVerifyNotIn(List<Integer> values) {
			addCriterion("is_verify not in", values, "isVerify");
			return (Criteria) this;
		}

		public Criteria andIsVerifyBetween(Integer value1, Integer value2) {
			addCriterion("is_verify between", value1, value2, "isVerify");
			return (Criteria) this;
		}

		public Criteria andIsVerifyNotBetween(Integer value1, Integer value2) {
			addCriterion("is_verify not between", value1, value2, "isVerify");
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

		public Criteria andOrgUserIdIsNull() {
			addCriterion("org_user_id is null");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdIsNotNull() {
			addCriterion("org_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdEqualTo(Integer value) {
			addCriterion("org_user_id =", value, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdNotEqualTo(Integer value) {
			addCriterion("org_user_id <>", value, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdGreaterThan(Integer value) {
			addCriterion("org_user_id >", value, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("org_user_id >=", value, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdLessThan(Integer value) {
			addCriterion("org_user_id <", value, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("org_user_id <=", value, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdIn(List<Integer> values) {
			addCriterion("org_user_id in", values, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdNotIn(List<Integer> values) {
			addCriterion("org_user_id not in", values, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdBetween(Integer value1, Integer value2) {
			addCriterion("org_user_id between", value1, value2, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("org_user_id not between", value1, value2, "orgUserId");
			return (Criteria) this;
		}

		public Criteria andOrgSelectedTimeIsNull() {
			addCriterion("org_selected_time is null");
			return (Criteria) this;
		}

		public Criteria andOrgSelectedTimeIsNotNull() {
			addCriterion("org_selected_time is not null");
			return (Criteria) this;
		}

		public Criteria andOrgSelectedTimeEqualTo(java.util.Date value) {
			addCriterion("org_selected_time =", value, "orgSelectedTime");
			return (Criteria) this;
		}

		public Criteria andOrgSelectedTimeNotEqualTo(java.util.Date value) {
			addCriterion("org_selected_time <>", value, "orgSelectedTime");
			return (Criteria) this;
		}

		public Criteria andOrgSelectedTimeGreaterThan(java.util.Date value) {
			addCriterion("org_selected_time >", value, "orgSelectedTime");
			return (Criteria) this;
		}

		public Criteria andOrgSelectedTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("org_selected_time >=", value, "orgSelectedTime");
			return (Criteria) this;
		}

		public Criteria andOrgSelectedTimeLessThan(java.util.Date value) {
			addCriterion("org_selected_time <", value, "orgSelectedTime");
			return (Criteria) this;
		}

		public Criteria andOrgSelectedTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("org_selected_time <=", value, "orgSelectedTime");
			return (Criteria) this;
		}

		public Criteria andOrgSelectedTimeIn(List<java.util.Date> values) {
			addCriterion("org_selected_time in", values, "orgSelectedTime");
			return (Criteria) this;
		}

		public Criteria andOrgSelectedTimeNotIn(List<java.util.Date> values) {
			addCriterion("org_selected_time not in", values, "orgSelectedTime");
			return (Criteria) this;
		}

		public Criteria andOrgSelectedTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("org_selected_time between", value1, value2, "orgSelectedTime");
			return (Criteria) this;
		}

		public Criteria andOrgSelectedTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("org_selected_time not between", value1, value2, "orgSelectedTime");
			return (Criteria) this;
		}

		public Criteria andPayeeNameIsNull() {
			addCriterion("payee_name is null");
			return (Criteria) this;
		}

		public Criteria andPayeeNameIsNotNull() {
			addCriterion("payee_name is not null");
			return (Criteria) this;
		}

		public Criteria andPayeeNameEqualTo(String value) {
			addCriterion("payee_name =", value, "payeeName");
			return (Criteria) this;
		}

		public Criteria andPayeeNameNotEqualTo(String value) {
			addCriterion("payee_name <>", value, "payeeName");
			return (Criteria) this;
		}

		public Criteria andPayeeNameGreaterThan(String value) {
			addCriterion("payee_name >", value, "payeeName");
			return (Criteria) this;
		}

		public Criteria andPayeeNameGreaterThanOrEqualTo(String value) {
			addCriterion("payee_name >=", value, "payeeName");
			return (Criteria) this;
		}

		public Criteria andPayeeNameLessThan(String value) {
			addCriterion("payee_name <", value, "payeeName");
			return (Criteria) this;
		}

		public Criteria andPayeeNameLessThanOrEqualTo(String value) {
			addCriterion("payee_name <=", value, "payeeName");
			return (Criteria) this;
		}

		public Criteria andPayeeNameLike(String value) {
			addCriterion("payee_name like", value, "payeeName");
			return (Criteria) this;
		}

		public Criteria andPayeeNameNotLike(String value) {
			addCriterion("payee_name not like", value, "payeeName");
			return (Criteria) this;
		}

		public Criteria andPayeeNameIn(List<String> values) {
			addCriterion("payee_name in", values, "payeeName");
			return (Criteria) this;
		}

		public Criteria andPayeeNameNotIn(List<String> values) {
			addCriterion("payee_name not in", values, "payeeName");
			return (Criteria) this;
		}

		public Criteria andPayeeNameBetween(String value1, String value2) {
			addCriterion("payee_name between", value1, value2, "payeeName");
			return (Criteria) this;
		}

		public Criteria andPayeeNameNotBetween(String value1, String value2) {
			addCriterion("payee_name not between", value1, value2, "payeeName");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneIsNull() {
			addCriterion("payee_phone is null");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneIsNotNull() {
			addCriterion("payee_phone is not null");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneEqualTo(String value) {
			addCriterion("payee_phone =", value, "payeePhone");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneNotEqualTo(String value) {
			addCriterion("payee_phone <>", value, "payeePhone");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneGreaterThan(String value) {
			addCriterion("payee_phone >", value, "payeePhone");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneGreaterThanOrEqualTo(String value) {
			addCriterion("payee_phone >=", value, "payeePhone");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneLessThan(String value) {
			addCriterion("payee_phone <", value, "payeePhone");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneLessThanOrEqualTo(String value) {
			addCriterion("payee_phone <=", value, "payeePhone");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneLike(String value) {
			addCriterion("payee_phone like", value, "payeePhone");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneNotLike(String value) {
			addCriterion("payee_phone not like", value, "payeePhone");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneIn(List<String> values) {
			addCriterion("payee_phone in", values, "payeePhone");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneNotIn(List<String> values) {
			addCriterion("payee_phone not in", values, "payeePhone");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneBetween(String value1, String value2) {
			addCriterion("payee_phone between", value1, value2, "payeePhone");
			return (Criteria) this;
		}

		public Criteria andPayeePhoneNotBetween(String value1, String value2) {
			addCriterion("payee_phone not between", value1, value2, "payeePhone");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameIsNull() {
			addCriterion("payee_bank_name is null");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameIsNotNull() {
			addCriterion("payee_bank_name is not null");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameEqualTo(String value) {
			addCriterion("payee_bank_name =", value, "payeeBankName");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameNotEqualTo(String value) {
			addCriterion("payee_bank_name <>", value, "payeeBankName");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameGreaterThan(String value) {
			addCriterion("payee_bank_name >", value, "payeeBankName");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameGreaterThanOrEqualTo(String value) {
			addCriterion("payee_bank_name >=", value, "payeeBankName");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameLessThan(String value) {
			addCriterion("payee_bank_name <", value, "payeeBankName");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameLessThanOrEqualTo(String value) {
			addCriterion("payee_bank_name <=", value, "payeeBankName");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameLike(String value) {
			addCriterion("payee_bank_name like", value, "payeeBankName");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameNotLike(String value) {
			addCriterion("payee_bank_name not like", value, "payeeBankName");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameIn(List<String> values) {
			addCriterion("payee_bank_name in", values, "payeeBankName");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameNotIn(List<String> values) {
			addCriterion("payee_bank_name not in", values, "payeeBankName");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameBetween(String value1, String value2) {
			addCriterion("payee_bank_name between", value1, value2, "payeeBankName");
			return (Criteria) this;
		}

		public Criteria andPayeeBankNameNotBetween(String value1, String value2) {
			addCriterion("payee_bank_name not between", value1, value2, "payeeBankName");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeIsNull() {
			addCriterion("payee_bank_card_code is null");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeIsNotNull() {
			addCriterion("payee_bank_card_code is not null");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeEqualTo(String value) {
			addCriterion("payee_bank_card_code =", value, "payeeBankCardCode");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeNotEqualTo(String value) {
			addCriterion("payee_bank_card_code <>", value, "payeeBankCardCode");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeGreaterThan(String value) {
			addCriterion("payee_bank_card_code >", value, "payeeBankCardCode");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeGreaterThanOrEqualTo(String value) {
			addCriterion("payee_bank_card_code >=", value, "payeeBankCardCode");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeLessThan(String value) {
			addCriterion("payee_bank_card_code <", value, "payeeBankCardCode");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeLessThanOrEqualTo(String value) {
			addCriterion("payee_bank_card_code <=", value, "payeeBankCardCode");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeLike(String value) {
			addCriterion("payee_bank_card_code like", value, "payeeBankCardCode");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeNotLike(String value) {
			addCriterion("payee_bank_card_code not like", value, "payeeBankCardCode");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeIn(List<String> values) {
			addCriterion("payee_bank_card_code in", values, "payeeBankCardCode");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeNotIn(List<String> values) {
			addCriterion("payee_bank_card_code not in", values, "payeeBankCardCode");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeBetween(String value1, String value2) {
			addCriterion("payee_bank_card_code between", value1, value2, "payeeBankCardCode");
			return (Criteria) this;
		}

		public Criteria andPayeeBankCardCodeNotBetween(String value1, String value2) {
			addCriterion("payee_bank_card_code not between", value1, value2, "payeeBankCardCode");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketIsNull() {
			addCriterion("payee_ticket is null");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketIsNotNull() {
			addCriterion("payee_ticket is not null");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketEqualTo(String value) {
			addCriterion("payee_ticket =", value, "payeeTicket");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketNotEqualTo(String value) {
			addCriterion("payee_ticket <>", value, "payeeTicket");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketGreaterThan(String value) {
			addCriterion("payee_ticket >", value, "payeeTicket");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketGreaterThanOrEqualTo(String value) {
			addCriterion("payee_ticket >=", value, "payeeTicket");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketLessThan(String value) {
			addCriterion("payee_ticket <", value, "payeeTicket");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketLessThanOrEqualTo(String value) {
			addCriterion("payee_ticket <=", value, "payeeTicket");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketLike(String value) {
			addCriterion("payee_ticket like", value, "payeeTicket");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketNotLike(String value) {
			addCriterion("payee_ticket not like", value, "payeeTicket");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketIn(List<String> values) {
			addCriterion("payee_ticket in", values, "payeeTicket");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketNotIn(List<String> values) {
			addCriterion("payee_ticket not in", values, "payeeTicket");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketBetween(String value1, String value2) {
			addCriterion("payee_ticket between", value1, value2, "payeeTicket");
			return (Criteria) this;
		}

		public Criteria andPayeeTicketNotBetween(String value1, String value2) {
			addCriterion("payee_ticket not between", value1, value2, "payeeTicket");
			return (Criteria) this;
		}

		public Criteria andPayeeStateIsNull() {
			addCriterion("payee_state is null");
			return (Criteria) this;
		}

		public Criteria andPayeeStateIsNotNull() {
			addCriterion("payee_state is not null");
			return (Criteria) this;
		}

		public Criteria andPayeeStateEqualTo(Integer value) {
			addCriterion("payee_state =", value, "payeeState");
			return (Criteria) this;
		}

		public Criteria andPayeeStateNotEqualTo(Integer value) {
			addCriterion("payee_state <>", value, "payeeState");
			return (Criteria) this;
		}

		public Criteria andPayeeStateGreaterThan(Integer value) {
			addCriterion("payee_state >", value, "payeeState");
			return (Criteria) this;
		}

		public Criteria andPayeeStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("payee_state >=", value, "payeeState");
			return (Criteria) this;
		}

		public Criteria andPayeeStateLessThan(Integer value) {
			addCriterion("payee_state <", value, "payeeState");
			return (Criteria) this;
		}

		public Criteria andPayeeStateLessThanOrEqualTo(Integer value) {
			addCriterion("payee_state <=", value, "payeeState");
			return (Criteria) this;
		}

		public Criteria andPayeeStateIn(List<Integer> values) {
			addCriterion("payee_state in", values, "payeeState");
			return (Criteria) this;
		}

		public Criteria andPayeeStateNotIn(List<Integer> values) {
			addCriterion("payee_state not in", values, "payeeState");
			return (Criteria) this;
		}

		public Criteria andPayeeStateBetween(Integer value1, Integer value2) {
			addCriterion("payee_state between", value1, value2, "payeeState");
			return (Criteria) this;
		}

		public Criteria andPayeeStateNotBetween(Integer value1, Integer value2) {
			addCriterion("payee_state not between", value1, value2, "payeeState");
			return (Criteria) this;
		}

		public Criteria andPayNameIsNull() {
			addCriterion("pay_name is null");
			return (Criteria) this;
		}

		public Criteria andPayNameIsNotNull() {
			addCriterion("pay_name is not null");
			return (Criteria) this;
		}

		public Criteria andPayNameEqualTo(String value) {
			addCriterion("pay_name =", value, "payName");
			return (Criteria) this;
		}

		public Criteria andPayNameNotEqualTo(String value) {
			addCriterion("pay_name <>", value, "payName");
			return (Criteria) this;
		}

		public Criteria andPayNameGreaterThan(String value) {
			addCriterion("pay_name >", value, "payName");
			return (Criteria) this;
		}

		public Criteria andPayNameGreaterThanOrEqualTo(String value) {
			addCriterion("pay_name >=", value, "payName");
			return (Criteria) this;
		}

		public Criteria andPayNameLessThan(String value) {
			addCriterion("pay_name <", value, "payName");
			return (Criteria) this;
		}

		public Criteria andPayNameLessThanOrEqualTo(String value) {
			addCriterion("pay_name <=", value, "payName");
			return (Criteria) this;
		}

		public Criteria andPayNameLike(String value) {
			addCriterion("pay_name like", value, "payName");
			return (Criteria) this;
		}

		public Criteria andPayNameNotLike(String value) {
			addCriterion("pay_name not like", value, "payName");
			return (Criteria) this;
		}

		public Criteria andPayNameIn(List<String> values) {
			addCriterion("pay_name in", values, "payName");
			return (Criteria) this;
		}

		public Criteria andPayNameNotIn(List<String> values) {
			addCriterion("pay_name not in", values, "payName");
			return (Criteria) this;
		}

		public Criteria andPayNameBetween(String value1, String value2) {
			addCriterion("pay_name between", value1, value2, "payName");
			return (Criteria) this;
		}

		public Criteria andPayNameNotBetween(String value1, String value2) {
			addCriterion("pay_name not between", value1, value2, "payName");
			return (Criteria) this;
		}

		public Criteria andPayPhoneIsNull() {
			addCriterion("pay_phone is null");
			return (Criteria) this;
		}

		public Criteria andPayPhoneIsNotNull() {
			addCriterion("pay_phone is not null");
			return (Criteria) this;
		}

		public Criteria andPayPhoneEqualTo(String value) {
			addCriterion("pay_phone =", value, "payPhone");
			return (Criteria) this;
		}

		public Criteria andPayPhoneNotEqualTo(String value) {
			addCriterion("pay_phone <>", value, "payPhone");
			return (Criteria) this;
		}

		public Criteria andPayPhoneGreaterThan(String value) {
			addCriterion("pay_phone >", value, "payPhone");
			return (Criteria) this;
		}

		public Criteria andPayPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("pay_phone >=", value, "payPhone");
			return (Criteria) this;
		}

		public Criteria andPayPhoneLessThan(String value) {
			addCriterion("pay_phone <", value, "payPhone");
			return (Criteria) this;
		}

		public Criteria andPayPhoneLessThanOrEqualTo(String value) {
			addCriterion("pay_phone <=", value, "payPhone");
			return (Criteria) this;
		}

		public Criteria andPayPhoneLike(String value) {
			addCriterion("pay_phone like", value, "payPhone");
			return (Criteria) this;
		}

		public Criteria andPayPhoneNotLike(String value) {
			addCriterion("pay_phone not like", value, "payPhone");
			return (Criteria) this;
		}

		public Criteria andPayPhoneIn(List<String> values) {
			addCriterion("pay_phone in", values, "payPhone");
			return (Criteria) this;
		}

		public Criteria andPayPhoneNotIn(List<String> values) {
			addCriterion("pay_phone not in", values, "payPhone");
			return (Criteria) this;
		}

		public Criteria andPayPhoneBetween(String value1, String value2) {
			addCriterion("pay_phone between", value1, value2, "payPhone");
			return (Criteria) this;
		}

		public Criteria andPayPhoneNotBetween(String value1, String value2) {
			addCriterion("pay_phone not between", value1, value2, "payPhone");
			return (Criteria) this;
		}

		public Criteria andPayBankNameIsNull() {
			addCriterion("pay_bank_name is null");
			return (Criteria) this;
		}

		public Criteria andPayBankNameIsNotNull() {
			addCriterion("pay_bank_name is not null");
			return (Criteria) this;
		}

		public Criteria andPayBankNameEqualTo(String value) {
			addCriterion("pay_bank_name =", value, "payBankName");
			return (Criteria) this;
		}

		public Criteria andPayBankNameNotEqualTo(String value) {
			addCriterion("pay_bank_name <>", value, "payBankName");
			return (Criteria) this;
		}

		public Criteria andPayBankNameGreaterThan(String value) {
			addCriterion("pay_bank_name >", value, "payBankName");
			return (Criteria) this;
		}

		public Criteria andPayBankNameGreaterThanOrEqualTo(String value) {
			addCriterion("pay_bank_name >=", value, "payBankName");
			return (Criteria) this;
		}

		public Criteria andPayBankNameLessThan(String value) {
			addCriterion("pay_bank_name <", value, "payBankName");
			return (Criteria) this;
		}

		public Criteria andPayBankNameLessThanOrEqualTo(String value) {
			addCriterion("pay_bank_name <=", value, "payBankName");
			return (Criteria) this;
		}

		public Criteria andPayBankNameLike(String value) {
			addCriterion("pay_bank_name like", value, "payBankName");
			return (Criteria) this;
		}

		public Criteria andPayBankNameNotLike(String value) {
			addCriterion("pay_bank_name not like", value, "payBankName");
			return (Criteria) this;
		}

		public Criteria andPayBankNameIn(List<String> values) {
			addCriterion("pay_bank_name in", values, "payBankName");
			return (Criteria) this;
		}

		public Criteria andPayBankNameNotIn(List<String> values) {
			addCriterion("pay_bank_name not in", values, "payBankName");
			return (Criteria) this;
		}

		public Criteria andPayBankNameBetween(String value1, String value2) {
			addCriterion("pay_bank_name between", value1, value2, "payBankName");
			return (Criteria) this;
		}

		public Criteria andPayBankNameNotBetween(String value1, String value2) {
			addCriterion("pay_bank_name not between", value1, value2, "payBankName");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeIsNull() {
			addCriterion("pay_bacnk_card_code is null");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeIsNotNull() {
			addCriterion("pay_bacnk_card_code is not null");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeEqualTo(String value) {
			addCriterion("pay_bacnk_card_code =", value, "payBacnkCardCode");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeNotEqualTo(String value) {
			addCriterion("pay_bacnk_card_code <>", value, "payBacnkCardCode");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeGreaterThan(String value) {
			addCriterion("pay_bacnk_card_code >", value, "payBacnkCardCode");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeGreaterThanOrEqualTo(String value) {
			addCriterion("pay_bacnk_card_code >=", value, "payBacnkCardCode");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeLessThan(String value) {
			addCriterion("pay_bacnk_card_code <", value, "payBacnkCardCode");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeLessThanOrEqualTo(String value) {
			addCriterion("pay_bacnk_card_code <=", value, "payBacnkCardCode");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeLike(String value) {
			addCriterion("pay_bacnk_card_code like", value, "payBacnkCardCode");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeNotLike(String value) {
			addCriterion("pay_bacnk_card_code not like", value, "payBacnkCardCode");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeIn(List<String> values) {
			addCriterion("pay_bacnk_card_code in", values, "payBacnkCardCode");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeNotIn(List<String> values) {
			addCriterion("pay_bacnk_card_code not in", values, "payBacnkCardCode");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeBetween(String value1, String value2) {
			addCriterion("pay_bacnk_card_code between", value1, value2, "payBacnkCardCode");
			return (Criteria) this;
		}

		public Criteria andPayBacnkCardCodeNotBetween(String value1, String value2) {
			addCriterion("pay_bacnk_card_code not between", value1, value2, "payBacnkCardCode");
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

		public Criteria andUserStateIsNull() {
			addCriterion("user_state is null");
			return (Criteria) this;
		}

		public Criteria andUserStateIsNotNull() {
			addCriterion("user_state is not null");
			return (Criteria) this;
		}

		public Criteria andUserStateEqualTo(Integer value) {
			addCriterion("user_state =", value, "userState");
			return (Criteria) this;
		}

		public Criteria andUserStateNotEqualTo(Integer value) {
			addCriterion("user_state <>", value, "userState");
			return (Criteria) this;
		}

		public Criteria andUserStateGreaterThan(Integer value) {
			addCriterion("user_state >", value, "userState");
			return (Criteria) this;
		}

		public Criteria andUserStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_state >=", value, "userState");
			return (Criteria) this;
		}

		public Criteria andUserStateLessThan(Integer value) {
			addCriterion("user_state <", value, "userState");
			return (Criteria) this;
		}

		public Criteria andUserStateLessThanOrEqualTo(Integer value) {
			addCriterion("user_state <=", value, "userState");
			return (Criteria) this;
		}

		public Criteria andUserStateIn(List<Integer> values) {
			addCriterion("user_state in", values, "userState");
			return (Criteria) this;
		}

		public Criteria andUserStateNotIn(List<Integer> values) {
			addCriterion("user_state not in", values, "userState");
			return (Criteria) this;
		}

		public Criteria andUserStateBetween(Integer value1, Integer value2) {
			addCriterion("user_state between", value1, value2, "userState");
			return (Criteria) this;
		}

		public Criteria andUserStateNotBetween(Integer value1, Integer value2) {
			addCriterion("user_state not between", value1, value2, "userState");
			return (Criteria) this;
		}

		public Criteria andPawnBeginTimeIsNull() {
			addCriterion("pawn_begin_time is null");
			return (Criteria) this;
		}

		public Criteria andPawnBeginTimeIsNotNull() {
			addCriterion("pawn_begin_time is not null");
			return (Criteria) this;
		}

		public Criteria andPawnBeginTimeEqualTo(java.util.Date value) {
			addCriterion("pawn_begin_time =", value, "pawnBeginTime");
			return (Criteria) this;
		}

		public Criteria andPawnBeginTimeNotEqualTo(java.util.Date value) {
			addCriterion("pawn_begin_time <>", value, "pawnBeginTime");
			return (Criteria) this;
		}

		public Criteria andPawnBeginTimeGreaterThan(java.util.Date value) {
			addCriterion("pawn_begin_time >", value, "pawnBeginTime");
			return (Criteria) this;
		}

		public Criteria andPawnBeginTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("pawn_begin_time >=", value, "pawnBeginTime");
			return (Criteria) this;
		}

		public Criteria andPawnBeginTimeLessThan(java.util.Date value) {
			addCriterion("pawn_begin_time <", value, "pawnBeginTime");
			return (Criteria) this;
		}

		public Criteria andPawnBeginTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("pawn_begin_time <=", value, "pawnBeginTime");
			return (Criteria) this;
		}

		public Criteria andPawnBeginTimeIn(List<java.util.Date> values) {
			addCriterion("pawn_begin_time in", values, "pawnBeginTime");
			return (Criteria) this;
		}

		public Criteria andPawnBeginTimeNotIn(List<java.util.Date> values) {
			addCriterion("pawn_begin_time not in", values, "pawnBeginTime");
			return (Criteria) this;
		}

		public Criteria andPawnBeginTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("pawn_begin_time between", value1, value2, "pawnBeginTime");
			return (Criteria) this;
		}

		public Criteria andPawnBeginTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("pawn_begin_time not between", value1, value2, "pawnBeginTime");
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

		public Criteria andBeginMoneyIsNull() {
			addCriterion("begin_money is null");
			return (Criteria) this;
		}

		public Criteria andBeginMoneyIsNotNull() {
			addCriterion("begin_money is not null");
			return (Criteria) this;
		}

		public Criteria andBeginMoneyEqualTo(java.math.BigDecimal value) {
			addCriterion("begin_money =", value, "beginMoney");
			return (Criteria) this;
		}

		public Criteria andBeginMoneyNotEqualTo(java.math.BigDecimal value) {
			addCriterion("begin_money <>", value, "beginMoney");
			return (Criteria) this;
		}

		public Criteria andBeginMoneyGreaterThan(java.math.BigDecimal value) {
			addCriterion("begin_money >", value, "beginMoney");
			return (Criteria) this;
		}

		public Criteria andBeginMoneyGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("begin_money >=", value, "beginMoney");
			return (Criteria) this;
		}

		public Criteria andBeginMoneyLessThan(java.math.BigDecimal value) {
			addCriterion("begin_money <", value, "beginMoney");
			return (Criteria) this;
		}

		public Criteria andBeginMoneyLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("begin_money <=", value, "beginMoney");
			return (Criteria) this;
		}

		public Criteria andBeginMoneyIn(List<java.math.BigDecimal> values) {
			addCriterion("begin_money in", values, "beginMoney");
			return (Criteria) this;
		}

		public Criteria andBeginMoneyNotIn(List<java.math.BigDecimal> values) {
			addCriterion("begin_money not in", values, "beginMoney");
			return (Criteria) this;
		}

		public Criteria andBeginMoneyBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("begin_money between", value1, value2, "beginMoney");
			return (Criteria) this;
		}

		public Criteria andBeginMoneyNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("begin_money not between", value1, value2, "beginMoney");
			return (Criteria) this;
		}

		public Criteria andBeginPawnMonthIsNull() {
			addCriterion("begin_pawn_month is null");
			return (Criteria) this;
		}

		public Criteria andBeginPawnMonthIsNotNull() {
			addCriterion("begin_pawn_month is not null");
			return (Criteria) this;
		}

		public Criteria andBeginPawnMonthEqualTo(Integer value) {
			addCriterion("begin_pawn_month =", value, "beginPawnMonth");
			return (Criteria) this;
		}

		public Criteria andBeginPawnMonthNotEqualTo(Integer value) {
			addCriterion("begin_pawn_month <>", value, "beginPawnMonth");
			return (Criteria) this;
		}

		public Criteria andBeginPawnMonthGreaterThan(Integer value) {
			addCriterion("begin_pawn_month >", value, "beginPawnMonth");
			return (Criteria) this;
		}

		public Criteria andBeginPawnMonthGreaterThanOrEqualTo(Integer value) {
			addCriterion("begin_pawn_month >=", value, "beginPawnMonth");
			return (Criteria) this;
		}

		public Criteria andBeginPawnMonthLessThan(Integer value) {
			addCriterion("begin_pawn_month <", value, "beginPawnMonth");
			return (Criteria) this;
		}

		public Criteria andBeginPawnMonthLessThanOrEqualTo(Integer value) {
			addCriterion("begin_pawn_month <=", value, "beginPawnMonth");
			return (Criteria) this;
		}

		public Criteria andBeginPawnMonthIn(List<Integer> values) {
			addCriterion("begin_pawn_month in", values, "beginPawnMonth");
			return (Criteria) this;
		}

		public Criteria andBeginPawnMonthNotIn(List<Integer> values) {
			addCriterion("begin_pawn_month not in", values, "beginPawnMonth");
			return (Criteria) this;
		}

		public Criteria andBeginPawnMonthBetween(Integer value1, Integer value2) {
			addCriterion("begin_pawn_month between", value1, value2, "beginPawnMonth");
			return (Criteria) this;
		}

		public Criteria andBeginPawnMonthNotBetween(Integer value1, Integer value2) {
			addCriterion("begin_pawn_month not between", value1, value2, "beginPawnMonth");
			return (Criteria) this;
		}

		public Criteria andBeginPawnEndTimeIsNull() {
			addCriterion("begin_pawn_end_time is null");
			return (Criteria) this;
		}

		public Criteria andBeginPawnEndTimeIsNotNull() {
			addCriterion("begin_pawn_end_time is not null");
			return (Criteria) this;
		}

		public Criteria andBeginPawnEndTimeEqualTo(java.util.Date value) {
			addCriterion("begin_pawn_end_time =", value, "beginPawnEndTime");
			return (Criteria) this;
		}

		public Criteria andBeginPawnEndTimeNotEqualTo(java.util.Date value) {
			addCriterion("begin_pawn_end_time <>", value, "beginPawnEndTime");
			return (Criteria) this;
		}

		public Criteria andBeginPawnEndTimeGreaterThan(java.util.Date value) {
			addCriterion("begin_pawn_end_time >", value, "beginPawnEndTime");
			return (Criteria) this;
		}

		public Criteria andBeginPawnEndTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("begin_pawn_end_time >=", value, "beginPawnEndTime");
			return (Criteria) this;
		}

		public Criteria andBeginPawnEndTimeLessThan(java.util.Date value) {
			addCriterion("begin_pawn_end_time <", value, "beginPawnEndTime");
			return (Criteria) this;
		}

		public Criteria andBeginPawnEndTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("begin_pawn_end_time <=", value, "beginPawnEndTime");
			return (Criteria) this;
		}

		public Criteria andBeginPawnEndTimeIn(List<java.util.Date> values) {
			addCriterion("begin_pawn_end_time in", values, "beginPawnEndTime");
			return (Criteria) this;
		}

		public Criteria andBeginPawnEndTimeNotIn(List<java.util.Date> values) {
			addCriterion("begin_pawn_end_time not in", values, "beginPawnEndTime");
			return (Criteria) this;
		}

		public Criteria andBeginPawnEndTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("begin_pawn_end_time between", value1, value2, "beginPawnEndTime");
			return (Criteria) this;
		}

		public Criteria andBeginPawnEndTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("begin_pawn_end_time not between", value1, value2, "beginPawnEndTime");
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

		public Criteria andPawnTimeIsNull() {
			addCriterion("pawn_time is null");
			return (Criteria) this;
		}

		public Criteria andPawnTimeIsNotNull() {
			addCriterion("pawn_time is not null");
			return (Criteria) this;
		}

		public Criteria andPawnTimeEqualTo(Integer value) {
			addCriterion("pawn_time =", value, "pawnTime");
			return (Criteria) this;
		}

		public Criteria andPawnTimeNotEqualTo(Integer value) {
			addCriterion("pawn_time <>", value, "pawnTime");
			return (Criteria) this;
		}

		public Criteria andPawnTimeGreaterThan(Integer value) {
			addCriterion("pawn_time >", value, "pawnTime");
			return (Criteria) this;
		}

		public Criteria andPawnTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("pawn_time >=", value, "pawnTime");
			return (Criteria) this;
		}

		public Criteria andPawnTimeLessThan(Integer value) {
			addCriterion("pawn_time <", value, "pawnTime");
			return (Criteria) this;
		}

		public Criteria andPawnTimeLessThanOrEqualTo(Integer value) {
			addCriterion("pawn_time <=", value, "pawnTime");
			return (Criteria) this;
		}

		public Criteria andPawnTimeIn(List<Integer> values) {
			addCriterion("pawn_time in", values, "pawnTime");
			return (Criteria) this;
		}

		public Criteria andPawnTimeNotIn(List<Integer> values) {
			addCriterion("pawn_time not in", values, "pawnTime");
			return (Criteria) this;
		}

		public Criteria andPawnTimeBetween(Integer value1, Integer value2) {
			addCriterion("pawn_time between", value1, value2, "pawnTime");
			return (Criteria) this;
		}

		public Criteria andPawnTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("pawn_time not between", value1, value2, "pawnTime");
			return (Criteria) this;
		}

		public Criteria andLastMoneyIsNull() {
			addCriterion("last_money is null");
			return (Criteria) this;
		}

		public Criteria andLastMoneyIsNotNull() {
			addCriterion("last_money is not null");
			return (Criteria) this;
		}

		public Criteria andLastMoneyEqualTo(java.math.BigDecimal value) {
			addCriterion("last_money =", value, "lastMoney");
			return (Criteria) this;
		}

		public Criteria andLastMoneyNotEqualTo(java.math.BigDecimal value) {
			addCriterion("last_money <>", value, "lastMoney");
			return (Criteria) this;
		}

		public Criteria andLastMoneyGreaterThan(java.math.BigDecimal value) {
			addCriterion("last_money >", value, "lastMoney");
			return (Criteria) this;
		}

		public Criteria andLastMoneyGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("last_money >=", value, "lastMoney");
			return (Criteria) this;
		}

		public Criteria andLastMoneyLessThan(java.math.BigDecimal value) {
			addCriterion("last_money <", value, "lastMoney");
			return (Criteria) this;
		}

		public Criteria andLastMoneyLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("last_money <=", value, "lastMoney");
			return (Criteria) this;
		}

		public Criteria andLastMoneyIn(List<java.math.BigDecimal> values) {
			addCriterion("last_money in", values, "lastMoney");
			return (Criteria) this;
		}

		public Criteria andLastMoneyNotIn(List<java.math.BigDecimal> values) {
			addCriterion("last_money not in", values, "lastMoney");
			return (Criteria) this;
		}

		public Criteria andLastMoneyBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("last_money between", value1, value2, "lastMoney");
			return (Criteria) this;
		}

		public Criteria andLastMoneyNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("last_money not between", value1, value2, "lastMoney");
			return (Criteria) this;
		}

		public Criteria andLastPawnMonthIsNull() {
			addCriterion("last_pawn_month is null");
			return (Criteria) this;
		}

		public Criteria andLastPawnMonthIsNotNull() {
			addCriterion("last_pawn_month is not null");
			return (Criteria) this;
		}

		public Criteria andLastPawnMonthEqualTo(Integer value) {
			addCriterion("last_pawn_month =", value, "lastPawnMonth");
			return (Criteria) this;
		}

		public Criteria andLastPawnMonthNotEqualTo(Integer value) {
			addCriterion("last_pawn_month <>", value, "lastPawnMonth");
			return (Criteria) this;
		}

		public Criteria andLastPawnMonthGreaterThan(Integer value) {
			addCriterion("last_pawn_month >", value, "lastPawnMonth");
			return (Criteria) this;
		}

		public Criteria andLastPawnMonthGreaterThanOrEqualTo(Integer value) {
			addCriterion("last_pawn_month >=", value, "lastPawnMonth");
			return (Criteria) this;
		}

		public Criteria andLastPawnMonthLessThan(Integer value) {
			addCriterion("last_pawn_month <", value, "lastPawnMonth");
			return (Criteria) this;
		}

		public Criteria andLastPawnMonthLessThanOrEqualTo(Integer value) {
			addCriterion("last_pawn_month <=", value, "lastPawnMonth");
			return (Criteria) this;
		}

		public Criteria andLastPawnMonthIn(List<Integer> values) {
			addCriterion("last_pawn_month in", values, "lastPawnMonth");
			return (Criteria) this;
		}

		public Criteria andLastPawnMonthNotIn(List<Integer> values) {
			addCriterion("last_pawn_month not in", values, "lastPawnMonth");
			return (Criteria) this;
		}

		public Criteria andLastPawnMonthBetween(Integer value1, Integer value2) {
			addCriterion("last_pawn_month between", value1, value2, "lastPawnMonth");
			return (Criteria) this;
		}

		public Criteria andLastPawnMonthNotBetween(Integer value1, Integer value2) {
			addCriterion("last_pawn_month not between", value1, value2, "lastPawnMonth");
			return (Criteria) this;
		}

		public Criteria andLastPawnTimeIsNull() {
			addCriterion("last_pawn_time is null");
			return (Criteria) this;
		}

		public Criteria andLastPawnTimeIsNotNull() {
			addCriterion("last_pawn_time is not null");
			return (Criteria) this;
		}

		public Criteria andLastPawnTimeEqualTo(java.util.Date value) {
			addCriterion("last_pawn_time =", value, "lastPawnTime");
			return (Criteria) this;
		}

		public Criteria andLastPawnTimeNotEqualTo(java.util.Date value) {
			addCriterion("last_pawn_time <>", value, "lastPawnTime");
			return (Criteria) this;
		}

		public Criteria andLastPawnTimeGreaterThan(java.util.Date value) {
			addCriterion("last_pawn_time >", value, "lastPawnTime");
			return (Criteria) this;
		}

		public Criteria andLastPawnTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("last_pawn_time >=", value, "lastPawnTime");
			return (Criteria) this;
		}

		public Criteria andLastPawnTimeLessThan(java.util.Date value) {
			addCriterion("last_pawn_time <", value, "lastPawnTime");
			return (Criteria) this;
		}

		public Criteria andLastPawnTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("last_pawn_time <=", value, "lastPawnTime");
			return (Criteria) this;
		}

		public Criteria andLastPawnTimeIn(List<java.util.Date> values) {
			addCriterion("last_pawn_time in", values, "lastPawnTime");
			return (Criteria) this;
		}

		public Criteria andLastPawnTimeNotIn(List<java.util.Date> values) {
			addCriterion("last_pawn_time not in", values, "lastPawnTime");
			return (Criteria) this;
		}

		public Criteria andLastPawnTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("last_pawn_time between", value1, value2, "lastPawnTime");
			return (Criteria) this;
		}

		public Criteria andLastPawnTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("last_pawn_time not between", value1, value2, "lastPawnTime");
			return (Criteria) this;
		}

		public Criteria andRateIsNull() {
			addCriterion("rate is null");
			return (Criteria) this;
		}

		public Criteria andRateIsNotNull() {
			addCriterion("rate is not null");
			return (Criteria) this;
		}

		public Criteria andRateEqualTo(java.math.BigDecimal value) {
			addCriterion("rate =", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateNotEqualTo(java.math.BigDecimal value) {
			addCriterion("rate <>", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateGreaterThan(java.math.BigDecimal value) {
			addCriterion("rate >", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("rate >=", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateLessThan(java.math.BigDecimal value) {
			addCriterion("rate <", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("rate <=", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateIn(List<java.math.BigDecimal> values) {
			addCriterion("rate in", values, "rate");
			return (Criteria) this;
		}

		public Criteria andRateNotIn(List<java.math.BigDecimal> values) {
			addCriterion("rate not in", values, "rate");
			return (Criteria) this;
		}

		public Criteria andRateBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("rate between", value1, value2, "rate");
			return (Criteria) this;
		}

		public Criteria andRateNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("rate not between", value1, value2, "rate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateIsNull() {
			addCriterion("money_rate is null");
			return (Criteria) this;
		}

		public Criteria andMoneyRateIsNotNull() {
			addCriterion("money_rate is not null");
			return (Criteria) this;
		}

		public Criteria andMoneyRateEqualTo(java.math.BigDecimal value) {
			addCriterion("money_rate =", value, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateNotEqualTo(java.math.BigDecimal value) {
			addCriterion("money_rate <>", value, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateGreaterThan(java.math.BigDecimal value) {
			addCriterion("money_rate >", value, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("money_rate >=", value, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateLessThan(java.math.BigDecimal value) {
			addCriterion("money_rate <", value, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("money_rate <=", value, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateIn(List<java.math.BigDecimal> values) {
			addCriterion("money_rate in", values, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateNotIn(List<java.math.BigDecimal> values) {
			addCriterion("money_rate not in", values, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("money_rate between", value1, value2, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andMoneyRateNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("money_rate not between", value1, value2, "moneyRate");
			return (Criteria) this;
		}

		public Criteria andOverdueRateIsNull() {
			addCriterion("overdue_rate is null");
			return (Criteria) this;
		}

		public Criteria andOverdueRateIsNotNull() {
			addCriterion("overdue_rate is not null");
			return (Criteria) this;
		}

		public Criteria andOverdueRateEqualTo(java.math.BigDecimal value) {
			addCriterion("overdue_rate =", value, "overdueRate");
			return (Criteria) this;
		}

		public Criteria andOverdueRateNotEqualTo(java.math.BigDecimal value) {
			addCriterion("overdue_rate <>", value, "overdueRate");
			return (Criteria) this;
		}

		public Criteria andOverdueRateGreaterThan(java.math.BigDecimal value) {
			addCriterion("overdue_rate >", value, "overdueRate");
			return (Criteria) this;
		}

		public Criteria andOverdueRateGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("overdue_rate >=", value, "overdueRate");
			return (Criteria) this;
		}

		public Criteria andOverdueRateLessThan(java.math.BigDecimal value) {
			addCriterion("overdue_rate <", value, "overdueRate");
			return (Criteria) this;
		}

		public Criteria andOverdueRateLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("overdue_rate <=", value, "overdueRate");
			return (Criteria) this;
		}

		public Criteria andOverdueRateIn(List<java.math.BigDecimal> values) {
			addCriterion("overdue_rate in", values, "overdueRate");
			return (Criteria) this;
		}

		public Criteria andOverdueRateNotIn(List<java.math.BigDecimal> values) {
			addCriterion("overdue_rate not in", values, "overdueRate");
			return (Criteria) this;
		}

		public Criteria andOverdueRateBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("overdue_rate between", value1, value2, "overdueRate");
			return (Criteria) this;
		}

		public Criteria andOverdueRateNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("overdue_rate not between", value1, value2, "overdueRate");
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

		public Criteria andUserMoneyIsNull() {
			addCriterion("user_money is null");
			return (Criteria) this;
		}

		public Criteria andUserMoneyIsNotNull() {
			addCriterion("user_money is not null");
			return (Criteria) this;
		}

		public Criteria andUserMoneyEqualTo(java.math.BigDecimal value) {
			addCriterion("user_money =", value, "userMoney");
			return (Criteria) this;
		}

		public Criteria andUserMoneyNotEqualTo(java.math.BigDecimal value) {
			addCriterion("user_money <>", value, "userMoney");
			return (Criteria) this;
		}

		public Criteria andUserMoneyGreaterThan(java.math.BigDecimal value) {
			addCriterion("user_money >", value, "userMoney");
			return (Criteria) this;
		}

		public Criteria andUserMoneyGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("user_money >=", value, "userMoney");
			return (Criteria) this;
		}

		public Criteria andUserMoneyLessThan(java.math.BigDecimal value) {
			addCriterion("user_money <", value, "userMoney");
			return (Criteria) this;
		}

		public Criteria andUserMoneyLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("user_money <=", value, "userMoney");
			return (Criteria) this;
		}

		public Criteria andUserMoneyIn(List<java.math.BigDecimal> values) {
			addCriterion("user_money in", values, "userMoney");
			return (Criteria) this;
		}

		public Criteria andUserMoneyNotIn(List<java.math.BigDecimal> values) {
			addCriterion("user_money not in", values, "userMoney");
			return (Criteria) this;
		}

		public Criteria andUserMoneyBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("user_money between", value1, value2, "userMoney");
			return (Criteria) this;
		}

		public Criteria andUserMoneyNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("user_money not between", value1, value2, "userMoney");
			return (Criteria) this;
		}

		public Criteria andPlatformRateIsNull() {
			addCriterion("platform_rate is null");
			return (Criteria) this;
		}

		public Criteria andPlatformRateIsNotNull() {
			addCriterion("platform_rate is not null");
			return (Criteria) this;
		}

		public Criteria andPlatformRateEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_rate =", value, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateNotEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_rate <>", value, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateGreaterThan(java.math.BigDecimal value) {
			addCriterion("platform_rate >", value, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_rate >=", value, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateLessThan(java.math.BigDecimal value) {
			addCriterion("platform_rate <", value, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("platform_rate <=", value, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateIn(List<java.math.BigDecimal> values) {
			addCriterion("platform_rate in", values, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateNotIn(List<java.math.BigDecimal> values) {
			addCriterion("platform_rate not in", values, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("platform_rate between", value1, value2, "platformRate");
			return (Criteria) this;
		}

		public Criteria andPlatformRateNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("platform_rate not between", value1, value2, "platformRate");
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

		public Criteria andRedeemStateIsNull() {
			addCriterion("redeem_state is null");
			return (Criteria) this;
		}

		public Criteria andRedeemStateIsNotNull() {
			addCriterion("redeem_state is not null");
			return (Criteria) this;
		}

		public Criteria andRedeemStateEqualTo(Integer value) {
			addCriterion("redeem_state =", value, "redeemState");
			return (Criteria) this;
		}

		public Criteria andRedeemStateNotEqualTo(Integer value) {
			addCriterion("redeem_state <>", value, "redeemState");
			return (Criteria) this;
		}

		public Criteria andRedeemStateGreaterThan(Integer value) {
			addCriterion("redeem_state >", value, "redeemState");
			return (Criteria) this;
		}

		public Criteria andRedeemStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("redeem_state >=", value, "redeemState");
			return (Criteria) this;
		}

		public Criteria andRedeemStateLessThan(Integer value) {
			addCriterion("redeem_state <", value, "redeemState");
			return (Criteria) this;
		}

		public Criteria andRedeemStateLessThanOrEqualTo(Integer value) {
			addCriterion("redeem_state <=", value, "redeemState");
			return (Criteria) this;
		}

		public Criteria andRedeemStateIn(List<Integer> values) {
			addCriterion("redeem_state in", values, "redeemState");
			return (Criteria) this;
		}

		public Criteria andRedeemStateNotIn(List<Integer> values) {
			addCriterion("redeem_state not in", values, "redeemState");
			return (Criteria) this;
		}

		public Criteria andRedeemStateBetween(Integer value1, Integer value2) {
			addCriterion("redeem_state between", value1, value2, "redeemState");
			return (Criteria) this;
		}

		public Criteria andRedeemStateNotBetween(Integer value1, Integer value2) {
			addCriterion("redeem_state not between", value1, value2, "redeemState");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketIsNull() {
			addCriterion("redeem_ticket is null");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketIsNotNull() {
			addCriterion("redeem_ticket is not null");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketEqualTo(String value) {
			addCriterion("redeem_ticket =", value, "redeemTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketNotEqualTo(String value) {
			addCriterion("redeem_ticket <>", value, "redeemTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketGreaterThan(String value) {
			addCriterion("redeem_ticket >", value, "redeemTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketGreaterThanOrEqualTo(String value) {
			addCriterion("redeem_ticket >=", value, "redeemTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketLessThan(String value) {
			addCriterion("redeem_ticket <", value, "redeemTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketLessThanOrEqualTo(String value) {
			addCriterion("redeem_ticket <=", value, "redeemTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketLike(String value) {
			addCriterion("redeem_ticket like", value, "redeemTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketNotLike(String value) {
			addCriterion("redeem_ticket not like", value, "redeemTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketIn(List<String> values) {
			addCriterion("redeem_ticket in", values, "redeemTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketNotIn(List<String> values) {
			addCriterion("redeem_ticket not in", values, "redeemTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketBetween(String value1, String value2) {
			addCriterion("redeem_ticket between", value1, value2, "redeemTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemTicketNotBetween(String value1, String value2) {
			addCriterion("redeem_ticket not between", value1, value2, "redeemTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemTimeIsNull() {
			addCriterion("redeem_time is null");
			return (Criteria) this;
		}

		public Criteria andRedeemTimeIsNotNull() {
			addCriterion("redeem_time is not null");
			return (Criteria) this;
		}

		public Criteria andRedeemTimeEqualTo(java.util.Date value) {
			addCriterion("redeem_time =", value, "redeemTime");
			return (Criteria) this;
		}

		public Criteria andRedeemTimeNotEqualTo(java.util.Date value) {
			addCriterion("redeem_time <>", value, "redeemTime");
			return (Criteria) this;
		}

		public Criteria andRedeemTimeGreaterThan(java.util.Date value) {
			addCriterion("redeem_time >", value, "redeemTime");
			return (Criteria) this;
		}

		public Criteria andRedeemTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("redeem_time >=", value, "redeemTime");
			return (Criteria) this;
		}

		public Criteria andRedeemTimeLessThan(java.util.Date value) {
			addCriterion("redeem_time <", value, "redeemTime");
			return (Criteria) this;
		}

		public Criteria andRedeemTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("redeem_time <=", value, "redeemTime");
			return (Criteria) this;
		}

		public Criteria andRedeemTimeIn(List<java.util.Date> values) {
			addCriterion("redeem_time in", values, "redeemTime");
			return (Criteria) this;
		}

		public Criteria andRedeemTimeNotIn(List<java.util.Date> values) {
			addCriterion("redeem_time not in", values, "redeemTime");
			return (Criteria) this;
		}

		public Criteria andRedeemTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("redeem_time between", value1, value2, "redeemTime");
			return (Criteria) this;
		}

		public Criteria andRedeemTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("redeem_time not between", value1, value2, "redeemTime");
			return (Criteria) this;
		}

		public Criteria andRedeemOverdueIsNull() {
			addCriterion("redeem_overdue is null");
			return (Criteria) this;
		}

		public Criteria andRedeemOverdueIsNotNull() {
			addCriterion("redeem_overdue is not null");
			return (Criteria) this;
		}

		public Criteria andRedeemOverdueEqualTo(java.math.BigDecimal value) {
			addCriterion("redeem_overdue =", value, "redeemOverdue");
			return (Criteria) this;
		}

		public Criteria andRedeemOverdueNotEqualTo(java.math.BigDecimal value) {
			addCriterion("redeem_overdue <>", value, "redeemOverdue");
			return (Criteria) this;
		}

		public Criteria andRedeemOverdueGreaterThan(java.math.BigDecimal value) {
			addCriterion("redeem_overdue >", value, "redeemOverdue");
			return (Criteria) this;
		}

		public Criteria andRedeemOverdueGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("redeem_overdue >=", value, "redeemOverdue");
			return (Criteria) this;
		}

		public Criteria andRedeemOverdueLessThan(java.math.BigDecimal value) {
			addCriterion("redeem_overdue <", value, "redeemOverdue");
			return (Criteria) this;
		}

		public Criteria andRedeemOverdueLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("redeem_overdue <=", value, "redeemOverdue");
			return (Criteria) this;
		}

		public Criteria andRedeemOverdueIn(List<java.math.BigDecimal> values) {
			addCriterion("redeem_overdue in", values, "redeemOverdue");
			return (Criteria) this;
		}

		public Criteria andRedeemOverdueNotIn(List<java.math.BigDecimal> values) {
			addCriterion("redeem_overdue not in", values, "redeemOverdue");
			return (Criteria) this;
		}

		public Criteria andRedeemOverdueBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("redeem_overdue between", value1, value2, "redeemOverdue");
			return (Criteria) this;
		}

		public Criteria andRedeemOverdueNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("redeem_overdue not between", value1, value2, "redeemOverdue");
			return (Criteria) this;
		}

		public Criteria andRedeemInterestIsNull() {
			addCriterion("redeem_interest is null");
			return (Criteria) this;
		}

		public Criteria andRedeemInterestIsNotNull() {
			addCriterion("redeem_interest is not null");
			return (Criteria) this;
		}

		public Criteria andRedeemInterestEqualTo(java.math.BigDecimal value) {
			addCriterion("redeem_interest =", value, "redeemInterest");
			return (Criteria) this;
		}

		public Criteria andRedeemInterestNotEqualTo(java.math.BigDecimal value) {
			addCriterion("redeem_interest <>", value, "redeemInterest");
			return (Criteria) this;
		}

		public Criteria andRedeemInterestGreaterThan(java.math.BigDecimal value) {
			addCriterion("redeem_interest >", value, "redeemInterest");
			return (Criteria) this;
		}

		public Criteria andRedeemInterestGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("redeem_interest >=", value, "redeemInterest");
			return (Criteria) this;
		}

		public Criteria andRedeemInterestLessThan(java.math.BigDecimal value) {
			addCriterion("redeem_interest <", value, "redeemInterest");
			return (Criteria) this;
		}

		public Criteria andRedeemInterestLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("redeem_interest <=", value, "redeemInterest");
			return (Criteria) this;
		}

		public Criteria andRedeemInterestIn(List<java.math.BigDecimal> values) {
			addCriterion("redeem_interest in", values, "redeemInterest");
			return (Criteria) this;
		}

		public Criteria andRedeemInterestNotIn(List<java.math.BigDecimal> values) {
			addCriterion("redeem_interest not in", values, "redeemInterest");
			return (Criteria) this;
		}

		public Criteria andRedeemInterestBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("redeem_interest between", value1, value2, "redeemInterest");
			return (Criteria) this;
		}

		public Criteria andRedeemInterestNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("redeem_interest not between", value1, value2, "redeemInterest");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketIsNull() {
			addCriterion("redeem_pawn_ticket is null");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketIsNotNull() {
			addCriterion("redeem_pawn_ticket is not null");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketEqualTo(String value) {
			addCriterion("redeem_pawn_ticket =", value, "redeemPawnTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketNotEqualTo(String value) {
			addCriterion("redeem_pawn_ticket <>", value, "redeemPawnTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketGreaterThan(String value) {
			addCriterion("redeem_pawn_ticket >", value, "redeemPawnTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketGreaterThanOrEqualTo(String value) {
			addCriterion("redeem_pawn_ticket >=", value, "redeemPawnTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketLessThan(String value) {
			addCriterion("redeem_pawn_ticket <", value, "redeemPawnTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketLessThanOrEqualTo(String value) {
			addCriterion("redeem_pawn_ticket <=", value, "redeemPawnTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketLike(String value) {
			addCriterion("redeem_pawn_ticket like", value, "redeemPawnTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketNotLike(String value) {
			addCriterion("redeem_pawn_ticket not like", value, "redeemPawnTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketIn(List<String> values) {
			addCriterion("redeem_pawn_ticket in", values, "redeemPawnTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketNotIn(List<String> values) {
			addCriterion("redeem_pawn_ticket not in", values, "redeemPawnTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketBetween(String value1, String value2) {
			addCriterion("redeem_pawn_ticket between", value1, value2, "redeemPawnTicket");
			return (Criteria) this;
		}

		public Criteria andRedeemPawnTicketNotBetween(String value1, String value2) {
			addCriterion("redeem_pawn_ticket not between", value1, value2, "redeemPawnTicket");
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

		public Criteria andOrgTelIsNull() {
			addCriterion("org_tel is null");
			return (Criteria) this;
		}

		public Criteria andOrgTelIsNotNull() {
			addCriterion("org_tel is not null");
			return (Criteria) this;
		}

		public Criteria andOrgTelEqualTo(String value) {
			addCriterion("org_tel =", value, "orgTel");
			return (Criteria) this;
		}

		public Criteria andOrgTelNotEqualTo(String value) {
			addCriterion("org_tel <>", value, "orgTel");
			return (Criteria) this;
		}

		public Criteria andOrgTelGreaterThan(String value) {
			addCriterion("org_tel >", value, "orgTel");
			return (Criteria) this;
		}

		public Criteria andOrgTelGreaterThanOrEqualTo(String value) {
			addCriterion("org_tel >=", value, "orgTel");
			return (Criteria) this;
		}

		public Criteria andOrgTelLessThan(String value) {
			addCriterion("org_tel <", value, "orgTel");
			return (Criteria) this;
		}

		public Criteria andOrgTelLessThanOrEqualTo(String value) {
			addCriterion("org_tel <=", value, "orgTel");
			return (Criteria) this;
		}

		public Criteria andOrgTelLike(String value) {
			addCriterion("org_tel like", value, "orgTel");
			return (Criteria) this;
		}

		public Criteria andOrgTelNotLike(String value) {
			addCriterion("org_tel not like", value, "orgTel");
			return (Criteria) this;
		}

		public Criteria andOrgTelIn(List<String> values) {
			addCriterion("org_tel in", values, "orgTel");
			return (Criteria) this;
		}

		public Criteria andOrgTelNotIn(List<String> values) {
			addCriterion("org_tel not in", values, "orgTel");
			return (Criteria) this;
		}

		public Criteria andOrgTelBetween(String value1, String value2) {
			addCriterion("org_tel between", value1, value2, "orgTel");
			return (Criteria) this;
		}

		public Criteria andOrgTelNotBetween(String value1, String value2) {
			addCriterion("org_tel not between", value1, value2, "orgTel");
			return (Criteria) this;
		}

		public Criteria andOrgAddressIsNull() {
			addCriterion("org_address is null");
			return (Criteria) this;
		}

		public Criteria andOrgAddressIsNotNull() {
			addCriterion("org_address is not null");
			return (Criteria) this;
		}

		public Criteria andOrgAddressEqualTo(String value) {
			addCriterion("org_address =", value, "orgAddress");
			return (Criteria) this;
		}

		public Criteria andOrgAddressNotEqualTo(String value) {
			addCriterion("org_address <>", value, "orgAddress");
			return (Criteria) this;
		}

		public Criteria andOrgAddressGreaterThan(String value) {
			addCriterion("org_address >", value, "orgAddress");
			return (Criteria) this;
		}

		public Criteria andOrgAddressGreaterThanOrEqualTo(String value) {
			addCriterion("org_address >=", value, "orgAddress");
			return (Criteria) this;
		}

		public Criteria andOrgAddressLessThan(String value) {
			addCriterion("org_address <", value, "orgAddress");
			return (Criteria) this;
		}

		public Criteria andOrgAddressLessThanOrEqualTo(String value) {
			addCriterion("org_address <=", value, "orgAddress");
			return (Criteria) this;
		}

		public Criteria andOrgAddressLike(String value) {
			addCriterion("org_address like", value, "orgAddress");
			return (Criteria) this;
		}

		public Criteria andOrgAddressNotLike(String value) {
			addCriterion("org_address not like", value, "orgAddress");
			return (Criteria) this;
		}

		public Criteria andOrgAddressIn(List<String> values) {
			addCriterion("org_address in", values, "orgAddress");
			return (Criteria) this;
		}

		public Criteria andOrgAddressNotIn(List<String> values) {
			addCriterion("org_address not in", values, "orgAddress");
			return (Criteria) this;
		}

		public Criteria andOrgAddressBetween(String value1, String value2) {
			addCriterion("org_address between", value1, value2, "orgAddress");
			return (Criteria) this;
		}

		public Criteria andOrgAddressNotBetween(String value1, String value2) {
			addCriterion("org_address not between", value1, value2, "orgAddress");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseIsNull() {
			addCriterion("org_license is null");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseIsNotNull() {
			addCriterion("org_license is not null");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseEqualTo(String value) {
			addCriterion("org_license =", value, "orgLicense");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseNotEqualTo(String value) {
			addCriterion("org_license <>", value, "orgLicense");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseGreaterThan(String value) {
			addCriterion("org_license >", value, "orgLicense");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseGreaterThanOrEqualTo(String value) {
			addCriterion("org_license >=", value, "orgLicense");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseLessThan(String value) {
			addCriterion("org_license <", value, "orgLicense");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseLessThanOrEqualTo(String value) {
			addCriterion("org_license <=", value, "orgLicense");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseLike(String value) {
			addCriterion("org_license like", value, "orgLicense");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseNotLike(String value) {
			addCriterion("org_license not like", value, "orgLicense");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseIn(List<String> values) {
			addCriterion("org_license in", values, "orgLicense");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseNotIn(List<String> values) {
			addCriterion("org_license not in", values, "orgLicense");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseBetween(String value1, String value2) {
			addCriterion("org_license between", value1, value2, "orgLicense");
			return (Criteria) this;
		}

		public Criteria andOrgLicenseNotBetween(String value1, String value2) {
			addCriterion("org_license not between", value1, value2, "orgLicense");
			return (Criteria) this;
		}

		public Criteria andOrgSealIsNull() {
			addCriterion("org_seal is null");
			return (Criteria) this;
		}

		public Criteria andOrgSealIsNotNull() {
			addCriterion("org_seal is not null");
			return (Criteria) this;
		}

		public Criteria andOrgSealEqualTo(String value) {
			addCriterion("org_seal =", value, "orgSeal");
			return (Criteria) this;
		}

		public Criteria andOrgSealNotEqualTo(String value) {
			addCriterion("org_seal <>", value, "orgSeal");
			return (Criteria) this;
		}

		public Criteria andOrgSealGreaterThan(String value) {
			addCriterion("org_seal >", value, "orgSeal");
			return (Criteria) this;
		}

		public Criteria andOrgSealGreaterThanOrEqualTo(String value) {
			addCriterion("org_seal >=", value, "orgSeal");
			return (Criteria) this;
		}

		public Criteria andOrgSealLessThan(String value) {
			addCriterion("org_seal <", value, "orgSeal");
			return (Criteria) this;
		}

		public Criteria andOrgSealLessThanOrEqualTo(String value) {
			addCriterion("org_seal <=", value, "orgSeal");
			return (Criteria) this;
		}

		public Criteria andOrgSealLike(String value) {
			addCriterion("org_seal like", value, "orgSeal");
			return (Criteria) this;
		}

		public Criteria andOrgSealNotLike(String value) {
			addCriterion("org_seal not like", value, "orgSeal");
			return (Criteria) this;
		}

		public Criteria andOrgSealIn(List<String> values) {
			addCriterion("org_seal in", values, "orgSeal");
			return (Criteria) this;
		}

		public Criteria andOrgSealNotIn(List<String> values) {
			addCriterion("org_seal not in", values, "orgSeal");
			return (Criteria) this;
		}

		public Criteria andOrgSealBetween(String value1, String value2) {
			addCriterion("org_seal between", value1, value2, "orgSeal");
			return (Criteria) this;
		}

		public Criteria andOrgSealNotBetween(String value1, String value2) {
			addCriterion("org_seal not between", value1, value2, "orgSeal");
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

		public Criteria andUserAddressIsNull() {
			addCriterion("user_address is null");
			return (Criteria) this;
		}

		public Criteria andUserAddressIsNotNull() {
			addCriterion("user_address is not null");
			return (Criteria) this;
		}

		public Criteria andUserAddressEqualTo(String value) {
			addCriterion("user_address =", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressNotEqualTo(String value) {
			addCriterion("user_address <>", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressGreaterThan(String value) {
			addCriterion("user_address >", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressGreaterThanOrEqualTo(String value) {
			addCriterion("user_address >=", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressLessThan(String value) {
			addCriterion("user_address <", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressLessThanOrEqualTo(String value) {
			addCriterion("user_address <=", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressLike(String value) {
			addCriterion("user_address like", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressNotLike(String value) {
			addCriterion("user_address not like", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressIn(List<String> values) {
			addCriterion("user_address in", values, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressNotIn(List<String> values) {
			addCriterion("user_address not in", values, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressBetween(String value1, String value2) {
			addCriterion("user_address between", value1, value2, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressNotBetween(String value1, String value2) {
			addCriterion("user_address not between", value1, value2, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserIdCardIsNull() {
			addCriterion("user_id_card is null");
			return (Criteria) this;
		}

		public Criteria andUserIdCardIsNotNull() {
			addCriterion("user_id_card is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdCardEqualTo(String value) {
			addCriterion("user_id_card =", value, "userIdCard");
			return (Criteria) this;
		}

		public Criteria andUserIdCardNotEqualTo(String value) {
			addCriterion("user_id_card <>", value, "userIdCard");
			return (Criteria) this;
		}

		public Criteria andUserIdCardGreaterThan(String value) {
			addCriterion("user_id_card >", value, "userIdCard");
			return (Criteria) this;
		}

		public Criteria andUserIdCardGreaterThanOrEqualTo(String value) {
			addCriterion("user_id_card >=", value, "userIdCard");
			return (Criteria) this;
		}

		public Criteria andUserIdCardLessThan(String value) {
			addCriterion("user_id_card <", value, "userIdCard");
			return (Criteria) this;
		}

		public Criteria andUserIdCardLessThanOrEqualTo(String value) {
			addCriterion("user_id_card <=", value, "userIdCard");
			return (Criteria) this;
		}

		public Criteria andUserIdCardLike(String value) {
			addCriterion("user_id_card like", value, "userIdCard");
			return (Criteria) this;
		}

		public Criteria andUserIdCardNotLike(String value) {
			addCriterion("user_id_card not like", value, "userIdCard");
			return (Criteria) this;
		}

		public Criteria andUserIdCardIn(List<String> values) {
			addCriterion("user_id_card in", values, "userIdCard");
			return (Criteria) this;
		}

		public Criteria andUserIdCardNotIn(List<String> values) {
			addCriterion("user_id_card not in", values, "userIdCard");
			return (Criteria) this;
		}

		public Criteria andUserIdCardBetween(String value1, String value2) {
			addCriterion("user_id_card between", value1, value2, "userIdCard");
			return (Criteria) this;
		}

		public Criteria andUserIdCardNotBetween(String value1, String value2) {
			addCriterion("user_id_card not between", value1, value2, "userIdCard");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIsNull() {
			addCriterion("goods_name is null");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIsNotNull() {
			addCriterion("goods_name is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsNameEqualTo(String value) {
			addCriterion("goods_name =", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotEqualTo(String value) {
			addCriterion("goods_name <>", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameGreaterThan(String value) {
			addCriterion("goods_name >", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
			addCriterion("goods_name >=", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLessThan(String value) {
			addCriterion("goods_name <", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLessThanOrEqualTo(String value) {
			addCriterion("goods_name <=", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLike(String value) {
			addCriterion("goods_name like", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotLike(String value) {
			addCriterion("goods_name not like", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIn(List<String> values) {
			addCriterion("goods_name in", values, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotIn(List<String> values) {
			addCriterion("goods_name not in", values, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameBetween(String value1, String value2) {
			addCriterion("goods_name between", value1, value2, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotBetween(String value1, String value2) {
			addCriterion("goods_name not between", value1, value2, "goodsName");
			return (Criteria) this;
		}

		public Criteria andLastPawnContinueIdIsNull() {
			addCriterion("last_pawn_continue_id is null");
			return (Criteria) this;
		}

		public Criteria andLastPawnContinueIdIsNotNull() {
			addCriterion("last_pawn_continue_id is not null");
			return (Criteria) this;
		}

		public Criteria andLastPawnContinueIdEqualTo(Integer value) {
			addCriterion("last_pawn_continue_id =", value, "lastPawnContinueId");
			return (Criteria) this;
		}

		public Criteria andLastPawnContinueIdNotEqualTo(Integer value) {
			addCriterion("last_pawn_continue_id <>", value, "lastPawnContinueId");
			return (Criteria) this;
		}

		public Criteria andLastPawnContinueIdGreaterThan(Integer value) {
			addCriterion("last_pawn_continue_id >", value, "lastPawnContinueId");
			return (Criteria) this;
		}

		public Criteria andLastPawnContinueIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("last_pawn_continue_id >=", value, "lastPawnContinueId");
			return (Criteria) this;
		}

		public Criteria andLastPawnContinueIdLessThan(Integer value) {
			addCriterion("last_pawn_continue_id <", value, "lastPawnContinueId");
			return (Criteria) this;
		}

		public Criteria andLastPawnContinueIdLessThanOrEqualTo(Integer value) {
			addCriterion("last_pawn_continue_id <=", value, "lastPawnContinueId");
			return (Criteria) this;
		}

		public Criteria andLastPawnContinueIdIn(List<Integer> values) {
			addCriterion("last_pawn_continue_id in", values, "lastPawnContinueId");
			return (Criteria) this;
		}

		public Criteria andLastPawnContinueIdNotIn(List<Integer> values) {
			addCriterion("last_pawn_continue_id not in", values, "lastPawnContinueId");
			return (Criteria) this;
		}

		public Criteria andLastPawnContinueIdBetween(Integer value1, Integer value2) {
			addCriterion("last_pawn_continue_id between", value1, value2, "lastPawnContinueId");
			return (Criteria) this;
		}

		public Criteria andLastPawnContinueIdNotBetween(Integer value1, Integer value2) {
			addCriterion("last_pawn_continue_id not between", value1, value2, "lastPawnContinueId");
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