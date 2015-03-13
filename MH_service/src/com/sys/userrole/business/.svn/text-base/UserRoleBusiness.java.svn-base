package com.sys.userrole.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.userrole.data.AuthorityData;
import com.sys.userrole.data.UserRoleCtnData;
import com.sys.userrole.persistence.IAuthorityPersistence;
import com.sys.userrole.persistence.IRoleAuthorityCtnPersistence;
import com.sys.userrole.persistence.IUserRolePersistence;

/**
 * 操作用户与权限关联关系business层实现类
 * @author LiuLei
 */
@Component("userRoleBusiness")
public class UserRoleBusiness extends FrmBusiness implements IUserRoleBusiness {
	@Resource(name="userRoleCtnPersistence")
	private IUserRolePersistence userRolePersistence;
	@Resource(name="authorityPersistence")
	private IAuthorityPersistence authorityPersistence;
	@Resource(name="roleAuthorityCtnPersistence")
	private IRoleAuthorityCtnPersistence roleAuthorityCtnPersistence;


	/**
	 *  添加用户And权限关联
	 *  @update:jmj
	 */
	public void addUserRole(UserRoleCtnData data){
		userRolePersistence.addUserRole(data);
	}
	
	/**
	 * 删除用户——角色关联
	 */
	public void deleteUserRole(String roleId, String userId){
		userRolePersistence.deleteUserRole(roleId, userId);
	}
	
	/**
	 * 查询角色基本信息ID
	 */
	public List<String> getUserRoleList(JSONObject jsonObj){
		return userRolePersistence.getUserRoleList(jsonObj);
	}

	@Override
	public List<AuthorityData> getAllAuthority(PageRoll pageRoll,
			AuthorityData authorityData) {
		
		Map<String, String > map = new HashMap<String, String>();
		map.put("name", "like");
		
		return authorityPersistence.searchByField(pageRoll, authorityData, map, "type ,createTime desc");
	}

	@Override
	public void addAuthority(AuthorityData authorityData) {
		authorityPersistence.add(authorityData);
	}

}