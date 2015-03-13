package com.itour.etip.pub.kit.ws;

import java.util.HashMap;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

import com.itour.etip.pub.kit.log.LogUtil;

public class WSUtil {
	/**
	 * @param address
	 * @param method
	 * @param paras
	 * @param soapAction
	 * @return xml
	 */
	public static String callWSMethod(String address, String method,
			HashMap paras, String soapAction,String nameSpace,String qname) {
		try {
			OMElement wsMethod = createWSMethod(method, paras,nameSpace,qname);
			EndpointReference targetEPR = new EndpointReference(address);

			Options options = new Options();
			options.setTo(targetEPR);
			options.setAction(soapAction);
			options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
			ServiceClient service = new ServiceClient();
			service.setOptions(options);
			OMElement result = service.sendReceive(wsMethod);
			String xml = result.toString();
			return xml;
		} catch (AxisFault e) {
			
			LogUtil.error("eTIPError", e.toString());
			e.printStackTrace();
			return "failure:" + e.toString();
		}
	}

	/**
	 * 生成WebService调用的dom模型
	 * 
	 * @return
	 */
	private static OMElement createWSMethod(String method, HashMap paras,String nameSpace,String qname) {
		OMFactory fac = OMAbstractFactory.getOMFactory();
		//OMNamespace omNs = fac.createOMNamespace("http://10.124.0.43/MotoService/Service.asmx", "ns");
		OMNamespace omNs = fac.createOMNamespace(nameSpace,qname);
		OMElement methodNode = fac.createOMElement(method, omNs);
		createAttrNode(fac, omNs, methodNode, paras);
		return methodNode;
	}

	/**
	 * 递归方式解析节点属性，生成子节点。
	 * 
	 * @param parentNode
	 * @param paras
	 */
	private static void createAttrNode(OMFactory fac, OMNamespace omNs,
			OMElement parentNode, HashMap paras) {
		Object[] attrs = paras.keySet().toArray();
		for (Object attr : attrs) {
			OMElement attrNode = fac.createOMElement(attr.toString(), omNs);
			parentNode.addChild(attrNode);
			// 以下判断当前节点是否是String,如果是String,那么直接创建text节点，如果是hashMap，那么要递归处理
			Object value = paras.get(attr);
			if (value instanceof String) {
				attrNode.addChild(fac.createOMText(attrNode, paras.get(attr)
						.toString()));
			} else if (value instanceof HashMap) {
				createAttrNode(fac, omNs, attrNode, (HashMap) value);
			} else {
				System.out.println("ceateAttrNodeFoundUnsupportParameter");
			}
		}
	}

}
