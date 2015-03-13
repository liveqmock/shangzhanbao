package com.itour.etip.support.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.support.business.IProcessInstanceBusiness;
import com.itour.etip.support.data.ProcessInstanceData;

public class ProcessInstanceService extends FrmService implements IProcessInstanceService{
	/**
	 * 工作流模板查询的业务逻辑对象
	 */
	private IProcessInstanceBusiness processInstanceBusiness;

	public IProcessInstanceBusiness getProcessInstanceBusiness() {
		return processInstanceBusiness;
	}

	public void setProcessInstanceBusiness(
			IProcessInstanceBusiness processInstanceBusiness) {
		this.processInstanceBusiness = processInstanceBusiness;
	}

	public void addProcessInstance(ProcessInstanceData data){
		// TODO Auto-generated method stub
		processInstanceBusiness.addProcessInstance(data);
	}

	public void deleteProcessInstance(String id)   {
		// TODO Auto-generated method stub
		processInstanceBusiness.deleteProcessInstance(id);
	}

	public void deleteProcessInstances(String[] ids)   {
		// TODO Auto-generated method stub
		processInstanceBusiness.deleteProcessInstances(ids);
	}

	/**
	 * 查询工作流模板注册，不同的工作流版本显示为不同的记录
	 * @param pageRoll 分页所需要的对象
	 * @param condition 查询条件对象
	 * @return 工作流模板注册列表
	 */
	public List<ProcessInstanceData> search(PageRoll pageRoll, JSONObject condition) {
		List<ProcessInstanceData> procesList = processInstanceBusiness.search(pageRoll, condition);
		return procesList;
	}

	public void updateProcessInstance(ProcessInstanceData data)  {
		// TODO Auto-generated method stub
		processInstanceBusiness.updateProcessInstance(data);
	}

}
