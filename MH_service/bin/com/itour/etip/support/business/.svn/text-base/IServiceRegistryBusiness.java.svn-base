package com.itour.etip.support.business;

import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.support.data.ServiceRegistryData;

/**
 * <p>Title: 服务注册表Business</p>
 * <p>Description: 服务注册表Business</p>
 * <p>Copyright: Copyright (C), 2009-2010, eTIP </p>
 * @Author txc
 * @Version 1.0
 * @Date 2009-06-02
 */
public interface IServiceRegistryBusiness extends IBusiness{
	
	/**
	 * 添加单条服务注册记录
	 * @param data 服务注册记录
	 * @return 服务注册记录
	 *
	 * 
	 * 备注：添加记录时的服务编码生成规则？
	 */
	public ServiceRegistryData addServiceRegistry(ServiceRegistryData data);
	/**
	 * 删除单条服务注册记录
	 * @param serviceCode 服务编号
	 *
	 * 
	 * 备注：由于数据库中是树形结构，故删除数据时使用服务编码字段模糊匹配删除
	 */
	public int deleteServiceRegistry(String serviceCode);
	/**
	 * 批量删除服务注册记录
	 * @param ids 服务编号数组
	 *
	 */
	public void deleteServiceRegistrys(String[] serviceCodes);
	
	/**
	 * 修改服务注册记录
	 * @param data 服务注册记录
	 * @return 服务注册记录
	 *
	 */
	public ServiceRegistryData updateServiceRegistry(ServiceRegistryData data);
	
	/**
	 * 查询单条服务注册记录
	 * @param id服务注册记录ID
	 * @return 服务注册记录
	 *
	 */
	public ServiceRegistryData retrieveServiceRegistry(String id);
	
	/**
	 * 查询多条服务注册记录
	 * @param data 服务注册记录
	 * @return 服务注册记录集合
	 *
	 */
	public List searchServiceRegistrys(ServiceRegistryData data);
	
	/**
	 * 给角色查看权限时使用
	 * @return
	 */
	public List getServiceList(String[] ids);
	
	
	

}
