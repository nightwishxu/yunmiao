package com.paidang.dao.model;

import java.util.List;
import java.util.ArrayList;

public class UserGoodsExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserGoodsExample(){
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

		public Criteria andBelongIdIsNull() {
			addCriterion("belong_id is null");
			return (Criteria) this;
		}

		public Criteria andBelongIdIsNotNull() {
			addCriterion("belong_id is not null");
			return (Criteria) this;
		}

		public Criteria andBelongIdEqualTo(Integer value) {
			addCriterion("belong_id =", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdNotEqualTo(Integer value) {
			addCriterion("belong_id <>", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdGreaterThan(Integer value) {
			addCriterion("belong_id >", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("belong_id >=", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdLessThan(Integer value) {
			addCriterion("belong_id <", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdLessThanOrEqualTo(Integer value) {
			addCriterion("belong_id <=", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdIn(List<Integer> values) {
			addCriterion("belong_id in", values, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdNotIn(List<Integer> values) {
			addCriterion("belong_id not in", values, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdBetween(Integer value1, Integer value2) {
			addCriterion("belong_id between", value1, value2, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdNotBetween(Integer value1, Integer value2) {
			addCriterion("belong_id not between", value1, value2, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongTypeIsNull() {
			addCriterion("belong_type is null");
			return (Criteria) this;
		}

		public Criteria andBelongTypeIsNotNull() {
			addCriterion("belong_type is not null");
			return (Criteria) this;
		}

		public Criteria andBelongTypeEqualTo(Integer value) {
			addCriterion("belong_type =", value, "belongType");
			return (Criteria) this;
		}

		public Criteria andBelongTypeNotEqualTo(Integer value) {
			addCriterion("belong_type <>", value, "belongType");
			return (Criteria) this;
		}

		public Criteria andBelongTypeGreaterThan(Integer value) {
			addCriterion("belong_type >", value, "belongType");
			return (Criteria) this;
		}

		public Criteria andBelongTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("belong_type >=", value, "belongType");
			return (Criteria) this;
		}

		public Criteria andBelongTypeLessThan(Integer value) {
			addCriterion("belong_type <", value, "belongType");
			return (Criteria) this;
		}

		public Criteria andBelongTypeLessThanOrEqualTo(Integer value) {
			addCriterion("belong_type <=", value, "belongType");
			return (Criteria) this;
		}

		public Criteria andBelongTypeIn(List<Integer> values) {
			addCriterion("belong_type in", values, "belongType");
			return (Criteria) this;
		}

		public Criteria andBelongTypeNotIn(List<Integer> values) {
			addCriterion("belong_type not in", values, "belongType");
			return (Criteria) this;
		}

		public Criteria andBelongTypeBetween(Integer value1, Integer value2) {
			addCriterion("belong_type between", value1, value2, "belongType");
			return (Criteria) this;
		}

		public Criteria andBelongTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("belong_type not between", value1, value2, "belongType");
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

		public Criteria andImagesIsNull() {
			addCriterion("images is null");
			return (Criteria) this;
		}

		public Criteria andImagesIsNotNull() {
			addCriterion("images is not null");
			return (Criteria) this;
		}

		public Criteria andImagesEqualTo(String value) {
			addCriterion("images =", value, "images");
			return (Criteria) this;
		}

		public Criteria andImagesNotEqualTo(String value) {
			addCriterion("images <>", value, "images");
			return (Criteria) this;
		}

		public Criteria andImagesGreaterThan(String value) {
			addCriterion("images >", value, "images");
			return (Criteria) this;
		}

		public Criteria andImagesGreaterThanOrEqualTo(String value) {
			addCriterion("images >=", value, "images");
			return (Criteria) this;
		}

		public Criteria andImagesLessThan(String value) {
			addCriterion("images <", value, "images");
			return (Criteria) this;
		}

		public Criteria andImagesLessThanOrEqualTo(String value) {
			addCriterion("images <=", value, "images");
			return (Criteria) this;
		}

		public Criteria andImagesLike(String value) {
			addCriterion("images like", value, "images");
			return (Criteria) this;
		}

		public Criteria andImagesNotLike(String value) {
			addCriterion("images not like", value, "images");
			return (Criteria) this;
		}

		public Criteria andImagesIn(List<String> values) {
			addCriterion("images in", values, "images");
			return (Criteria) this;
		}

		public Criteria andImagesNotIn(List<String> values) {
			addCriterion("images not in", values, "images");
			return (Criteria) this;
		}

		public Criteria andImagesBetween(String value1, String value2) {
			addCriterion("images between", value1, value2, "images");
			return (Criteria) this;
		}

		public Criteria andImagesNotBetween(String value1, String value2) {
			addCriterion("images not between", value1, value2, "images");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsIsNull() {
			addCriterion("goods_imgs is null");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsIsNotNull() {
			addCriterion("goods_imgs is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsEqualTo(String value) {
			addCriterion("goods_imgs =", value, "goodsImgs");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsNotEqualTo(String value) {
			addCriterion("goods_imgs <>", value, "goodsImgs");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsGreaterThan(String value) {
			addCriterion("goods_imgs >", value, "goodsImgs");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsGreaterThanOrEqualTo(String value) {
			addCriterion("goods_imgs >=", value, "goodsImgs");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsLessThan(String value) {
			addCriterion("goods_imgs <", value, "goodsImgs");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsLessThanOrEqualTo(String value) {
			addCriterion("goods_imgs <=", value, "goodsImgs");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsLike(String value) {
			addCriterion("goods_imgs like", value, "goodsImgs");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsNotLike(String value) {
			addCriterion("goods_imgs not like", value, "goodsImgs");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsIn(List<String> values) {
			addCriterion("goods_imgs in", values, "goodsImgs");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsNotIn(List<String> values) {
			addCriterion("goods_imgs not in", values, "goodsImgs");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsBetween(String value1, String value2) {
			addCriterion("goods_imgs between", value1, value2, "goodsImgs");
			return (Criteria) this;
		}

		public Criteria andGoodsImgsNotBetween(String value1, String value2) {
			addCriterion("goods_imgs not between", value1, value2, "goodsImgs");
			return (Criteria) this;
		}

		public Criteria andVideoIsNull() {
			addCriterion("video is null");
			return (Criteria) this;
		}

		public Criteria andVideoIsNotNull() {
			addCriterion("video is not null");
			return (Criteria) this;
		}

		public Criteria andVideoEqualTo(String value) {
			addCriterion("video =", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoNotEqualTo(String value) {
			addCriterion("video <>", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoGreaterThan(String value) {
			addCriterion("video >", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoGreaterThanOrEqualTo(String value) {
			addCriterion("video >=", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoLessThan(String value) {
			addCriterion("video <", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoLessThanOrEqualTo(String value) {
			addCriterion("video <=", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoLike(String value) {
			addCriterion("video like", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoNotLike(String value) {
			addCriterion("video not like", value, "video");
			return (Criteria) this;
		}

		public Criteria andVideoIn(List<String> values) {
			addCriterion("video in", values, "video");
			return (Criteria) this;
		}

		public Criteria andVideoNotIn(List<String> values) {
			addCriterion("video not in", values, "video");
			return (Criteria) this;
		}

		public Criteria andVideoBetween(String value1, String value2) {
			addCriterion("video between", value1, value2, "video");
			return (Criteria) this;
		}

		public Criteria andVideoNotBetween(String value1, String value2) {
			addCriterion("video not between", value1, value2, "video");
			return (Criteria) this;
		}

		public Criteria andBuyTimeIsNull() {
			addCriterion("buy_time is null");
			return (Criteria) this;
		}

		public Criteria andBuyTimeIsNotNull() {
			addCriterion("buy_time is not null");
			return (Criteria) this;
		}

		public Criteria andBuyTimeEqualTo(java.util.Date value) {
			addCriterion("buy_time =", value, "buyTime");
			return (Criteria) this;
		}

		public Criteria andBuyTimeNotEqualTo(java.util.Date value) {
			addCriterion("buy_time <>", value, "buyTime");
			return (Criteria) this;
		}

		public Criteria andBuyTimeGreaterThan(java.util.Date value) {
			addCriterion("buy_time >", value, "buyTime");
			return (Criteria) this;
		}

		public Criteria andBuyTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("buy_time >=", value, "buyTime");
			return (Criteria) this;
		}

		public Criteria andBuyTimeLessThan(java.util.Date value) {
			addCriterion("buy_time <", value, "buyTime");
			return (Criteria) this;
		}

		public Criteria andBuyTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("buy_time <=", value, "buyTime");
			return (Criteria) this;
		}

		public Criteria andBuyTimeIn(List<java.util.Date> values) {
			addCriterion("buy_time in", values, "buyTime");
			return (Criteria) this;
		}

		public Criteria andBuyTimeNotIn(List<java.util.Date> values) {
			addCriterion("buy_time not in", values, "buyTime");
			return (Criteria) this;
		}

		public Criteria andBuyTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("buy_time between", value1, value2, "buyTime");
			return (Criteria) this;
		}

		public Criteria andBuyTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("buy_time not between", value1, value2, "buyTime");
			return (Criteria) this;
		}

		public Criteria andBuyPriceIsNull() {
			addCriterion("buy_price is null");
			return (Criteria) this;
		}

		public Criteria andBuyPriceIsNotNull() {
			addCriterion("buy_price is not null");
			return (Criteria) this;
		}

		public Criteria andBuyPriceEqualTo(java.math.BigDecimal value) {
			addCriterion("buy_price =", value, "buyPrice");
			return (Criteria) this;
		}

		public Criteria andBuyPriceNotEqualTo(java.math.BigDecimal value) {
			addCriterion("buy_price <>", value, "buyPrice");
			return (Criteria) this;
		}

		public Criteria andBuyPriceGreaterThan(java.math.BigDecimal value) {
			addCriterion("buy_price >", value, "buyPrice");
			return (Criteria) this;
		}

		public Criteria andBuyPriceGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("buy_price >=", value, "buyPrice");
			return (Criteria) this;
		}

		public Criteria andBuyPriceLessThan(java.math.BigDecimal value) {
			addCriterion("buy_price <", value, "buyPrice");
			return (Criteria) this;
		}

		public Criteria andBuyPriceLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("buy_price <=", value, "buyPrice");
			return (Criteria) this;
		}

		public Criteria andBuyPriceIn(List<java.math.BigDecimal> values) {
			addCriterion("buy_price in", values, "buyPrice");
			return (Criteria) this;
		}

		public Criteria andBuyPriceNotIn(List<java.math.BigDecimal> values) {
			addCriterion("buy_price not in", values, "buyPrice");
			return (Criteria) this;
		}

		public Criteria andBuyPriceBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("buy_price between", value1, value2, "buyPrice");
			return (Criteria) this;
		}

		public Criteria andBuyPriceNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("buy_price not between", value1, value2, "buyPrice");
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

		public Criteria andCityIsNull() {
			addCriterion("city is null");
			return (Criteria) this;
		}

		public Criteria andCityIsNotNull() {
			addCriterion("city is not null");
			return (Criteria) this;
		}

		public Criteria andCityEqualTo(String value) {
			addCriterion("city =", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotEqualTo(String value) {
			addCriterion("city <>", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityGreaterThan(String value) {
			addCriterion("city >", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityGreaterThanOrEqualTo(String value) {
			addCriterion("city >=", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLessThan(String value) {
			addCriterion("city <", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLessThanOrEqualTo(String value) {
			addCriterion("city <=", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLike(String value) {
			addCriterion("city like", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotLike(String value) {
			addCriterion("city not like", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityIn(List<String> values) {
			addCriterion("city in", values, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotIn(List<String> values) {
			addCriterion("city not in", values, "city");
			return (Criteria) this;
		}

		public Criteria andCityBetween(String value1, String value2) {
			addCriterion("city between", value1, value2, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotBetween(String value1, String value2) {
			addCriterion("city not between", value1, value2, "city");
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

		public Criteria andAuthenticateRequireIsNull() {
			addCriterion("authenticate_require is null");
			return (Criteria) this;
		}

		public Criteria andAuthenticateRequireIsNotNull() {
			addCriterion("authenticate_require is not null");
			return (Criteria) this;
		}

		public Criteria andAuthenticateRequireEqualTo(String value) {
			addCriterion("authenticate_require =", value, "authenticateRequire");
			return (Criteria) this;
		}

		public Criteria andAuthenticateRequireNotEqualTo(String value) {
			addCriterion("authenticate_require <>", value, "authenticateRequire");
			return (Criteria) this;
		}

		public Criteria andAuthenticateRequireGreaterThan(String value) {
			addCriterion("authenticate_require >", value, "authenticateRequire");
			return (Criteria) this;
		}

		public Criteria andAuthenticateRequireGreaterThanOrEqualTo(String value) {
			addCriterion("authenticate_require >=", value, "authenticateRequire");
			return (Criteria) this;
		}

		public Criteria andAuthenticateRequireLessThan(String value) {
			addCriterion("authenticate_require <", value, "authenticateRequire");
			return (Criteria) this;
		}

		public Criteria andAuthenticateRequireLessThanOrEqualTo(String value) {
			addCriterion("authenticate_require <=", value, "authenticateRequire");
			return (Criteria) this;
		}

		public Criteria andAuthenticateRequireLike(String value) {
			addCriterion("authenticate_require like", value, "authenticateRequire");
			return (Criteria) this;
		}

		public Criteria andAuthenticateRequireNotLike(String value) {
			addCriterion("authenticate_require not like", value, "authenticateRequire");
			return (Criteria) this;
		}

		public Criteria andAuthenticateRequireIn(List<String> values) {
			addCriterion("authenticate_require in", values, "authenticateRequire");
			return (Criteria) this;
		}

		public Criteria andAuthenticateRequireNotIn(List<String> values) {
			addCriterion("authenticate_require not in", values, "authenticateRequire");
			return (Criteria) this;
		}

		public Criteria andAuthenticateRequireBetween(String value1, String value2) {
			addCriterion("authenticate_require between", value1, value2, "authenticateRequire");
			return (Criteria) this;
		}

		public Criteria andAuthenticateRequireNotBetween(String value1, String value2) {
			addCriterion("authenticate_require not between", value1, value2, "authenticateRequire");
			return (Criteria) this;
		}

		public Criteria andCateIdIsNull() {
			addCriterion("cate_id is null");
			return (Criteria) this;
		}

		public Criteria andCateIdIsNotNull() {
			addCriterion("cate_id is not null");
			return (Criteria) this;
		}

		public Criteria andCateIdEqualTo(Integer value) {
			addCriterion("cate_id =", value, "cateId");
			return (Criteria) this;
		}

		public Criteria andCateIdNotEqualTo(Integer value) {
			addCriterion("cate_id <>", value, "cateId");
			return (Criteria) this;
		}

		public Criteria andCateIdGreaterThan(Integer value) {
			addCriterion("cate_id >", value, "cateId");
			return (Criteria) this;
		}

		public Criteria andCateIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("cate_id >=", value, "cateId");
			return (Criteria) this;
		}

		public Criteria andCateIdLessThan(Integer value) {
			addCriterion("cate_id <", value, "cateId");
			return (Criteria) this;
		}

		public Criteria andCateIdLessThanOrEqualTo(Integer value) {
			addCriterion("cate_id <=", value, "cateId");
			return (Criteria) this;
		}

		public Criteria andCateIdIn(List<Integer> values) {
			addCriterion("cate_id in", values, "cateId");
			return (Criteria) this;
		}

		public Criteria andCateIdNotIn(List<Integer> values) {
			addCriterion("cate_id not in", values, "cateId");
			return (Criteria) this;
		}

		public Criteria andCateIdBetween(Integer value1, Integer value2) {
			addCriterion("cate_id between", value1, value2, "cateId");
			return (Criteria) this;
		}

		public Criteria andCateIdNotBetween(Integer value1, Integer value2) {
			addCriterion("cate_id not between", value1, value2, "cateId");
			return (Criteria) this;
		}

		public Criteria andCateCodeIsNull() {
			addCriterion("cate_code is null");
			return (Criteria) this;
		}

		public Criteria andCateCodeIsNotNull() {
			addCriterion("cate_code is not null");
			return (Criteria) this;
		}

		public Criteria andCateCodeEqualTo(String value) {
			addCriterion("cate_code =", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeNotEqualTo(String value) {
			addCriterion("cate_code <>", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeGreaterThan(String value) {
			addCriterion("cate_code >", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeGreaterThanOrEqualTo(String value) {
			addCriterion("cate_code >=", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeLessThan(String value) {
			addCriterion("cate_code <", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeLessThanOrEqualTo(String value) {
			addCriterion("cate_code <=", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeLike(String value) {
			addCriterion("cate_code like", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeNotLike(String value) {
			addCriterion("cate_code not like", value, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeIn(List<String> values) {
			addCriterion("cate_code in", values, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeNotIn(List<String> values) {
			addCriterion("cate_code not in", values, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeBetween(String value1, String value2) {
			addCriterion("cate_code between", value1, value2, "cateCode");
			return (Criteria) this;
		}

		public Criteria andCateCodeNotBetween(String value1, String value2) {
			addCriterion("cate_code not between", value1, value2, "cateCode");
			return (Criteria) this;
		}

		public Criteria andAuthResultIsNull() {
			addCriterion("auth_result is null");
			return (Criteria) this;
		}

		public Criteria andAuthResultIsNotNull() {
			addCriterion("auth_result is not null");
			return (Criteria) this;
		}

		public Criteria andAuthResultEqualTo(Integer value) {
			addCriterion("auth_result =", value, "authResult");
			return (Criteria) this;
		}

		public Criteria andAuthResultNotEqualTo(Integer value) {
			addCriterion("auth_result <>", value, "authResult");
			return (Criteria) this;
		}

		public Criteria andAuthResultGreaterThan(Integer value) {
			addCriterion("auth_result >", value, "authResult");
			return (Criteria) this;
		}

		public Criteria andAuthResultGreaterThanOrEqualTo(Integer value) {
			addCriterion("auth_result >=", value, "authResult");
			return (Criteria) this;
		}

		public Criteria andAuthResultLessThan(Integer value) {
			addCriterion("auth_result <", value, "authResult");
			return (Criteria) this;
		}

		public Criteria andAuthResultLessThanOrEqualTo(Integer value) {
			addCriterion("auth_result <=", value, "authResult");
			return (Criteria) this;
		}

		public Criteria andAuthResultIn(List<Integer> values) {
			addCriterion("auth_result in", values, "authResult");
			return (Criteria) this;
		}

		public Criteria andAuthResultNotIn(List<Integer> values) {
			addCriterion("auth_result not in", values, "authResult");
			return (Criteria) this;
		}

		public Criteria andAuthResultBetween(Integer value1, Integer value2) {
			addCriterion("auth_result between", value1, value2, "authResult");
			return (Criteria) this;
		}

		public Criteria andAuthResultNotBetween(Integer value1, Integer value2) {
			addCriterion("auth_result not between", value1, value2, "authResult");
			return (Criteria) this;
		}

		public Criteria andAuthPriceTestIsNull() {
			addCriterion("auth_price_test is null");
			return (Criteria) this;
		}

		public Criteria andAuthPriceTestIsNotNull() {
			addCriterion("auth_price_test is not null");
			return (Criteria) this;
		}

		public Criteria andAuthPriceTestEqualTo(java.math.BigDecimal value) {
			addCriterion("auth_price_test =", value, "authPriceTest");
			return (Criteria) this;
		}

		public Criteria andAuthPriceTestNotEqualTo(java.math.BigDecimal value) {
			addCriterion("auth_price_test <>", value, "authPriceTest");
			return (Criteria) this;
		}

		public Criteria andAuthPriceTestGreaterThan(java.math.BigDecimal value) {
			addCriterion("auth_price_test >", value, "authPriceTest");
			return (Criteria) this;
		}

		public Criteria andAuthPriceTestGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("auth_price_test >=", value, "authPriceTest");
			return (Criteria) this;
		}

		public Criteria andAuthPriceTestLessThan(java.math.BigDecimal value) {
			addCriterion("auth_price_test <", value, "authPriceTest");
			return (Criteria) this;
		}

		public Criteria andAuthPriceTestLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("auth_price_test <=", value, "authPriceTest");
			return (Criteria) this;
		}

		public Criteria andAuthPriceTestIn(List<java.math.BigDecimal> values) {
			addCriterion("auth_price_test in", values, "authPriceTest");
			return (Criteria) this;
		}

		public Criteria andAuthPriceTestNotIn(List<java.math.BigDecimal> values) {
			addCriterion("auth_price_test not in", values, "authPriceTest");
			return (Criteria) this;
		}

		public Criteria andAuthPriceTestBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("auth_price_test between", value1, value2, "authPriceTest");
			return (Criteria) this;
		}

		public Criteria andAuthPriceTestNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("auth_price_test not between", value1, value2, "authPriceTest");
			return (Criteria) this;
		}

		public Criteria andAuthPriceIsNull() {
			addCriterion("auth_price is null");
			return (Criteria) this;
		}

		public Criteria andAuthPriceIsNotNull() {
			addCriterion("auth_price is not null");
			return (Criteria) this;
		}

		public Criteria andAuthPriceEqualTo(java.math.BigDecimal value) {
			addCriterion("auth_price =", value, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceNotEqualTo(java.math.BigDecimal value) {
			addCriterion("auth_price <>", value, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceGreaterThan(java.math.BigDecimal value) {
			addCriterion("auth_price >", value, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("auth_price >=", value, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceLessThan(java.math.BigDecimal value) {
			addCriterion("auth_price <", value, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("auth_price <=", value, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceIn(List<java.math.BigDecimal> values) {
			addCriterion("auth_price in", values, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceNotIn(List<java.math.BigDecimal> values) {
			addCriterion("auth_price not in", values, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("auth_price between", value1, value2, "authPrice");
			return (Criteria) this;
		}

		public Criteria andAuthPriceNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("auth_price not between", value1, value2, "authPrice");
			return (Criteria) this;
		}

		public Criteria andBackImagesIsNull() {
			addCriterion("back_images is null");
			return (Criteria) this;
		}

		public Criteria andBackImagesIsNotNull() {
			addCriterion("back_images is not null");
			return (Criteria) this;
		}

		public Criteria andBackImagesEqualTo(String value) {
			addCriterion("back_images =", value, "backImages");
			return (Criteria) this;
		}

		public Criteria andBackImagesNotEqualTo(String value) {
			addCriterion("back_images <>", value, "backImages");
			return (Criteria) this;
		}

		public Criteria andBackImagesGreaterThan(String value) {
			addCriterion("back_images >", value, "backImages");
			return (Criteria) this;
		}

		public Criteria andBackImagesGreaterThanOrEqualTo(String value) {
			addCriterion("back_images >=", value, "backImages");
			return (Criteria) this;
		}

		public Criteria andBackImagesLessThan(String value) {
			addCriterion("back_images <", value, "backImages");
			return (Criteria) this;
		}

		public Criteria andBackImagesLessThanOrEqualTo(String value) {
			addCriterion("back_images <=", value, "backImages");
			return (Criteria) this;
		}

		public Criteria andBackImagesLike(String value) {
			addCriterion("back_images like", value, "backImages");
			return (Criteria) this;
		}

		public Criteria andBackImagesNotLike(String value) {
			addCriterion("back_images not like", value, "backImages");
			return (Criteria) this;
		}

		public Criteria andBackImagesIn(List<String> values) {
			addCriterion("back_images in", values, "backImages");
			return (Criteria) this;
		}

		public Criteria andBackImagesNotIn(List<String> values) {
			addCriterion("back_images not in", values, "backImages");
			return (Criteria) this;
		}

		public Criteria andBackImagesBetween(String value1, String value2) {
			addCriterion("back_images between", value1, value2, "backImages");
			return (Criteria) this;
		}

		public Criteria andBackImagesNotBetween(String value1, String value2) {
			addCriterion("back_images not between", value1, value2, "backImages");
			return (Criteria) this;
		}

		public Criteria andBackVideoIsNull() {
			addCriterion("back_video is null");
			return (Criteria) this;
		}

		public Criteria andBackVideoIsNotNull() {
			addCriterion("back_video is not null");
			return (Criteria) this;
		}

		public Criteria andBackVideoEqualTo(String value) {
			addCriterion("back_video =", value, "backVideo");
			return (Criteria) this;
		}

		public Criteria andBackVideoNotEqualTo(String value) {
			addCriterion("back_video <>", value, "backVideo");
			return (Criteria) this;
		}

		public Criteria andBackVideoGreaterThan(String value) {
			addCriterion("back_video >", value, "backVideo");
			return (Criteria) this;
		}

		public Criteria andBackVideoGreaterThanOrEqualTo(String value) {
			addCriterion("back_video >=", value, "backVideo");
			return (Criteria) this;
		}

		public Criteria andBackVideoLessThan(String value) {
			addCriterion("back_video <", value, "backVideo");
			return (Criteria) this;
		}

		public Criteria andBackVideoLessThanOrEqualTo(String value) {
			addCriterion("back_video <=", value, "backVideo");
			return (Criteria) this;
		}

		public Criteria andBackVideoLike(String value) {
			addCriterion("back_video like", value, "backVideo");
			return (Criteria) this;
		}

		public Criteria andBackVideoNotLike(String value) {
			addCriterion("back_video not like", value, "backVideo");
			return (Criteria) this;
		}

		public Criteria andBackVideoIn(List<String> values) {
			addCriterion("back_video in", values, "backVideo");
			return (Criteria) this;
		}

		public Criteria andBackVideoNotIn(List<String> values) {
			addCriterion("back_video not in", values, "backVideo");
			return (Criteria) this;
		}

		public Criteria andBackVideoBetween(String value1, String value2) {
			addCriterion("back_video between", value1, value2, "backVideo");
			return (Criteria) this;
		}

		public Criteria andBackVideoNotBetween(String value1, String value2) {
			addCriterion("back_video not between", value1, value2, "backVideo");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoIsNull() {
			addCriterion("open_goods_video is null");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoIsNotNull() {
			addCriterion("open_goods_video is not null");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoEqualTo(String value) {
			addCriterion("open_goods_video =", value, "openGoodsVideo");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoNotEqualTo(String value) {
			addCriterion("open_goods_video <>", value, "openGoodsVideo");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoGreaterThan(String value) {
			addCriterion("open_goods_video >", value, "openGoodsVideo");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoGreaterThanOrEqualTo(String value) {
			addCriterion("open_goods_video >=", value, "openGoodsVideo");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoLessThan(String value) {
			addCriterion("open_goods_video <", value, "openGoodsVideo");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoLessThanOrEqualTo(String value) {
			addCriterion("open_goods_video <=", value, "openGoodsVideo");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoLike(String value) {
			addCriterion("open_goods_video like", value, "openGoodsVideo");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoNotLike(String value) {
			addCriterion("open_goods_video not like", value, "openGoodsVideo");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoIn(List<String> values) {
			addCriterion("open_goods_video in", values, "openGoodsVideo");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoNotIn(List<String> values) {
			addCriterion("open_goods_video not in", values, "openGoodsVideo");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoBetween(String value1, String value2) {
			addCriterion("open_goods_video between", value1, value2, "openGoodsVideo");
			return (Criteria) this;
		}

		public Criteria andOpenGoodsVideoNotBetween(String value1, String value2) {
			addCriterion("open_goods_video not between", value1, value2, "openGoodsVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoIsNull() {
			addCriterion("plat_goods_receive_video is null");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoIsNotNull() {
			addCriterion("plat_goods_receive_video is not null");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoEqualTo(String value) {
			addCriterion("plat_goods_receive_video =", value, "platGoodsReceiveVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoNotEqualTo(String value) {
			addCriterion("plat_goods_receive_video <>", value, "platGoodsReceiveVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoGreaterThan(String value) {
			addCriterion("plat_goods_receive_video >", value, "platGoodsReceiveVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoGreaterThanOrEqualTo(String value) {
			addCriterion("plat_goods_receive_video >=", value, "platGoodsReceiveVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoLessThan(String value) {
			addCriterion("plat_goods_receive_video <", value, "platGoodsReceiveVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoLessThanOrEqualTo(String value) {
			addCriterion("plat_goods_receive_video <=", value, "platGoodsReceiveVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoLike(String value) {
			addCriterion("plat_goods_receive_video like", value, "platGoodsReceiveVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoNotLike(String value) {
			addCriterion("plat_goods_receive_video not like", value, "platGoodsReceiveVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoIn(List<String> values) {
			addCriterion("plat_goods_receive_video in", values, "platGoodsReceiveVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoNotIn(List<String> values) {
			addCriterion("plat_goods_receive_video not in", values, "platGoodsReceiveVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoBetween(String value1, String value2) {
			addCriterion("plat_goods_receive_video between", value1, value2, "platGoodsReceiveVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsReceiveVideoNotBetween(String value1, String value2) {
			addCriterion("plat_goods_receive_video not between", value1, value2, "platGoodsReceiveVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoIsNull() {
			addCriterion("plat_goods_auth_video is null");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoIsNotNull() {
			addCriterion("plat_goods_auth_video is not null");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoEqualTo(String value) {
			addCriterion("plat_goods_auth_video =", value, "platGoodsAuthVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoNotEqualTo(String value) {
			addCriterion("plat_goods_auth_video <>", value, "platGoodsAuthVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoGreaterThan(String value) {
			addCriterion("plat_goods_auth_video >", value, "platGoodsAuthVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoGreaterThanOrEqualTo(String value) {
			addCriterion("plat_goods_auth_video >=", value, "platGoodsAuthVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoLessThan(String value) {
			addCriterion("plat_goods_auth_video <", value, "platGoodsAuthVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoLessThanOrEqualTo(String value) {
			addCriterion("plat_goods_auth_video <=", value, "platGoodsAuthVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoLike(String value) {
			addCriterion("plat_goods_auth_video like", value, "platGoodsAuthVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoNotLike(String value) {
			addCriterion("plat_goods_auth_video not like", value, "platGoodsAuthVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoIn(List<String> values) {
			addCriterion("plat_goods_auth_video in", values, "platGoodsAuthVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoNotIn(List<String> values) {
			addCriterion("plat_goods_auth_video not in", values, "platGoodsAuthVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoBetween(String value1, String value2) {
			addCriterion("plat_goods_auth_video between", value1, value2, "platGoodsAuthVideo");
			return (Criteria) this;
		}

		public Criteria andPlatGoodsAuthVideoNotBetween(String value1, String value2) {
			addCriterion("plat_goods_auth_video not between", value1, value2, "platGoodsAuthVideo");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonIsNull() {
			addCriterion("not_verify_reason is null");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonIsNotNull() {
			addCriterion("not_verify_reason is not null");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonEqualTo(String value) {
			addCriterion("not_verify_reason =", value, "notVerifyReason");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonNotEqualTo(String value) {
			addCriterion("not_verify_reason <>", value, "notVerifyReason");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonGreaterThan(String value) {
			addCriterion("not_verify_reason >", value, "notVerifyReason");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonGreaterThanOrEqualTo(String value) {
			addCriterion("not_verify_reason >=", value, "notVerifyReason");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonLessThan(String value) {
			addCriterion("not_verify_reason <", value, "notVerifyReason");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonLessThanOrEqualTo(String value) {
			addCriterion("not_verify_reason <=", value, "notVerifyReason");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonLike(String value) {
			addCriterion("not_verify_reason like", value, "notVerifyReason");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonNotLike(String value) {
			addCriterion("not_verify_reason not like", value, "notVerifyReason");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonIn(List<String> values) {
			addCriterion("not_verify_reason in", values, "notVerifyReason");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonNotIn(List<String> values) {
			addCriterion("not_verify_reason not in", values, "notVerifyReason");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonBetween(String value1, String value2) {
			addCriterion("not_verify_reason between", value1, value2, "notVerifyReason");
			return (Criteria) this;
		}

		public Criteria andNotVerifyReasonNotBetween(String value1, String value2) {
			addCriterion("not_verify_reason not between", value1, value2, "notVerifyReason");
			return (Criteria) this;
		}

		public Criteria andGoVideoIsNull() {
			addCriterion("go_video is null");
			return (Criteria) this;
		}

		public Criteria andGoVideoIsNotNull() {
			addCriterion("go_video is not null");
			return (Criteria) this;
		}

		public Criteria andGoVideoEqualTo(String value) {
			addCriterion("go_video =", value, "goVideo");
			return (Criteria) this;
		}

		public Criteria andGoVideoNotEqualTo(String value) {
			addCriterion("go_video <>", value, "goVideo");
			return (Criteria) this;
		}

		public Criteria andGoVideoGreaterThan(String value) {
			addCriterion("go_video >", value, "goVideo");
			return (Criteria) this;
		}

		public Criteria andGoVideoGreaterThanOrEqualTo(String value) {
			addCriterion("go_video >=", value, "goVideo");
			return (Criteria) this;
		}

		public Criteria andGoVideoLessThan(String value) {
			addCriterion("go_video <", value, "goVideo");
			return (Criteria) this;
		}

		public Criteria andGoVideoLessThanOrEqualTo(String value) {
			addCriterion("go_video <=", value, "goVideo");
			return (Criteria) this;
		}

		public Criteria andGoVideoLike(String value) {
			addCriterion("go_video like", value, "goVideo");
			return (Criteria) this;
		}

		public Criteria andGoVideoNotLike(String value) {
			addCriterion("go_video not like", value, "goVideo");
			return (Criteria) this;
		}

		public Criteria andGoVideoIn(List<String> values) {
			addCriterion("go_video in", values, "goVideo");
			return (Criteria) this;
		}

		public Criteria andGoVideoNotIn(List<String> values) {
			addCriterion("go_video not in", values, "goVideo");
			return (Criteria) this;
		}

		public Criteria andGoVideoBetween(String value1, String value2) {
			addCriterion("go_video between", value1, value2, "goVideo");
			return (Criteria) this;
		}

		public Criteria andGoVideoNotBetween(String value1, String value2) {
			addCriterion("go_video not between", value1, value2, "goVideo");
			return (Criteria) this;
		}

		public Criteria andGotoPawnIsNull() {
			addCriterion("goto_pawn is null");
			return (Criteria) this;
		}

		public Criteria andGotoPawnIsNotNull() {
			addCriterion("goto_pawn is not null");
			return (Criteria) this;
		}

		public Criteria andGotoPawnEqualTo(Integer value) {
			addCriterion("goto_pawn =", value, "gotoPawn");
			return (Criteria) this;
		}

		public Criteria andGotoPawnNotEqualTo(Integer value) {
			addCriterion("goto_pawn <>", value, "gotoPawn");
			return (Criteria) this;
		}

		public Criteria andGotoPawnGreaterThan(Integer value) {
			addCriterion("goto_pawn >", value, "gotoPawn");
			return (Criteria) this;
		}

		public Criteria andGotoPawnGreaterThanOrEqualTo(Integer value) {
			addCriterion("goto_pawn >=", value, "gotoPawn");
			return (Criteria) this;
		}

		public Criteria andGotoPawnLessThan(Integer value) {
			addCriterion("goto_pawn <", value, "gotoPawn");
			return (Criteria) this;
		}

		public Criteria andGotoPawnLessThanOrEqualTo(Integer value) {
			addCriterion("goto_pawn <=", value, "gotoPawn");
			return (Criteria) this;
		}

		public Criteria andGotoPawnIn(List<Integer> values) {
			addCriterion("goto_pawn in", values, "gotoPawn");
			return (Criteria) this;
		}

		public Criteria andGotoPawnNotIn(List<Integer> values) {
			addCriterion("goto_pawn not in", values, "gotoPawn");
			return (Criteria) this;
		}

		public Criteria andGotoPawnBetween(Integer value1, Integer value2) {
			addCriterion("goto_pawn between", value1, value2, "gotoPawn");
			return (Criteria) this;
		}

		public Criteria andGotoPawnNotBetween(Integer value1, Integer value2) {
			addCriterion("goto_pawn not between", value1, value2, "gotoPawn");
			return (Criteria) this;
		}

		public Criteria andGoSellIsNull() {
			addCriterion("go_sell is null");
			return (Criteria) this;
		}

		public Criteria andGoSellIsNotNull() {
			addCriterion("go_sell is not null");
			return (Criteria) this;
		}

		public Criteria andGoSellEqualTo(Integer value) {
			addCriterion("go_sell =", value, "goSell");
			return (Criteria) this;
		}

		public Criteria andGoSellNotEqualTo(Integer value) {
			addCriterion("go_sell <>", value, "goSell");
			return (Criteria) this;
		}

		public Criteria andGoSellGreaterThan(Integer value) {
			addCriterion("go_sell >", value, "goSell");
			return (Criteria) this;
		}

		public Criteria andGoSellGreaterThanOrEqualTo(Integer value) {
			addCriterion("go_sell >=", value, "goSell");
			return (Criteria) this;
		}

		public Criteria andGoSellLessThan(Integer value) {
			addCriterion("go_sell <", value, "goSell");
			return (Criteria) this;
		}

		public Criteria andGoSellLessThanOrEqualTo(Integer value) {
			addCriterion("go_sell <=", value, "goSell");
			return (Criteria) this;
		}

		public Criteria andGoSellIn(List<Integer> values) {
			addCriterion("go_sell in", values, "goSell");
			return (Criteria) this;
		}

		public Criteria andGoSellNotIn(List<Integer> values) {
			addCriterion("go_sell not in", values, "goSell");
			return (Criteria) this;
		}

		public Criteria andGoSellBetween(Integer value1, Integer value2) {
			addCriterion("go_sell between", value1, value2, "goSell");
			return (Criteria) this;
		}

		public Criteria andGoSellNotBetween(Integer value1, Integer value2) {
			addCriterion("go_sell not between", value1, value2, "goSell");
			return (Criteria) this;
		}

		public Criteria andLocationIsNull() {
			addCriterion("location is null");
			return (Criteria) this;
		}

		public Criteria andLocationIsNotNull() {
			addCriterion("location is not null");
			return (Criteria) this;
		}

		public Criteria andLocationEqualTo(Integer value) {
			addCriterion("location =", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotEqualTo(Integer value) {
			addCriterion("location <>", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThan(Integer value) {
			addCriterion("location >", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThanOrEqualTo(Integer value) {
			addCriterion("location >=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThan(Integer value) {
			addCriterion("location <", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThanOrEqualTo(Integer value) {
			addCriterion("location <=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationIn(List<Integer> values) {
			addCriterion("location in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotIn(List<Integer> values) {
			addCriterion("location not in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationBetween(Integer value1, Integer value2) {
			addCriterion("location between", value1, value2, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotBetween(Integer value1, Integer value2) {
			addCriterion("location not between", value1, value2, "location");
			return (Criteria) this;
		}

		public Criteria andPostStateIsNull() {
			addCriterion("post_state is null");
			return (Criteria) this;
		}

		public Criteria andPostStateIsNotNull() {
			addCriterion("post_state is not null");
			return (Criteria) this;
		}

		public Criteria andPostStateEqualTo(Integer value) {
			addCriterion("post_state =", value, "postState");
			return (Criteria) this;
		}

		public Criteria andPostStateNotEqualTo(Integer value) {
			addCriterion("post_state <>", value, "postState");
			return (Criteria) this;
		}

		public Criteria andPostStateGreaterThan(Integer value) {
			addCriterion("post_state >", value, "postState");
			return (Criteria) this;
		}

		public Criteria andPostStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("post_state >=", value, "postState");
			return (Criteria) this;
		}

		public Criteria andPostStateLessThan(Integer value) {
			addCriterion("post_state <", value, "postState");
			return (Criteria) this;
		}

		public Criteria andPostStateLessThanOrEqualTo(Integer value) {
			addCriterion("post_state <=", value, "postState");
			return (Criteria) this;
		}

		public Criteria andPostStateIn(List<Integer> values) {
			addCriterion("post_state in", values, "postState");
			return (Criteria) this;
		}

		public Criteria andPostStateNotIn(List<Integer> values) {
			addCriterion("post_state not in", values, "postState");
			return (Criteria) this;
		}

		public Criteria andPostStateBetween(Integer value1, Integer value2) {
			addCriterion("post_state between", value1, value2, "postState");
			return (Criteria) this;
		}

		public Criteria andPostStateNotBetween(Integer value1, Integer value2) {
			addCriterion("post_state not between", value1, value2, "postState");
			return (Criteria) this;
		}

		public Criteria andPostUserNameIsNull() {
			addCriterion("post_user_name is null");
			return (Criteria) this;
		}

		public Criteria andPostUserNameIsNotNull() {
			addCriterion("post_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andPostUserNameEqualTo(String value) {
			addCriterion("post_user_name =", value, "postUserName");
			return (Criteria) this;
		}

		public Criteria andPostUserNameNotEqualTo(String value) {
			addCriterion("post_user_name <>", value, "postUserName");
			return (Criteria) this;
		}

		public Criteria andPostUserNameGreaterThan(String value) {
			addCriterion("post_user_name >", value, "postUserName");
			return (Criteria) this;
		}

		public Criteria andPostUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("post_user_name >=", value, "postUserName");
			return (Criteria) this;
		}

		public Criteria andPostUserNameLessThan(String value) {
			addCriterion("post_user_name <", value, "postUserName");
			return (Criteria) this;
		}

		public Criteria andPostUserNameLessThanOrEqualTo(String value) {
			addCriterion("post_user_name <=", value, "postUserName");
			return (Criteria) this;
		}

		public Criteria andPostUserNameLike(String value) {
			addCriterion("post_user_name like", value, "postUserName");
			return (Criteria) this;
		}

		public Criteria andPostUserNameNotLike(String value) {
			addCriterion("post_user_name not like", value, "postUserName");
			return (Criteria) this;
		}

		public Criteria andPostUserNameIn(List<String> values) {
			addCriterion("post_user_name in", values, "postUserName");
			return (Criteria) this;
		}

		public Criteria andPostUserNameNotIn(List<String> values) {
			addCriterion("post_user_name not in", values, "postUserName");
			return (Criteria) this;
		}

		public Criteria andPostUserNameBetween(String value1, String value2) {
			addCriterion("post_user_name between", value1, value2, "postUserName");
			return (Criteria) this;
		}

		public Criteria andPostUserNameNotBetween(String value1, String value2) {
			addCriterion("post_user_name not between", value1, value2, "postUserName");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneIsNull() {
			addCriterion("post_user_phone is null");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneIsNotNull() {
			addCriterion("post_user_phone is not null");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneEqualTo(String value) {
			addCriterion("post_user_phone =", value, "postUserPhone");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneNotEqualTo(String value) {
			addCriterion("post_user_phone <>", value, "postUserPhone");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneGreaterThan(String value) {
			addCriterion("post_user_phone >", value, "postUserPhone");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("post_user_phone >=", value, "postUserPhone");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneLessThan(String value) {
			addCriterion("post_user_phone <", value, "postUserPhone");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneLessThanOrEqualTo(String value) {
			addCriterion("post_user_phone <=", value, "postUserPhone");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneLike(String value) {
			addCriterion("post_user_phone like", value, "postUserPhone");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneNotLike(String value) {
			addCriterion("post_user_phone not like", value, "postUserPhone");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneIn(List<String> values) {
			addCriterion("post_user_phone in", values, "postUserPhone");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneNotIn(List<String> values) {
			addCriterion("post_user_phone not in", values, "postUserPhone");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneBetween(String value1, String value2) {
			addCriterion("post_user_phone between", value1, value2, "postUserPhone");
			return (Criteria) this;
		}

		public Criteria andPostUserPhoneNotBetween(String value1, String value2) {
			addCriterion("post_user_phone not between", value1, value2, "postUserPhone");
			return (Criteria) this;
		}

		public Criteria andPostExpressIsNull() {
			addCriterion("post_express is null");
			return (Criteria) this;
		}

		public Criteria andPostExpressIsNotNull() {
			addCriterion("post_express is not null");
			return (Criteria) this;
		}

		public Criteria andPostExpressEqualTo(String value) {
			addCriterion("post_express =", value, "postExpress");
			return (Criteria) this;
		}

		public Criteria andPostExpressNotEqualTo(String value) {
			addCriterion("post_express <>", value, "postExpress");
			return (Criteria) this;
		}

		public Criteria andPostExpressGreaterThan(String value) {
			addCriterion("post_express >", value, "postExpress");
			return (Criteria) this;
		}

		public Criteria andPostExpressGreaterThanOrEqualTo(String value) {
			addCriterion("post_express >=", value, "postExpress");
			return (Criteria) this;
		}

		public Criteria andPostExpressLessThan(String value) {
			addCriterion("post_express <", value, "postExpress");
			return (Criteria) this;
		}

		public Criteria andPostExpressLessThanOrEqualTo(String value) {
			addCriterion("post_express <=", value, "postExpress");
			return (Criteria) this;
		}

		public Criteria andPostExpressLike(String value) {
			addCriterion("post_express like", value, "postExpress");
			return (Criteria) this;
		}

		public Criteria andPostExpressNotLike(String value) {
			addCriterion("post_express not like", value, "postExpress");
			return (Criteria) this;
		}

		public Criteria andPostExpressIn(List<String> values) {
			addCriterion("post_express in", values, "postExpress");
			return (Criteria) this;
		}

		public Criteria andPostExpressNotIn(List<String> values) {
			addCriterion("post_express not in", values, "postExpress");
			return (Criteria) this;
		}

		public Criteria andPostExpressBetween(String value1, String value2) {
			addCriterion("post_express between", value1, value2, "postExpress");
			return (Criteria) this;
		}

		public Criteria andPostExpressNotBetween(String value1, String value2) {
			addCriterion("post_express not between", value1, value2, "postExpress");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeIsNull() {
			addCriterion("post_express_code is null");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeIsNotNull() {
			addCriterion("post_express_code is not null");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeEqualTo(String value) {
			addCriterion("post_express_code =", value, "postExpressCode");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeNotEqualTo(String value) {
			addCriterion("post_express_code <>", value, "postExpressCode");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeGreaterThan(String value) {
			addCriterion("post_express_code >", value, "postExpressCode");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeGreaterThanOrEqualTo(String value) {
			addCriterion("post_express_code >=", value, "postExpressCode");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeLessThan(String value) {
			addCriterion("post_express_code <", value, "postExpressCode");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeLessThanOrEqualTo(String value) {
			addCriterion("post_express_code <=", value, "postExpressCode");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeLike(String value) {
			addCriterion("post_express_code like", value, "postExpressCode");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeNotLike(String value) {
			addCriterion("post_express_code not like", value, "postExpressCode");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeIn(List<String> values) {
			addCriterion("post_express_code in", values, "postExpressCode");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeNotIn(List<String> values) {
			addCriterion("post_express_code not in", values, "postExpressCode");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeBetween(String value1, String value2) {
			addCriterion("post_express_code between", value1, value2, "postExpressCode");
			return (Criteria) this;
		}

		public Criteria andPostExpressCodeNotBetween(String value1, String value2) {
			addCriterion("post_express_code not between", value1, value2, "postExpressCode");
			return (Criteria) this;
		}

		public Criteria andBackUserNameIsNull() {
			addCriterion("back_user_name is null");
			return (Criteria) this;
		}

		public Criteria andBackUserNameIsNotNull() {
			addCriterion("back_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andBackUserNameEqualTo(String value) {
			addCriterion("back_user_name =", value, "backUserName");
			return (Criteria) this;
		}

		public Criteria andBackUserNameNotEqualTo(String value) {
			addCriterion("back_user_name <>", value, "backUserName");
			return (Criteria) this;
		}

		public Criteria andBackUserNameGreaterThan(String value) {
			addCriterion("back_user_name >", value, "backUserName");
			return (Criteria) this;
		}

		public Criteria andBackUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("back_user_name >=", value, "backUserName");
			return (Criteria) this;
		}

		public Criteria andBackUserNameLessThan(String value) {
			addCriterion("back_user_name <", value, "backUserName");
			return (Criteria) this;
		}

		public Criteria andBackUserNameLessThanOrEqualTo(String value) {
			addCriterion("back_user_name <=", value, "backUserName");
			return (Criteria) this;
		}

		public Criteria andBackUserNameLike(String value) {
			addCriterion("back_user_name like", value, "backUserName");
			return (Criteria) this;
		}

		public Criteria andBackUserNameNotLike(String value) {
			addCriterion("back_user_name not like", value, "backUserName");
			return (Criteria) this;
		}

		public Criteria andBackUserNameIn(List<String> values) {
			addCriterion("back_user_name in", values, "backUserName");
			return (Criteria) this;
		}

		public Criteria andBackUserNameNotIn(List<String> values) {
			addCriterion("back_user_name not in", values, "backUserName");
			return (Criteria) this;
		}

		public Criteria andBackUserNameBetween(String value1, String value2) {
			addCriterion("back_user_name between", value1, value2, "backUserName");
			return (Criteria) this;
		}

		public Criteria andBackUserNameNotBetween(String value1, String value2) {
			addCriterion("back_user_name not between", value1, value2, "backUserName");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneIsNull() {
			addCriterion("back_user_phone is null");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneIsNotNull() {
			addCriterion("back_user_phone is not null");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneEqualTo(String value) {
			addCriterion("back_user_phone =", value, "backUserPhone");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneNotEqualTo(String value) {
			addCriterion("back_user_phone <>", value, "backUserPhone");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneGreaterThan(String value) {
			addCriterion("back_user_phone >", value, "backUserPhone");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("back_user_phone >=", value, "backUserPhone");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneLessThan(String value) {
			addCriterion("back_user_phone <", value, "backUserPhone");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneLessThanOrEqualTo(String value) {
			addCriterion("back_user_phone <=", value, "backUserPhone");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneLike(String value) {
			addCriterion("back_user_phone like", value, "backUserPhone");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneNotLike(String value) {
			addCriterion("back_user_phone not like", value, "backUserPhone");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneIn(List<String> values) {
			addCriterion("back_user_phone in", values, "backUserPhone");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneNotIn(List<String> values) {
			addCriterion("back_user_phone not in", values, "backUserPhone");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneBetween(String value1, String value2) {
			addCriterion("back_user_phone between", value1, value2, "backUserPhone");
			return (Criteria) this;
		}

		public Criteria andBackUserPhoneNotBetween(String value1, String value2) {
			addCriterion("back_user_phone not between", value1, value2, "backUserPhone");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressIsNull() {
			addCriterion("back_user_express is null");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressIsNotNull() {
			addCriterion("back_user_express is not null");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressEqualTo(String value) {
			addCriterion("back_user_express =", value, "backUserExpress");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressNotEqualTo(String value) {
			addCriterion("back_user_express <>", value, "backUserExpress");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressGreaterThan(String value) {
			addCriterion("back_user_express >", value, "backUserExpress");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressGreaterThanOrEqualTo(String value) {
			addCriterion("back_user_express >=", value, "backUserExpress");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressLessThan(String value) {
			addCriterion("back_user_express <", value, "backUserExpress");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressLessThanOrEqualTo(String value) {
			addCriterion("back_user_express <=", value, "backUserExpress");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressLike(String value) {
			addCriterion("back_user_express like", value, "backUserExpress");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressNotLike(String value) {
			addCriterion("back_user_express not like", value, "backUserExpress");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressIn(List<String> values) {
			addCriterion("back_user_express in", values, "backUserExpress");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressNotIn(List<String> values) {
			addCriterion("back_user_express not in", values, "backUserExpress");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressBetween(String value1, String value2) {
			addCriterion("back_user_express between", value1, value2, "backUserExpress");
			return (Criteria) this;
		}

		public Criteria andBackUserExpressNotBetween(String value1, String value2) {
			addCriterion("back_user_express not between", value1, value2, "backUserExpress");
			return (Criteria) this;
		}

		public Criteria andBackExpressIsNull() {
			addCriterion("back_express is null");
			return (Criteria) this;
		}

		public Criteria andBackExpressIsNotNull() {
			addCriterion("back_express is not null");
			return (Criteria) this;
		}

		public Criteria andBackExpressEqualTo(String value) {
			addCriterion("back_express =", value, "backExpress");
			return (Criteria) this;
		}

		public Criteria andBackExpressNotEqualTo(String value) {
			addCriterion("back_express <>", value, "backExpress");
			return (Criteria) this;
		}

		public Criteria andBackExpressGreaterThan(String value) {
			addCriterion("back_express >", value, "backExpress");
			return (Criteria) this;
		}

		public Criteria andBackExpressGreaterThanOrEqualTo(String value) {
			addCriterion("back_express >=", value, "backExpress");
			return (Criteria) this;
		}

		public Criteria andBackExpressLessThan(String value) {
			addCriterion("back_express <", value, "backExpress");
			return (Criteria) this;
		}

		public Criteria andBackExpressLessThanOrEqualTo(String value) {
			addCriterion("back_express <=", value, "backExpress");
			return (Criteria) this;
		}

		public Criteria andBackExpressLike(String value) {
			addCriterion("back_express like", value, "backExpress");
			return (Criteria) this;
		}

		public Criteria andBackExpressNotLike(String value) {
			addCriterion("back_express not like", value, "backExpress");
			return (Criteria) this;
		}

		public Criteria andBackExpressIn(List<String> values) {
			addCriterion("back_express in", values, "backExpress");
			return (Criteria) this;
		}

		public Criteria andBackExpressNotIn(List<String> values) {
			addCriterion("back_express not in", values, "backExpress");
			return (Criteria) this;
		}

		public Criteria andBackExpressBetween(String value1, String value2) {
			addCriterion("back_express between", value1, value2, "backExpress");
			return (Criteria) this;
		}

		public Criteria andBackExpressNotBetween(String value1, String value2) {
			addCriterion("back_express not between", value1, value2, "backExpress");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeIsNull() {
			addCriterion("back_express_code is null");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeIsNotNull() {
			addCriterion("back_express_code is not null");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeEqualTo(String value) {
			addCriterion("back_express_code =", value, "backExpressCode");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeNotEqualTo(String value) {
			addCriterion("back_express_code <>", value, "backExpressCode");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeGreaterThan(String value) {
			addCriterion("back_express_code >", value, "backExpressCode");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeGreaterThanOrEqualTo(String value) {
			addCriterion("back_express_code >=", value, "backExpressCode");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeLessThan(String value) {
			addCriterion("back_express_code <", value, "backExpressCode");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeLessThanOrEqualTo(String value) {
			addCriterion("back_express_code <=", value, "backExpressCode");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeLike(String value) {
			addCriterion("back_express_code like", value, "backExpressCode");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeNotLike(String value) {
			addCriterion("back_express_code not like", value, "backExpressCode");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeIn(List<String> values) {
			addCriterion("back_express_code in", values, "backExpressCode");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeNotIn(List<String> values) {
			addCriterion("back_express_code not in", values, "backExpressCode");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeBetween(String value1, String value2) {
			addCriterion("back_express_code between", value1, value2, "backExpressCode");
			return (Criteria) this;
		}

		public Criteria andBackExpressCodeNotBetween(String value1, String value2) {
			addCriterion("back_express_code not between", value1, value2, "backExpressCode");
			return (Criteria) this;
		}

		public Criteria andBackStateIsNull() {
			addCriterion("back_state is null");
			return (Criteria) this;
		}

		public Criteria andBackStateIsNotNull() {
			addCriterion("back_state is not null");
			return (Criteria) this;
		}

		public Criteria andBackStateEqualTo(Integer value) {
			addCriterion("back_state =", value, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateNotEqualTo(Integer value) {
			addCriterion("back_state <>", value, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateGreaterThan(Integer value) {
			addCriterion("back_state >", value, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("back_state >=", value, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateLessThan(Integer value) {
			addCriterion("back_state <", value, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateLessThanOrEqualTo(Integer value) {
			addCriterion("back_state <=", value, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateIn(List<Integer> values) {
			addCriterion("back_state in", values, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateNotIn(List<Integer> values) {
			addCriterion("back_state not in", values, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateBetween(Integer value1, Integer value2) {
			addCriterion("back_state between", value1, value2, "backState");
			return (Criteria) this;
		}

		public Criteria andBackStateNotBetween(Integer value1, Integer value2) {
			addCriterion("back_state not between", value1, value2, "backState");
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

		public Criteria andIsOnlineIsNull() {
			addCriterion("is_online is null");
			return (Criteria) this;
		}

		public Criteria andIsOnlineIsNotNull() {
			addCriterion("is_online is not null");
			return (Criteria) this;
		}

		public Criteria andIsOnlineEqualTo(Integer value) {
			addCriterion("is_online =", value, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineNotEqualTo(Integer value) {
			addCriterion("is_online <>", value, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineGreaterThan(Integer value) {
			addCriterion("is_online >", value, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_online >=", value, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineLessThan(Integer value) {
			addCriterion("is_online <", value, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineLessThanOrEqualTo(Integer value) {
			addCriterion("is_online <=", value, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineIn(List<Integer> values) {
			addCriterion("is_online in", values, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineNotIn(List<Integer> values) {
			addCriterion("is_online not in", values, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineBetween(Integer value1, Integer value2) {
			addCriterion("is_online between", value1, value2, "isOnline");
			return (Criteria) this;
		}

		public Criteria andIsOnlineNotBetween(Integer value1, Integer value2) {
			addCriterion("is_online not between", value1, value2, "isOnline");
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

		public Criteria andPlatUserNameIsNull() {
			addCriterion("plat_user_name is null");
			return (Criteria) this;
		}

		public Criteria andPlatUserNameIsNotNull() {
			addCriterion("plat_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andPlatUserNameEqualTo(String value) {
			addCriterion("plat_user_name =", value, "platUserName");
			return (Criteria) this;
		}

		public Criteria andPlatUserNameNotEqualTo(String value) {
			addCriterion("plat_user_name <>", value, "platUserName");
			return (Criteria) this;
		}

		public Criteria andPlatUserNameGreaterThan(String value) {
			addCriterion("plat_user_name >", value, "platUserName");
			return (Criteria) this;
		}

		public Criteria andPlatUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("plat_user_name >=", value, "platUserName");
			return (Criteria) this;
		}

		public Criteria andPlatUserNameLessThan(String value) {
			addCriterion("plat_user_name <", value, "platUserName");
			return (Criteria) this;
		}

		public Criteria andPlatUserNameLessThanOrEqualTo(String value) {
			addCriterion("plat_user_name <=", value, "platUserName");
			return (Criteria) this;
		}

		public Criteria andPlatUserNameLike(String value) {
			addCriterion("plat_user_name like", value, "platUserName");
			return (Criteria) this;
		}

		public Criteria andPlatUserNameNotLike(String value) {
			addCriterion("plat_user_name not like", value, "platUserName");
			return (Criteria) this;
		}

		public Criteria andPlatUserNameIn(List<String> values) {
			addCriterion("plat_user_name in", values, "platUserName");
			return (Criteria) this;
		}

		public Criteria andPlatUserNameNotIn(List<String> values) {
			addCriterion("plat_user_name not in", values, "platUserName");
			return (Criteria) this;
		}

		public Criteria andPlatUserNameBetween(String value1, String value2) {
			addCriterion("plat_user_name between", value1, value2, "platUserName");
			return (Criteria) this;
		}

		public Criteria andPlatUserNameNotBetween(String value1, String value2) {
			addCriterion("plat_user_name not between", value1, value2, "platUserName");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneIsNull() {
			addCriterion("plat_user_phone is null");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneIsNotNull() {
			addCriterion("plat_user_phone is not null");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneEqualTo(String value) {
			addCriterion("plat_user_phone =", value, "platUserPhone");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneNotEqualTo(String value) {
			addCriterion("plat_user_phone <>", value, "platUserPhone");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneGreaterThan(String value) {
			addCriterion("plat_user_phone >", value, "platUserPhone");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("plat_user_phone >=", value, "platUserPhone");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneLessThan(String value) {
			addCriterion("plat_user_phone <", value, "platUserPhone");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneLessThanOrEqualTo(String value) {
			addCriterion("plat_user_phone <=", value, "platUserPhone");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneLike(String value) {
			addCriterion("plat_user_phone like", value, "platUserPhone");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneNotLike(String value) {
			addCriterion("plat_user_phone not like", value, "platUserPhone");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneIn(List<String> values) {
			addCriterion("plat_user_phone in", values, "platUserPhone");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneNotIn(List<String> values) {
			addCriterion("plat_user_phone not in", values, "platUserPhone");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneBetween(String value1, String value2) {
			addCriterion("plat_user_phone between", value1, value2, "platUserPhone");
			return (Criteria) this;
		}

		public Criteria andPlatUserPhoneNotBetween(String value1, String value2) {
			addCriterion("plat_user_phone not between", value1, value2, "platUserPhone");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressIsNull() {
			addCriterion("plat_user_address is null");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressIsNotNull() {
			addCriterion("plat_user_address is not null");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressEqualTo(String value) {
			addCriterion("plat_user_address =", value, "platUserAddress");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressNotEqualTo(String value) {
			addCriterion("plat_user_address <>", value, "platUserAddress");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressGreaterThan(String value) {
			addCriterion("plat_user_address >", value, "platUserAddress");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressGreaterThanOrEqualTo(String value) {
			addCriterion("plat_user_address >=", value, "platUserAddress");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressLessThan(String value) {
			addCriterion("plat_user_address <", value, "platUserAddress");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressLessThanOrEqualTo(String value) {
			addCriterion("plat_user_address <=", value, "platUserAddress");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressLike(String value) {
			addCriterion("plat_user_address like", value, "platUserAddress");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressNotLike(String value) {
			addCriterion("plat_user_address not like", value, "platUserAddress");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressIn(List<String> values) {
			addCriterion("plat_user_address in", values, "platUserAddress");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressNotIn(List<String> values) {
			addCriterion("plat_user_address not in", values, "platUserAddress");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressBetween(String value1, String value2) {
			addCriterion("plat_user_address between", value1, value2, "platUserAddress");
			return (Criteria) this;
		}

		public Criteria andPlatUserAddressNotBetween(String value1, String value2) {
			addCriterion("plat_user_address not between", value1, value2, "platUserAddress");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameIsNull() {
			addCriterion("org_user_name is null");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameIsNotNull() {
			addCriterion("org_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameEqualTo(String value) {
			addCriterion("org_user_name =", value, "orgUserName");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameNotEqualTo(String value) {
			addCriterion("org_user_name <>", value, "orgUserName");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameGreaterThan(String value) {
			addCriterion("org_user_name >", value, "orgUserName");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("org_user_name >=", value, "orgUserName");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameLessThan(String value) {
			addCriterion("org_user_name <", value, "orgUserName");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameLessThanOrEqualTo(String value) {
			addCriterion("org_user_name <=", value, "orgUserName");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameLike(String value) {
			addCriterion("org_user_name like", value, "orgUserName");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameNotLike(String value) {
			addCriterion("org_user_name not like", value, "orgUserName");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameIn(List<String> values) {
			addCriterion("org_user_name in", values, "orgUserName");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameNotIn(List<String> values) {
			addCriterion("org_user_name not in", values, "orgUserName");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameBetween(String value1, String value2) {
			addCriterion("org_user_name between", value1, value2, "orgUserName");
			return (Criteria) this;
		}

		public Criteria andOrgUserNameNotBetween(String value1, String value2) {
			addCriterion("org_user_name not between", value1, value2, "orgUserName");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressIsNull() {
			addCriterion("org_user_address is null");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressIsNotNull() {
			addCriterion("org_user_address is not null");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressEqualTo(String value) {
			addCriterion("org_user_address =", value, "orgUserAddress");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressNotEqualTo(String value) {
			addCriterion("org_user_address <>", value, "orgUserAddress");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressGreaterThan(String value) {
			addCriterion("org_user_address >", value, "orgUserAddress");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressGreaterThanOrEqualTo(String value) {
			addCriterion("org_user_address >=", value, "orgUserAddress");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressLessThan(String value) {
			addCriterion("org_user_address <", value, "orgUserAddress");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressLessThanOrEqualTo(String value) {
			addCriterion("org_user_address <=", value, "orgUserAddress");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressLike(String value) {
			addCriterion("org_user_address like", value, "orgUserAddress");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressNotLike(String value) {
			addCriterion("org_user_address not like", value, "orgUserAddress");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressIn(List<String> values) {
			addCriterion("org_user_address in", values, "orgUserAddress");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressNotIn(List<String> values) {
			addCriterion("org_user_address not in", values, "orgUserAddress");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressBetween(String value1, String value2) {
			addCriterion("org_user_address between", value1, value2, "orgUserAddress");
			return (Criteria) this;
		}

		public Criteria andOrgUserAddressNotBetween(String value1, String value2) {
			addCriterion("org_user_address not between", value1, value2, "orgUserAddress");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneIsNull() {
			addCriterion("org_user_phone is null");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneIsNotNull() {
			addCriterion("org_user_phone is not null");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneEqualTo(String value) {
			addCriterion("org_user_phone =", value, "orgUserPhone");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneNotEqualTo(String value) {
			addCriterion("org_user_phone <>", value, "orgUserPhone");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneGreaterThan(String value) {
			addCriterion("org_user_phone >", value, "orgUserPhone");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("org_user_phone >=", value, "orgUserPhone");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneLessThan(String value) {
			addCriterion("org_user_phone <", value, "orgUserPhone");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneLessThanOrEqualTo(String value) {
			addCriterion("org_user_phone <=", value, "orgUserPhone");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneLike(String value) {
			addCriterion("org_user_phone like", value, "orgUserPhone");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneNotLike(String value) {
			addCriterion("org_user_phone not like", value, "orgUserPhone");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneIn(List<String> values) {
			addCriterion("org_user_phone in", values, "orgUserPhone");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneNotIn(List<String> values) {
			addCriterion("org_user_phone not in", values, "orgUserPhone");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneBetween(String value1, String value2) {
			addCriterion("org_user_phone between", value1, value2, "orgUserPhone");
			return (Criteria) this;
		}

		public Criteria andOrgUserPhoneNotBetween(String value1, String value2) {
			addCriterion("org_user_phone not between", value1, value2, "orgUserPhone");
			return (Criteria) this;
		}

		public Criteria andPlatOrgStateIsNull() {
			addCriterion("plat_org_state is null");
			return (Criteria) this;
		}

		public Criteria andPlatOrgStateIsNotNull() {
			addCriterion("plat_org_state is not null");
			return (Criteria) this;
		}

		public Criteria andPlatOrgStateEqualTo(Integer value) {
			addCriterion("plat_org_state =", value, "platOrgState");
			return (Criteria) this;
		}

		public Criteria andPlatOrgStateNotEqualTo(Integer value) {
			addCriterion("plat_org_state <>", value, "platOrgState");
			return (Criteria) this;
		}

		public Criteria andPlatOrgStateGreaterThan(Integer value) {
			addCriterion("plat_org_state >", value, "platOrgState");
			return (Criteria) this;
		}

		public Criteria andPlatOrgStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("plat_org_state >=", value, "platOrgState");
			return (Criteria) this;
		}

		public Criteria andPlatOrgStateLessThan(Integer value) {
			addCriterion("plat_org_state <", value, "platOrgState");
			return (Criteria) this;
		}

		public Criteria andPlatOrgStateLessThanOrEqualTo(Integer value) {
			addCriterion("plat_org_state <=", value, "platOrgState");
			return (Criteria) this;
		}

		public Criteria andPlatOrgStateIn(List<Integer> values) {
			addCriterion("plat_org_state in", values, "platOrgState");
			return (Criteria) this;
		}

		public Criteria andPlatOrgStateNotIn(List<Integer> values) {
			addCriterion("plat_org_state not in", values, "platOrgState");
			return (Criteria) this;
		}

		public Criteria andPlatOrgStateBetween(Integer value1, Integer value2) {
			addCriterion("plat_org_state between", value1, value2, "platOrgState");
			return (Criteria) this;
		}

		public Criteria andPlatOrgStateNotBetween(Integer value1, Integer value2) {
			addCriterion("plat_org_state not between", value1, value2, "platOrgState");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoIsNull() {
			addCriterion("plat_org_video is null");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoIsNotNull() {
			addCriterion("plat_org_video is not null");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoEqualTo(String value) {
			addCriterion("plat_org_video =", value, "platOrgVideo");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoNotEqualTo(String value) {
			addCriterion("plat_org_video <>", value, "platOrgVideo");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoGreaterThan(String value) {
			addCriterion("plat_org_video >", value, "platOrgVideo");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoGreaterThanOrEqualTo(String value) {
			addCriterion("plat_org_video >=", value, "platOrgVideo");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoLessThan(String value) {
			addCriterion("plat_org_video <", value, "platOrgVideo");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoLessThanOrEqualTo(String value) {
			addCriterion("plat_org_video <=", value, "platOrgVideo");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoLike(String value) {
			addCriterion("plat_org_video like", value, "platOrgVideo");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoNotLike(String value) {
			addCriterion("plat_org_video not like", value, "platOrgVideo");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoIn(List<String> values) {
			addCriterion("plat_org_video in", values, "platOrgVideo");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoNotIn(List<String> values) {
			addCriterion("plat_org_video not in", values, "platOrgVideo");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoBetween(String value1, String value2) {
			addCriterion("plat_org_video between", value1, value2, "platOrgVideo");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVideoNotBetween(String value1, String value2) {
			addCriterion("plat_org_video not between", value1, value2, "platOrgVideo");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVerifyIsNull() {
			addCriterion("plat_org_verify is null");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVerifyIsNotNull() {
			addCriterion("plat_org_verify is not null");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVerifyEqualTo(Integer value) {
			addCriterion("plat_org_verify =", value, "platOrgVerify");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVerifyNotEqualTo(Integer value) {
			addCriterion("plat_org_verify <>", value, "platOrgVerify");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVerifyGreaterThan(Integer value) {
			addCriterion("plat_org_verify >", value, "platOrgVerify");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVerifyGreaterThanOrEqualTo(Integer value) {
			addCriterion("plat_org_verify >=", value, "platOrgVerify");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVerifyLessThan(Integer value) {
			addCriterion("plat_org_verify <", value, "platOrgVerify");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVerifyLessThanOrEqualTo(Integer value) {
			addCriterion("plat_org_verify <=", value, "platOrgVerify");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVerifyIn(List<Integer> values) {
			addCriterion("plat_org_verify in", values, "platOrgVerify");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVerifyNotIn(List<Integer> values) {
			addCriterion("plat_org_verify not in", values, "platOrgVerify");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVerifyBetween(Integer value1, Integer value2) {
			addCriterion("plat_org_verify between", value1, value2, "platOrgVerify");
			return (Criteria) this;
		}

		public Criteria andPlatOrgVerifyNotBetween(Integer value1, Integer value2) {
			addCriterion("plat_org_verify not between", value1, value2, "platOrgVerify");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeIsNull() {
			addCriterion("plat_org_express_code is null");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeIsNotNull() {
			addCriterion("plat_org_express_code is not null");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeEqualTo(String value) {
			addCriterion("plat_org_express_code =", value, "platOrgExpressCode");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeNotEqualTo(String value) {
			addCriterion("plat_org_express_code <>", value, "platOrgExpressCode");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeGreaterThan(String value) {
			addCriterion("plat_org_express_code >", value, "platOrgExpressCode");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeGreaterThanOrEqualTo(String value) {
			addCriterion("plat_org_express_code >=", value, "platOrgExpressCode");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeLessThan(String value) {
			addCriterion("plat_org_express_code <", value, "platOrgExpressCode");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeLessThanOrEqualTo(String value) {
			addCriterion("plat_org_express_code <=", value, "platOrgExpressCode");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeLike(String value) {
			addCriterion("plat_org_express_code like", value, "platOrgExpressCode");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeNotLike(String value) {
			addCriterion("plat_org_express_code not like", value, "platOrgExpressCode");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeIn(List<String> values) {
			addCriterion("plat_org_express_code in", values, "platOrgExpressCode");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeNotIn(List<String> values) {
			addCriterion("plat_org_express_code not in", values, "platOrgExpressCode");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeBetween(String value1, String value2) {
			addCriterion("plat_org_express_code between", value1, value2, "platOrgExpressCode");
			return (Criteria) this;
		}

		public Criteria andPlatOrgExpressCodeNotBetween(String value1, String value2) {
			addCriterion("plat_org_express_code not between", value1, value2, "platOrgExpressCode");
			return (Criteria) this;
		}

		public Criteria andPlatOrgTimeIsNull() {
			addCriterion("plat_org_time is null");
			return (Criteria) this;
		}

		public Criteria andPlatOrgTimeIsNotNull() {
			addCriterion("plat_org_time is not null");
			return (Criteria) this;
		}

		public Criteria andPlatOrgTimeEqualTo(java.util.Date value) {
			addCriterion("plat_org_time =", value, "platOrgTime");
			return (Criteria) this;
		}

		public Criteria andPlatOrgTimeNotEqualTo(java.util.Date value) {
			addCriterion("plat_org_time <>", value, "platOrgTime");
			return (Criteria) this;
		}

		public Criteria andPlatOrgTimeGreaterThan(java.util.Date value) {
			addCriterion("plat_org_time >", value, "platOrgTime");
			return (Criteria) this;
		}

		public Criteria andPlatOrgTimeGreaterThanOrEqualTo(java.util.Date value) {
			addCriterion("plat_org_time >=", value, "platOrgTime");
			return (Criteria) this;
		}

		public Criteria andPlatOrgTimeLessThan(java.util.Date value) {
			addCriterion("plat_org_time <", value, "platOrgTime");
			return (Criteria) this;
		}

		public Criteria andPlatOrgTimeLessThanOrEqualTo(java.util.Date value) {
			addCriterion("plat_org_time <=", value, "platOrgTime");
			return (Criteria) this;
		}

		public Criteria andPlatOrgTimeIn(List<java.util.Date> values) {
			addCriterion("plat_org_time in", values, "platOrgTime");
			return (Criteria) this;
		}

		public Criteria andPlatOrgTimeNotIn(List<java.util.Date> values) {
			addCriterion("plat_org_time not in", values, "platOrgTime");
			return (Criteria) this;
		}

		public Criteria andPlatOrgTimeBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("plat_org_time between", value1, value2, "platOrgTime");
			return (Criteria) this;
		}

		public Criteria andPlatOrgTimeNotBetween(java.util.Date value1, java.util.Date value2) {
			addCriterion("plat_org_time not between", value1, value2, "platOrgTime");
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

		public Criteria andExperterInfoIdIsNull() {
			addCriterion("experter_info_id is null");
			return (Criteria) this;
		}

		public Criteria andExperterInfoIdIsNotNull() {
			addCriterion("experter_info_id is not null");
			return (Criteria) this;
		}

		public Criteria andExperterInfoIdEqualTo(Integer value) {
			addCriterion("experter_info_id =", value, "experterInfoId");
			return (Criteria) this;
		}

		public Criteria andExperterInfoIdNotEqualTo(Integer value) {
			addCriterion("experter_info_id <>", value, "experterInfoId");
			return (Criteria) this;
		}

		public Criteria andExperterInfoIdGreaterThan(Integer value) {
			addCriterion("experter_info_id >", value, "experterInfoId");
			return (Criteria) this;
		}

		public Criteria andExperterInfoIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("experter_info_id >=", value, "experterInfoId");
			return (Criteria) this;
		}

		public Criteria andExperterInfoIdLessThan(Integer value) {
			addCriterion("experter_info_id <", value, "experterInfoId");
			return (Criteria) this;
		}

		public Criteria andExperterInfoIdLessThanOrEqualTo(Integer value) {
			addCriterion("experter_info_id <=", value, "experterInfoId");
			return (Criteria) this;
		}

		public Criteria andExperterInfoIdIn(List<Integer> values) {
			addCriterion("experter_info_id in", values, "experterInfoId");
			return (Criteria) this;
		}

		public Criteria andExperterInfoIdNotIn(List<Integer> values) {
			addCriterion("experter_info_id not in", values, "experterInfoId");
			return (Criteria) this;
		}

		public Criteria andExperterInfoIdBetween(Integer value1, Integer value2) {
			addCriterion("experter_info_id between", value1, value2, "experterInfoId");
			return (Criteria) this;
		}

		public Criteria andExperterInfoIdNotBetween(Integer value1, Integer value2) {
			addCriterion("experter_info_id not between", value1, value2, "experterInfoId");
			return (Criteria) this;
		}

		public Criteria andSfProtectPriceIsNull() {
			addCriterion("sf_protect_price is null");
			return (Criteria) this;
		}

		public Criteria andSfProtectPriceIsNotNull() {
			addCriterion("sf_protect_price is not null");
			return (Criteria) this;
		}

		public Criteria andSfProtectPriceEqualTo(java.math.BigDecimal value) {
			addCriterion("sf_protect_price =", value, "sfProtectPrice");
			return (Criteria) this;
		}

		public Criteria andSfProtectPriceNotEqualTo(java.math.BigDecimal value) {
			addCriterion("sf_protect_price <>", value, "sfProtectPrice");
			return (Criteria) this;
		}

		public Criteria andSfProtectPriceGreaterThan(java.math.BigDecimal value) {
			addCriterion("sf_protect_price >", value, "sfProtectPrice");
			return (Criteria) this;
		}

		public Criteria andSfProtectPriceGreaterThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("sf_protect_price >=", value, "sfProtectPrice");
			return (Criteria) this;
		}

		public Criteria andSfProtectPriceLessThan(java.math.BigDecimal value) {
			addCriterion("sf_protect_price <", value, "sfProtectPrice");
			return (Criteria) this;
		}

		public Criteria andSfProtectPriceLessThanOrEqualTo(java.math.BigDecimal value) {
			addCriterion("sf_protect_price <=", value, "sfProtectPrice");
			return (Criteria) this;
		}

		public Criteria andSfProtectPriceIn(List<java.math.BigDecimal> values) {
			addCriterion("sf_protect_price in", values, "sfProtectPrice");
			return (Criteria) this;
		}

		public Criteria andSfProtectPriceNotIn(List<java.math.BigDecimal> values) {
			addCriterion("sf_protect_price not in", values, "sfProtectPrice");
			return (Criteria) this;
		}

		public Criteria andSfProtectPriceBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("sf_protect_price between", value1, value2, "sfProtectPrice");
			return (Criteria) this;
		}

		public Criteria andSfProtectPriceNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
			addCriterion("sf_protect_price not between", value1, value2, "sfProtectPrice");
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