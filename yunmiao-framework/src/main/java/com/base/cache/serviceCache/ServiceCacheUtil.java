package com.base.cache.serviceCache;

public class ServiceCacheUtil {

	private static final String PREFIX = "SERVICE:";
	
	public static String getKeys(String group){
		return PREFIX+group+":*";
	}
	
	public static String getKey(String group, String key){
		return PREFIX+group+":"+key;
	}
	
	public static String getKeys(){
		return PREFIX+"*";
	}
	
}
