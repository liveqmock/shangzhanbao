package com.itour.etip.pub.kit.jms;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * <p>
 * Title: 异步JMS消息发送Appender
 * </p>
 * <p>
 * Description: 异步JMS消息发送Appender
 * </p>
 * <p>
 * Copyright: Copyright (C), 2009-2010, eTIP
 * </p>
 * 
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-03-17
 */
public class JMSAppender extends AppenderSkeleton {

	/**
	 * 发送消息，异步日志发送工具
	 * 
	 * @param ConnectionFactory
	 *            连接工厂
	 * @param String
	 *            目的地名称
	 * @return
	 * @throws
	 */
	protected void append(LoggingEvent event) {
		if(event==null) return;
		Object msg = event.getMessage();
		if(msg==null)return;
		if (msg instanceof JMSMessage) {
			JMSUtil.send( (JMSMessage) msg);
		}
		else{
			return;
		}
		//如果不是这个类型怎么处理呢？
	}

	public void close() {
	}

	public boolean requiresLayout() {
		return false;
	}

}
