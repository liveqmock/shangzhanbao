package com.itour.etip.pub.kit.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;

public class CacheUtil {
	private static final String DBCACHE = "dbCache";

	private static final String DBMEMCACHE = "dbMemCache";

	private static final String EXCEPTIONCACHE = "exceptionCache";

	private static final String DATACACHE = "dataCache";

	private static final String VOCACHE = "voCache";

	private static final String PARACACHE = "paraCache";

	private static CacheUtil instance = null;

	public static ExceptionCache errorCache = null;

	public static DBCache dbCache = null;

	public static DataCache dataCache = null;

	public static ParaCache paraCache = null;

	private CacheUtil() {

	}

	public static CacheUtil getInstance() {
		if (instance == null) {
			instance = new CacheUtil();
			CacheUtil.paraCache = (ParaCache) SpringContextHelper.getBean(PARACACHE);
			CacheUtil.dataCache = (DataCache) SpringContextHelper.getBean(DATACACHE);
			// 此处需要根据参数确定使用哪个数据库缓存，只能使用一个
			String value = CacheUtil.paraCache.getParaValue("MemCacheUsed");
			if (value == null || value.equals("false")) {
				CacheUtil.dbCache = (DBCache) SpringContextHelper.getBean(DBCACHE);
			} else {
				CacheUtil.dbCache = (DBMemCache) SpringContextHelper.getBean(DBMEMCACHE);
			}
			CacheUtil.errorCache = (ExceptionCache) SpringContextHelper.getBean(EXCEPTIONCACHE);
		}
		return instance;
	}



	public HashMap getAssociateMapping(String srcCacheName, String srcID, String desCacheName) {
		HashMap rtMap = null;

		TreeMap accMap = getCacheMap(desCacheName + "/" + srcCacheName);
		TreeMap desMap = getCacheMap(desCacheName);

		if (accMap == null || desMap == null)
			return rtMap;

		rtMap = new HashMap();

		java.util.TreeSet set = new java.util.TreeSet(accMap.keySet());
		Iterator iterator = set.iterator();
		Object curkey = null;
		Object key = null;
		Object value = null;
		String tempkey = null;
		String tempkey1 = null;
		String tempkey2 = null;
		String tempValue = null;
		while (iterator.hasNext()) {
			curkey = iterator.next();
			if (curkey.toString().indexOf("/") >= 0) {
				String[] keystr = curkey.toString().split("/");
				tempkey1 = keystr[0].trim();
				tempkey2 = keystr[1].trim();
				tempkey = Integer.toString(Integer.parseInt(tempkey1) + Integer.parseInt(tempkey2));
				key = tempkey;
			} else {
				key = curkey;
			}
			value = accMap.get(curkey);
			tempValue = "";
			if (value != null)
				tempValue = value.toString();
			if (value != null
					&& srcID.length() > 1
					&& srcID.length() < key.toString().length()
					&& (tempValue.toLowerCase().lastIndexOf("$$") == tempValue.length() - 2 && tempValue.toLowerCase()
							.indexOf(srcID.toLowerCase()) == 0)

			) {
				tempValue = key.toString().substring(srcID.length(), key.toString().length());
				rtMap.put(tempValue, desMap.get(tempValue));
			} else if (tempValue.equalsIgnoreCase(srcID)) {

				String assValue = ("" + (Integer.parseInt(key.toString()) - Integer.parseInt(value.toString())));
				rtMap.put(key, desMap.get(assValue));
			}
		}

		return rtMap;
	}

	/**
	 * 根据名称取得cache,首先在dataCache中搜索，然后在DBCache中搜索
	 * 
	 * @param cacheName
	 * @return
	 */
	public java.util.TreeMap getCacheMap(String cacheName) {
		TreeMap dataMap = new TreeMap();
		try {

			TreeMap dataDicMap = dataCache.getDataMap(cacheName);
			if (dataDicMap != null && !dataDicMap.toString().endsWith("{}")) {
				for (int i = 0; i < dataDicMap.size(); i++) {
					Object object = dataDicMap.get(i+"");
					dataMap.put(i, object);
				}
				return dataMap;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {

			TreeMap DBMap = dbCache.getDBCache(cacheName);
			if (DBMap != null && !DBMap.toString().endsWith("{}")) {
				dataMap.putAll(DBMap);
				return dataMap;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (dataMap.size() == 0) {
			dataMap = null;
		}
		return dataMap;
	}

	public String getCacheName(String cacheName, String code) {
		return (getCacheMap(cacheName).get(code) == null) ? "" : getCacheMap(cacheName).get(code).toString();
	}

	public String getCacheCode(String cacheName, String name) {
		TreeMap cacheMap = getCacheMap(cacheName);
		Iterator iter = cacheMap.keySet().iterator();
		String code = "";
		while (iter.hasNext()) {
			code = (String) iter.next();
			if (name.equals(cacheMap.get(code)))
				return code;
		}
		return "";
	}

	
	

	// txc add
	public  String getCacheStringByAttrCode(String attrCode) {

		JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");

		String sql = "select g.ATTRCODE,g.ATTRNAME from GENERALDIC g where g.PARENTID=(select id from GENERALDIC where ATTRCODE='"
				+ attrCode + "')";
		List<ETIPResultSet> rv = jdbcDao.queryForList(sql, null);

		if (rv.size() > 0) {
			StringBuffer data = new StringBuffer();
			for (ETIPResultSet record : rv) {
				if (data.toString().length() > 0) {
					data.append(",").append("['").append(record.getString("ATTRCODE")).append("'").append(",").append(
							"'").append(record.getString("ATTRNAME")).append("']");
				} else {
					data.append("[").append("['").append(record.getString("ATTRCODE")).append("'").append(",").append(
							"'").append(record.getString("ATTRNAME")).append("']");
				}
			}
			if (data.toString().length() == 0) {
				return "[]";
			} else {
				data.append("]");
				return data.toString();
			}
		}

		return "[]";
	}

	// txc add
	public static String getNextTreeNode(String myAttrCode) {

		JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");

		String sql = "select g.ATTRCODE,g.ATTRNAME from GENERALDIC g where g.PARENTID=(select id from GENERALDIC where ATTRCODE='"
				+ myAttrCode + "')";
		List<ETIPResultSet> rv = jdbcDao.queryForList(sql, null);

		JSONArray firstArray = new JSONArray();

		for (ETIPResultSet record : rv) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("checked", false);
			jsonObject.put("id", record.getString("ATTRCODE"));
			jsonObject.put("text", record.getString("ATTRNAME"));
			if (!("[]".equals(record.getString("ATTRCODE")))) {
				jsonObject.put("leaf", false);
			} else {
				jsonObject.put("leaf", true);
			}
			firstArray.add(jsonObject);
		}
		
		return firstArray.toString();

	}

	
}
