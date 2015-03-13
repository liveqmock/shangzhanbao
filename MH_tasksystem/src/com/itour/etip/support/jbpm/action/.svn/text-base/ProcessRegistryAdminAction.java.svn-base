package com.itour.etip.support.jbpm.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.db.GraphSession;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.itour.etip.contract.EtipJBPMService;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.FrmData;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.itour.etip.pub.kit.exception.ETIPError;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.pub.kit.jbpm.JBPMTask;
import com.itour.etip.pub.kit.tool.DateTool;
import com.itour.etip.support.data.ProcessInstanceData;
import com.itour.etip.support.data.ProcessRegistryData;
import com.itour.etip.support.data.ProcessTaskRegistryData;
import com.itour.etip.support.data.ProcessTransitionRegistryData;
import com.itour.etip.support.data.UserTaskData;
import com.itour.etip.support.jbpm.facade.ProcessRegistryFacade;
import com.itour.etip.support.service.ProcessRegistryService;

public class ProcessRegistryAdminAction extends FrmAction {
	/**
	 * 流程注册Facade.
	 */
	private ProcessRegistryFacade processRegistryFacade;

	/**
	 * 返回流程注册的facade
	 * 
	 * @return
	 */
	public ProcessRegistryFacade getProcessRegistryFacade() {
		return processRegistryFacade;
	}

	/**
	 * 设置流程操作的facade
	 * 
	 * @param processRegistryFacade
	 */
	public void setProcessRegistryFacade(ProcessRegistryFacade processRegistryFacade) {
		this.processRegistryFacade = processRegistryFacade;
	}

	/**
	 * 注册工作流模板
	 */
	public String registerProcess() {
		String xmlTpl = request.getParameter("process");
		processRegistryFacade.registerProcess(xmlTpl);
		setJson("{success:true}");
		return null;
	}

	/**
	 * 删除工作流对象
	 * 
	 * @return
	 */
	public String deleteProcessRegistry() {

		return null;
	}

	/**
	 * 加载一个流程实例值，包括子表对象。
	 * 
	 * @return null;
	 */
	public String loadProcess() {
		JSONObject jsonData = (JSONObject) this.getJson();
		String id = jsonData.getString("id");
		ProcessRegistryData process = processRegistryFacade.getProcess(id);
		this.retrieveLazy(process, false);
		JSONObject json = JSONObject.fromObject(process);
		this.setJson(json);
		return null;
	}

	/**
	 * 加载一个流程实例值，包括子表对象。
	 * 
	 * @return null;
	 */
	public String updateProcess() {
		JSONObject jsonData = (JSONObject) this.getJson();
		ProcessRegistryData process = (ProcessRegistryData) JSONObject.toBean(jsonData, ProcessRegistryData.class);
		JSONArray tasks = jsonData.getJSONArray("tasks");
		List taskDatas = tasks.toList(tasks, ProcessTaskRegistryData.class);
		process.setTasks(taskDatas);

		JSONArray transitions = jsonData.getJSONArray("transitions");
		List transitionDatas = tasks.toList(transitions, ProcessTransitionRegistryData.class);
		process.setTransitions(transitionDatas);

		System.out.println(process.toMyString());
		// 此处需要将jsonData转换为process对象。
		ProcessRegistryData rv = processRegistryFacade.updateProcess(process);

		JSONObject json = JSONObject.fromObject(rv);
		this.setJson(json);
		// Map
		// baseMap=userMemberAdminFacade.watchUserMember(idOBJ.get("id").toString());
		return null;
	}

	/**
	 * 查询流程实例
	 * 
	 * @return 查询流程。
	 */
	public String searchProcess() {
		PageRoll pageRoll = new PageRoll();
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		pageRoll.setPageSize(Integer.valueOf(limit));
		pageRoll.setStartRow(Integer.valueOf(start));
		Object conditionObj = getJson();
		JSONObject condition = JSONObject.fromObject(conditionObj);
		List<ProcessRegistryData> rvList = processRegistryFacade.getProcessRegistries(pageRoll, condition);
		this.removeLazy(rvList);
		String rvJson = getListJsonStr(pageRoll, rvList);
		setJson(rvJson);
		return null;
	}

