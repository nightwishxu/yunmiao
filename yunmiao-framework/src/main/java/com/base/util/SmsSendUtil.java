package com.base.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import com.base.support.LogKit;
import com.base.support.PropertySupport;
import com.base.util.Sendsms;

public class SmsSendUtil {

	private static final String USERNAME = PropertySupport.getProperty("sms.account");
	private static String PASSWORD = PropertySupport.getProperty("sms.pwd");
	private static String url = "http://js10088.com:18001/?Action=SendSms&UserName=USERNAME&Password=PASSWORD&Mobile=MOBILE&Message=MESSAGE";
	
	private static Map<String, Sendsms> smsError;
	
	static{
		PASSWORD = DigestUtils.md5Hex(PASSWORD);
		url = url.replaceAll("USERNAME", USERNAME).replaceAll("PASSWORD", PASSWORD);
	}
	
	public static String push(String mobile,String content){
		try {
			content = URLEncoder.encode(content, "utf-8");
			String sendUrl = url.replace("MOBILE", mobile).replace("MESSAGE", content);
			HttpClient client = new HttpClient();
	        HttpMethod method = new GetMethod( sendUrl );
	        // 这里设置字符编码，避免乱码
	        method.setRequestHeader("Content-Type", "text/html;charset=utf-8");
	 
	        client.executeMethod(method);
	        // 打印服务器返回的状态
	        System.out.println(method.getStatusLine());
	 
	        // 获取返回的html页面
	        byte[] body = method.getResponseBody();
	        // 打印返回的信息
	        String result = new String(body, "utf-8");
	        LogKit.debug("短信发送结果:"+result);
	        if(result.startsWith("0:")){
	        	LogKit.debug("短信发送成功");
	        	return "2";
	        }else{
	        	LogKit.debug("发送失败");
	        }
	        // 释放连接
	        method.releaseConnection();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
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
}
