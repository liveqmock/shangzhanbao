package com.itour.etip.support.service;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.support.business.IRoleAuthorityBusiness;

public class RoleAuthorityService extends FrmService implements IRoleAuthorityService{
	
	private IRoleAuthorityBusiness roleAuthorityBusiness;

	public IRoleAuthorityBusiness getRoleAuthorityBusiness() {
		return roleAuthorityBusiness;
	}

	public void setRoleAuthorityBusiness(
			IRoleAuthorityBusiness roleAuthorityBusiness) {
		this.roleAuthorityBusiness = roleAuthorityBusiness;
	}

	public void addRoleAuthoritys(String roleID, String[] serviceCode) {
		// TODO Auto-generated method stub
		roleAuthorityBusiness.addRoleAuthoritys(roleID, serviceCode);
	}

	public void deleteAuthorityOfRole(String[] roleIDs) {
		// TODO Auto-generated method stub
		roleAuthorityBusiness.deleteAuthorityOfRole(roleIDs);
	}

	public void deleteRoleAuthoritys(String roleID, String[] serviceCode) {
		// TODO Auto-generated method stub
		roleAuthorityBusiness.deleteRoleAuthoritys(roleID, serviceCode);
	}

}
