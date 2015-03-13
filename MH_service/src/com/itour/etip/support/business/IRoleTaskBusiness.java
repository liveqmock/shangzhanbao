package com.itour.etip.support.business;

import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.kit.exception.ETIPException;

public interface IRoleTaskBusiness extends IBusiness{

	public void addRoleTasks(String roleID,String[] processTaskRegistryIDs);
	
	public void deleteTasksOfRole(String roleID,String[] processTaskRegistryIDs);
	
	public void deleteRoleTasks(String[] roleIDs);
	
	public List getTaskOfRole(String roleID);
	
}
