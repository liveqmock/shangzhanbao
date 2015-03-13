package com.sys.resources.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;

/**
 * @author jmj
 * 角色权限实体类
 */
@Entity
@Table(name = "TB_SYS_ROLERES")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class RoleResData extends FrmData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1536968155846331271L;
	
	/**
	 * 权限名称
	 */
	@Column(name="ROLEID")
	private String roleId;//角色id

	@Column(name="RESID")
	private String resId;//资源id

	/**
	 * 资源对象
	 */
	private ResourceData resourceData;
	
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}
	@Transient
	public ResourceData getResourceData() {
		return resourceData;
	}

	public void setResourceData(ResourceData resourceData) {
		this.resourceData = resourceData;
	}
	

	
	
}
