package com.itour.etip.pub.kit.cache;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Locale;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.itour.etip.pub.frame.SpringContextHelper;
import com.opensymphony.xwork2.interceptor.I18nInterceptor;

public class InitCacheListener implements ServletContextListener {
	public static String fullCacheLocation;

	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		String cacheLocation = event.getServletContext().getInitParameter("cacheConfiguration");
		fullCacheLocation = event.getServletContext().getRealPath(cacheLocation);
		loadExceptions(fullCacheLocation, event);
		loadParas(fullCacheLocation, event);
		loadDatas(fullCacheLocation, event);
		loadDBs(fullCacheLocation, event);
		// txc add for IDMappingName
		loadNames();
		// loadVOs(fullCacheLocation, event);
	}

	private void loadNames() {
		IDMappingNameCache cache = (IDMappingNameCache) SpringContextHelper.getBean("iDMappingNameCache");
		cache.init();
	}

	private void loadExceptions(String fullCacheLocation, final ServletContextEvent event) {
		String exceptionPath = fullCacheLocation + "/exception";
		File file = new File(exceptionPath);
		// LogUtil.info("CONSOLE", "load exceptoins");
		if (file.isDirectory()) {
			String[] fileNames = getFiles(event, file);
			ExceptionCache cache = (ExceptionCache) SpringContextHelper.getBean("exceptionCache");

			for (String fileName : fileNames) {
				String cacheFileName = exceptionPath + "/" + fileName;
				try {
					cache.setCacheFile(cacheFileName);
					cache.loadFromFile();
				} catch (Exception ex) {
					ex.printStackTrace();
					System.exit(0);
				}
			}

		} else {
			System.exit(0);
		}
	}

	private String[] getFiles(final ServletContextEvent event, File file) {
		String[] fileNames = file.list(new FilenameFilter() {
			public boolean accept(File path, String fileName) {
				String defaultLocaleName = I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE;
				String userLocaleName = I18nInterceptor.DEFAULT_PARAMETER;
				Locale locale = (Locale) event.getServletContext().getAttribute(userLocaleName);
				if (locale == null) {
					locale = (Locale) event.getServletContext().getAttribute(defaultLocaleName);
				}
				if (locale == null) {
					// LogUtil
					// .info("ETIP",
					// "can not get default locale from WW_TRANS_I18N_LOCALE");
				}
				String localeStr = "";
				if (locale != null) {
					localeStr = locale.getLanguage() + "_" + locale.getCountry();
				}
				if (fileName.endsWith(localeStr + ".xml")) {
					return true;
				} else {
					return false;
				}
			}
		});
		return fileNames;
	}

	private void loadParas(String fullCacheLocation, final ServletContextEvent event) {
		String cachePatch = fullCacheLocation + "/para";
		File file = new File(cachePatch);
		if (file.isDirectory()) {
			String[] fileNames = getFiles(event, file);
			ParaCache cache = (ParaCache) SpringContextHelper.getBean("paraCache");
			for (String fileName : fileNames) {
				String cacheFileName = cachePatch + "/" + fileName;
				try {
					cache.setCacheFile(cacheFileName);
					cache.loadFromFile();
					// LogUtil.info("ETIP", cacheFileName + " loaded!");
				} catch (Exception ex) {
					// LogUtil.fatal("ETIP", "can not load cache file:"
					// + cacheFileName);
					System.exit(0);
				}
			}

		} else {
			System.exit(0);
		}
	}

	private void loadDBs(String fullCacheLocation, final ServletContextEvent event) {
		String cachePath = fullCacheLocation + "/db";
		File file = new File(cachePath);
		if (file.isDirectory()) {
			String[] fileNames = getFiles(event, file);
			DBCache cache = null;

			if ("true".equals(CacheUtil.getInstance().paraCache.getParaValue("MemCacheUsed"))) {
				cache = (DBCache) SpringContextHelper.getBean("dbMemCache");
			}
			else{
				cache = (DBCache) SpringContextHelper.getBean("dbCache");
			}

			for (String fileName : fileNames) {
				String cacheFileName = cachePath + "/" + fileName;
				try {
					cache.setCacheFile(cacheFileName);
					cache.loadFromFile();
					// LogUtil.info("ETIP", cacheFileName + " loaded!");
				} catch (Exception ex) {
					// LogUtil.fatal("ETIP", "can not load cache file:"
					// + cacheFileName);
					System.exit(0);
				}
			}

		} else {
			// LogUtil.fatal("ETIP", cachePath + " not existed,System exit");
			System.exit(0);
		}
	}

	private void loadDatas(String fullCacheLocation, final ServletContextEvent event) {
		String cachePath = fullCacheLocation + "/data";
		File file = new File(cachePath);
		if (file.isDirectory()) {
			String[] fileNames = getFiles(event, file);
			DataCache cache = (DataCache) SpringContextHelper.getBean("dataCache");
			for (String fileName : fileNames) {
				String cacheFileName = cachePath + "/" + fileName;
				try {
					cache.setCacheFile(cacheFileName);
					cache.loadFromFile();
					// LogUtil.info("ETIP", cacheFileName + " loaded!");
				} catch (Exception ex) {
					// LogUtil.fatal("ETIP", "can not load cache file:"
					// + cacheFileName);
					System.exit(0);
				}
			}

		} else {
			// LogUtil.fatal("ETIP", cachePath + " not existed,System exit");
			System.exit(0);
		}
	}

}
