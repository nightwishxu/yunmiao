package com.api;

import com.base.api.IMError;

public enum MEnumError implements IMError {
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
	CONTENT_NOEXIST_ERROR(10012,"内容不存在"),
	NICK_LEN_ERROR(10013,"昵称太长了"),
	PAY_TYPE_ERRPR(10014,"支付方式错误"),
	OPEN_ERROR(-1,"开发中"),
	APP_VERSION_NULL(1005,"APP版本不存在"),
	OPER_FAILURE_ERROE(1006,"操作失败"),
	ADDRESS_EXISTS_ERROR(1007,"地址不存在"),
	BANKCARD_BIND_ERROR(1008,"银行卡绑定失败"),
	MAX_PRICE_ERROR(1009,"输入的价格必须大于当前价格"),
	ORG_IS_PAY(1010,"机构端已经付款"),
	NAME_ERROE(1011,"身份证名字必须与银行卡名字一致"),
	
	
	SMS_ERROR_4086(10100,"发送失败，短时间内该号码提交次数过多，如有疑问请联系客服。"),
	SMS_ERROR(20101,"短信发送失败"), 
	
	CASH_NOT_ENOUGHT(10901,"余额不足"), 
	WM_ORDER_NOTEXISTS(10902,"订单不存在"), 
	WM_ORDER_CANDOTHIS(10903,"订单无法做此项操作"), 
	
	PRAISE_AGAIN_ERROR(20001,"您已经赞过"),

	NEWS_NOT_EXIST(20002,"新闻不存在"),
	GOODS_NOT_EXIST(20003,"商品不存在"),
	COUPON_TYPE_EXIST(20004,"优惠券状态错误"),
	ADDRESS_NOT_EXIST(20005,"地址不存在"),
	STATE_ERROR(20006,"状态异常请联系客服"),
	ORDER_STATE_ERROR(20007,"请先确认收货"),
	ORDER_IS_HANDLE(20008,"请等待，客服正在处理中"),
	CONTENT_CAN_NOT_BE_NULL(20009,"原因不可为空"),
	CAN_NOT_REFUND(20010,"不可退款")
	;


	/** 错误编码 */
	private int errorCode;

	/** 错误信息 */
	private String errorMsg;
	
	/**
	 * 构造函数
	 */
	private MEnumError(int errorCode, String errorMsg) {
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
