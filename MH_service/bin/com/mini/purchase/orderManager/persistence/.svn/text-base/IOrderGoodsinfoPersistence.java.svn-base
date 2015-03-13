package com.mini.purchase.orderManager.persistence;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;
/**
 * 
 * 订单商品关联信息Persistence<br> 
 *
 * @author 冯鑫
 * @see IOrderGoodsinfoPersistence
 * @since vmaque1.5
 */
public interface IOrderGoodsinfoPersistence extends IBasePersistence<ConsumerOrderGoodsinfoData>{
    
    
    /**
     * 
     * 根据订单id查询订单商品中间表信息<br>
     * 
     * @author 左香勇 <br> 
     *		   2015年1月22日
     * @update 
     * @param orderid     订单id
     * @return  ConsumerOrderGoodsinfoData
     * @see   IOrderGoodsinfoPersistence#queryConsumerOrderGoodsinfoDataByOrderid(String)
     * @since vmaque 2.4
     */
    public ConsumerOrderGoodsinfoData queryConsumerOrderGoodsinfoDataByOrderid(String orderid);
    
    /**
     * 
     * 修改订单商品中间表信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月22日
     * @update 
     * @param data  订单中间表信息
     * @see   IOrderGoodsinfoPersistence#updateConsumerOrderGoodsinfoData(ConsumerOrderGoodsinfoData)
     * @since vmaque 2.4
     */
    public void updateConsumerOrderGoodsinfoData(ConsumerOrderGoodsinfoData data);
}
