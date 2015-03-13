package com.itour.etip.contract;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itour.etip.pub.base.IService;

/**
 * 权限服务
 * @author Administrator
 *
 */
@WebService
public interface IAuthorityService extends IService{
	/**
	 * 根据EtipUserId获得该用户能访问的所有服务地址
	 * 
	 * @param account
	 *            String 会员账号
	 * @return UserBaseID String
	 */
	public String getServiceRegistry(@WebParam(name = "etipUserId")
	String etipUserId, @WebParam(name = "serviceName")String serviceName);
}
