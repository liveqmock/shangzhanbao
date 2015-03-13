package com.itour.etip.common.util;

import java.util.TreeMap;

import com.itour.etip.pub.kit.cache.CacheUtil;

public class GeneraldicUtil {

	public static String getDBCacheValueByValue(String cacheName, String dicType, String returnCode, String valueCode, String value) {
		TreeMap cacheMap = CacheUtil.getInstance().getCacheMap(cacheName);
		Object[] keySet = cacheMap.keySet().toArray();

		for (int i = 0; i < keySet.length; i++) {
			try {
				if (value.equals(((TreeMap) cacheMap.get(keySet[i])).get(valueCode))) {
					if(dicType == null && dicType.isEmpty()){
						return ((TreeMap) cacheMap.get(keySet[i])).get(returnCode).toString();
					}else{
						if(dicType.equals(((TreeMap) cacheMap.get(keySet[i])).get("DICTYPE"))){
							return ((TreeMap) cacheMap.get(keySet[i])).get(returnCode).toString();
						}
					}
				}
			} catch (Exception ex) {
			}
		}

		return "";
	}
	public static String getDBCacheValueByValue(TreeMap cacheMap, String dicType, String returnCode, String valueCode, String value) {
		Object[] keySet = cacheMap.keySet().toArray();
		
		for (int i = 0; i < keySet.length; i++) {
			try {
				if (value.equals(((TreeMap) cacheMap.get(keySet[i])).get(valueCode))) {
					if(dicType == null && dicType.isEmpty()){
						return ((TreeMap) cacheMap.get(keySet[i])).get(returnCode).toString();
					}else{
						if(dicType.equals(((TreeMap) cacheMap.get(keySet[i])).get("DICTYPE"))){
							return ((TreeMap) cacheMap.get(keySet[i])).get(returnCode).toString();
						}
					}
				}
			} catch (Exception ex) {
			}
		}
		
		return "";
	}
}
