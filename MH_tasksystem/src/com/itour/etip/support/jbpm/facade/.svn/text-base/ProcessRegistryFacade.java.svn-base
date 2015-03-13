package com.itour.etip.support.jbpm.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmData;
import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.jbpm.IJBPMService;
import com.itour.etip.pub.kit.jbpm.JBPMService;
import com.itour.etip.pub.kit.jbpm.JBPMTask;
import com.itour.etip.pub.kit.jbpm.ProcessTask;
import com.itour.etip.pub.kit.jbpm.ProcessTransition;
import com.itour.etip.support.data.ProcessInstanceData;
import com.itour.etip.support.data.ProcessRegistryData;
import com.itour.etip.support.data.ProcessTaskRegistryData;
import com.itour.etip.support.data.ProcessTransitionRegistryData;
import com.itour.etip.support.data.UserTaskData;
import com.itour.etip.support.service.IProcessRegistryService;

/**
 * 流程实例操作接口
 * 
 * @author lishan
 * 
 */
public class ProcessRegistryFacade extends FrmFacade {

	private IProcessRegistryService processRegistryService;

	public IProcessRegistryService getProcessRegistryService() {
		return processRegistryService;
	}

	public void setProcessRegistryService(
			IProcessRegistryService processRegistryService) {
		this.processRegistryService = processRegistryService;
	}

	/**
	 * 注册工作流程
	 * 
	 * @param process
	 *            流程xml文件
	 */
	public void registerProcess(String processXml) {
		// 此处调用xml文件，调试时使用直接调用
		// JBPMService service = new JBPMService();
		System.out.println("process:"+processXml);
		if(processXml==null||processXml.trim().length()==0){
			System.out.println("no process registered!!!!!!!!!!!!");
			return;
		}
		IJBPMService jbpm = new JBPMService();
/*		IJBPMService jbpm = (IJBPMService) SpringContextHelper
				.getBean("JBPMClient");*/
		
		
		com.itour.etip.pub.kit.jbpm.Process process = jbpm.deployProcessDefinition(processXml);
		// 此处需要购置ProcessRegistryData对象，然后调用API创建流程实例
		String processName = process.getProcessName();
		String processVersion = process.getProcessVersion();
		/*
		 * 以下代码用于处理ProcessTask
		 */
		
		ProcessTask[] tasks = process.getTasks();
		ProcessRegistryData processRegistry = new ProcessRegistryData();
		processRegistry.setProcessName(processName);
		processRegistry.setProcessVersion(processVersion);
		//Object[] tasks = tasksMap.values().toArray();
		List<ProcessTaskRegistryData> taskRegistries = new ArrayList<ProcessTaskRegistryData>();
		for (ProcessTask task:tasks) {
			// Map taskMap = tasksMap.c
			
			ProcessTaskRegistryData taskRegistry = new ProcessTaskRegistryData();
			taskRegistry.setProcessName(processName);
			taskRegistry.setProcessVersion(processVersion);
			taskRegistry.setTaskName(task.getName());
			taskRegistries.add(taskRegistry);
		}
		processRegistry.setTasks(taskRegistries);

		/*
		 * 以下代码用于处理ProcessTransition
		 */
		//Map transitonMap = (Map) rv.get("transitions");
		ProcessTransition[] transitions = process.getTransitions();
		List<ProcessTransitionRegistryData> transitionRegistries = new ArrayList<ProcessTransitionRegistryData>();
		for (ProcessTransition transition:transitions) {
			// Map taskMap = tasksMap.c
			ProcessTransitionRegistryData transitionRegistry = new ProcessTransitionRegistryData();
			transitionRegistry.setProcessName(processName);
			transitionRegistry.setProcessVersion(processVersion);
			transitionRegistry.setTaskName(transition.getTaskName());
			//transitionRegistry.setTaskStatus(transition.getTaskStatus());
			transitionRegistry.setTransitionName(transition.getTransitionName());
			transitionRegistry.setTransitionTaskName(transition.getTransitionTaskName());
			//transitionRegistry.setTransitionStatus(transition.getTransitionStatus());
			transitionRegistries.add(transitionRegistry);
		}
		processRegistry.setTransitions(transitionRegistries);

		processRegistryService.addProcessRegistry(processRegistry);
		// 还需要注册迁移，暂时不做了，调试程序
	}

