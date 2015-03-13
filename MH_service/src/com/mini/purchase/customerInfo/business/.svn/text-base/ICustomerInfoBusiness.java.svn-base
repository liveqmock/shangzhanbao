package com.mini.purchase.customerInfo.business;

import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.mini.purchase.customerInfo.data.ConSumerUserData;
/**
 * 
 * 消费者信息<br> 
 *
 * @author 冯鑫
 * @see ICustomerInfoBusiness
 * @since vmaque1.5
 */
public interface ICustomerInfoBusiness extends IBusiness {
    /**
     * 
     * 增加消费者信息<br>
     * 
     * @author 冯鑫<br> 
     *         2014-9-11
     * @update ［更改人，更改时间，更改内容描述，更改位置 n行－m行］
     * @param ConSumerUserData conSumerUserData
     * @return  void
     * @exception/throws [异常类型] [异常说明]
     * @see   CustomerInfoBusiness#addCustomerInfo
     * @since vmaque1.5
     */
    public void addCustomerInfo(ConSumerUserData conSumerUserData);
    /**
     * 
     * 查询消费者信息<br>
     * 
     * @author 冯鑫<br> 
     *         2014-9-11
     * @update ［更改人，更改时间，更改内容描述，更改位置 n行－m行］
     * @param ConSumerUserData conSumerUserData
     * @return  ConSumerUserData
     * @exception/throws [异常类型] [异常说明]
     * @see   CustomerInfoBusiness#findCustomerInfo
     * @since vmaque1.5
     */
    public ConSumerUserData findCustomerInfo(ConSumerUserData conSumerUserData);
    /**
     * 
     *根据微信ip查询消费者的地址 电话 名字等信息<br>
     * 
     * @author 侯杨 <br> 
     *		   2014年11月24日
     * @update 
     * @param data  消费者实体
     * @return  消费者信息集合
     * @see   ICustomerInfoBusiness#getConSumerUserDatasByOpenId(ConSumerUserData)
     * @since vmaque1.8
     */
    public List<ConSumerUserData> getConSumerUserDatasByOpenId(ConSumerUserData data);
    /**
     * 
     *根据id修改消费者信息<br>
     * 
     * @author hy <br> 
     *         2014年12月3日
     * @update 
     * @param data  消费者实体
     * @return  void
     * @see  ICustomerInfoBusiness#updateConSumerUserData(ConSumerUserData)
     * @since vmaque2.0
     */
    public void updateConSumerUserData(ConSumerUserData data);
     
}
