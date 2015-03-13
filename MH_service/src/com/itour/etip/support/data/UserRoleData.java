/**
 * Auto generator by Leo
 */
package com.itour.etip.support.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

@Entity()
@Table(name = "EtipUserRole")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserRoleData extends FrmData {

	/**
	 * 内部用户
	 */
	private EtipOperatorData etipOperator;

	/**
	 * 角色代码
	 */
	private String roleID;

	/**
	 * 获得内部用户
	 */
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = EtipOperatorData.class)
	@JoinColumn(name = "ETIPOPERATORID")
	public EtipOperatorData getEtipOperator() {
		return etipOperator;
	}

	/**
	 * 设置内部用户
	 */
	public void setEtipOperator(EtipOperatorData etipOperator) {
		this.etipOperator = etipOperator;
	}

	/**
	 * 获得角色代码
	 */
	@Column(length = 32, name = "ROLEID", nullable = true)
	public String getRoleID() {
		return roleID;
	}

	/**
	 * 设置角色代码
	 */
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

}
