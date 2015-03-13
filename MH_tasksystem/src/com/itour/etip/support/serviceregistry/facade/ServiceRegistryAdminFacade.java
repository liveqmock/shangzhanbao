package com.itour.etip.support.serviceregistry.facade;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;

import com.itour.etip.pub.kit.tool.TreeUtils;
import com.itour.etip.support.data.ServiceRegistryData;
import com.itour.etip.support.service.IServiceRegistryService;


public class ServiceRegistryAdminFacade extends FrmFacade{
	
	private IServiceRegistryService serviceRegistryService;
	
	private static List<ServiceRegistryData> serviceList = new ArrayList<ServiceRegistryData>();
	
	private static List serviceTree = new ArrayList();

	
	/**
	 * 查询服务信息
	 * @return List
	
	 */
	public List getServiceList(PageRoll pageRoll,JSONObject obj){
		
		if(serviceList.size()<1){
			serviceList.clear();
			for(int i=0;i<8;i++){
				ServiceRegistryData service = new ServiceRegistryData();
				service.setId(String.valueOf(i));
				service.setParentID("父编号"+String.valueOf(i));
				service.setServiceCode("服务代码"+String.valueOf(i));
				service.setServiceType("服务类型"+String.valueOf(i));
				service.setServiceAddress("服务地址"+String.valueOf(i));
				service.setServiceName("服务名字"+String.valueOf(i));
				service.setMemo("备注"+String.valueOf(i));
				serviceList.add(service);
			}
		}
		
		pageRoll.setTotalRows(serviceList.size());
		
		List sub = null;
		if((Integer.valueOf(pageRoll.getStartRow())+Integer.valueOf(pageRoll.getPageSize()))>serviceList.size()){
			sub = serviceList.subList(Integer.valueOf(pageRoll.getStartRow()), serviceList.size());
		}else{
			sub = serviceList.subList(Integer.valueOf(pageRoll.getStartRow()), (Integer.valueOf(pageRoll.getStartRow())+Integer.valueOf(pageRoll.getPageSize())));
		}
		
		return sub;
		
	}
	/**
	 * 添加时保存服务信息
	 * @return 
	
	 */
	public ServiceRegistryData addService(ServiceRegistryData sr){
		return serviceRegistryService.addServiceRegistry(sr); 
//		sr.setId(String.valueOf(serviceList.size()));
//		serviceList.add(sr);
	}
	
	
	
	
	/**
	 * 修改权限信息
	 * @return
	
	 */
	public ServiceRegistryData updateService(ServiceRegistryData sr){
		return  serviceRegistryService.updateServiceRegistry(sr);
		
//		serviceList.set(Integer.valueOf(sr.getId()), sr);
//		System.out.println(sr.getServiceName());
	}
	
	/**
	 * 删除权限信息
	 * @return
	
	 */
	public void deleteService(String[] serviceCodes){
//		for(int i=0;i<ids.size();i++){
//			
//			System.out.println(ids.get(i));
//			ServiceRegistryData sr =(ServiceRegistryData)serviceTree.get(i);
//			serviceTree.remove(sr);
//		}
		serviceRegistryService.deleteServiceRegistrys(serviceCodes);
	}
	
	public List getServiceTree(ServiceRegistryData srd,String id){
		
		
	
		
		
		
		if(id.equals("0")){
			TreeUtils treeUtils = new TreeUtils(serviceRegistryService.searchServiceRegistrys(srd));
			List list =  treeUtils.getTransferedTrees();
			List theFirst = treeUtils.getRoots(list);
			
			return theFirst;
		}else if(id!=null){
			TreeUtils treeUtils = new TreeUtils(serviceRegistryService.searchServiceRegistrys(srd));
			List list =  treeUtils.getTransferedTrees();
			List childrens = treeUtils.getDirectChildrenTrees(list, id);
			return childrens;
		}
		return null;
	}
	public IServiceRegistryService getServiceRegistryService() {
		return serviceRegistryService;
	}
	public void setServiceRegistryService(
			IServiceRegistryService serviceRegistryService) {
		this.serviceRegistryService = serviceRegistryService;
	}
	
}
