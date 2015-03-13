package com.itour.etip.pub.kit.jbpm;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 工作流拦截器，自动进行工作流处理，并且跳转到指定的页面。
 * 
 * @author lishan
 * 
 */
public class JBPMInterceptor implements Interceptor {
	private static ApplicationContext JBPMContext = null;

	/**
	 * 工作流拦截业务逻辑处理，用于启动工作流、查询待办任务、推进工作流
	 * 1.启动工作流,要求传入参数，jbpmClassName,jbpmObjectId,jbpmStatus,满足启动条件
	 * a.jbpmClassName在ProcessRegistry中有注册
	 * b.jbpmClassName,jbpmObjectId在ProcessIntance没有查询到实例
	 * c.processName,jbpmStatus查询到taskName是StartState. 需要做下列处理： a.利用下列参数创建工作流实例：
	 * processName,processVersion：流程名称和版本号，利用pjbpmClassName从数据库表ProcessRegistry中查询获得
	 * jbpmClassName,jbpmObjectId：对象类名和对象实例，从参数中传入。
	 * etipOperatorId:当前用户，从session中获取，传入流程用作流程启动
	 * b.执行工作流，由startState节点进入到下一个任务节点，这时形成待办任务。
	 * c.利用processName,processVersion,processId,jbpmClassName,jbpmObjectId生成ProcessInstance实例。
	 * d.记录操作历史。
	 * 2.查询待办任务，要求传入参数,指示要得到待办任务：findMyJbpmTask,这个优先处理，从session中取当前任务，形成待办任务表。
	 * 3.由待办任务推进工作流，这时需要下列参数： processName:当前流程名称 jbpmTaskName：当前任务名称
	 * jbpmActionName：当前操作名称 jbpmTransitionName：操作时选择的迁移路径： jbpmClassName:当前对象类型
	 * jbpmObjectId:对象实例 jbpmStaus：操作后的状态 jbpmMemo：操作时输入备注信息。 推进工作流需要满足下列条件：
	 * a.jbpmClass，jbpmObjectId在ProcessInstance中有查询到processId,否则抛出错误，提示工作流未实例化。
	 * b.判断processId对应的process实例的状态，如果已经完成或终止,说明任务已经结束，不可能再进行操作。
	 * c.用户可以选择下列几个操作：start(启动),do(继续),endTo(执行转移到指定任务),cancel，取消当前流程。
	 * d.jbpmTransitionName,如果用户选择的是endTo,那么指定迁移的路线。 本业务执行下列操作：
	 * a.调用工作流引擎，推动工作流移动，形成新的待办任务。 b.如果流程执行成功，那么更新ProcessHistory表
	 */
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		try {
			/**
			 * 首先判断是否是ETIP框架的基础API,如果不是则不执行本拦截器
			 */
			if (!(actionInvocation.getAction() instanceof FrmAction)) {
				String result = actionInvocation.invoke();
				return result;
			}

			// 以下代码进行一些初始化处理，
			FrmUser user = FrmUser.getUser();
			HttpServletRequest request = ((FrmAction) actionInvocation
					.getAction()).getRequest();
			HttpServletResponse response = ((FrmAction) actionInvocation
					.getAction()).getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			// PrintWriter printWriter = response.getWriter();
			com.itour.etip.pub.frame.JdbcDao dao = (com.itour.etip.pub.frame.JdbcDao) com.itour.etip.pub.frame.SpringContextHelper
					.getBean("jdbc");

			/*
			 * 判断有无登录，如果未登录，则不执行本拦截器中的业务逻辑，因为所有的任务都需要人。
			 */
			if (user == null) {
				String value = actionInvocation.invoke();
				return value;
			}

			/**
			 * 以下正常执行业务逻辑，
			 */
			String result = actionInvocation.invoke();
			String jbpmClassName = (String) request
					.getAttribute("jbpmClassName");
			String jbpmObjectId = (String) request.getAttribute("jbpmObjectId");
			String jbpmStatus = (String) request.getAttribute("jbpmStatus");
			/*
			 * 如果三个工作流参数有一个为空,那么就抛例外
			 */
			if (jbpmClassName == null || jbpmObjectId == null
					|| jbpmStatus == null) {
				return result;
			}

			/*
			 * 检查b.jbpmClassName在ProcessRegistry中有注册
			 */
			String processNameSql = "select * from ProcessRegistry where jbpmClassName='"
					+ jbpmClassName + "' order by processVersion desc";
			List<ETIPResultSet> processRegistry = dao.queryForList(
					processNameSql, null);
			// 如果未配置工作流映射，无法创建流程实例
			if (processRegistry.size() == 0) {
				return result;
			}

			/*
			 * 检查processName,processVersion,jbpmStatus查询到taskName是StartState.
			 */
			String processName = processRegistry.get(0)
					.getString("PROCESSNAME");
			String processVersion = processRegistry.get(0).getString(
					"PROCESSVERSION");

			String taskNameSql = "select * from ProcessTransitionRegistry where processName='"
					+ processName
					+ "' and processVersion='"
					+ processVersion
					+ "' and taskStatus='" + jbpmStatus + "' and taskName='启动'";// 默认为启动
			List<ETIPResultSet> transitionRegistry = dao.queryForList(
					taskNameSql, null);
			// 如果当前状态不是工作流的初始状态，那么返回。
			if (transitionRegistry.size() == 0) {
				return result;
			}

			// 以下创建并启动流程实例，这时对象状态不会改变，还是当前值,但是此处需要记录操作历史
			String processId = createProcesInstance(processName,
					processVersion, jbpmClassName, jbpmObjectId,
					user.etipOperatorId);

			// 工作流创建完成时添加日志,此处直接操作子表，而不是更新主表子表,此处需要一个主键，不然有问题。
			// 此处直接操作子表，而不是更新主表子表,此处需要一个主键，不然有问题。
			java.util.Date curDate = new java.util.Date();
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
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
					+ "启动"
					+ "','"
					+ "启动"
					+ "','"
					+ jbpmStatus
					+ "','"
					+ jbpmStatus// 此处不改变工作流状态
					+ "','" + jbpmClassName + "','" + jbpmObjectId + "')";
			dao.executeSQL(historySql);

			// 然后添加变更历史，以上三个操作有事务问题
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 以下创建工作流实例新
	 */
	private String createProcesInstance(String processName,
			String processVersion, String jbpmClassName, String jbpmObjectId,
			String etipOperatorId) {
		/*
		 * 此处用于支持工作流引擎。
		 */
		IJBPMService jbpm = (IJBPMService)SpringContextHelper.getBean("JBPMClient");
		long processId = jbpm.createProcess(processName, processVersion);
		// 以下保存工作流实例与对象的映射，此处有主键问题。
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		String sql2 = "insert into ProcessInstance(id,processName,processVersion,jbpmClassName,jbpmProcessId,jbpmObjectId) values('"
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
				+ "')";
		com.itour.etip.pub.frame.JdbcDao dao = (com.itour.etip.pub.frame.JdbcDao) com.itour.etip.pub.frame.SpringContextHelper
				.getBean("jdbc");
		dao.executeSQL(sql2);
		// 如果流程创建成功，应该启动工作流，进入到下一个节点，以形成一个待办任务。
		startProcess(String.valueOf(processId), etipOperatorId);
		// 返回工作流
		return String.valueOf(processId);
	}

	/**
	 * 启动工作流，在实例初始化成功时调用
	 * 
	 * @param processId
	 */
	private void startProcess(String processId, String etipOperatorId) {
		// if (JBPMContext == null) {
		// JBPMContext = new ClassPathXmlApplicationContext(
		// "/WEB-INF/configuration/spring/applicationContext-jbpm-webservice.xml");
		// }
		// IJBPMService JBPM = (IJBPMService) JBPMContext.getBean("JBPM");
		//IJBPMService JBPM = new JBPMService();
		IJBPMService jbpm = (IJBPMService)SpringContextHelper.getBean("JBPMClient");
		// 此处执行任务时，需要初始化一个变量，确定任务的发起者是谁
		jbpm.startProcess(Long.parseLong(processId), etipOperatorId);
	}

	public void destroy() {
	}

	public void init() {
	}
}