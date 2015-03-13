package com.itour.etip.pub.kit.jbpm;


import java.util.List;


public class JBPMService implements IJBPMService {

	JBPMServiceProvider jbpm = new JBPMServiceProvider();

	/**
	 * 部署工作流模板。 processDefinitionPath 工作流模板路径
	 * 此处部署有问题，因为是分布式部署，所以，要求此处传入procesDefinition字符串，而不是路径
	 * 部署完成后，要求返回ProcessDefinition,然后写入etip的数据库。
	 */
	public Process deployProcessDefinition(String processXml) {
		return jbpm.deployProcessDefinition(processXml);
	}

	/**
	 * 根据流程名称和版本名称创建工作流实例，要求系统中的最新版本号和传入的版本号一致
	 * 
	 * @param processName
	 *            流程名称
	 * @param processVesion
	 *            流程版本
	 * @return processID;
	 */
	public long createProcess(String processName, String processVersion) {
		return jbpm.createProcess(processName, processVersion);
	}

	/**
	 * 启动工作流，离开start状态，进入到下一个节点
	 * 
	 * @param processId
	 */
	public long startProcess(long processId, String etipOperatorId) {
		return jbpm.startProcess(processId, etipOperatorId);
	}

	/**
	 * 查询指定用户的待办任务，此处构造一个Map返回所有待办任务，但是不包括已经完成的任务 此处有问题，最好直接转换为json串
	 */
	public List<JBPMTask> getTaskList(String etipOperatorID) {
		return jbpm.getTaskList(etipOperatorID);
	}

	/**
	 * 启动工作任务
	 */
	public void startTask(long taskID) {
		jbpm.startTask(taskID);
	}

	/**
	 * 完成工作任务,后续路径如何处理呢，如果有多条路径。
	 */
	public void doTask(long taskID) {
		jbpm.doTask(taskID);
	}

	/**
	 * 结束任务执行到指定路径
	 */
	public void endTaskToTransition(long taskID, String transitionName) {
		jbpm.endTaskToTransition(taskID, transitionName);
	}

	/**
	 * 取消任务
	 */
	public void cancelProcess(long processinstanceID) {
		jbpm.cancelProcess(processinstanceID);
	}

	public void submitProcess(long processinstanceID, String transitionName) {
		jbpm.submitProcess(processinstanceID, transitionName);
	}

	public void proxyTasks(String proxyedID, String proxyID,boolean flag) {
		// TODO Auto-generated method stub
		jbpm.proxyTasks(proxyedID, proxyID, flag);
	}

}