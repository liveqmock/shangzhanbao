package com.itour.etip.pub.kit.jbpm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.db.GraphSession;
import org.jbpm.db.TaskMgmtSession;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.def.Task;
import org.jbpm.taskmgmt.exe.PooledActor;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.itour.etip.pub.kit.exception.ETIPError;

public class JBPMServiceProvider {

	/**
	 * 部署工作流模板。 processDefinitionPath 工作流模板路径
	 * 此处部署有问题，因为是分布式部署，所以，要求此处传入procesDefinition字符串，而不是路径
	 * 部署完成后，要求返回ProcessDefinition,然后写入etip的数据库。
	 */
	public Process deployProcessDefinition(String processXml) {
		JbpmContext jbpmContext = JbpmConfiguration.getInstance()
				.createJbpmContext();
		try {
			ProcessDefinition processDefinition = ProcessDefinition
					.parseXmlString(processXml);
			jbpmContext.deployProcessDefinition(processDefinition);
			System.out.println("deploy success");
			// 此处需要将processDefintion转换成为etip系统需要的ProcessRegistry中的格式。
			String processName = processDefinition.getName();
			String processVersion = String.valueOf(processDefinition
					.getVersion());
			Object[] tasks = processDefinition.getTaskMgmtDefinition()
					.getTasks().values().toArray();
			//
			Map<String, ProcessTask> rvTasks = new TreeMap<String, ProcessTask>();
			Map<String, ProcessTransition> rvTransitions = new TreeMap<String, ProcessTransition>();
			handlerNode(processDefinition.getStartState(), rvTasks,
					rvTransitions);
			for (Object taskObj : tasks) {
				handlerNode(taskObj, rvTasks, rvTransitions);
			}
			// 结束节点，不能用这种方式处理，而是简单添加一个结束。
			ProcessTask endTask = new ProcessTask();
			endTask.setId("end");
			endTask.setName("结束");
			rvTasks.put("end", endTask);

			// 以下有问题啊，混杂的对象。
			Process process = new Process();
			process.setProcessName(processName);
			process.setProcessVersion(processVersion);
			ProcessTask[] taskArray = new ProcessTask[rvTasks.size()];
			rvTasks.values().toArray(taskArray);
			process.setTasks(taskArray);
			ProcessTransition[] transitionArray = new ProcessTransition[rvTransitions
					.size()];
			rvTransitions.values().toArray(transitionArray);
			process.setTransitions(transitionArray);

			// 此处还需要迁移对象
			return process;
		} finally {
			jbpmContext.close();
		}
	}

	private void handlerNode(Object node, Map rvTasks, Map rvTransitions) {
		// Map taskMap = new TreeMap();
		ProcessTask processTask = new ProcessTask();
		String id = null;
		List transitions = null;
		if (node instanceof Task) {
			Task task = (Task) node;
			id = String.valueOf(task.getId());
			processTask.setId(id);
			processTask.setName(task.getName());
			transitions = task.getTaskNode().getLeavingTransitions();
		} else if (node instanceof Node) {
			Node myNode = (Node) node;
			id = String.valueOf(myNode.getId());
			processTask.setId(id);
			processTask.setName(myNode.getName());
			transitions = myNode.getLeavingTransitions();
		}

		for (Object transitionObj : transitions) {
			Transition transition = (Transition) transitionObj;
			// Map<String, String> transitionMap = new TreeMap<String,
			// String>();
			ProcessTransition processTransition = new ProcessTransition();
			processTransition.setId(String.valueOf(transition.getId()));
			processTransition.setTaskName(transition.getFrom().getName());
			processTransition.setTransitionName(transition.getName());
			processTransition.setTransitionTaskName(transition.getTo()
					.getName());
			rvTransitions.put(String.valueOf(transition.getId()),
					processTransition);
		}

		rvTasks.put(id, processTask);
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
		JbpmContext jbpmContext = JbpmConfiguration.getInstance()
				.createJbpmContext();
		// jbpmContext.setSession(HibernateUtil.getSession());

		try {
			GraphSession graphSession = jbpmContext.getGraphSession();
			ProcessDefinition processdefinition = graphSession
					.findLatestProcessDefinition(processName);
			String curVersion = String.valueOf(processdefinition.getVersion());
			// 如果当前系统中的版本号与jbpm中的版本号不一致，那么不能创建工作流实例，而是抛出例外。
			// if (!curVersion.equals(processVersion)) {
			// throw new Exception("UnConsistentProcessVersion");
			// }
			// 此处创建流程实例
			ProcessInstance processInstance = new ProcessInstance(
					processdefinition);
			// 保存流程实例到数据库
			jbpmContext.save(processInstance);
			// 返回流程实例id
			long processId = processInstance.getId();

			return processId;

		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		} finally {
			// 关闭上下文环境，并提交请求，但是此处遇到了一个bug.主键冲突。
			jbpmContext.close();
		}
	}

