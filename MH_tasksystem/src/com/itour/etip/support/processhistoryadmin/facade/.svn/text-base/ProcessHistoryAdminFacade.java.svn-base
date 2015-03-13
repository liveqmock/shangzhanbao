package com.itour.etip.support.processhistoryadmin.facade;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.process.service.IProcessHistoryService;
import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.support.data.ProcessHistoryData;

/**
 * @author Administrator
 *
 */
public class ProcessHistoryAdminFacade extends FrmFacade{
	private IProcessHistoryService processHistoryService;
	/**
	 * 查询流程历史
	 * @return
	 */
	public List<ProcessHistoryData> searchProcessHistory(PageRoll pageRoll , JSONObject obj){
		
		return processHistoryService.searchProcessHistory(pageRoll, obj);
	}
	/**
	 * 查询指定id计划的审批历史
	 * @param obj
	 * @return
	 */
	public List<ProcessHistoryData> detailHistory( JSONObject obj ) {
		
		return processHistoryService.detailHistory(obj);
	}
	
	/**
	 * 将计划的id变为计划名称
	 *
	 */
	public String convertIDtoClass ( String planID , String className ) {
		
		return processHistoryService.convertIDtoClass( planID, className ) ; 
	}
	public IProcessHistoryService getProcessHistoryService() {
		return processHistoryService;
	}
	public void setProcessHistoryService(
			IProcessHistoryService processHistoryService) {
		this.processHistoryService = processHistoryService;
	}
	
	
}
