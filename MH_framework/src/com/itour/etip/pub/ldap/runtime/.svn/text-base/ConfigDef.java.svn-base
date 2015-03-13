package com.itour.etip.pub.ldap.runtime;

import java.util.ArrayList;
import java.util.List;

/**
 * 表示一个逻辑运行时配置属性分组。每个 ConfigDef可能包含0个或多个DisplayGroups。
 */
public class ConfigDef {

	private List<DisplayGroup> displayGroups = null;
	private String name = null;

	public ConfigDef() {
		this.displayGroups = new ArrayList<DisplayGroup>();
	}

	public ConfigDef(List<DisplayGroup> displaygroups) {
		this.displayGroups = displaygroups;
	}

	public boolean addDisplayGroup(DisplayGroup group) {
		return this.displayGroups.add(group);
	}

	public List<DisplayGroup> getDisplayGroups() {
		return displayGroups;
	}

	public String getName() {
		return name;
	}

	public boolean removeDisplayGroup(DisplayGroup group) {
		return this.displayGroups.remove(group);
	}

	public void setDisplayGroups(List<DisplayGroup> displayGroups) {
		this.displayGroups = displayGroups;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

}
