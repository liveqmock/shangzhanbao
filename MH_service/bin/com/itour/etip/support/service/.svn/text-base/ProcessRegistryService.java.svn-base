package com.itour.etip.support.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.DaoFactory;
import com.itour.etip.pub.frame.FrmData;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.HibernateDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.hibernate.HibernateLoadForLazy;
import com.itour.etip.support.business.IProcessRegistryBusiness;
import com.itour.etip.support.data.ProcessInstanceData;
import com.itour.etip.support.data.ProcessRegistryData;
import com.itour.etip.support.persistence.ProcessInstancePersistence;

public class ProcessRegistryService extends FrmService implements IProcessRegistryService{
	/**
	 * 工作流模板查询的业务逻辑对象
	 */
	private IProcessRegistryBusiness processRegistryBusiness;

	public IProcessRegistryBusiness getProcessRegistryBusiness() {
		return processRegistryBusiness;
	}

	public void setProcessRegistryBusiness(
			IProcessRegistryBusiness processRegistryBusiness) {
		this.processRegistryBusiness = processRegistryBusiness;
	}

	public void addProcessRegistry(ProcessRegistryData data){
		// TODO Auto-generated method stub
		processRegistryBusiness.addProcessRegistry(data);
	}

	public void deleteProcessRegistry(String id)   {
		// TODO Auto-generated method stub
		processRegistryBusiness.deleteProcessRegistry(id);
	}

	public void deleteProcessRegistrys(String[] ids)   {
		// TODO Auto-generated method stub
		processRegistryBusiness.deleteProcessRegistrys(ids);
	}

	/**
	 * 查询工作流模板注册，不同的工作流版本显示为不同的记录
	 * @param pageRoll 分页所需要的对象
	 * @param condition 查询条件对象
	 * @return 工作流模板注册列表
	 * 此处应该处理懒加载问题，即为懒加载提供统一方法。
	 */
	public List<ProcessRegistryData> search(PageRoll pageRoll, JSONObject condition) {
		List<ProcessRegistryData> procesList = processRegistryBusiness.search(pageRoll, condition);
		return procesList;
	}
	
	/**
	 * 获取注册流程。
	 * @return
	 */
	public ProcessRegistryData getProcess(String id ){
		ProcessRegistryData process= processRegistryBusiness.getProcess(id);
		//this.retrieveLazy(process,false);
		return process;
	}
	
	/**
	 * 
	 */
	public void updateProcessRegistry(ProcessRegistryData data)  {
		// TODO Auto-generated method stub
		processRegistryBusiness.updateProcessRegistry(data);
	}
	
	public List<ProcessInstanceData> getProcessInstances(String processIDs){
		ProcessInstancePersistence  processInstancePersistence = new ProcessInstancePersistence();
		List<ProcessInstanceData> rv =processInstancePersistence.search("from ProcessInstanceData instance where instance.jbpmProcessID in ("+processIDs+")");
		return rv;
	}
	
	/**
	 * 返回对象值
	 * @return
	 */
	public FrmData getProcessObject(String jbpmClassName,String jbpmObjectId){
		//此处将对象转换为语句，然手查询
		if(!jbpmClassName.endsWith("Data")){
			jbpmClassName = jbpmClassName+"Data";
		}
		String sql = "from "+jbpmClassName+" instance where instance.id='"+jbpmObjectId+"'";
		List rvData = ((HibernateDao) DaoFactory.getDao("hibernate")).search(sql);
		if(rvData.size()==1){
			FrmData data = (FrmData)rvData.get(0);
			HibernateLoadForLazy.loadLazyObject(data);
			return data;
		}
		return null;
	}
}
