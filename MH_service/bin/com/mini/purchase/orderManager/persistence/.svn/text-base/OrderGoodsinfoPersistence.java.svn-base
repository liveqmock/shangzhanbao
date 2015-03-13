package com.mini.purchase.orderManager.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;
/**
 * 
 * 订单商品关联信息Persistence<br> 
 *
 * @author 冯鑫
 * @see OrderGoodsinfoPersistence
 * @since vmaque1.5
 */
@Component("orderGoodsinfoPersistence")
public class OrderGoodsinfoPersistence extends BasePersistence<ConsumerOrderGoodsinfoData> implements IOrderGoodsinfoPersistence{
 
    /**
     * 
     * 根据订单id查询订单商品中间表信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月22日
     * @update 
     * @param orderid     订单id
     * @return  ConsumerOrderGoodsinfoData
     * @see   OrderGoodsinfoPersistence#queryConsumerOrderGoodsinfoDataByOrderid(String)
     * @since vmaque 2.4
     */
    public ConsumerOrderGoodsinfoData queryConsumerOrderGoodsinfoDataByOrderid(String orderid) { 
        
        String hql = "from ConsumerOrderGoodsinfoData where consumerOrderId = ?";
        
        List<Object> parameters = new ArrayList<Object>();
        
        parameters.add(orderid);
        
        List<ConsumerOrderGoodsinfoData> list = this.search(hql, parameters);
        
        if(list == null || list.size() < 1){
            return null;
        } else {
            return list.get(0);
        }

    }
    
    /**
     * 
     * 修改订单商品中间表信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月22日
     * @update 
     * @param data  订单中间表信息
     * @see   OrderGoodsinfoPersistence#updateConsumerOrderGoodsinfoData(ConsumerOrderGoodsinfoData)
     * @since vmaque 2.4
     */
    public void updateConsumerOrderGoodsinfoData(ConsumerOrderGoodsinfoData data){
        this.update(data);
    }
    
}
