/**
 * Auto generator by Leo
 */
package com.itour.etip.support.data;

import com.itour.etip.pub.frame.FrmData;

/**
 * <p>Title: 消息JavaBean</p>
 * <p>Description: 消息JavaBean</p>
 * <p>Copyright: Copyright (C), 2009-2010, eTIP </p>
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-03-14
 */
// @Entity()
// @Table(name = "JMSMessage")
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class JMSMessageData extends FrmData {

	/**
	 * 消息类型
	 * 按照现有接口规范允许使用的值有如下4种：
	 * <p>(日志)JMSMessage.MESSAGETYPE_LOG</p>
	 * <p>(邮件)JMSMessage.MESSAGETYPE_MAIL</p>
	 * <p>(短信)JMSMessage.MESSAGETYPE_SMS</p>
	 * <p>(桌面消息)JMSMessage.MESSAGETYPE_DESKTOP</p>
	 */
	// @Column(length = 1,name = "MESSAGETYPE",nullable = false)
	private String messageType;

	/**
	 * 消息体
	 * <p>消息体按照现有接口规范允许使用的值有如下4种：</p>
	 * <p>(日志)JMSLog.class</p>
	 * <p>(邮件)JMSMail.class</p>
	 * <p>(短信)JMSSMS.class</p>
	 * <p>(桌面消息)JMSDeskTop.class</p>
	 */
	// @Column(length = 1,name = "MESSAGECONTENT",nullable = false)
	private Object messageContent;

	/**
	 * 获得消息类型
	 */
	public String getMessageType() {
		return messageType;
	}

	/**
	 * 设置消息类型
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	/**
	 * 获得消息体
	 */
	public Object getMessageContent() {
		return messageContent;
	}

	/**
	 * 设置消息体
	 */
	public void setMessageContent(Object messageContent) {
		this.messageContent = messageContent;
	}

}
