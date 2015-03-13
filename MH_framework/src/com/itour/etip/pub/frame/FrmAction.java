/********************************************************
 Copyright (C), 2009-2011, gomai.
 File name:    com/itour/etip/base/FrmAction.java
 Description:  框架基础Action，所有的Action都要继承此Action
 Author: txc      Version:  1.0.0  Date: 2009.4.8
 ***********************************************************/
package com.itour.etip.pub.frame;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.collection.PersistentBag;
import org.hibernate.proxy.HibernateProxy;

import com.itour.etip.pub.kit.cache.CacheUtil;
import com.itour.etip.pub.kit.convert.ParameterRequestWrapper;
import com.itour.etip.pub.kit.exception.ETIPError;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.pub.kit.exception.IETIPException;
import com.itour.etip.pub.kit.json.JsonUtil;
import com.itour.etip.pub.kit.tool.DateTool;

public abstract class FrmAction implements SessionAware, ServletRequestAware,
		ServletResponseAware {

	protected String key = null;
	
	/**
	 * 日志内容
	 */
	private String context;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	protected Object json = null;

	public Object getJson() {
		return json;
	}

	public void setJson(Object json) {
		if (json instanceof String) {
			json = json.toString().replaceAll("\r\n", "");
		}
		this.json = json;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = new ParameterRequestWrapper(request);
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<Object, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<Object, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	/**
	 * 内置的request对象，由容器注入。
	 */
	protected ParameterRequestWrapper request;

	/**
	 * 内置的response对象，由容器注入。
	 */
	protected HttpServletResponse response;

	/**
	 * 内置的session对象，由容器注入。
	 */
	protected Map<Object, Object> sessionMap;

	/**
	 * 设置Session Map对象，由容器调用。
	 * 
	 * @param att
	 *            被设置的Session Map对象。
	 * 
	 */
	public void setSession(Map att) {
		this.sessionMap = att;
	}

	/**
	 * 设置HttpServletRequest实例，由容器调用
	 * 
	 * @param request
	 *            被设置的HttpServletRequest实例
	 * 
	 * 
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = new ParameterRequestWrapper(request);
	}

	/**
	 * 设置response实例，供容器调用
	 * 
	 * @param response
	 *            被设置的HttpServletResponse实例
	 * 
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * 将列表转化为json串
	 * 
	 * @param pageRoll
	 *            分页控件
	 * @param list
	 *            结果列表
	 * @param containDate
	 *            是否包含日期
	 * @return
	 */
	protected String getListJsonStr(PageRoll pageRoll, List list) {
		if (pageRoll == null) {
			pageRoll = new PageRoll();
			pageRoll.setPageSize(10);
			pageRoll.setStartRow(0);
			
			if(list!=null){
				pageRoll.setTotalRows(list.size());
			}
		}
		StringBuffer sb = new StringBuffer();
		// 处理无值的情况
		if (list == null || list.size() == 0) {
			sb.append("{'items':[]");
			sb.append(",'results':");
			sb.append(pageRoll.getTotalRows());
			sb.append("}");
			return sb.toString();
		}
		// 以下处理有值的情况
		JSONArray jsonArray = null;
		// 此处是否是否存在日期类型
		boolean containDate = false;
		Field[] fields = list.get(0).getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.getType().getName().equals("java.util.Date")) {
				containDate = true;
				break;
			}
		}
		if (containDate) {
			try {
				jsonArray = DateTool.getJSONArray(list, "yyyy-MM-dd");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			jsonArray = JSONArray.fromObject(list);
		}
		// 以下获取cache配置项目，实现自动转换。
		String className = list.get(0).getClass().getSimpleName();
		// 此处只是需要配置哪个字段采用哪个cache，专供后台使用。
		JSONArray names = null;
		Map objectCacheMap = CacheUtil.dataCache
				.getDataMap("ObjectCacheMap");

		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject oneRecord = jsonArray.getJSONObject(i);
			if (names == null) {
				names = oneRecord.names();
			}
			for (int j = 0; j < names.size(); j++) {
				Object name = names.get(j);
				// System.out.println("name:"+name);
				String attrCacheName = (String) objectCacheMap.get(className
						+ "." + name);
				if (attrCacheName == null) {
					continue;
				}
				// 取得属性cache
				Map attrCache = CacheUtil.dataCache
						.getDataMap(attrCacheName);
				// json值
				Object jsonValue = oneRecord.get(name);

				Object captionValue = attrCache.get(jsonValue + "");
				// System.out.println(className+"."+name+"'s cache is
				// "+attrCacheName+":caption of "+jsonValue+" is
				// "+captionValue);
				// 替换值
				oneRecord.put(name, captionValue);
			}
		}

		// JSONArray names = jsonArray.getJSONObject(0).pu;
		// System.out.println("names:"+names);
		sb.append("{'items':");
		if (jsonArray != null) {
			sb.append(jsonArray.toString());
		}
		sb.append(",'results':");
		sb.append(pageRoll.getTotalRows());
		sb.append("}");

		return sb.toString();

	}

	/**
	 * 打印系统异常。当异常为IETIPException异常时，需要取出 真正的异常堆栈信息
	 * 
	 * @param e
	 *            需要打印的异常
	 */
	public void printException(Exception e) {
		if (e instanceof IETIPException) {
			((ETIPError) e).getErrorRoot().printStackTrace();
		} else {
			e.printStackTrace();
		}
	}

	/**
	 * 从缓存中获取值
	 * 
	 * @param cacheName
	 *            缓存名字
	 * @param key
	 *            键值
	 * @return 对应的value
	 */
	public String getValueFromCache(String cacheName, String key) {
		if (key == null) {
			return null;
		}
		return (String) CacheUtil.getInstance().getCacheMap(cacheName).get(key);
	}

	/**
	 * 从缓存中获取值
	 * 
	 * @param cacheName
	 *            缓存名字
	 * @param key
	 *            键值，Integer类型
	 * @return 对应的value
	 */
	public String getValueFromCache(String cacheName, Integer key) {
		if (key == null) {
			return null;
		}
		return getValueFromCache(cacheName, key.toString());
	}

	/**
	 * 从acegi容器中获取用户身份信息，可能存在session的问题。
	 * 
	 * @return frmUser.
	 */
	public FrmUser getFrmUser() {
		FrmUser frmUser = null;
		if (request.getSession().getAttribute("ETIP_FRAME_USER") != null) {
			frmUser = (FrmUser) request.getSession().getAttribute(
					"ETIP_FRAME_USER");
		} else {
			frmUser = FrmUser.getUser();
		}

		if (frmUser == null || frmUser.etipUserID == null
				|| frmUser.etipUserID.equals("")) {
			throw new ETIPException("NoSession");
		}
		return frmUser;
	}

	/**
	 * 删除为空的字段
	 * @param obj
	 * @param beanClass
	 * @return
	 */
	protected JSONObject removeJSONObjectNull(JSONObject obj, Class beanClass) {
		if (obj == null || obj.isNullObject()) {
			return null;
		}
		JSONObject tmpObject = new JSONObject();
		tmpObject = JSONObject.fromObject(obj.toString());
		Field[] fields = beanClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if ((java.util.Date.class).equals(fields[i].getType())
					|| (java.sql.Date.class).equals(fields[i].getType())) {
				String name = fields[i].getName();
				if (tmpObject.has(name)) {
					String str = tmpObject.getString(name);
					if ("".equals(str) || "null".equals(str)
							|| "undefined".equals(str)) {
						tmpObject.remove(name);
					}
				}
			}
		}
		return tmpObject;
	}

	protected JSONArray removeJSONArrayNull(JSONArray array, Class beanClass) {
		if (array == null) {
			return null;
		}
		for (int i = 0; i < array.size(); i++) {
			removeJSONObjectNull(array.getJSONObject(i), beanClass);
		}
		return array;
	}

	/**
	 * 设置代理对象为NULL
	 */
	public void setHibernateProxyToNULL4List(List dataList,
			String[] excludeMethod) {
		if (dataList == null)
			return;
		Iterator iterator = dataList.iterator();
		while (iterator.hasNext()) {
			setHibernateProxyToNULL4Object(iterator.next(), excludeMethod);
		}
	}

	/**
	 * 设置代理对象为NULL
	 */
	public void setHibernateProxyToNULL4Object(Object dataObject,
			String[] excludeMethod) {
		if (dataObject == null)
			return;
		Method[] m = dataObject.getClass().getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			if (m[i].getName().indexOf("get") != 0)
				continue;
			try {
				if (isExcludeMethod(m[i].getName(), excludeMethod))
					continue;
				if (m[i].invoke(dataObject) instanceof PersistentBag
						|| m[i].invoke(dataObject) instanceof HibernateProxy) {
					dataObject.getClass().getDeclaredMethod(
							m[i].getName().replaceFirst("g", "s"),
							m[i].getReturnType()).invoke(dataObject,
							new Object[1]);
				}
			} catch (IllegalArgumentException e) {
				
				e.printStackTrace();
			} catch (SecurityException e) {
				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				
				e.printStackTrace();
			}
		}
	}

	private boolean isExcludeMethod(String methodName, String[] excludeMethod) {
		if (excludeMethod == null)
			return false;
		for (String m : excludeMethod) {
			if (methodName.equals(m))
				return true;
		}
		return false;
	}

	/**
	 * 去掉懒加载的数据
	 * 
	 * @param data
	 */
	protected void removeLazy(FrmData data) {
		// 只有未处理状态才进行处理，否则直接返回。
		if (data.lazyStatus != 0) {
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
					// System.out.println(fieldName+":"+setMethodName);
					Method setMethod = data.getClass().getMethod(setMethodName,
							new Class[] { java.util.List.class });
					setMethod.invoke(data, new Object[] { null });

				}
				if (FrmData.class.isAssignableFrom(field.getType())) {
					// 需要将该属性值设置为null
					String fieldName = field.getName();
					String setMethodName = "set"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);
					Method setMethod = data.getClass().getMethod(setMethodName,
							new Class[] { field.getType() });
					setMethod.invoke(data, new Object[] { null });
				}
			}
			data.lazyStatus = 2;
		} catch (Exception ex) {
			throw new ETIPError("removeLazyError", ex);
		}
	}

	/**
	 * 去掉列表中的所有lazy数据
	 * 
	 * @param datas
	 */
	protected void removeLazy(List datas) {
		for (Object dataObj : datas) {
			removeLazy((FrmData) dataObj);
		}
	}

	protected void retrieveLazy(List datas, boolean recursivly) {
		for (Object dataObj : datas) {
			retrieveLazy((FrmData) dataObj, recursivly);
		}
	}

	/**
	 * 递归加载懒加载数据,如果数据库设计不好，可能是死循环
	 */
	protected void retrieveLazy(FrmData data, boolean recursibly) {
		/* 只有未处理状态才处理，否则直接返回 */
		if (data.lazyStatus != 0) {
			return;
		}

		try {
			Field[] fields = data.getClass().getDeclaredFields();
			for (Field field : fields) {
				// 列表属性，获取值
				if (java.util.List.class.isAssignableFrom(field.getType())) {
					// 需要将该属性值设置为null
					String fieldName = field.getName();
					String setMethodName = "get"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);
					Method getMethod = data.getClass().getMethod(setMethodName);
					if (recursibly) {
						List fieldValues = (List) getMethod.invoke(data, null);
						retrieveLazy(fieldValues, recursibly);
					}

				}
				// 一对一关联对象，则获取一次
				if (FrmData.class.isAssignableFrom(field.getType())) {
					// 需要将该属性值设置为null
					String fieldName = field.getName();
					String setMethodName = "get"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);
					Method getMethod = data.getClass().getMethod(setMethodName);
					getMethod.invoke(data, null);
					if (recursibly) {
						List fieldValues = (List) getMethod.invoke(data, null);
						retrieveLazy(fieldValues, recursibly);
					}
				}

			}
		} catch (Exception ex) {
			throw new ETIPError("retrieveLazyError", ex);
		}
	}

	/**
	 * 获取
	 * @return the context
	 */
	public String getContext() {
		return context;
	}

	/**
	 * 设置
	 * @param context the context to set
	 */
	public void setContext(String context) {
		this.context = context;
	}
	
	
	/**
	 * json数据类型格式化
	 * 
	 */
	public void setResultInfoObjectFormat(Object result) throws Exception{
		JsonConfig jsonConfig = JsonUtil.configJson("yyyy-MM-dd");
		response.getWriter().println(JSONObject.fromObject(result,jsonConfig).toString());
	}
	
	//----author LiuLei----
	/**
	 * 从缓存中获取值
	 * @param cacheName 缓存名字
	 * @param key 键值
	 * @param value 根据Key取值后获得的Map的key
	 * @return 对应的value 字符串类型
	 */
	@SuppressWarnings("unchecked")
	public String getValueFromCache(String cacheName, String key, String value) {
		if (key == null) {
			return null;
		}
		return (String) ((Map)CacheUtil.getInstance().getCacheMap(cacheName).get(key)).get(value);
	}
	
	/**
	 * 获取页面翻页控件的值
	 */
	public PageRoll getPageRollInfo() {
		String tempPage = request.getParameter("page");
		String tempRows = request.getParameter("rows");
		int page = Integer
				.parseInt((tempPage == null || "".equals(tempPage)) ? "1"
						: tempPage) - 1; // 获取从DATAGRID中获取的page的值
		int pageSize = Integer.parseInt((tempRows == null || ""
				.equals(tempRows)) ? "5" : tempRows);// 获取到PAGESIZE的值
		PageRoll pageRoll = new PageRoll();
		pageRoll.setStartRow(page * pageSize);
		pageRoll.setPageSize(pageSize);
		return pageRoll;
	}
	/*
	 * 把分页的total 和 rows 拼接为JSON 格式为："total":30,"rows":[{},{}]
	 * 
	 * @param pageRoll
	 * 
	 * @param brands
	 * 
	 * @return
	 */
	protected Map<String, Object> getCtnJSONMap(PageRoll pageRoll,
			List list) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pageRoll.getTotalRows());
		result.put("rows", list);
		return result;
	}
}
