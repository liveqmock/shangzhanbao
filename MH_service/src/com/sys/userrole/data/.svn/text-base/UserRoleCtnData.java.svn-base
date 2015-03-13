package com.sys.userrole.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.sys.role.data.RoleData;

/**
 * 表名 用户And权限关联表 TB_SYS_USERROLE
 * @author LiuLei
 */
@Entity()
@Table(name = "TB_SYS_USERROLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserRoleCtnData extends FrmData {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	private String userId;
	
	/**
	 * 权限ID
	 */
	private String roleId;
	/**
	 * 角色对象
	 */
	private RoleData roleData;
	
	public UserRoleCtnData(){}
	
	public UserRoleCtnData(String roleID){
		userId = roleID;
	}
	
	public UserRoleCtnData(String userID, String roleID){
		userId = userID;
		roleId = roleID;
	}

	@Column(length = 36, name = "USER_ID", nullable = true)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(length = 36, name = "ROLE_ID", nullable = true)
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Transient
	public RoleData getRoleData() {
		return roleData;
	}

	public void setRoleData(RoleData roleData) {
		this.roleData = roleData;
	}
	
	
	
}
