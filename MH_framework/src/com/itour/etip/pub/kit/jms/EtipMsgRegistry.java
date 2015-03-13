package com.itour.etip.pub.kit.jms;

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
 * @Author lishan
 * @Version 1.0
 * @Date 2009-03-14
 */
@Entity()
@Table(name = "EtipMsgRegistry")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EtipMsgRegistry extends FrmData{

	/**
	 * 桌面消息名称
	 */
	@Column(name = "messageName")
	private String messageName;
	
	/**
	 * 触发请求
	 */
	@Column(name = "triggerAction")
	private String triggerAction;
	
	
	/**
	 * 触发点:前置触发(BEFORE)，后置触发(AFTER)，例外触发(EXCEPTION)
	 */
	@Column(name = "triggerPoint")
	private String triggerPoint;
	

	
	/**
	 * 触发者,暂时不需填写，以后用于支持点对点的消息发送。
	 */
	@Column(name = "msgTrigger")
	private String msgTrigger;
	
	
	/**
	 * 消息处理者类型：DBLog,DesktopMsg,SMS,Email,Drools
	 */
	@Column(name = "handlerType")
	private String handlerType;
	
	/**
	 * 同步还是异步处理
	 */
	@Column(name = "synchronize")
	private boolean synchronize;
	
	/**
	 * 消息接受者，DBLog,DesktopMsg,SMS,Email.需要选择接受消息的人。
	 * Drools,需要选择处理消息的规则名称，以及后置处理类
	 */
	@Column(name = "receivers")
	private String receivers;
	
	/**
	 * 消息接收者类型
	 */
	@Column(name = "receiverType")
	private String receiverType;

	public String getHandlerType() {
		return handlerType;
	}

	public void setHandlerType(String handlerType) {
		this.handlerType = handlerType;
	}

	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	public String getMsgTrigger() {
		return msgTrigger;
	}

	public void setMsgTrigger(String msgTrigger) {
		this.msgTrigger = msgTrigger;
	}

	public String getReceivers() {
		return receivers;
	}

	public void setReceivers(String receivers) {
		this.receivers = receivers;
	}

	public String getTriggerAction() {
		return triggerAction;
	}

	public void setTriggerAction(String triggerAction) {
		this.triggerAction = triggerAction;
	}

	public String getTriggerPoint() {
		return triggerPoint;
	}

	public void setTriggerPoint(String triggerPoint) {
		this.triggerPoint = triggerPoint;
	}

	public boolean isSynchronize() {
		return synchronize;
	}

	public void setSynchronize(boolean synchronize) {
		this.synchronize = synchronize;
	}

	public String getReceiverType() {
		return receiverType;
	}

	public void setReceiverType(String receiverType) {
		this.receiverType = receiverType;
	}
	
	

	
}
