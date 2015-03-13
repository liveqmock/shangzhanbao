/**
 * Auto generator by Leo
 */
package com.itour.etip.support.data;

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
@Table(name = "ProcessInstance")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ProcessInstanceData extends FrmData {

	/**
	 * 流程名称
	 */
	private String processName;

	/**
	 * 类型名称
	 */
	private String jbpmClassName;

	/**
	 * 流程版本
	 */
	private String processVersion;

	/**
	 * 流程状态
	 */
	private String processStatus;

	/**
	 * 流程ID
	 */
	private String jbpmProcessID;

	/**
	 * 对象ID
	 */
	private String jbpmObjectID;
	

	@Column(length = 128, name = "JBPMCLASSNAME", nullable = true)
	public String getJbpmClassName() {
		return jbpmClassName;
	}

	public void setJbpmClassName(String jbpmClassName) {
		this.jbpmClassName = jbpmClassName;
	}

	@Column(length = 32, name = "JBPMOBJECTID", nullable = true)
	public String getJbpmObjectID() {
		return jbpmObjectID;
	}

	public void setJbpmObjectID(String jbpmObjectID) {
		this.jbpmObjectID = jbpmObjectID;
	}

	@Column(length = 32, name = "JBPMPROCESSID", nullable = true)
	public String getJbpmProcessID() {
		return jbpmProcessID;
	}

	public void setJbpmProcessID(String jbpmProcessID) {
		this.jbpmProcessID = jbpmProcessID;
	}

	@Column(length = 128, name = "PROCESSNAME", nullable = true)
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	@Column(length = 4, name = "PROCESSSTATUS", nullable = true)
	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	@Column(length = 4, name = "PROCESSVERSION", nullable = true)
	public String getProcessVersion() {
		return processVersion;
	}

	public void setProcessVersion(String processVersion) {
		this.processVersion = processVersion;
	}

	/**
	 * 变更记录
	 */
	private java.util.List<ProcessHistoryData> histories;

	/**
	 * 返回变更记录
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ProcessHistoryData.class)
	@JoinColumn(name = "PROCESSINSTANCEID")
	public java.util.List<ProcessHistoryData> getHistories() {
		return this.histories;
	}

	/**
	 * 设置变更记录
	 */
	public void setHistories(java.util.List<ProcessHistoryData> histories) {
		this.histories = histories;
	}

}
