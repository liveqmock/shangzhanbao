package com.sys.role.data;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import org.hibernate.annotations.Formula;
import com.itour.etip.pub.frame.FrmData;

/********************************************************
Copyright (C), 2009-2011, GoMai.
File name:    RoleData.java
Description：角色权限表 TB_SYS_ROLE
Author: CuiYunYan LiuLei     Version:  1.0.0  Date: 2011-6-17
***********************************************************/
/**
 * 角色data层
 * @author jmj
 */
@Entity()
@Table(name = "TB_SYS_ROLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RoleData extends FrmData {
	private static final long serialVersionUID = 3178596402696236227L;

	public RoleData(){}
	
	public RoleData(String id,String rolename){
		this.id = id;
		this.rolename = rolename;
	}
	/**
	 * 岗位名称
	 */
	private String rolename;
	
	/**
	 * 岗位描述(备注)
	 */
	private String description;
	
	/**
	 * 创建者 
	 */
	private String creator;
	
	/**
	 * 创建时间
	 */
	private Date createdate;
	
	/**
	 * 角色的继承关系。对应于本表的id。
	 */
	private String extend;
	
	/**
	 * 记录状态 normal/deleted
	 */
	private String status = "NORMAL";
	
	/**
	 * 创建人姓名
	 * */
	private String creatorUserName;

	@Formula("(select TB_SYS_USER.name from TB_SYS_USER where TB_SYS_USER.id = CREATER)")
	public String getCreatorUserName() {
		return creatorUserName;
	}
	
	public void setCreatorUserName(String creatorUserName) {
		this.creatorUserName = creatorUserName;
	}
	
	@Column(length = 50,name = "ROLENAME",nullable = true)
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	@Column(length = 300,name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(length = 10,name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(length = 36,name = "CREATER")
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	@Column(length = 36,name = "EXTEND")
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	
	@Column(name = "CREATEDATE")
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
}