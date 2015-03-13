package com.itour.etip.pub.ldap.runtime;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * This POJO represents a single property of the system.
 */
public class RuntimeConfigProperty implements Serializable {
	private static final long serialVersionUID = -1211203167228019484L;
	private String name;
	private String value;
	private boolean newProperty;

	public RuntimeConfigProperty() {
	}

	public RuntimeConfigProperty(String name, String value) {
		this(name, value, false);
	}

	public RuntimeConfigProperty(String name, String value, boolean newProperty) {
		this.name = name;
		this.value = value;
		this.newProperty = newProperty;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (other instanceof RuntimeConfigProperty != true)
			return false;
		RuntimeConfigProperty o = (RuntimeConfigProperty) other;
		return new EqualsBuilder().append(getName(), o.getName()).isEquals();
	}

	/*
	 * Getter for property name.
	 * 
	 * @return Value of property name.
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * Getter for property value.
	 * 
	 * @return Value of property value.
	 */
	public String getValue() {
		return this.value;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getName()).toHashCode();
	}

	public boolean isNewProperty() {
		return newProperty;
	}

	/*
	 * Setter for property name.
	 * 
	 * @param name New value of property name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	// ------------------------------------------------------- Good citizenship

	public void setNewProperty(boolean newProperty) {
		this.newProperty = newProperty;
	}

	/*
	 * Setter for property value.
	 * 
	 * @param value New value of property value.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return (this.name + "=" + this.value);
	}

}
