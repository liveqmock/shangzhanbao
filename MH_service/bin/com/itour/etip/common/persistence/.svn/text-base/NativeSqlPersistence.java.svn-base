package com.itour.etip.common.persistence;

import com.itour.etip.pub.frame.DaoFactory;
import com.itour.etip.pub.frame.FrmPersistence;
import com.itour.etip.pub.frame.HibernateDao;

public class NativeSqlPersistence extends FrmPersistence implements INativeSqlPersistence{
	public int executeInsert(String sql) {
		return ((HibernateDao) DaoFactory.getDao("hibernate")).updateBySQL(sql);
	}

	public int executeDelete(String sql) {		
		return ((HibernateDao) DaoFactory.getDao("hibernate")).updateBySQL(sql);
	}
}
