package com.itour.etip.pub.kit.log;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
import com.itour.etip.pub.kit.jms.JMSLog;
import com.itour.etip.pub.kit.jms.JMSMessage;
import com.itour.etip.pub.kit.tool.DateTool;

/**
 * <p>Title: 方法调用后置的日志切面</p>
 * <p>Description: 方法调用后置的日志切面，用于记录调用后日志。</p>
 * <p>Copyright: Copyright (C), 2009-2010, eTIP </p>
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-04-29
 */
public class LogAfterReturningAdvice implements  AfterReturningAdvice {
	
	/**
	 * 当方法被成功执行后调用
	 * @param returnValue 方法的返回值
	 * @param method 当前被调用的方法
	 * @param args 调用方法的参数。
	 * @param target 当前方法依赖的对象。
	 * @throws Throwable 抛出例外时，将中止本操作.
	 */
	public void afterReturning(Object returnValue, Method method, Object[] args,
			Object target) throws Throwable {
		JMSLog jmsLog=new JMSLog();
		jmsLog.setTime(DateTool.getNow());
		jmsLog.setLoglevel(JMSLog.LEVEL_INFO);
		jmsLog.setType("aop_afterReturning");
	
		jmsLog.setUserid("ID001");
		jmsLog.setMethod(method.getName());
		jmsLog.setContent(target.getClass().getName()+"."+method.getName()+"("+args.toString()+")="+returnValue.toString());
		JMSMessage jmsMsg=new JMSMessage();
		//jmsMsg.setMessageType(JMSMessage.MESSAGETYPE_DBLOG);
		jmsMsg.setMessageContent(jmsLog);
		LogUtil.info("eTIP", jmsMsg);
	}
}

