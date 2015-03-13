package com.itour.etip.pub.kit.jms;

import java.io.Serializable;

/**
 * <p>Title: 消息JavaBean</p>
 * <p>Description: 消息JavaBean</p>
 * <p>Copyright: Copyright (C), 2009-2010, eTIP </p>
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-03-14
 */
public class JMSMessage implements Serializable {
	
//	/**
//	 * 消息类型
//	 */
//	private String messageType;
	/**
	 * 消息体
	 * <p>消息体按照现有接口规范允许使用的值有如下4种：</p>
	 * <p>(日志)JMSLog.class</p>
	 * <p>(邮件)JMSMail.class</p>
	 * <p>(短信)JMSSMS.class</p>
	 * <p>(桌面消息)JMSDeskTop.class</p>
	 */
	private Object messageContent;
	
	/**
	 * 目的地名称
	 */
	private String destination;
	
	/**
	 * 日志类型消息
	 */
//	public final static String MESSAGETYPE_DBLOG="DBLog";
//	public final static String MESSAGETYPE_MAIL="Mail";
//	public final static String MESSAGETYPE_TIBCOMAIL="jmsSendEmail";
//	public final static String MESSAGETYPE_SMS="SMS";
//	public final static String MESSAGETYPE_TIBCOSMS="TibcoSMS";
//	public final static String MESSAGETYPE_DESKTOPMSG="DesktopMsg";
//	public final static String MESSAGETYPE_DROOLS="Drools";
//	public final static String MESSAGETYPE_FAX="Fax";
//	public final static String MESSAGETYPE_ROLE = "RoleRefresh";
//	public final static String MESSAGETYPE_NAMECACHE = "NameCache";
	/**
	 * 获取目的地
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * 设置目的地
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * 获取消息体内容
	 */
	public Object getMessageContent() {
		return messageContent;
	}
	
	/**
	 * 设置消息体内容
	 */
	public void setMessageContent(Object messageContent) {
		this.messageContent = messageContent;
	}

//	/**
//	 * 获取消息类型
//	 */
//	public String getMessageType() {
//		return messageType;
//	}
//
//	/**
//	 * 设置消息类型
//	 */
//	public void setMessageType(String messageType) {
//		this.messageType = messageType;
//	}
	
}
