/**
 * Auto generator by Leo
 */
package com.itour.etip.support.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;


@Entity()
@Table(name = "ServiceRegistry")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ServiceRegistryData extends FrmData{

	/**
	 * 父编号
	 */
	
	private String parentID;

	/**
	 * 服务代码
	 */
	
	private String serviceCode;

	/**
	 * 服务类型
	 */
	
	private String serviceType;

	/**
	 * 服务地址
	 */
	
	private String serviceAddress;

	/**
	 * 服务名字
	 */
	
	private String serviceName;

	/**
	 * 备注
	 */
	
	private String memo;
	
	

	/**
	 *获得父编号
	 */
	@Column(length = 32,name = "PARENTID",nullable = true)
	public String getParentID(){
		return parentID;
}

	/**
	 *设置父编号
	 */
	public void setParentID(String parentID) {
		this.parentID = parentID;
}


	/**
	 *获得服务代码
	 */
	@Column(length = 128,name = "SERVICECODE",nullable = false)
	public String getServiceCode(){
		return serviceCode;
}

	/**
	 *设置服务代码
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
}


	/**
	 *获得服务类型
	 */
	@Column(length = 32,name = "SERVICETYPE",nullable = false)
	public String getServiceType(){
		return serviceType;
}

	/**
	 *设置服务类型
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
}


	/**
	 *获得服务地址
	 */
	@Column(length = 128,name = "SERVICEADDRESS",nullable = true)
	public String getServiceAddress(){
		return serviceAddress;
}

	/**
	 *设置服务地址
	 */
	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
}


	/**
	 *获得服务名字
	 */
	@Column(length = 32,name = "SERVICENAME",nullable = false)
	public String getServiceName(){
		return serviceName;
}

	/**
	 *设置服务名字
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
}


	/**
	 *获得备注
	 */
	@Column(length = 4000,name = "MEMO",nullable = true)
	public String getMemo(){
		return memo;
}

	/**
	 *设置备注
	 */
	public void setMemo(String memo) {
		this.memo = memo;
}



}
