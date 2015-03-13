package com.itour.etip.pub.frame;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.kit.exception.ETIPError;

public class FrmService implements IService {
	
	

	
	
	/**
	 * 去掉懒加载的数据
	 * 
	 * @param data
	 */
	protected void removeLazy1(FrmData data) {
		// 只有未处理状态才进行处理，否则直接返回。
		if(data.lazyStatus!=0){
			return;
		}
		
		try {
			Field[] fields = data.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (java.util.List.class.isAssignableFrom(field.getType())) {
					// 需要将该属性值设置为null
					String fieldName = field.getName();
					String setMethodName = "set"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);
				//System.out.println(fieldName+":"+setMethodName);
					Method setMethod = data.getClass().getMethod(setMethodName,
							new Class[] { java.util.List.class });
					setMethod.invoke(data,new Object[]{null});

				}
				if (FrmData.class.isAssignableFrom(field.getType())) {
					// 需要将该属性值设置为null
					String fieldName = field.getName();
					String setMethodName = "set"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);
					Method setMethod = data.getClass().getMethod(setMethodName,
							new Class[] { field.getType()});
					setMethod.invoke(data,new Object[]{null});
				}
			}
			data.lazyStatus=2;
		} catch (Exception ex) {
			throw new ETIPError("removeLazyError", ex);
		}
	}

	/**
	 * 去掉列表中的所有lazy数据
	 * 
	 * @param datas
	 */
	protected void removeLazy1(List datas) {
		for (Object dataObj : datas) {
			removeLazy1((FrmData) dataObj);
		}
	}

	
	
	protected void retrieveLazy1(List datas,boolean recursivly){
		for (Object dataObj : datas) {
			retrieveLazy1((FrmData) dataObj,recursivly);
		}
	}

	/**
	 * 递归加载懒加载数据,如果数据库设计不好，可能是死循环
	 */
	protected void retrieveLazy1(FrmData data,boolean recursibly) {
		/*只有未处理状态才处理，否则直接返回*/
		if(data.lazyStatus!=0){
			return;
		}
		
		try {
			Field[] fields = data.getClass().getDeclaredFields();
			for (Field field : fields) {
				//列表属性，获取值
				if (java.util.List.class.isAssignableFrom(field.getType())) {
					// 需要将该属性值设置为null
					String fieldName = field.getName();
					String setMethodName = "get"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);
					Method getMethod = data.getClass().getMethod(setMethodName);
					if(recursibly){
						List fieldValues = (List)getMethod.invoke(data, null);
						retrieveLazy1(fieldValues,recursibly);
					}
					
					
				}
				//一对一关联对象，则获取一次
				if (FrmData.class.isAssignableFrom(field.getType())) {
					// 需要将该属性值设置为null
					String fieldName = field.getName();
					String setMethodName = "get"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);
					Method getMethod = data.getClass().getMethod(setMethodName);
					getMethod.invoke(data, null);
					if(recursibly){
						List fieldValues = (List)getMethod.invoke(data, null);
						retrieveLazy1(fieldValues,recursibly);
					}
				}
				
			}
		} catch (Exception ex) {
			throw new ETIPError("retrieveLazyError", ex);
		}
	}

}
