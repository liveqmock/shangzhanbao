package com.sys.org.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.sys.org.data.OrgData;
import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;

/********************************************************
 * Copyright (C), 2009-2011, GoMai. 
 * File name: ICompanyService.java 
 * Author: CuiYunYan  Version: 1.0.0 Date: 2011-6-17
 ***********************************************************/
public interface IOrgService extends IService {

	/**
	 * 通过id删除公司信息
	 */
	public void deleteOrg(String id); 

	/**
	 * 添加公司对象
	 */
	public void addOrg(OrgData orgData);

	/**
	 * 编辑公司信息
	 */
	public void editOrg(OrgData orgData);
	
	/**
	 * 条件查询机构
	 */
	public List<OrgData> queryOrgList( JSONObject jsonObj );
	
	/**
	 * 分页查询机构(分页显示)
	 */
	public List<OrgData> queryOrgList( PageRoll pageRoll,JSONObject jsonObj );
	
	/**
	 * 获取当前机构的主管
	 */
	public String getOrgDeptManagerID(String user_OrgId);
	
	/**
	 * 获取当前机构的分管
	 */
	public String getOrgDeptDeputyMangerID(String user_OrgId);
}
