package com.sys.resources.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.sys.resources.business.IRoleResBusiness;
import com.sys.resources.data.RoleResData;

/**
 * 角色权限service层实现类
 * @author jmj
 * 2013-10-11 上午11:19:59
 */
@Component("roleResService")
public class RoleResService extends FrmService implements IRoleResService{

	@Resource(name="roleResBusiness")
	private IRoleResBusiness roleResBusiness;
	@Override
	public void addRoleRes(RoleResData roleResData) {
		roleResBusiness.addRoleRes(roleResData);
	}
	@Override
	public List<RoleResData> getRoleResById(String roleid) {
		return roleResBusiness.getRoleResById(roleid);
	}
	@Override
	public void deleteRoleResByRoleId(String roleid) {
		roleResBusiness.deleteRoleResByRoleId(roleid);
	}
	
	

}
