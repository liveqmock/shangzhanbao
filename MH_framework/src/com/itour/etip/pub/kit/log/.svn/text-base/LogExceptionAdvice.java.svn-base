package com.itour.etip.pub.kit.log;

import org.springframework.aop.ThrowsAdvice;

import com.itour.etip.pub.kit.jms.JMSLog;
import com.itour.etip.pub.kit.jms.JMSMessage;
import com.itour.etip.pub.kit.tool.DateTool;

/**
 * <p>Title: 发生Excepion例外时的日志切面</p>
 * <p>Description: 发生Excepion例外时的日志切面，用于记录发生Excepion例外时的日志。</p>
 * <p>Copyright: Copyright (C), 2009-2010, eTIP </p>
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-04-29
 */
public class LogExceptionAdvice implements ThrowsAdvice {
	
	/**
	 * 当发生Excepion例外时，记录日志。
	 * @param Exception例外
	 */
	public void afterThrowing(Exception ex) {
		//得到异常的首个元素
		StackTraceElement stackTraceElement=ex.getStackTrace()[0];
		//文件名
		String File=stackTraceElement.getFileName();
		//出错行号
		int Line=stackTraceElement.getLineNumber();
		//出错方法
		String Method=stackTraceElement.getMethodName();
		
		JMSLog jmsLog=new JMSLog();
//		jmsLog.setId(DateTool.getDateTime("yyyyMMddHHmmssSSS"));
		jmsLog.setTime(DateTool.getNow());
		jmsLog.setLoglevel(JMSLog.LEVEL_FATAL);
		jmsLog.setType("DBLog");
		jmsLog.setUserid("ID001");
		jmsLog.setMethod(Method);
		jmsLog.setContent(ex.getMessage());
		JMSMessage jmsMsg=new JMSMessage();
		//jmsMsg.setMessageType(JMSMessage.MESSAGETYPE_DBLOG);
		jmsMsg.setMessageContent(jmsLog);
		LogUtil.info("eTIP", jmsMsg);
	}

}
