package com.mini.filter;

import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itour.etip.pub.kit.convert.ParameterRequestWrapper;

import net.sf.ehcache.constructs.web.filter.Filter;


/**
 * @author 何大勇
 * @date 2013-9-26
 */
public class ParametersMappingFilter extends Filter {

	@Override
	protected void doDestroy() {
		
	}

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain) throws Throwable {
		//从session中获取当前目标跳转地址
		String targetURL = (String) request.getSession().getAttribute("targetURL");
		String uri = request.getRequestURI();
		ParameterRequestWrapper parameterRequestWrapper = new ParameterRequestWrapper(request);
		if(targetURL!=null && targetURL.equals(uri)){
			Map<String, Object> map = (Map<String, Object>) request.getSession().getAttribute("targetReqParam");
			request.getSession().removeAttribute("targetReqParam");
			request.getSession().removeAttribute("targetURL");
			parameterRequestWrapper.addAllParameters(map);
		}
		chain.doFilter(parameterRequestWrapper, response);
	}

	@Override
	protected void doInit(FilterConfig arg0) throws Exception {
	}


}
