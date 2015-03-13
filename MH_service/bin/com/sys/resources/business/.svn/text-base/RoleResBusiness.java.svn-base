package com.sys.resources.business;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.sys.resources.data.RoleResData;
import com.sys.resources.persistence.IRoleResPersistence;

/**
 * 权限business层实现类
 * @author jmj
 * 2013-10-11 上午11:18:42
 */
@Component("roleResBusiness")
public class RoleResBusiness extends FrmBusiness implements IRoleResBusiness{

	@Resource(name="roleResPersistence")
	private IRoleResPersistence roleResPersistence;
	@Override
	public void addRoleRes(RoleResData roleResData) {
		roleResPersistence.addRoleRes(roleResData);
	}
	@Override
	public List<RoleResData> getRoleResById(String id) {
		return roleResPersistence.getRoleResById(id);
	}
	@Override
	public void deleteRoleResByRoleId(String roleid) {
		roleResPersistence.deleteRoleResByRoleId(roleid);
	}

	

}
