/**
 * Auto generator by Leo
 */
package com.itour.etip.support.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmData;

@Entity()
@Table(name = "ProcessTaskRegistry")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ProcessTaskRegistryData extends FrmData {

	/**
	 * 流程名称
	 */
	private String processName;

	/**
	 * 任务名称
	 */
	private String taskName;

	/**
	 * 流程版本号
	 */
	private String processVersion;
	/**
	 * 任务执行岗位
	 */
	private String taskRoleId;

	/**
	 * 任务执行岗位名称
	 */
	private String taskRoleName;

	/**
	 * 获得流程名称
	 */
	@Column(length = 128, name = "PROCESSNAME", nullable = true)
	public String getProcessName() {
		return processName;
	}

	/**
	 * 设置流程名称
	 */

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	/**
	 * 获得任务名称
	 */
	@Column(length = 128, name = "TASKNAME", nullable = true)
	public String getTaskName() {
		return taskName;
	}

	/**
	 * 设置任务名称
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * 获得流程版本号
	 */
	@Column(length = 32, name = "PROCESSVERSION", nullable = true)
	public String getProcessVersion() {
		return processVersion;
	}

	/**
	 * 设置流程版本号
	 */
	public void setProcessVersion(String processVersion) {
		this.processVersion = processVersion;
	}

	/**
	 * 获取
	 * 
	 * @return the taskRoleId
	 */
	@Column(length = 36, name = "TASKROLEID", nullable = true)
	public String getTaskRoleId() {
		com.itour.etip.pub.frame.JdbcDao dao = (com.itour.etip.pub.frame.JdbcDao) com.itour.etip.pub.frame.SpringContextHelper
				.getBean("jdbc");
		String roleNameSql = "select id from tb_sys_role where rolename = '"
				+ getTaskRoleName() + "'";
		List<ETIPResultSet> roleNameList = dao.queryForList(
				roleNameSql, null);
		if(roleNameList.size()>0){
			taskRoleId = roleNameList.get(0).getString("ID");
		}
		return taskRoleId;
	}

	/**
	 * 设置
	 * 
	 * @param taskRoleId
	 *            the taskRoleId to set
	 */
	public void setTaskRoleId(String taskRoleId) {
		this.taskRoleId = taskRoleId;
	}

	/**
	 * 获取
	 * 
	 * @return the taskRoleName
	 */
	public String getTaskRoleName() {
		return taskRoleName;
	}

	/**
	 * 设置
	 * 
	 * @param taskRoleName
	 *            the taskRoleName to set
	 */
	public void setTaskRoleName(String taskRoleName) {
		this.taskRoleName = taskRoleName;
	}

}
