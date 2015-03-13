package com.itour.etip.pub.kit.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EhCache implements ICache{
	
	private static final Log log = LogFactory.getLog( EhCache.class );
	
	private static final int SIXTY_THOUSAND_MS = 60000;
	
	private net.sf.ehcache.Cache cache;
	
	public EhCache(net.sf.ehcache.Cache cache) {
		this.cache = cache;
	}
	
	public EhCache(){
		cache = null;
	}
	
	public Object get(Object key) throws CacheException {
		try {
			if ( log.isDebugEnabled() ) {
				log.debug( "key: " + key );
			}
			if ( key == null ) {
				return null;
			}
			else {
				Element element = cache.get( key );
				if ( element == null ) {
					if ( log.isDebugEnabled() ) {
						log.debug( "Element for " + key + " is null" );
					}
					return null;
				}
				else {
					return element.getObjectValue();
				}
			}
		}
		catch (net.sf.ehcache.CacheException e) {
			throw new CacheException( e );
		}
	}

	public Object read(Object key) throws CacheException {
		return get( key );
	}
	
	public void update(Object key, Object value) throws CacheException {
		put( key, value );
	}
	
	public void put(Object key, Object value) throws CacheException {
		try {
			Element element = new Element( key, value );
			cache.put( element );
		}
		catch (IllegalArgumentException e) {
			throw new CacheException( e );
		}
		catch (IllegalStateException e) {
			throw new CacheException( e );
		}
		catch (net.sf.ehcache.CacheException e) {
			throw new CacheException( e );
		}

	}
	
	public void remove(Object key) throws CacheException {
		try {
			cache.remove( key );
		}
		catch (ClassCastException e) {
			throw new CacheException( e );
		}
		catch (IllegalStateException e) {
			throw new CacheException( e );
		}
		catch (net.sf.ehcache.CacheException e) {
			throw new CacheException( e );
		}
	}
	
	public void clear() throws CacheException {
		try {
			cache.removeAll();
		}
		catch (IllegalStateException e) {
			throw new CacheException( e );
		}
		catch (net.sf.ehcache.CacheException e) {
			throw new CacheException( e );
		}
	}
	
	public void destroy() throws CacheException {
		try {
			cache.getCacheManager().removeCache( cache.getName() );
		}
		catch (IllegalStateException e) {
			throw new CacheException( e );
		}
		catch (net.sf.ehcache.CacheException e) {
			throw new CacheException( e );
		}
	}
	
	public long nextTimestamp() {
		return Timestamper.next();
	}
	
	public int getTimeout() {
		// 60 second lock timeout
		return Timestamper.ONE_MS * SIXTY_THOUSAND_MS;
	}

	public String getRegionName() {
		return cache.getName();
	}
	
	public long getSizeInMemory() {
		try {
			return cache.calculateInMemorySize();
		}
		catch (Throwable t) {
			return -1;
		}
	}

	public long getElementCountInMemory() {
		try {
			return cache.getMemoryStoreSize();
		}
		catch (net.sf.ehcache.CacheException ce) {
			throw new CacheException( ce );
		}
	}

	public long getElementCountOnDisk() {
		return cache.getDiskStoreSize();
	}

	public Map toMap() {
		try {
			Map result = new HashMap();
			Iterator iter = cache.getKeys().iterator();
			while ( iter.hasNext() ) {
				Object key = iter.next();
				result.put( key, cache.get( key ).getObjectValue() );
			}
			return result;
		}
		catch (Exception e) {
			throw new CacheException( e );
		}
	}

	public String toString() {
		return "EHCache(" + getRegionName() + ')';
	}
	
	public final void setCache(net.sf.ehcache.Cache cache) {
		this.cache = cache;
	}

}
