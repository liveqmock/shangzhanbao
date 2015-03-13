package com.itour.etip.support.jbpm.action;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;

import com.itour.etip.support.data.ProcessInstanceData;
import com.itour.etip.support.jbpm.facade.ProcessInstanceFacade;

public class ProcessInstanceAdminAction extends FrmAction {
	private ProcessInstanceFacade processInstanceFacade;

	public ProcessInstanceFacade getProcessInstanceFacade() {
		return processInstanceFacade;
	}

	public void setProcessInstanceFacade(
			ProcessInstanceFacade processInstanceFacade) {
		this.processInstanceFacade = processInstanceFacade;
	}

	
	/**
	 * 查询流程实例
	 * @return
	
	 */
	public String searchProcessInstances() {
		JSONObject jsonObject = null;
		PageRoll pageRoll = new PageRoll();	
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		pageRoll.setPageSize(Integer.valueOf(limit));
		pageRoll.setStartRow(Integer.valueOf(start));
		Object conditionObj = getJson();
		JSONObject condition = JSONObject.fromObject(conditionObj);
		List<ProcessInstanceData> rvList = processInstanceFacade.getProcessIntances(pageRoll, condition);
		String rvJson = getListJsonStr(pageRoll,rvList);
		setJson(rvJson);
		return null;
	}
}
