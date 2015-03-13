package com.sys.org.facade;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.sys.org.data.OrgData;
import com.sys.org.service.IOrgService;
import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;

/********************************************************
Copyright (C), 2009-2011, GoMai.
File name:    OrgFacade.java
Author: CuiYunYan LiuLei Version:  1.0.0  Date: 2011-6-17
***********************************************************/
@Component("orgFacade")
public class OrgFacade extends FrmFacade {
	@Resource(name="orgService")
    private IOrgService orgService;

	/**
	 * 通过id删除公司信息
	 */
	public void deleteOrg(String id){
		orgService.deleteOrg(id);
	}

	/**
	 * 添加公司对象
	 */
	public void addOrg(OrgData orgData){
		orgService.addOrg(orgData);
	}

	/**
	 * 编辑公司信息
	 */
	public void editOrg(OrgData orgData){
		orgService.editOrg(orgData);
	}
	
	/**
	 * 条件查询机构
	 */
	public List<OrgData> queryOrgList( JSONObject jsonObj ){
		return orgService.queryOrgList(jsonObj);
	}
	
	/**
	 * 条件查询机构
	 */
	public List<OrgData> queryOrgList(){
		return queryOrgList(null);
	}
	
	/**
	 * 分页查询机构(分页显示)
	 */
	public List<OrgData> queryOrgList( PageRoll pageRoll,JSONObject jsonObj ){
		return orgService.queryOrgList(pageRoll, jsonObj);
	}
	
	/**
	 * 获取当前机构的主管
	 */
	public String getOrgDeptManagerID(String user_OrgId){
		return orgService.getOrgDeptManagerID(user_OrgId);
	}
	
	/**
	 * 获取当前机构的分管
	 */
	public String getOrgDeptDeputyMangerID(String user_OrgId){
		return orgService.getOrgDeptDeputyMangerID(user_OrgId);
	}

}