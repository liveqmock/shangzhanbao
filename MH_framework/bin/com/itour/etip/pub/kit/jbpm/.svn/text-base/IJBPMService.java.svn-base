package com.itour.etip.pub.kit.jbpm;

import java.util.List;



public abstract interface IJBPMService {
	public abstract Process deployProcessDefinition(String paramString);

	/*
	 * 创建工作流实例 @param processName 流程名称 @param processVersion 流程版本
	 */
	public abstract long createProcess(String processName, String processVersion);

	public abstract long startProcess(long processId, String etipOperatorId);

	public abstract List<JBPMTask> getTaskList(String actorId);

	public abstract void startTask(long taskId);

	public abstract void doTask(long taskId);

	public abstract void endTaskToTransition(long taskId, String transitionname);

	public abstract void cancelProcess(long processId);
	
	public void submitProcess(long processinstanceID,String transitionName);
	
	public void proxyTasks(String proxyedID,String proxyID,boolean flag);

}