/********************************************************
  Copyright (C), 2009-2010, eTIP.
  File name:    com/itour/etip/base/IData.java
  Description:  语义声明，无需定义方法。所有的数据模型都需要实现此接口
  Author: TengXiaocong      Version:  1.0.0  Date: 2009.4.8
***********************************************************/
package com.itour.etip.pub.base;

public  interface IData{
	/**
	 * 获取对象的id
	 * @return
	 * 	对象的id
	 */	
	public String getId();
	/**
	 * 设置对象的id，由hibernate自动设置
	 * @param id
	 * 	对象的id，由hibernate设置。
	 */
	public void setId(String id);
	/**
	 *  获取对象的版本戳
	 * @return 
	 * 	int类型参数，标识对象在数据库中对应记录的版本
	 */	
	public Integer getVersion();
	
	/**
	 * 设置对象的版本戳
	 * @param version
	 * 	版本戳，不需要手工设置，由hibernate自动设置
	 */
	public void setVersion(Integer version);
}
