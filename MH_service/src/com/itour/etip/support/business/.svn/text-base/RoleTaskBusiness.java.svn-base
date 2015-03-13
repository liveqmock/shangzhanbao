package com.itour.etip.support.business;

import java.util.List;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.support.data.RoleTaskData;
import com.itour.etip.support.persistence.IRoleTaskPersistence;

public class RoleTaskBusiness extends FrmBusiness implements IRoleTaskBusiness{
	
	private IRoleTaskPersistence roleTaskPersistence;

	public IRoleTaskPersistence getRoleTaskPersistence() {
		return roleTaskPersistence;
	}

	public void setRoleTaskPersistence(IRoleTaskPersistence roleTaskPersistence) {
		this.roleTaskPersistence = roleTaskPersistence;
	}

	public void addRoleTasks(String roleID, String[] processTaskRegistryIDs) {
		// TODO Auto-generated method stub
		for(int i=0;i<processTaskRegistryIDs.length;i++){
			RoleTaskData rtd = new RoleTaskData();
			rtd.setRoleID(roleID);
			rtd.setProcessTaskRegistryID(processTaskRegistryIDs[i]);
			roleTaskPersistence.add(rtd);
		}
	}

	public void deleteRoleTasks(String[] roleIDs) {
		// TODO Auto-generated method stub
		for(int i=0;i<roleIDs.length;i++){
			roleTaskPersistence.executeSQL("delete from ROLETASK  where roleID='"+roleIDs[i]+"'");
		}
	}

	public void deleteTasksOfRole(String roleID, String[] processTaskRegistryIDs) {
		// TODO Auto-generated method stub
		for(int i=0;i<processTaskRegistryIDs.length;i++){
			roleTaskPersistence.executeSQL("delete from ROLETASK  where roleID='"+roleID+"' and processRegistryID='"+processTaskRegistryIDs[i]+"'");
		}
	}

	public List getTaskOfRole(String roleID) {
		// TODO Auto-generated method stub
		return roleTaskPersistence.search("select r.processTaskRegistryID from RoleTaskData r where r.roleID='"+roleID+"'");
	}

}
