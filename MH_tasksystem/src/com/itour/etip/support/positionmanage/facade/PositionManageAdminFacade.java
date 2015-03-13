package com.itour.etip.support.positionmanage.facade;

import java.util.List;
import java.util.Map;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;

import com.itour.etip.support.data.ProcessTaskRegistryData;
import com.itour.etip.support.data.RoleRegistryData;
import com.itour.etip.support.service.IRoleRegistryService;

public class PositionManageAdminFacade extends FrmFacade{
	
	private IRoleRegistryService roleRegistryService;

	public IRoleRegistryService getRoleRegistryService() {
		return roleRegistryService;
	}

	public void setRoleRegistryService(IRoleRegistryService roleRegistryService) {
		this.roleRegistryService = roleRegistryService;
	}
	
	
	public List getPositionList(PageRoll pageRoll,RoleRegistryData data){
		return roleRegistryService.searchPositions(pageRoll, data);
	}
	
	public List getProcessTask(PageRoll pageRoll,ProcessTaskRegistryData data){
		return roleRegistryService.getProcessTask(pageRoll, data);
	}
	
	public Map getTaskOfPosition(String roleID){
		return roleRegistryService.getTaskOfPosition(roleID);
	}
	
	public void addPosition(RoleRegistryData data,String[] ids){
		roleRegistryService.addPosition(data, ids);
	}
	
	public void updatePosition(RoleRegistryData data,String[] ids){
		roleRegistryService.updatePosition(data,ids);
	}
	
	public void deletePositions(String[] ids){
		roleRegistryService.deletePositions(ids);
	}
	
}
