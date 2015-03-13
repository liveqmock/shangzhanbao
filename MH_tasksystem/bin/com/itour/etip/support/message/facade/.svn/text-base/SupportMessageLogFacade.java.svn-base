package com.itour.etip.support.message.facade;

import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.jms.JMSLog;
import com.itour.etip.pub.kit.tool.DateJsonValueProcessor;
import com.itour.etip.support.service.IMessageLogService;

public class SupportMessageLogFacade extends FrmFacade {

	private IMessageLogService messageLogService;

	public IMessageLogService getMessageLogService() {
		return messageLogService;
	}

	public void setMessageLogService(IMessageLogService messageLogService) {
		this.messageLogService = messageLogService;
	}

	public List<JMSLog> getLogs(PageRoll pageRoll,JSONObject condition) {
		List<JMSLog> list = messageLogService.getLogs(pageRoll,condition);
		return list;
	}

	public String select(String id) {
		JMSLog jmsLog = messageLogService.select(id);
		// 转换日期格式
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss:SSS"));
		jsonConfig.registerJsonValueProcessor(java.sql.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss:SSS"));

		JSONObject jsonObject = JSONObject.fromObject(jmsLog, jsonConfig);
		String jsonStr = "{success:true,data:" + jsonObject.toString() + "}";
		return jsonStr;
	}

	public void delete(String[] ids) {
		messageLogService.delete(ids);
	}

}
