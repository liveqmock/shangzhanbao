package com.itour.etip.pub.ldap.runtime;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表一个DisplayGroup。每个DisplayGroup可能包含0个或多个 PropertyDefs。
 */
public class DisplayGroup {

	private List<PropertyDef> propertyDefs = null;
	private String name = null;
	private String key = null;

	public DisplayGroup() {
		this.propertyDefs = new ArrayList<PropertyDef>();
	}

	public DisplayGroup(List<PropertyDef> propdefs) {
		this.propertyDefs = propdefs;
	}

	public boolean addPropertyDef(PropertyDef prop) {
		return this.propertyDefs.add(prop);
	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public List<PropertyDef> getPropertyDefs() {
		return propertyDefs;
	}

	public boolean removePropertyDef(PropertyDef prop) {
		return this.propertyDefs.remove(prop);
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPropertyDefs(List<PropertyDef> propertyDefs) {
		this.propertyDefs = propertyDefs;
	}

	public String toString() {
		return name + "," + key;
	}

}
