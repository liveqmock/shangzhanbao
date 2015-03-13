package com.itour.etip.support.business;

import java.util.List;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.util.SQLTest;
import com.itour.etip.support.data.RoleRegistryData;
import com.itour.etip.support.persistence.IRoleRegistryPersistence;

public class RoleRegistryBusiness extends FrmBusiness implements IRoleRegistryBusiness{
	
	
	private IRoleRegistryPersistence roleRegistryPersistence;

	public IRoleRegistryPersistence getRoleRegistryPersistence() {
		return roleRegistryPersistence;
	}

	public void setRoleRegistryPersistence(
			IRoleRegistryPersistence roleRegistryPersistence) {
		this.roleRegistryPersistence = roleRegistryPersistence;
	}

	public void addRole(RoleRegistryData data) {
		// TODO Auto-generated method stub
		roleRegistryPersistence.add(data);
	}

	public void deleteRole(String id) {
		// TODO Auto-generated method stub
		roleRegistryPersistence.delete(id);
	}

	public void deleteRoles(String[] ids) {
		// TODO Auto-generated method stub
		roleRegistryPersistence.delete(ids);
	}

	public RoleRegistryData retrieveRole(String id) {
		// TODO Auto-generated method stub
		return roleRegistryPersistence.retrieve(id);
	}

	public List searchRoles(PageRoll pageRoll, RoleRegistryData data) {
		// TODO Auto-generated method stub
		//data.setRoleClass("1");
		//String hql = SQLTest.makeSQL("from RoleRegistryData ", data, null, null);
		String hql = "from RoleRegistryData r where r.roleClass in(1,3,4)";
		if(data.getRoleName()!=null && !"".equals(data.getRoleName())){
			hql += "and r.roleName like '%"+data.getRoleName()+"%'";
		}
		pageRoll.setSearchSQL(hql);
		pageRoll.setCountSQL("select count(*) "+hql);
		return roleRegistryPersistence.search(pageRoll);
	}

	public void updateRole(RoleRegistryData data) {
		// TODO Auto-generated method stub
		roleRegistryPersistence.update(data);
	}
	
	public List searchPositions(PageRoll pageRoll, RoleRegistryData data){
		data.setRoleClass("2");
		String hql = SQLTest.makeSQL("from RoleRegistryData ", data, null, null);
		pageRoll.setSearchSQL(hql);
		pageRoll.setCountSQL("select count(*) "+hql);
		return roleRegistryPersistence.search(pageRoll);
	}

}
