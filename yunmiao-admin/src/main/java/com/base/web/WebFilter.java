package com.base.web;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.security.util.UserUtils;
import com.base.spring.SpringContextUtil;
import com.base.support.PropertySupport;
import com.base.util.ClassUtil;
import com.base.util.ClassUtils;
import com.base.util.PattenUtil;
import com.base.util.RequestUtils;
import com.base.web.annotation.LoginFilter;

public class WebFilter implements Filter {
	private Logger logger = Logger.getLogger(WebFilter.class);

	public static final Boolean SESSION_ENABLE = Boolean.valueOf("true".equals(PropertySupport.getProperty("session.enable", "false")));
	public static final String SESSION_METHOD = PropertySupport.getProperty("session.method");

	// 保存接口方法注解
	private Map<String, LoginFilter> webMethodAnnoMap = new HashMap<String, LoginFilter>();

	private Set<String> exclude;

	public void initParams() {
		try {
			// 获取所有的controller类
			Map mobileClz = SpringContextUtil.getBeansWithAnnotation(Controller.class);
			mobileClz = ClassUtil.getClassesByAnnotation(Controller.class);
			if (mobileClz != null) {

				// 遍历所有接口类
				for (Iterator localIterator = mobileClz.values().iterator(); localIterator.hasNext();) {
					Object clzObj = localIterator.next();
					StringBuffer parent = new StringBuffer();
					RequestMapping controller = clzObj.getClass().getAnnotation(RequestMapping.class);
					LoginFilter web = clzObj.getClass().getAnnotation(LoginFilter.class);

					if (controller != null) {
						String[] parentValue = controller.value();
						if (parentValue != null && parentValue.length > 0) {
							parent.append(parentValue[0]);
							if (parent.indexOf("/") == 0) {
								parent.deleteCharAt(0);
							}
							if (web != null) {
								webMethodAnnoMap.put("/" + parent + "/", web);
								continue;
							}
						}
					}
					parent.append("/");
					if (parent.indexOf("/") != 0) {
						parent.insert(0, "/");
					}
					// 获取类所有接口方法
					List<Method> methodList = ClassUtils.getClassMethodByAnnotation(clzObj.getClass(), LoginFilter.class);

					// 遍历所有接口方法
					for (Method method : methodList) {
						LoginFilter methodAnno = method.getAnnotation(LoginFilter.class);
						RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
						String[] requestValue = requestMapping.value();

						if (requestValue == null || requestValue.length == 0) {
							continue;
						}

						String methodname = requestValue[0];

						if (StringUtils.isBlank(methodname)) {
							continue;
						}

						StringBuffer sb = new StringBuffer(parent);
						for (String str : methodname.split("/")) {
							if (str.equals("")) {
								continue;
							} else if (str.indexOf("{") == -1) {
								sb.append(str + "/");
							} else {
								sb.append(".*/");
							}
						}

						String methodName = sb.substring(0, sb.length() - 1);
						webMethodAnnoMap.put(methodName, methodAnno);
					}
				}
			}
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		RequestUtils.setRequest(request);
		HttpServletResponse response = (HttpServletResponse) rsp;
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ (request.getServerPort() == 80 ? "" : ":" + request.getServerPort()) + request.getContextPath() + "/";
		String url = request.getRequestURL().toString();
		if (isEnd(url)) {
			chain.doFilter(req, rsp);
			return;
		}

		url += "/";
		
		boolean login = false;

		LoginFilter method = null;
		for (String rep : this.webMethodAnnoMap.keySet()) {
			String tempRep = basePath.substring(0, basePath.length() - 1) + rep;
			Pattern pattern = Pattern.compile(tempRep);
			Matcher matcher = pattern.matcher(url);
			if (matcher.find()) {
				login = true;
				method = webMethodAnnoMap.get(rep);
				break;
			}
		}
		
		Session session = UserUtils.getSession();
		if(SESSION_ENABLE && session.getAttribute("autoLogin") == null){
			String mPath = request.getRequestURI().replace(request.getContextPath(), "");
			if(mPath.startsWith("/m/")){
				if (StringUtils.isNotBlank(SESSION_METHOD)) {
					Map<String, Object> serviceParam = new HashMap<String, Object>();
					serviceParam.put("request", request);
					serviceParam.put("response", response);
					try {
						ClassUtils.invokeMethod(SESSION_METHOD.split("\\.")[0], SESSION_METHOD.split("\\.")[1], serviceParam);
						session.setAttribute("autoLogin", true);
					} catch (Exception e) {
						logger.error("未正确定义session.method,CLASS.METHOD");
						e.printStackTrace();
					}
				} else {
					logger.info("未定义session.method");
				}
			}
		}

		if (!login) {
			chain.doFilter(req, rsp);
			return;
		}

		if (session != null) {
			Object obj = session.getAttribute(method.value().getName());
			if (obj != null) {
				chain.doFilter(req, rsp);
				return;
			}
		}

		String temp = PropertySupport.getProperty(method.value().getName(), "");

		// 如果是ajax请求响应头会有，x-requested-with
		if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
			// 在响应头设置session状态
			response.setStatus(500);
			response.setHeader("sessionstatus", "sessionOut");
			response.getWriter().print("sessionOut");
		} else {
			if (!temp.equals("")) {
				response.sendRedirect(basePath + temp);
			} else {
				String toUrl = method.value().getUrl();
				if (toUrl.indexOf("/") == 0)
					toUrl = toUrl.substring(1);
				response.sendRedirect(basePath + toUrl);
			}
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		initParams();
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
}
