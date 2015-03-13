package com.itour.etip.pub.ldap.runtime;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表所有ConfigDefs集合。
 */
public class RuntimeConfigDefs {

	private List<ConfigDef> configDefs = null;

	public RuntimeConfigDefs() {
		this.configDefs = new ArrayList<ConfigDef>();
	}

	public RuntimeConfigDefs(List<ConfigDef> configs) {
		this.configDefs = configs;
	}

	public boolean addConfigDef(ConfigDef config) {
		return this.configDefs.add(config);
	}

	public List<ConfigDef> getConfigDefs() {
		return configDefs;
	}

	public boolean removeConfigDef(ConfigDef config) {
		return this.configDefs.remove(config);
	}

	public void setConfigDefs(List<ConfigDef> configDefs) {
		this.configDefs = configDefs;
	}

}
