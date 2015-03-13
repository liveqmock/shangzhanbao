package com.sys.org.data;

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
  File name:    CompanyData.java
  Description:  系统机构 TB_SYS_ORG
  Author: CuiYunYan LiuLei Version:  1.0.0  Date: 2011-6-17
 ***********************************************************/
@Entity()
@Table(name = "TB_SYS_ORG")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class OrgData extends FrmData{
	private static final long serialVersionUID = -7606701686916045136L;

	/**
	 * 机构编号
	 */
	private String orgcode;
	
	/**
	 * 机构类型
	 */
	private String catalog;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 联系人
	 */
	private String linkman;
	
	/**
	 * 电话
	 */
	private String telephone;
	
	/**
	 * 传真
	 */
	private String fax;
	
	/**
	 * 邮编
	 */
	private String postcode;
	
	/**
	 * 机构排序
	 */
	private String taxis;
	
	/**
	 * 父机构id
	 */
	private String parentid;
	
	/**
	 * 记录状态 NORMAL/DELETED
	 */
	private String rowstatus;

	/**
	 * 公司创建者
	 */
	private String creator;
	
	/**
	 * 公司创建时间
	 */
	private Date createtime;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 机构中文名称
	 */
	private String orgname_cn;
	
	/**
	 * 机构英文名称
	 */
	private String orgname_us;
	
	/**
	 * 机构名称
	 */
	private String orgnamedefault;
	
	/**
	 * 机构简称
	 */
	private String orgshortname;
	
	/**
	 * 部门主管
	 */
	private String deptManagerID;
	
	/**
	 * 部门主管名称
	 */
	@Formula("(SELECT TB_SYS_ROLE.ROLENAME FROM TB_SYS_ROLE WHERE TB_SYS_ROLE.ID = deptManagerID)")
	private String daptManagerName;
	
	/**
	 * 部门分管
	 */
	private String deptDeputyManagerID;
	
	/**
	 * 部门分管名称
	 */
	@Formula("(SELECT TB_SYS_ROLE.ROLENAME FROM TB_SYS_ROLE WHERE TB_SYS_ROLE.ID = deptDeputyManagerID)")
	private String deptDeputyManagerName;
	
	/**
	 * 用来存放父机构名称
	 */
	@Formula("(SELECT TB_SYS_ORG.ORGNAME_CN FROM TB_SYS_ORG WHERE TB_SYS_ORG.ID = PARENT_ID)")
	private String parentName;

	public OrgData(){}
	
	public OrgData(String id,String orgnamedefault){
		this.id = id;
		this.orgnamedefault = orgnamedefault;
	}
	
	@Formula("(SELECT TB_SYS_ORG.ORGNAME_CN FROM TB_SYS_ORG WHERE TB_SYS_ORG.ID = PARENT_ID)")
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	/**
	 * 获取机构中文名称
	 */
	@Column(length = 50,name = "ORGNAME_CN")
	public String getOrgname_cn() {
		return orgname_cn;
	}
	
	/**
	 * 设置机构中文名称
	 */
	public void setOrgname_cn(String orgnameCn) {
		orgname_cn = orgnameCn;
	}
	
	/**
	 * 获取机构英文名称
	 */
	@Column(length = 50,name = "orgname_US")
	public String getOrgname_us() {
		return orgname_us;
	}
	
	/**
	 * 设置机构英文名称
	 */
	public void setOrgname_us(String orgnameUs) {
		orgname_us = orgnameUs;
	}
	
	/**
	 * 获取机构默认名称
	 */
	@Column(length = 50,name = "ORGNAMEDEFAULT",nullable = true)
	public String getOrgnamedefault() {
		return orgnamedefault;
	}
	
	/**
	 * 设置机构默认名称
	 */
	public void setOrgnamedefault(String orgnamedefault) {
		this.orgnamedefault = orgnamedefault;
	}

	@Column(length = 50,name = "ORGSHORTNAME")
	public String getOrgshortname() {
		return orgshortname;
	}

	public void setOrgshortname(String orgshortname) {
		this.orgshortname = orgshortname;
	}

	@Column(length = 30,name = "ORGCode")
	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	@Column(length = 36,name = "CATALOG")
	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	@Column(length = 200,name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(length = 40,name = "LINKMAN")
	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	@Column(length = 50,name = "TELEPHONE")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(length = 50,name = "FAX")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(length = 6,name = "POSTCODE")
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "TAXIS")
	public String getTaxis() {
		return taxis;
	}

	public void setTaxis(String taxis) {
		this.taxis = taxis;
	}

	@Column(length = 36,name = "PARENT_ID")
	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	@Column(length = 10,name = "ROW_STATUS")
	public String getRowstatus() {
		return rowstatus;
	}

	public void setRowstatus(String rowstatus) {
		this.rowstatus = rowstatus;
	}

	@Column(length = 36,name = "CREATOR",nullable = true)
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "CREATE_TIME")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(length = 4000,name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(length = 40,name = "DEPTMANAGERID", nullable = true)
	public String getDeptManagerID() {
		return deptManagerID;
	}
	
	public void setDeptManagerID(String deptManagerID) {
		this.deptManagerID = deptManagerID;
	}
	
	@Column(length = 40,name = "DEPTDEPUTYMANAGERID", nullable = true)
	public String getDeptDeputyManagerID() {
		return deptDeputyManagerID;
	}
	
	public void setDeptDeputyManagerID(String deptDeputyManagerID) {
		this.deptDeputyManagerID = deptDeputyManagerID;
	}

	@Formula("(SELECT TB_SYS_ROLE.ROLENAME FROM TB_SYS_ROLE WHERE TB_SYS_ROLE.ID = deptManagerID)")
	public String getDaptManagerName() {
		return daptManagerName;
	}

	public void setDaptManagerName(String daptManagerName) {
		this.daptManagerName = daptManagerName;
	}

	@Formula("(SELECT TB_SYS_ROLE.ROLENAME FROM TB_SYS_ROLE WHERE TB_SYS_ROLE.ID = deptDeputyManagerID)")
	public String getDeptDeputyManagerName() {
		return deptDeputyManagerName;
	}

	public void setDeptDeputyManagerName(String deptDeputyManagerName) {
		this.deptDeputyManagerName = deptDeputyManagerName;
	}
}