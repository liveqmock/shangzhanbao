package com.itour.etip.support.roleregistry.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.itour.etip.contract.JMSService;
import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.itour.etip.pub.kit.jms.JMSMessage;
import com.itour.etip.support.data.RoleRegistryData;
import com.itour.etip.support.data.ServiceRegistryData;
import com.itour.etip.support.service.IRoleRegistryService;

public class RoleRegistryAdminFacade extends FrmFacade {

	private IRoleRegistryService roleRegistryService;

	private static List<RoleRegistryData> roleList = new ArrayList<RoleRegistryData>();

	/**
	 * 查询角色信息
	 * 
	 * @return List
	 * 
	 */
	public List getRoleList(PageRoll pageRoll, RoleRegistryData data) {

		return roleRegistryService.searchRoles(pageRoll, data);

	}

	/**
	 * 查询系统已存在权限信息
	 * 
	 * @return List
	 * 
	 */
	private static List<ServiceRegistryData> serviceList = new ArrayList<ServiceRegistryData>();

	public List getSystemServiceList(PageRoll pageRoll, JSONObject obj) {
		if (serviceList.size() < 1) {
			serviceList.clear();
			for (int i = 0; i < 8; i++) {
				ServiceRegistryData service = new ServiceRegistryData();
				service.setId(String.valueOf(i));
				service.setParentID("父编号" + String.valueOf(i));
				service.setServiceCode("服务代码" + String.valueOf(i));
				service.setServiceType("服务类型" + String.valueOf(i));
				service.setServiceAddress("服务地址" + String.valueOf(i));
				service.setServiceName("服务名字" + String.valueOf(i));
				service.setMemo("备注" + String.valueOf(i));
				serviceList.add(service);
			}
		}

		pageRoll.setTotalRows(serviceList.size());

		List sub = null;
		if ((Integer.valueOf(pageRoll.getStartRow()) + Integer.valueOf(pageRoll
				.getPageSize())) > serviceList.size()) {
			sub = serviceList.subList(Integer.valueOf(pageRoll.getStartRow()),
					serviceList.size());
		} else {
			sub = serviceList.subList(Integer.valueOf(pageRoll.getStartRow()),
					(Integer.valueOf(pageRoll.getStartRow()) + Integer
							.valueOf(pageRoll.getPageSize())));
		}

		return sub;

	}

	/**
	 * 添加角色信息
	 * 
	 * @return
	 * 
	 */
	public void addRole(RoleRegistryData rr, String[] serviceCode) {
		roleRegistryService.addRole(rr, serviceCode);

		String queueName = CacheUtil.paraCache.getParaValue("RoleRefreshTopic");
		Map<String, String> contentMap = new HashMap<String, String>();

		contentMap.put("Refresh", "true");
		JMSService jmsService = new JMSService();
		jmsService.sendQueueMessageTwo(queueName, contentMap);

		// rr.setId(String.valueOf(roleList.size()));
		// roleList.add(rr);
	}

	/**
	 * 根据id取得角色信息
	 * 
	 * @return RoleRegistryData
	 * 
	 */
	public Map getRole(String id) {
		// return roleList.get(Integer.valueOf(id));
		return roleRegistryService.retrieveRole(id);
	}

	/**
	 * 修改角色信息
	 * 
	 * @return
	 * 
	 */
	public void updateRole(RoleRegistryData rr, String[] serviceCode) {
		roleRegistryService.updateRole(rr, serviceCode);

		String queueName = CacheUtil.paraCache.getParaValue("RoleRefreshTopic");
		Map<String, String> contentMap = new HashMap<String, String>();

		contentMap.put("Refresh", "true");
		JMSService jmsService = new JMSService();
		jmsService.sendQueueMessageTwo(queueName, contentMap);
	}

	/**
	 * 删除角色信息
	 * 
	 * @return
	 * 
	 */
	public void deleteRole(String[] ids) {
		roleRegistryService.deleteRoles(ids);

		JMSMessage jms = new JMSMessage();
		String queueName = CacheUtil.paraCache.getParaValue("RoleRefreshTopic");
		jms.setDestination(queueName);
		// jms.setMessageType(JMSMessage.MESSAGETYPE_ROLE);
		Map<String, String> contentMap = new HashMap<String, String>();
		contentMap.put("Refresh", "true");
		JMSService jmsService = new JMSService();
		jmsService.sendQueueMessageTwo(queueName,contentMap);
		
	}

	public IRoleRegistryService getRoleRegistryService() {
		return roleRegistryService;
	}

	public void setRoleRegistryService(IRoleRegistryService roleRegistryService) {
		this.roleRegistryService = roleRegistryService;
	}

}
