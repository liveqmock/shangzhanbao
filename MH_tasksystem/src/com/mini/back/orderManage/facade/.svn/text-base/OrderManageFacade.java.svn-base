package com.mini.back.orderManage.facade;
/***********************************************
 * 
 * 运营后台订单管理的facade层
 * @author dlm
 * @date 2014-4-17
 * 
 ************************************************/
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.order.data.OrderData;
import com.mini.order.data.OrderProductData;
import com.mini.order.service.IOrderservice;

@Component("orderManageFacade")
public class OrderManageFacade extends FrmFacade {
	
	@Resource(name="orderservice")
	private IOrderservice orderservice;

	public List<OrderData> getAllOrder(PageRoll pageRoll, OrderData orderData) {
		
		return orderservice.getAllOrderData(pageRoll, orderData);
	}

	
	/****
	 * 根据订单服务中间表id和状态值来该变订单的状态（未开通改为已开通）
	 * @author dlm
	 */
	public void ajaxUpdateOpState(OrderProductData orderProductData) {
		orderservice.updateOpState(orderProductData);
	}


	
	/****
	 * 根据订单id和状态值来该变订单的状态（线下付款变为已付款）
	 * @author dlm
	 */
	public void ajaxUpdateOrderState(OrderData orderData) {
		orderservice.updateOrderState(orderData);
	}
	/**
     * 
     * 更具订单id和用户id查询订单的详细信息 包括实名认证信息和发票信息<br>
     * 
     * @author 冯鑫 <br> 
     *        2014-4-22
     * @update 
     * @param orderId 订单id 必须不为空
     *        userId  当前登录用户id 必须不为空
     * @return  OrderData
     */
   public OrderData findAllOrderDatebyOrderId(String orderId){
       return orderservice.findAllOrderDatebyOrderId(orderId);
   }


	public OrderData retrieve(String orderId) {
		return orderservice.retrieve(orderId);
	}

}