	/**
	 * 启动工作流，离开start状态，进入到下一个节点
	 * 
	 * @param processId
	 */
	public long startProcess(long processId, String etipOperatorId) {
		JbpmContext jbpmContext = JbpmConfiguration.getInstance()
				.createJbpmContext();
		try {
			GraphSession graphSession = jbpmContext.getGraphSession();
			ProcessInstance process = graphSession
					.getProcessInstance(processId);
			// 此处需要设置流程实例的初始化人员是谁？
			process.getContextInstance().setVariable("creator", etipOperatorId);

			// 启动流程，进入第一个节点，流程中一定有一个startState
			// 此处判断startDate,rootName
			// if (!startStateName.equals(rootName)) {
			// throw new Exception("unConsistentProcessRootNode");
			// }
			// 执行工作流，并且设置下一个节点的创建者变量，创建者变量只有一个
			process.signal();
			TaskInstance taskInstance = (TaskInstance) process
					.getTaskMgmtInstance().getTaskInstances().iterator().next();
			// 此处需要判断第一个task节点中是否有creator变量，必须有，因为这里需要设置初始流程的权限。
			// VariableInstance vc =
			// taskInstance.getVariableInstance("creator");
			// if (vc == null) {
			// throw new ETIPError("processFirstNodeHasNotCreatorVariable");
			// }
			// if (!"creator".equals(vc.getName())) {
			// throw new ETIPError("processFirstNodeHasNotCreatorVariable");
			// }
			taskInstance.setActorId(etipOperatorId);
			taskInstance.setVariable("creator", etipOperatorId);
			jbpmContext.save(process);
			return taskInstance.getId();
		} finally {
			jbpmContext.close();
		}
	}

	/**
	 * 获取用户的所有JBPM原生任务并添加或去除代理执行人
	 */
	public void proxyTasks(String proxyedID, String proxyID, boolean flag) {
		JbpmContext jbpmContext = JbpmConfiguration.getInstance()
				.createJbpmContext();
		// 此处调用有错误,但是本地调用就无错，原因在哪里？
		try {
			TaskMgmtSession taskMgmtSession = jbpmContext.getTaskMgmtSession();

			// 以下需要从两个地方获取待办任务。
			List<TaskInstance> list = new ArrayList<TaskInstance>();
			List<TaskInstance> list1 = taskMgmtSession
					.findPooledTaskInstances(proxyedID);
			for (TaskInstance pooledTask : list1) {
				list.add(pooledTask);
			}

			if (flag) {
				for (TaskInstance t : list) {
					Set set = t.getPooledActors();
					Vector<String> actorVector = new Vector<String>();
					for(Object o : set){
						PooledActor p = (PooledActor)o;
						actorVector.addElement(p.getActorId());
					}
					actorVector.addElement(proxyID);
					String[] strs = new String[actorVector.size()];
					actorVector.copyInto(strs);
					t.setPooledActors(strs);
				}
			} else {
			}

		} finally {
			jbpmContext.close();
		}
	}

