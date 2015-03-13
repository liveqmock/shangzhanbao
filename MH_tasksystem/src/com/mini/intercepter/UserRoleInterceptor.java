/********************************************************
 Copyright (C), 2009-2010, eTIP.
 File name:    com/itour/etip/kit/convert/JsonConversionInterceptor.java
 Description:  JSON拦截器
 Author: TengXiaocong      Version:  1.0.0  Date: 2009.4.14
 ***********************************************************/
package com.mini.intercepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class UserRoleInterceptor implements Interceptor {

	/**
	 * @author 何大勇
	 * @date 2013-9-23
	 * @update
	 */
	private static final long serialVersionUID = 4923768264555390387L;

	public String intercept(ActionInvocation actionInvocation) throws Exception {
//		FrmAction action = (FrmAction) actionInvocation.getAction();
//		HttpServletRequest request = action.getRequest();
//		HttpSession session = request.getSession();
//		FrmUser frmUser = action.getFrmUser();
		
//		if(frmUser.roles.indexOf("订单")){
//			
//		}
		
		String result = actionInvocation.invoke();
		return result;
	}



	public void destroy() {
	}

	public void init() {
	}

}
