package com.mini.purchase.orderManager.business;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;
import com.mini.purchase.orderManager.persistence.IOrderGoodsinfoPersistence;

@Component("orderGoodsinfoBusiness")
public class OrderGoodsinfoBusiness extends FrmBusiness implements IOrderGoodsinfoBusiness {

    @Resource(name = "orderGoodsinfoPersistence")
    private IOrderGoodsinfoPersistence orderGoodsinfoPersistence;
    
    /**
     * 
     * 根据订单id查询订单商品中间表信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月22日
     * @update 
     * @param orderid     订单id
     * @return  ConsumerOrderGoodsinfoData
     * @see   OrderGoodsinfoBusiness#queryConsumerOrderGoodsinfoDataByOrderid(String)
     * @since vmaque 2.4
     */
    public ConsumerOrderGoodsinfoData queryConsumerOrderGoodsinfoDataByOrderid(String orderid) {
        return orderGoodsinfoPersistence.queryConsumerOrderGoodsinfoDataByOrderid(orderid);
    }
    
    /**
     * 
     * 修改订单商品中间表信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月22日
     * @update 
     * @param data  订单中间表信息
     * @see   OrderGoodsinfoBusiness#updateConsumerOrderGoodsinfoData(ConsumerOrderGoodsinfoData)
     * @since vmaque 2.4
     */
    public void updateConsumerOrderGoodsinfoData(ConsumerOrderGoodsinfoData data){
        orderGoodsinfoPersistence.updateConsumerOrderGoodsinfoData(data);
    }
}
