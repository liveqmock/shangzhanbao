package com.itour.etip.pub.kit.cache;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * 利用开源项目danga.MemCached管理缓存，实现分布式缓存支持。
 * 在调试时使用了memcached-1.2.6-win32-binary安装，在部署时需要build linux版本部署。 服务器默认端口是11211
 * 服务器地址要求在para.xml中配置
 * 
 * @author lishan
 * 
 */
public class MemCacheManager {

	// 创建全局的唯一实例
	protected static MemCachedClient mcc = null;

	protected static MemCacheManager memCacheManager = null;

	/**
	 * 保护型构造方法，不允许实例化！
	 * 
	 */
	protected MemCacheManager() {

	}

	/**
	 * 获取唯一实例.
	 * 
	 * @return
	 */
	public static MemCacheManager getInstance() {
		// 设置与缓存服务器的连接池
		if (memCacheManager == null) {
				
			// 获取socke连接池的实例对象
			SockIOPool pool = SockIOPool.getInstance();
			String server = CacheUtil.paraCache.getParaValue("MemCacheServer");
			String port = CacheUtil.paraCache.getParaValue("MemCachePort");
			String[] servers = { server+":"+port};
			// 设置服务器信息
			pool.setServers(servers);
			//	与服务器列表中对应的各服务器的权重,权重高的负载大
			Integer[] weights = { 3 };
			pool.setWeights(weights);

			// 设置初始连接数、最小和最大连接数以及最大处理时间
			pool.setInitConn(5);
			pool.setMinConn(5);
			pool.setMaxConn(250);
			pool.setMaxIdle(1000 * 60 * 60 * 6);

			// 设置主线程的睡眠时间
			pool.setMaintSleep(30);

			// 设置TCP的参数，连接超时等
			pool.setNagle(false);
			pool.setSocketTO(3000);
			pool.setSocketConnectTO(0);
			
			// 初始化连接池
			pool.initialize();
			// 压缩设置，超过指定大小（单位为K）的数据都会被压缩
			MemCachedClient mcc = new MemCachedClient();
			mcc.setCompressEnable(true);
			mcc.setCompressThreshold(64 * 1024);
			memCacheManager = new MemCacheManager();
			memCacheManager.mcc = mcc;
		}

		return memCacheManager;
	}

	/**
	 * 添加一个指定的值到缓存中.
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean put(String key, Object value) {
		return mcc.add(key, value);
	}

	public boolean put(String key, Object value, Date expiry) {
		return mcc.add(key, value, expiry);
	}

	public boolean replace(String key, Object value) {
		return mcc.replace(key, value);
	}

	public boolean replace(String key, Object value, Date expiry) {
		return mcc.replace(key, value, expiry);
	}

	/**
	 * 根据指定的关键字获取对象.
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		Object rv=  mcc.get(key);
		
		return rv;
	}

	
}
