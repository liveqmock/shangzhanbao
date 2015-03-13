package com.sys.userrole.business;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.userrole.data.AuthorityData;
import com.sys.userrole.data.UserRoleCtnData;

/**
 * 操作用户与权限关联关系business层接口
 * @author LiuLei
 */
public interface IUserRoleBusiness extends IBusiness {

	/**
	 * 添加用户And权限关联
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:55:45
	 * @param data
	 */
	public void addUserRole(UserRoleCtnData data);
	
	/**
	 *  删除用户——角色关联
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:55:52
	 * @param roleId
	 * @param userId
	 */
	public void deleteUserRole(String roleId, String userId);
	
	/**
	 * 查询角色基本信息ID
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:55:59
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
	public List<AuthorityData> getAllAuthority(PageRoll pageRoll,
			AuthorityData authorityData);

	/**
	 * @author 何大勇
	 * @date 2013-9-23
	 * @update
	 * @param authorityData
	 */
	public void addAuthority(AuthorityData authorityData);
}
