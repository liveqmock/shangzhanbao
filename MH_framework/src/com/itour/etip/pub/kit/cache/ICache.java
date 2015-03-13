package com.itour.etip.pub.kit.cache;

import java.util.Map;

public interface ICache {

	public Object read(Object key) throws CacheException;
	
	public Object get(Object key) throws CacheException;
	
	public void put(Object key, Object value) throws CacheException;
	
	public void update(Object key, Object value) throws CacheException;
	
	public void remove(Object key) throws CacheException;
	
	public void clear() throws CacheException;
	
	public void destroy() throws CacheException;
	
	public long nextTimestamp();
	
	public int getTimeout();
	
	public String getRegionName();
	
	public long getSizeInMemory();
	
	public long getElementCountInMemory();
	
	public long getElementCountOnDisk();
	
	public Map toMap();
}
