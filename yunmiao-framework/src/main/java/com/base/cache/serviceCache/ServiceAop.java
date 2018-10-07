package com.base.cache.serviceCache;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import com.base.cache.redis.ReditClient;
import com.base.util.DateUtil;

@Aspect
@Component
public class ServiceAop {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	public static final String CAHCE_NAME = "";

	private static ExpressionParser parser = null;
	
	private static LocalVariableTableParameterNameDiscoverer u = null;
	
	static{
		u = new LocalVariableTableParameterNameDiscoverer();
		parser = new SpelExpressionParser();
	}
	
	/**
	 * go方法
	 */
	private final static String addEl = "execution(* com.*.service.*Service.*(..)) && @annotation(com.base.cache.serviceCache.CacheAdd)";
	
	private final static String removeEl = "execution(* com.*.service.*Service.*(..)) && @annotation(com.base.cache.serviceCache.CacheRemove)";

	@Around(addEl)
	public Object add(ProceedingJoinPoint p) {
		Method method = ((MethodSignature) p.getSignature()).getMethod();
		Object result = null;
		CacheAdd cacheAdd = method.getAnnotation(CacheAdd.class);
		String key = cacheAdd.key();
		if (key.equals("")) {
			key = getCacheKey(p.getTarget().getClass().getName(), p
					.getSignature().getName(), p.getArgs());
		}else {
			key = parseKey(key, method, p.getArgs());
		}
		key = ServiceCacheUtil.getKey(cacheAdd.group(), key);
		result = ReditClient.get(key);
		if (result == null) {
			try {
				result = p.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}

			if (result != null) {
				ReditClient.set(key, result);
			}
		}
		return result;
	}
	
	@Around(removeEl)
	public Object remove(ProceedingJoinPoint p){
		Method method = ((MethodSignature) p.getSignature()).getMethod();
		Object result = null;
		CacheRemove cacheRemove = method.getAnnotation(CacheRemove.class);
		String key = cacheRemove.key();
		if (key.equals("")) {
			ReditClient.deleteKeys(ServiceCacheUtil.getKeys(cacheRemove.group()));
		} else {
			key = parseKey(key, method, p.getArgs());
			ReditClient.del(ServiceCacheUtil.getKey(cacheRemove.group(), key));
		}
		try {
			result = p.proceed();
		} catch (Throwable e) {
		}
		return result;
	}

	/**
	 * 未定义缓存key，自动生成key
	 * @return
	 */
	private String getCacheKey(String targetName, String methodName,
			Object[] arguments) {
		StringBuffer sb = new StringBuffer();
		sb.append(targetName).append(".").append(methodName);
		if ((arguments != null) && (arguments.length != 0)) {
			for (int i = 0; i < arguments.length; i++) {
				if (arguments[i] instanceof Date) {
					sb.append(".").append(
							DateUtil.dateToStr((Date) arguments[i]));
				} else {
					sb.append(".").append(arguments[i]);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 获取缓存的key key 定义在注解上，支持SPEL表达式
	 */
	private String parseKey(String key, Method method, Object[] args) {
		String[] paraNameArr = u.getParameterNames(method);
		// SPEL上下文
		StandardEvaluationContext context = new StandardEvaluationContext();
		// 把方法参数放入SPEL上下文中
		for (int i = 0; i < paraNameArr.length; i++) {
			context.setVariable(paraNameArr[i], args[i]);
		}
		return parser.parseExpression(key).getValue(context, String.class);
	}
}