	/**
	 * 查询指定用户的待办任务，此处构造一个Map返回所有待办任务，但是不包括已经完成的任务 此处有问题，最好直接转换为json串
	 */
	public List<JBPMTask> getTaskList(String etipOperatorID) {
		JbpmContext jbpmContext = JbpmConfiguration.getInstance()
				.createJbpmContext();
		// 此处调用有错误,但是本地调用就无错，原因在哪里？
		try {
			TaskMgmtSession taskMgmtSession = jbpmContext.getTaskMgmtSession();

			// 以下需要从两个地方获取待办任务。
			List<TaskInstance> list = new ArrayList<TaskInstance>();
			List<TaskInstance> list1 = taskMgmtSession
					.findPooledTaskInstances(etipOperatorID);
			// System.out.println("list:"+list.size());
			// System.out.println("list1:"+list1.size());
			for (TaskInstance pooledTask : list1) {
				list.add(pooledTask);
			}
			List<JBPMTask> rvTasks = new ArrayList<JBPMTask>();
			for (int i = 0; i < list.size(); i++) {

				TaskInstance task = (TaskInstance) list.get(i);
				// 获取任务节点名称
				String taskName = task.getName();
				long taskId = task.getId();
				String processName = task.getProcessInstance()
						.getProcessDefinition().getName();
				long processId = task.getProcessInstance().getId();
				Date createDate = task.getCreate();
				Date startDate = task.getStart();
				Date endDate = task.getEnd();
				Date dueDate = task.getDueDate();
				String prviousActor = task.getPreviousActorId();

				// 将所有任务负责人拼成一个串
				Object[] taskActors = task.getPooledActors().toArray();
				String taskActorStr = "";
				for (Object taskActor : taskActors) {
					taskActorStr += taskActor.toString();
				}

				// 获取任务后续路径，注意此处无自动任务节点，都是手工驱动。
				List transitions = task.getTask().getTaskNode()
						.getLeavingTransitions();
				String leavingTransitionStr = "";
				for (int j = 0; j < transitions.size(); j++) {
					Transition trans = (Transition) transitions.get(j);
					String transName = trans.getName();
					if (j == 0)
						leavingTransitionStr = transName;
					else
						leavingTransitionStr += "," + transName;
				}

				// Map rvTask = new HashMap();
				JBPMTask rvTask = new JBPMTask();

				rvTask.setTaskName(taskName);
				rvTask.setTaskId(String.valueOf(taskId));
				rvTask.setProcessName(processName);
				rvTask.setProcessId(String.valueOf(processId));
				rvTask.setCreateDate(createDate);
				rvTask.setStartDate(startDate);
				rvTask.setDueDate(dueDate);
				rvTask.setEndDate(endDate);

				rvTask.setPrviousActor(prviousActor);
				rvTask.setTaskActors(taskActorStr);
				rvTask.setLeavingTransitions(leavingTransitionStr);
				rvTasks.add(rvTask);
			}
			return rvTasks;
			// JSONArray jsonArray = JSONArray.fromObject(rvTasks);
			// String jsonStrTasks = jsonArray.toString();
			// return jsonStrTasks;
		} finally {
			jbpmContext.close();
		}
	}

	/**
	 * 启动工作任务
	 */
	public void startTask(long taskID) {
		JbpmContext jbpmContext = JbpmConfiguration.getInstance()
				.createJbpmContext();
		try {
			TaskMgmtSession taskMgmtSession = jbpmContext.getTaskMgmtSession();
			TaskInstance taskInstance = taskMgmtSession.getTaskInstance(taskID);
			taskInstance.start();
			jbpmContext.save(taskInstance);
		} finally {
			jbpmContext.close();
		}
	}

