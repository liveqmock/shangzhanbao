package com.itour.etip.pub.kit.jbpm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.def.AssignmentHandler;
import org.jbpm.taskmgmt.def.Task;
import org.jbpm.taskmgmt.exe.Assignable;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;

//import com.itour.etip.pub.kit.exception.ETIPError;

/**
 * 给工作流任务指定授权角色 。
 * 本类型是jbpm和etip的衔接点,在访问数据库时，需要使用hibernate.cfg.xml.在jbpm部署时，已经有统一配置
 * 前提是jbpm的数据库表需要和授权表部署在一起。 此处最好由etip提供一个webservice接口，相互调用。
 * 
 * @author lishan
 */
public class EtipJbpmActorHandler implements AssignmentHandler {
	private static final long serialVersionUID = 1725926221415415573L;

	public void assign(Assignable assignable, ExecutionContext context) throws Exception {
		ProcessDefinition processDefinition = context.getProcessDefinition();
		TaskInstance taskInstance = context.getTaskInstance();
		Task task = taskInstance.getTask();
		String processName = processDefinition.getName();
		String taskName = task.getName();
		long processId = taskInstance.getProcessInstance().getId();
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		// 查询任务实例的对象，根据找到该对象处理部门，在根据岗位和部门查找用户，解决一个岗位多部门用户
		String objectSql = "select se.createorgid as orgid from tb_core_settlement se where se.id = (select i.jbpmobjectid from ProcessInstance i where i.jbpmprocessid =  '"
				+ processId + "')";
		List<ETIPResultSet> list = dao.queryForList(objectSql, null);
		/*
		 * 以下代码直接执行sql： 1.根据procesName,taskName获取 2.根据RoleID查询对应用户
		 */

		Connection conn = null;

		// 这里是获取连接,有问题，未能获取链接
		try {
			String orgid = "";
			if (list.size() > 0) {
				orgid = list.get(0).getString("ORGID");
			}
			conn = context.getJbpmContext().getConnection();
			String sql = "select id as actorID from tb_sys_user where id in (select user_id from tb_sys_userrole where role_id in (select taskroleid from ProcessTaskRegistry where processName='"
					+ processName
					+ "' and taskName='"
					+ taskName
					+ "' and processversion = (select max(processversion) from ProcessTaskRegistry where processName='"
					+ processName
					+ "' and taskName='" + taskName + "')))";
			if (!taskName.equals("预算管理分部经理审批")) {
				sql += " and org_id = '" + orgid + "'";
			}
			System.out.println("sql:" + sql);
			Statement stmt = conn.createStatement();
			ResultSet rv = stmt.executeQuery(sql);
			Vector<String> actorVector = new Vector<String>();
			while (rv.next()) {
				actorVector.addElement(rv.getString("actorID"));
			}
			if (actorVector.size() == 0) {
				throw new Exception("EtipJbpmActorHandlerError");
			}
			
			//txc add 将任务执行者的代理人加入到组中
			try {
				for(String s : actorVector){
					List<ETIPResultSet> l =dao.queryForList("select PROXYID from tb_sys_proxyrelation t where t.proxyedID='"+s+"'", null);
					if(l!=null && l.size()>0){
						for(ETIPResultSet set : l){
							actorVector.addElement(set.getString("PROXYID"));
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String[] actors = new String[actorVector.size()];
			actorVector.copyInto(actors);
			assignable.setPooledActors(actors);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("EtipJbpmActorHandlerError");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
