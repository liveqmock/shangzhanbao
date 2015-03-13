package com.mini.purchase.orderManager.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.mini.purchase.orderManager.business.IOrderGoodsinfoBusiness;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;

@Component("orderGoodsinfoService")
public class OrderGoodsinfoService extends FrmService implements IOrderGoodsinfoService {

    @Resource(name = "orderGoodsinfoBusiness")
    private IOrderGoodsinfoBusiness orderGoodsinfoBusiness;
    
    /**
     * 
     * 根据订单id查询订单商品中间表信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月22日
     * @update 
     * @param orderid     订单id
     * @return  ConsumerOrderGoodsinfoData
     * @see   OrderGoodsinfoService#queryConsumerOrderGoodsinfoDataByOrderid(String)
     * @since vmaque 2.4
     */
    public ConsumerOrderGoodsinfoData queryConsumerOrderGoodsinfoDataByOrderid(String orderid) {
        return orderGoodsinfoBusiness.queryConsumerOrderGoodsinfoDataByOrderid(orderid);
    }
    
    /**
     * 
     * 修改订单商品中间表信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月22日
     * @update 
     * @param data  订单中间表信息
     * @see   OrderGoodsinfoService#updateConsumerOrderGoodsinfoData(ConsumerOrderGoodsinfoData)
     * @since vmaque 2.4
     */
    public void updateConsumerOrderGoodsinfoData(ConsumerOrderGoodsinfoData data) {
        orderGoodsinfoBusiness.updateConsumerOrderGoodsinfoData(data);
    }
    
}
