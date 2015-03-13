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
@Table(name = "RoleAuthority")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RoleAuthorityData extends FrmData{

	/**
	 * 唯一角色代码
	 */
	private String roleID;

	/**
	 * 资源代码
	 */
	private String serviceCode;
	

	/**
	 *获得唯一角色ID
	 */
	@Column(length = 32,name = "ROLEID",nullable = false)
	public String getRoleID(){
		return roleID;
}

	/**
	 *设置唯一角色ID
	 */
	public void setRoleID(String roleID) {
		this.roleID = roleID;
}


	/**
	 *获得资源代码
	 */
	@Column(length = 128,name = "SERVICECODE",nullable = false)
	public String getServiceCode(){
		return serviceCode;
}

	/**
	 *设置资源代码
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
}



}
