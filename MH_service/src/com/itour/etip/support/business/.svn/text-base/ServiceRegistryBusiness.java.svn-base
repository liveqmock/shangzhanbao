package com.itour.etip.support.business;

import java.util.ArrayList;
import java.util.List;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.support.data.ServiceRegistryData;
import com.itour.etip.support.persistence.IServiceRegistryPersistence;

public class ServiceRegistryBusiness extends FrmBusiness implements IServiceRegistryBusiness{
	
	private IServiceRegistryPersistence serviceRegistryPersistence;

	public ServiceRegistryData addServiceRegistry(ServiceRegistryData data) {
		// TODO Auto-generated method stub
		String parentID = data.getParentID();
		String serviceCode =null;
		List list = null;
		if(parentID.trim().length()<=0 || parentID == null){
			list = serviceRegistryPersistence.search("select max(s.serviceCode) from ServiceRegistryData s where s.parentID is null");
		}else{
			list = serviceRegistryPersistence.search("select max(s.serviceCode) from ServiceRegistryData s where s.parentID='"+parentID+"'");
		}
		
		if(list.get(0) == null){
			if(parentID.trim().length()<=0 || parentID == null){
				serviceCode = parentID.trim()+"01";
			}else{
				ServiceRegistryData parentObj = serviceRegistryPersistence.retrieve(parentID);
				serviceCode = parentObj.getServiceCode()+"01";
			}
		}else{
			serviceCode = (String)list.get(0);
			serviceCode = getCode(serviceCode);
		}
		data.setServiceCode(serviceCode);
		//未完成
		serviceRegistryPersistence.add(data);
		return data;
	}

	public int deleteServiceRegistry(String serviceCode) {
		// TODO Auto-generated method stub
		return serviceRegistryPersistence.executeSQL("delete from SERVICEREGISTRY where serviceCode like '"+serviceCode+"%'");
	}

	public void deleteServiceRegistrys(String[] serviceCodes) {
		// TODO Auto-generated method stub
		for(int i=0;i<serviceCodes.length;i++){
			serviceRegistryPersistence.executeSQL("delete from SERVICEREGISTRY where serviceCode like '"+serviceCodes[i]+"%'");
		}
	}

	public ServiceRegistryData retrieveServiceRegistry(String id) {
		// TODO Auto-generated method stub
		return serviceRegistryPersistence.retrieve(id);
	}

	public List searchServiceRegistrys(ServiceRegistryData data) {
		// TODO Auto-generated method stub
//		String hql = SQLTest.makeSQL("from ServiceRegistryData ", data, null, null);
		return serviceRegistryPersistence.search("from ServiceRegistryData");
	}

	public ServiceRegistryData updateServiceRegistry(ServiceRegistryData data) {
		// TODO Auto-generated method stub
		serviceRegistryPersistence.update(data);
		return data;
	}

	public IServiceRegistryPersistence getServiceRegistryPersistence() {
		return serviceRegistryPersistence;
	}

	public void setServiceRegistryPersistence(
			IServiceRegistryPersistence serviceRegistryPersistence) {
		this.serviceRegistryPersistence = serviceRegistryPersistence;
	}
	
	public List getServiceList(String[] ids){
		List list = new ArrayList();
		for(int i=0;i<ids.length;i++){
			List serviceList = serviceRegistryPersistence.search("from ServiceRegistryData where serviceCode='"+ids[i]+"'");
			list.add(serviceList.get(0));
		}
		return list;
	}
	
	
	public static void main(String[] args){
		String serviceCode = "0101";
		String lastSub = serviceCode.substring(serviceCode.length()-2, serviceCode.length());
		if(Integer.valueOf(lastSub) == 99){
		}
		String firstSub = serviceCode.substring(0, serviceCode.length()-2);
		//System.err.println(firstSub);
		if(Integer.valueOf(lastSub.substring(0,1)) == 0){
			Integer tmpCode = Integer.valueOf(lastSub.substring(1,2))+1;
			if(tmpCode == 10){
				String service = tmpCode.toString();
				//System.out.println(firstSub+service+"--1");
			}else{
				String service = "0"+tmpCode;
				//System.out.println(firstSub+service+"--2");
			}
		}
		else{
			Integer tmpCode = Integer.valueOf(lastSub)+1;
			String service = tmpCode.toString();
			//System.out.println(firstSub+service+"--3");
		}
		
	}
	
	private String getCode(String serviceCode){
		
//		ServiceRegistryData data = new ServiceRegistryData();
//		data.setServiceCode("01");
//		//System.out.println(SQLTest.makeSQL("from ServiceRegistryData ", data, null, null));
		String lastSub = serviceCode.substring(serviceCode.length()-2, serviceCode.length());
		if(Integer.valueOf(lastSub) == 99){
			throw new ETIPException("TreeTooLongException");
		}
		String firstSub = serviceCode.substring(0, serviceCode.length()-2);
		//System.err.println(firstSub);
		if(Integer.valueOf(lastSub.substring(0,1)) == 0){
			Integer tmpCode = Integer.valueOf(lastSub.substring(1,2))+1;
			if(tmpCode == 10){
				String service = tmpCode.toString();
				//System.out.println(firstSub+service+"--1");
				return firstSub+service;
			}else{
				String service = "0"+tmpCode;
				//System.out.println(firstSub+service+"--2");
				return firstSub+service;
			}
		}
		else{
			Integer tmpCode = Integer.valueOf(lastSub)+1;
			String service = tmpCode.toString();
			//System.out.println(firstSub+service+"--3");
			return firstSub+service;
		}
		
	}
	

}
