package com.itour.etip.pub.kit.jms;

import java.util.Map;

import org.springframework.core.task.TaskExecutor;

import com.itour.etip.pub.frame.HibernateDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.itour.etip.pub.kit.cache.IDMappingNameCache;
import com.itour.etip.pub.kit.drools.DroolsUtil;
import com.itour.etip.pub.kit.log.LogUtil;
import com.itour.etip.pub.kit.security.UrlObjectDefinitionSource;

/**
 * <p>
 * Title: JMS消息接收器
 * </p>
 * <p>
 * Description: JMS消息接收器
 * </p>
 * <p>
 * Copyright: Copyright (C), 2009-2010, eTIP
 * </p>
 * 
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-03-14
 */
public class jmsReciever {

	private class MessagePrinterTask implements Runnable {
		private String message;

		public MessagePrinterTask(String message) {
			this.message = message;
		}

		public void run() {
		}

	}

	private TaskExecutor taskExecutor;

	public jmsReciever(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void printMessages() {
		taskExecutor.execute(new MessagePrinterTask("Message"));
	}

	public void receive(String msg) {
	}

	/**
	 * 异步JMS消息接收器日志消息处理方法
	 * 
	 * @param Object
	 *            消息体
	 */
	public void receiveLog(Object msg) {
		LogUtil.debug("CONSOLE", "get Message from queue DBLog"
				+ msg.toString());
		JMSMessage jmsMsg = (JMSMessage) msg;
		JMSLog jmsLog = (JMSLog) jmsMsg.getMessageContent();
		// 此处最好改为sql,而不是用api,不然和应用系统有冲突。
		HibernateDao hibernate = (HibernateDao) SpringContextHelper
				.getBean("hibernate");
		hibernate.save(jmsLog);
	}

	/**
	 * 异步JMS消息接收器桌面消息处理方法
	 * 
	 * @param Object
	 *            消息体
	 * @return
	 * @throws
	 */
	public void receiveDesktop(Object msg) {
			JMSMessage jmsMsg = (JMSMessage) msg;
		Object content = jmsMsg.getMessageContent();

		if (content instanceof JMSDeskTop) {
			JMSDeskTop jmsDeskTop = (JMSDeskTop)

			jmsMsg.getMessageContent();

			jmsDeskTop.setId(null);
			HibernateDao hibernate = (HibernateDao)

			SpringContextHelper.getBean("hibernate");
			hibernate.save(jmsDeskTop);
		}
	}

	/**
	 * 异步JMS消息接收器邮件消息处理方法，此处调用发送邮件，此处保留， 用于支
	 * 
	 * 持非TIBCO方式发送邮件。
	 * 
	 * @param Object
	 *            消息体
	 * @return
	 * @throws
	 */
	public void receiveMail(Object msg) {
		// 此处调用邮件API，发送邮件。
		JMSMessage jms = (JMSMessage) msg;
		// 此处实现邮件转发就可以了。
		String queueName = CacheUtil.paraCache.getParaValue

		("TibcoEmailQueue");
		jms.setDestination(queueName);
		// jms.setMessageType(JMSMessage.MESSAGETYPE_TIBCOMAIL);
		JMSUtil.send(jms);
	}

	/**
	 * 异步JMS消息接收器短信消息处理方法，此处调用发送短信。 此处保留，用于支
	 * 
	 * 持非TIBCO方式发送短信。
	 * 
	 * @param Object
	 *            消息体
	 * @return
	 * @throws
	 */
	public void receiveSMS(Object msg) {
		// 此处调用短信API，发送短信。
		JMSMessage jms = (JMSMessage) msg;
		// 此处实现短信转发就可以了。
		String queueName = CacheUtil.paraCache.getParaValue

		("TibcoSMSQueue");
		jms.setDestination(queueName);
		// jms.setMessageType(JMSMessage.MESSAGETYPE_TIBCOSMS);
		JMSUtil.send(jms);
	}

	/**
	 * 异步JMS消息接收器短信消息处理方法，此处调用发送短信。 此处保留，用于支
	 * 
	 * 持非TIBCO方式发送短信。
	 * 
	 * @param Object
	 *            消息体
	 * @return
	 * @throws
	 */
	public void receiveDrools(Object msg) {
		System.out.println("receiverDrools:" + msg.toString());
		try {// 必须try，否则出错后不会清除队列，不停循环监听
			DroolsUtil.excuteDrools((Map) msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void receiveRefreshRole(Object msg) {
		try {// 必须try，否则出错后不会清除队列，不停循环监听
			System.out.println("接受到更新角色消息，执行更新");
			UrlObjectDefinitionSource.needRefresh = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 异步JMS消息接收scoreForAirOrders队列的消息，用来处理订单送积分规则。
	 * 
	 * @param msg
	 *            消息体
	 * @return
	 * @throws
	 */
	public void receiveScoreForAirOrders(Object msg) {
		try {// 必须try，否则出错后不会清除队列，不停循环监听
			// System.out.println("接受到scoreForAirOrders消息，执行业务规则");
			if (!(msg instanceof Map))
				return;
			Map contentMap = (Map) msg;
			DroolsUtil.excuteDrools(contentMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void receiveRefreshNameCache(Object msg) {
		try {// 必须try，否则出错后不会清除队列，不停循环监听
			System.out.println("接受到更新名称cache消息，执行更新");
			IDMappingNameCache.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
