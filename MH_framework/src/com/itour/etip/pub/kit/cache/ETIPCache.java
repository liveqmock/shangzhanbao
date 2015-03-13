package com.itour.etip.pub.kit.cache;

import java.util.Hashtable;

import com.itour.etip.pub.kit.xml.XMLDataBean;

public abstract class ETIPCache {
	/**
	 * 当前的缓冲区文件
	 */
	protected String curCacheFile = null;

	/**
	 * key与文件名的对应关系
	 */
	protected Hashtable<String, String> keyFileMapping = new Hashtable<String, String>();

	/**
	 * 文件和dom的对应关系
	 */
	protected Hashtable<String, XMLDataBean> fileDomMapping = new Hashtable<String, XMLDataBean>();

	/**
	 * 实例对象
	 */
	protected java.util.TreeMap<String, Object> cacheInstance = new java.util.TreeMap<String, Object>();

	public void setCacheFile(String cacheFile) {
		this.curCacheFile = cacheFile;
	}

	public String getCacheFile() {
		return this.curCacheFile;
	}

	public abstract void loadFromFile() throws Exception;

	public abstract void saveCache() throws Exception;

	public Object getCache(String key) {
		Object rv = cacheInstance.get(key);
		return rv;
	}

	public void updateCache(String key, Object value) {
		if (key == null)
			return;
		if (value == null)
			cacheInstance.remove(key);
		cacheInstance.put(key, value);
	}

	public java.util.TreeMap getCacheInstance() {
		return cacheInstance;
	}

	public String getCurCacheFile() {
		return curCacheFile;
	}

	public void setCurCacheFile(String curCacheFile) {
		this.curCacheFile = curCacheFile;
	}

	public Hashtable<String, String> getKeyFileMapping() {
		return keyFileMapping;
	}

	public void setKeyFileMapping(Hashtable<String, String> keyFileMapping) {
		this.keyFileMapping = keyFileMapping;
	}

	public Hashtable<String, XMLDataBean> getFileDomMapping() {
		return fileDomMapping;
	}

	public void setFileDomMapping(Hashtable<String, XMLDataBean> fileDomMapping) {
		this.fileDomMapping = fileDomMapping;
	}

	public void setCacheInstance(java.util.TreeMap<String, Object> cacheInstance) {
		this.cacheInstance = cacheInstance;
	}

}
