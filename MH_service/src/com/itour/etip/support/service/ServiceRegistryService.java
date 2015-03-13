package com.itour.etip.support.service;

import java.util.List;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.support.business.IServiceRegistryBusiness;
import com.itour.etip.support.data.ServiceRegistryData;

public class ServiceRegistryService extends FrmService implements IServiceRegistryService{
	
	private IServiceRegistryBusiness serviceRegistryBusiness;

	public ServiceRegistryData addServiceRegistry(ServiceRegistryData data) {
		// TODO Auto-generated method stub
		return serviceRegistryBusiness.addServiceRegistry(data);
	}

	public int deleteServiceRegistry(String serviceCode) {
		// TODO Auto-generated method stub
		return serviceRegistryBusiness.deleteServiceRegistry(serviceCode);
	}

	public void deleteServiceRegistrys(String[] serviceCodes) {
		// TODO Auto-generated method stub
		serviceRegistryBusiness.deleteServiceRegistrys(serviceCodes);
	}

	public ServiceRegistryData retrieveServiceRegistry(String id) {
		// TODO Auto-generated method stub
		return serviceRegistryBusiness.retrieveServiceRegistry(id);
	}

	public List searchServiceRegistrys(ServiceRegistryData data) {
		// TODO Auto-generated method stub
		return serviceRegistryBusiness.searchServiceRegistrys(data);
	}

	public ServiceRegistryData updateServiceRegistry(ServiceRegistryData data) {
		// TODO Auto-generated method stub
		return serviceRegistryBusiness.updateServiceRegistry(data);
	}

	public IServiceRegistryBusiness getServiceRegistryBusiness() {
		return serviceRegistryBusiness;
	}

	public void setServiceRegistryBusiness(
			IServiceRegistryBusiness serviceRegistryBusiness) {
		this.serviceRegistryBusiness = serviceRegistryBusiness;
	}

}
