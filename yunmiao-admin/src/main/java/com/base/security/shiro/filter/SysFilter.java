package com.base.security.shiro.filter;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.base.dao.model.Ret;
import com.base.util.ResponseUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.base.security.shiro.Principal;
import com.base.security.util.UserUtils;
import com.item.dao.model.Right;
import com.item.util.RoleUtil;

/**
 * go拦截
 * @author sun
 */
public class SysFilter extends PathMatchingFilter{
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response)
			throws Exception {
		ShiroHttpServletRequest servletRequest = (ShiroHttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		String servletPath =  servletRequest.getServletPath();
		if ("/go".equals(servletPath)){
			String path = servletRequest.getQueryString().substring(5);
			if (logger.isDebugEnabled()) {
				logger.debug("请求路径 = " + path);
			}
			Principal principal = UserUtils.getPrincipal();
			if (principal == null){
//				ResponseUtils.renderJson(servletResponse,"sessionOut");
				//权限验证失败
				String basePath = servletRequest.getScheme() + "://" + servletRequest.getServerName()
						+ (servletRequest.getServerPort() == 80 ? "" : ":" + servletRequest.getServerPort()) + servletRequest.getContextPath() + "/";
				servletResponse.sendRedirect(basePath+"manager");
				return false;
			}
			//是否在主菜单内
			boolean isUrl = RoleUtil.isUrl(path);
			if (isUrl){
				boolean result = validateRight(path, principal.getRights());
				if (!result){
//					ResponseUtils.renderJson(servletResponse, new Ret(401, "权限不足，无法访问"));
					//权限验证失败
					return false;
				}	
			}
		}
		return true;
	}
	
	/*@Override
	protected void postHandle(ServletRequest request, ServletResponse response)
			throws Exception {
		ShiroHttpServletRequest servletRequest = (ShiroHttpServletRequest) request;
		String servletPath =  servletRequest.getServletPath();
		if ("/go".equals(servletPath)){
			String path = servletRequest.getParameter("path");
			Principal principal = UserUtils.getPrincipal();
			boolean result = validateRight(path, principal.getRights());
			if (!result){
				//权限验证失败
				return;
			}	
		}
		super.postHandle(request, response);
	}*/
	
	private boolean validateRight(String path, List<Right> list){
		for (Right right : list){
			if (path.equals(right.getUrl())){
				return true;
			}
		}
		return false;
	}
}
