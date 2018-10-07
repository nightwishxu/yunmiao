package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class UserBankCardExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserBankCardExample(){
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

		public Criteria andBankLogoIsNull() {
			addCriterion("bank_logo is null");
			return (Criteria) this;
		}

		public Criteria andBankLogoIsNotNull() {
			addCriterion("bank_logo is not null");
			return (Criteria) this;
		}

		public Criteria andBankLogoEqualTo(String value) {
			addCriterion("bank_logo =", value, "bankLogo");
			return (Criteria) this;
		}

		public Criteria andBankLogoNotEqualTo(String value) {
			addCriterion("bank_logo <>", value, "bankLogo");
			return (Criteria) this;
		}

		public Criteria andBankLogoGreaterThan(String value) {
			addCriterion("bank_logo >", value, "bankLogo");
			return (Criteria) this;
		}

		public Criteria andBankLogoGreaterThanOrEqualTo(String value) {
			addCriterion("bank_logo >=", value, "bankLogo");
			return (Criteria) this;
		}

		public Criteria andBankLogoLessThan(String value) {
			addCriterion("bank_logo <", value, "bankLogo");
			return (Criteria) this;
		}

		public Criteria andBankLogoLessThanOrEqualTo(String value) {
			addCriterion("bank_logo <=", value, "bankLogo");
			return (Criteria) this;
		}

		public Criteria andBankLogoLike(String value) {
			addCriterion("bank_logo like", value, "bankLogo");
			return (Criteria) this;
		}

		public Criteria andBankLogoNotLike(String value) {
			addCriterion("bank_logo not like", value, "bankLogo");
			return (Criteria) this;
		}

		public Criteria andBankLogoIn(List<String> values) {
			addCriterion("bank_logo in", values, "bankLogo");
			return (Criteria) this;
		}

		public Criteria andBankLogoNotIn(List<String> values) {
			addCriterion("bank_logo not in", values, "bankLogo");
			return (Criteria) this;
		}

		public Criteria andBankLogoBetween(String value1, String value2) {
			addCriterion("bank_logo between", value1, value2, "bankLogo");
			return (Criteria) this;
		}

		public Criteria andBankLogoNotBetween(String value1, String value2) {
			addCriterion("bank_logo not between", value1, value2, "bankLogo");
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

		public Criteria andBankCardUserNameIsNull() {
			addCriterion("bank_card_user_name is null");
			return (Criteria) this;
		}

		public Criteria andBankCardUserNameIsNotNull() {
			addCriterion("bank_card_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andBankCardUserNameEqualTo(String value) {
			addCriterion("bank_card_user_name =", value, "bankCardUserName");
			return (Criteria) this;
		}

		public Criteria andBankCardUserNameNotEqualTo(String value) {
			addCriterion("bank_card_user_name <>", value, "bankCardUserName");
			return (Criteria) this;
		}

		public Criteria andBankCardUserNameGreaterThan(String value) {
			addCriterion("bank_card_user_name >", value, "bankCardUserName");
			return (Criteria) this;
		}

		public Criteria andBankCardUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("bank_card_user_name >=", value, "bankCardUserName");
			return (Criteria) this;
		}

		public Criteria andBankCardUserNameLessThan(String value) {
			addCriterion("bank_card_user_name <", value, "bankCardUserName");
			return (Criteria) this;
		}

		public Criteria andBankCardUserNameLessThanOrEqualTo(String value) {
			addCriterion("bank_card_user_name <=", value, "bankCardUserName");
			return (Criteria) this;
		}

		public Criteria andBankCardUserNameLike(String value) {
			addCriterion("bank_card_user_name like", value, "bankCardUserName");
			return (Criteria) this;
		}

		public Criteria andBankCardUserNameNotLike(String value) {
			addCriterion("bank_card_user_name not like", value, "bankCardUserName");
			return (Criteria) this;
		}

		public Criteria andBankCardUserNameIn(List<String> values) {
			addCriterion("bank_card_user_name in", values, "bankCardUserName");
			return (Criteria) this;
		}

		public Criteria andBankCardUserNameNotIn(List<String> values) {
			addCriterion("bank_card_user_name not in", values, "bankCardUserName");
			return (Criteria) this;
		}

		public Criteria andBankCardUserNameBetween(String value1, String value2) {
			addCriterion("bank_card_user_name between", value1, value2, "bankCardUserName");
			return (Criteria) this;
		}

		public Criteria andBankCardUserNameNotBetween(String value1, String value2) {
			addCriterion("bank_card_user_name not between", value1, value2, "bankCardUserName");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneIsNull() {
			addCriterion("bank_card_phone is null");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneIsNotNull() {
			addCriterion("bank_card_phone is not null");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneEqualTo(String value) {
			addCriterion("bank_card_phone =", value, "bankCardPhone");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneNotEqualTo(String value) {
			addCriterion("bank_card_phone <>", value, "bankCardPhone");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneGreaterThan(String value) {
			addCriterion("bank_card_phone >", value, "bankCardPhone");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("bank_card_phone >=", value, "bankCardPhone");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneLessThan(String value) {
			addCriterion("bank_card_phone <", value, "bankCardPhone");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneLessThanOrEqualTo(String value) {
			addCriterion("bank_card_phone <=", value, "bankCardPhone");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneLike(String value) {
			addCriterion("bank_card_phone like", value, "bankCardPhone");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneNotLike(String value) {
			addCriterion("bank_card_phone not like", value, "bankCardPhone");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneIn(List<String> values) {
			addCriterion("bank_card_phone in", values, "bankCardPhone");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneNotIn(List<String> values) {
			addCriterion("bank_card_phone not in", values, "bankCardPhone");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneBetween(String value1, String value2) {
			addCriterion("bank_card_phone between", value1, value2, "bankCardPhone");
			return (Criteria) this;
		}

		public Criteria andBankCardPhoneNotBetween(String value1, String value2) {
			addCriterion("bank_card_phone not between", value1, value2, "bankCardPhone");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardIsNull() {
			addCriterion("bank_card_id_card is null");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardIsNotNull() {
			addCriterion("bank_card_id_card is not null");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardEqualTo(String value) {
			addCriterion("bank_card_id_card =", value, "bankCardIdCard");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardNotEqualTo(String value) {
			addCriterion("bank_card_id_card <>", value, "bankCardIdCard");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardGreaterThan(String value) {
			addCriterion("bank_card_id_card >", value, "bankCardIdCard");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardGreaterThanOrEqualTo(String value) {
			addCriterion("bank_card_id_card >=", value, "bankCardIdCard");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardLessThan(String value) {
			addCriterion("bank_card_id_card <", value, "bankCardIdCard");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardLessThanOrEqualTo(String value) {
			addCriterion("bank_card_id_card <=", value, "bankCardIdCard");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardLike(String value) {
			addCriterion("bank_card_id_card like", value, "bankCardIdCard");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardNotLike(String value) {
			addCriterion("bank_card_id_card not like", value, "bankCardIdCard");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardIn(List<String> values) {
			addCriterion("bank_card_id_card in", values, "bankCardIdCard");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardNotIn(List<String> values) {
			addCriterion("bank_card_id_card not in", values, "bankCardIdCard");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardBetween(String value1, String value2) {
			addCriterion("bank_card_id_card between", value1, value2, "bankCardIdCard");
			return (Criteria) this;
		}

		public Criteria andBankCardIdCardNotBetween(String value1, String value2) {
			addCriterion("bank_card_id_card not between", value1, value2, "bankCardIdCard");
			return (Criteria) this;
		}

		public Criteria andBankCardTypeIsNull() {
			addCriterion("bank_card_type is null");
			return (Criteria) this;
		}

		public Criteria andBankCardTypeIsNotNull() {
			addCriterion("bank_card_type is not null");
			return (Criteria) this;
		}

		public Criteria andBankCardTypeEqualTo(Integer value) {
			addCriterion("bank_card_type =", value, "bankCardType");
			return (Criteria) this;
		}

		public Criteria andBankCardTypeNotEqualTo(Integer value) {
			addCriterion("bank_card_type <>", value, "bankCardType");
			return (Criteria) this;
		}

		public Criteria andBankCardTypeGreaterThan(Integer value) {
			addCriterion("bank_card_type >", value, "bankCardType");
			return (Criteria) this;
		}

		public Criteria andBankCardTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("bank_card_type >=", value, "bankCardType");
			return (Criteria) this;
		}

		public Criteria andBankCardTypeLessThan(Integer value) {
			addCriterion("bank_card_type <", value, "bankCardType");
			return (Criteria) this;
		}

		public Criteria andBankCardTypeLessThanOrEqualTo(Integer value) {
			addCriterion("bank_card_type <=", value, "bankCardType");
			return (Criteria) this;
		}

		public Criteria andBankCardTypeIn(List<Integer> values) {
			addCriterion("bank_card_type in", values, "bankCardType");
			return (Criteria) this;
		}

		public Criteria andBankCardTypeNotIn(List<Integer> values) {
			addCriterion("bank_card_type not in", values, "bankCardType");
			return (Criteria) this;
		}

		public Criteria andBankCardTypeBetween(Integer value1, Integer value2) {
			addCriterion("bank_card_type between", value1, value2, "bankCardType");
			return (Criteria) this;
		}

		public Criteria andBankCardTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("bank_card_type not between", value1, value2, "bankCardType");
			return (Criteria) this;
		}

		public Criteria andIsDefaultIsNull() {
			addCriterion("is_default is null");
			return (Criteria) this;
		}

		public Criteria andIsDefaultIsNotNull() {
			addCriterion("is_default is not null");
			return (Criteria) this;
		}

		public Criteria andIsDefaultEqualTo(Integer value) {
			addCriterion("is_default =", value, "isDefault");
			return (Criteria) this;
		}

		public Criteria andIsDefaultNotEqualTo(Integer value) {
			addCriterion("is_default <>", value, "isDefault");
			return (Criteria) this;
		}

		public Criteria andIsDefaultGreaterThan(Integer value) {
			addCriterion("is_default >", value, "isDefault");
			return (Criteria) this;
		}

		public Criteria andIsDefaultGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_default >=", value, "isDefault");
			return (Criteria) this;
		}

		public Criteria andIsDefaultLessThan(Integer value) {
			addCriterion("is_default <", value, "isDefault");
			return (Criteria) this;
		}

		public Criteria andIsDefaultLessThanOrEqualTo(Integer value) {
			addCriterion("is_default <=", value, "isDefault");
			return (Criteria) this;
		}

		public Criteria andIsDefaultIn(List<Integer> values) {
			addCriterion("is_default in", values, "isDefault");
			return (Criteria) this;
		}

		public Criteria andIsDefaultNotIn(List<Integer> values) {
			addCriterion("is_default not in", values, "isDefault");
			return (Criteria) this;
		}

		public Criteria andIsDefaultBetween(Integer value1, Integer value2) {
			addCriterion("is_default between", value1, value2, "isDefault");
			return (Criteria) this;
		}

		public Criteria andIsDefaultNotBetween(Integer value1, Integer value2) {
			addCriterion("is_default not between", value1, value2, "isDefault");
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