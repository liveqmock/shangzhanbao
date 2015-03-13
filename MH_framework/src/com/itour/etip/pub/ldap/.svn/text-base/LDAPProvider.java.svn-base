package com.itour.etip.pub.ldap;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.unboundid.ldap.sdk.BindRequest;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPConnectionOptions;
import com.unboundid.ldap.sdk.LDAPConnectionPool;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.PostConnectProcessor;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.ldap.sdk.ServerSet;
import com.unboundid.ldap.sdk.SingleServerSet;
import com.unboundid.ldap.sdk.StartTLSPostConnectProcessor;
import com.unboundid.util.ssl.SSLUtil;
import com.unboundid.util.ssl.TrustAllTrustManager;

public class LDAPProvider {
	private static final Log log = LogFactory.getLog(LDAPProvider.class);
	private static LDAPConnectionPool CONNECTIONS_POOLS;

	/** 最小连接数 **/
	private static final int MIN_CONNECTIONS = 5;
	/** 最大连接数 **/
	private static final int MAX_CONNECTIONS = 15;

	private static BindRequest createBindRequest() throws LDAPException {
		return null;
	}

	/** LDAP代理是否启动 **/
	private AtomicBoolean PROXY_STARTED = new AtomicBoolean(false);
	private SSLContext startTLSContext;

	public LDAPProvider() throws LDAPException {
		System.out.println("启动LDAP认证服务...");
		startLDAPProxy();
		System.out.println("成功启动LDAP认证服务");
	}

	private ServerSet createServerSet() throws LDAPException {
		/** 地址 **/
		final String HOST = ManagerRuntimeConfig.getProperty("ladp.host");
		/** 端口 **/
		final int PORT = ManagerRuntimeConfig.getIntProperty("ldap.port");
		/** 是否启用SSL **/
		final boolean SSL_ENABLED = "ssl".equalsIgnoreCase(ManagerRuntimeConfig.getProperty("ldap.encryption.method"));
		final boolean TLS_ENABLED = "StartTLS".equalsIgnoreCase(ManagerRuntimeConfig
				.getProperty("ldap.encryption.method"));
		final SSLUtil sslUtil = createSSLUtil(SSL_ENABLED);
		SocketFactory socketFactory = null;
		if (SSL_ENABLED) {
			try {
				socketFactory = sslUtil.createSSLSocketFactory();
			} catch (GeneralSecurityException e) {
				log.error("sslUtil.createSSLSocketFactory() error:", e);
				throw new LDAPException(
						ResultCode.LOCAL_ERROR,
						"Unable to create the SSL socket factory to use for secure communication with the server:  {0}",
						e);
			}
		} else if (TLS_ENABLED) {
			try {
				startTLSContext = sslUtil.createSSLContext();
			} catch (Exception e) {
				throw new LDAPException(ResultCode.LOCAL_ERROR, "", e);
			}
		}

		return new SingleServerSet(HOST, PORT, socketFactory, getConnectionOptions());
	}

	private SSLUtil createSSLUtil(boolean sslEnabled) {

		if (sslEnabled) {
			return new SSLUtil(new TrustAllTrustManager());
		}

		return null;
	}

	/**
	 * 获取LDAP连接
	 * 
	 * @return
	 * @throws LDAPException
	 */
	public synchronized LDAPConnection getConnection() throws LDAPException {
		if (CONNECTIONS_POOLS == null || !PROXY_STARTED.get()) {
			startLDAPProxy();
		}
		if (CONNECTIONS_POOLS != null) {
			return CONNECTIONS_POOLS.getConnection();
		}

		return null;
	}

	/**
	 * LDAP连接属性
	 * 
	 * @return
	 */
	private LDAPConnectionOptions getConnectionOptions() {
		LDAPConnectionOptions options = new LDAPConnectionOptions();
		options.setAutoReconnect(true);
		options.setUseSynchronousMode(true);
		return options;
	}
	
	public synchronized void restartLDAPProxy() throws LDAPException{
		PROXY_STARTED.set(false);
		startLDAPProxy();
	}

	/**
	 * 启动LDAP代理。目的在于创建与LDAP连接的连接池
	 */
	private synchronized void startLDAPProxy() throws LDAPException {
		/** 已经启动 **/
		if (PROXY_STARTED.get()) {
			return;
		}
		final boolean TLS_ENABLED = "StartTLS".equalsIgnoreCase(ManagerRuntimeConfig
				.getProperty("ldap.encryption.method"));
		ServerSet serverSet = createServerSet();
		BindRequest bindRequest = createBindRequest();
		PostConnectProcessor postConnectProcessor = null;
		if (TLS_ENABLED) {
			postConnectProcessor = new StartTLSPostConnectProcessor(startTLSContext);
		}

		CONNECTIONS_POOLS = new LDAPConnectionPool(serverSet, bindRequest, MIN_CONNECTIONS, MAX_CONNECTIONS,
				postConnectProcessor);

		PROXY_STARTED.set(true);
	}
}
