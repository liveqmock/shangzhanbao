package com.sys.userrole.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 * @author 大勇
 * 订单实体类
 */
@Entity
@Table(name = "CTN_ROLEAUTHORITY")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class RoleAuthorityCtnData extends FrmData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1536968155846331271L;
	
	/**
	 * 权限名称
	 */
	@Column(name="roleId")
	private String roleId;
	

	@Column(name="authorityId")
	private String authorityId;
	
	
	/**
	 * 创建时间
	 */
	@Column(name="createTime")
	private Date createTime;


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public String getAuthorityId() {
		return authorityId;
	}


	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
}