	/**
	 * 返回当前的流程实例。
	 * 
	 * @return 满足条件的流程实例
	 */
	public List<ProcessRegistryData> getProcessRegistries(PageRoll pageRoll,
			JSONObject condition) {
		return processRegistryService.search(pageRoll, condition);
	}

	/**
	 * 工作流注册
	 * 
	 * @return
	 */
	public ProcessRegistryData getProcess(String id) {
		ProcessRegistryData process = processRegistryService.getProcess(id);
		return process;
	}

	/**
	 * 工作流注册
	 * 
	 * @return
	 */
	public ProcessRegistryData updateProcess(ProcessRegistryData process) {
		processRegistryService.updateProcessRegistry(process);
		return process;
	}

	/**
	 * 此处查询用户待办任务，最好在框架中完成，而不是写入到指定模块中
	 * 
	 * @param etipOperatorID
	 * @return List<UserTaskData>
	 */
	public List<UserTaskData> getTaskList(String etipOperatorID) {
		IJBPMService jbpm = new JBPMService();
//		IJBPMService jbpm = (IJBPMService) SpringContextHelper
//				.getBean("JBPMClient");

		List<JBPMTask> taskList = null;
		try {
			taskList = jbpm.getTaskList(etipOperatorID);
		} catch (Exception ex) {
			// 此处无数据库表，访问有错误
			System.out.println("getTaskListError:" + ex.getMessage());
			return new ArrayList();
		}
		if(taskList==null){
			System.out.println("getTaskList:no tasks" );
			return new ArrayList();
		}
		List<UserTaskData> rvTasks = new ArrayList<UserTaskData>();

		String processIDs = "";
		for (JBPMTask jbpmTask : taskList) {
			//Map taskMap = (Map) taskObj;
			UserTaskData task = new UserTaskData();
			rvTasks.add(task);
			task.setTaskName(jbpmTask.getTaskName());
			task.setTaskId(jbpmTask.getTaskId());
			task.setProcessName(jbpmTask.getProcessName());
			task.setProcessId(jbpmTask.getProcessId());
			// 此处需要从ProcessInstance中获取当前jbpmClassName jbpmObjectId
			processIDs = processIDs + "'" + task.getProcessId() + "',";
			task.setCreateDate(jbpmTask.getCreateDate());
			task.setStartDate(jbpmTask.getStartDate());
			task.setEndDate(jbpmTask.getEndDate());
			task.setPrviousActor(jbpmTask.getPrviousActor());
			task.setTaskActors(jbpmTask.getTaskActors());
			task.setLeavingTransitions(jbpmTask.getLeavingTransitions());
		}
		// 此处根据processIDs从ProcessInstance中查询jbpmClassName,jbpmObjectId,jbpmStatus
		if (rvTasks.size() > 0) {
			processIDs = processIDs.substring(0, processIDs.length() - 1);
			List<ProcessInstanceData> instances = processRegistryService
					.getProcessInstances(processIDs);
			Map<String, ProcessInstanceData> instanceMap = new TreeMap<String, ProcessInstanceData>();
			for (ProcessInstanceData instance : instances) {
				instanceMap.put(instance.getJbpmProcessID(), instance);
			}
			// 以下载task中添加属性
			for (UserTaskData task : rvTasks) {
				ProcessInstanceData instance = instanceMap.get(task.getProcessId());
				if(instance !=null){//lihc修改
					task.setJbpmClassName(instance.getJbpmClassName());
					task.setJbpmStatus(instance.getProcessStatus());
					task.setJbpmObjectId(instance.getJbpmObjectID());
				}
			}
		}
		// 此处需要查询
		return rvTasks;
	}

	public FrmData getProcessObject(String jbpmClassName, String jbpmObjectId) {
		return processRegistryService.getProcessObject(jbpmClassName,
				jbpmObjectId);
	}

}
