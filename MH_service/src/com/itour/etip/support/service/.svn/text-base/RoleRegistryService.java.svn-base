package com.itour.etip.support.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.support.business.IProcessRegistryBusiness;
import com.itour.etip.support.business.IProcessTaskRegistryBusiness;
import com.itour.etip.support.business.IRoleAuthorityBusiness;
import com.itour.etip.support.business.IRoleRegistryBusiness;
import com.itour.etip.support.business.IRoleTaskBusiness;
import com.itour.etip.support.business.IServiceRegistryBusiness;
import com.itour.etip.support.data.ProcessTaskRegistryData;
import com.itour.etip.support.data.RoleRegistryData;

public class RoleRegistryService extends FrmService implements IRoleRegistryService{
	
	private IRoleRegistryBusiness roleRegistryBusiness;
	
	private IRoleAuthorityBusiness roleAuthorityBusiness;
	
	private IServiceRegistryBusiness serviceRegistryBusiness;
	
	private IProcessTaskRegistryBusiness processTaskRegistryBusiness;
	
	private IRoleTaskBusiness roleTaskBusiness;

	public IRoleTaskBusiness getRoleTaskBusiness() {
		return roleTaskBusiness;
	}

	public void setRoleTaskBusiness(IRoleTaskBusiness roleTaskBusiness) {
		this.roleTaskBusiness = roleTaskBusiness;
	}

	public IProcessTaskRegistryBusiness getProcessTaskRegistryBusiness() {
		return processTaskRegistryBusiness;
	}

	public void setProcessTaskRegistryBusiness(
			IProcessTaskRegistryBusiness processTaskRegistryBusiness) {
		this.processTaskRegistryBusiness = processTaskRegistryBusiness;
	}

	public IRoleAuthorityBusiness getRoleAuthorityBusiness() {
		return roleAuthorityBusiness;
	}

	public void setRoleAuthorityBusiness(
			IRoleAuthorityBusiness roleAuthorityBusiness) {
		this.roleAuthorityBusiness = roleAuthorityBusiness;
	}

	public IServiceRegistryBusiness getServiceRegistryBusiness() {
		return serviceRegistryBusiness;
	}

	public void setServiceRegistryBusiness(
			IServiceRegistryBusiness serviceRegistryBusiness) {
		this.serviceRegistryBusiness = serviceRegistryBusiness;
	}

	public IRoleRegistryBusiness getRoleRegistryBusiness() {
		return roleRegistryBusiness;
	}

	public void setRoleRegistryBusiness(IRoleRegistryBusiness roleRegistryBusiness) {
		this.roleRegistryBusiness = roleRegistryBusiness;
	}

	public void addRole(RoleRegistryData data,String[] serviceCode) {
		// TODO Auto-generated method stub
		roleRegistryBusiness.addRole(data);
		String id = data.getId();
		roleAuthorityBusiness.addRoleAuthoritys(id, serviceCode);
	}

	public void deleteRole(String id) {
		// TODO Auto-generated method stub
		String[] ids= new String[1];
		ids[0] = id;
		roleAuthorityBusiness.deleteAuthorityOfRole(ids);
		roleRegistryBusiness.deleteRole(id);
	}

	public void deleteRoles(String[] ids) {
		// TODO Auto-generated method stub
		roleAuthorityBusiness.deleteAuthorityOfRole(ids);
		roleRegistryBusiness.deleteRoles(ids);
	}

	public Map retrieveRole(String id) {
		// TODO Auto-generated method stub
		Map map = new HashedMap();
		map.put("role", roleRegistryBusiness.retrieveRole(id));
		List list = roleAuthorityBusiness.getServiceCodes(id);
		String[] ids = new String[list.size()];
		for(int i=0;i<list.size();i++){
			ids[i] = (String)list.get(i);
		}
		map.put("services", serviceRegistryBusiness.getServiceList(ids));
		return map;
	}

	public List searchRoles(PageRoll pageRoll, RoleRegistryData data) {
		// TODO Auto-generated method stub
		return roleRegistryBusiness.searchRoles(pageRoll, data);
	}

	public void updateRole(RoleRegistryData data,String[] serviceCode) {
		// TODO Auto-generated method stub
		String[] ids = new String[1];
		ids[0] = data.getId();
		roleAuthorityBusiness.deleteAuthorityOfRole(ids);
		roleRegistryBusiness.updateRole(data);
		roleAuthorityBusiness.addRoleAuthoritys(data.getId(), serviceCode);
	}
	
	public List searchPositions(PageRoll pageRoll, RoleRegistryData data) {
		return roleRegistryBusiness.searchPositions(pageRoll, data);
	}
	/**
	 * 此处查询业务流程中注册的任务，用于给指定角色授权。
	 */
	public List getProcessTask(PageRoll pageRoll,ProcessTaskRegistryData data){
		return processTaskRegistryBusiness.searchProcessTaskRegistrys(pageRoll, data);
	}

	public Map getTaskOfPosition(String roleID) {
		// TODO Auto-generated method stub
		Map map = new HashedMap();
		map.put("position", roleRegistryBusiness.retrieveRole(roleID));
		List list = roleTaskBusiness.getTaskOfRole(roleID);
		String[] ids = new String[list.size()];
		for(int i=0;i<list.size();i++){
			ids[i] = (String)list.get(i);
		}
		map.put("tasks", processTaskRegistryBusiness.getProcessTaskList(ids));
		return map;
	}
	
	public void addPosition(RoleRegistryData data,String[] ids){
		roleRegistryBusiness.addRole(data);
		String id = data.getId();
		roleTaskBusiness.addRoleTasks(id, ids);
		
	}

	public void updatePosition(RoleRegistryData data, String[] ids) {
		// TODO Auto-generated method stub
		String[] positionID = new String[1];
		positionID[0] = data.getId();
		roleTaskBusiness.deleteRoleTasks(positionID);
		roleRegistryBusiness.updateRole(data);
		roleTaskBusiness.addRoleTasks(data.getId(), ids);
	}

	public void deletePositions(String[] ids) {
		// TODO Auto-generated method stub
		roleTaskBusiness.deleteRoleTasks(ids);
		roleRegistryBusiness.deleteRoles(ids);
	}

}
