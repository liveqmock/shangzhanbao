package com.mini.front.order.facade;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.order.data.OrderProductData;
import com.mini.order.service.IOrderProductService;
import com.mini.product.data.ProductData;
import com.mini.product.service.IProductService;
/**
 * 订单管理与产品facade层
 * 
 * @author 林海鹏
 * @see OrderProductFacade
 * @since
 * 
 */
@Component("orderProductFacade")
public class OrderProductFacade extends FrmFacade{

	@Resource(name="orderProductService")
	private IOrderProductService orderProductService;
	
	// 服务Service接口  容器注入
	@Resource(name="productService")
	private IProductService productService;

	public void setOrderProductService(IOrderProductService orderProductService) {
		this.orderProductService = orderProductService;
	}

	
	public void addOrderProduct(OrderProductData orderProductData) {
		orderProductService.addOrderProduct(orderProductData);
	}

	
	public void deleteOrderProduct(String[] ids) {
		orderProductService.deleteOrderProduct(ids);
	}

	
	public void editOrderProduct(OrderProductData orderProductData) {
		orderProductService.editOrderProduct(orderProductData);
	}

	
	public List<OrderProductData> getOrderProduct(JSONObject json) {
		return orderProductService.getOrderProduct(json);
	}

	/**
	 * 
	 *根据ID查询服务<br>
	 * 
	 * @author 文东 <br> 
	 *		   2014-4-2
	 * @update 
	 * @param Id 主键ID
	 * @return  [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see  OrderProductFacade#searchProductById(String)
	 * @since [起始版本]
	 */
    public ProductData searchProductById(String Id) {
        return productService.getProductData(Id);
    }


	/**
	 * 根据主键查询订单服务中间表信息
	 * @param id
	 * @return
	 */
	public OrderProductData retrieve(String id) {
		return orderProductService.retrieve(id);
		
	}

}
