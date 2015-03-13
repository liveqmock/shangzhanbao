package com.sys.org.business;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.org.data.OrgData;
import com.sys.org.persistence.IOrgPersistence;
/********************************************************
Copyright (C), 2009-2011, GoMai.
File name:    CompanyBusiness.java
Author: CuiYunYan LiuLei  Version:  1.0.0  Date: 2011-6-17
***********************************************************/
@Component("orgBusiness")
public class OrgBusiness extends FrmBusiness implements IOrgBusiness {
	@Resource(name="orgPersistence")
	private IOrgPersistence orgPersistence;

	/**
	 * 通过id删除公司信息
	 */
	public void deleteOrg(String id){
		orgPersistence.deleteOrg(id);
	}

	/**
	 * 添加公司对象
	 */
	public void addOrg(OrgData orgData){
		orgPersistence.addOrg(orgData);
	}

	/**
	 * 编辑公司信息
	 */
	public void editOrg(OrgData orgData){
		orgPersistence.editOrg(orgData);
	}
	
	/**
	 * 条件查询机构
	 */
	public List<OrgData> queryOrgList( JSONObject jsonObj ){
		return orgPersistence.queryOrgList(jsonObj);
	}
	
	/**
	 * 分页查询机构(分页显示)
	 */
	public List<OrgData> queryOrgList( PageRoll pageRoll,JSONObject jsonObj ){
		return orgPersistence.queryOrgList(pageRoll, jsonObj);
	}
	
	/**
	 * 获取当前机构的主管
	 */
	public String getOrgDeptManagerID(String user_OrgId){
		return orgPersistence.getOrgDeptManagerID(user_OrgId);
	}
	
	/**
	 * 获取当前机构的分管
	 */
	public String getOrgDeptDeputyMangerID(String user_OrgId){
		return orgPersistence.getOrgDeptDeputyMangerID(user_OrgId);
	}
}