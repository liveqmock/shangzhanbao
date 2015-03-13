package com.sys.resources.business;


import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.sys.resources.data.RoleResData;

/**
 * 角色权限business层接口
 * @author jmj
 * 2013-10-11 上午11:17:57
 */
public interface IRoleResBusiness extends IBusiness {

	/**
	 * 增加角色权限信息
	 * 2013-10-11 下午03:39:58
	 * @author jmj
	 */
	public void addRoleRes(RoleResData roleResData);
	
	/**
	 * 根据角色id查询角色权限信息
	 * 2013-10-11 下午05:51:09
	 * @author jmj
	 */
	public List<RoleResData> getRoleResById(String roleid);
	
	/**
	 * 根据角色id删除角色权限信息
	 * 2013-10-12 下午02:42:30
	 * @author jmj
	 */
	public void deleteRoleResByRoleId(String roleid);
	
	
}
