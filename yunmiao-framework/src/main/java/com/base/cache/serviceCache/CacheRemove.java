package com.base.cache.serviceCache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheRemove {
	String cache() default ServiceAop.CAHCE_NAME;
	
	String group();
	
	String key() default "";
}
