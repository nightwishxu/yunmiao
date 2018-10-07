package com.base;

import com.base.support.PropertySupport;

public class ConstantsCode {

	public static final String WELCOME_IMG = "welcome@sys";//欢迎页
	public static final String OAUTH_LOGIN = "oauthLogin@sys";//第三方登录开关
	public static final String SERVER_URL = PropertySupport.getProperty("server.url");
	public static final String SERVER_PUSH_URL = SERVER_URL+"ws/send";
	public static final String API_URL = PropertySupport.getProperty("api.url");
	public static final String ICON_URL = SERVER_URL + "download?id=";
	public static final String SERVICE_CACHE = "serviceCache";
	public static final String PROJECT_NAME = PropertySupport.getProperty("project.name");
	public static final boolean MULTI_LOGIN = "true".equals(PropertySupport.getProperty("api.login.multi"))?true:false;

	public static final String FFMPEG_PATH = PropertySupport.getProperty("ffmpeg.path","");

	public static final boolean DEBUG = "true".equals(PropertySupport.getProperty("api.debug"))?true:false;
	public static final boolean AJAX_DEBUG = "true".equals(PropertySupport.getProperty("api.ajax.debug"))?true:false;
	public static final String ENCRYPT = PropertySupport.getProperty("api.encrypt","DES");
}
