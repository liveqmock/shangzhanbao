package com.itour.etip.support.business;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.support.data.ProcessInstanceData;
import com.itour.etip.support.data.ProcessRegistryData;

public interface IProcessRegistryBusiness extends IBusiness{
	
	public void addProcessRegistry(ProcessRegistryData data);
	
	public void deleteProcessRegistry(String id);
	
	public void deleteProcessRegistrys(String[] ids);
	
	public void updateProcessRegistry(ProcessRegistryData data);
	
	public List searchProcessRegistrys(PageRoll pageRoll,ProcessRegistryData data);
	
	public List getProcessList(String[] ids);
	/**
	 * 返回流程实例
	 * @param id
	 * @return
	 */
	public ProcessRegistryData getProcess(String id);
	
	/**
	 * 查询工作流模板注册，不同的工作流版本显示为不同的记录
	 * @param pageRoll 分页所需要的对象
	 * @param condition 查询条件对象
	 * @return 工作流模板注册列表
	 */
	public List<ProcessRegistryData> search(PageRoll pageRoll,JSONObject condition);
	
}
