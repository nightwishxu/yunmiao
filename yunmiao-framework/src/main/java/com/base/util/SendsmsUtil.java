package com.base.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.base.CoreConstants;
import com.base.util.HttpClientUtils;
import com.base.util.Sendsms;

/**
 * 短信通道
 */
@Service
public class SendsmsUtil {
	private static final Logger logger = Logger.getLogger(SendsmsUtil.class);
	private static final String account = CoreConstants.SENDSMS_ACCOUNT;
	private static final String password = CoreConstants.SENDSMS_PWD;
	private static final String url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	private static final Header header = new Header() {
		public String getValue() {
			return "application/x-www-form-urlencoded;charset=UTF-8";
		}
		public String getName() {
			return "ContentType";
		}
		public HeaderElement[] getElements() throws ParseException {
			return null;
		}
	};
	private static Map<String, Sendsms> smsError;
	/**
	 * @返回code 4086：频繁发送
	 */
	public static String push(String mobile,String content){
		Map<String, String> params = new HashMap<String, String>();
		params.put("account", account);
		params.put("password", password);
		params.put("mobile", mobile);
		params.put("content", content);
		try {
			String SubmitResult = HttpClientUtils.post(url, params, "UTF-8", "UTF-8",new Header[]{header});
			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();
			String code = root.elementText("code");	
			String msg = root.elementText("msg");	
			String smsid = root.elementText("smsid");	
			logger.info("短信通道反馈：["+mobile+"]["+ code + "][" + msg + "][" + smsid + "]");
			return code;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
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