	/**
	 * 返回已办理的任务
	 */
	public void getProcessedList() {
		FrmUser user = this.getFrmUser();
		JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance();
		JbpmContext jbpmContext = jbpmConfiguration.createJbpmContext();
		GraphSession graphSession = jbpmContext.getGraphSession();
		Session session = jbpmContext.getSession();
		List taskInstanceList = new ArrayList();
		List<JBPMTask> taskList = new ArrayList<JBPMTask>();
		List<Long> processIDList = new ArrayList<Long>();
		List<UserTaskData> rvTasks = new ArrayList<UserTaskData>();

		try {
			Query query = session
					.createQuery("select distinct ti from org.jbpm.taskmgmt.exe.TaskInstance as ti,org.jbpm.taskmgmt.exe.PooledActor pi "
							// + "where ti.end is null "
							+ "where ti.end is not null and ti.processInstance in ( select t.processInstance from org.jbpm.taskmgmt.exe.TaskInstance as t where t.end is null) "
							+ "and ((pi.actorId =  :actorId and pi = any elements(ti.pooledActors))) or ti.actorId=:actorId");
			// Query query = session
			// .createQuery("select ti from org.jbpm.taskmgmt.exe.PooledActor as ti "
			// + "where ti.actorId = :actorId ");
			query.setString("actorId", user.etipOperatorId);
			taskInstanceList = query.list();

			for (int i = 0; i < taskInstanceList.size(); i++) {

				TaskInstance task = (TaskInstance) taskInstanceList.get(i);
				long processId = task.getProcessInstance().getId();
				if (processIDList.contains(processId)) {
					continue;
				}

				processIDList.add(processId);
				// 查询最新任务ID
				ProcessInstance processInstance = graphSession.getProcessInstance(processId);
				Token t = processInstance.getRootToken();
				List taskInstances = jbpmContext.getTaskMgmtSession().findTaskInstancesByToken(t.getId());
				if (taskInstances.size() == 0) {
					continue;
				}
				task = (TaskInstance) taskInstances.get(0);
				// 获取任务节点名称
				String taskName = task.getName();
				long taskId = task.getId();
				String processName = task.getProcessInstance().getProcessDefinition().getName();
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
				List transitions = task.getTask().getTaskNode().getLeavingTransitions();
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
				taskList.add(rvTask);
			}

			String processIDs = "";
			for (JBPMTask jbpmTask : taskList) {
				// Map taskMap = (Map) taskObj;
				UserTaskData task = new UserTaskData();
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
				task.setJbpmType("processed");
				rvTasks.add(task);
			}
			// 此处根据processIDs从ProcessInstance中查询jbpmClassName,jbpmObjectId,jbpmStatus
			if (rvTasks.size() > 0) {
				processIDs = processIDs.substring(0, processIDs.length() - 1);
				ProcessRegistryService processRegistryService = new ProcessRegistryService();
				List<ProcessInstanceData> instances = processRegistryService.getProcessInstances(processIDs);
				Map<String, ProcessInstanceData> instanceMap = new TreeMap<String, ProcessInstanceData>();
				for (ProcessInstanceData instance : instances) {
					instanceMap.put(instance.getJbpmProcessID(), instance);
				}

				// 以下载task中添加属性
				for (UserTaskData task : rvTasks) {
					ProcessInstanceData instance = instanceMap.get(task.getProcessId());
					if (instance != null) {// lihc修改
						task.setJbpmClassName(instance.getJbpmClassName());
						task.setJbpmStatus(instance.getProcessStatus());
						task.setJbpmObjectId(instance.getJbpmObjectID());
						/*SettlementData sett = settlementFacade.getSettlement(task.getJbpmObjectId());
						if(sett!=null){//?????? 怎么出来的空 ?????
							task.setJbpmCreater(sett.getCreateid());
							task.setObjectTransType(sett.getTransactionstype());
							task.setObjectServicesCode(sett.getServicescode());
							task.setAmount(DataFormatUtil.toDecimal(sett.getTransactionsmoney()));
							task.setTransferDate(sett.getTransactionsdate());
							task.setTargetName(sett.getTargetname());
						}*/
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jbpmContext.close();
		}
		Collections.reverse(rvTasks);
		PageRoll pageRoll = new PageRoll();
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		pageRoll.setPageSize(Integer.valueOf(limit));
		pageRoll.setStartRow(Integer.valueOf(start));
		pageRoll.setTotalRows(rvTasks.size());
		if (Integer.parseInt(limit) + Integer.parseInt(start) > rvTasks.size()) {
			rvTasks = rvTasks.subList(Integer.parseInt(start), rvTasks.size());
		} else {
			rvTasks = rvTasks.subList(Integer.parseInt(start), Integer.parseInt(limit) + Integer.parseInt(start));
		}
		String rvJson = getListJsonStr(pageRoll, rvTasks);
		setJson(rvJson);
	}

	/**
	 * 返回用户待办任务列表
	 * 
	 * @return
	 */
	public String getTaskList() {
		FrmUser user = this.getFrmUser();
		List<UserTaskData> userTasks = processRegistryFacade.getTaskList(user.etipOperatorId);

		// 以下载task中添加属性
		for (UserTaskData task : userTasks) {
//			SettlementData sett = settlementFacade.getSettlement(task.getJbpmObjectId());
//			task.setJbpmCreater(sett.getCreateid());
//			task.setObjectTransType(sett.getTransactionstype());
//			task.setObjectServicesCode(sett.getServicescode());
//			//task.setAmount(String.valueOf(sett.getTransactionsmoney()));
//			task.setAmount(DataFormatUtil.toDecimal(sett.getTransactionsmoney()));
//			task.setTransferDate(sett.getTransactionsdate());
//			task.setTargetName(sett.getTargetname());
		}
		Collections.reverse(userTasks);
		PageRoll pageRoll = new PageRoll();
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		pageRoll.setPageSize(Integer.valueOf(limit));
		pageRoll.setStartRow(Integer.valueOf(start));
		pageRoll.setTotalRows(userTasks.size());
		if (Integer.parseInt(limit) + Integer.parseInt(start) > userTasks.size()) {
			userTasks = userTasks.subList(Integer.parseInt(start), userTasks.size());
		} else {
			userTasks = userTasks.subList(Integer.parseInt(start), Integer.parseInt(limit) + Integer.parseInt(start));
		}
		String rvJson = getListJsonStr(pageRoll, userTasks);
		setJson(rvJson);
		return null;
	}

	/**
	 * 返回所选对象的工作流操作历史
	 * 
	 * @return
	 */
	public String getTaskHistoryList() {
		if (!((JSONObject) this.getJson()).containsKey("id")) {
			throw new ETIPException("NoJbpmObjectId");
		}
		String jbpmObjectId = ((JSONObject) this.getJson()).getString("id");
		com.itour.etip.pub.frame.JdbcDao dao = (com.itour.etip.pub.frame.JdbcDao) com.itour.etip.pub.frame.SpringContextHelper
				.getBean("jdbc");

		/*
		 * 检查b.jbpmClassName在ProcessRegistry中有注册
		 */
		String processNameSql = "select * from processhistory where jbpmobjectid='" + jbpmObjectId + "'";
		List<ETIPResultSet> processHistoryList = dao.queryForList(processNameSql, null);
		JSONArray jsonList = new JSONArray();

		for (ETIPResultSet resuleSet : processHistoryList) {
			JSONObject jeson = new JSONObject();

			jeson.put("taskName", resuleSet.get("TASKNAME"));
			jeson.put("taskStatus", resuleSet.get("TASKSTATUS"));
			jeson.put("transitionName", resuleSet.get("TRANSITIONNAME"));
			jeson.put("transitionStatus", resuleSet.get("TRANSITIONSTATUS"));
			String operatorName = (String) ((Map) CacheUtil.getInstance().dbCache.getDBCache("UserIDName").get(
					(String) resuleSet.get("OPERATORID"))).get("CHINESENAME");
			jeson.put("operatorName", operatorName);
			String operatorOrg = (String) ((Map) CacheUtil.getInstance().dbCache.getDBCache("OrgIDName").get(
					(String) resuleSet.get("ORPERATORORGID"))).get("CHINESENAME");
			jeson.put("operatorOrg", operatorOrg);
			jeson.put("operateDate", DateTool.format((Date) resuleSet.get("OPERATEDATE"), "yyyy-MM-dd"));
			jsonList.add(jeson);
		}

		/*
		 * List list =new ArrayList(); for(int i=0 ;i
		 * <processHistoryList.size();i++){ processHistoryList.get(i).g }
		 */

		// PageRoll pageRoll = new PageRoll();
		/*
		 * String start = request.getParameter("start"); String limit =
		 * request.getParameter("limit");
		 * pageRoll.setPageSize(Integer.valueOf(limit));
		 * pageRoll.setStartRow(Integer.valueOf(start));
		 */
		// String rvJson = DateTool.getJSONArray(returnList,
		// "yyyy-MM-dd").toString();
		// String rvJson = getListJsonStr(pageRoll, returnList);
		System.out.println(jsonList.toString());
		setJson(jsonList.toString());
		return null;
	}

	/**
	 * 提交时创建工作流实例，而不是通过拦截器自动匹配，暂时让拦截器失效。
	 * 
	 * @return
	 */
	public String createProcessInstance() {
		FrmUser user = this.getFrmUser();
		com.itour.etip.pub.frame.JdbcDao dao = (com.itour.etip.pub.frame.JdbcDao) com.itour.etip.pub.frame.SpringContextHelper
				.getBean("jdbc");
		String jbpmClassName = request.getParameter("jbpmClassName");
		String jbpmObjectId = request.getParameter("jbpmObjectId");
		String jbpmStatus = request.getParameter("jbpmStatus");
		String processName = request.getParameter("processName");
		/*
		 * 如果三个工作流参数有一个为空,那么就抛例外
		 */
		if (jbpmClassName == null || jbpmObjectId == null || jbpmStatus == null || processName == null) {
			throw new ETIPException("ProcessParameterNotSet");
		}
		/*
		 * 检查b.jbpmClassName在ProcessRegistry中有注册
		 */
		String processNameSql = "select * from ProcessRegistry where jbpmClassName='" + jbpmClassName + "' and processname  = '"
				+ processName + "' order by processVersion desc";
		List<ETIPResultSet> processRegistry = dao.queryForList(processNameSql, null);
		// 如果未配置工作流映射，无法创建流程实例
		if (processRegistry.size() == 0) {
			throw new ETIPException("NoProcessRegistry");
		}
		/*
		 * 检查processName,processVersion,jbpmStatus查询到taskName是StartState.
		 */
		processName = processRegistry.get(0).getString("PROCESSNAME");
		String processVersion = processRegistry.get(0).getString("PROCESSVERSION");

		String taskNameSql = "select * from ProcessTransitionRegistry where processName='" + processName + "' and processVersion='"
				+ processVersion + "' and taskStatus='" + jbpmStatus + "' and taskName='启动'";// 默认为启动
		List<ETIPResultSet> transitionRegistry = dao.queryForList(taskNameSql, null);
		// 如果当前状态不是工作流的初始状态，那么返回。
		if (transitionRegistry.size() == 0) {
			throw new ETIPException("UnConsistentStartState");
		}

		// 首先检查当前对象是否存在工作流实例，如果存在则获取实例id,执行提交。此处需要知道当前任务节点taskid

		String processId = "0";// 当前流程实例ID
		String taskName = transitionRegistry.get(0).getString("TASKNAME");// 当前任务名称
		String transitionName = transitionRegistry.get(0).getString("TRANSITIONNAME");// 指定要流转的迁移名称

		String precessMyObjectSql = "select * from processinstance pi where pi.JBPMCLASSNAME = '" + jbpmClassName
				+ "' and pi.JBPMOBJECTID = '" + jbpmObjectId + "'";
		List<ETIPResultSet> precessMyObjectList = dao.queryForList(precessMyObjectSql, null);
		if (precessMyObjectList.size() > 1) {
			throw new ETIPException("WrongSizeOfProcessInstance");
		} else if (precessMyObjectList.size() == 1) {
			throw new ETIPException("ToTaskList");
		} else {
			// 否则创建并启动流程实例，这时对象状态不会改变，还是当前值,但是此处需要记录操作历史
			try {
				processId = createProcesInstance(processName, processVersion, jbpmClassName, jbpmObjectId, user.etipOperatorId, taskName,
						transitionName);
			} catch (Exception e) {
				throw new ETIPException("EtipJbpmActorHandlerError", "*:没有找到下一环节执行人，流程提交失败!");
			}
			taskName = "启动";
			transitionName = "初始化";
		}
		// 工作流创建完成时添加日志,此处直接操作子表，而不是更新主表子表,此处需要一个主键，不然有问题。
		// 此处直接操作子表，而不是更新主表子表,此处需要一个主键，不然有问题。
		java.util.Date curDate = new java.util.Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String uuid = UUID.randomUUID().toString().replace("-", "");

		String historySql = "insert into ProcessHistory(id,jbpmProcessId,orperatorOrgId,operatorId,operateDate,operateMemo,processName,taskName,transitionName,taskStatus,transitionStatus,jbpmClassName,jbpmObjectId) values('"
				+ uuid
				+ "','"
				+ processId
				+ "','"
				+ user.etipOperatorOrgId
				+ "','"
				+ user.etipOperatorId
				+ "',to_date('"
				+ format.format(curDate)
				+ "','yyyy-mm-dd hh24:mi:ss'),'"
				+ "启动工作流"
				+ "','"
				+ transitionRegistry.get(0).getString("PROCESSNAME")
				+ "','"
				+ taskName
				+ "','"
				+ transitionName
				+ "','"
				+ jbpmStatus
				+ "','" + jbpmStatus// 此处不改变工作流状态
				+ "','" + jbpmClassName + "','" + jbpmObjectId + "')";
		dao.executeSQL(historySql);

		return null;
	}

	/**
	 * 以下创建工作流实例新
	 * 
	 * @param transitionName
	 * @param taskName
	 * @throws Exception
	 */
	private String createProcesInstance(String processName, String processVersion, String jbpmClassName, String jbpmObjectId,
			String etipOperatorId, String taskName, String transitionName) throws Exception {
		/*
		 * 此处用于支持工作流引擎。
		 */
		EtipJBPMService jbpm = new EtipJBPMService();
		/*
		 * IJBPMService jbpm = (IJBPMService) SpringContextHelper
		 * .getBean("JBPMClient");
		 */
		long processId = jbpm.createProcess(processName, processVersion);
		// 以下保存工作流实例与对象的映射，此处有主键问题。
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		String sql2 = "insert into ProcessInstance(id,processName,processVersion,jbpmClassName,jbpmProcessId,jbpmObjectId,processstatus) values('"
				+ uuid
				+ "','"
				+ processName
				+ "','"
				+ processVersion
				+ "','"
				+ jbpmClassName
				+ "','"
				+ processId
				+ "','"
				+ jbpmObjectId
				+ "','0')";
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		dao.executeSQL(sql2);
		try {
			// 如果流程创建成功，应该启动工作流，进入到下一个节点，以形成一个待办任务。此处不能是提交节点。开始节点就应该是提交节点
			long jbpmTaskId = jbpm.startProcess(processId, etipOperatorId);
			// 再执行一步，完成提交动作。
			// endTaskToTransition(jbpmTaskId, null);
			// 改变当前对象状态，此处默认为提交任务，迁移名称是"送审批"
			JSONObject jbpmObject = new JSONObject();
			jbpmObject.element("actionName", "提交");
			jbpmObject.element("processName", processName);
			//changeObjectStatus("endTo", jbpmClassName, processName, processVersion, taskName, transitionName, dao, jbpmObjectId, "",
			//		jbpmObject);
		} catch (Exception e) {
			dao.executeSQL("delete from ProcessInstance where id='" + uuid + "'");
			throw e;
		}
		// 返回工作流
		return String.valueOf(processId);
	}

	/**
	 * 返回业务流程对象实例，参数在json中获取：jbpmClassName,jbpmObjectId
	 * 由于对象不同，要求提供不用的节目进行显示，这个最好做成通用的。
	 * 
	 * @return
	 */
	public String getProcessObject() {
		JSONObject jsonData = (JSONObject) this.getJson();
		String jbpmClassName = jsonData.getString("jbpmClassName");
		String jbpmObjectId = jsonData.getString("jbpmObjectId");
		FrmData data = processRegistryFacade.getProcessObject(jbpmClassName, jbpmObjectId);
		// data类型虽然不同，最好提供相同的显示界面，这样系统扩展就容易了。
		// JSONObject json = JSONObject.fromObject(data);
		JSONObject json = JSONObject.fromObject(DateTool.getJSONString(data, "yyyy-MM-dd"));
		this.setJson(json);
		return null;
	}

	/**
	 * 执行工作流任务，此处将拦截器中的任务转移到这里执行。
	 * 
	 * @return
	 */
	public String doProcessTask() {
		JSONObject jsonData = (JSONObject) this.getJson();
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		FrmUser user = getFrmUser();
		/**
		 * 以下准备基本参数
		 */
		String jbpmActionName = jsonData.getString("jbpmActionName");
		if (jbpmActionName == null) {
			throw new ETIPError("NoSetJbpmActionName");
		}
		String jbpmTaskId = jsonData.getString("jbpmTaskId");// 此处需要知道taskID
		if (jbpmTaskId == null) {
			throw new ETIPError("NotSetJbpmJbpmTaskId");
		}

		String jbpmTransitionName = jsonData.getString("jbpmTransitionName");
		if (jbpmTransitionName == null) {
			throw new ETIPError("CanNotDoTaskBecauseOfNoJbpmTransitionName");
		}

		String jbpmObjectId = jsonData.getString("jbpmObjectId");

		if (jbpmObjectId == null) {
			throw new ETIPError("CanNotDoTaskBecauseOfNoJbpmObjectId");
		}
		String jbpmClassName = jsonData.getString("jbpmClassName");
		if (jbpmClassName == null) {
			throw new ETIPError("CanNotDoTaskBecauseOfNoJbpmClassName");
		}

		String jbpmTaskName = jsonData.getString("jbpmTaskName");
		if (jbpmTaskName == null) {
			throw new ETIPError("CanNotDoTaskBecauseOfNoJbpmTaskName");
		}

		// 以下代码查询processInstanceID,jbpmProcessId
		String processIDSql = "select jbpmProcessId,id,processVersion,processName from ProcessInstance where jbpmObjectId='" + jbpmObjectId
				+ "' and jbpmClassName='" + jbpmClassName + "' and processstatus='0'";
		List<ETIPResultSet> processInstanceIds = dao.queryForList(processIDSql, null);

		// 如果工作流实例已经存在多份，那么是系统例外，一个对象只能有一份工作流实例。
		if (processInstanceIds.size() > 1) {
			throw new ETIPError("WrongSizeOfProcessInstance");
		}
		if (processInstanceIds.size() == 0) {
			throw new ETIPError("NoProcessIdForObject");
		}
		String jbpmProcessId = processInstanceIds.get(0).getString("JBPMPROCESSID");
		String processVersion = processInstanceIds.get(0).getString("PROCESSVERSION");
		String processName = processInstanceIds.get(0).getString("PROCESSNAME");
		String pid = processInstanceIds.get(0).getString("ID");

		JSONObject jbpmObject = new JSONObject();
		jbpmObject.element("jbpmObject", jsonData.get("jbpmObject"));
		jbpmObject.element("actionName", jbpmTransitionName);
		jbpmObject.element("processName", processName);

		// 以下查询当前工作流迁移的状态迁移关系，重点是jbpmTransitionName!=null
		String taskStatus = null;
		String transitionStatus = null;
		String transitionToTaskName = null;

		String getNextStatusSql = "select taskStatus,transitionStatus,transitiontaskname from ProcessTransitionRegistry where processName='" + processName
				+ "' and processVersion='" + processVersion + "' and taskName='" + jbpmTaskName + "'  and transitionName='"
				+ jbpmTransitionName + "'";
		// 以下获取transitionStatus
		List<ETIPResultSet> transitions = dao.queryForList(getNextStatusSql, null);
		if (transitions.size() == 0 && !(jbpmActionName.equals("cancel"))) {
			throw new ETIPError("NoTransitionStatusSet");
		}
		if (transitions.size() > 1) {
			throw new ETIPError("MoreThanOneTransitionStatusSet");
		}

		// 状态管理
		if (!(jbpmActionName.equals("cancel"))) {
			taskStatus = transitions.get(0).getString("TASKSTATUS");
			transitionStatus = transitions.get(0).getString("TRANSITIONSTATUS");
			transitionToTaskName = transitions.get(0).getString("TRANSITIONTASKNAME");
		}
		String jbpmMemo = jsonData.getString("jbpmMemo");

		// // 执行工作流
		doProcess(jbpmActionName, jbpmTransitionName, jbpmTaskId, jbpmProcessId);
		// 变更对象状态
		//changeObjectStatus(jbpmActionName, jbpmClassName, processName, processVersion, jbpmTaskName, jbpmTransitionName, dao, jbpmObjectId,
		//		jbpmMemo, jbpmObject);

		// 此处直接操作子表，而不是更新主表子表,此处需要一个主键，不然有问题。
		java.util.Date curDate = new java.util.Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String uuid = UUID.randomUUID().toString().replace("-", "");
		String historySql = "insert into ProcessHistory(id,jbpmProcessId,orperatorOrgId,operatorId,operateDate,operateMemo,processName,taskName,transitionName,taskStatus,transitionStatus,jbpmClassName,jbpmObjectId) values('"
				+ uuid
				+ "','"
				+ jbpmProcessId
				+ "','"
				+ user.etipOperatorOrgId
				+ "','"
				+ user.etipOperatorId
				+ "',to_date('"
				+ format.format(curDate)
				+ "','yyyy-mm-dd hh24:mi:ss'),'"
				+ jbpmMemo
				+ "','"
				+ processName
				+ "','"
				+ jbpmTaskName
				+ "','"
				+ jbpmTransitionName + "','" + taskStatus + "','" + transitionStatus + "','" + jbpmClassName + "','" + jbpmObjectId + "')";

		dao.executeSQL(historySql);
		if (transitionToTaskName != null && !("".equals(transitionToTaskName.trim())) && "end1".equals(transitionToTaskName)) {
			String mSQL = "update processinstance p set p.processstatus=1 where p.id='" + pid + "' and p.processName='" + processName
					+ "' and p.jbpmobjectid='" + jbpmObjectId + "' and p.processstatus=0";
			dao.executeSQL(mSQL);
		}
		if (processName.equals("结售汇流程") && transitionStatus.equals("待支付")) {
		//	SettlementData settlement = settlementFacade.getSettlement(jbpmObjectId);
		//	ExchangeSettlement(settlement);
		}
		return null;
	}

	private void doProcess(String jbpmActionName, String jbpmTransitionName, String jbpmTaskId, String jbpmProcessId) {
		/*
		 * 已经具有工作流实例了，则推动工作流，推进工作流需要满足下列条件：
		 * a.jbpmClass，jbpmObjectId在ProcessInstance中有查询到processId
		 * ,否则抛出错误，提示工作流未实例化。
		 * b.判断processId对应的process实例的状态，如果已经完成或终止,说明任务已经结束，不可能再进行操作。
		 * c.用户可以选择下列几个操作：start(启动),do(继续),endTo(执行转移到指定任务),cancel，取消当前流程。
		 * d.jbpmTransitionName,如果用户选择的是endTo,那么指定迁移的路线。
		 */
		/* 根据任务名称执行任务。 */
		if (jbpmActionName.equals("start")) {
			startTask(Long.parseLong(jbpmTaskId));
		} else if (jbpmActionName.equals("endTo")) {
			endTaskToTransition(Long.parseLong(jbpmTaskId), jbpmTransitionName);
		} else if (jbpmActionName.equals("do")) {
			doTask(Long.parseLong(jbpmTaskId));
		} else if (jbpmActionName.equals("cancel")) {
			// 此处应该是流程Id
			//cancelProcess(Long.parseLong(jbpmProcessId));
		} else {
			throw new ETIPError("WrongActionSetToRunJbpm");
		}

	}

	/**
	 * 执行指定的任务，此处需要任务Id。
	 * 
	 * @param taskId
	 */
	private void startTask(long taskId) {
		EtipJBPMService jbpm = new EtipJBPMService();
		/*
		 * IJBPMService jbpm = (IJBPMService) SpringContextHelper
		 * .getBean("JBPMClient");
		 */
		jbpm.startTask(taskId);
	}

	/**
	 * 执行指定的任务，但是不改变状态，而是改变当前时间。
	 * 
	 * @param taskId
	 */
	private void doTask(long taskId) {
		EtipJBPMService jbpm = new EtipJBPMService();
		/*
		 * IJBPMService jbpm = (IJBPMService) SpringContextHelper
		 * .getBean("JBPMClient");
		 */
		jbpm.doTask(taskId);
	}

	/**
	 * 执行任务，到指定的转移路径
	 * 
	 * @param taskId
	 * @param transitionname
	 *            可以为空，这时选择第一个路径执行
	 */
	private void endTaskToTransition(long taskId, String transitionName) {
		EtipJBPMService jbpm = new EtipJBPMService();
		/*
		 * IJBPMService jbpm = (IJBPMService) SpringContextHelper
		 * .getBean("JBPMClient");
		 */
		jbpm.endTaskToTransition(taskId, transitionName);
	}

	/**
	 * 执行流程，到指定的迁移名称。
	 * 
	 * @param processinstanceID
	 *            当前流程的ID
	 * @param transitionName
	 *            执行流程时所走的迁移名称
	 */
	public void submitProcess(long processinstanceID, String transitionName) {
		EtipJBPMService jbpm = new EtipJBPMService();
		// IJBPMService jbpm = (IJBPMService)
		// SpringContextHelper.getBean("JBPMClient");
		jbpm.submitProcess(processinstanceID, transitionName);
	}

	/**
	 * 终止当前工作流。
	 *
	private void cancelProcess(long processId) {
		EtipJBPMService jbpm = new EtipJBPMService();
		/*
		 * IJBPMService jbpm = (IJBPMService) SpringContextHelper
		 * .getBean("JBPMClient");
		 *
		jbpm.cancelProcess(processId);
	}

	private void changeObjectStatus(String jbpmActionName, String jbpmClassName, String jbpmProcessName, String jbpmProcessVersion,
			String jbpmTaskName, String jbpmTransitionName, JdbcDao dao, String jbpmObjectId, String jbpmMemo, JSONObject jbpmObject) {
		/*
		 * 如果工作流驱动成功，首先修改对象实例当前状态,该状态值从数据库表中查询 a.start,do不改变状态，但是要记录历史记录
		 * b.endTo,cancel要改变状态。
		 *
		// 处理意见
		String opinion = jbpmMemo;

		if (jbpmActionName.equals("endTo") || jbpmActionName.equals("cancel")) {
			// 此处需要知道jbpmClassName对应的工作流版本中，当前迁移执行后的状态值
			String getNextStatusSql = "select transitionStatus from ProcessTransitionRegistry where processName='" + jbpmProcessName
					+ "' and processVersion='" + jbpmProcessVersion + "' and taskName='" + jbpmTaskName + "'  and transitionName='"
					+ jbpmTransitionName + "'";
			// 以下获取transitionStatus
			List<ETIPResultSet> transitions = dao.queryForList(getNextStatusSql, null);
			if (transitions.size() == 0 && !(jbpmActionName.equals("cancel"))) {
				throw new ETIPError("NoTransitionStatusSet");
			}
			if (transitions.size() > 1) {
				throw new ETIPError("MoreThanOneTransitionStatusSet");
			}

			String transitionStatus;// 修改后数据的状态
			if (jbpmActionName.equals("cancel")) {
				transitionStatus = "99";// 设置为异常终止状态
			} else {
				transitionStatus = transitions.get(0).getString("TRANSITIONSTATUS");
			}
			SettlementData settlement = settlementFacade.getSettlement(jbpmObjectId);
			settlement.setStatus(transitionStatus);
			// 改变状态和记录流程信息
			settlementFacade.addSettlementTache(settlement, jbpmTaskName, opinion, jbpmObject);
			// 结售汇流程付款待支付状态需要启动新的流程

		}
	}*/

	/**
	 * 结售汇流程结束后需要为每个业务处理结售汇支付
	 * 
	 * @param settlement
	 
	private void ExchangeSettlement(SettlementData settlement) {
		HibernateDao dao = (HibernateDao) SpringContextHelper.getBean("hibernate");
		String servicecode = settlement.getServicescode().split("-")[0];
		String hql = " from SettlementData s where s.settlementtype='" + settlement.getSettlementtype() + "' and s.servicescode like '"
				+ servicecode + "%'";
		List<? extends IData> updateList = dao.search(hql);
		for (IData sett : updateList) {
			createProcessInstance((SettlementData) sett);
		}
	}*/

	/**
	 * 结售汇支付启动流程
	 
	private String createProcessInstance(SettlementData settlement) {
		FrmUser user = this.getFrmUser();
		JdbcDao dao = (com.itour.etip.pub.frame.JdbcDao) SpringContextHelper.getBean("jdbc");
		String jbpmClassName = "SettlementData";
		String jbpmObjectId = settlement.getId();
		String jbpmStatus = "待支付";
		String processName = "结售汇支付";
		/*
		 * 如果三个工作流参数有一个为空,那么就抛例外
		 *
		if (jbpmClassName == null || jbpmObjectId == null || jbpmStatus == null || processName == null) {
			throw new ETIPException("ProcessParameterNotSet");
		}
		/*
		 * 检查b.jbpmClassName在ProcessRegistry中有注册
		 *
		String processNameSql = "select * from ProcessRegistry where jbpmClassName='" + jbpmClassName + "' and processname  = '"
				+ processName + "' order by processVersion desc";
		List<ETIPResultSet> processRegistry = dao.queryForList(processNameSql, null);
		// 如果未配置工作流映射，无法创建流程实例
		if (processRegistry.size() == 0) {
			throw new ETIPException("NoProcessRegistry");
		}
		/*
		 * 检查processName,processVersion,jbpmStatus查询到taskName是StartState.
		 *
		processName = processRegistry.get(0).getString("PROCESSNAME");
		String processVersion = processRegistry.get(0).getString("PROCESSVERSION");

		String taskNameSql = "select * from ProcessTransitionRegistry where processName='" + processName + "' and processVersion='"
				+ processVersion + "' and taskStatus='" + jbpmStatus + "' and taskName='启动'";// 默认为启动
		List<ETIPResultSet> transitionRegistry = dao.queryForList(taskNameSql, null);
		// 如果当前状态不是工作流的初始状态，那么返回。
		if (transitionRegistry.size() == 0) {
			throw new ETIPException("UnConsistentStartState");
		}

		// 首先检查当前对象是否存在工作流实例，如果存在则获取实例id,执行提交。此处需要知道当前任务节点taskid

		String processId = "0";// 当前流程实例ID
		String taskName = transitionRegistry.get(0).getString("TASKNAME");// 当前任务名称
		String transitionName = transitionRegistry.get(0).getString("TRANSITIONNAME");// 指定要流转的迁移名称

		String precessMyObjectSql = "select * from processinstance pi where pi.JBPMCLASSNAME = '" + jbpmClassName
				+ "' and pi.JBPMOBJECTID = '" + jbpmObjectId + "' and processstatus ='0'";
		List<ETIPResultSet> precessMyObjectList = dao.queryForList(precessMyObjectSql, null);
		if (precessMyObjectList.size() > 1) {
			throw new ETIPException("WrongSizeOfProcessInstance");
		} else if (precessMyObjectList.size() == 1) {
			throw new ETIPException("ToTaskList");
		} else {
			// 否则创建并启动流程实例，这时对象状态不会改变，还是当前值,但是此处需要记录操作历史
			try {
				processId = createProcesInstance(processName, processVersion, jbpmClassName, jbpmObjectId, user.etipOperatorId, taskName,
						transitionName);
			} catch (Exception e) {
				throw new ETIPException("EtipJbpmActorHandlerError", "*:没有找到下一环节执行人，流程提交失败!");
			}
			taskName = "启动";
			transitionName = "初始化";
		}
		// 工作流创建完成时添加日志,此处直接操作子表，而不是更新主表子表,此处需要一个主键，不然有问题。
		// 此处直接操作子表，而不是更新主表子表,此处需要一个主键，不然有问题。
		java.util.Date curDate = new java.util.Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String uuid = UUID.randomUUID().toString().replace("-", "");

		String historySql = "insert into ProcessHistory(id,jbpmProcessId,orperatorOrgId,operatorId,operateDate,operateMemo,processName,taskName,transitionName,taskStatus,transitionStatus,jbpmClassName,jbpmObjectId) values('"
				+ uuid
				+ "','"
				+ processId
				+ "','"
				+ user.etipOperatorOrgId
				+ "','"
				+ user.etipOperatorId
				+ "',to_date('"
				+ format.format(curDate)
				+ "','yyyy-mm-dd hh24:mi:ss'),'"
				+ "启动工作流"
				+ "','"
				+ transitionRegistry.get(0).getString("PROCESSNAME")
				+ "','"
				+ taskName
				+ "','"
				+ transitionName
				+ "','"
				+ jbpmStatus
				+ "','" + jbpmStatus// 此处不改变工作流状态
				+ "','" + jbpmClassName + "','" + jbpmObjectId + "')";
		dao.executeSQL(historySql);

		return null;
	}*/
}