	/**
	 * 完成工作任务,后续路径如何处理呢，如果有多条路径。
	 */
	public void doTask(long taskID) {
		JbpmContext jbpmContext = JbpmConfiguration.getInstance()
				.createJbpmContext();
		try {
			TaskMgmtSession taskMgmtSession = jbpmContext.getTaskMgmtSession();
			TaskInstance taskInstance = taskMgmtSession.getTaskInstance(taskID);
			taskInstance.setDueDate(new Date());
			jbpmContext.save(taskInstance);
		} finally {
			jbpmContext.close();
		}
	}

	/**
	 * 结束任务执行到指定路径
	 */
	public void endTaskToTransition(long taskID, String transitionName) {
		JbpmContext jbpmContext = JbpmConfiguration.getInstance()
				.createJbpmContext();
		try {
			TaskMgmtSession taskMgmtSession = jbpmContext.getTaskMgmtSession();
			TaskInstance taskInstance = taskMgmtSession.getTaskInstance(taskID);
			if (transitionName == null) {
				taskInstance.end();
			} else {
				if ("同意".equals(transitionName) || "不同意".equals(transitionName)) {
					taskInstance.getProcessInstance().getContextInstance()
							.setVariable("selectedTransition", transitionName);
				}
				taskInstance.end(transitionName);
			}
			jbpmContext.save(taskInstance);
		} finally {
			jbpmContext.close();
		}
	}

	/**
	 * 执行流程，到指定的迁移名称。
	 */
	public void submitProcess(long processinstanceID, String transitionName) {
		JbpmContext jbpmContext = JbpmConfiguration.getInstance()
				.createJbpmContext();
		try {
			GraphSession graphSession = jbpmContext.getGraphSession();
			ProcessInstance processInstance = graphSession
					.getProcessInstance(processinstanceID);
			// lihc
			Token t = processInstance.getRootToken();
			List taskInstances = jbpmContext.getTaskMgmtSession()
					.findTaskInstancesByToken(t.getId());
			if (taskInstances.size() == 0) {
				throw new ETIPError("noTaskInstances");
			}
			((TaskInstance) taskInstances.get(0)).end(transitionName);
			// processInstance.signal(transitionName);
		} finally {
			jbpmContext.close();
		}
	}

	/**
	 * 取消任务
	 */
	public void cancelProcess(long processinstanceID) {
		JbpmContext jbpmContext = JbpmConfiguration.getInstance()
				.createJbpmContext();
		try {
			GraphSession graphSession = jbpmContext.getGraphSession();
			ProcessInstance processInstance = graphSession
					.getProcessInstance(processinstanceID);
			// 关闭当前流程实例
			processInstance.end();
			// 取出当前流程实例中的所有任务，并将为关闭的任务关闭
			Collection tasks = processInstance.getTaskMgmtInstance()
					.getTaskInstances();
			for (Iterator iterator = tasks.iterator(); iterator.hasNext();) {
				TaskInstance taskInstance = (TaskInstance) iterator.next();
				if (!taskInstance.hasEnded()) {
					taskInstance.end();
				}
			}

		} finally {
			jbpmContext.close();
		}
	}

	/**
	 * 删除流程定义
	 */
	public void deleteProcess(String processName) {
		JbpmContext jbpmContext = JbpmConfiguration.getInstance()
				.createJbpmContext();
		try {
			ProcessDefinition pd = jbpmContext.getGraphSession()
					.findLatestProcessDefinition(processName);
			jbpmContext.getGraphSession().deleteProcessDefinition(pd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jbpmContext.close();
		}
	}

	/**
	 * 删除流程实例
	 */
	public void deleteProcessInstance(long processId) {
		JbpmContext jbpmContext = JbpmConfiguration.getInstance()
				.createJbpmContext();
		try {
			jbpmContext.getGraphSession().deleteProcessInstance(processId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jbpmContext.close();
		}
	}

}