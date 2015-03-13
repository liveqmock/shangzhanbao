package com.itour.etip.support.service;

import java.util.List;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.support.business.IRoleTaskBusiness;

public class RoleTaskService extends FrmService implements IRoleTaskService{
	
	private IRoleTaskBusiness roleTaskBusiness;

	public IRoleTaskBusiness getRoleTaskBusiness() {
		return roleTaskBusiness;
	}

	public void setRoleTaskBusiness(IRoleTaskBusiness roleTaskBusiness) {
		this.roleTaskBusiness = roleTaskBusiness;
	}

	public void addRoleTasks(String roleID, String[] processTaskRegistryIDs) {
		// TODO Auto-generated method stub
		roleTaskBusiness.addRoleTasks(roleID, processTaskRegistryIDs);
	}  

	public void deleteRoleTasks(String[] roleIDs) {
		// TODO Auto-generated method stub
		roleTaskBusiness.deleteRoleTasks(roleIDs);
	}

	public void deleteTasksOfRole(String roleID, String[] processTaskRegistryIDs) {
		// TODO Auto-generated method stub
		roleTaskBusiness.deleteTasksOfRole(roleID, processTaskRegistryIDs);
	}

	public List getTaskOfRole(String roleID) {
		// TODO Auto-generated method stub
		return roleTaskBusiness.getTaskOfRole(roleID);
	}

}
