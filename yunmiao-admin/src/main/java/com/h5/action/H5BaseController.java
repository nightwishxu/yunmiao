package com.h5.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.action.SysController;
import com.item.action.SystemController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alibaba.fastjson.JSONObject;
import com.base.util.JSONUtils;
import com.base.util.RequestUtils;
import com.base.util.ResponseUtils;
import com.base.web.annotation.LoginMethod;

public class H5BaseController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected static final String BASE_PATH = "h5";
	/**
	 * 异常控制，这便是异常细节可控，将来可用于支持国际化（异常信息国际化）
	 * @throws IOException 
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleException(Exception ex, HttpServletRequest request,HttpServletResponse response) throws IOException {
		logger.error(ex.getMessage(), ex);
		if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
			JSONObject obj = new JSONObject();
			obj.put("error", ex.getMessage());
			ResponseUtils.renderJson(response, obj);
			return null;
		}
		return "common/500";
	}
	@InitBinder  
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        dateFormat.setLenient(false);  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
    } 
	public String getSessionParameter(String name) {
		Object obj = RequestUtils.getRequest().getSession().getAttribute(LoginMethod.PHONE.getName());
		if (obj != null) {
			HashMap<String, String> map = (HashMap<String, String>) obj;
			return map.get(name);
		}
		return "";
	}
	public void setSessionParameter(String name, String value) {
		Object obj = RequestUtils.getRequest().getSession().getAttribute(LoginMethod.PHONE.getName());
		if (obj != null) {
			HashMap<String, String> map = (HashMap<String, String>) obj;
			map.put(name, value);
		}
	}

}
