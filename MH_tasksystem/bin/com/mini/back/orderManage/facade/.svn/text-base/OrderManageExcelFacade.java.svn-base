package com.mini.back.orderManage.facade;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.itour.etip.pub.frame.FrmFacade;
import com.mini.order.data.OrderData;
import com.mini.order.service.IOrderservice;

/**
 * 订单详情页面导出Faction
 * 
 * @author 侯杨
 * @see OrderManageExcelFacade
 * @since
 */
@Component("orderManageExcelFacade")
public class OrderManageExcelFacade extends FrmFacade {
	@Resource(name="orderservice")
	private IOrderservice orderservice;
	/**
     * 
     * 导出订单详情<br>
     * 
     * @author 侯杨 <br> 
     *        2014-4-25
     * @return  OrderData
     */
   public OrderData findAllOrderDatebyOrderId(String orderId){
       return orderservice.findAllOrderDatebyOrderId(orderId);
   }
}
