package com.mini.back.orderManage.facade;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;
import com.mini.purchase.orderManager.service.IOrderGoodsinfoService;

@Component("orderGoodsinfoFacade")
public class OrderGoodsinfoFacade extends FrmFacade {
 
    @Resource(name="orderGoodsinfoService")
    private IOrderGoodsinfoService orderGoodsinfoService;
   
    /**
     * 
     * 根据订单id查询订单商品中间表信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月22日
     * @update 
     * @param orderid     订单id
     * @return  ConsumerOrderGoodsinfoData
     * @see   OrderGoodsinfoFacade#queryConsumerOrderGoodsinfoDataByOrderid(String)
     * @since vmaque 2.4
     */
    public ConsumerOrderGoodsinfoData queryConsumerOrderGoodsinfoDataByOrderid(String orderid) {
        return orderGoodsinfoService.queryConsumerOrderGoodsinfoDataByOrderid(orderid);
    }
}
