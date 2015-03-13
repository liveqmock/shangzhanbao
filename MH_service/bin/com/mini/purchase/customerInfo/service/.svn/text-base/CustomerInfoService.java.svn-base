package com.mini.purchase.customerInfo.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.mini.purchase.customerInfo.business.ICustomerInfoBusiness;
import com.mini.purchase.customerInfo.data.ConSumerUserData;
/**
 * 
 * 消费者信息<br> 
 *
 * @author 冯鑫
 * @see CustomerInfoService
 * @since vmaque1.5
 */
@Component("customerInfoService")
public class CustomerInfoService extends FrmService implements ICustomerInfoService {
    /**
     * 消费者信息Bussiness
     */
    @Resource(name = "customerInfoBusiness")
    private ICustomerInfoBusiness customerInfoBusiness;
    /**
     * 
     * 在创建订单之前先创建用户信息<br>
     * 
     * @author 冯鑫<br> 
     *		   2014-9-11
     * @update ［更改人，更改时间，更改内容描述，更改位置 n行－m行］
     * @param ConSumerUserData conSumerUserData
     * @return  ConSumerUserData
     * @exception/throws [异常类型] [异常说明]
     * @see   CustomerInfoService#createConSumerUserWithCreateOrder
     * @since vmaque1.5
     */
    public ConSumerUserData createConSumerUserWithCreateOrder(ConSumerUserData conSumerUserData){
         //id存在就修改，不存就增加
          if(conSumerUserData.getUserMobile()!=null && !"".equals(conSumerUserData.getUserMobile())){
              if(conSumerUserData.getId()!=null && !"".equals(conSumerUserData.getId())){
                  conSumerUserData.setCreateTime(new Date());
                  conSumerUserData.setIsDelete(1);
                  customerInfoBusiness.updateConSumerUserData(conSumerUserData);
              }else{
                  conSumerUserData.setCreateTime(new Date());
                  conSumerUserData.setIsDelete(1);
                  customerInfoBusiness.addCustomerInfo(conSumerUserData);
              }
         }
        return conSumerUserData;
    }
    /**
     * 
     *根据微信ip查询消费者的地址 电话 名字等信息<br>
     * 
     * @author 侯杨 <br> 
     *         2014年11月24日
     * @update 
     * @param data  消费者实体
     * @return  消费者信息集合
     * @see   CustomerInfoService#getConSumerUserDatasByOpenId(ConSumerUserData)
     * @since vmaque1.8
     */
    @Override
    public List<ConSumerUserData> getConSumerUserDatasByOpenId(ConSumerUserData data) {
          return customerInfoBusiness.getConSumerUserDatasByOpenId(data);  
    }
}
