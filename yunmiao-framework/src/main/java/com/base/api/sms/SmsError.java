package com.base.api.sms;

import java.util.HashMap;
import java.util.Map;

import com.base.util.Sendsms;

public class SmsError {

	private static Map<String, Sendsms> smsError = new HashMap<String, Sendsms>();
	
	static{
		Sendsms[] arr = Sendsms.values();
		for (Sendsms sendsms : arr){
			smsError.put(sendsms.getCode(), sendsms);
		}
	}
	
	public static String getSmsError(String code) throws Exception {
		if(smsError.get(code)!=null)
			return smsError.get(code).getMsg();
		else
			return null;
	}
	
}
