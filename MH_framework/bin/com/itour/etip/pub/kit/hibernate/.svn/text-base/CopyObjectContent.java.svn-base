package com.itour.etip.pub.kit.hibernate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.itour.etip.pub.base.IData;
import com.itour.etip.pub.frame.FrmData;

/**
 * 自动设置对象内容用来生成测试数据
 * 
 * @author Leo
 *
 */
public class CopyObjectContent {
	
	
	/**
	 * 自动为对象赋值
	 */
	public static void copyObject(Object newObj, Object oldObj) {
		if(newObj instanceof Collection){
			for(int i=0; i<((List)newObj).size(); i++){
				copyObject(((List)newObj).get(i), ((List)oldObj).get(i));
			}
		}else if(newObj instanceof IData){
			Method[] ms = newObj.getClass().getDeclaredMethods();
			for(Method m : ms){
				//m.getName().indexOf("set")==0 && "id".equals(m.getName().substring(m.getName().length()-2).toLowerCase())
				if(m.getName().indexOf("set")!=0 || "setJson".equals(m.getName()) || (m.getName().indexOf("set")==0 && "id".equals(m.getName().substring(m.getName().length()-2).toLowerCase())))continue;
				try {
					if((FrmData.class).equals(m.getParameterTypes()[0].getSuperclass())){
						Object o = oldObj.getClass().getDeclaredMethod(m.getName().replaceFirst("s", "g")).invoke(oldObj);
						if(o == null){
//							m.invoke(newObj, null);
						}else{
							Object newSubObj = (m.getParameterTypes()[0]).newInstance();
							copyObject(newSubObj, o);
							m.invoke(newObj, newSubObj);
						}
					}else if((List.class).equals(m.getParameterTypes()[0])){
						List ol = (List)(oldObj.getClass().getDeclaredMethod(m.getName().replaceFirst("s", "g")).invoke(oldObj));
						if(ol == null){
//							m.invoke(newObj, null);
						}else{
							List nl = new ArrayList();
							Class clazz = (Class)(((java.lang.reflect.ParameterizedType)(m.getGenericParameterTypes()[0])).getActualTypeArguments()[0]);
							for(int i=0; i<ol.size(); i++){
								nl.add(clazz.newInstance());
							}
							copyObject(nl, ol);
							m.invoke(newObj, nl);
						}
					}else{
						m.invoke(newObj, oldObj.getClass().getDeclaredMethod(m.getName().replaceFirst("s", "g")).invoke(oldObj));
					}
				} catch (IllegalArgumentException e) {
					
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					
					e.printStackTrace();
				} catch (InstantiationException e) {
					
					e.printStackTrace();
				} catch (SecurityException e) {
					
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					
					e.printStackTrace();
				}
				
			}
		}
	}
}
