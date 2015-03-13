package com.itour.etip.pub.kit.cache;

import java.util.TreeMap;

/**
 * 无分布式支持的数据库缓冲区。
 * 
 * @author lishan
 * 
 */
public class DBLocalCache extends DBCache {

	/**
	 * 添加缓冲区对象
	 */
	public void addDBCache(String cacheName, TreeMap tableMap) {
		cacheInstance.put(cacheName, tableMap);
	}

	/**
	 * 添加数据到缓冲区对象
	 */
	public void addRecordToDBCache(String cacheName, String key, TreeMap dbData) {
		TreeMap map = getDBCache(cacheName);
		map.put(key, dbData);
	}

	/**
	 * 获得缓冲区对象
	 */
	public TreeMap getDBCache(String cacheName) {
		TreeMap rv = (TreeMap) cacheInstance.get(cacheName);
		return rv;
	}

	/**
	 * 从缓冲区中清除对象
	 */
	public void removeRecordFromDBCache(String cacheName, String key) {
		TreeMap cacheMap = CacheUtil.getInstance().dbCache.getDBCache(cacheName);
		cacheMap.remove(key);
	}

}
