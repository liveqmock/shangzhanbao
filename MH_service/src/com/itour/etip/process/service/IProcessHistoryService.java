package com.itour.etip.process.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.support.data.ProcessHistoryData;

public interface IProcessHistoryService extends IService {
	/**
	 * 查询流程历史
	 * @return
	 */
	public List<ProcessHistoryData> searchProcessHistory(PageRoll pageRoll , JSONObject obj) ;
	/**
	 * 查询指定id计划的审批历史
	 * @param obj
	 * @return
	 */
	public List<ProcessHistoryData> detailHistory( JSONObject obj ) ;
	
	/**
	 * 将计划的id变为计划名称
	 *
	 */
	public String convertIDtoClass ( String planID , String className ) ;

}
