package com.itour.etip.pub.kit.log;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.itour.etip.pub.frame.FrmData;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.kit.jms.JMSLog;
import com.itour.etip.pub.kit.jms.JMSMessage;
import com.itour.etip.pub.kit.tool.DateTool;

/**
 * <p>
 * Title: 方法调用前的日志切面
 * </p>
 * <p>
 * Description: 方法调用前的日志切面，用于记录调用前日志。
 * </p>
 * <p>
 * Copyright: Copyright (C), 2009-2010, eTIP
 * </p>
 * 
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-04-29
 */
public class LogMethodBeforeAdvice implements MethodBeforeAdvice {

	/**
	 * 在方法调用前调用。
	 * 
	 * @param method被调用的方法
	 * @param args
	 *            方法参数
	 * @param target
	 *            当前对象,可能为null
	 * @throws Throwable
	 *             抛出例外时，将中止本操作.
	 */
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		JMSLog jmsLog = new JMSLog();
		jmsLog.setTime(DateTool.getNow());
		jmsLog.setLoglevel(JMSLog.LEVEL_INFO);

		jmsLog.setType("DBLog");// 此处标识为数据库日志
		jmsLog.setUserid(FrmUser.getUser().etipOperatorId);
		jmsLog.setMethod("before invoke:"+method.getName());
		// 此处将方法参数作为日志内容。
		String content = "";
		if (args != null) {
			for (Object arg : args) {
				if (arg instanceof FrmData) {
					content += ((FrmData) arg).toMyString();
				}
				else {
					content += arg.toString();
				}
			}
		}
		jmsLog.setContent(content);
		JMSMessage jmsMsg = new JMSMessage();
		//jmsMsg.setMessageType(JMSMessage.MESSAGETYPE_DBLOG);
		jmsMsg.setMessageContent(jmsLog);
		// 此处记录异步日志，而不是直接访问数据库
		LogUtil.info("eTIPJMS", jmsMsg);
	}

}
