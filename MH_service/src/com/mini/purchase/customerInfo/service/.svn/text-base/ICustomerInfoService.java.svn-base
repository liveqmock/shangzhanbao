package com.mini.purchase.customerInfo.service;

import java.util.List;

import com.itour.etip.pub.base.IService;
import com.mini.purchase.customerInfo.data.ConSumerUserData;
/**
 * 
 * 消费者信息<br> 
 *
 * @author 冯鑫
 * @see ICustomerInfoService
 * @since vmaque1.5
 */
public interface ICustomerInfoService extends IService {
    
    /**
     * 
     * 在创建订单之前先创建用户信息<br>
     * 
     * @author 冯鑫<br> 
     *         2014-9-11
     * @update ［更改人，更改时间，更改内容描述，更改位置 n行－m行］
     * @param ConSumerUserData conSumerUserData
     * @return  ConSumerUserData
     * @exception/throws [异常类型] [异常说明]
     * @see   ICustomerInfoService#createConSumerUserWithCreateOrder
     * @since vmaque1.5
     */
    public ConSumerUserData createConSumerUserWithCreateOrder(ConSumerUserData conSumerUserData);
    /**
     * 
     *根据微信ip查询消费者的地址 电话 名字等信息<br>
     * 
     * @author 侯杨 <br> 
     *         2014年11月24日
     * @update 
     * @param data  消费者实体
     * @return  消费者信息集合
     * @see   ICustomerInfoService#getConSumerUserDatasByOpenId(ConSumerUserData)
     * @since vmaque1.8
     */
    public List<ConSumerUserData> getConSumerUserDatasByOpenId(ConSumerUserData data);
}
