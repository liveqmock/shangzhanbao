package com.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import com.itour.etip.pub.kit.tool.DateJsonValueProcessor;

public class JsonUtilOld {
	private HttpServletRequest request;
	/**
	 * 内置的response对象，由容器注入。
	 */
	private HttpServletResponse response;
	private boolean isYMD = false;

	public JsonUtilOld(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param isYMD
	 *            指定时间格式是否为yyyy-MM-dd 否则为yyyy-MM-dd HH:mm
	 */
	public JsonUtilOld(HttpServletRequest request,
			HttpServletResponse response, boolean isYMD) {
		this.request = request;
		this.response = response;
		this.isYMD = isYMD;

	}

	private static final String contentType = "text/json;charset=UTF-8";

	// 替换不规则字符的函数
	public String replace(String source, String oldString, String newString) {
		StringBuffer output = new StringBuffer();
		int lengthOfSource = source.length();
		int lengthOfOld = oldString.length();
		int posStart = 0;
		int pos; //
		while ((pos = source.indexOf(oldString, posStart)) >= 0) {
			output.append(source.substring(posStart, pos));
			output.append(newString);
			posStart = pos + lengthOfOld;
		}
		if (posStart < lengthOfSource) {
			output.append(source.substring(posStart));
		}
		return output.toString();
	}

	/**
	 * ***********************************
	 * 以下部分處理jason轉換*************************
	 * *****************************************************
	 */
	/**
	 * @param response
	 * @param obj
	 *            要转成json的java对象
	 * @param delparam
	 *            在从java对象转成json对象时，要剔除的多余属性
	 * @param isAppendSuccess
	 *            树节点时必须为false
	 *            是否在json对象中附加success:true,data:[]属性,否则直接返回java转成的对象
	 * @param isShowJsonStr
	 *            是否控制台打印java转成的json对象
	 */
	public void object2JsonForymd(Object list, List delparam,
			boolean isAppendSuccess, boolean isShowJsonStr) {
		response.setContentType(contentType);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));

		JSONArray jsonObj = JSONArray.fromObject(list, jsonConfig);

