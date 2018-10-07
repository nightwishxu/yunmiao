package com.item.dao.model;

import java.util.List;
import java.util.ArrayList;

public class UserExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserExample(){
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

		public Criteria andXcxIdIsNull() {
			addCriterion("xcx_id is null");
			return (Criteria) this;
		}

		public Criteria andXcxIdIsNotNull() {
			addCriterion("xcx_id is not null");
			return (Criteria) this;
		}

		public Criteria andXcxIdEqualTo(String value) {
			addCriterion("xcx_id =", value, "xcxId");
			return (Criteria) this;
		}

		public Criteria andXcxIdNotEqualTo(String value) {
			addCriterion("xcx_id <>", value, "xcxId");
			return (Criteria) this;
		}

		public Criteria andXcxIdGreaterThan(String value) {
			addCriterion("xcx_id >", value, "xcxId");
			return (Criteria) this;
		}

		public Criteria andXcxIdGreaterThanOrEqualTo(String value) {
			addCriterion("xcx_id >=", value, "xcxId");
			return (Criteria) this;
		}

		public Criteria andXcxIdLessThan(String value) {
			addCriterion("xcx_id <", value, "xcxId");
			return (Criteria) this;
		}

		public Criteria andXcxIdLessThanOrEqualTo(String value) {
			addCriterion("xcx_id <=", value, "xcxId");
			return (Criteria) this;
		}

		public Criteria andXcxIdLike(String value) {
			addCriterion("xcx_id like", value, "xcxId");
			return (Criteria) this;
		}

		public Criteria andXcxIdNotLike(String value) {
			addCriterion("xcx_id not like", value, "xcxId");
			return (Criteria) this;
		}

		public Criteria andXcxIdIn(List<String> values) {
			addCriterion("xcx_id in", values, "xcxId");
			return (Criteria) this;
		}

		public Criteria andXcxIdNotIn(List<String> values) {
			addCriterion("xcx_id not in", values, "xcxId");
			return (Criteria) this;
		}

		public Criteria andXcxIdBetween(String value1, String value2) {
			addCriterion("xcx_id between", value1, value2, "xcxId");
			return (Criteria) this;
		}

