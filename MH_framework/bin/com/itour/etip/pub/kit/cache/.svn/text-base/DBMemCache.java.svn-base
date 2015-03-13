package com.itour.etip.pub.kit.cache;

import java.util.TreeMap;

/**
 * 分布式缓冲区MemCache。
 * 
 * @author lishan
 */
public class DBMemCache extends DBCache {

	/**
	 * 添加缓冲区对象
	 * 
	 * @cacheName 缓冲区名称
	 * @tableMap 缓冲区实例
	 */
	public void addDBCache(String cacheName, TreeMap tableMap) {
		MemCacheManager.getInstance().put(cacheName, tableMap);
	}

	/**
	 * 添加数据岛缓冲区对象中。
	 * 
	 * @param cacheName
	 * @param key
	 * @param dbData
	 */
	public void addRecordToDBCache(String cacheName, String key, TreeMap dbData) {
		// 取得缓冲区对象
		TreeMap map = getDBCache(cacheName);
		map.put(key, dbData);
		MemCacheManager.getInstance().replace(cacheName, map);
	}

	/**
	 * 获取缓冲区实例
	 * 
	 * @param tableName
	 * @return
	 */
	public TreeMap getDBCache(String cacheName) {
		Object rv = MemCacheManager.getInstance().get(cacheName);
		return (TreeMap)rv;
	}

	public void removeRecordFromDBCache(String cacheName, String key) {

		TreeMap cacheMap = getDBCache(cacheName);
		cacheMap.remove(key);
		MemCacheManager.getInstance().replace(cacheName, cacheMap);

	}
}
