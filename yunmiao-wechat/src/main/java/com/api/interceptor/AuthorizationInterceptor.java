package com.api.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.cache.bean.MobileVerifyRedisCache;
import com.base.cache.redis.ReditClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.api.MEnumError;
import com.api.MErrorEnum;
import com.base.Const;
import com.base.api.ApiException;
import com.base.api.annotation.ApiMethod;
import com.base.cache.CacheSupport;
import com.base.cache.CacheUtil;
import com.base.util.DateUtil;
import com.base.web.ParameterRequestWrapper;
import com.item.dao.model.MobileVerify;
import com.item.service.MobileVerifyService;

/**
 * 权限(Token)验证
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private MobileVerifyService mobileVerifyService;
    
    private static final int NICK_LENGTH = 30;
    
    private static final String TOKEN = "token";
    public static final String USER_ID = "userid";
    private static final String DEVICE_ID = "deviceid";
    private static final String DEVICE_TYPE = "deviceType";
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //支持跨域请求
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,X-Nideshop-Token,X-URL-PATH");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

        if(handler instanceof HandlerMethod) {
        	ApiMethod annotation = ((HandlerMethod) handler).getMethodAnnotation(ApiMethod.class);
            if (annotation == null) return true;
            
        	//从header中获取token
            String token = request.getHeader(TOKEN);
            //如果header中不存在token，则从参数中获取token
            if(StringUtils.isBlank(token)){
                token = request.getParameter(TOKEN);
            }
            
            String nickName = request.getParameter("nickName");
            if (StringUtils.isNotBlank(nickName)){
            	if (nickName.length() > NICK_LENGTH){
            		throw new ApiException(MEnumError.NICK_LEN_ERROR);
            	}
            }
            
            //分页
            if (annotation.isPage()){
            	String p = request.getParameter(Const.PAGE);
            	String l = request.getParameter(Const.LIMIT);
            	if (StringUtils.isBlank(p) || StringUtils.isBlank(l)){
            		throw new ApiException(MErrorEnum.PAGE_LIMIT_NONG);
            	}
            }
            
            MobileVerify mobileVerify = null;
            
            if (StringUtils.isNotBlank(token)){
                mobileVerify = mobileVerifyService.queryByToken(token);
            }

            //登陆
            if(annotation.isLogin()){
                if(mobileVerify == null || (mobileVerify.getExpireTime() != null && mobileVerify.getExpireTime().getTime() < System.currentTimeMillis())){
            		throw new ApiException(MErrorEnum.LOGIN_FAIL_ERROR);
                }
            }
            
            if (mobileVerify != null){
        		if(mobileVerify.getExpireTime() != null){
            		Date date = new Date();
            		mobileVerify.setExpireTime(DateUtil.addHour(date, 12000));
            		mobileVerify.setUpdateTime(date);
            		mobileVerifyService.updateByPrimaryKey(mobileVerify);
            	}

        		ParameterRequestWrapper wrapper =  (ParameterRequestWrapper) request;
                request.setAttribute(USER_ID, mobileVerify.getUserId());
            	wrapper.addParameter(USER_ID, mobileVerify.getUserId());
            	wrapper.addParameter(DEVICE_ID, mobileVerify.getDeviceId());
            	wrapper.addParameter(DEVICE_TYPE, mobileVerify.getDeviceType());
            	wrapper.addParameter(TOKEN, token);
        	}
           
        }
        return true;
    }
    
}
