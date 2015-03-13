package com.sys.role.facade;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.resources.data.ResourceData;
import com.sys.resources.data.RoleResData;
import com.sys.resources.service.IResourceService;
import com.sys.resources.service.IRoleResService;
import com.sys.role.data.RoleData;
import com.sys.role.service.IRoleService;
import com.sys.userrole.data.AuthorityData;
import com.sys.userrole.service.IUserRoleService;
/**
 * 角色管理操作facade层
 * @author jmj
 */
@Component("roleFacade")
public class RoleFacade extends FrmFacade {
	@Resource(name="roleService")
	private IRoleService roleService;
	@Resource(name="userRoleService")
	private IUserRoleService userRoleService;
	@Resource(name="resourceService")
	private IResourceService resourceService;
	@Resource(name="roleResService")
	private IRoleResService roleResService;
	
	/**
	 * 查询权限(角色)信息(分页显示)
	 */
	public List<RoleData> queryAllRole(PageRoll pageRoll,RoleData roleData){
		return roleService.queryAllRole(pageRoll,roleData);
	}
	
	/**
	 * 查询权限(角色)信息
	 */
	public List<RoleData> queryAllRole(JSONObject jsonObj){
		return roleService.queryAllRole(jsonObj);
	}
	
	/**
	 * 查询权限(角色)信息
	 */
	public List<RoleData> queryAllRole(){
		return queryAllRole(null);
	}
	
	/**
	 * 删除权限(角色)信息
	 */
	public void deleteRole(String id){
		roleService.deleteRole(id);
	}
	
	/**
	 * 更新权限(角色)信息
	 */
	public void updateRole(RoleData data){
		roleService.updateRole(data);
	}
	
	/**
	 * 新增权限(角色)信息
	 */
	public void saveRole(RoleData data){
		roleService.saveRole(data);
	}

	/**
	 * 权限配置人员信息
	 * @flag true 为已配置的人员,  false为未配置的人员
	 * @param roleID 权限ID
	 */
	public List<String> getAuthorizedUser(boolean flag, String roleID){
		return roleService.getAuthorizedUser(flag, roleID);
	}

	/**
	 * @author 何大勇
	 * @date 2013-9-23
	 * @update
	 * @param pageRoll
	 * @param authorityData
	 * @return
	 */
	public List<AuthorityData> getAuthorityList(PageRoll pageRoll,
			AuthorityData authorityData) {
		return userRoleService.getAllAuthority(pageRoll, authorityData);
	}

	/**
	 * @author 何大勇
	 * @date 2013-9-23
	 * @update
	 * @param authorityData
	 */
	public void addAuthority(AuthorityData authorityData) {
		userRoleService.addAuthority(authorityData);
	}
	/**
	 * 查询资源
	 * 2013-10-11 上午11:35:12
	 * @author jmj
	 */
	public List<ResourceData> getResource(String type){
		return resourceService.getResource(type);
	}
	/**
	 * 增加资源信息
	 * 2013-10-11 下午04:40:13
	 * @author jmj
	 */
	public void addRoleRes(RoleResData roleResData){
		roleResService.addRoleRes(roleResData);
	}
	/**
	 * 根据角色id查询角色权限信息
	 * 2013-10-11 下午05:51:09
	 * @author jmj
	 */
	public List<RoleResData> getRoleResById(String roleid){
		return roleResService.getRoleResById(roleid);
	}
	/**
	 * 查询资源并存储：资源ID-key,资源名称-value
	 * 2013-10-12 上午11:41:39
	 * @author jmj
	 */
	public Map<String,String> getResoureMap(){
		return resourceService.getResoureMap();
	}
	/**
	 * 根据角色id删除角色权限信息
	 * 2013-10-12 下午02:42:30
	 * @author jmj
	 */
	public void deleteRoleResByRoleId(String roleid){
		roleResService.deleteRoleResByRoleId(roleid);
	}
	
}
