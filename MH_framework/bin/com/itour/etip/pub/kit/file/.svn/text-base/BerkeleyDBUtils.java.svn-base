package com.itour.etip.pub.kit.file;
import java.io.File;
import java.io.UnsupportedEncodingException;

import com.itour.etip.pub.kit.cache.CacheUtil;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;

public class BerkeleyDBUtils {
	
	
	
	// private static final int CACHE_PERCENT = 65;
	private static final int CACHE_SIZE = 1024 * 512 * 1;
	private String dbPath = CacheUtil.paraCache.getParaValue("orderFilePath");
	private boolean isZip = true;

	private Environment myDbEnvironment = null;
	private Database myDatabase = null;
	private Cursor myCursor = null;
	private EnvironmentConfig envConfig = null;

	public BerkeleyDBUtils(String path) {
		this.setDbPath(CacheUtil.paraCache.getParaValue("orderFilePath"));
		try {
			this.setup();
		} catch (EnvironmentLockedException e) {
			e.printStackTrace();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

	private void setup() throws EnvironmentLockedException, DatabaseException {
		setEnvConfig(new EnvironmentConfig());
		getEnvConfig().setAllowCreate(true);
		// envConfig.setCachePercent(CACHE_PERCENT);
		getEnvConfig().setCacheSize(CACHE_SIZE);
		getEnvConfig().setConfigParam(EnvironmentConfig.LOG_FILE_MAX, String.valueOf(1024 * 1024 * 50));
		setMyDbEnvironment(new Environment(new File(getDbPath()), getEnvConfig()));

		DatabaseConfig dbConfig = new DatabaseConfig();
//		dbConfig.setExclusiveCreate(false);
		dbConfig.setAllowCreate(true);
		// 延迟写数据，减少io
		dbConfig.setDeferredWrite(true);
		// transaction为null，不支持事务
		setMyDatabase(getMyDbEnvironment().openDatabase(null, "sampleDatabase", dbConfig));
		this.myCursor = this.getMyDatabase().openCursor(null, null);
	}

	public void putString(String key, String value, Boolean isZip, String defaultEncoding) {
		try {
			String charsetName ="utf-8";
			byte[] bytes = key.getBytes(charsetName);
			byte[] bytes2 = value.getBytes(charsetName);
			putByte(isZip, bytes, bytes2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteString(String key, String defaultEncoding) {
		try {
			String charsetName ="utf-8";
			byte[] bytes = key.getBytes(charsetName);
			deleteByte(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void putByte(Boolean isZip, byte[] bytesKey, byte[] bytesValue) throws DatabaseException {
//		if (isZip == null ? this.isZip : isZip) {
//			bytesValue = FileZipUtils.gZipByte(bytesValue);
//		}
		DatabaseEntry theKey = new DatabaseEntry(bytesKey);
		DatabaseEntry theValue = new DatabaseEntry(bytesValue);
		myDatabase.put(null, theKey, theValue);
	}

	public void deleteByte(byte[] bytesKey) throws DatabaseException {
		DatabaseEntry theKey = new DatabaseEntry(bytesKey);
		myDatabase.delete(null, theKey);
	}

	public String getString(String key, Boolean isZip, String defaultEncoding) {
		String foundData = null;
		try {
			String charsetName ="utf-8";
			byte[] bytes = key.getBytes(charsetName);
			byte[] byter = getByte(bytes, isZip);
			if (byter != null)
				foundData = new String(byter, charsetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foundData;
	}

	

	public byte[] getByte(byte[] bytesKey, Boolean isZip) throws DatabaseException, UnsupportedEncodingException {
		byte[] bytesValue = null;
		DatabaseEntry theKey = new DatabaseEntry(bytesKey);
		DatabaseEntry theData = new DatabaseEntry();
		if (myDatabase.get(null, theKey, theData, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
//			if (isZip == null ? this.isZip : isZip) {
//				bytesValue = FileZipUtils.unGZipByte(theData.getData());
//			}
//			else {
				bytesValue = theData.getData();
	//		}
		}
		return bytesValue;
	}

	public void close() {
		try {
			if (getMyCursor() != null) {
				getMyCursor().close();
			}
			if (getMyDatabase() != null) {
				getMyDatabase().close();
			}
			if (getMyDbEnvironment() != null) {
				getMyDbEnvironment().sync();
				getMyDbEnvironment().cleanLog();
				getMyDbEnvironment().close();
			}
		} catch (DatabaseException dbe) {
			dbe.printStackTrace();
		}
	}

	public void setMyDatabase(Database myDatabase) {
		this.myDatabase = myDatabase;
	}

	public Database getMyDatabase() {
		return myDatabase;
	}

	public void setMyDbEnvironment(Environment myDbEnvironment) {
		this.myDbEnvironment = myDbEnvironment;
	}

	public Environment getMyDbEnvironment() {
		return myDbEnvironment;
	}

	public void putString(String key, String value) {
		putString(key, value, null, null);

	}

	public String getString(String key) {
		return getString(key, null, null);
	}

	public void setMyCursor(Cursor myCursor) {
		this.myCursor = myCursor;
	}

	public Cursor getMyCursor() {
		return myCursor;
	}

	public void setDbPath(String dbPath) {
		this.dbPath = dbPath;
	}

	public String getDbPath() {
		return dbPath;
	}

	public void setEnvConfig(EnvironmentConfig envConfig) {
		this.envConfig = envConfig;
	}

	public EnvironmentConfig getEnvConfig() {
		return envConfig;
	}

}

