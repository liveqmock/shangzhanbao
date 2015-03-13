package com.sys.role.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.sys.role.data.RoleData;
import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
/********************************************************
Copyright (C), 2009-2011, GoMai.
File name:   IRoleService.java
Author: CuiYunYan LiuLei  Version:  1.0.0  Date: 2011-6-17
***********************************************************/
/**
 * 角色管理操作service层接口
 * @author jmj
 */
public interface IRoleService extends IService {

	/**
	 * 查询权限(角色)信息(分页显示)
	 */
	public List<RoleData> queryAllRole(PageRoll pageRoll, RoleData roleData);
	
	/**
	 * 查询权限(角色)信息
	 */
	public List<RoleData> queryAllRole(JSONObject jsonObj);
	
	/**
	 * 删除权限(角色)信息
	 */
	public void deleteRole(String id);
	
	/**
	 * 更新权限(角色)信息
	 */
	public void updateRole(RoleData data);
	
	/**
	 * 新增权限(角色)信息
	 */
	public void saveRole(RoleData data);
	
	/**
	 * 权限配置人员信息
	 * @flag true 为已配置的人员,  false为未配置的人员
	 * @param roleID 权限ID
	 */
	public List<String> getAuthorizedUser(boolean flag, String roleID);

	/**
	 * 获取用户角色个数
	 * @author pb
	 * @date 2013-8-26
	 * @return
	 */
	public int getRoleNum();
}
