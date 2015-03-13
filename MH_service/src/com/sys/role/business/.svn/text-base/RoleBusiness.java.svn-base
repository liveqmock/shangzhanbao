package com.sys.role.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.role.data.RoleData;
import com.sys.role.persistence.IRolePersistence;
/********************************************************
Copyright (C), 2009-2011, GoMai.
File name:    RoleBusiness.java
Author: CuiYunYan LiuLei  Version:  1.0.0  Date: 2011-6-17
***********************************************************/
/**
 * 角色管理操作business层
 * @author jmj
 */
@Component("roleBusiness")
public class RoleBusiness extends FrmBusiness implements IRoleBusiness {
	@Resource(name="rolePersistence")
	private IRolePersistence rolePersistence;

	/**
	 * 删除权限(角色)信息
	 */
	public void deleteRole(String id) {
		rolePersistence.deleteRole(id);
	}
	
	/**
	 * 查询权限(角色)信息(分页显示)
	 */
	public List<RoleData> queryAllRole(PageRoll pageRoll,RoleData roleData){
		return rolePersistence.queryAllRole(pageRoll, roleData);
	}

	/**
	 * 查询权限(角色)信息
	 */
	public List<RoleData> queryAllRole(JSONObject jsonObj){
		return rolePersistence.queryAllRole(jsonObj);
	}
	
	/**
	 * 更新权限(角色)信息
	 */
	public void updateRole(RoleData data) {
		rolePersistence.updateRole(data);
	}

	/**
	 * 新增权限(角色)信息
	 */
	public void saveRole(RoleData data){
		rolePersistence.saveRole(data);
	}
	
	/**
	 * 权限配置人员信息
	 * @flag true 为已配置的人员,  false为未配置的人员
	 * @param roleID 权限ID
	 */
	public List<String> getAuthorizedUser(boolean flag, String roleID){
		return rolePersistence.getAuthorizedUser(flag, roleID);
	}

	@Override
	public int getRoleNum() {
		return rolePersistence.count();
	}
	
}
