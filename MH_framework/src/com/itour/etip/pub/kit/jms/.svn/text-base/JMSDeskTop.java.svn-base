package com.itour.etip.pub.kit.jms;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import com.itour.etip.pub.frame.FrmData;

/**
 * <p>Title: 桌面消息JavaBean</p>
 * <p>Description: 桌面消息JavaBean</p>
 * <p>Copyright: Copyright (C), 2009-2010, eTIP </p>
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-03-14
 */
@Entity()
@Table(name = "JMSDeskTop")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class JMSDeskTop extends FrmData{

	/**
	 * 桌面消息发起时间
	 */
	@Column(name = "desktopTime")
	private Date desktopTime;
	

	/**
	 * 桌面消息发送者
	 */
	@Column(name = "sender",length=32)
	private String sender;
	
	/**
	 * 接收者类型。
	 */
	@Column(name = "receiverType",length=6)
	private String receiverType;
	
	
	
	/**
	 * 消息发送渠道。
	 * 001.桌面消息。
	 * 002.邮件
	 * 003.手机
	 */
	@Column(name = "sendChannel",length=3)
	private String sendChannel;
	

	
	/**
	 * 消息接受者
	 * 1.如果是ALL:无值
	 * 2.如果是ROLES:则指的是各个角色。
	 * 3.如果是USERS：则指的是各个用户。
	 * 4.如果是DROOLS:则指向事实，每个事实名称都有一个事件监听器。
	 * 
	 */
	@Column(name = "recipients",length=4000)
	private String recipients;
	
	/**
	 * 桌面标题,传递的是规则参数值。
	 */
	@Column(name = "title",length=400)
	private String title;
	
	/**
	 * 桌面消息内容,传递的是规则参数值。
	 */
	@Column(name = "content",length=4000)
	private String content;
	
	
	/**
	 * 获取桌面消息内容的值
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置桌面消息内容的值
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取桌面消息授权对象的值
	 */
	public String getRecipients() {
		return recipients;
	}
	
	/**
	 * 设置桌面消息授权对象的值
	 */
	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}
	
	/**
	 * 获取桌面消息发送者的值
	 */
	public String getSender() {
		return sender;
	}
	
	/**
	 * 设置桌面消息发送者的值
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	/**
	 * 获取桌面消息发起时间的值
	 */
	public Date getDesktopTime() {
		return desktopTime;
	}
	
	/**
	 * 设置桌面消息发起时间的值
	 */
	public void setDesktopTime(Date time) {
		this.desktopTime = time;
	}
	


	public String getReceiverType() {
		return receiverType;
	}

	public void setReceiverType(String receiverType) {
		this.receiverType = receiverType;
	}

	public String getSendChannel() {
		return sendChannel;
	}

	public void setSendChannel(String sendChannel) {
		this.sendChannel = sendChannel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
}
