package com.itour.etip.security.intercept.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itour.etip.pub.frame.SpringContextHelper;

@WebService
public class AuthenticationService {
	
	public boolean authentication(@WebParam(name="username")String username ,@WebParam(name="password")String password,@WebParam(name="url")String url){
		if (username == null || "".equals(username) || password == null || "".equals(password) || url == null || "".equals(url)){
			return false;
		}
		WebServiceSecurityInterceptor wsi = (WebServiceSecurityInterceptor) SpringContextHelper.getBean("webServiceSecurityInterceptor");
		return wsi.invoke(username,password,url);
	}

}