		if (delparam != null && delparam.size() > 0) {
			for (int i = 0; i < delparam.size(); i++)
				jsonObj.remove((String) delparam.get(i));
		}
		if (isShowJsonStr) {
			String jstr = jsonObj.toString();

			jstr = replace(jstr, "},{", ",");

		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String jstr = jsonObj.toString();
			jstr = replace(jstr, "},{", ",");
			if (!isAppendSuccess) {

				out.write(jstr.substring(1, jstr.length() - 1));
			} else {

				out.write("{success:true,data:"
						+ jstr.substring(1, jstr.length() - 1) + "}");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	/**
	 * 把线性结构对象如(List,Array)转成json
	 * 
	 * @param response
	 * @param obj
	 *            数组或List
	 * @param delparam
	 *            需要剔除的元素列表，使不在json对象中
	 * @param isAppendSuccess
	 *            树节点时必须为false
	 *            是否在json对象中附加success:true,data:[]属性,否则直接返回java转成的对象
	 * @param isShowJsonStr
	 *            是否控制台打印java转成的json对象
	 * @return
	 */
	public void jsonFromListForyyd(Object list, List delparam,
			boolean isAppendSuccess, boolean isShowJsonStr) {
		response.setContentType(contentType);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));

		JSONArray jsonObj = JSONArray.fromObject(list, jsonConfig);
		if (delparam != null && delparam.size() > 0) {
			for (int i = 0; i < delparam.size(); i++)
				jsonObj.remove((String) delparam.get(i));
		}
		if (isShowJsonStr) {

		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (!isAppendSuccess) {
				out.write(jsonObj.toString());
			} else {
				out.write("{success:true,data:" + jsonObj.toString() + "}");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();

	}

	/**
	 * ***********************************
	 * 以下部分處理jason轉換*************************
	 * *****************************************************
	 */
	/**
	 * @param response
	 * @param obj
	 *            要转成json的java对象
	 * @param delparam
	 *            在从java对象转成json对象时，要剔除的多余属性
	 * @param isAppendSuccess
	 *            树节点时必须为false
	 *            是否在json对象中附加success:true,data:[]属性,否则直接返回java转成的对象
	 * @param isShowJsonStr
	 *            是否控制台打印java转成的json对象
	 */
	public void object2Json(Object list, List delparam,
			boolean isAppendSuccess, boolean isShowJsonStr) {
		response.setContentType(contentType);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));

		JSONArray jsonObj = JSONArray.fromObject(list, jsonConfig);

		if (delparam != null && delparam.size() > 0) {
			for (int i = 0; i < delparam.size(); i++)
				jsonObj.remove((String) delparam.get(i));
		}
		if (isShowJsonStr) {
			String jstr = jsonObj.toString();

			jstr = replace(jstr, "},{", ",");
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String jstr = jsonObj.toString();
			jstr = replace(jstr, "},{", ",");
			if (!isAppendSuccess) {
				out.write(jstr.substring(1, jstr.length() - 1));
			} else {
				out.write("{success:true,data:"
						+ jstr.substring(1, jstr.length() - 1) + "}");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	/**
	 * 把线性结构对象如(List,Array)转成json
	 * 
	 * @param response
	 * @param obj
	 *            数组或List
	 * @param delparam
	 *            需要剔除的元素列表，使不在json对象中
	 * @param isAppendSuccess
	 *            树节点时必须为false
	 *            是否在json对象中附加success:true,data:[]属性,否则直接返回java转成的对象
	 * @param isShowJsonStr
	 *            是否控制台打印java转成的json对象
	 * @return
	 */
	public void jsonFromList(Object list, List delparam,
			boolean isAppendSuccess, boolean isShowJsonStr) {
		response.setContentType(contentType);
		JsonConfig jsonConfig = new JsonConfig();
		if (isYMD) {
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd"));
			jsonConfig.registerJsonValueProcessor(java.sql.Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd"));
			jsonConfig.registerJsonValueProcessor(java.sql.Timestamp.class,
					new DateJsonValueProcessor("yyyy-MM-dd"));
		} else {
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
			jsonConfig.registerJsonValueProcessor(java.sql.Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
			jsonConfig.registerJsonValueProcessor(java.sql.Timestamp.class,
					new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
		}
		// //////////////////////////////////////////////////////////////
		// JSONObject jsonObj1 = new JSONObject();
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				if (name.equals("devAttMap") || name.equals("formAttMap")
						|| name.equals("devModelForm")
						|| name.equals("formModelForm")) {
					return true;
				} else {
					return false;
				}
			}
		});
		JSONArray jsonObj = JSONArray.fromObject(list, jsonConfig);

		// /////////////////////////////////////////////////////////////

		// JSONArray jsonObj = JSONArray.fromObject(list, jsonConfig);
		if (delparam != null && delparam.size() > 0) {
			for (int i = 0; i < delparam.size(); i++)
				jsonObj.remove((String) delparam.get(i));
		}

		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (!isAppendSuccess) {
				out.write(jsonObj.toString());
				System.out.println(jsonObj.toString());
			} else {
				out.write("{success:true,data:" + jsonObj.toString() + "}");
				System.out.println("{success:true,data:" + jsonObj.toString()
						+ "}");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();

	}

	/**
	 * 把bean转成json
	 * 
	 * @param response
	 * @param obj
	 *            bean
	 * @param delparam
	 *            需要剔除的元素列表，使不在json对象中
	 * @param isShowJsonStr
	 *            是否命令行显示json对象
	 * @return
	 */
	public void jsonFormObj(Object obj, List delparam, boolean isAppendSuccess,
			boolean isShowJsonStr) {
		response.setContentType(contentType);
		JsonConfig jsonConfig = new JsonConfig();
		if (isYMD) {
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd"));
		} else {
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
		}
		JSONObject jsonObj = JSONObject.fromObject(obj, jsonConfig);

		if (delparam != null && delparam.size() > 0) {
			for (int i = 0; i < delparam.size(); i++)
				jsonObj.remove((String) delparam.get(i));
		}
		if (isShowJsonStr) {
			// System.out.println("jsonObj.toString "+jsonObj.toString());
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (!isAppendSuccess) {
				out.write(jsonObj.toString());
			} else {
				out.write("{success:true,data:" + jsonObj.toString() + "}");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();

	}

	/**
	 * 把bean转成json
	 * 
	 * @param obj
	 * @param delparam
	 *            需要剔除的元素列表，使不在json对象中
	 * @param addProperty
	 *            需要额外添加的字段
	 * @param isAppendSuccess
	 *            是否输出success:true
	 * @param isShowJsonStr
	 *            是否命令行显示json对象
	 */
	public void jsonFormObj(Object obj, List delparam, Map addProperty,
			boolean isAppendSuccess, boolean isShowJsonStr) {
		response.setContentType(contentType);
		JsonConfig jsonConfig = new JsonConfig();
		if (isYMD) {
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd"));
		} else {
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
		}
		JSONObject jsonObj = JSONObject.fromObject(obj, jsonConfig);

		if (delparam != null && delparam.size() > 0) {
			for (int i = 0; i < delparam.size(); i++)
				jsonObj.remove((String) delparam.get(i));
		}
		if (addProperty != null) {
			Set list = addProperty.keySet();
			for (Iterator it = list.iterator(); it.hasNext();) {
				String key = (String) it.next();
				jsonObj.accumulate(key, addProperty.get(key));
			}
		}
		if (isShowJsonStr) {
			// System.out.println("jsonObj.toString "+jsonObj.toString());
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (!isAppendSuccess) {
				out.write(jsonObj.toString());
			} else {
				out.write("{success:true,data:" + jsonObj.toString() + "}");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();

	}

	/** 调用set方法 */
	private void invokeSetMethod(Field f, Object param, Object value)
			throws Exception {
		String fName = f.getName();
		StringBuffer buf = new StringBuffer();
		buf.append("set");
		buf.append(fName.substring(0, 1).toUpperCase());
		buf.append(fName.substring(1));
		String mName = buf.toString();
		Class[] pm = new Class[1];
		pm[0] = f.getType();
		Object[] in = new Object[1];
		in[0] = value;
		Method method = param.getClass().getDeclaredMethod(mName, pm);
		method.invoke(param, in);
	}

	/**
	 * 自动填充bean
	 * 
	 * @param request
	 * @param list
	 *            不需要赋值到bean的属性列表
	 * @param bean
	 *            要进行set的bean对象引用
	 * @return
	 */
	public Object autoFillBean(List list, Object bean) {
		Class c = bean.getClass();
		Map map = new HashMap();
		map.putAll(request.getParameterMap());
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (map.containsKey((String) list.get(i)))
					map.remove((String) list.get(i));
			}
		}
		Set set = map.keySet();
		Iterator it = set.iterator();
		Field f = null;
		String temp = "";
		while (it.hasNext()) {
			try {
				temp = (String) it.next();

				f = c.getDeclaredField(temp);
				String str = request.getParameter(temp);
				invokeSetMethod(f, bean, str);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bean;
	}

	/**
	 * 直接返回josn串
	 * 
	 * @param response
	 * @param s
	 */
	public void returnResponseJsonText(HttpServletResponse response, String s) {
		response.setContentType(contentType);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	/**
	 * 用于分页显示
	 * 
	 * @param objList
	 *            -类型Object[] ,要求0为结果集合(Collection) 1总共记录数(Integer)
	 */
	public void pageScrollOut(Object[] objList) {
		response.setContentType(contentType);
		PrintWriter out = null;
		Collection cl = (List) objList[0];
		Integer rowCount = (Integer) objList[1];
		// 当为空时为了不影响数据显示按照最多处理.
		int totolRowInt = rowCount == null ? Integer.MAX_VALUE : rowCount
				.intValue();
		JsonConfig jsonConfig = new JsonConfig();
		if (isYMD) {
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd"));
		} else {
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
		}
		JSONArray jsonObj = JSONArray.fromObject(cl, jsonConfig);
		try {
			out = response.getWriter();
			out.write("{success:true,total:" + totolRowInt + ",data:"
					+ jsonObj.toString() + "}");
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	/**
	 * 操作失败
	 * 
	 * @param response
	 */
	public void returnFailure() {
		response.setContentType(contentType);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write("{success:false}");
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	/** 操作成功 */
	public void returnTrue() {
		response.setContentType(contentType);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write("{success:true}");
			// //System.out.println("{success:true}");
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	};

	/** 输出简单字符窜 */
	public void simpleOut(String str) {
		response.setContentType(contentType);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	};

	/** 输出简单字符窜 */
	public void simpleOutWithData(String str) {
		response.setContentType(contentType);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write("{data:" + str + "}");
			// //System.out.println("{data:"+str+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	};

	/**
	 * ************************************************** jason部分结束
	 * ************************************************************
	 */
	/**
	 * 
	 */

	/** 根据类型调用set方法 */
	private void invokeSetObjectMethod(Field f, Object param, Object value)
			throws Exception {
		String fName = f.getName();
		StringBuffer buf = new StringBuffer();
		buf.append("set");
		buf.append(fName.substring(0, 1).toUpperCase());
		buf.append(fName.substring(1));
		String mName = buf.toString();
		Class[] pm = new Class[1];
		pm[0] = f.getType();
		Object[] in = new Object[1];
		if ("java.lang.String".equals(pm[0].getName())) {
			in[0] = value;
		} else if ("java.lang.Long".equals(pm[0].getName())) {
			try {
				in[0] = new Long((String) value);
			} catch (Exception ee) {
				in[0] = new Long("0");
			}
		} else if ("java.util.Date".equals(pm[0].getName())) {
			try {
				java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat(
						"yyyy-MM-dd HH:mm");

				in[0] = sf.parse((String) value);
			} catch (Exception ee) {
				java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat(
						"yyyy-MM-dd");
				in[0] = sf.parse((String) value);
			}
		} else {
			in[0] = value;
		}

		Method method = param.getClass().getDeclaredMethod(mName, pm);
		method.invoke(param, in);
	}

	/**
	 * 自动填充bean
	 * 
	 * @param bean
	 *            要进行set的bean对象引用
	 * @return
	 */
	public Object autoFillBeanByType(Object bean) {
		Class c = bean.getClass();

		Field[] f = c.getDeclaredFields();
		String temp = "";
		for (int i = 0; i < f.length; i++) {
			try {
				String str = request.getParameter(f[i].getName());
				invokeSetObjectMethod(f[i], bean, str);

			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return bean;
	}

	/**
	 * 把bean转成JSONObject
	 * 
	 * @param obj
	 * @param delparam
	 *            需要剔除的元素列表，使不在json对象中
	 * @param addProperty
	 *            需要额外添加的字段
	 * @param isAppendSuccess
	 *            是否输出success:true
	 * @param isShowJsonStr
	 *            是否命令行显示json对象
	 */
	public JSONObject getJSONOBjectByObj(Object obj, List delparam,
			Map addProperty, boolean isAppendSuccess) {
		JsonConfig jsonConfig = new JsonConfig();
		if (isYMD) {
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd"));
		} else {
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
		}
		JSONObject jsonObj = JSONObject.fromObject(obj, jsonConfig);

		if (delparam != null && delparam.size() > 0) {
			for (int i = 0; i < delparam.size(); i++)
				jsonObj.remove((String) delparam.get(i));
		}
		if (addProperty != null) {
			Set list = addProperty.keySet();
			for (Iterator it = list.iterator(); it.hasNext();) {
				String key = (String) it.next();
				jsonObj.accumulate(key, addProperty.get(key));
			}
		}
		try {
			if (isAppendSuccess) {
				JSONObject jsObj = new JSONObject();
				jsObj.accumulate("success", true);
				jsObj.accumulate("data", jsonObj);
				return jsObj;
			}

		} catch (Exception e) {

		}
		return jsonObj;
	}
}
