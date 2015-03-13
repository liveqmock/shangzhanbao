package com.itour.etip.pub.ldap.runtime;

/**
 * 代表了一个运行时属性的定义。
 * 
 * 每个属性的定义可以包含这些元素 - name（必填） - key （必填） - type（必需） - defaultValue（必需） -
 * rows（可选） - cols（选项）
 */
public class PropertyDef {

	private String name = null;
	private String key = null;
	private String type = null;
	private String defaultValue = null;
	private String event;
	private int rows = 5;

	private int cols = 25;

	/* Creates a new instance of PropertyDef */
	public PropertyDef() {
	}
	public int getCols() {
		return cols;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public String getEvent() {
		return event;
	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public int getRows() {
		return rows;
	}

	public String getType() {
		return type;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public void setCols(String cols) {
		// convert to int
		try {
			int c = Integer.parseInt(cols);
			this.cols = c;
		} catch (Exception e) {
			// hmmm ... bogus value
		}
	}

	public void setDefaultValue(String defaultvalue) {
		this.defaultValue = defaultvalue;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setRows(String rows) {
		// convert to int
		try {
			int r = Integer.parseInt(rows);
			this.rows = r;
		} catch (Exception e) {
			// hmmm ... bogus value
		}
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return "[" + name + "," + key + "," + type + "," + defaultValue + "," + rows + "," + cols + "]";
	}
}
