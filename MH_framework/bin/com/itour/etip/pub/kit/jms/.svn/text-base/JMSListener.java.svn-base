package com.itour.etip.pub.kit.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.TopicConnection;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.tool.DateTool;
import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Topic;

/**
 * <p>Title: 桌面消息Listener</p>
 * <p>Description: 桌面消息Listener</p>
 * <p>Copyright: Copyright (C), 2009-2010, eTIP </p>
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-05-15
 */
public class JMSListener implements MessageListener, ServletContextListener {

	String topicName = "mytopic"; // 要监听的topic名字
	String queueName = "myqueue"; // 要监听的queue的名字
	String brokerHost = "www.etip.com"; // OpenMQ server （broker）的ip
	String brokerPort = "7676"; // OpenMQ server （broker）的port
	String username = "admin"; // test账号必须有可以接受此queue或者topic的权限
	String password = "admin";
	ConnectionFactory connectionFactory = null;
	/* topic or queue */
	TopicConnection connection = null;
	// QueueConnection connection = null;

	Destination destination = null;
	Session session = null;
	MessageConsumer consumer = null;
	TextMessage message = null;
	JMSListener listen;

	public JMSListener() {
	}

	public void onMessage(Message msg) {
		try {
			ObjectMessage om = (ObjectMessage) msg;
			JMSMessage jmsMessage = (JMSMessage) om.getObject();
			JMSListener.addCache(jmsMessage);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void init() throws Exception {
		connectionFactory = new ConnectionFactory();
		connectionFactory.setProperty(
				ConnectionConfiguration.imqBrokerHostName, brokerHost);
		connectionFactory.setProperty(
				ConnectionConfiguration.imqBrokerHostPort, brokerPort);
		// connectionFactory.setProperty(ConnectionConfiguration.imqBrokerServiceName,brokerName);
		connectionFactory.setProperty(
				ConnectionConfiguration.imqDefaultUsername, username);
		connectionFactory.setProperty(
				ConnectionConfiguration.imqDefaultPassword, password);

		/* topic or queue */
		connection = connectionFactory.createTopicConnection();
		// connection = connectionFactory.createQueueConnection();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		/* topic or queue */
		destination = new Topic(topicName);
		// destination = new Queue(queueName);
		consumer = session.createConsumer(destination);
		connection.start();
	}

	// 消费消息
	public void consumeMessage() throws JMSException, Exception {
		init();
		connection.start();
		// 开始监听
		consumer.setMessageListener(this);
		// Message message = consumer.receive();
	}

	public void destory() throws JMSException {
		consumer.close();
		session.close();
		connection.close();
	}

	public static void addCache(Object msg) {
		// CacheManager manager = CacheManager.create();
		CacheManager manager = (CacheManager) SpringContextHelper
				.getBean("cacheManager");
		Cache cache = manager.getCache("desktop");
		JMSMessage jmsMessage = (JMSMessage) msg;
		JMSDeskTop jmsDeskTop = (JMSDeskTop) jmsMessage.getMessageContent();
		String id = jmsDeskTop.getId();
		if (cache == null) {
			manager.addCache("desktop");
			cache = manager.getCache("desktop");
			Element element = new Element("newtime", msg);
			cache.put(element);
		} else {
			cache.remove("newtime");
			Element elementtime = new Element("newtime", DateTool.getDateTime(
					jmsDeskTop.getDesktopTime(), "yyyyMMddkkmmssS"));
			cache.put(elementtime);
			// 暂时不将消息存放到cache中，需要时可放开，此处担心内存过大
			// Element element = new Element(id, jmsDeskTop);
			// cache.put(element);
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			listen.destory();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		listen = new JMSListener();
		try {
			listen.consumeMessage();
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
