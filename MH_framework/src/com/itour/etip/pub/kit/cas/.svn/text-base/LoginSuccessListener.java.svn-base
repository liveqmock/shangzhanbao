package com.itour.etip.pub.kit.cas;

import java.util.HashMap;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.Authentication;
import org.springframework.security.event.authentication.AuthenticationSuccessEvent;
import org.springframework.security.event.authorization.AuthenticationCredentialsNotFoundEvent;
import org.springframework.security.event.authorization.PublicInvocationEvent;
import org.springframework.security.ui.session.HttpSessionDestroyedEvent;

import com.itour.etip.pub.frame.FrmUser;

/**
 * 用户登录监听器。
 * 
 * @author lishan
 * 
 */
public class LoginSuccessListener implements ApplicationListener {
	/**
	 * 保存当前所有的在线用户。
	 */
	private static HashMap onlineUsers = new HashMap();

	/**
	 * 返回当前系统在线人数。
	 * 
	 * @return
	 */
	public static int getCount() {
		return onlineUsers.size();
	}

	
	
	/**
	 * 判断某个用户是否在线。
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean isOnline(String userId) {
		return onlineUsers.containsKey(userId);
	}

	/**
	 * 将用户踢出系统。
	 * 
	 * @param userId
	 * @return
	 */
	public void kickoffUser(String userId) {
		onlineUsers.remove(userId);
		
	}

	/**
	 * 返回当前的所有在线用户数
	 * 
	 * @return
	 */
	public static HashMap getOnlineUsers() {
		return onlineUsers;
	}

	public void onApplicationEvent(ApplicationEvent event) {
		// 登录成功的监听器，登录成功后，二次登录初始化用户身份数据，放入到session中。
		if (event instanceof AuthenticationSuccessEvent) {
			AuthenticationSuccessEvent aEvent = (AuthenticationSuccessEvent) event;
			Authentication auth = aEvent.getAuthentication();
			Object principal = auth.getPrincipal();
			if (principal instanceof FrmUser) {
				FrmUser user = (FrmUser) principal;
				//此处构造GroupUserData来完成
				onlineUsers.put(user.etipUserID, user);
				//System.out.println("onlineUsers:"+onlineUsers.size());
			} 
		}
		//logout时，系统将暴露该事件。
		else if (event instanceof AuthenticationCredentialsNotFoundEvent) {
			//session,创建成功，暂时不做处理。
			//System.out.println("logout:"+FrmUser.getUser());
			
		} else if (event instanceof HttpSessionDestroyedEvent) {
			//System.out.println("sessionDestroyed:"+FrmUser.getUser().etipUserID);
			String etipUserID= null;
			try{
			etipUserID=FrmUser.getUser().etipUserID;
			onlineUsers.remove(FrmUser.getUser().etipUserID);
			}catch(Exception ex){
				
			}
			//System.out.println("after logout,onlineUsers:"+onlineUsers.size());
		} 
		else {
			if (!(event instanceof PublicInvocationEvent)) {
				//System.out.println("event:" + event.getClass().getSimpleName());
			}
		}

	}
}