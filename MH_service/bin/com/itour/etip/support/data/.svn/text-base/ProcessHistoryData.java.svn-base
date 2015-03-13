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
@Table(name = "ProcessHistory")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ProcessHistoryData extends FrmData {

	/**
	 * 流程名称
	 */
	private String processName;

	/**
	 * 流程ID
	 */
	private String jbpmProcessID;

	/**
	 * 任务名称
	 */
	private String taskName;

	/**
	 * 任务当前状态
	 */
	private String taskStatus;

	/**
	 * 迁移名称
	 */
	private String transitionName;

	/**
	 * 迁移后的状态
	 */
	private String transitionStatus;

	/**
	 * 操作人员所属机构
	 */
	private String operatorOrgID;

	/**
	 * 操作人员
	 */
	private String operatorID;
	
	

	/**
	 * 操作时间
	 */
	private java.util.Date operateDate;

	/**
	 * 操作备注
	 */
	private String operateMemo;

	/**
	 * 类型名称
	 */
	private String jbpmClassName;

	/**
	 * 对象ID
	 */
	private String jbpmObjectID;

	/**
	 * 操作前对象值
	 */
	private String jbpmObjectJson;

	/**
	 * 获得操作人员
	 */
	@Column(length = 32, name = "OPERATORID", nullable = true)
	public String getOperatorID() {
		return operatorID;
	}

	/**
	 * 设置操作人员
	 */
	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}

	/**
	 * 获得操作时间
	 */
	@Column(name = "OPERATEDATE", nullable = true)
	public java.util.Date getOperateDate() {
		return operateDate;
	}

	/**
	 * 设置操作时间
	 */
	public void setOperateDate(java.util.Date operateDate) {
		this.operateDate = operateDate;
	}

	/**
	 * 获得操作备注
	 */
	@Column(length = 4000, name = "OPERATEMEMO", nullable = true)
	public String getOperateMemo() {
		return operateMemo;
	}

	/**
	 * 设置操作备注
	 */
	public void setOperateMemo(String operateMemo) {
		this.operateMemo = operateMemo;
	}
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
	/**
	 * 保存操作前对象属性值，
	 * @return
	 */
	@Column(length = 1024, name = "jBPMOJECTJSON", nullable = true)
	public String getJbpmObjectJson() {
		return jbpmObjectJson;
	}

	public void setJbpmObjectJson(String jbpmObjectJson) {
		this.jbpmObjectJson = jbpmObjectJson;
	}
	@Column(length = 32, name = "JBPMPROCESSID", nullable = true)
	public String getJbpmProcessID() {
		return jbpmProcessID;
	}

	public void setJbpmProcessID(String jbpmProcessID) {
		this.jbpmProcessID = jbpmProcessID;
	}
	@Column(length = 32, name = "ORPERATORORGID", nullable = true)
	public String getOperatorOrgID() {
		return operatorOrgID;
	}

	public void setOperatorOrgID(String operatorOrgID) {
		this.operatorOrgID = operatorOrgID;
	}
	@Column(length = 128, name = "PROCESSNAME", nullable = true)
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	@Column(length = 128, name = "TASKNAME", nullable = true)
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskStatus() {
		return taskStatus;
	}
	@Column(length = 4, name = "TASKSTATUS", nullable = true)
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	@Column(length = 32, name = "TRANSITIONNAME", nullable = true)
	public String getTransitionName() {
		return transitionName;
	}
	
	public void setTransitionName(String transitionName) {
		this.transitionName = transitionName;
	}
	@Column(length = 4, name = "TRANSITIONSTATUS", nullable = true)
	public String getTransitionStatus() {
		return transitionStatus;
	}

	public void setTransitionStatus(String transitionStatus) {
		this.transitionStatus = transitionStatus;
	}
	
}
