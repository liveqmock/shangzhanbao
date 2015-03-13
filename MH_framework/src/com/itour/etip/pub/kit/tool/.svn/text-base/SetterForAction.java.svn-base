package com.itour.etip.pub.kit.tool;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.itour.etip.pub.frame.FrmAction;

/**
 * @author 何大勇
 * @date 2013-9-13
 */
public class SetterForAction {
	public  void  actionParameterMapping(FrmAction action){
		HttpServletRequest request = action.getRequest();
		
		Map<String, Object> map = request.getParameterMap();
		Iterator<String> iterator = map.keySet().iterator();
		PropertyDescriptor[] props = null;   
        try {   
            props = Introspector.getBeanInfo(action.getClass(), FrmAction.class)
                    .getPropertyDescriptors();
        } catch (IntrospectionException e) {   
        } 
		while(iterator.hasNext()){
			String key = iterator.next();
			Object value = map.get(key);
			
		}
	}
}
