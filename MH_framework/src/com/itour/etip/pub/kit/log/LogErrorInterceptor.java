package com.itour.etip.pub.kit.log;

import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.kit.jms.JMSLog;
import com.itour.etip.pub.kit.jms.JMSMessage;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * <p>
 * Title: 日志信息JavaBean
 * </p>
 * <p>
 * Description: 本拦截器是缺省的拦截器，所有Action执行时都需要执行本拦截器。 通过本拦截器执行后记录日志信息
 * </p>
 * <p>
 * Copyright: Copyright (C), 2009-2010, eTIP
 * </p>
 * 
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-03-20
 */
public class LogErrorInterceptor implements Interceptor {

	/**
	 * 拦截器日志，主要是拦截struts请求时，自动保存日志，此拦截器日志，仅仅记录错误日志，即当
	 * 应用系统请求发生例外时，就记录日志，该日志记录到错误文件中。
	 * 
	 * @param invocation
	 *            当前调用的方法。
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			String result = invocation.invoke();
			return result;
		} catch (Exception ex) {
			// 在Action调用后
			JMSLog jmsLog = new JMSLog();
			// jmsLog.setId(DateTool.getDateTime("yyyyMMddHHmmssSSS"));
			jmsLog.setTime(new java.util.Date());
			jmsLog.setLoglevel(JMSLog.LEVEL_INFO);
			jmsLog.setType("intercept");
			
			String etipUserID = null;
			try{
				etipUserID = FrmUser.getUser().etipUserID;
			}catch(Exception e){
				//此处不处理。
			}
			jmsLog.setUserid(etipUserID);
			jmsLog.setMethod(invocation.getAction().toString());
			jmsLog.setContent(ex.toString());
			JMSMessage jmsMsg = new JMSMessage();
			//jmsMsg.setMessageType(JMSMessage.MESSAGETYPE_DBLOG);
			jmsMsg.setMessageContent(jmsLog);
			LogUtil.info("eTIPError", jmsMsg, ex);
			throw ex;
		}
		

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

}