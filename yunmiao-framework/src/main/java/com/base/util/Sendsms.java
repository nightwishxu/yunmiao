package com.base.util;

public enum Sendsms {
	
	SEND_FAIL("0","提交失败"),
	SEND_SUCCESS("2","提交成功"),
	ILLEAGLE_IP("400","非法ip访问"),
	ACCOUNT_NULL("401","帐号不能为空"),
	SPACE_SHORT("4010","通道限制：每个号码1分钟内只能发1条"),
	PWD_NULL("402","密码不能为空"),
	PHONE_NULL("403","手机号码不能为空"),
	PHONE_BLACK("4030","手机号码已被列入黑名单"),
	CONTENT_NULL("404","短信内容不能为空"),
	LOGIN_FAIL("405","用户名或密码不正确"),
	ACCOUNT_LOCK("4050","账号被冻结"),
	LESS_COUNT("4051","剩余条数不足"),
	IP_WRONG("4052","访问ip与备案ip不符"),
	PHONE_WRONG("406","手机格式不正确"),
	CONTENT_WRONG("407","短信内容含有敏感字符"),
	SING_WRONG("4070","签名格式不正确"),
	TEMPLATE_NULL("4071","没有提交备案模板"),
	TEMPLATE_WRONG("4072","短信内容与模板不匹配"),
	CONTENT_LONG("4073","短信内容超出长度限制"),
	PHONE_FAST("408","同一手机号码一分钟之内发送频率超过10条，系统将冻结你的帐号"),
	PHONE_SECOND("4080","同一手机号码同一秒钟不能超过2条"),
	PHONE_MIN("4081","同一手机号码一分钟之内发送频率超不能超过1条"),
	PHONE_DAY("4082","同一手机号码一天之内发送频率超不能超过5条"),
	SAME_CONTENT_MIN("4083","同内容每分钟限制：1条"),
	SAME_CONTENT_DAY("4084","同内容每日限制：5条"),
	PHONE_IDENTIFY("4085","同一手机号码验证码短信发送量超出5条"),
	PHONE_TOO_FAST("4086","发送失败，同一个手机号码发送频率太频繁"),
	PHONE_BLANK_LIST("40864","发送失败，手机号已被列入黑名单"),
	
	SEND_TO_QUICK("-1","请求频率太频繁~"),
	SEND_TO_IP("-2","请求次数太多了~"),
	;
	
	private String code;
	
	private String msg;
	
	private Sendsms(String code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public String getMsg(){
		return this.msg;
	}
	
	public String getCode(){
		return this.code;
	}
}
