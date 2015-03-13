package com.itour.etip.pub.kit.jms;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TopicConnection;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Topic;

/**
 * 
 * @author zoumm
 */
public class Send {

	public Send() {

	}

	/**
	 * 发送主题。
	 * @param msg
	 * @throws JMSException
	 */
	public void send(Serializable msg) throws JMSException {
	
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setProperty(
				ConnectionConfiguration.imqBrokerHostName, "www.etip.com");
		connectionFactory.setProperty(
				ConnectionConfiguration.imqBrokerHostPort, "7676");
		connectionFactory.setProperty(
				ConnectionConfiguration.imqDefaultUsername, "admin");
		connectionFactory.setProperty(
				ConnectionConfiguration.imqDefaultPassword, "admin");

		/* topic or queue */
		TopicConnection connection = connectionFactory.createTopicConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		/* topic or queue */
		String topicName = "MyTopic"; // 要监听的topic名字
		Destination destination = new Topic(topicName);
		
		MessageProducer producer = session.createProducer(destination);
		connection.start();
		
		ObjectMessage message = null;
		try {
			message = session.createObjectMessage();
			message.setObject(msg);
			producer.send(message);

		} catch (JMSException ex) {
			ex.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
