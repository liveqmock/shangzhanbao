package com.mini.BusinessUserData.service;

import com.itour.etip.pub.base.IService;
import com.mini.BusinessUserData.data.BusinessUserData;

/**
 * 〈服务 BusinessUser  Service 接口类〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IBusinessUserService extends IService{
	/**
	 * 添加实名认证信息
	 * @author 侯杨
	 * @date 2014-04-17
	 * @param data
	 * @return
	 */
	public String addBusinessUserData(BusinessUserData data);

}
