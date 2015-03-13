package com.itour.etip.support.data;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 *内部用户
 */
@Entity()
@Table(name = "EtipOperator")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EtipOperatorData extends FrmData {

	/**
	 * 机构登录账号，在操作员登录时有用
	 */
	private String groupAccount;

	/**
	 * 账号
	 */
	private String loginName;

	/**
	 * 密码
	 */
	private String password;

	// private String groupUserID;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 创建人
	 */
	private String creator;

	/**
	 * 创建日期
	 */
	private Date createDate;

	/**
	 * 最后更新人员
	 */
	private String lastUpdator;

	/**
	 * 最后更新日期
	 */
	private Date lastUptDate;

	/**
	 * 用户角色对照表
	 */
	private List<UserRoleData> userRoles;

	/**
	 * 获得创建日期
	 */
	@Column(name = "CREATEDATE", nullable = true)
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获得创建人
	 */
	@Column(length = 32, name = "CREATOR", nullable = true)
	public String getCreator() {
		return creator;
	}

	/**
	 * 设置创建人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	// @Column(length = 32, name = "GROUPUSERID", nullable = true)
	// public String getGroupUserID() {
	// return groupUserID;
	// }

	// public void setGroupUserID(String groupUserID) {
	// this.groupUserID = groupUserID;
	// }

	/**
	 * 获得最后更新人员
	 */
	@Column(length = 32, name = "LASTUPDATOR", nullable = true)
	public String getLastUpdator() {
		return lastUpdator;
	}

	/**
	 * 设置最后更新人员
	 */
	public void setLastUpdator(String lastUpdator) {
		this.lastUpdator = lastUpdator;
	}

	/**
	 * 获得最后更新时间
	 */
	@Column(name = "LASTUPTDATE", nullable = true)
	public Date getLastUptDate() {
		return lastUptDate;
	}

	/**
	 * 设置最后更新时间
	 */
	public void setLastUptDate(Date lastUptDate) {
		this.lastUptDate = lastUptDate;
	}

	/**
	 * 获得账号
	 */
	@Column(length = 64, name = "LOGINNAME", nullable = true)
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 设置账号
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * 获得密码
	 */
	@Column(length = 100, name = "PASSWORD", nullable = true)
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获得状态
	 */
	@Column(length = 3, name = "STATUS", nullable = true)
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获得角色对照表
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = UserRoleData.class)
	@JoinColumn(name = "ETIPOPERATORID")
	public List<UserRoleData> getUserRoles() {
		return userRoles;
	}

	/**
	 * 设置角色对照表
	 */
	public void setUserRoles(List<UserRoleData> userRoles) {
		this.userRoles = userRoles;
	}

	/**
	 * 获取机构登录账号,在机构变更账号时，要求更新
	 * 
	 * @return
	 */
	@Column(length = 64, name = "GROUPACCOUNT", nullable = true)
	public String getGroupAccount() {
		return groupAccount;
	}

	/**
	 * 设置机构登录账号
	 * 
	 * @param groupAccount
	 */
	public void setGroupAccount(String groupAccount) {
		this.groupAccount = groupAccount;
	}

}
