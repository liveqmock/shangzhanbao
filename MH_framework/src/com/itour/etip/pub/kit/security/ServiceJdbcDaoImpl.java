package com.itour.etip.pub.kit.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;

public class ServiceJdbcDaoImpl extends JdbcDaoSupport {
	private String serviceQuery = null;

	private MappingSqlQuery serviceMapping = null;
	
	private List serviceList = null;

	// 根据角色查找URL授权

	
	protected void initDao() throws Exception {
		super.initDao();
		this.serviceMapping = new ServiceMapping(getDataSource());
	}

	private class ServiceMapping extends MappingSqlQuery {
		protected ServiceMapping(DataSource ds) {
			super(ds, serviceQuery);
			compile();
		}

		protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
			ServiceRegistry service = new ServiceRegistry();
			service.setServiceAddress(rs.getString("url"));
			service.setServiceCode(rs.getString("resname"));
			
			return service;
		}
	}

	public List getServices() {
		if(serviceList==null||serviceList.size()==0){
			serviceList = serviceMapping.execute();
			return serviceList;
		}
		return serviceList;
	}
	
	/**
	 * 判断当前的服务注册表中是否包含指定的uri
	 * @param uri
	 * @return
	 */
	public boolean isExist(String uri){
		if(uri==null || uri.trim().length()==0) return false; 
		
		List services = getServices();
		if(services==null||services.size()==0) return false;
		String[] strs = uri.split("\\?");
		String firstURI = strs[0];
		for(Object service:services){
		   ServiceRegistry serviceRegistry = (ServiceRegistry)service;
		   if(firstURI.equalsIgnoreCase(serviceRegistry.getServiceAddress())) return true;
		}
		return false;
	}

	public String getServiceQuery() {
		return serviceQuery;
	}

	public void setServiceQuery(String serviceQuery) {
		this.serviceQuery = serviceQuery;
	}
}
