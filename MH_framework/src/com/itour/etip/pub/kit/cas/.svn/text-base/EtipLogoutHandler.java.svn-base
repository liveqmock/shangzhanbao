package com.itour.etip.pub.kit.cas;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.Authentication;
import org.springframework.security.ui.logout.LogoutHandler;

public class EtipLogoutHandler implements LogoutHandler{

	public void logout(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2) {
		// TODO Auto-generated method stub
		Cookie removeCookie = new Cookie("etipUserName",null);
		removeCookie.setPath("/");
		removeCookie.setMaxAge(0);
		arg1.addCookie(removeCookie);
	}

}
