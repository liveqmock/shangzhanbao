package com.itour.etip.pub.kit.cas;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.Authentication;
import org.springframework.security.ui.rememberme.NullRememberMeServices;

public class EtipRememberMeService extends NullRememberMeServices{
	
	private String cookiePath;
	

	public String getCookiePath() {
		return cookiePath;
	}


	public void setCookiePath(String cookiePath) {
		this.cookiePath = cookiePath;
	}


	public void loginSuccess(HttpServletRequest request, HttpServletResponse response,
		        Authentication successfulAuthentication) {
		 Cookie cookie = new Cookie("etipUserName",URLEncoder.encode(successfulAuthentication.getName()));
		 if(cookiePath!=null && !("".equals(cookiePath))){
			 cookie.setPath("/");
		 }
		 cookie.setMaxAge(-1);
		 response.addCookie(cookie);
	 }

}
