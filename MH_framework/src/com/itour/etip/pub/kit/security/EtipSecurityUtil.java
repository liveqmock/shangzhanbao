package com.itour.etip.pub.kit.security;

import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.User;

public class EtipSecurityUtil {
	
	/**
	 * 取登录用户的username或者叫userid。
	 * @return 如果未登录返回null
	 */
	public static String getUserName(){
	  	SecurityContext ctx = SecurityContextHolder.getContext();
	  	if(ctx == null){
	  		return null;
	  	}
	  	Authentication auth = ctx.getAuthentication();
	  	if(auth == null){
	  		return null;
	  	}
  		if(auth.getPrincipal() instanceof User){
  			User user = (User)auth.getPrincipal();
  			return user.getUsername();
  		}
	  	return null;
	 }

	/**
	 * 读取权限列表
	 * @return 返回String，如果有多个角色，则用","隔开
	 */
	public static String getUserRole(){
	  	SecurityContext ctx = SecurityContextHolder.getContext();
	  	Authentication auth = ctx.getAuthentication();
	  	if(auth != null){
	  		if(auth.getPrincipal() instanceof User){
	  			User user = (User)auth.getPrincipal();
	  			GrantedAuthority gauth[] = user.getAuthorities();
	  			StringBuffer buf = new StringBuffer();
	  			for(int i=0;i<gauth.length;i++){
	  				 buf.append(gauth[i].getAuthority());
	  				 if(i!=gauth.length-1){
	  					 buf.append(",");
	  				 }
	  			}
	  			return buf.toString();
	  		}
	  	}
	  	return null;
	 }

	/**
	 * 读取权限列表
	 * @return 返回String数组
	 */
	public static String [] getUserRoleAsArray(){
	  	SecurityContext ctx = SecurityContextHolder.getContext();
	  	Authentication auth = ctx.getAuthentication();
	  	if(auth != null){
	  		if(auth.getPrincipal() instanceof User){
	  			User user = (User)auth.getPrincipal();
	  			GrantedAuthority gauth[] = user.getAuthorities();
	  			String a[] = new String[gauth.length];
	  			for(int i=0;i<a.length;i++){
	  				a[i] = gauth[i].getAuthority();
	  			}
	  			return a;
	  		}
	  	}
	  	return null;
	 }
}
