/********************************************************
  Copyright (C), 2009-2010, eTIP.
  File name:    com/itour/etip/base/FrmPersistence.java
  Description:  持久化基础父类,用于声明持久化对象语义。
  Author: TengXiaocong      Version:  1.0.0  Date: 2009.4.8
 ***********************************************************/
package com.itour.etip.pub.frame;

import com.itour.etip.pub.base.IDao;
import com.itour.etip.pub.base.IPersistence;


public abstract class FrmPersistence implements IPersistence {
	/**
	 * 
	 * 返回Dao实例。
	 * 
	 * @param daoName
	 *            Dao名称。
	 */
	public IDao getDao(String daoName) {
		return DaoFactory.getDao(daoName);
	}

}
