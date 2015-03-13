package com.itour.etip.support.service;

import java.util.List;
import java.util.Map;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.support.data.ProcessTaskRegistryData;
import com.itour.etip.support.data.RoleRegistryData;

public interface IRoleRegistryService extends IService{
	
	public void addRole(RoleRegistryData data,String[] serviceCode);
	
	public void deleteRole(String id);
	
	public void deleteRoles(String[] ids);
	
	public void updateRole(RoleRegistryData data,String[] serviceCode);
	
	public Map retrieveRole(String id);
	
	public List searchRoles(PageRoll pageRoll,RoleRegistryData data);

	public List searchPositions(PageRoll pageRoll,RoleRegistryData data);
	
	public List getProcessTask(PageRoll pageRoll,ProcessTaskRegistryData data);
	
	public Map getTaskOfPosition(String roleID);
	
	public void addPosition(RoleRegistryData data,String[] ids);
	
	public void updatePosition(RoleRegistryData data,String[] ids);
	
	public void deletePositions(String[] ids);

}
