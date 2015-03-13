package com.itour.etip.pub.kit.tool;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.itour.etip.pub.kit.cache.CacheUtil;

/**
 * 
 * @author yangcan
 *
 */
public class CacheTool {

	private static CacheTool instance = null;

	private CacheTool() {

	}

	public static CacheTool getInstance() {
		if (instance == null) {
			instance = new CacheTool();
		}

		return instance;
	}
	
	/**
	 * 根据code取name
	 * @param type 是从DB中取还是从cache里面取
	 * @param cacheName 
	 * @param code
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public static String getNameByCode(String type,String cacheName,String code){
		try{
			TreeMap brandMap = CacheUtil.getInstance().getCacheMap(cacheName);
			
			if(brandMap == null){
				return null;
			}
			
			if(type.equals("DB")){
				Map<String,String> entryMap = (Map<String,String>)brandMap.get(code);
				if(entryMap != null){
					for(Iterator iter = entryMap.entrySet().iterator();iter.hasNext();){
						Map.Entry<String, String> entry = (Map.Entry<String, String>)iter.next();
						return entry.getValue();
					}
				}
			}
			else{
				return brandMap.get(code).toString();
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
}
