package com.mini.front.businessUser.facade;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.BusinessUserData.data.BusinessUserData;
import com.mini.BusinessUserData.service.IBusinessUserService;
/**
 * 〈服务 BusinessUser  Facade 类〉 〈功能详细描述〉
 * 
 * @author [作者]（hy）
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("businessUserFacade")
public class BusinessUserFacade extends FrmFacade{
	@Resource(name="businessUserService")
	private IBusinessUserService businessUserService;
	/**
	 * 添加实名认证信息
	 * @author hy
	 * @date 2014-04-17
	 * @param data
	 * @return
	 */
	public String addBusinessUserData(BusinessUserData data){
		return businessUserService.addBusinessUserData(data);
	}

}
