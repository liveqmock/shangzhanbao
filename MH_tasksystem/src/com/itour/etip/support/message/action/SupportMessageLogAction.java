package com.itour.etip.support.message.action;


import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.jms.JMSLog;
import com.itour.etip.support.message.facade.SupportMessageLogFacade;


public class SupportMessageLogAction extends FrmAction {

	private SupportMessageLogFacade supportMessageLogFacade;

	public SupportMessageLogFacade getSupportMessageLogFacade() {
		return supportMessageLogFacade;
	}

	public void setSupportMessageLogFacade(
			SupportMessageLogFacade supportMessageLogFacade) {
		this.supportMessageLogFacade = supportMessageLogFacade;
	}

	public String query() {
		
		JSONObject jsonObject = null;
		PageRoll pageRoll = new PageRoll();
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		pageRoll.setPageSize(Integer.valueOf(limit));
		pageRoll.setStartRow(Integer.valueOf(start));
		Object conditionObj = getJson();
		JSONObject condition = JSONObject.fromObject(conditionObj);
	
		List<JMSLog> rvList = supportMessageLogFacade.getLogs(pageRoll,condition);
		String rvJson = getListJsonStr(pageRoll, rvList);
		setJson(rvJson);
		return null;
	}
	
	public String select() {
		JSONObject jsonObject = (JSONObject)getJson();
		String id = (String)jsonObject.get("id");
		String json = supportMessageLogFacade.select(id);
		setJson(json);
		return null;
	}
	
	public String delete() {
		JSONArray jsonArray = (JSONArray)getJson();
		Object[] objs = jsonArray.toArray();
		String[] ids = new String[objs.length];
		int i = 0;
		for(Object obj : objs){
			ids[i++] = obj.toString();
		}
		supportMessageLogFacade.delete(ids);
		setJson("{success:true}");
		return null;
	}
	
}
