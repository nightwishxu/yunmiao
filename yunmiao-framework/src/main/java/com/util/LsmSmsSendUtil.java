package com.util;

import com.alibaba.fastjson.JSONObject;
import com.base.http.HttpRequest;
import com.base.http.Method;
import com.base.support.PropertySupport;
import com.base.util.Sendsms;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 螺丝帽短信平台
 */
public class LsmSmsSendUtil {

	private static final String USERNAME = PropertySupport.getProperty("sms.account");
	private static String PASSWORD = PropertySupport.getProperty("sms.pwd");
	private static String SIGN = "【"+PropertySupport.getProperty("sms.sign")+"】";
	private static String url = "http://sms-api.luosimao.com/v1/send.json";
	private static final Charset CHARACTER_SET = Charset.forName("iso-8859-1");
	
	private static Map<String, Sendsms> smsError;
	
	private static void init(){
		smsError = new HashMap<String, Sendsms>();
		Sendsms[] arr = Sendsms.values();
		for (Sendsms sendsms : arr){
			smsError.put(sendsms.getCode(), sendsms);
		}
	}
	
	public static String getSmsError(String code) throws Exception {
		if (smsError == null) init();
		if(smsError.get(code)!=null)
			return smsError.get(code).getMsg();
		else
			return null;
	}

	public static String push(String mobile,String content){
		HttpRequest httpRequest = new HttpRequest(url);
		httpRequest.method(Method.POST);
		httpRequest.basicAuth("api","key-"+PASSWORD);
		httpRequest.header("accept","*/*");
		httpRequest.form("mobile",mobile).form("message",content+SIGN);
		JSONObject respose = JSONObject.parseObject(httpRequest.execute().body());
		if (0 == respose.getIntValue("error")){
			return "2";
		}
		return "0";
	}

}
