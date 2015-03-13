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
@Table(name = "RoleTask")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RoleTaskData extends FrmData{

	/**
	 * 角色ID
	 */
	private String roleID;

	/**
	 * 流程任务ID
	 */
	private String processTaskRegistryID;
	

	/**
	 *获得唯一角色代码
	 */
	@Column(length = 32,name = "ROLEID",nullable = false)
	public String getRoleID(){
		return roleID;
}

	/**
	 *设置唯一角色代码
	 */
	public void setRoleID(String roleID) {
		this.roleID = roleID;
}


	/**
	 *获得资源代码
	 */
	@Column(length = 32,name = "PROCESSTASKREGISTRYID",nullable = false)
	public String getProcessTaskRegistryID(){
		return processTaskRegistryID;
}

	/**
	 *设置资源代码
	 */
	public void setProcessTaskRegistryID(String processTaskRegistryID) {
		this.processTaskRegistryID = processTaskRegistryID;
}



}
