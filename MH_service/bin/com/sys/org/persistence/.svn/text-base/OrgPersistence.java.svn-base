package com.sys.org.persistence;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;


import com.sys.org.data.OrgData;
import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.PageRoll;
/********************************************************
Copyright (C), 2009-2011, GoMai.
File name:    CompanyPersistence.java
Author: CuiYunYan LiuLei  Version:  1.0.0  Date: 2011-6-17
***********************************************************/

@Component("orgPersistence")
public class OrgPersistence extends BasePersistence<OrgData> implements
		IOrgPersistence {
	/**
	 * 删除公司
	 */
	public void deleteOrg(String id) {
		StringBuffer delSQL = new StringBuffer();
		delSQL.append("DELETE FROM TB_SYS_ORG WHERE ID IN(")
			.append("SELECT T.ID FROM TB_SYS_ORG T START WITH T.ID = '")
			.append(id).append("' CONNECT BY PRIOR T.ID = T.PARENT_ID)");
		executeSQL(delSQL.toString());
	}
	
	/**
	 * 添加公司
	 */
	public void addOrg(OrgData orgData) {
		add(orgData);
	}
	
	/**
	 * 编辑公司信息
	 */
	public void editOrg(OrgData orgData) {
		update(orgData);
	}

	/**
	 * 条件查询机构
	 */
	public List<OrgData> queryOrgList( JSONObject jsonObj ) {
		StringBuffer searchSQL = new StringBuffer("FROM OrgData WHERE 1=1");
		searchSQL.append(getInquiresTheConditions(jsonObj));
		return search(searchSQL.toString());
	}
	
	/**
	 * 分页查询机构
	 */
	public List<OrgData> queryOrgList( PageRoll pageRoll,JSONObject jsonObj ) {
		StringBuffer countSQL = new StringBuffer("SELECT COUNT(d.id) FROM OrgData d WHERE 1=1");
		StringBuffer searchSQL = new StringBuffer("FROM OrgData WHERE 1=1");
		String whereSQL = getInquiresTheConditions(jsonObj);
		
		pageRoll.setCountSQL(countSQL.append(whereSQL).toString());
		pageRoll.setSearchSQL(searchSQL.append(whereSQL).append(" ORDER BY id DESC").toString());
		return search(pageRoll);
	}

	/*
	 * 拼接条件,机构查询条件
	 */
	private String getInquiresTheConditions(JSONObject obj) {
		StringBuffer whereSQL = new StringBuffer();
		if (obj != null && !obj.isNullObject()) {
			if(null != obj.get("parentID")){//父机构ID
				String parentID = obj.getString("parentID");
				if(parentID != null && !"".equals(parentID))
					whereSQL.append(" AND parentid = '").append(parentID).append("'");
			}
			if(null != obj.get("orgID")){//机构ID
				String orgID = obj.getString("orgID");
				if(orgID != null && !"".equals(orgID))
					whereSQL.append(" AND id = '").append(orgID).append("'");
			}
		}
		return whereSQL.toString();
	}

	/**
	 * 获取当前机构的主管
	 */
	@SuppressWarnings("unchecked")
	public String getOrgDeptManagerID(String user_OrgId){
		StringBuffer deptManager = new StringBuffer();
		deptManager.append("SELECT deptManagerID FROM TB_SYS_ORG WHERE ID = '").append(user_OrgId).append("'");
		List<String> list = searchBySQL(deptManager.toString());
		if(list.size() > 0)
			return list.get(0);
		return "";
	}
	
	/**
	 * 获取当前机构的分管
	 */
	@SuppressWarnings("unchecked")
	public String getOrgDeptDeputyMangerID(String user_OrgId){
		StringBuffer deptDeputyManager = new StringBuffer();
		deptDeputyManager.append("SELECT DEPTDEPUTYMANAGERID FROM TB_SYS_ORG WHERE ID = '").append(user_OrgId).append("'");
		List<String> list = searchBySQL(deptDeputyManager.toString());
		if(list.size() >0)
			return list.get(0);
		return "";
	}
}
