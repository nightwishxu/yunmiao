package com.base.api.base;

import com.base.ConstantsCode;
import com.base.api.annotation.ApiMethod;
import com.util.PaidangSecureUtil;
import com.base.crypto.SecureUtil;
import com.base.crypto.symmetric.DES;
import com.base.dao.model.Result;
import com.base.util.JSONUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.spring.web.json.Json;

@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object>{

	@Override
	public boolean supports(MethodParameter returnType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		ApiMethod api = returnType.getMethod().getAnnotation(ApiMethod.class);
		if (api != null){
			return true;
		}
		return true;

	}

	@Override
	public Object beforeBodyWrite(Object body,
			MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {
		ApiMethod api = returnType.getMethod().getAnnotation(ApiMethod.class);
		if (api != null){
			Result<Object> ret = new Result<>(body);
			if (ConstantsCode.DEBUG || isAjax(request)){
				return JSONUtils.serialize(ret);
			}else{
				return PaidangSecureUtil.encrypt(JSONUtils.serialize(ret));
			}
		}else if (body.getClass().equals(String.class)) {
			return body;
		}else if (body.getClass().equals(Json.class)){
			return body;
		}else {
			return JSONUtils.serialize(body);
		}
	}


	private boolean isAjax(ServerHttpRequest req){
		HttpHeaders httpHeaders = req.getHeaders();
		boolean isAjax = false;
		if (httpHeaders.containsKey("x-requested-with")){
			if (httpHeaders.get("x-requested-with").get(0).equals("XMLHttpRequest")){
				isAjax = true;
			}
		}
		return ConstantsCode.AJAX_DEBUG&&isAjax;
	}

}
