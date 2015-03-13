package com.itour.etip.support.message.facade;

import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.jms.JMSDeskTop;
import com.itour.etip.pub.kit.tool.DateJsonValueProcessor;
import com.itour.etip.support.service.IMessageDesktopService;

public class SupportMessageDesktopFacade extends FrmFacade {

	private IMessageDesktopService messageDesktopService;

	public IMessageDesktopService getMessageDesktopService() {
		return messageDesktopService;
	}

	public void setMessageDesktopService(
			IMessageDesktopService messageDesktopService) {
		this.messageDesktopService = messageDesktopService;
	}

	public List<JMSDeskTop> query(PageRoll pageRoll, JSONObject jsonObject,
			FrmUser user) {
		List<JMSDeskTop> rv = messageDesktopService.query(pageRoll, jsonObject,
				user);
		return rv;

	}
	
	public void sendMsg(JSONObject jsonData){
		messageDesktopService.sendMsg(jsonData);
	}

	public String select(String id) {
		JMSDeskTop jmsDesktop = messageDesktopService.select(id);
		// 转换日期格式
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss:SSS"));
		jsonConfig.registerJsonValueProcessor(java.sql.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss:SSS"));

		JSONObject jsonObject = JSONObject.fromObject(jmsDesktop, jsonConfig);
		String jsonStr = "{success:true,data:" + jsonObject.toString() + "}";
		return jsonStr;
	}

	public void delete(String[] ids) {
		messageDesktopService.delete(ids);
	}

}
