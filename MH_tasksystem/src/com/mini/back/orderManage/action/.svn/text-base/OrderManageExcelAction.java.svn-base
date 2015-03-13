package com.mini.back.orderManage.action;
import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import com.itour.etip.pub.frame.FrmAction;
import com.mini.back.orderManage.facade.OrderManageExcelFacade;
import com.mini.order.data.OrderData;

/**
 * @author 侯杨
 * @date 2014-4-25
 */
@Results(value = {
        @Result(name = "orderDateInfo", location = "view/pages/mini/back/orderManage/OrderServiceExcel.jsp")
        })
public class OrderManageExcelAction extends FrmAction {
	@Resource(name="orderManageExcelFacade")
	private OrderManageExcelFacade orderManageExcelFacade;
	  private OrderData orderData = new OrderData();// 接受页面值的实体类

	/**
	 * 订单详情导出
	 * @author 侯杨
	 * 2014年4月25日
	 * @param
	 * @param
	 */
	public String getOrderDetail(){
		  orderData = orderManageExcelFacade.findAllOrderDatebyOrderId(orderData.getId());
	       return "orderDateInfo";
	}

	public OrderData getOrderData() {
		return orderData;
	}

	public void setOrderData(OrderData orderData) {
		this.orderData = orderData;
	}
	
}
