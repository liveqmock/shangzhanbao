package com.itour.etip.support.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.jms.JMSLog;
import com.itour.etip.support.persistence.IMessageLogPersistence;

public class MessageLogService extends FrmService implements IMessageLogService {
	private IMessageLogPersistence messageLogPersistence;

	public IMessageLogPersistence getMessageLogPersistence() {
		return messageLogPersistence;
	}

	public void setMessageLogPersistence(
			IMessageLogPersistence messageLogPersistence) {
		this.messageLogPersistence = messageLogPersistence;
	}

	/**
	 * 日志信息查询
	 * 
	 * @param String,limit,query
	 * @return PageModel
	 * 
	 */
	public List<JMSLog> getLogs(PageRoll pageRoll,JSONObject condition) {
		//String condition1;此处需要拼接查询条件
		pageRoll.setSearchSQL("from JMSLog");
		pageRoll.setCountSQL("select count(*) from JMSLog");
		List<JMSLog> rvList = messageLogPersistence.search(pageRoll);
		return rvList;
	
	}

	/**
	 * 日志信息浏览
	 * 
	 * @param id
	 * @return JMSLog
	 * 
	 */
	public JMSLog select(String id) {
		return messageLogPersistence.retrieve(id);
	}

	/**
	 * 日志信息清除
	 * 
	 * @param id
	 * @return boolean
	 * 
	 */
	public void delete(String[] id) {
		messageLogPersistence.delete(id);
	}

}
