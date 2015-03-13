package com.itour.etip.pub.ldap;


import javax.jcr.LoginException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.unboundid.ldap.sdk.BindResult;
import com.unboundid.ldap.sdk.Filter;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ReadOnlySearchRequest;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;

/**
 * LDAP 认证工具类
 * 
 * @author yy
 * 
 */
public class LDAPAuthenticateHelper extends LDAPHelper {
	
	private static final Log log = LogFactory.getLog(LDAPAuthenticateHelper.class);

	private SearchResultEntry entry = null;
	
	public SearchResultEntry getEntry() {
		return entry;
	}

	public void setEntry(SearchResultEntry entry) {
		this.entry = entry;
	}

	/**
	 * 用户认证
	 * 
	 * @param user
	 * @param password
	 * @throws LDAPException 
	 * @throws LoginException
	 * @return String 1.成功，2.有新用户，0.失败
	 */
	public String authorizate(String user, String password, boolean newUser) throws LDAPException {
		LDAPProvider provider = new LDAPProvider();
		if (provider == null) {
			/*** 重新进行LDAP连接 **/
			provider = new LDAPProvider();
			if (provider == null) {
				//认证失败，写入日志
				System.out.println("认证失败了哈~~~");
			}
		}
		LDAPConnection connection = null;
		String checkStatus = "1";
		try {
			connection = provider.getConnection();
			BindResult br = connection.bind(getLDAPUserName(user)/*user*/, password);
			log.debug("LDAP Authenticate User:" + user);
			/** 验证成功 **/
			if (br.getResultCode() == ResultCode.SUCCESS) {
				log.debug("LDAP Authenticate User[" + user + "] success.");
				/** 新的LDAP用户登录本系统 **/
				if (newUser) {
					/** 需要完成用户数据映射 **/
					ReadOnlySearchRequest searchRequest = new SearchRequest(getBaseDN(), SearchScope.SUB, Filter
							.create("(mail=" + getLDAPUserName(user) + ")"));
					SearchResult result = connection.search(searchRequest);
					SearchResultEntry entry = result.getSearchEntries().get(0);
					setEntry(entry);
					checkStatus = "2";
				}
			} else {
				/** LDAP验证失败 **/
				checkStatus = "0";
			}
		} catch (LDAPException e) {
			checkStatus = "0";
			log.debug("LDAP Authenticate User[" + user + "] error:" + e.getExceptionMessage());
			if (e.getResultCode() == ResultCode.INVALID_CREDENTIALS) {
				/** LDAP验证失败 **/
				log.info("LDAP验证失败:ResultCode");
				return checkStatus;
			} else {
				/** LDAP验证失败 **/
				log.info("LDAP验证失败:Other");
				return checkStatus;
			}
		} catch (Exception ex) {
			log.error("synchronize user with LDAP ERROR:", ex);
		} finally {
			if (connection != null) {
				connection.close();
			}
			provider = null;
		}
		return checkStatus;
	}
	
}
