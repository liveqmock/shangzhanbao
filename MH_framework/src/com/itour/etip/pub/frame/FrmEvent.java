package com.itour.etip.pub.frame;

import org.springframework.context.ApplicationEvent;

public class FrmEvent extends ApplicationEvent {
	public FrmEvent(Object source){
		super(source);
	}
	/**
	 * �¼���ʶ
	 */
	private String eventID =null;
	/**
	 * �¼���Ϣ
	 */
	private String eventMessage=null;
	/**
	 * �¼�����
	 */
	private Object eventObject = null;
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
	public String getEventMessage() {
		return eventMessage;
	}
	public void setEventMessage(String eventMessage) {
		this.eventMessage = eventMessage;
	}
	public Object getEventObject() {
		return eventObject;
	}
	public void setEventObject(Object eventObject) {
		this.eventObject = eventObject;
	}
	
	
}
