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
@Table(name = "EtipProcess")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EtipProcessData extends FrmData{

	/**
	 * 流程实例ID
	 */
	private String processID;

	/**
	 * 对象实例ID
	 */
	private String objectID;

	/**
	 * 对象类型
	 */
	private String objectClass;
	

	/**
	 *获得流程实例ID
	 */
	@Column(length = 32,name = "PROCESSID",nullable = true)
	public String getProcessID(){
		return processID;
}

	/**
	 *设置流程实例ID
	 */
	public void setProcessID(String processID) {
		this.processID = processID;
}


	/**
	 *获得对象实例ID
	 */
	@Column(length = 32,name = "OBJECTID",nullable = true)
	public String getObjectID(){
		return objectID;
}

	/**
	 *设置对象实例ID
	 */
	public void setObjectID(String objectID) {
		this.objectID = objectID;
}


	/**
	 *获得对象类型
	 */
	@Column(length = 64,name = "OBJECTCLASS",nullable = true)
	public String getObjectClass(){
		return objectClass;
}

	/**
	 *设置对象类型
	 */
	public void setObjectClass(String objectClass) {
		this.objectClass = objectClass;
}



}
