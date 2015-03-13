package com.sys.role.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.sys.role.business.IRoleBusiness;
import com.sys.role.data.RoleData;
import com.common.util.Page;
import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;

/**
 *角色管理操作service层
 * @author jmj
 */
@Component("roleService")
public class RoleService extends FrmBusiness implements IRoleService {
	@Resource(name="roleBusiness")
	private IRoleBusiness roleBusiness;

	/**
	 * 查询权限(角色)信息(分页显示)
	 */
	public List<RoleData> queryAllRole(PageRoll pageRoll, RoleData roleData){
		pageRoll=PageRoll.set(Page.SIZE_10, pageRoll);
		return roleBusiness.queryAllRole(pageRoll, roleData);
	}
	
	/**
	 * 查询权限(角色)信息
	 */
	public List<RoleData> queryAllRole(JSONObject jsonObj){
		return roleBusiness.queryAllRole(jsonObj);
	}
	
	/**
	 * 删除权限(角色)信息
	 */
	public void deleteRole(String id){
		roleBusiness.deleteRole(id);
	}
	
	/**
	 * 更新权限(角色)信息
	 */
	public void updateRole(RoleData data){
		roleBusiness.updateRole(data);
	}
	
	/**
	 * 新增权限(角色)信息
	 */
	public void saveRole(RoleData data){
		roleBusiness.saveRole(data);
	}
	
	/**
	 * 权限配置人员信息
	 * @flag true 为已配置的人员,  false为未配置的人员
	 * @param roleID 权限ID
	 */
	public List<String> getAuthorizedUser(boolean flag, String roleID){
		return roleBusiness.getAuthorizedUser(flag, roleID);
	}

	@Override
	public int getRoleNum() {
		return roleBusiness.getRoleNum();
	}
}
