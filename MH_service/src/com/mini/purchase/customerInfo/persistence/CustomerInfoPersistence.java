package com.mini.purchase.customerInfo.persistence;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.purchase.customerInfo.data.ConSumerUserData;
/**
 * 
 * 消费者信息<br> 
 *
 * @author 冯鑫
 * @see CustomerInfoPersistence
 * @since vmaque1.5
 */
@SuppressWarnings("unchecked")
@Component("customerInfoPersistence")
public class CustomerInfoPersistence extends BasePersistence<ConSumerUserData> implements ICustomerInfoPersistence {
}
