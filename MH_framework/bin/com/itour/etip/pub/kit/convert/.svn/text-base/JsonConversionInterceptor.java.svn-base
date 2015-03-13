/********************************************************
 Copyright (C), 2009-2010, eTIP.
 File name:    com/itour/etip/kit/convert/JsonConversionInterceptor.java
 Description:  JSON拦截器
 Author: TengXiaocong      Version:  1.0.0  Date: 2009.4.14
 ***********************************************************/
package com.itour.etip.pub.kit.convert;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.kit.exception.ETIPError;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class JsonConversionInterceptor implements Interceptor {

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		if (!(actionInvocation.getAction() instanceof FrmAction)) {
			String result = actionInvocation.invoke();
			return result;
		}
		HttpServletRequest request = ((FrmAction) actionInvocation.getAction()).getRequest();
		String uri = request.getRequestURI();
		String root = request.getContextPath();
		// 符合框架，采用拦截器
		
		try {
			//对json格式参数进行处理
			strToJson(actionInvocation);
			String value = actionInvocation.invoke();
			//对json格式返回值进行处理
			jsonToStr(actionInvocation);
			return value;
		} catch (ETIPException exception) {
			throw exception;
		} catch (ETIPError error) {
			//如果用户未登录，跳转到登陆页面，并把当前request参数保存到session，配合ParametersMappingFilter处理
			if(error.getErrorCode().equals("UnLoginedUser")){
				if(request.getMethod().equals("GET")&&request.getQueryString()!=null){
					request.getSession().setAttribute("targetURL", uri+"?"+request.getQueryString());
				}else{
					request.getSession().setAttribute("targetURL", uri);
				}
				Map<String, String> map = new HashMap<String, String>();
				Iterator<String> keys = request.getParameterMap().keySet().iterator();
				while (keys.hasNext()) {
					String key = keys.next();
					String[] strings = (String[]) request.getParameterMap().get(key);
					for (int i = 0; i < strings.length; i++) {
						String placeholder = "~~~~~~~~~~~~~~~~~~~~~~~~~~";
						map.put(placeholder.substring(placeholder.length()-i)+key, strings[i]);
					}
				}
				request.getSession().setAttribute("targetReqParam", map);
				
				String actionName = actionInvocation.getAction().getClass().getName();
				//判断是不是管理员
				if(actionName.indexOf("com.sys.")>-1 || actionName.indexOf("operating")>-1 || uri.indexOf("frame/key/oprating")>-1){
					return "toAdminLogin";
				}
				return "toLogin";
			}
			throw error;
		} catch (Exception ex) {
			// removeRepeatTag(actionInvocation);
			ETIPError error = new ETIPError("etip_001", ex);
			throw error;
		}
	}

	private static HashMap repeatTag = new HashMap();

	/**
	 * 检查当前请求是否重复调用，如果是重复调用。
	 * 
	 * @param actionInvocation
	 * @return
	 */
	private boolean checkRepeatTag(ActionInvocation actionInvocation) {
		String etipUserID = null;
		try {
			etipUserID = FrmUser.getUser().etipUserID;
		} catch (Exception ex) {
			// 如果session过期或未登录，不进行重复校验
			return false;
		}
		FrmAction myAction = (FrmAction) actionInvocation.getAction();
		/*
		 * 构造actionName,用于在DesktopRegistry中搜索对应的消息注册表。
		 */
		String requestURI = myAction.getRequest().getRequestURI();
		requestURI = requestURI.substring(requestURI.lastIndexOf("/") + 1);
		String actionClassName = myAction.getClass().getSimpleName();
		String actionName = etipUserID + "_" + actionClassName + "." + requestURI;
		Date lastTime = (Date) repeatTag.get(actionName);
		if (lastTime == null) {
			repeatTag.put(actionName, new Date());

			return false;
		} else {
			// 检查上次调用时间，如果该时间

			return true;
		}
	}

	private void removeRepeatTag(ActionInvocation actionInvocation) {
		String etipUserID = null;
		try {
			etipUserID = FrmUser.getUser().etipUserID;
		} catch (Exception ex) {
			// 如果session过期或未登录，不进行重复校验
			return;
		}
		FrmAction myAction = (FrmAction) actionInvocation.getAction();
		/*
		 * 构造actionName,用于在DesktopRegistry中搜索对应的消息注册表。
		 */
		String requestURI = myAction.getRequest().getRequestURI();
		requestURI = requestURI.substring(requestURI.lastIndexOf("/") + 1);
		String actionClassName = myAction.getClass().getSimpleName();
		String actionName = etipUserID + "_" + actionClassName + "." + requestURI;
		// 检查是否找到actionName,如果找到，那么就去掉
		Object oldDate = repeatTag.get(actionName);
		if (oldDate != null) {

			repeatTag.remove(actionName);
		}

	}

	/**
	 * 前置拦截方法，用于将页面传过来的json串转换成JSONObject或JSONArray
	 * 
	 * @param actionInvocation
	 */
	public void strToJson(ActionInvocation actionInvocation) {
		if (!(actionInvocation.getAction() instanceof FrmAction)) {
			return;
		}

		HttpServletRequest request = ((FrmAction) actionInvocation.getAction()).getRequest();
		String jsonData = request.getParameter("jsonData");

		if (jsonData == null || jsonData.trim().length() == 0) {
			return;
		}
		String[] dateFormats = new String[] { "yyyy-MM-dd" };
		JSONUtils.getMorpherRegistry().registerMorpher(new EtipDateMorpher(dateFormats));
		// 返回值可能是数组，也可能是一个对象，首先判断是否是数组，如果取数组出错，那么取为对象。
		Object rv = null;
		try {
			//System.out.println("jsonData:" + jsonData);
			if (jsonData.startsWith("[")) {
				rv = JSONArray.fromObject(jsonData);
				((FrmAction) (actionInvocation.getAction())).setJson(rv);
			} else if (jsonData.startsWith("{")) {
				rv = JSONObject.fromObject(jsonData);
				/*
				 * 此处默认添加，创建人，创建日期，最后更新人员，最后更新日期。 要求数据对象中的创建人、创建日期、最后更新人员、最后更新日期
				 * 分别是：creator,createDate,lastUptUser,lastUptDate
				 */
				FrmAction frmAction = (FrmAction) actionInvocation.getAction();

				String etipUserID = null;
				try {
					etipUserID = FrmUser.getUser().etipUserID;
				} catch (Exception ex) {
					// 如果未登录，那么设置一个缺省值
				}

				JSONObject valueMap = (JSONObject) rv;
				// 取得当前用户，根据当前用户设置
				if (valueMap.get("creator") == null) {
					valueMap.put("creator", etipUserID);
				}
				if (valueMap.get("createDate") == null) {
					valueMap.put("createDate", new java.util.Date());
				}
				// 无论什么情况，都添加最后更新人员和更新日期
				valueMap.put("lastUptUser", etipUserID);
				valueMap.put("lastUptDate", new java.util.Date());
				((FrmAction) (actionInvocation.getAction())).setJson(rv);
			} else {
				throw new ETIPError("unsupportedJSONFormat");
				// System.out.println("unsupported JSON format1：" + jsonData);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ETIPError("unsupportedJSONFormat");
			// System.out.println("unsupported JSON format2：" + jsonData);
		}

	}

	/**
	 * 后置拦截方法，用于将后台传过来的JSON实体转换成字符串
	 * 
	 * @param actionInvocation
	 */
	public void jsonToStr(ActionInvocation actionInvocation) {
		if (actionInvocation.getAction() instanceof FrmAction) {
			//判断如果action为取图片的action那么不执行拦截   by dengling
			if(actionInvocation.getAction().getClass().getSimpleName().equals("GoodPictureAction")
					|| actionInvocation.getAction().getClass().getSimpleName().equals("SettlementPrintAction")
					|| actionInvocation.getAction().getClass().getSimpleName().equals("DocumentPrintAction") 
					|| actionInvocation.getAction().getClass().getSimpleName().equals("BudgetPrintAction") ){
				return;
			}
			HttpServletRequest request = ((FrmAction) actionInvocation.getAction()).getRequest();
			HttpServletResponse response = ((FrmAction) actionInvocation.getAction()).getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			// request.setAttribute("i18n_locale",
			// request.getLocale().toString());
			try {
				PrintWriter printWriter = response.getWriter();
				// 如果Action继承了FrmAction作为父类，那么判断是数组还是对象，转换后向页面输出字符串
				Object json = ((FrmAction) (actionInvocation.getAction())).getJson();
				if (json != null) {
					if (json instanceof String) {
						printWriter.print(json);
					} else if (json instanceof JSONObject) {
						JSONObject jsonObject = (JSONObject) json;
						printWriter.println(jsonObject.toString());
					} else if (json instanceof JSONArray) {
						JSONArray jsonArray = (JSONArray) json;
						printWriter.println(jsonArray.toString());
					} else {
						return;
					}
				} else {
					return;
				}

				// 如果Action没有声明FrmAction作为父类，那么就没有getJson方法，将参数作为attribute传递
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			return;
		}
	}

	public void destroy() {
	}

	public void init() {
	}

}
