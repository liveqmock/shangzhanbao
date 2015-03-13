package com.itour.etip.support.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.FrmData;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.support.data.ProcessInstanceData;
import com.itour.etip.support.data.ProcessRegistryData;
/**
 * 工作流程服务接口 
 * @author lishan
 */
public interface IProcessRegistryService extends IService{

	/**
	 * 添加流程注册表
	 * @param data 待添加的流程实例。
	 */
	public void addProcessRegistry(ProcessRegistryData data);
	
	/**
	 * 删除流程注册表
	 * @param id 待删除的流程id
	 */
	public void deleteProcessRegistry(String id);
	
	/**
	 * 删除流程注册项目，此处是多项删除
	 * @param ids 待删除的id数组
	 */
	public void deleteProcessRegistrys(String[] ids);
	
	/**
	 * 更新流程注册表
	 * @param data 更新的流程注册表
	 */
	public void updateProcessRegistry(ProcessRegistryData data);
	
	/**
	 * 获取流程注册项目
	 * @param id 当前流程id
	 * @return 返回流程注册表
	 */
	public ProcessRegistryData getProcess(String id );
	/**
	 * 查询工作流模板注册，不同的工作流版本显示为不同的记录
	 * @param pageRoll 分页所需要的对象
	 * @param condition 查询条件对象
	 * @return 工作流模板注册列表
	 */
	public List<ProcessRegistryData> search(PageRoll pageRoll,JSONObject condition);
	
	/**
	 * 返回流程实例
	 * @param processIDs
	 * @return
	 */
	public List<ProcessInstanceData> getProcessInstances(String processIDs);
	
	/**
	 * 返回对象值
	 * @return
	 */
	public FrmData getProcessObject(String jbpmClassName,String jbpmObjectId);
}
