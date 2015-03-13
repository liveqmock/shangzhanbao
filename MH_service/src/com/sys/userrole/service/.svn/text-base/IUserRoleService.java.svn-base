package com.sys.userrole.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.userrole.data.AuthorityData;
import com.sys.userrole.data.UserRoleCtnData;

/**
 * 操作用户与权限关联关系Service层接口
 * @author LiuLei
 */
public interface IUserRoleService extends IService {

	/**
	 * 添加用户And权限关联
	 * @update:jmj
	 */
	public void addUserRole(UserRoleCtnData data);
	
	/**
	 * 删除用户——角色关联
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:56:47
	 * @param roleId
	 * @param userId
	 */
	public void deleteUserRole(String roleId, String userId);
	
	/**
	 * 查询角色基本信息ID
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:56:54
	 * @param jsonObj
	 * @return
	 */
	public List<String> getUserRoleList(JSONObject jsonObj);
	
	
	/**
	 * @author 何大勇
	 * @date 2013-9-23
	 * @update
	 * @param pageRoll
	 * @param authorityData
	 * @return
	 */
	public List<AuthorityData> getAllAuthority(PageRoll pageRoll, AuthorityData authorityData);

	/**
	 * @author 何大勇
	 * @date 2013-9-23
	 * @update
	 * @param authorityData
	 */
	public void addAuthority(AuthorityData authorityData);
}
