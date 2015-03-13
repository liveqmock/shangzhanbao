/********************************************************
  Copyright (C), 2009-2010, eTIP.
  File name:    com/itour/etip/kit/adapter/IAdapter.java
  Description:  为服务适配器定义接口
  Author: LiuShuwei      Version:  1.0.0  Date: 2009.4.7
  History:     
    1. Date:
       Author:
       Modification:定义接口
    2. ...
***********************************************************/
package com.itour.etip.pub.kit.adapter;

public interface IAdapter {
	/**
	 * 
	 * @param methodName
	 *        要调用的Service的方法名
	 * @param param
	 *        要调用的Service的方法需要的参数，按照顺序放入一个Object数组；
	 *        UserBean user = new UserBean();
	 *        user.setID("999");
	 *        .....
	 *        OrderBean order = new OrderBean;
	 *        order.setOrderID(orderId);
	 *        Object[] ojbArr = new Object[]{user,order};
	 *        invoke("methodName",objArr,String.class);
	 * @param returnType
	 *        要调用的Service的方法返回值类型，参见param
	 * @return 
	 *        要调用的Service的方法返回值
	 * @throws Exception
	 *        抛出的异常
	 */
	Object[] invoke(String methodName,Object param,Class<?> returnType) throws Exception;
}
