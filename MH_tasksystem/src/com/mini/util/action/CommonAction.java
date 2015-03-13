/**
 * com.gomai.common.action
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-1-17 		何大勇
 *
 * Copyright (c) 2013, gomai.
*/

package com.mini.util.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author   何大勇
 * @version  
 * @Date	 2013-1-17 下午05:30:08
 */
public class CommonAction implements SessionAware, ServletRequestAware,
ServletResponseAware {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String,Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		
		this.session = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		
		this.request = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
		
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
}

