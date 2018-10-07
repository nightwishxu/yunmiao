package com.api;

import com.base.api.IMError;

public enum MErrorEnum implements IMError{
	APPID_FAIL_ERROR(100,"系统异常"),
	TOKEN_NOTEXISTS_ERROR(101,"缺少token信息"), 
	LOGIN_FAIL_ERROR(102,"登录失效，请重新登录"), 
	FILE_NOT_EXISTS(103,"文件不存在"), 
	PAGE_LIMIT_NONG(104,"缺少分页参数page,limit"), 
	SERVER_BUSY_ERROR(10000,"服务器忙，请稍后再试"),
	UPLOAD_FAILURE_ERROR(10001,"文件上传失败"),
	USER_NOEXIST_ERROR(10002,"用户不存在"), 
	LOGIN_FAILURE_ERROR(10003,"用户名或密码不正确"), 
	PHONE_EXISTS_ERROR(10004,"手机号已存在"), 
	NICK_EXISTS_ERROR(10004,"昵称已存在"), 
	PHONE_NOTEXISTS_ERROR(10005,"手机号不存在"), 
	MOBILE_CODE_ERROR(10006,"短信验证码错误"),
	CREATE_ACCOUNT_ERROR(10007,"注册失败"), 
	ACCOUNT_STOP_ERROR(10008,"账号已被封停"), 
	UPDATE_ACCOUNT_ERROR(10009,"账号更新失败"), 
	PASSWORD_FALSE_ERROR(10010,"密码错误"),
	OAUTHLOGIN_FAILURE_ERROR(10011,"登录失败"),
	OPERATION_FAILURE_ERROR(10012,"交易失败"),
	COUPON_FAILURE_ERROR(10013,"优惠券异常"),
	GOODS_NOTEXISTS_ERROR(10014,"商品不存在"),
	VIDEO_NOTEXISTS_ERROR(10015,"视频不存在 "),
	ORG_NOT_VERIFY(10016,"上次续当申请还未结束，请等待"),
	GOODS_OUT_TIME(10017,"本次交易已经逾期，请联系客户人员"),
	
	SMS_ERROR_4086(10100,"发送失败，短时间内该号码提交次数过多，如有疑问请联系客服。"),
	SMS_ERROR(20101,"短信发送失败"), 
	
	CASH_NOT_ENOUGHT(10901,"余额不足"), 
	WM_ORDER_NOTEXISTS(10902,"订单不存在"), 
	WM_ORDER_CANDOTHIS(10903,"订单无法做此项操作"),
	APPLY_IS_WORKING(10904,"申请请求处理中，请耐心等待"),
	;

	/** 错误编码 */
	private int errorCode;

	/** 错误信息 */
	private String errorMsg;
	
	/**
	 * 构造函数
	 */
	private MErrorEnum(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	/**
	 * @return int 错误代码
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @return String 错误信息
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

}
