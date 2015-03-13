/**
 * Auto generator by Leo
 */
package com.itour.etip.support.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

@Entity()
@Table(name = "ProcessTransitionRegistry")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ProcessTransitionRegistryData extends FrmData {

	/**
	 * 流程名称
	 */
	private String processName;
	
	//流程版本
	private String processVersion;
	

	/**
	 * 任务名称
	 */
	private String taskName;

	/**
	 * 当前任务状态
	 */
	private String taskStatus;

	/**
	 * 迁移名称
	 */
	private String transitionName;
	
	/**
	 * 迁移后任务名称
	 */
	private String transitionTaskName;

	/**
	 * 迁移后状态
	 */
	private String transitionStatus;
	
	
	
	@Column(length = 10, name = "PROCESSVERSION", nullable = true)
	public String getProcessVersion() {
		return processVersion;
	}

	public void setProcessVersion(String processVersion) {
		this.processVersion = processVersion;
	}

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
	@Column(length = 30, name = "TASkSTATUS", nullable = true)
	public String getTaskStatus() {
		return taskStatus;
	}

	/**
	 * 设置流程版本号
	 */
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	
	/**
	 * 获得迁移名称
	 */
	@Column(length = 128, name = "TRANSITIONNAME", nullable = true)
	public String getTransitionName() {
		return transitionName;
	}

	/**
	 * 设置迁移名称
	 */
	public void setTransitionName(String transitionName) {
		this.transitionName = transitionName;
	}

	/**
	 * 获得迁移状态
	 */
	@Column(length = 30, name = "TRANSITIONSTATUS", nullable = true)
	public String getTransitionStatus() {
		return transitionStatus;
	}

	/**
	 * 设置迁移状态
	 */
	public void setTransitionStatus(String transitionStatus) {
		this.transitionStatus = transitionStatus;
	}
	@Column(length = 256, name = "TRANSITIONTASKNAME", nullable = true)
	public String getTransitionTaskName() {
		return transitionTaskName;
	}

	public void setTransitionTaskName(String transitionTaskName) {
		this.transitionTaskName = transitionTaskName;
	}

}
