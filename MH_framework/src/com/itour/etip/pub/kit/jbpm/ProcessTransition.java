package com.itour.etip.pub.kit.jbpm;

public class ProcessTransition {
	private String id;
	private String transitionName;
	private String taskName;
	private String transitionTaskName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTransitionName() {
		return transitionName;
	}
	public void setTransitionName(String transitionName) {
		this.transitionName = transitionName;
	}
	public String getTransitionTaskName() {
		return transitionTaskName;
	}
	public void setTransitionTaskName(String transitionTaskName) {
		this.transitionTaskName = transitionTaskName;
	}
	
}
