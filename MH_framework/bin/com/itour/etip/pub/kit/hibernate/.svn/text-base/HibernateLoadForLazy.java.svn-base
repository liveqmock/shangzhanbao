package com.itour.etip.pub.kit.hibernate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.collection.PersistentBag;
import org.hibernate.proxy.HibernateProxy;

/**
 * 获得Hibernate懒加载对象
 * 
 * @author Leo
 *
 */
public class HibernateLoadForLazy {
	
	/**
	 * 获得Hibernate懒加载对象
	 * 
	 * @param List<?>
	 * @return List<?>
	 */
	public static void loadLazyObjects(List dataList) {
		/*
		 * 如果没有指定要排除的方法名，那么将懒加载对象全部加载
		 */
		loadLazyObjects(dataList, null);
	}
	
	/**
	 * 获得Hibernate懒加载对象
	 * 
	 * @param List<?> dataList, String[] excludeMethod
	 * @return List<?>
	 */
	public static void loadLazyObjects(List dataList, String[] excludeMethod) {
		Method[] m = new Method[0];
		Object p = new Object();
		Object lazyObject = new Object();
		
		Iterator iterator = dataList.iterator();
        while(iterator.hasNext()){
            Object rowObj = iterator.next();
			if(m.length == 0)
				m = rowObj.getClass().getDeclaredMethods();
			for(int i=0; i<m.length; i++){
				if(m[i].getName().indexOf("get")!=0)continue;
				methodGetSet(m[i], rowObj, p, lazyObject, excludeMethod);
			}
        }
	}
	
	/**
	 * 获得Hibernate懒加载对象
	 * 
	 * @param Object obj
	 * @return Object
	 */
	public static void loadLazyObject(Object obj) {
		/*
		 * 如果没有指定要排除的方法名，那么将懒加载对象全部加载
		 */
		loadLazyObject(obj, null);
	}
	
	/**
	 * 获得Hibernate懒加载对象
	 * 
	 * @param Object obj, String[] excludeMethod
	 * @return Object
	 */
	public static void loadLazyObject(Object obj, String[] excludeMethod) {
		Method[] m = new Method[0];
		Object p = new Object();
		Object lazyObject = new Object();
		if(m.length == 0)
			m = obj.getClass().getDeclaredMethods();
		for(int i=0; i<m.length; i++){
			if(m[i].getName().indexOf("get")!=0)continue;
			methodGetSet(m[i], obj, p, lazyObject, excludeMethod);
		}
	}

	/**
	 * 校验是否是不需要加载的方法
	 * 
	 * @param String methodName, String[] excludeMethod
	 * @return boolean
	 */
	private static boolean isExcludeMethod(String methodName, String[] excludeMethod) {
		if(excludeMethod == null)return false;
		for(String m : excludeMethod){
			if(methodName.equals(m))return true;
		}
		return false;
	}
	
	/**
	 * GetSet
	 * 
	 * @param Method m, Object obj, Object p, Object lazyObject, String[] excludeMethod
	 * @return boolean
	 */
	private static void methodGetSet(Method m, Object obj, Object p, Object lazyObject, String[] excludeMethod) {
		try {
			if(!(m.invoke(obj) instanceof PersistentBag) && !(m.invoke(obj) instanceof HibernateProxy))return;
			
			if(m.invoke(obj) instanceof PersistentBag){
				p = (PersistentBag)m.invoke(obj);
				Hibernate.initialize(p);
				if(isExcludeMethod(m.getName(), excludeMethod)){
					lazyObject = ((PersistentBag)p).getStoredSnapshot();
				}else{
					lazyObject = ((PersistentBag)p).getValue();
				}
			}else if(m.invoke(obj) instanceof HibernateProxy){
				p = (HibernateProxy)m.invoke(obj);
				Hibernate.initialize(p);
				if(isExcludeMethod(m.getName(), excludeMethod)){
					lazyObject = ((HibernateProxy)p).writeReplace();
				}else{
					lazyObject = ((HibernateProxy)p).getHibernateLazyInitializer().getImplementation();
				}
			}
			obj.getClass().getDeclaredMethod(m.getName().replaceFirst("g", "s"), m.getReturnType()).invoke(obj, lazyObject);
			
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		} catch (SecurityException e) {
			
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			
			e.printStackTrace();
		}
	}
}
