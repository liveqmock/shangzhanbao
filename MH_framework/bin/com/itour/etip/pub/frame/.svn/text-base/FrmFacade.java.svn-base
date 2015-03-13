/********************************************************
  Copyright (C), 2009-2011, eTIP.
  File name:    com/itour/etip/frame/FrmFacade.java
  Description:  IFacade的子类实现调用。
  Author: txc      Version:  1.0.0  Date: 2009.4.7
  History:     
    1. Date:
       Author:
       Modification:定义接口
    2. ...
***********************************************************/
package com.itour.etip.pub.frame;

import com.itour.etip.pub.base.IFacade;
import com.itour.etip.pub.kit.adapter.IAdapter;
import com.itour.etip.pub.kit.cache.CacheUtil;

public abstract class FrmFacade implements IFacade {
	/**
	 * 服务调用适配器，目前支持两种：WebService和Java方法调用
	 */
	IAdapter adapter = null;
	
	public IAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(IAdapter adapter) {
		this.adapter = adapter;
	}
	
	/**
	 * 通用的服务执行接口
	 */
	public final Object[] executeService(String methodName, Object param,
			Class<?> returnType) throws Exception {
		return adapter.invoke(methodName, param, returnType);
	}	
	
	/**
	 * 判断，当前应用是否demo状态，如果是demo状态
	 * 此方法的问题不能取得web容器中的spring配置对象。
	 * 需要加载xml,导致二次加载，不过处于测试状态，效率就没有关系了。
	 */
	public boolean isDemo(){
		String runMode = CacheUtil.paraCache.getParaValue("runMode");
		if(runMode!=null && runMode.equals("demo")){
			return true;
		}
		else {
			return false;
		}
	}
}
