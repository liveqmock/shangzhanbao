/**
 * Auto generator by Leo
 */
package com.itour.etip.support.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

@Entity()
@Table(name = "ProcessRegistry")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ProcessRegistryData extends FrmData {

	/**
	 * 流程名称
	 */
	private String processName;

	/**
	 * 流程对应的类名
	 */
	private String jbpmClassName;

	/**
	 * 流程版本号
	 */
	private String processVersion;


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
	@Column(length = 128, name = "JBPMCLASSNAME", nullable = true)
	public String getJbpmClassName() {
		return jbpmClassName;
	}

	/**
	 * 设置流程对应的类名，此处用可以辩解的列表
	 */
	public void setJbpmClassName(String jbpmClassName) {
		this.jbpmClassName = jbpmClassName;
	}

	/**
	 * 获得流程版本号
	 */
	@Column(length = 128, name = "PROCESSVERSION", nullable = true)
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
	 * 任务
	 */
	private java.util.List<ProcessTaskRegistryData> tasks;

	/**
	 * 返回当前工作流任务
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ProcessTaskRegistryData.class)
	@JoinColumn(name = "PROCESSREGISTRYID")
	public java.util.List<ProcessTaskRegistryData> getTasks() {
		return this.tasks;
	}

	/**
	 * 设置工作流任务
	 */
	public void setTasks(java.util.List<ProcessTaskRegistryData> tasks) {
		this.tasks = tasks;
	}
	/**
	 * 迁移
	 */
	private java.util.List<ProcessTransitionRegistryData> transitions;

	/**
	 * 返回迁移
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ProcessTransitionRegistryData.class)
	@JoinColumn(name = "PROCESSREGISTRYID")
	public java.util.List<ProcessTransitionRegistryData> getTransitions() {
		return this.transitions;
	}

	/**
	 * 设置迁移
	 */
	public void setTransitions(java.util.List<ProcessTransitionRegistryData> transitions) {
		this.transitions = transitions;
	}
}
