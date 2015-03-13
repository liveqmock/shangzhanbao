package com.itour.etip.pub.ldap;

import com.unboundid.ldap.sdk.BindRequest;
import com.unboundid.ldap.sdk.CRAMMD5BindRequest;
import com.unboundid.ldap.sdk.DIGESTMD5BindRequest;
import com.unboundid.ldap.sdk.PLAINBindRequest;
import com.unboundid.ldap.sdk.SimpleBindRequest;

public abstract class LDAPHelper {
	/**
	 * The authentication type value that will be used to indicate that simple
	 * authentication should be performed.
	 */
	private static final int AUTH_TYPE_SIMPLE = 0;

	/**
	 * The authentication type value that will be used to indicate that CRAM-MD5
	 * authentication should be performed.
	 */
	private static final int AUTH_TYPE_CRAM_MD5 = 1;

	/**
	 * The authentication type value that will be used to indicate that
	 * DIGEST-MD5 authentication should be performed.
	 */
	private static final int AUTH_TYPE_DIGEST_MD5 = 2;

	/**
	 * The authentication type value that will be used to indicate that PLAIN
	 * authentication should be performed.
	 */
	private static final int AUTH_TYPE_PLAIN = 3;

	public static int getAuthenticationType() {
		return ManagerRuntimeConfig.getIntProperty("ldap.authentication.type");
	}

	public static String getBaseDN() {
		return ManagerRuntimeConfig.getProperty("ldap.suffix");
	}

	public static String getUserDN(String user) {
		return ManagerRuntimeConfig.getProperty("ldap.user.dn") + "=" + user + "," + getBaseDN();
	}

	public static String getUserMailAttribute() {
		return ManagerRuntimeConfig.getProperty("ldap.user.mail");
	}

	public static String getUserNameAttribute() {
		return ManagerRuntimeConfig.getProperty("ldap.user.name");
	}

	public static String getPasswordAttribute() {
		return ManagerRuntimeConfig.getProperty("ldap.user.password");
	}

	public static String getAccountAttribute() {
		return ManagerRuntimeConfig.getProperty("ldap.user.account");
	}

	/**
	 * 获取域用户名，即在普通用户名后加上域名
	 * @param user
	 * @return
	 */
	public static String getLDAPUserName(String user){
		String suffix=ManagerRuntimeConfig.getProperty("ldap.account.suffix");
		if (user.endsWith(suffix)){//判断是否为域用户名登录
			return user;
//			return user.substring(0,user.indexOf(suffix));
		}else{
			return new StringBuffer(user).append(suffix).toString();
		}
	}
	
	/**
	 * 解析域用户名成普通用户名
	 * @param ldapUser
	 * @return
	 */
	public static String getUserNameFromLDAPUserName(String ldapUser){
		String suffix=ManagerRuntimeConfig.getProperty("ldap.account.suffix");
		if(ldapUser.endsWith(suffix)){
			return ldapUser.substring(0,ldapUser.indexOf(suffix));
		}else{
			return ldapUser;
		}
	}
	
	public static String extraPasswordAndAlgorithm(String password) {
		if (password==null||password.equals("")) {
			return null;
		}

		if (password.startsWith("{")) {
			return password.substring(password.indexOf("}") + 1);
		}
		return password;
	}

	/**
	 * 认证请求
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	public static BindRequest getBindRequest(String user, String password) {
		String dn = getUserDN(user);
		BindRequest bindRequest = null;
		switch (getAuthenticationType()) {
		case AUTH_TYPE_SIMPLE:
			bindRequest = new SimpleBindRequest(user, password);
			break;
		case AUTH_TYPE_CRAM_MD5:
			bindRequest = new CRAMMD5BindRequest("dn:" + dn, password);
			break;
		case AUTH_TYPE_DIGEST_MD5:
			bindRequest = new DIGESTMD5BindRequest("dn:" + dn, password);
			break;
		case AUTH_TYPE_PLAIN:
			bindRequest = new PLAINBindRequest("dn:" + dn, password);
			break;
		}
		return bindRequest;
	}
}
