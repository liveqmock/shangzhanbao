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
@Table(name = "RoleRegistry")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RoleRegistryData extends FrmData{

	/**
	 * 唯一角色编号
	 */
	
	private String roleCode;

	/**
	 * 角色分类
	 */
	
	private String roleClass;

	/**
	 * 角色中文名称
	 */
	
	private String roleName;

	/**
	 * 备注
	 */
	
	private String memo;

	

	/**
	 *获得唯一角色编号
	 */
	@Column(length = 128,name = "ROLECODE",nullable = true)
	public String getRoleCode(){
		return roleCode;
}

	/**
	 *设置唯一角色编号
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
}


	/**
	 *获得角色分类
	 */
	@Column(length = 128,name = "ROLECLASS",nullable = true)
	public String getRoleClass(){
		return roleClass;
}

	/**
	 *设置角色分类
	 */
	public void setRoleClass(String roleClass) {
		this.roleClass = roleClass;
}


	/**
	 *获得角色中文名称
	 */
	@Column(length = 128,name = "ROLENAME",nullable = false)
	public String getRoleName(){
		return roleName;
}

	/**
	 *设置角色中文名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
}


	/**
	 *获得备注
	 */
	@Column(length = 4000,name = "MEMO",nullable = true)
	public String getMemo(){
		return memo;
}

	/**
	 *设置备注
	 */
	public void setMemo(String memo) {
		this.memo = memo;
}





}
