package com.sys.userrole.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.userrole.business.IUserRoleBusiness;
import com.sys.userrole.data.AuthorityData;
import com.sys.userrole.data.UserRoleCtnData;

/**
 * 操作用户与权限关联关系Service层实现类
 * @author LiuLei
 */
@Component("userRoleService")
public class UserRoleService extends FrmService implements IUserRoleService {
	@Resource(name="userRoleBusiness")
	private IUserRoleBusiness userRoleBusiness;

	/**
	 * 添加用户And权限关联
	 */
	public void addUserRole(UserRoleCtnData data){
		userRoleBusiness.addUserRole(data);
	}
	
	/**
	 * 删除用户——角色关联
	 */
	public void deleteUserRole(String roleId, String userId){
		userRoleBusiness.deleteUserRole(roleId, userId);
	}
	
	/**
	 * 查询角色基本信息ID
	 */
	public List<String> getUserRoleList(JSONObject jsonObj){
		return userRoleBusiness.getUserRoleList(jsonObj);
	}

	@Override
	public List<AuthorityData> getAllAuthority(PageRoll pageRoll,
			AuthorityData authorityData) {
		pageRoll.setPageSize(10);
		return userRoleBusiness.getAllAuthority(pageRoll, authorityData);
	}

	@Override
	public void addAuthority(AuthorityData authorityData) {
		userRoleBusiness.addAuthority(authorityData);
	}

}