		public Criteria andXcxIdNotBetween(String value1, String value2) {
			addCriterion("xcx_id not between", value1, value2, "xcxId");
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

		public Criteria andAccountIsNull() {
			addCriterion("account is null");
			return (Criteria) this;
		}

		public Criteria andAccountIsNotNull() {
			addCriterion("account is not null");
			return (Criteria) this;
		}

		public Criteria andAccountEqualTo(String value) {
			addCriterion("account =", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotEqualTo(String value) {
			addCriterion("account <>", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountGreaterThan(String value) {
			addCriterion("account >", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountGreaterThanOrEqualTo(String value) {
			addCriterion("account >=", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountLessThan(String value) {
			addCriterion("account <", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountLessThanOrEqualTo(String value) {
			addCriterion("account <=", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountLike(String value) {
			addCriterion("account like", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotLike(String value) {
			addCriterion("account not like", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountIn(List<String> values) {
			addCriterion("account in", values, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotIn(List<String> values) {
			addCriterion("account not in", values, "account");
			return (Criteria) this;
		}

		public Criteria andAccountBetween(String value1, String value2) {
			addCriterion("account between", value1, value2, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotBetween(String value1, String value2) {
			addCriterion("account not between", value1, value2, "account");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andHeadImgIsNull() {
			addCriterion("head_img is null");
			return (Criteria) this;
		}

		public Criteria andHeadImgIsNotNull() {
			addCriterion("head_img is not null");
			return (Criteria) this;
		}

		public Criteria andHeadImgEqualTo(String value) {
			addCriterion("head_img =", value, "headImg");
			return (Criteria) this;
		}

		public Criteria andHeadImgNotEqualTo(String value) {
			addCriterion("head_img <>", value, "headImg");
			return (Criteria) this;
		}

		public Criteria andHeadImgGreaterThan(String value) {
			addCriterion("head_img >", value, "headImg");
			return (Criteria) this;
		}

		public Criteria andHeadImgGreaterThanOrEqualTo(String value) {
			addCriterion("head_img >=", value, "headImg");
			return (Criteria) this;
		}

		public Criteria andHeadImgLessThan(String value) {
			addCriterion("head_img <", value, "headImg");
			return (Criteria) this;
		}

		public Criteria andHeadImgLessThanOrEqualTo(String value) {
			addCriterion("head_img <=", value, "headImg");
			return (Criteria) this;
		}

		public Criteria andHeadImgLike(String value) {
			addCriterion("head_img like", value, "headImg");
			return (Criteria) this;
		}

		public Criteria andHeadImgNotLike(String value) {
			addCriterion("head_img not like", value, "headImg");
			return (Criteria) this;
		}

		public Criteria andHeadImgIn(List<String> values) {
			addCriterion("head_img in", values, "headImg");
			return (Criteria) this;
		}

		public Criteria andHeadImgNotIn(List<String> values) {
			addCriterion("head_img not in", values, "headImg");
			return (Criteria) this;
		}

		public Criteria andHeadImgBetween(String value1, String value2) {
			addCriterion("head_img between", value1, value2, "headImg");
			return (Criteria) this;
		}

		public Criteria andHeadImgNotBetween(String value1, String value2) {
			addCriterion("head_img not between", value1, value2, "headImg");
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

		public Criteria andNickNameIsNull() {
			addCriterion("nick_name is null");
			return (Criteria) this;
		}

		public Criteria andNickNameIsNotNull() {
			addCriterion("nick_name is not null");
			return (Criteria) this;
		}

		public Criteria andNickNameEqualTo(String value) {
			addCriterion("nick_name =", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotEqualTo(String value) {
			addCriterion("nick_name <>", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameGreaterThan(String value) {
			addCriterion("nick_name >", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameGreaterThanOrEqualTo(String value) {
			addCriterion("nick_name >=", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameLessThan(String value) {
			addCriterion("nick_name <", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameLessThanOrEqualTo(String value) {
			addCriterion("nick_name <=", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameLike(String value) {
			addCriterion("nick_name like", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotLike(String value) {
			addCriterion("nick_name not like", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameIn(List<String> values) {
			addCriterion("nick_name in", values, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotIn(List<String> values) {
			addCriterion("nick_name not in", values, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameBetween(String value1, String value2) {
			addCriterion("nick_name between", value1, value2, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotBetween(String value1, String value2) {
			addCriterion("nick_name not between", value1, value2, "nickName");
			return (Criteria) this;
		}

		public Criteria andSexIsNull() {
			addCriterion("sex is null");
			return (Criteria) this;
		}

		public Criteria andSexIsNotNull() {
			addCriterion("sex is not null");
			return (Criteria) this;
		}

		public Criteria andSexEqualTo(Integer value) {
			addCriterion("sex =", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotEqualTo(Integer value) {
			addCriterion("sex <>", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThan(Integer value) {
			addCriterion("sex >", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThanOrEqualTo(Integer value) {
			addCriterion("sex >=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThan(Integer value) {
			addCriterion("sex <", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThanOrEqualTo(Integer value) {
			addCriterion("sex <=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexIn(List<Integer> values) {
			addCriterion("sex in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotIn(List<Integer> values) {
			addCriterion("sex not in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexBetween(Integer value1, Integer value2) {
			addCriterion("sex between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotBetween(Integer value1, Integer value2) {
			addCriterion("sex not between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNull() {
			addCriterion("phone is null");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNotNull() {
			addCriterion("phone is not null");
			return (Criteria) this;
		}

		public Criteria andPhoneEqualTo(String value) {
			addCriterion("phone =", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotEqualTo(String value) {
			addCriterion("phone <>", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThan(String value) {
			addCriterion("phone >", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("phone >=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThan(String value) {
			addCriterion("phone <", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThanOrEqualTo(String value) {
			addCriterion("phone <=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLike(String value) {
			addCriterion("phone like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotLike(String value) {
			addCriterion("phone not like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneIn(List<String> values) {
			addCriterion("phone in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotIn(List<String> values) {
			addCriterion("phone not in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneBetween(String value1, String value2) {
			addCriterion("phone between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotBetween(String value1, String value2) {
			addCriterion("phone not between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andIdCardIsNull() {
			addCriterion("id_card is null");
			return (Criteria) this;
		}

		public Criteria andIdCardIsNotNull() {
			addCriterion("id_card is not null");
			return (Criteria) this;
		}

		public Criteria andIdCardEqualTo(String value) {
			addCriterion("id_card =", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotEqualTo(String value) {
			addCriterion("id_card <>", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardGreaterThan(String value) {
			addCriterion("id_card >", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardGreaterThanOrEqualTo(String value) {
			addCriterion("id_card >=", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLessThan(String value) {
			addCriterion("id_card <", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLessThanOrEqualTo(String value) {
			addCriterion("id_card <=", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLike(String value) {
			addCriterion("id_card like", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotLike(String value) {
			addCriterion("id_card not like", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardIn(List<String> values) {
			addCriterion("id_card in", values, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotIn(List<String> values) {
			addCriterion("id_card not in", values, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardBetween(String value1, String value2) {
			addCriterion("id_card between", value1, value2, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotBetween(String value1, String value2) {
			addCriterion("id_card not between", value1, value2, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardImgIsNull() {
			addCriterion("id_card_img is null");
			return (Criteria) this;
		}

		public Criteria andIdCardImgIsNotNull() {
			addCriterion("id_card_img is not null");
			return (Criteria) this;
		}

		public Criteria andIdCardImgEqualTo(String value) {
			addCriterion("id_card_img =", value, "idCardImg");
			return (Criteria) this;
		}

		public Criteria andIdCardImgNotEqualTo(String value) {
			addCriterion("id_card_img <>", value, "idCardImg");
			return (Criteria) this;
		}

		public Criteria andIdCardImgGreaterThan(String value) {
			addCriterion("id_card_img >", value, "idCardImg");
			return (Criteria) this;
		}

		public Criteria andIdCardImgGreaterThanOrEqualTo(String value) {
			addCriterion("id_card_img >=", value, "idCardImg");
			return (Criteria) this;
		}

		public Criteria andIdCardImgLessThan(String value) {
			addCriterion("id_card_img <", value, "idCardImg");
			return (Criteria) this;
		}

		public Criteria andIdCardImgLessThanOrEqualTo(String value) {
			addCriterion("id_card_img <=", value, "idCardImg");
			return (Criteria) this;
		}

		public Criteria andIdCardImgLike(String value) {
			addCriterion("id_card_img like", value, "idCardImg");
			return (Criteria) this;
		}

		public Criteria andIdCardImgNotLike(String value) {
			addCriterion("id_card_img not like", value, "idCardImg");
			return (Criteria) this;
		}

		public Criteria andIdCardImgIn(List<String> values) {
			addCriterion("id_card_img in", values, "idCardImg");
			return (Criteria) this;
		}

		public Criteria andIdCardImgNotIn(List<String> values) {
			addCriterion("id_card_img not in", values, "idCardImg");
			return (Criteria) this;
		}

		public Criteria andIdCardImgBetween(String value1, String value2) {
			addCriterion("id_card_img between", value1, value2, "idCardImg");
			return (Criteria) this;
		}

		public Criteria andIdCardImgNotBetween(String value1, String value2) {
			addCriterion("id_card_img not between", value1, value2, "idCardImg");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseIsNull() {
			addCriterion("id_card_reverse is null");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseIsNotNull() {
			addCriterion("id_card_reverse is not null");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseEqualTo(String value) {
			addCriterion("id_card_reverse =", value, "idCardReverse");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseNotEqualTo(String value) {
			addCriterion("id_card_reverse <>", value, "idCardReverse");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseGreaterThan(String value) {
			addCriterion("id_card_reverse >", value, "idCardReverse");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseGreaterThanOrEqualTo(String value) {
			addCriterion("id_card_reverse >=", value, "idCardReverse");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseLessThan(String value) {
			addCriterion("id_card_reverse <", value, "idCardReverse");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseLessThanOrEqualTo(String value) {
			addCriterion("id_card_reverse <=", value, "idCardReverse");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseLike(String value) {
			addCriterion("id_card_reverse like", value, "idCardReverse");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseNotLike(String value) {
			addCriterion("id_card_reverse not like", value, "idCardReverse");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseIn(List<String> values) {
			addCriterion("id_card_reverse in", values, "idCardReverse");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseNotIn(List<String> values) {
			addCriterion("id_card_reverse not in", values, "idCardReverse");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseBetween(String value1, String value2) {
			addCriterion("id_card_reverse between", value1, value2, "idCardReverse");
			return (Criteria) this;
		}

		public Criteria andIdCardReverseNotBetween(String value1, String value2) {
			addCriterion("id_card_reverse not between", value1, value2, "idCardReverse");
			return (Criteria) this;
		}

		public Criteria andIdCardHandIsNull() {
			addCriterion("id_card_hand is null");
			return (Criteria) this;
		}

		public Criteria andIdCardHandIsNotNull() {
			addCriterion("id_card_hand is not null");
			return (Criteria) this;
		}

		public Criteria andIdCardHandEqualTo(String value) {
			addCriterion("id_card_hand =", value, "idCardHand");
			return (Criteria) this;
		}

		public Criteria andIdCardHandNotEqualTo(String value) {
			addCriterion("id_card_hand <>", value, "idCardHand");
			return (Criteria) this;
		}

		public Criteria andIdCardHandGreaterThan(String value) {
			addCriterion("id_card_hand >", value, "idCardHand");
			return (Criteria) this;
		}

		public Criteria andIdCardHandGreaterThanOrEqualTo(String value) {
			addCriterion("id_card_hand >=", value, "idCardHand");
			return (Criteria) this;
		}

		public Criteria andIdCardHandLessThan(String value) {
			addCriterion("id_card_hand <", value, "idCardHand");
			return (Criteria) this;
		}

		public Criteria andIdCardHandLessThanOrEqualTo(String value) {
			addCriterion("id_card_hand <=", value, "idCardHand");
			return (Criteria) this;
		}

		public Criteria andIdCardHandLike(String value) {
			addCriterion("id_card_hand like", value, "idCardHand");
			return (Criteria) this;
		}

		public Criteria andIdCardHandNotLike(String value) {
			addCriterion("id_card_hand not like", value, "idCardHand");
			return (Criteria) this;
		}

		public Criteria andIdCardHandIn(List<String> values) {
			addCriterion("id_card_hand in", values, "idCardHand");
			return (Criteria) this;
		}

		public Criteria andIdCardHandNotIn(List<String> values) {
			addCriterion("id_card_hand not in", values, "idCardHand");
			return (Criteria) this;
		}

		public Criteria andIdCardHandBetween(String value1, String value2) {
			addCriterion("id_card_hand between", value1, value2, "idCardHand");
			return (Criteria) this;
		}

		public Criteria andIdCardHandNotBetween(String value1, String value2) {
			addCriterion("id_card_hand not between", value1, value2, "idCardHand");
			return (Criteria) this;
		}

		public Criteria andRealNameAuthenticationIsNull() {
			addCriterion("real_name_authentication is null");
			return (Criteria) this;
		}

		public Criteria andRealNameAuthenticationIsNotNull() {
			addCriterion("real_name_authentication is not null");
			return (Criteria) this;
		}

		public Criteria andRealNameAuthenticationEqualTo(Integer value) {
			addCriterion("real_name_authentication =", value, "realNameAuthentication");
			return (Criteria) this;
		}

		public Criteria andRealNameAuthenticationNotEqualTo(Integer value) {
			addCriterion("real_name_authentication <>", value, "realNameAuthentication");
			return (Criteria) this;
		}

		public Criteria andRealNameAuthenticationGreaterThan(Integer value) {
			addCriterion("real_name_authentication >", value, "realNameAuthentication");
			return (Criteria) this;
		}

		public Criteria andRealNameAuthenticationGreaterThanOrEqualTo(Integer value) {
			addCriterion("real_name_authentication >=", value, "realNameAuthentication");
			return (Criteria) this;
		}

		public Criteria andRealNameAuthenticationLessThan(Integer value) {
			addCriterion("real_name_authentication <", value, "realNameAuthentication");
			return (Criteria) this;
		}

		public Criteria andRealNameAuthenticationLessThanOrEqualTo(Integer value) {
			addCriterion("real_name_authentication <=", value, "realNameAuthentication");
			return (Criteria) this;
		}

		public Criteria andRealNameAuthenticationIn(List<Integer> values) {
			addCriterion("real_name_authentication in", values, "realNameAuthentication");
			return (Criteria) this;
		}

		public Criteria andRealNameAuthenticationNotIn(List<Integer> values) {
			addCriterion("real_name_authentication not in", values, "realNameAuthentication");
			return (Criteria) this;
		}

		public Criteria andRealNameAuthenticationBetween(Integer value1, Integer value2) {
			addCriterion("real_name_authentication between", value1, value2, "realNameAuthentication");
			return (Criteria) this;
		}

		public Criteria andRealNameAuthenticationNotBetween(Integer value1, Integer value2) {
			addCriterion("real_name_authentication not between", value1, value2, "realNameAuthentication");
			return (Criteria) this;
		}

		public Criteria andPlatformAuthenticationIsNull() {
			addCriterion("platform_authentication is null");
			return (Criteria) this;
		}

		public Criteria andPlatformAuthenticationIsNotNull() {
			addCriterion("platform_authentication is not null");
			return (Criteria) this;
		}

		public Criteria andPlatformAuthenticationEqualTo(Integer value) {
			addCriterion("platform_authentication =", value, "platformAuthentication");
			return (Criteria) this;
		}

		public Criteria andPlatformAuthenticationNotEqualTo(Integer value) {
			addCriterion("platform_authentication <>", value, "platformAuthentication");
			return (Criteria) this;
		}

		public Criteria andPlatformAuthenticationGreaterThan(Integer value) {
			addCriterion("platform_authentication >", value, "platformAuthentication");
			return (Criteria) this;
		}

		public Criteria andPlatformAuthenticationGreaterThanOrEqualTo(Integer value) {
			addCriterion("platform_authentication >=", value, "platformAuthentication");
			return (Criteria) this;
		}

		public Criteria andPlatformAuthenticationLessThan(Integer value) {
			addCriterion("platform_authentication <", value, "platformAuthentication");
			return (Criteria) this;
		}

		public Criteria andPlatformAuthenticationLessThanOrEqualTo(Integer value) {
			addCriterion("platform_authentication <=", value, "platformAuthentication");
			return (Criteria) this;
		}

		public Criteria andPlatformAuthenticationIn(List<Integer> values) {
			addCriterion("platform_authentication in", values, "platformAuthentication");
			return (Criteria) this;
		}

		public Criteria andPlatformAuthenticationNotIn(List<Integer> values) {
			addCriterion("platform_authentication not in", values, "platformAuthentication");
			return (Criteria) this;
		}

		public Criteria andPlatformAuthenticationBetween(Integer value1, Integer value2) {
			addCriterion("platform_authentication between", value1, value2, "platformAuthentication");
			return (Criteria) this;
		}

		public Criteria andPlatformAuthenticationNotBetween(Integer value1, Integer value2) {
			addCriterion("platform_authentication not between", value1, value2, "platformAuthentication");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("address is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("address is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("address =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("address <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("address >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("address >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("address <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("address <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("address like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("address not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("address in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("address not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("address between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("address not between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andTrueNameIsNull() {
			addCriterion("true_name is null");
			return (Criteria) this;
		}

		public Criteria andTrueNameIsNotNull() {
			addCriterion("true_name is not null");
			return (Criteria) this;
		}

		public Criteria andTrueNameEqualTo(String value) {
			addCriterion("true_name =", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameNotEqualTo(String value) {
			addCriterion("true_name <>", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameGreaterThan(String value) {
			addCriterion("true_name >", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameGreaterThanOrEqualTo(String value) {
			addCriterion("true_name >=", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameLessThan(String value) {
			addCriterion("true_name <", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameLessThanOrEqualTo(String value) {
			addCriterion("true_name <=", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameLike(String value) {
			addCriterion("true_name like", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameNotLike(String value) {
			addCriterion("true_name not like", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameIn(List<String> values) {
			addCriterion("true_name in", values, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameNotIn(List<String> values) {
			addCriterion("true_name not in", values, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameBetween(String value1, String value2) {
			addCriterion("true_name between", value1, value2, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameNotBetween(String value1, String value2) {
			addCriterion("true_name not between", value1, value2, "trueName");
			return (Criteria) this;
		}

		public Criteria andCreateNameIsNull() {
			addCriterion("create_name is null");
			return (Criteria) this;
		}

		public Criteria andCreateNameIsNotNull() {
			addCriterion("create_name is not null");
			return (Criteria) this;
		}

		public Criteria andCreateNameEqualTo(String value) {
			addCriterion("create_name =", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameNotEqualTo(String value) {
			addCriterion("create_name <>", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameGreaterThan(String value) {
			addCriterion("create_name >", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
			addCriterion("create_name >=", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameLessThan(String value) {
			addCriterion("create_name <", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameLessThanOrEqualTo(String value) {
			addCriterion("create_name <=", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameLike(String value) {
			addCriterion("create_name like", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameNotLike(String value) {
			addCriterion("create_name not like", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameIn(List<String> values) {
			addCriterion("create_name in", values, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameNotIn(List<String> values) {
			addCriterion("create_name not in", values, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameBetween(String value1, String value2) {
			addCriterion("create_name between", value1, value2, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameNotBetween(String value1, String value2) {
			addCriterion("create_name not between", value1, value2, "createName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameIsNull() {
			addCriterion("update_name is null");
			return (Criteria) this;
		}

		public Criteria andUpdateNameIsNotNull() {
			addCriterion("update_name is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateNameEqualTo(java.util.Date value) {
			addCriterion("update_name =", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameNotEqualTo(java.util.Date value) {
			addCriterion("update_name <>", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameGreaterThan(java.util.Date value) {
			addCriterion("update_name >", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("update_name >=", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameLessThan(java.util.Date value) {
			addCriterion("update_name <", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameLessThanOrEqualTo(java.util.Date value) {
			addCriterion("update_name <=", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameIn(List<java.util.Date> values) {
			addCriterion("update_name in", values, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameNotIn(List<java.util.Date> values) {
			addCriterion("update_name not in", values, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("update_name between", value1, value2, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("update_name not between", value1, value2, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(String value) {
			addCriterion("update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(String value) {
			addCriterion("update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(String value) {
			addCriterion("update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(String value) {
			addCriterion("update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
			addCriterion("update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLike(String value) {
			addCriterion("update_time like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotLike(String value) {
			addCriterion("update_time not like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<String> values) {
			addCriterion("update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<String> values) {
			addCriterion("update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(String value1, String value2) {
			addCriterion("update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(String value1, String value2) {
			addCriterion("update_time not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUserLevelIsNull() {
			addCriterion("user_level is null");
			return (Criteria) this;
		}

		public Criteria andUserLevelIsNotNull() {
			addCriterion("user_level is not null");
			return (Criteria) this;
		}

		public Criteria andUserLevelEqualTo(Integer value) {
			addCriterion("user_level =", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelNotEqualTo(Integer value) {
			addCriterion("user_level <>", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelGreaterThan(Integer value) {
			addCriterion("user_level >", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_level >=", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelLessThan(Integer value) {
			addCriterion("user_level <", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelLessThanOrEqualTo(Integer value) {
			addCriterion("user_level <=", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelIn(List<Integer> values) {
			addCriterion("user_level in", values, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelNotIn(List<Integer> values) {
			addCriterion("user_level not in", values, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelBetween(Integer value1, Integer value2) {
			addCriterion("user_level between", value1, value2, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelNotBetween(Integer value1, Integer value2) {
			addCriterion("user_level not between", value1, value2, "userLevel");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIsNull() {
			addCriterion("last_login_time is null");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIsNotNull() {
			addCriterion("last_login_time is not null");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeEqualTo(java.util.Date value) {
			addCriterion("last_login_time =", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotEqualTo(java.util.Date value) {
			addCriterion("last_login_time <>", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeGreaterThan(java.util.Date value) {
			addCriterion("last_login_time >", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("last_login_time >=", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeLessThan(java.util.Date value) {
			addCriterion("last_login_time <", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("last_login_time <=", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIn(List<java.util.Date> values) {
			addCriterion("last_login_time in", values, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotIn(List<java.util.Date> values) {
			addCriterion("last_login_time not in", values, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("last_login_time between", value1, value2, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpIsNull() {
			addCriterion("last_login_ip is null");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpIsNotNull() {
			addCriterion("last_login_ip is not null");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpEqualTo(String value) {
			addCriterion("last_login_ip =", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpNotEqualTo(String value) {
			addCriterion("last_login_ip <>", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpGreaterThan(String value) {
			addCriterion("last_login_ip >", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpGreaterThanOrEqualTo(String value) {
			addCriterion("last_login_ip >=", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpLessThan(String value) {
			addCriterion("last_login_ip <", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpLessThanOrEqualTo(String value) {
			addCriterion("last_login_ip <=", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpLike(String value) {
			addCriterion("last_login_ip like", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpNotLike(String value) {
			addCriterion("last_login_ip not like", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpIn(List<String> values) {
			addCriterion("last_login_ip in", values, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpNotIn(List<String> values) {
			addCriterion("last_login_ip not in", values, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpBetween(String value1, String value2) {
			addCriterion("last_login_ip between", value1, value2, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpNotBetween(String value1, String value2) {
			addCriterion("last_login_ip not between", value1, value2, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andSignatureIsNull() {
			addCriterion("signature is null");
			return (Criteria) this;
		}

		public Criteria andSignatureIsNotNull() {
			addCriterion("signature is not null");
			return (Criteria) this;
		}

		public Criteria andSignatureEqualTo(String value) {
			addCriterion("signature =", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureNotEqualTo(String value) {
			addCriterion("signature <>", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureGreaterThan(String value) {
			addCriterion("signature >", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureGreaterThanOrEqualTo(String value) {
			addCriterion("signature >=", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureLessThan(String value) {
			addCriterion("signature <", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureLessThanOrEqualTo(String value) {
			addCriterion("signature <=", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureLike(String value) {
			addCriterion("signature like", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureNotLike(String value) {
			addCriterion("signature not like", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureIn(List<String> values) {
			addCriterion("signature in", values, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureNotIn(List<String> values) {
			addCriterion("signature not in", values, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureBetween(String value1, String value2) {
			addCriterion("signature between", value1, value2, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureNotBetween(String value1, String value2) {
			addCriterion("signature not between", value1, value2, "signature");
			return (Criteria) this;
		}

		public Criteria andIsBindIsNull() {
			addCriterion("is_bind is null");
			return (Criteria) this;
		}

		public Criteria andIsBindIsNotNull() {
			addCriterion("is_bind is not null");
			return (Criteria) this;
		}

		public Criteria andIsBindEqualTo(Integer value) {
			addCriterion("is_bind =", value, "isBind");
			return (Criteria) this;
		}

		public Criteria andIsBindNotEqualTo(Integer value) {
			addCriterion("is_bind <>", value, "isBind");
			return (Criteria) this;
		}

		public Criteria andIsBindGreaterThan(Integer value) {
			addCriterion("is_bind >", value, "isBind");
			return (Criteria) this;
		}

		public Criteria andIsBindGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_bind >=", value, "isBind");
			return (Criteria) this;
		}

		public Criteria andIsBindLessThan(Integer value) {
			addCriterion("is_bind <", value, "isBind");
			return (Criteria) this;
		}

		public Criteria andIsBindLessThanOrEqualTo(Integer value) {
			addCriterion("is_bind <=", value, "isBind");
			return (Criteria) this;
		}

		public Criteria andIsBindIn(List<Integer> values) {
			addCriterion("is_bind in", values, "isBind");
			return (Criteria) this;
		}

		public Criteria andIsBindNotIn(List<Integer> values) {
			addCriterion("is_bind not in", values, "isBind");
			return (Criteria) this;
		}

		public Criteria andIsBindBetween(Integer value1, Integer value2) {
			addCriterion("is_bind between", value1, value2, "isBind");
			return (Criteria) this;
		}

		public Criteria andIsBindNotBetween(Integer value1, Integer value2) {
			addCriterion("is_bind not between", value1, value2, "isBind");
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