/**
 * 
 */
package com.itour.etip.pub.ldap;

import java.util.List;

import javax.jcr.LoginException;

import com.unboundid.ldap.sdk.Filter;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ReadOnlySearchRequest;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;

/**
 * 与LDAP进行数据同步工具类
 * 
 * @author yy
 * 
 */
public class LDAPSynchronizeHelper extends LDAPHelper {
	private static LDAPSynchronizeHelper me = new LDAPSynchronizeHelper();

	public static LDAPSynchronizeHelper getInstance() {
		return me;
	}

	/**
	 * 提供用户名和密码作为同步条件
	 * 
	 * @param user
	 * @param password
	 * @throws LDAPException 
	 * @throws ManagerException
	 */
	public void synchronize() throws LDAPException{
		synchronize(null, null);
	}

	/**
	 * 实现与LDAP数据同步。 为单向同步，即仅从根据LDAP数据来同步本地系统用户数据
	 * @return 
	 * @throws LDAPException 
	 * 
	 * @throws LoginException
	 */
	public List<SearchResultEntry> synchronize(String user, String password) throws LDAPException {
		/** 用户信息 **/
		LDAPProvider provider = new LDAPProvider();
		if (provider == null) {
			/*** 重新进行LDAP连接 **/
			provider = new LDAPProvider();
			if (provider == null) {
				//认证错误，写入日志
			}
		}
		LDAPConnection connection = null;
		try {
			connection = provider.getConnection();
			if (user!=null&&!user.isEmpty()) {
				String ldapAccount = user;
				connection.bind(getLDAPUserName(ldapAccount), password);
			}
			ReadOnlySearchRequest searchRequest = new SearchRequest(getBaseDN(), SearchScope.SUB, Filter.create("(objectClass=user)"));
			SearchResult result = connection.search(searchRequest);
			List<SearchResultEntry> entries = result.getSearchEntries();
			return entries;
		} catch (LDAPException e) {
			 e.printStackTrace();
			//throw new ManagerException(e.getResultCode().getName());
		} finally {
			if (connection != null) {
				connection.close();
			}

			provider = null;
		}
		return null;
	}

	
	
	public static void main(String[] args) {
		try {
			LDAPSynchronizeHelper ldapHelper = LDAPSynchronizeHelper.getInstance();
			ldapHelper.synchronize("guoshuanglai@chinacaec.com","123456");
		} catch (LDAPException e) {
			e.printStackTrace();
		}
		
	}
	
}
