package com.sys.userrole.persistence;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBasePersistence;
import com.sys.userrole.data.UserRoleCtnData;

/**
 * 操作用户与权限关联关系
 * @author LiuLei
 */
public interface IUserRolePersistence extends IBasePersistence<UserRoleCtnData> {

	/**
	 *  添加用户And权限关联
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:49:55
	 * @param data
	 */
	public void addUserRole(UserRoleCtnData data);
	
	/**
	 * 删除用户——角色关联
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:50:02
	 * @param roleId
	 * @param userId
	 */
	public void deleteUserRole(String roleId, String userId);
	
	/**
	 * 查询角色基本信息ID
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:50:11
	 * @param jsonObj
	 * @return
	 */
	public List<String> getUserRoleList(JSONObject jsonObj);
	
	/**
	 * 根据用户id查询中间表信息
	 * @author：jmj
	 * @update：
	 * 2013-8-19 上午10:43:36
	 * @param userId
	 * @return
	 */
	public List<UserRoleCtnData> getUserRolesByUserId(String userId);
}
