/********************************************************
  Copyright (C), 2009-2010, eTIP.
  File name:    com/itour/etip/base/DaoFactory.java
  Description:  数据持久化组件工厂
  Author: TengXiaocong      Version:  1.0.0  Date: 2009.4.8
***********************************************************/
package com.itour.etip.pub.frame;

import java.util.LinkedHashMap;

import com.itour.etip.pub.base.IDao;

/**
 * Dao工厂，可以根据名称获得Dao实例
 */
public class DaoFactory {
	
	
	/**
	 * daoMap实例,静态要求是单实例对象。
	 */
	protected static LinkedHashMap<String, IDao> daoMap = new LinkedHashMap<String, IDao>();
	
	/**
	 * 构造函数。 
	 */
	private DaoFactory(){
		
	}

	/**
	 * 返回Dao映射表
	 */
	public LinkedHashMap<String, IDao> getDaoMap() {
		return daoMap;
	}

	/**
	 * 设置Dao映射表
	 * @param daoMap
	 *            设置Dao映射表。
	 */
	public void setDaoMap(LinkedHashMap<String, IDao> daoMap) {
		this.daoMap = daoMap;
	}

	/**
	 * 返回Dao名称。
	 */
	public static IDao getDao(String daoName) {
		return daoMap.get(daoName);
	}
}