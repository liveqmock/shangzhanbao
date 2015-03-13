package com.sys.org.service;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.sys.org.business.IOrgBusiness;
import com.sys.org.data.OrgData;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;

/********************************************************
Copyright (C), 2009-2011, GoMai.
File name:    CompanyService.java
Author: CuiYunYan LiuLei      Version:  1.0.0  Date: 2011-6-17
***********************************************************/

@Component("orgService")
public class OrgService extends FrmService implements IOrgService {
	@Resource(name="orgBusiness")
	private IOrgBusiness orgBusiness;

	/**
	 * 通过id删除公司信息
	 */
	public void deleteOrg(String id){
		orgBusiness.deleteOrg(id);
	}

	/**
	 * 添加公司对象
	 */
	public void addOrg(OrgData orgData){
		orgBusiness.addOrg(orgData);
	}

	/**
	 * 编辑公司信息
	 */
	public void editOrg(OrgData orgData){
		orgBusiness.editOrg(orgData);
	}
	
	/**
	 * 条件查询机构
	 */
	public List<OrgData> queryOrgList( JSONObject jsonObj ){
		return orgBusiness.queryOrgList(jsonObj);
	}
	
	/**
	 * 分页查询机构(分页显示)
	 */
	public List<OrgData> queryOrgList( PageRoll pageRoll,JSONObject jsonObj ){
		return orgBusiness.queryOrgList(pageRoll, jsonObj);
	}
	
	/**
	 * 获取当前机构的主管
	 */
	public String getOrgDeptManagerID(String user_OrgId){
		return orgBusiness.getOrgDeptManagerID(user_OrgId);
	}
	
	/**
	 * 获取当前机构的分管
	 */
	public String getOrgDeptDeputyMangerID(String user_OrgId){
		return orgBusiness.getOrgDeptDeputyMangerID(user_OrgId);
	}
	
}
