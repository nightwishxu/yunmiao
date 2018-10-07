package com.base.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.base.util.PattenUtil;
import com.base.util.RequestUtils;

public class WebFilter implements Filter {
	private Logger logger = Logger.getLogger(WebFilter.class);

	private Set<String> exclude;

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		RequestUtils.setRequest(request);
		String url = request.getRequestURL().toString();
		if (isEnd(url)) {
			chain.doFilter(req, rsp);
			return;
		}
		ParameterRequestWrapper wrapper = new ParameterRequestWrapper(request);
		chain.doFilter(wrapper, rsp);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		String exclude = filterConfig.getInitParameter("exclude");
		if (exclude != null && exclude.trim().length() != 0) {
			this.exclude = new HashSet<String>(Arrays.asList(exclude.split("\\s*,\\s*")));
		}
	}

	private boolean isEnd(String url) {
		if (this.exclude == null)
			return false;

		for (String str : this.exclude) {
			if (PattenUtil.matches(str, url))
				return true;
		}

		return false;
	}
	
	private boolean isApi(String url,String base){
		if (url.indexOf(base+"api/") != -1){
			return true;
		}
		return false;
	}
}
