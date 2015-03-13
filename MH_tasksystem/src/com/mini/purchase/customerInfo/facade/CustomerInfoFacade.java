package com.mini.purchase.customerInfo.facade;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.purchase.customerInfo.service.ICustomerInfoService;

/**
 * 
 * 消费者信息<br> 
 * 〈功能详细描述〉
 *
 * @author 冯鑫
 * @see [相关类/方法]
 * @since vmaque2.0
 */
@Component("customerInfoFacade")
public class CustomerInfoFacade extends FrmFacade {
    /**
     * 消费者信息service层注入
     */
    @Resource(name="customerInfoService")
    private ICustomerInfoService customerInfoService;
}
