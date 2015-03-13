/********************************************************
  Copyright (C), 2009-2010, eTIP.
  File name:    com/itour/etip/base/IPersistent.java
  Description:  持久化接口的语义基础接口，在系统设计时，要求所有
   对外暴露的持久化接口都声明为IPersistent的子接口。
  Author: LiuShuwei      Version:  1.0.0  Date: 2009.4.8
  History:     
    1. Date:
       Author:
       Modification:定义接口
    2. ...
***********************************************************/
package com.itour.etip.pub.base;


/**
 * 持久化层对象基础接口，用作语义声明 PO意思是PersistentObject,在应用系统中的持久化
 * 操作都通过IVWPPO接口提供服务，具体包括：
 * 1.SpringDAO方式调用。 2.Hibernate方式调用。 3.Ibatis方式调用。
 */

public interface IPersistence {
	/**
	 * 
	 * 返回Dao实例。
	 * 
	 * @param daoName
	 *            Dao名称。
	 */
	public IDao getDao(String daoName);
}
