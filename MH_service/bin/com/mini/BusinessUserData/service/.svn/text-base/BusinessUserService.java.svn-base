package com.mini.BusinessUserData.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.mini.BusinessUserData.business.IBusinessUserBusiness;
import com.mini.BusinessUserData.data.BusinessUserData;

/**
 * 〈服务 BusinessUser  Service 实现类〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("businessUserService")
public class BusinessUserService extends FrmService implements IBusinessUserService{
	@Resource(name="businessUserBusiness")
	private IBusinessUserBusiness businessUserBusiness;   //认证信息Business层注入
	/**
	 * 添加实名认证信息
	 * @author 侯杨
	 * @date 2014-04-17
	 * @param data
	 * @return
	 */
	public String addBusinessUserData(BusinessUserData data){
		return businessUserBusiness.addBusinessUserData(data);
	}

}
