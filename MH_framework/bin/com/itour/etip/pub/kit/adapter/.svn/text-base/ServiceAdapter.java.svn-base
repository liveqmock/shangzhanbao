/********************************************************
  Copyright (C), 2009-2010, eTIP.
  File name:    com/itour/etip/kit/adapter/ServiceAdapter.java
  Description:  服务调用适配器实现，使用Java反射方式调用方法，目的是与
      WebService统一调用接口，隐藏实现节省开发工作。
  Author: LiuShuwei      Version:  1.0.0  Date: 2009.4.7
  History:     
    1. Date:
       Author:
       Modification:
    2. ...
***********************************************************/
package com.itour.etip.pub.kit.adapter;

import java.lang.reflect.Method;

import com.itour.etip.pub.base.IService;

public class ServiceAdapter implements IAdapter {
	private IService service;
	public IService getService() {
		return service;
	}
	public void setService(IService service) {
		this.service = service;
	}
	public Object[] invoke(String methodName, Object param, Class<?> returnType) throws Exception {
		Method method = service.getClass().getMethod(methodName, param.getClass());
		Object objReturn[] = new Object[]{method.invoke(service,param)};
		return objReturn;
	}
	
	

}
