package com.itour.etip.support.business;

import java.util.List;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.support.data.RoleAuthorityData;
import com.itour.etip.support.persistence.IRoleAuthorityPersistence;

public class RoleAuthorityBusiness extends FrmBusiness implements IRoleAuthorityBusiness{
	
	private IRoleAuthorityPersistence roleAuthorityPersistence;


	public void addRoleAuthoritys(String roleID, String[] serviceCode) {
		// TODO Auto-generated method stub
		for(int i=0;i<serviceCode.length;i++){
			RoleAuthorityData ard = new RoleAuthorityData();
			ard.setRoleID(roleID);
			ard.setServiceCode(serviceCode[i]);
			roleAuthorityPersistence.add(ard);
		}
		
	}

	public void deleteAuthorityOfRole(String[] roleIDs) {
		// TODO Auto-generated method stub
		for(int i=0;i<roleIDs.length;i++){
			roleAuthorityPersistence.executeSQL("delete from ROLEAUTHORITY where roleID='"+roleIDs[i]+"'");
		}
		
	}

	public void deleteRoleAuthoritys(String roleID, String[] serviceCode) {
		// TODO Auto-generated method stub
		for(int i=0;i<serviceCode.length;i++){
			roleAuthorityPersistence.executeSQL("delete from ROLEAUTHORITY where roleID='"+roleID+"' and serviceCode='"+serviceCode[i]+"'");
		}
	}

	public IRoleAuthorityPersistence getRoleAuthorityPersistence() {
		return roleAuthorityPersistence;
	}

	public void setRoleAuthorityPersistence(
			IRoleAuthorityPersistence roleAuthorityPersistence) {
		this.roleAuthorityPersistence = roleAuthorityPersistence;
	}

	public List getServiceCodes(String roleID) {
		// TODO Auto-generated method stub
		return roleAuthorityPersistence.search("select r.serviceCode from RoleAuthorityData r where r.roleID='"+roleID+"'");
	}

}
