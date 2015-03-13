package com.itour.etip.support.jbpm.facade;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.support.data.ProcessInstanceData;
import com.itour.etip.support.service.IProcessInstanceService;


/**
 * 流程实例操作接口
 * @author lishan
 *
 */
public class ProcessInstanceFacade extends FrmFacade{
	
	private IProcessInstanceService processInstanceService;
	
	public IProcessInstanceService getProcessInstanceService() {
		return processInstanceService;
	}
	public void setProcessInstanceService(
			IProcessInstanceService processInstanceService) {
		this.processInstanceService = processInstanceService;
	}
	
	/**
	 * 返回当前的流程实例。
	 * @return 满足条件的流程实例
	 */
	public List<ProcessInstanceData> getProcessIntances(PageRoll pageRoll,JSONObject condition){
		return processInstanceService.search(pageRoll, condition);
	}
	
	
	
}
