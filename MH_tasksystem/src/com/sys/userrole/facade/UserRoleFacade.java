package com.sys.userrole.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmFacade;
import com.sys.userrole.data.UserRoleCtnData;
import com.sys.userrole.service.IUserRoleService;

/**
 * 操作用户与权限关联关系facade层
 * @author LiuLei
 */
@Component("userRoleFacade")
public class UserRoleFacade extends FrmFacade {
	@Resource(name="userRoleService")
	private IUserRoleService userRoleService;

	/**
	 * 添加用户And权限关联
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:57:50
	 * @param data
	 */
	public void addUserRole(UserRoleCtnData data){
		userRoleService.addUserRole(data);
	}
	
	/**
	 * 根据角色删除数据
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:57:57
	 * @param roleId
	 */
	public void deleteAllByRole(String roleId){
		this.deleteUserRole(roleId, null);
	}
	
	/**
	 * 根据用户删除数据
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:58:04
	 * @param userId
	 */
	public void deleteAllByUser(String userId){
		this.deleteUserRole(null, userId);
	}
	
	/**
	 *  根据用户——角色删除数据
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:58:16
	 * @param roleId
	 * @param userId
	 */
	public void deleteUserRole(String roleId, String userId){
		userRoleService.deleteUserRole(roleId, userId);
	}
	
	/**
	 * 查询角色基本信息ID
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:58:23
	 * @param jsonObj
	 * @return
	 */
	public List<String> getUserRoleList(JSONObject jsonObj){
		return userRoleService.getUserRoleList(jsonObj);
	}
}
