/********************************************************
  Copyright (C), 2009-2010, eTIP.
  File name:    com/itour/etip/kit/adapter/ServiceAdapter.java
  Description:  WebService调用适配器实现，为了减少应用系统代码量，
      采用RPCServiceClient方式调用WebService，不用生成桩代码。
      再调用之前需要实例化输入参数中的Bean实例。
  Author:LiuShuwei      Version:1.0.0  Date:2009.4.7
  History:     
    1. Date:
       Author:
       Modification:定义接口
    2. ...
***********************************************************/
package com.itour.etip.pub.kit.adapter;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class WebServiceAdapter implements IAdapter {
	String targetNamespace;
	private RPCServiceClient serviceClient;
	private Options options;
	private String endPointReference;
	
	public String getEndPointReference() {
		return endPointReference;
	}

	public void setEndPointReference(String endPointReference) {
		this.endPointReference = endPointReference;
	}


	public Object[] invokeOp(String targetNamespace, String opName,
			Object[] opArgs, Class<?>[] opReturnType) throws AxisFault,
			ClassNotFoundException {
		QName opQName = new QName(targetNamespace, opName);
		return serviceClient.invokeBlocking(opQName, opArgs, opReturnType);
	}

	public String getTargetNamespace() {
		return targetNamespace;
	}

	public void setTargetNamespace(String targetNamespace) {
		this.targetNamespace = targetNamespace;
	}

	public Object[] invoke(String methodName, Object param, Class<?> returnType)
			throws Exception {
		
		Object response[] = null;
		try {
			System.out.println("================================");
			serviceClient = new RPCServiceClient();
			options = serviceClient.getOptions();
			EndpointReference targetEPR = new EndpointReference(endPointReference);
			options.setTo(targetEPR);
			
			Object[] opArgs = new Object[]{param};
			Class<?>[] opReturnType = new Class[]{returnType};
			
			response = invokeOp(targetNamespace, methodName, opArgs, opReturnType);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return response;
	}

}
