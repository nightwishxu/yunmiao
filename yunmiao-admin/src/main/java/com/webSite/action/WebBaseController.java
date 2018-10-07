package com.webSite.action;

import com.base.CoreConstants;
import com.base.api.ApiException;
import com.base.api.IMError;
import com.base.dao.model.Ret;
import com.base.util.JSONUtils;
import com.base.util.RequestUtils;
import com.base.util.ResponseUtils;
import com.base.web.annotation.LoginMethod;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class WebBaseController {

	private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected static final String BASE_PATH = "website";

	@ExceptionHandler({ApiException.class})
	@ResponseBody
	public void handleExceptionOk(Exception ex, HttpServletRequest request, HttpServletResponse response) throws IOException {
		Ret ret;
		ApiException se = (ApiException)ex;
		ret = new Ret(se.getCode(), se.getError().getErrorMsg());
		ResponseUtils.renderJson(response, ret);
	}

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        dateFormat.setLenient(false);  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    } 
	public Object getSessionParameter(String name) {
		Object obj = RequestUtils.getRequest().getSession().getAttribute(LoginMethod.WEB.getName());
		if (obj != null) {
			HashMap<String, Object> map = (HashMap<String, Object>) obj;
			return map.get(name);
		}
		return "";
	}
	public void setSessionParameter(String name, Object value) {
		Object obj = RequestUtils.getRequest().getSession().getAttribute(LoginMethod.WEB.getName());
		if (obj != null) {
			HashMap<String, Object> map = (HashMap<String, Object>) obj;
			map.put(name, value);
		}
	}

	protected String getUrl(String fileid) {
		return getUrl(fileid, null, null);
	}

	protected String getUrl(String fileid, Integer width, Integer height) {
		if (StringUtils.isNotBlank(fileid)) {
			String url = CoreConstants.SERVER_URL + "download?id=" + fileid;
			if (width != null)
				url += "&w=" + width;
			if (height != null)
				url += "&h=" + height;
			return url;
		} else {
			return "";
		}
	}

	protected String getPage(String id, Integer type) {
		return CoreConstants.SERVER_URL + "detail?id=" + id + "&type=" + type;
	}

	protected String ok(){
		return JSONUtils.serialize(new Ret());
	}

	protected String ok(Object data){
		return GSON.toJson(new Ret(0,data));
	}

	protected String msg(int code, String msg){
		return JSONUtils.serialize(new Ret(code,msg));
	}

	protected String msg(String msg){
		return JSONUtils.serialize(msg(0, msg));
	}

	protected String msg(IMError error){
		return msg(error.getErrorCode(),error.getErrorMsg());
	}
}
