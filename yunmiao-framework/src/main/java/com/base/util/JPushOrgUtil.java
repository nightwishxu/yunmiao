package com.base.util;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.connection.NativeHttpClient;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.base.CoreConstants;
import com.base.support.LogKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class JPushOrgUtil {

	protected static final Logger LOG = LoggerFactory
			.getLogger(JPushOrgUtil.class);

	private static String APPKEY = CoreConstants.getProperty("jpush.org.appkey");
	private static String SECRET = CoreConstants.getProperty("jpush.org.secret");
	private static boolean PRODUCT = "true".equals(CoreConstants.getProperty("jpush.org.product"))?true:false;
	private static JPushClient jpushClient;
	public static final String JPUSH_SOUND = "sound";
	static {
		ClientConfig clientConfig = ClientConfig.getInstance();
		clientConfig.setReadTimeout(60000);
		jpushClient = new JPushClient(SECRET, APPKEY, null,
				clientConfig);
		String authCode = ServiceHelper.getBasicAuthorization(APPKEY, SECRET);
		NativeHttpClient httpClient = new NativeHttpClient(authCode, null, clientConfig);
		jpushClient.getPushClient().setHttpClient(httpClient);
	}

	public static PushPayload buildPushObject_all_all_alert(String msg) {
		return PushPayload.alertAll(msg);
	}

	public static String pushMessageToApp(Map<String,String> params,String iosMsg) {
		PushPayload payload = PushPayload.newBuilder().setAudience(Audience.all()).setPlatform(Platform.android_ios())
				.setNotification(loadNotification(params, iosMsg, null)).setMessage(message(params,iosMsg)).setOptions(loadOptions()).build();
		try {
			PushResult result = jpushClient.sendPush(payload);
			LOG.info("Got result - " + result);
			return result.getOriginalContent();
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
			LOG.error("Sendno: " + payload.getSendno());
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            LOG.error("Sendno: " + payload.getSendno());
            return e.getErrorCode()+","+e.getErrorMessage();
		}
		return null;
	}
	
	public static String pushMessageToSingle(Map<String,String> params,String iosMsg,String cid){
		PushPayload payload = PushPayload.newBuilder().setAudience(Audience.registrationId(cid)).setPlatform(Platform.android_ios())
				.setNotification(loadNotification(params, iosMsg, null)).setMessage(message(params,iosMsg)).setOptions(loadOptions()).build();
		try {
			PushResult result = jpushClient.sendPush(payload);
			LOG.info("Got result - " + result);
			return result.getOriginalContent();
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
			LOG.error("Sendno: " + payload.getSendno());
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            LOG.error("Sendno: " + payload.getSendno());
		}
		return null;
	}
	
	public static String pushMessageToList(Map<String,String> params,String iosMsg,List<String> cid){
		LogKit.debug("=======【开始】打印类JPushOrgUtil的pushMessageToList方法的入参【Map<String,String> params】========");
		for (Map.Entry entry:params.entrySet()) {
			LogKit.debug("key:"+entry.getKey()+"->value:"+entry.getValue());
		}
		LogKit.debug("=======【结束】打印类JPushOrgUtil的pushMessageToList方法的入参【Map<String,String> params】========");
		LogKit.debug("===========类JPushOrgUtil的pushMessageToList方法的入参【iosMsg】:"+iosMsg+"======================");
		LogKit.debug("=======【开始】打印类JPushOrgUtil的pushMessageToList方法的入参【List<String> cid】========");
		for (String element:cid) {
			LogKit.debug(element);
		}
		LogKit.debug("=======【结束】打印类JPushOrgUtil的pushMessageToList方法的入参【List<String> cid】========");
		PushPayload payload = PushPayload.newBuilder().setAudience(Audience.registrationId(cid)).setPlatform(Platform.android_ios())
				.setNotification(loadNotification(params, iosMsg, null)).setMessage(message(params,iosMsg)).setOptions(loadOptions()).build();
		try {
			PushResult result = jpushClient.sendPush(payload);
			LOG.info("Got result - " + result);
			return result.getOriginalContent();
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
			LOG.error("Sendno: " + payload.getSendno());
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            LOG.error("Sendno: " + payload.getSendno());
		}
		return null;
	}
	
	private static Options loadOptions(){
		Options.Builder options = Options.newBuilder();
		options.setApnsProduction(PRODUCT);
		return options.build();
	}
	
	private static Notification loadNotification(Map<String,String> params,String iosMsg,String title){
		Notification.Builder builder = Notification.newBuilder();
		return builder.setAlert(iosMsg).addPlatformNotification(androidNotification(params, title)).addPlatformNotification(iosNotification(params)).build();
	}
	
	private static AndroidNotification androidNotification(Map<String,String> params,String title){
		AndroidNotification.Builder ret = AndroidNotification.newBuilder();
		if (params != null)
			ret.addExtras(params);
		if (title != null){
			ret.setTitle(title);
		}
		return ret.build();
	}
	
	private static IosNotification iosNotification(Map<String,String> params){
		IosNotification.Builder ret = IosNotification.newBuilder();
		if (params != null){
			if(params.containsKey(JPUSH_SOUND)){
				ret.setSound(params.get(JPUSH_SOUND));
				params.remove(JPUSH_SOUND);
			}
			ret.addExtras(params);
		}
		return ret.build();
	}
	
	private static Message message(Map<String,String> params,String content){
		Message.Builder ret = Message.newBuilder();
		ret.setMsgContent(content);
		if (params != null)
			ret.addExtras(params);
		return ret.build();
	}
}
